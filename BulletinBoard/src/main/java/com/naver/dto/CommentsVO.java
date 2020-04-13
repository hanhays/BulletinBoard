package com.naver.dto;

import java.io.Serializable;

public class CommentsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		private int cno ;
		private int bno ;
		private String ment ;
		private String menter ;
		private String regdate ;
		private String updatedate ;
		
		public CommentsVO() {
			// TODO Auto-generated constructor stub
		}
		
		public CommentsVO(int cno, int bno, String ment, String menter, String regdate, String updatedate) {
			super();
			this.cno = cno;
			this.bno = bno;
			this.ment = ment;
			this.menter = menter;
			this.regdate = regdate;
			this.updatedate = updatedate;
		}

		public int getCno() {
			return cno;
		}

		public void setCno(int cno) {
			this.cno = cno;
		}

		public int getBno() {
			return bno;
		}

		public void setBno(int bno) {
			this.bno = bno;
		}

		public String getMent() {
			return ment;
		}

		public void setMent(String ment) {
			this.ment = ment;
		}

		public String getMenter() {
			return menter;
		}

		public void setMenter(String menter) {
			this.menter = menter;
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
		
		

}
