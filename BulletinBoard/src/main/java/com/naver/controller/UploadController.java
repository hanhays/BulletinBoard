package com.naver.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.naver.utils.MediaUtils;
import com.naver.utils.UploadFileUtils;

@Controller
public class UploadController {
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
	}
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public String uploadForm(MultipartHttpServletRequest request, Model model) throws IOException {
		MultipartFile file = request.getFile("file");
//		String title = request.getParameter("title"); if there is file name
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+file.getOriginalFilename();
		
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		model.addAttribute("savedName", savedName);
		
		return "uploadResult";
	}
	
	@RequestMapping(value = "uploadajax", method = RequestMethod.GET)
	public void uploadajax() {
		
	}
	
	@RequestMapping(value = "uploadajax", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String uploadajax(MultipartHttpServletRequest request) throws IOException {
		MultipartFile file = request.getFile("file");
		return UploadFileUtils.uploadFile(uploadPath, file);
	}
	
	@RequestMapping("display")
	@ResponseBody
	public ResponseEntity<byte[]> display(String filename) {
		
		try {
			filename = new String(filename.getBytes("8859_1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} //encode for Korean
		
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		try {
			in = new FileInputStream(uploadPath+filename);
			String type = filename.substring(filename.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(type);	
			HttpHeaders headers = new HttpHeaders();
			
			if(mType != null) {
				headers.setContentType(mType);
			} else {
				filename = filename.substring(filename.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\""+new String(filename.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			
		} finally {
			try {
				if(in != null) in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return entity;
	}
	
	@RequestMapping(value = "deletefile", method = RequestMethod.POST)
	@ResponseBody
	public String deletefile(String filename) {
		filename = filename.replace('/', File.separatorChar);
		
		String type = filename.substring(filename.lastIndexOf(".")+1);
		if(MediaUtils.getMediaType(type)!=null) {
			String prefix = filename.substring(0,12);
			String suffix = filename.substring(14);
			
			File fl = new File(uploadPath, prefix+suffix);
			if(fl.exists()) fl.delete(); //delete original img 
		}
		
		File f = new File(uploadPath, filename);
		if(f.exists()) f.delete(); //delete s_img
		return "deleted.!";
	}
}
