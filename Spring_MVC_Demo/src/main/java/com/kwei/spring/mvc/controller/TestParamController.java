package com.kwei.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kwei.spring.mvc.pojo.User;

/**
 * 
 * Date: 2022�~8��30��U��4:36:10
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	����ШD�Ѽƪ��覡:
 *		1. �q�LServletAPI���
 *			�u�ݭn�b�����k�����Ѧ�m�]�mHttpServletRequset����������, 
 *			�N�i�H�b�����k���ϥ�request��H������ШD�Ѽ�.	
 *
 *		2. �q�L�����k����������ШD�Ѽ�
 *			�u�ݭn�b�����k�����Ѧ�m, �]�m�@�ի���, �䫬�ѦW�P�ШD�Ѽ�(name)�W�@�P.
 *
 *		3. @RequestParam: �N�ШD�ѼƻP�����k���ΰѸj�w 
 *		   @RequestParam���ݩ�:
 *				3.1. value: �P�����k�����Ѹj�w���ШD�ѼƦW
 *				3.2. required(true/false)�q�{��true: �ШD�ѼƬO�_����null, 
 *					 �Y��null�h����:	HTTP Status 400 �V Bad Request
 *				3.3. defaultValue: �ШD�ѼƦp�G��null��"", �h�ϥ��q�{��,
 *								   �Prequired�ݩʭȵL��.
 *
 *		4. @RequestHeader: �N�ШD�Y�T����key�P�����k���ΰѶi��j�w
 *
 *		5. @CookieValue: �NCookie�ƾڻP�����k�����Ѷi��j�w
 *
 *		6. �q�L�������k����������������������ШD�Ѽ�
 *			�ݭn�b�����k�����Ѧ�m�]�m����������������, �n�O�ҹ����������ݩʦW,
 *			�P�ШD�ѼƦW�O���@�P, �i�H�z�L��������������������ШD�Ѽ�.	
 *
 *		7. �ѨM�ШD�Ѽƪ��ýX���D	
 *			�bweb.xml���t�mSpring���s�X�L�o��(CharacterEncodingFilter)
 *		
 */

@Controller
public class TestParamController {

	@RequestMapping("/param/servletAPI")
	public String getParamByServletAPI(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username + ", password: " + password);
		return "tranquil";
	}
	
	@RequestMapping("/param/springMVC")
	public String getParamBySpringMVC(
			@RequestParam(value = "userName", required = true) String username, 
			String password,
			@RequestHeader("referer") String referer,
			@CookieValue("JSESSIONID") String jsessionId) {
		System.out.println("username: " + username + ", password: " + password);
		System.out.println("Header-Referer: " + referer);
		// �����P����PHttpSession�����ާ@, �~�|�ͦ�JSESSIONID.
		System.out.println("Cookie-JSESSIONID: " + jsessionId);
		return "tranquil";
	}
	
	@RequestMapping("/param/springmvc/pojo")
	public String getParamBySpringMVCWithPOJO(User user) {
		System.out.println(user);
		return "tranquil";
	}
	
}
