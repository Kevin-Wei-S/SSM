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
 * Date: 2022�~9��5��U��4:58:58
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	ResponseEntity: �i�H�@�������k����^��, ����T�����s���������㪺�T������.
 *
 *	���W�Ǫ��n�D:
 *		1. �ШD�覡������post, get�S���ШD��, post��.
 *		2. form��楲���Nenctype�ݩʭȳ]�m��: multipart;form-data;
 *
 */
@Controller
public class DownloadAndUploadController {


	
	@GetMapping("/img/download")
	public ResponseEntity<byte[]> testDownload(HttpSession session){
		
		ServletContext context = session.getServletContext();
		String realPath = context.getRealPath("static");
		realPath = realPath + File.separator + "img" + File.separator + "�L�q�ظg.jpg";
		System.out.println(realPath);
		ResponseEntity<byte[]> entity = null;
		
		try(InputStream is = new FileInputStream(realPath)) {
			// is.available(): �����J�y������󪺦r�`��
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
	
	@PostMapping("/img/upload") // MultipartFile: SpringMVC�w�N�W�Ǫ��ɮ׫ʸ�, �ھڽШD�ѼƦW�i��o.
	public String testUpload(MultipartFile photo, HttpSession session) throws IOException {
		
		// ����W�Ǥ�󪺤��W
		String filename = photo.getOriginalFilename();
		// ����W�Ǥ�󪺫��W
		// String fileExtension = file.getName().split("\\.")[1];
		String fileExtension = filename.substring(filename.lastIndexOf("."));
		// ���UUID
		String uuid = UUID.randomUUID().toString();
		filename = uuid + fileExtension;
		// ���ServletContext����H
		ServletContext context = session.getServletContext();
		String staticPath = context.getRealPath("static");
		String photoPath = staticPath + File.separator + "photo";
		// �Ы�photoPath�ҹ�����File��H
		File file = new File(photoPath);
		if(!file.exists()) {
			file.mkdir();
		}
		photoPath = photoPath + File.separator + filename;
		file = new File(photoPath);
		
		// ����W�Ǥ��e��W
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
