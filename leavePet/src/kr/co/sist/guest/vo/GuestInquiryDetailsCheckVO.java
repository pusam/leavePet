package kr.co.sist.guest.vo;

public class GuestInquiryDetailsCheckVO {

	private String qSeq, qDate, qTitle, qStatus;
	
	public GuestInquiryDetailsCheckVO() {
		
	}//GuestInquiryDetailsCheckVO

	public GuestInquiryDetailsCheckVO(String qSeq, String qDate, String qTitle, String qStatus) {
		this.qSeq = qSeq;
		this.qDate = qDate;
		this.qTitle = qTitle;
		this.qStatus = qStatus;
	}

	public String getqSeq() {
		return qSeq;
	}

	public void setqSeq(String qSeq) {
		this.qSeq = qSeq;
	}

	public String getqDate() {
		return qDate;
	}

	public void setqDate(String qDate) {
		this.qDate = qDate;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqStatus() {
		return qStatus;
	}

	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}
	
}//class
