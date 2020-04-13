package com.naver.service;

import java.util.List;

import com.naver.dto.CommentsVO;

public interface CommentService {
	
	public abstract void insert(CommentsVO vo);

	public abstract List<CommentsVO> list(Integer bno);

	public abstract void delete(int cno);

	public abstract void update(CommentsVO vo);

}
