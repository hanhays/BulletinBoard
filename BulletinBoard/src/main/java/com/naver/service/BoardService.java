package com.naver.service;

import com.naver.dto.BoardVO;
import com.naver.dto.PageTO;

public interface BoardService {
	
	PageTO listpage(PageTO to);
	
	void insert(BoardVO vo);

	BoardVO read(int bno);

	BoardVO updateui(int bno);

	void update(BoardVO vo);

	void deleteFile(int bno, String filename);
	
	void delete(int bno);

	void reply(BoardVO vo, int parent_root, int parent_step, int parent_indent);

}
