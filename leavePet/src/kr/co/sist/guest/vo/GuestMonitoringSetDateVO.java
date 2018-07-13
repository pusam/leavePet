package kr.co.sist.guest.vo;

public class GuestMonitoringSetDateVO {

	private String chkInDate, chkOutDate, coName, petType, bNum;
	private int rtPrice;
	
	public GuestMonitoringSetDateVO() {
		
	}

	public GuestMonitoringSetDateVO(String chkInDate, String chkOutDate, String coName, String petType, String bNum,
			int rtPrice) {
		this.chkInDate = chkInDate;
		this.chkOutDate = chkOutDate;
		this.coName = coName;
		this.petType = petType;
		this.bNum = bNum;
		this.rtPrice = rtPrice;
	}

	public String getChkInDate() {
		return chkInDate;
	}

	public void setChkInDate(String chkInDate) {
		this.chkInDate = chkInDate;
	}

	public String getChkOutDate() {
		return chkOutDate;
	}

	public void setChkOutDate(String chkOutDate) {
		this.chkOutDate = chkOutDate;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public int getRtPrice() {
		return rtPrice;
	}

	public void setRtPrice(int rtPrice) {
		this.rtPrice = rtPrice;
	}

}//GuestMonitoringSetDateVO
