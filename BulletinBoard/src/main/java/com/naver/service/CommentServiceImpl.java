package com.naver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.dto.CommentsVO;
import com.naver.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Inject
	private CommentDAO cdao; 

	@Override
	public void insert(CommentsVO vo) {
		cdao.insert(vo);
	}

	@Override
	public List<CommentsVO> list(Integer bno) {
		return cdao.list(bno);
	}

	@Override
	public void delete(int cno) {
		cdao.delete(cno);
	}

	@Override
	public void update(CommentsVO vo) {
		cdao.update(vo);
	}

}
