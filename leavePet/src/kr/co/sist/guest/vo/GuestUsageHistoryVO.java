package kr.co.sist.guest.vo;

public class GuestUsageHistoryVO {

	private String chkInDate, chkOutDate, coName, petName, bStatus;
	private int rtPrice;
	
	public GuestUsageHistoryVO() {
		
	}

	public GuestUsageHistoryVO(String chkInDate, String chkOutDate, String coName, String petName, String bStatus,
			int rtPrice) {
		this.chkInDate = chkInDate;
		this.chkOutDate = chkOutDate;
		this.coName = coName;
		this.petName = petName;
		this.bStatus = bStatus;
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

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getbStatus() {
		return bStatus;
	}

	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}

	public int getRtPrice() {
		return rtPrice;
	}

	public void setRtPrice(int rtPrice) {
		this.rtPrice = rtPrice;
	}
	
	
}//GuestUsageHistoryVO
