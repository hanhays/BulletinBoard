package com.naver.repository;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.dto.LoginTo;
import com.naver.dto.MemberDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession session;
	
	private final String NS = "com.naver.user";

	@Override
	public LoginTo login(LoginTo to) {
		return session.selectOne(NS+".login", to);
	}

	@Override
	public void enroll(MemberDTO dto) {
		session.insert(NS+".enroll", dto);
	}

	@Override
	public MemberDTO myinfo(String id) {
		return session.selectOne(NS+".myinfo", id);
	}

	@Override
	public void revise(MemberDTO dto) {
		session.update(NS+".revise", dto);
	}

	@Override
	public void delete(String id) {
		session.delete(NS+".delete", id);
	}

}
