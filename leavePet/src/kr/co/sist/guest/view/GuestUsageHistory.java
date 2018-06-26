package kr.co.sist.guest.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GuestUsageHistory extends JFrame{

	private JLabel lblUsageHistory;
	private JTable tableView;
	private DefaultTableModel dtm;
	
	public GuestUsageHistory() {
		
		lblUsageHistory = new JLabel("이용내역UI");
		lblUsageHistory.setBorder(new TitledBorder(""));
		
		String tableName[] = {"순번","시작날짜","끝날짜","업체명","동물","가격"};
		
		dtm = new DefaultTableModel(tableName, 0);
		
		tableView = new JTable(dtm);
		
		tableView.setRowHeight(90);
		
		tableView.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableView.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableView.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableView.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableView.getColumnModel().getColumn(4).setPreferredWidth(60);
		tableView.getColumnModel().getColumn(5).setPreferredWidth(60);
		
		JScrollPane jsp = new JScrollPane(tableView);
		
		lblUsageHistory.setBounds(10, 10, 360, 50);
		jsp.setBounds(10, 70, 360, 380);
		
		add(lblUsageHistory);
		add(jsp);
		
		setLayout(null);
		setVisible(true);
		setBounds(500, 300, 400, 500);
		
	}//GuestUsageHistory
	
	public static void main(String[] args) {
		new GuestUsageHistory();
	}//main
}//class
