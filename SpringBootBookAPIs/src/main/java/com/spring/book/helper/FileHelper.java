package com.spring.book.helper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {

	//private final String Upload_Dir= "/Users/firozkumar/DevQA/SpringBootBookAPIs/src/main/resources/static/images";

	//In this folder my file will be uploaded ( this can be a server URL)
    private final String Upload_Dir= new ClassPathResource("static/images/").getFile().getAbsolutePath();

   public FileHelper() throws IOException
   {
	   
   }
  // The file separator is the character used to separate the directory names that make up the path to a specific location.
	public boolean uploadFile(MultipartFile multipartFile) throws IOException
	{
		boolean up=false;
		Files.copy(multipartFile.getInputStream(), Paths.get(Upload_Dir + File.separator + multipartFile.getOriginalFilename() ), StandardCopyOption.REPLACE_EXISTING);
		up =true;
		return up;
	}	
}
