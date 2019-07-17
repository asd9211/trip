package com.org.trip.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class InsertPic {

	public String fileUpload(MultipartFile file,String filePath) {
		String fileName = file.getOriginalFilename();
		String extName = FilenameUtils.getExtension(fileName);
		String reName= Long.toString(System.nanoTime());
		reName += "." + extName;
		File targetFile = new File(filePath+reName);
		try {
			Files.copy(file.getInputStream(), targetFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reName;
	}
}
