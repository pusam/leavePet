package kr.co.sist.guest.view;

import java.awt.TextArea;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.guest.Evt.GuestRejReasonEvt;

public class GuestRejReason extends JFrame{

	private JLabel lblTitle;
	private JTextArea taRejReason;
	private JButton btnClose;
	
	public GuestRejReason() {
		
		lblTitle = new JLabel("거절사유");
		taRejReason = new JTextArea();
		btnClose = new JButton("닫기");
		
		lblTitle.setBounds(10, 10, 360, 50);
		taRejReason.setBounds(10, 70, 360, 280);
		btnClose.setBounds(310, 360, 60, 30);
		
		lblTitle.setBorder(new TitledBorder(""));
		
		add(lblTitle);
		add(taRejReason);
		add(btnClose);
		
		setLayout(null);
		setVisible(true);
		setBounds(500, 300, 400, 440);
		
		GuestRejReasonEvt grre = new GuestRejReasonEvt(this);
		btnClose.addActionListener(grre);
		
		grre.guestRejReasonList();
		
	}//GuestRejReason
	
	public static void main(String[] args) {
		new GuestRejReason();
	}//main

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public JTextArea getTaRejReason() {
		return taRejReason;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

}//class
