package kr.co.sist.guest.view;

import java.awt.TextArea;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class GuestRejReason extends JFrame{

	private JLabel lblTitle;
	private JTextArea taRejReason;
	
	public GuestRejReason() {
		
		lblTitle = new JLabel("거절사유");
		taRejReason = new JTextArea();
		
		lblTitle.setBounds(10, 10, 360, 50);
		taRejReason.setBounds(10, 70, 360, 280);
		
		lblTitle.setBorder(new TitledBorder(""));
		
		add(lblTitle);
		add(taRejReason);
		
		setLayout(null);
		setVisible(true);
		setBounds(500, 300, 400, 400);
		
	}//GuestRejReason
	
	public static void main(String[] args) {
		new GuestRejReason();
	}//main

}//class
