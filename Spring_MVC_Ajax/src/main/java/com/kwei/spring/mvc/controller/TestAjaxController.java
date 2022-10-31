package com.kwei.spring.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kwei.spring.mvc.pojo.User;

/**
 * 
 * Date: 2022年9月5日上午8:49:36
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	1. @RequestBody: 將請求體中的內容和控制器方法的型參進行綁定 
 *
 * 	2. 使用 @RequestBody 註解將json格式的請求參數轉換為Java對象
 * 		2.1. 導入jackson的jar包(依賴) 
 * 		2.2. 在SpringMVC的配置文件中設置<mvc:annotation-driven />
 * 		2.3. 在處理請求的控制器方法的型參位置, 直接設置json格式的請求參數,
 * 			 要轉換的Java類型的型參, 可為實體類, 或者Map<String,Object>,
 * 			 在使用 @RequestBody 的註解標示即可.
 *	3. @ResponseBody: 將所標示的控制器方法的返回值作為響應報文的響應體且響應到瀏覽器	
 *
 *	4. 使用 @ResponseBody 註解響應瀏覽器json格式的數據
 *		4.1. 導入jackson依賴
 *		4.2. 在SpringMVC的配置文件中設置<mvc:annotation-driven />
 *		4.3. 將需要轉換為json字符串的Java對象直接作為控制器方法的返回值,
 *			 再使用 @RequestBody 註解標示控制器方法, 就可以將Java對象轉換為json字符串,
 *			 並響應到瀏覽器.
 *	
 *	常用的Java對象轉換為Json字符串的結果:
 *		實體類對象 -> Json字符串
 *		Map集合 -> Json字符串
 *		list -> json數組
 *
 */

@Controller
//@RestController //@RestController = @Controller + 其內每個方法上加上@ResponseBody
public class TestAjaxController {

	@PostMapping("/user")
	public void getAjaxRequest(Integer id, @RequestBody String requestBody,
				HttpServletResponse response, Model model) throws IOException {
		System.out.println("id:" + id);// + "username: " + username + ", password: " + password);
		System.out.println("requestBody: " + requestBody);
		response.getWriter().write("AjaxRequest. Got it!");
	}
	
	@PostMapping("/user/requestbody/json")
	public void getAjaxRequestBody(HttpServletResponse response,
					  //@RequestBody Map<String,Object> map,
					  @RequestBody User user) throws IOException {
		
		//System.out.println(map);
		System.out.println(user);
		response.getWriter().write("RequestBody. Hi!");
	}
	
	@ResponseBody // 將返回值作為響應體報文的內容響應到瀏覽器
	@RequestMapping(value="/user/responsebody", method=RequestMethod.GET)
	public String testResponseBody() {
		return "What's up? ResponseBody!";
	}
	
	@ResponseBody
	@PostMapping("/user/responsebody/json")
	public User testResponseBodyWithJson(@RequestBody User user) {
		return user;
	}
	
	@ResponseBody
	@PostMapping("/user/responsebody/maptojson")
	public Map<String,Object> testResponseBodyWithMapToJson(){
		
		Map<String,Object> map = new HashMap<>();
		map.put("pId", "P10001");
		map.put("pName", "Vacuum Cleaner");
		map.put("pBrand", "Dyson");
		map.put("pPrice", 50000.0);
		map.put("pWarranty-Period(Year)", 2);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="user/responsebody/listtojson", method=RequestMethod.POST)
	public List<Map<String,Object>> testResponseWithListToJson() {
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		map1.put("阿彌陀佛","阿彌陀佛");
		list.add(map1);
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("Amitofo","阿彌陀佛");
		list.add(map2);
		
		Map<String,Object> map3 = new HashMap<String,Object>();
		map3.put("法藏比丘","阿彌陀佛");
		list.add(map3);
		
		Map<String,Object> map4 = new HashMap<String,Object>();
		map4.put("佛中之王","阿彌陀佛");
		list.add(map4);
		
		Map<String,Object> map5 = new HashMap<String,Object>();
		map5.put("光中極尊","阿彌陀佛");
		list.add(map5);
		
		return list;
	}
	
	
}
