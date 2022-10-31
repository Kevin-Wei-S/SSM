package com.kwei.spring.mvc.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * Date: 2022�~8��31��U��12:23:02
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	�V���H�@�ɼƾ�:
 *		1. �q�LModelAndView�V�ШD��@�ɼƾ�	
 *			�ϥ�ModelAndView��, �i�H�ϥΨ�Model�\��V�ШD��@�ɼƾ�,
 *			�]�i�H�ϥ�View�\��, �]�m�޿����, 
 *			���O�����k�@�w�n�NModelAndView�@����k����^��.
 *
 *		2. �ϥ�Model�V�ШD��@�ɼƾ�
 *			
 *		3. �ϥ�ModelMap�V�ШD��@�ɼƾ�
 *
 *		4. �ϥ�map�V�ШD��@�ɼƾ�
 *		
 *		5. Model�BModelMap�BMap�����Y:
 *			���h��, �o�����������ѳ��O�q�LBindingAwareModelMap�ӹ�Ҥ�.
 *		public class BindingAwareModelMap extends ExtendedModelMap {...}
 *		public class ExtendedModelMap extends ModelMap implements Model {...}
 *		public class ModelMap extends LinkedHashMap<String, Object> {...}
 *		public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {...}
 */
@Controller
public class TestScopeController {

	@RequestMapping("/scope/mav")
	public ModelAndView testMAV() {
		/*
		 * ModelAndView�]�tModel�MView���\��
		 * 	Model: �V�ШD�줤�@�ɼƾ�	 
		 * 	View: �]�m�޿���Ϲ�{�������� 
		 */
		ModelAndView mav = new ModelAndView();
		// �V�ШD���H���@�ɼƾ�
		mav.addObject("testRequestScope", "Amitofo");
		// �]�m�޿����
		mav.setViewName("tranquil");
		return mav;
	}
	
	@RequestMapping("/scope/model")
	public String testModel(Model model) {
		// org.springframework.validation.support.BindingAwareModelMap
		System.out.println(model.getClass().getName());
		model.addAttribute("model", "��������");
		return "tranquil";
	}
	
	@RequestMapping("/scope/modelmap")
	public String testModelMap(ModelMap modelMap) {
		// org.springframework.validation.support.BindingAwareModelMap
		System.out.println(modelMap.getClass().getName());
		modelMap.addAttribute("modelMap", "�k�ä�C");
		return "tranquil";
	}
	
	@RequestMapping("/scope/map")
	public String testMap(Map<String,Object> map) {
		// org.springframework.validation.support.BindingAwareModelMap
		System.out.println(map.getClass().getName());
		map.put("map", "�򤤤���");
		return "tranquil";
	}
	
	@RequestMapping("/scope/session")
	public String testSession(HttpSession session) {
		session.setAttribute("session", "�������L");
		return "tranquil";
	}
	
	@RequestMapping("/scope/application")
	public String testApplication(HttpServletRequest request) {
		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("application", "��������");
		return "tranquil";
	}
	
}
