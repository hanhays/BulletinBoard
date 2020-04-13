package com.naver.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.naver.dto.CommentsVO;

@Repository
public class CommentDAOImply implements CommentDAO{
	
	@Inject
	private SqlSession session;
	private final String NS = "com.naver.comment";

	@Override
	public void insert(CommentsVO vo) {
		session.insert(NS+".insert", vo);
	}


	@Override
	public List<CommentsVO> list(Integer bno) {
		return session.selectList(NS+".list", bno);
	}


	@Override
	public void delete(int cno) {
		session.delete(NS+".delete", cno);
	}


	@Override
	public void update(CommentsVO vo) {
		session.update(NS+".update", vo);
	}


	@Override
	public void deleteByBno(int bno) {
		session.delete(NS+".deleteByBno", bno);
	}

}
