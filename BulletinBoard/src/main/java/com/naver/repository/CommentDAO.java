package com.naver.repository;

import java.util.List;

import com.naver.dto.CommentsVO;

public interface CommentDAO {
	
	public abstract void insert(CommentsVO vo);

	public abstract List<CommentsVO> list(Integer bno);

	public abstract void delete(int cno);

	public abstract void update(CommentsVO vo);

	public abstract void deleteByBno(int bno);
	
}
