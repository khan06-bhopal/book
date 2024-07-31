package com.book.helper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR="C:\\Users\\hp\\Downloads\\book\\book\\src\\main\\resources\\static\\image"; 
	
	public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath(); 
	public FileUploadHelper() throws IOException { 
		
	}
	public boolean uploadFile(MultipartFile file) { 
		
		boolean bool = false;
		
		try {
			
			//old way
//			InputStream is = file.getInputStream();
//			byte data[]  =new byte[is.available()];
//			is.read(data);
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			
//			fos.write(data);
//			fos.flush();
//			fos.close();
//			bool = true;
			
			//new way
			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()) ,StandardCopyOption.REPLACE_EXISTING);
			bool= true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return bool;
	}
}
// /book/src/main/resources/static/image
//C:\Users\hp\Downloads\book\book\src\main\resources\static\image