package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.helper.FileUploadHelper;

import jakarta.servlet.Servlet;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadhelper;
	
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){ 
		
		try {
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			
			if(file.isEmpty()) { 
//				return ResponseEntity.ok("Request Must contain file");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

			}
			//file upload code
		boolean bool = 	fileUploadhelper.uploadFile(file);
			
		if(bool) { 
//			return ResponseEntity.ok("File Is succefuly Upload");
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
		}
}
///book/src/main/resources/static/image