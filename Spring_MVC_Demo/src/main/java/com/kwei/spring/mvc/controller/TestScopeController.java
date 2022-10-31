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
 * Date: 2022年8月31日下午12:23:02
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	向域對象共享數據:
 *		1. 通過ModelAndView向請求域共享數據	
 *			使用ModelAndView時, 可以使用其Model功能向請求域共享數據,
 *			也可以使用View功能, 設置邏輯視圖, 
 *			但是控制器方法一定要將ModelAndView作為方法的返回值.
 *
 *		2. 使用Model向請求域共享數據
 *			
 *		3. 使用ModelMap向請求域共享數據
 *
 *		4. 使用map向請求域共享數據
 *		
 *		5. Model、ModelMap、Map的關係:
 *			底層中, 這些類型的型參都是通過BindingAwareModelMap來實例化.
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
		 * ModelAndView包含Model和View的功能
		 * 	Model: 向請求域中共享數據	 
		 * 	View: 設置邏輯視圖實現頁面跳轉 
		 */
		ModelAndView mav = new ModelAndView();
		// 向請求域對象中共享數據
		mav.addObject("testRequestScope", "Amitofo");
		// 設置邏輯視圖
		mav.setViewName("tranquil");
		return mav;
	}
	
	@RequestMapping("/scope/model")
	public String testModel(Model model) {
		// org.springframework.validation.support.BindingAwareModelMap
		System.out.println(model.getClass().getName());
		model.addAttribute("model", "阿彌陀佛");
		return "tranquil";
	}
	
	@RequestMapping("/scope/modelmap")
	public String testModelMap(ModelMap modelMap) {
		// org.springframework.validation.support.BindingAwareModelMap
		System.out.println(modelMap.getClass().getName());
		modelMap.addAttribute("modelMap", "法藏比丘");
		return "tranquil";
	}
	
	@RequestMapping("/scope/map")
	public String testMap(Map<String,Object> map) {
		// org.springframework.validation.support.BindingAwareModelMap
		System.out.println(map.getClass().getName());
		map.put("map", "佛中之王");
		return "tranquil";
	}
	
	@RequestMapping("/scope/session")
	public String testSession(HttpSession session) {
		session.setAttribute("session", "光中極尊");
		return "tranquil";
	}
	
	@RequestMapping("/scope/application")
	public String testApplication(HttpServletRequest request) {
		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("application", "阿彌陀佛");
		return "tranquil";
	}
	
}
