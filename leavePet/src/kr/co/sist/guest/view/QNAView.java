package kr.co.sist.guest.view;

import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QNAView extends JFrame {

	
	private JLabel lblGuestContactDetails, lblAnswerDetails;
	private DefaultTableModel dtm;
	private TextArea taGuestContactDetails, taAnswerDetails; 

	private QNAView() {
		
		lblGuestContactDetails = new JLabel("고객 문의 내역 상세");
		lblAnswerDetails= new JLabel("답변 내역");
		taGuestContactDetails = new TextArea();
		taAnswerDetails = new TextArea();
		
		lblGuestContactDetails.setBorder(new TitledBorder(""));
		lblAnswerDetails.setBorder(new TitledBorder(""));
		
		
		lblGuestContactDetails.setBounds(10, 10, 420, 30);
		taGuestContactDetails.setBounds(10, 50, 420, 240);
		lblAnswerDetails.setBounds(10, 300, 420, 30);
		taAnswerDetails.setBounds(10, 340, 420, 240);
		
		add(lblGuestContactDetails);
		add(taGuestContactDetails);
		add(lblAnswerDetails);
		add(taAnswerDetails);
		
		setResizable(false);
		setLayout(null);
		setBounds(600, 200, 450, 620);
		setVisible(true);		
		
	}// GuestInquirydetailsCheck

	public static void main(String[] args) {

		new QNAView();

	}// main

}// class
