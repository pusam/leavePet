package kr.co.sist.guest.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 사용자 고양이 예약신청 화면
 * 
 * @author kdh
 */
public class GuestReservationCatView extends JFrame {

	private JLabel lblTitle, lblStartDate, lblEndDate, lblKind, lblGDName, lblGDPhone,
			lblPreliminaryPhone, lblRequestedTerm, lblHyphen1, lblHyphen2, lblHyphen3, lblHyphen4,
			lblCatName;

	private JComboBox<String> cbStartYear, cbStartMonth, cbStartDay, cbEndYear, cbEndMonth, cbEndDay, cbKind;
	private JTextField tfGDName, tfGDPhone1, tfGDPhone2, tfGDPhone3, tfPreliminaryPhone1,
			tfPreliminaryPhone2, tfPreliminaryPhone3, tfCatName;
	
	private JTextArea taRequestedTerm;

	public GuestReservationCatView() {
		int x = 0;
		int xGep = 20;
		int y = 0;
		int yGep = 10;
		int width = 300;
		int height = 25;

		lblTitle = new JLabel("고양이 예약 신청");
		lblStartDate = new JLabel("시작 날짜");
		cbStartYear = new JComboBox<>();
		cbStartMonth = new JComboBox<>();
		cbStartDay = new JComboBox<>();
		lblEndDate = new JLabel("끝 날짜");
		cbEndYear = new JComboBox<>();
		cbEndMonth = new JComboBox<>();
		cbEndDay = new JComboBox<>();
		lblKind = new JLabel("룸타입");
		cbKind = new JComboBox<>();
		lblGDName = new JLabel("보호자");
		tfGDName = new JTextField("");
		tfGDName.setEditable(false);
		lblGDPhone = new JLabel("연락처");
		tfGDPhone1 = new JTextField();
		tfGDPhone2 = new JTextField();
		tfGDPhone3 = new JTextField();
		lblHyphen1 = new JLabel("-");
		lblHyphen2 = new JLabel("-");
		lblPreliminaryPhone = new JLabel("예비번호");
		tfPreliminaryPhone1 = new JTextField();
		tfPreliminaryPhone2 = new JTextField();
		tfPreliminaryPhone3 = new JTextField();
		lblHyphen3 = new JLabel("-");
		lblHyphen4 = new JLabel("-");
		lblRequestedTerm = new JLabel("요청사항");
		taRequestedTerm = new JTextArea();
		lblCatName = new JLabel("고양이 이름");
		tfCatName = new JTextField();
		
		lblTitle.setFont(new Font("Serif", Font.BOLD, 30));
		cbStartYear.setBackground(new Color(255, 255, 255));
		cbStartMonth.setBackground(new Color(255, 255, 255));
		cbStartDay.setBackground(new Color(255, 255, 255));
		cbEndYear.setBackground(new Color(255, 255, 255));
		cbEndMonth.setBackground(new Color(255, 255, 255));
		cbEndDay.setBackground(new Color(255, 255, 255));
		
		
		x = x + xGep;
		y = y + 30;
		lblTitle.setBounds(x, 10, width, 40);
		y = y + height + yGep;
		lblStartDate.setBounds(x, y, width, height);
		y = y + height + yGep;
		cbStartYear.setBounds(x, y, 90, 20);
		cbStartMonth.setBounds(x + 100, y, 90, 20);
		cbStartDay.setBounds(x + 200, y, 90, 20);
		y = y + height + yGep;
		lblEndDate.setBounds(x, y, width, height);
		y = y + height + yGep;
		cbEndYear.setBounds(x, y, 90, 20);
		cbEndMonth.setBounds(x + 100, y, 90, 20);
		cbEndDay.setBounds(x + 200, y, 90, 20);
		y = y + height + yGep;
		lblKind.setBounds(x, y, width, height);
		cbKind.setBounds(x + 80, y, width - 90, height);
		y = y + height + yGep;
		lblCatName.setBounds(x, y, width, height);
		tfCatName.setBounds(x+80, y, width-80, height);
		y = y + height + yGep;
		lblGDName.setBounds(x, y, 60, height);
		tfGDName.setBounds(x + 80, y, width - 80, height);
		y = y + height + yGep;
		lblGDPhone.setBounds(x, y, 60, height);
		tfGDPhone1.setBounds(x + 80, y, 40, height);
		lblHyphen1.setBounds(x + 125, y, 10, height);
		tfGDPhone2.setBounds(x + 140, y, 50, height);
		lblHyphen2.setBounds(x + 195, y, 10, height);
		tfGDPhone3.setBounds(x + 210, y, 50, height);
		y = y + height + yGep;
		lblPreliminaryPhone.setBounds(x, y, 60, height);
		tfPreliminaryPhone1.setBounds(x + 80, y, 40, height);
		lblHyphen3.setBounds(x + 125, y, 10, height);
		tfPreliminaryPhone2.setBounds(x + 140, y, 50, height);
		lblHyphen4.setBounds(x + 195, y, 10, height);
		tfPreliminaryPhone3.setBounds(x + 210, y, 50, height);
		y = y + height + yGep;
		lblRequestedTerm.setBounds(x, y, 60, height);
		taRequestedTerm.setBounds(x + 80, y, width -80, 160);
		
		add(lblTitle);
		add(lblStartDate);
		add(cbStartYear);
		add(cbStartMonth);
		add(cbStartDay);
		add(lblEndDate);
		add(cbEndYear);
		add(cbEndMonth);
		add(cbEndDay);
		add(lblKind);
		add(cbKind);
		add(lblGDName);
		add(tfGDName);
		add(lblGDPhone);
		add(tfGDPhone1);
		add(tfGDPhone2);
		add(tfGDPhone3);
		add(lblHyphen1);
		add(lblHyphen2);
		add(lblPreliminaryPhone);
		add(tfPreliminaryPhone1);
		add(lblHyphen3);
		add(tfPreliminaryPhone2);
		add(lblHyphen4);
		add(tfPreliminaryPhone3);
		add(lblRequestedTerm);
		add(taRequestedTerm);
		add(lblCatName);
		add(tfCatName);

		setResizable(false);
		setLayout(null);
		setBounds(600, 200, 350, 600);
		setVisible(true);

	}// ReservationView
	public static void main(String[] args) {
		new GuestReservationCatView();
	}// end main

}// class
