package com.naver.service;

import com.naver.dto.LoginTo;
import com.naver.dto.MemberDTO;

public interface UserService {
	
	LoginTo login(LoginTo to);

	void enroll(MemberDTO dto);

	MemberDTO myinfo(String id);

	void revise(MemberDTO dto);

	void delete(String id);

}
