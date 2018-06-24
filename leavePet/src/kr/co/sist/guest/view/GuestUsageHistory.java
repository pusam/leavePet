package kr.co.sist.guest.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GuestUsageHistory extends JFrame{

	private JLabel lblUsageHistory;
	private List<String> usageHistorylist;
	private DefaultListModel<List<String>> dlm;
	
	public GuestUsageHistory() {
		
		lblUsageHistory = new JLabel("이용내역UI");
		lblUsageHistory.setBorder(new TitledBorder(""));
		usageHistorylist = new ArrayList<>();
		dlm = new DefaultListModel<>();
		
		dlm.addElement(usageHistorylist);
		
		lblUsageHistory.setBounds(10, 10, 360, 50);
		
		
		add(lblUsageHistory);
		
		setLayout(null);
		setVisible(true);
		setBounds(500, 300, 400, 500);
		
	}//GuestUsageHistory
	
	public static void main(String[] args) {
		new GuestUsageHistory();
	}//main
}//class
