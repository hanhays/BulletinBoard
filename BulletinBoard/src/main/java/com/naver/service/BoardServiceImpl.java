package com.naver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.dto.BoardVO;
import com.naver.dto.PageTO;
import com.naver.repository.BoardDAO;
import com.naver.repository.CommentDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bdao;

	@Autowired
	private CommentDAO cdao;

	
	@Override
	public PageTO listpage(PageTO to) {
		
		int amount = bdao.getAmount();
		to.setAmount(amount);
		
		List<BoardVO> list = bdao.getListpage(to);
		to.setList(list);
		
		return to;
	}

	@Override
	public void insert(BoardVO vo) {

		bdao.insert(vo);
		bdao.updateRoot(vo.getBno());

		String[] arr = vo.getFilenames();
		if (arr != null) {
			for (String filename : vo.getFilenames()) {
				bdao.addAttach(filename, vo.getBno());
			}
		}
	}

	@Override
	public BoardVO read(int bno) {

		bdao.updateReadcnt(bno);

		BoardVO vo = bdao.read(bno);

		List<String> list = bdao.getAttach(bno);

		String[] filenames = (String[]) list.toArray(new String[list.size()]);

		vo.setFilenames(filenames);

		return vo;
	}

	@Override
	public BoardVO updateui(int bno) {

		BoardVO vo = bdao.read(bno);
		
		List<String> list = bdao.getAttach(bno);

		String[] filenames = (String[]) list.toArray(new String[list.size()]);

		vo.setFilenames(filenames);

		return vo;
	}

	@Override
	public void update(BoardVO vo) {
		
		bdao.update(vo);
		
		bdao.deleteAllFile(vo.getBno());
		
		String[] arr = vo.getFilenames();
		if (arr != null) {
			for (String filename : vo.getFilenames()) {
				bdao.addAttach(filename, vo.getBno());
			}
		}
	}
	
	@Override
	public void deleteFile(int bno, String filename) {
		bdao.deleteFile(bno, filename);
	}
	
	@Override
	public void delete(int bno) {
		cdao.deleteByBno(bno);
		bdao.deleteAllFile(bno);
		bdao.delete(bno);
		
	}

	@Override
	public void reply(BoardVO vo, int parent_root, int parent_step, int parent_indent) {
		bdao.updateStep(parent_root, parent_step);
		bdao.insert(vo);
		bdao.updateReply(vo.getBno(), parent_root, parent_step, parent_indent);
		
		String[] arr = vo.getFilenames();
		if (arr != null) {
			for (String filename : vo.getFilenames()) {
				bdao.addAttach(filename, vo.getBno());
			}
		}
	}


}
