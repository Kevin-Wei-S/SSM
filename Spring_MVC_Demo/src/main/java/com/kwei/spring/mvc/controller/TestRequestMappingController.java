package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Date: 2022年8月30日上午11:27:55
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 * 		1. @RequestMapping註解標示的位置:
 * 			 @RequestMapping標示在一個類:
 * 				設置映射請求的請求路徑的初始訊息
 * 			 @RequestMapping標示在一個方法:
 *				設置映射請求的請求路徑的具體訊息
 *		
 *		2. @RequestMapping註解標示的value屬性:
 *				作用: 通過請求的請求路徑來匹配請求
 *				value屬性是數組類型, 即當前瀏覽器所發送請求的請求路徑匹配
 *				value屬性的中的任何一個值, 則當前請求就會被註解所標示的方法所處理.
 *
 *		3. @RequestMapping註解標示的method屬性:
 *				作用: 通過請求的請求的方式來匹配請求
 *				method屬性為RequestMethod數組類型, 即當前瀏覽器所發出的請求的請求方式,
 *				若匹配method屬性中的任何一個值, 則當前請求會被標示此註解的方法處理. 
 *			
 *			注意: 若瀏覽器所發送的請求方式不匹配伺服器所接受的請求方式則會報錯
 *				EX: 405 - Request method 'GET' not supported
 *			在 @RequestMapping註解的基礎上, 結合請求方式的些派生註解
 *				@GetMapping, @PostMapping, @DeleteMapping, @PutMapping
 *		
 *		4. @RequestMapping註解標示的params屬性:
 *				作用: 通過請求的請求參數來匹配請求 
 *				params屬性為String數組類型, 即當前瀏覽器發送的請求參數與伺服器
 *				所要求的請求參數必須逐一匹配, 則當前請求將被標示此註解的方法所處理.
 *			params可以使用4種表達式:
 *				v. "param": 表示當前請求的請求參數中, 必須挾帶param參數(key), 無論value.
 *				x. "!param": 表示當前請求的請求參數中, 不能挾帶param參數(key).
 *				y. "param=value": 表示當前請求的請求參數中, 必須挾帶param參數(key), 包含value.
 *				z. "param!=value": 表示當前請求的請求參數中, 挾帶param參數(key), 不包含value,
 *								   或不挾帶param參數(key).
 *			注意: 如瀏覽器所發出請求的請求參數不匹配時, 則伺服器會報錯.
 *				EX: HTTP Status 400 – Bad Request
 *
 *		5. @RequestMapping註解標示的headers屬性:
 *				作用: 通過請求的請求頭訊息來匹配請求, 即當前瀏覽器發送的請求頭訊息與伺服器
 *				所要求的請求頭訊息必須逐完全匹配, 則當前請求將被標示此註解的方法所處理.
 *			headers可以使用4種表達式(如上params)
 *			注意: 如瀏覽器所發出請求的請求頭訊息不匹配時, 則伺服器會報錯.
 *				EX: HTTP Status 404 – Not Found
 *		
 *		6. SpringMVC支持ant風格的路徑
 *			在 @RequestMapping註解的value屬性值中設置一些特殊字符
 *				?: 任意的單個字符(除了?本身, 因為瀏覽器會將?之前視為請求路徑, 
 *								?之後為請求參數)	
 *				*: 任意個數的任意字符(除了'?'及'/')
 *				**: 任意層數的任意目錄, 注意使用方式只能把**寫在//中(/ ** /).
 *
 *		7. @RequestMapping註解使用路徑中的佔位符
 *			傳統寫法: /deleteUser?id=1001
 *			rest: /user/delete/1001
 *			7.1. 需要在 @RequestMapping註解的value屬性所設置的路徑中, 
 *				 使用{xxx}表示路徑中的數據.
 *			7.2. 再通過 @PathVariable的註解, 將佔位符所標示的值和控制器的方法型參,
 *				 進行綁定.
 *
 */			
@Controller
//@RequestMapping("/peace/love")
public class TestRequestMappingController {
	
	// 此時控制器方法所匹配的請求路徑為: 
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
