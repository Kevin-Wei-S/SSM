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
 * Date: 2022�~9��5��W��8:49:36
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	1. @RequestBody: �N�ШD�餤�����e�M�����k�����Ѷi��j�w 
 *
 * 	2. �ϥ� @RequestBody ���ѱNjson�榡���ШD�Ѽ��ഫ��Java��H
 * 		2.1. �ɤJjackson��jar�](�̿�) 
 * 		2.2. �bSpringMVC���t�m��󤤳]�m<mvc:annotation-driven />
 * 		2.3. �b�B�z�ШD�������k�����Ѧ�m, �����]�mjson�榡���ШD�Ѽ�,
 * 			 �n�ഫ��Java����������, �i��������, �Ϊ�Map<String,Object>,
 * 			 �b�ϥ� @RequestBody �����ѼХܧY�i.
 *	3. @ResponseBody: �N�ҼХܪ������k����^�ȧ@���T�����媺�T����B�T�����s����	
 *
 *	4. �ϥ� @ResponseBody �����T���s����json�榡���ƾ�
 *		4.1. �ɤJjackson�̿�
 *		4.2. �bSpringMVC���t�m��󤤳]�m<mvc:annotation-driven />
 *		4.3. �N�ݭn�ഫ��json�r�ŦꪺJava��H�����@�������k����^��,
 *			 �A�ϥ� @RequestBody ���ѼХܱ����k, �N�i�H�NJava��H�ഫ��json�r�Ŧ�,
 *			 ���T�����s����.
 *	
 *	�`�Ϊ�Java��H�ഫ��Json�r�Ŧꪺ���G:
 *		��������H -> Json�r�Ŧ�
 *		Map���X -> Json�r�Ŧ�
 *		list -> json�Ʋ�
 *
 */

@Controller
//@RestController //@RestController = @Controller + �䤺�C�Ӥ�k�W�[�W@ResponseBody
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
	
	@ResponseBody // �N��^�ȧ@���T������媺���e�T�����s����
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
		map1.put("��������","��������");
		list.add(map1);
		
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("Amitofo","��������");
		list.add(map2);
		
		Map<String,Object> map3 = new HashMap<String,Object>();
		map3.put("�k�ä�C","��������");
		list.add(map3);
		
		Map<String,Object> map4 = new HashMap<String,Object>();
		map4.put("�򤤤���","��������");
		list.add(map4);
		
		Map<String,Object> map5 = new HashMap<String,Object>();
		map5.put("�������L","��������");
		list.add(map5);
		
		return list;
	}
	
	
}
