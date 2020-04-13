package com.naver.repository;

import java.util.List;

import com.naver.dto.BoardVO;
import com.naver.dto.PageTO;

public interface BoardDAO {
	
	List<BoardVO> getListpage(PageTO to);
	
	List<String> getAttach(int bno);
	
	void insert(BoardVO vo);

	int getAmount();
	
	BoardVO read(int bno);

	void updateReadcnt(int bno);

	void update(BoardVO vo);

	void addAttach(String filename, int bno);
	
	void delete(int bno);

	void deleteFile(int bno, String filename);

	void deleteAllFile(int bno);

	void updateStep(int parent_root, int parent_step);

	void updateReply(int bno, int parent_root, int parent_step, int parent_indent);

	void updateRoot(int bno);

}
