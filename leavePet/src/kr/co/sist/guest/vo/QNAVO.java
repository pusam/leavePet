package kr.co.sist.guest.vo;

public class QNAVO {

	private String qTitle, qAnswer;
	
	public QNAVO() {
		
	}

	public QNAVO(String qText, String qAnswer) {
		this.qTitle = qText;
		this.qAnswer = qAnswer;
	}

	public String getqText() {
		return qTitle;
	}

	public void setqText(String qText) {
		this.qTitle = qText;
	}

	public String getqAnswer() {
		return qAnswer;
	}

	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}
	
}
