package com.file.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceFile{
	
	@Autowired
	DAO imageFileDAO;

	@Override
	public int createExampleImageFile(DTO image) {
		System.out.println("ServiceImpl: "+image.toString());
		return imageFileDAO.createExampleImageFile(image);
	}
	
	
}
