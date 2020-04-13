package com.naver.dto;

import java.util.List;

public class PageTO {
	
	private int perPage = 10;
	private int pageLine = 10;
	private int curPage = 1;
	private int amount;
	private int totalPage;
	private int startNum;
//	private int endNum; no need with mybatis
	private int beginPage;
	private int stopPage;
	private List<BoardVO> list;
	
	public PageTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PageTO(int curPage, int amount, int perPage, int pageLine, int totalPage, int startNum, int endNum,
			int beginPage, int stopPage) {
		super();
		this.curPage = curPage;
		this.amount = amount;
		this.perPage = perPage;
		this.pageLine = pageLine;
		this.totalPage = totalPage;
		this.startNum = startNum;
//		this.endNum = endNum;
		this.beginPage = beginPage;
		this.stopPage = stopPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		process();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		process();
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
		process();
	}

	public int getPageLine() {
		return pageLine;
	}

	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
		process();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
		process();
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
		process();
	}

//	public int getEndNum() {
//		return endNum;
//	}
//
//	public void setEndNum(int endNum) {
//		this.endNum = endNum;
//	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
		process();
	}

	public int getStopPage() {
		return stopPage;
	}

	public void setStopPage(int stopPage) {
		this.stopPage = stopPage;
		process();
	}

	public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
		this.list = list;
		process();
	}

	private void process() {
		totalPage = (amount-1)/perPage +1;
		startNum = (curPage-1)*perPage +1;
//		endNum = startNum + (perPage-1); if(endNum > amount) endNum = amount;
		beginPage =((curPage-1)/pageLine)*pageLine+1;
		stopPage = beginPage+(pageLine-1); if(stopPage > totalPage) stopPage = totalPage;
	}
}
