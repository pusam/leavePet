package kr.co.sist.user.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 사용자 견 예약신청 화면
 * @author kdh
 */
public class ReservationView extends JFrame{

	private JLabel lblReservation, lblSelectDate, lblKind, lblGuardian, lblGuardianPhone, lblPreliminaryPhone;
	
	public ReservationView() {
		
	}//ReservationView
	
	public static void main(String[] args) {
		new ReservationView();
	}//end main

}//class
