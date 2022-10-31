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
 * Date: 2022�~9��1��W��11:31:24
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	�귽: user
 *	�d�ߩҦ����Τ�T��: /user (get)
 *	�d�ߥΤ�T���ھ�id: /user/1001 (get)
 *	�s�W�Τ�T��: /user (post)
 *	���Τ�T��: /user (put)
 *	�R���Τ�T���ھ�id: /user/1001 (delete)
 *
 *	�`�N: �s�����ثe�u��o�eget��post�ШD
 *	�Y�n�o�eput��delete���ШD, �ݦbweb.xml��󤤰t�m�@�ӹL�o��HiddenHttpMethodFilter.
 *	�t�m�F�L�o������, �ݨϥ�form���榡, ���method������post, 
 *	�B���ahidden�����ШD�Ѽ�, name="_method", value="put"(��ڽШD�覡)
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
		System.out.println("�d�ߩҦ����Τ�T��");
		return "success";
	}
	
	//@RequestMapping(value="/user/{id}")
	@GetMapping("/user/{id}")
	public String getUserById(@PathVariable Integer id, Model model) {
		System.out.println("�d�ߥΤ�T���ھ�id: /user/" + id + " (get)");
		return "success";
	}
	
	//@RequestMapping(value="/user", method=RequestMethod.POST)
	@PostMapping("/user")
	public String insertUser() {
		System.out.println("�s�W�Τ�T��: /user (post)");
		return "success";
	}
	
	//@RequestMapping(value="/user", method=RequestMethod.PUT)
	@PutMapping("/user")
	public String updateUser() {
		System.out.println("���Τ�T��: /user (put)");
		return "success";
	}
	
	//@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable("id") Integer id) {
		System.out.println("�R���Τ�T���ھ�id: /user/" + id + " (delete)");
		return "success";
	}
	
	
}
