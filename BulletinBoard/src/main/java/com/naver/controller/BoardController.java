package com.naver.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.naver.dto.BoardVO;
import com.naver.dto.PageTO;
import com.naver.service.BoardService;
import com.naver.utils.MediaUtils;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService bs;

	@Resource(name = "uploadPath")
	private String uploadPath;

	
	@RequestMapping(value = "listpage", method = RequestMethod.GET)
	public void listpage(PageTO to, Model model) {
		to = bs.listpage(to);
		model.addAttribute("to", to);
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insertui() {
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(BoardVO vo) {
		bs.insert(vo);
		return "redirect:/board/listpage";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public void replyui(int bno, int curPage, Model model) {
		BoardVO vo = bs.updateui(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("curPage", curPage);
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(BoardVO vo, int parent_root, int parent_step, int parent_indent, int curPage) {
		bs.reply(vo, parent_root, parent_step, parent_indent);
		return "redirect:/board/listpage?curPage="+ curPage;
	}

	@RequestMapping(value = "read/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, @RequestParam("curPage") int curPage, Model model) {
		BoardVO vo = bs.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("curPage", curPage);
		return "board/read";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardVO vo, @RequestParam("curPage") int curPage) {
		bs.update(vo);
		return "redirect:/board/listpage?curPage=" + curPage;

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateui(Model model, int bno, int curPage) {
		BoardVO vo = bs.updateui(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("curPage", curPage);
		return "/board/update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int bno, int curPage) {
		bs.delete(bno);
		return "redirect:/board/listpage?curPage=" + curPage;
	}


	@RequestMapping(value = "deletefile/{bno}", method = RequestMethod.POST)
	@ResponseBody
	public String deletefile(@PathVariable("bno") int bno, String filename) {
		
		bs.deleteFile(bno, filename);
		
		filename = filename.replace('/', File.separatorChar);
		
		String type = filename.substring(filename.lastIndexOf(".") + 1);
		if (MediaUtils.getMediaType(type) != null) {
			String prefix = filename.substring(0, 12);
			String suffix = filename.substring(14);
			
			File fl = new File(uploadPath, prefix + suffix);
			if (fl.exists())
				fl.delete(); // delete original img
		}
		
		File f = new File(uploadPath, filename);
		if (f.exists())
			f.delete(); // delete s_img
		
		return "deleted.!";
	}
	
}
