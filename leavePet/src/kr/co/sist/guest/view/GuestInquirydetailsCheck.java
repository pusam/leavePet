package kr.co.sist.guest.view;

import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GuestInquirydetailsCheck extends JFrame {

	
	private JLabel lblGuestInquirydetailsCheck, lblGuestContactDetails, lblAnswerDetails;
	private JTable tableView;
	private DefaultTableModel dtm;
	private TextArea taGuestContactDetails, taAnswerDetails; 

	private GuestInquirydetailsCheck() {
		
		lblGuestInquirydetailsCheck = new JLabel("���ǳ��� Ȯ��UI");
		lblGuestContactDetails = new JLabel("�� ���� ���� ��");
		lblAnswerDetails= new JLabel("�亯 ����");
		taGuestContactDetails = new TextArea();
		taAnswerDetails = new TextArea();
		
		lblGuestInquirydetailsCheck.setBorder(new TitledBorder(""));
		lblGuestContactDetails.setBorder(new TitledBorder(""));
		lblAnswerDetails.setBorder(new TitledBorder(""));
		
		String tableName[] = {"����","���ó�¥","���� ����","�亯����"};
		
		dtm = new DefaultTableModel(tableName, 0);
		
		tableView = new JTable(dtm);
		
		tableView.setRowHeight(90);
		
		tableView.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableView.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableView.getColumnModel().getColumn(2).setPreferredWidth(160);
		tableView.getColumnModel().getColumn(3).setPreferredWidth(60);
		
		JScrollPane jsp = new JScrollPane(tableView);
		
		lblGuestInquirydetailsCheck.setBounds(10, 10, 360, 60);
		jsp.setBounds(10, 80, 360, 500);
		lblGuestContactDetails.setBounds(380, 10, 420, 30);
		taGuestContactDetails.setBounds(380, 50, 420, 240);
		lblAnswerDetails.setBounds(380, 300, 420, 30);
		taAnswerDetails.setBounds(380, 340, 420, 240);
		
		add(lblGuestInquirydetailsCheck);
		add(jsp);
		add(lblGuestContactDetails);
		add(taGuestContactDetails);
		add(lblAnswerDetails);
		add(taAnswerDetails);
		
		setResizable(false);
		setLayout(null);
		setBounds(600, 200, 820, 620);
		setVisible(true);		
		
	}// GuestInquirydetailsCheck

	public static void main(String[] args) {

		new GuestInquirydetailsCheck();

	}// main

}// class
