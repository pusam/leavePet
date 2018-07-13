package kr.co.sist.guest.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.guest.Evt.GuestInquiryDetailsCheckEvt;

public class GuestInquiryDetailsCheck extends JPanel{

	private JLabel lblUsageHistory;
	private JTable tbView;
	private DefaultTableModel dtm;
	public JPanel pnAll;
	
	public GuestInquiryDetailsCheck() {
		
		lblUsageHistory = new JLabel("���ǳ���UI");
		lblUsageHistory.setBorder(new TitledBorder(""));
		
		pnAll = new JPanel();
		
		String tableName[] = {"����","���ó�¥","���� ����","�亯����"};
		
		dtm = new DefaultTableModel(tableName, 0);
		
		tbView = new JTable(dtm);
		
		tbView.setRowHeight(90);
		
		tbView.getColumnModel().getColumn(0).setPreferredWidth(70);
		tbView.getColumnModel().getColumn(1).setPreferredWidth(90);
		tbView.getColumnModel().getColumn(2).setPreferredWidth(190);
		tbView.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		JScrollPane jsp = new JScrollPane(tbView);
		
		
		pnAll.add(lblUsageHistory);
		pnAll.add(jsp);
		
		add(pnAll);
		
		GuestInquiryDetailsCheckEvt gdce = new GuestInquiryDetailsCheckEvt(this);
		tbView.addMouseListener(gdce);
		
		gdce.guestDetailsCheckList();
		
		setVisible(true);
		setBounds(500, 300, 460, 500);
		
	}//GuestUsageHistory

	public JLabel getLblUsageHistory() {
		return lblUsageHistory;
	}

	public JTable getTbView() {
		return tbView;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JPanel getPnAll() {
		return pnAll;
	}

}//class
