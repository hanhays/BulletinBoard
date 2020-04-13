package com.naver.dto;

import java.io.Serializable;

public class MSGDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int mid;
	private String sender;
	private String receiver;
	
	public MSGDTO() {
		// TODO Auto-generated constructor stub
	}

	public MSGDTO(int mid, String sender, String receiver) {
		super();
		this.mid = mid;
		this.sender = sender;
		this.receiver = receiver;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
