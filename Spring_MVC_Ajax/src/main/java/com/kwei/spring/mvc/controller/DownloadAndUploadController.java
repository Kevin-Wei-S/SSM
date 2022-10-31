package com.kwei.spring.mvc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * Date: 2022年9月5日下午4:58:58
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	ResponseEntity: 可以作為控制器方法的返回值, 表示響應到瀏覽器的完整的響應報文.
 *
 *	文件上傳的要求:
 *		1. 請求方式必須為post, get沒有請求體, post有.
 *		2. form表單必須將enctype屬性值設置為: multipart;form-data;
 *
 */
@Controller
public class DownloadAndUploadController {


	
	@GetMapping("/img/download")
	public ResponseEntity<byte[]> testDownload(HttpSession session){
		
		ServletContext context = session.getServletContext();
		String realPath = context.getRealPath("static");
		realPath = realPath + File.separator + "img" + File.separator + "無量壽經.jpg";
		System.out.println(realPath);
		ResponseEntity<byte[]> entity = null;
		
		try(InputStream is = new FileInputStream(realPath)) {
			// is.available(): 獲取輸入流對應文件的字節數
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			MultiValueMap<String,String> headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=Amitofo.jpg");
			HttpStatus statusCode = HttpStatus.OK;
			entity = new ResponseEntity<>(bytes, headers, statusCode);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return entity;
	}
	
	@PostMapping("/img/upload") // MultipartFile: SpringMVC已將上傳的檔案封裝, 根據請求參數名可獲得.
	public String testUpload(MultipartFile photo, HttpSession session) throws IOException {
		
		// 獲取上傳文件的文件名
		String filename = photo.getOriginalFilename();
		// 獲取上傳文件的後綴名
		// String fileExtension = file.getName().split("\\.")[1];
		String fileExtension = filename.substring(filename.lastIndexOf("."));
		// 獲取UUID
		String uuid = UUID.randomUUID().toString();
		filename = uuid + fileExtension;
		// 獲取ServletContext的對象
		ServletContext context = session.getServletContext();
		String staticPath = context.getRealPath("static");
		String photoPath = staticPath + File.separator + "photo";
		// 創建photoPath所對應的File對象
		File file = new File(photoPath);
		if(!file.exists()) {
			file.mkdir();
		}
		photoPath = photoPath + File.separator + filename;
		file = new File(photoPath);
		
		// 獲取上傳文件前綴名
		//int n = 1;
		//String fileFirstName = file.getName().split("\\.")[0];
		//String fileFirstName = filename.substring(0, filename.lastIndexOf("."));
//		while(file.exists()) {
//			file = new File(tempPath + File.separator + fileFirstName + "(" + (n++) +")." + fileExtension);
//		}
		
		try {
			photo.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	
}
