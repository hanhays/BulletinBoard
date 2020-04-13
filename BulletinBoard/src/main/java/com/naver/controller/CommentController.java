package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naver.dto.CommentsVO;
import com.naver.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Inject
	private CommentService cservice;
	
	@RequestMapping(method = RequestMethod.POST)
	public String insert(@RequestBody CommentsVO vo) {
		cservice.insert(vo);
		return "success_insert";
	}
	
	@RequestMapping(value = "{bno}", method = RequestMethod.GET)
	public List<CommentsVO> list(@PathVariable Integer bno) {
		List<CommentsVO> list = cservice.list(bno);
		return list;
	}
	
	@RequestMapping(value = "{cno}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int cno) {
		cservice.delete(cno);
		return "success_delete";
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public String update(@RequestBody CommentsVO vo) {
		cservice.update(vo);
		return "success_update";
	}

}
