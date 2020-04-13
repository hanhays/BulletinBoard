package com.naver.dto;

import java.io.Serializable;

public class BoardVO/*DTO/TO*/ implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String updatedate;
	private int readcnt;
	private int root;
	private int step;
	private int indent;
	
	private String[] filenames;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}


	public BoardVO(int bno, String title, String content, String writer, String regdate, String updatedate, int readcnt,
			int root, int step, int indent) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.readcnt = readcnt;
		this.root = root;
		this.step = step;
		this.indent = indent;
	}

	
	public BoardVO(int bno, String title, String content, String writer, String regdate, String updatedate, int readcnt,
			int root, int step, int indent, String[] filenames) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.readcnt = readcnt;
		this.root = root;
		this.step = step;
		this.indent = indent;
		this.filenames = filenames;
	}


	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public String[] getFilenames() {
		return filenames;
	}

	public void setFilenames(String[] filenames) {
		this.filenames = filenames;
	}


	public int getRoot() {
		return root;
	}


	public void setRoot(int root) {
		this.root = root;
	}


	public int getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public int getIndent() {
		return indent;
	}


	public void setIndent(int indent) {
		this.indent = indent;
	}

	
	
	

}
