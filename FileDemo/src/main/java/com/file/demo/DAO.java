package com.file.demo;

import org.mybatis.spring.SqlSessionTemplate;
//총동연에서는 밑에꺼 썼는데, 현재아래꺼 쓰며ㅕㄴ 에러남,,,위에꺼로 자동에러해결은 되는 상태인데 계정을 몰라서 뜨는 에러때문에 확인을 못함 
//import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
		
	public int createExampleImageFile(DTO image) {
		//System.out.println(image.toString());
		//sqlSession.insert("fileDemo.createExampleImageFile", image);
		//System.out.println("finished inserting");

		return 0;
	}
	
}
