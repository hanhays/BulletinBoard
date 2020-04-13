package com.naver.repository;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.dto.MSGDTO;

@Repository
public class MSGDAOImpl implements MSGDAO{
	
	@Inject
	private SqlSession session;
	
	private String NS = "com.naver.msg";

	@Override
	public void insert(MSGDTO mdto) {
		session.insert(NS+".insert", mdto); 
	}

}
