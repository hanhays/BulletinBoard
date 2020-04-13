package com.naver.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.dto.LoginTo;
import com.naver.dto.MemberDTO;
import com.naver.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO udao;

	@Override
	public LoginTo login(LoginTo to) {
		return udao.login(to);
	}

	@Override
	public void enroll(MemberDTO dto) {
		udao.enroll(dto);
	}

	@Override
	public MemberDTO myinfo(String id) {
		return udao.myinfo(id);
	}

	@Override
	public void revise(MemberDTO dto) {
		udao.revise(dto);
	}

	@Override
	public void delete(String id) {
		udao.delete(id);
	}

}
