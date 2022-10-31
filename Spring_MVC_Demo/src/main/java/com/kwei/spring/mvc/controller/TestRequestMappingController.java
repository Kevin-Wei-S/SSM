package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Date: 2022�~8��30��W��11:27:55
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 * 		1. @RequestMapping���ѼХܪ���m:
 * 			 @RequestMapping�Хܦb�@����:
 * 				�]�m�M�g�ШD���ШD���|����l�T��
 * 			 @RequestMapping�Хܦb�@�Ӥ�k:
 *				�]�m�M�g�ШD���ШD���|������T��
 *		
 *		2. @RequestMapping���ѼХܪ�value�ݩ�:
 *				�@��: �q�L�ШD���ШD���|�Ӥǰt�ШD
 *				value�ݩʬO�Ʋ�����, �Y��e�s�����ҵo�e�ШD���ШD���|�ǰt
 *				value�ݩʪ���������@�ӭ�, �h��e�ШD�N�|�Q���ѩҼХܪ���k�ҳB�z.
 *
 *		3. @RequestMapping���ѼХܪ�method�ݩ�:
 *				�@��: �q�L�ШD���ШD���覡�Ӥǰt�ШD
 *				method�ݩʬ�RequestMethod�Ʋ�����, �Y��e�s�����ҵo�X���ШD���ШD�覡,
 *				�Y�ǰtmethod�ݩʤ�������@�ӭ�, �h��e�ШD�|�Q�Хܦ����Ѫ���k�B�z. 
 *			
 *			�`�N: �Y�s�����ҵo�e���ШD�覡���ǰt���A���ұ������ШD�覡�h�|����
 *				EX: 405 - Request method 'GET' not supported
 *			�b @RequestMapping���Ѫ���¦�W, ���X�ШD�覡���Ǭ��͵���
 *				@GetMapping, @PostMapping, @DeleteMapping, @PutMapping
 *		
 *		4. @RequestMapping���ѼХܪ�params�ݩ�:
 *				�@��: �q�L�ШD���ШD�ѼƨӤǰt�ШD 
 *				params�ݩʬ�String�Ʋ�����, �Y��e�s�����o�e���ШD�ѼƻP���A��
 *				�ҭn�D���ШD�Ѽƥ����v�@�ǰt, �h��e�ШD�N�Q�Хܦ����Ѫ���k�ҳB�z.
 *			params�i�H�ϥ�4�ت�F��:
 *				v. "param": ��ܷ�e�ШD���ШD�ѼƤ�, �������aparam�Ѽ�(key), �L��value.
 *				x. "!param": ��ܷ�e�ШD���ШD�ѼƤ�, ���வ�aparam�Ѽ�(key).
 *				y. "param=value": ��ܷ�e�ШD���ШD�ѼƤ�, �������aparam�Ѽ�(key), �]�tvalue.
 *				z. "param!=value": ��ܷ�e�ШD���ШD�ѼƤ�, ���aparam�Ѽ�(key), ���]�tvalue,
 *								   �Τ����aparam�Ѽ�(key).
 *			�`�N: �p�s�����ҵo�X�ШD���ШD�ѼƤ��ǰt��, �h���A���|����.
 *				EX: HTTP Status 400 �V Bad Request
 *
 *		5. @RequestMapping���ѼХܪ�headers�ݩ�:
 *				�@��: �q�L�ШD���ШD�Y�T���Ӥǰt�ШD, �Y��e�s�����o�e���ШD�Y�T���P���A��
 *				�ҭn�D���ШD�Y�T�������v�����ǰt, �h��e�ШD�N�Q�Хܦ����Ѫ���k�ҳB�z.
 *			headers�i�H�ϥ�4�ت�F��(�p�Wparams)
 *			�`�N: �p�s�����ҵo�X�ШD���ШD�Y�T�����ǰt��, �h���A���|����.
 *				EX: HTTP Status 404 �V Not Found
 *		
 *		6. SpringMVC���ant���檺���|
 *			�b @RequestMapping���Ѫ�value�ݩʭȤ��]�m�@�ǯS��r��
 *				?: ���N����Ӧr��(���F?����, �]���s�����|�N?���e�����ШD���|, 
 *								?���ᬰ�ШD�Ѽ�)	
 *				*: ���N�Ӽƪ����N�r��(���F'?'��'/')
 *				**: ���N�h�ƪ����N�ؿ�, �`�N�ϥΤ覡�u���**�g�b//��(/ ** /).
 *
 *		7. @RequestMapping���Ѩϥθ��|���������
 *			�ǲμg�k: /deleteUser?id=1001
 *			rest: /user/delete/1001
 *			7.1. �ݭn�b @RequestMapping���Ѫ�value�ݩʩҳ]�m�����|��, 
 *				 �ϥ�{xxx}��ܸ��|�����ƾ�.
 *			7.2. �A�q�L @PathVariable������, �N����ũҼХܪ��ȩM�������k����,
 *				 �i��j�w.
 *
 */			
@Controller
//@RequestMapping("/peace/love")
public class TestRequestMappingController {
	
	// ���ɱ����k�Ҥǰt���ШD���|��: 
	// http://localhost:8080/Spring_MVC_Demo/peace/love/silent
	@RequestMapping(
			value = {"/silent", "tranquil"}, 
			method = {RequestMethod.POST, RequestMethod.GET}
			//params = {"Buddha", "Buddha=Amitofo"},
			//headers = {"referer"}
			)
	public String tranquil() {
		return "tranquil";
	}
	
	@RequestMapping("/a*c/test/**")
	public String testAnt() {
		return "tranquil";
	}
	
	@RequestMapping("/test/rest/{id}/{username}/{password}")
	public String testRest(@PathVariable("id") Integer id,
						   @PathVariable("username") String username,
						   @PathVariable("password") String password) {
		System.out.println("id: " + id + ", username: " + 
						   username + ", password: " + password);
		return "tranquil";
	}
	
	
}
