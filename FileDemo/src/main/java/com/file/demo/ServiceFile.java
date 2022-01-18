package com.file.demo;

import java.util.List;

public interface ServiceFile {
		
		public int createExampleImageFile(DTO image);
		public List<DTO> readImageFileList();
		public int updateImageFileList(DTO image);
		public List<DTO> getImg(int id);
		public int deleteImageFileList(int id);
		
}
