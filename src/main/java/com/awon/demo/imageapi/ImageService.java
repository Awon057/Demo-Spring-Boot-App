package com.awon.demo.imageapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	private static String UPLOAD_ROOT = "F://Java//Workspace//Tutorial//upload-dir";

	private final ResourceLoader resourceLoader;

	@Autowired
	public ImageService(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public Resource findOneImage(String name) {
		return resourceLoader.getResource("file:" + UPLOAD_ROOT + "/" + name);
	}

	public void saveImage(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_ROOT, file.getOriginalFilename()));
//			imageRepository.save(new Image(file.getOriginalFilename()));
		}
	}

	public void deleteImage(String name) throws IOException {
//		imageRepository.delete(byName);
		Files.deleteIfExists(Paths.get(UPLOAD_ROOT, name));
	}
}
