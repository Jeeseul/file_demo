package com.file.demo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class DTO {
	private int id;
	private String originalImageUrl;
	private int imageOrder;
	private String fileOriginalUrl;
	private int fileOrder;
	private MultipartFile file; 
	private Date regdate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginalImageUrl() {
		return originalImageUrl;
	}
	public void setOriginalImageUrl(String originalImageUrl) {
		this.originalImageUrl = originalImageUrl;
	}
	public int getImageOrder() {
		return imageOrder;
	}
	public void setImageOrder(int imageOrder) {
		this.imageOrder = imageOrder;
	}
	public String getFileOriginalUrl() {
		return fileOriginalUrl;
	}
	public void setFileOriginalUrl(String fileOriginalUrl) {
		this.fileOriginalUrl = fileOriginalUrl;
	}
	public int getFileOrder() {
		return fileOrder;
	}
	public void setFileOrder(int fileOrder) {
		this.fileOrder = fileOrder;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
