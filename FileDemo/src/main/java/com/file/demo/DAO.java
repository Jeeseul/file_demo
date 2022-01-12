package com.file.demo;

import com.file.demo.DTO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

	@Autowired
	private static SqlSessionTemplate sqlSession;
	
	public static int createExampleImageFile(DTO image) {
		sqlSession.insert("createExampleImageFile", image);
	}
	
}
