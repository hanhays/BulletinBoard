package com.naver.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.dto.BoardVO;
import com.naver.dto.PageTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession session;
	private final String NS = "com.naver.board";
	

	@Override
	public void insert(BoardVO vo) {
		session.insert(NS+".insert", vo);
	}

	@Override
	public void updateReadcnt(int bno) {
		session.update(NS+".updateReadcnt", bno);	
	}
	
	@Override
	public BoardVO read(int bno) {
		return session.selectOne(NS+".read", bno);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(NS+".update", vo);
	}

	@Override
	public void delete(int bno) {
		session.delete(NS+".delete", bno);
	}

	@Override
	public int getAmount() {
		return session.selectOne(NS+".getAmount");
	}

	@Override
	public List<BoardVO> getListpage(PageTO to) {
		RowBounds rb = new RowBounds(to.getStartNum()-1, to.getPerPage());
		return session.selectList(NS+".getListpage", null, rb); //list instead of getListpage
	}

	@Override
	public void addAttach(String filename, int bno) {
		Map<String,	Object> map = new HashMap<String, Object>();
		map.put("filename", filename);
		map.put("bno", bno);
		session.insert(NS+".addAttach", map);
		
	}

	@Override
	public List<String> getAttach(int bno) {
		return session.selectList(NS+".getAttach", bno);
	}

	@Override
	public void deleteFile(int bno, String filename) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("filename", filename);
		session.delete(NS+".deleteFile", map);
	}

	@Override
	public void deleteAllFile(int bno) {
		session.delete(NS+".deleteAllFile", bno);
	}

	@Override
	public void updateStep(int parent_root, int parent_step) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("parent_root", parent_root);
		map.put("parent_step", parent_step);
		session.update(NS+".updateStep", map);
	}

	@Override
	public void updateReply(int bno, int parent_root, int parent_step, int parent_indent) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("bno", bno);
		map.put("parent_root", parent_root);
		map.put("parent_step", parent_step);
		map.put("parent_indent", parent_indent);
		session.update(NS+".updateReply", map);
	}

	@Override
	public void updateRoot(int bno) {
		session.update(NS+".updateRoot", bno);
	}


}
