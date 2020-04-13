package com.naver.repository;

import com.naver.dto.LoginTo;
import com.naver.dto.MemberDTO;

public interface UserDAO {
	
	public abstract LoginTo login(LoginTo to);

	public abstract void enroll(MemberDTO dto);

	public abstract MemberDTO myinfo(String id);

	public abstract void revise(MemberDTO dto);

	public abstract void delete(String id);

}
