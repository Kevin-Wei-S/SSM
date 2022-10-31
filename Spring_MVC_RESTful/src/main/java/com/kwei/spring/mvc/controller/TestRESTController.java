package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
/**
 * 
 * Date: 2022年9月1日上午11:31:24
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	資源: user
 *	查詢所有的用戶訊息: /user (get)
 *	查詢用戶訊息根據id: /user/1001 (get)
 *	新增用戶訊息: /user (post)
 *	更改用戶訊息: /user (put)
 *	刪除用戶訊息根據id: /user/1001 (delete)
 *
 *	注意: 瀏覽器目前只能發送get及post請求
 *	若要發送put或delete的請求, 需在web.xml文件中配置一個過濾器HiddenHttpMethodFilter.
 *	配置了過濾器之後, 需使用form表單格式, 表單method必須為post, 
 *	且挾帶hidden類型請求參數, name="_method", value="put"(實際請求方式)
 *	EX:
 *		<form th:action="@{/...}" method="post">
 *			<input type="hidden" name="_method" value="put">
 *			<input type="submit" value="submit">
 *		</form>
 *
 */
@Controller
public class TestRESTController {

	//@RequestMapping(value="/user", method=RequestMethod.GET)
	@GetMapping("/user")
	public String getAllUsers() {
		System.out.println("查詢所有的用戶訊息");
		return "success";
	}
	
	//@RequestMapping(value="/user/{id}")
	@GetMapping("/user/{id}")
	public String getUserById(@PathVariable Integer id, Model model) {
		System.out.println("查詢用戶訊息根據id: /user/" + id + " (get)");
		return "success";
	}
	
	//@RequestMapping(value="/user", method=RequestMethod.POST)
	@PostMapping("/user")
	public String insertUser() {
		System.out.println("新增用戶訊息: /user (post)");
		return "success";
	}
	
	//@RequestMapping(value="/user", method=RequestMethod.PUT)
	@PutMapping("/user")
	public String updateUser() {
		System.out.println("更改用戶訊息: /user (put)");
		return "success";
	}
	
	//@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable("id") Integer id) {
		System.out.println("刪除用戶訊息根據id: /user/" + id + " (delete)");
		return "success";
	}
	
	
}
