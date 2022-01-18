package com.file.demo;

import java.util.List;

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
	
	@Override
	public List<DTO> readImageFileList(){
		return imageFileDAO.readExampleImageFile();
	}

	@Override
	public int updateImageFileList(DTO image) {
		// TODO Auto-generated method stub
		return imageFileDAO.updateImageFileList(image);
	}

	
	
}
