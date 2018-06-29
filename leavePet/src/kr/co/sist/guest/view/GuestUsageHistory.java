package kr.co.sist.guest.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GuestUsageHistory extends JFrame{

	private JLabel lblUsageHistory;
	private JTable tableView;
	private DefaultTableModel dtm;
	private JTabbedPane tab;
	private JPanel pnGuestUsageHistory;
	
	private GuestInquiryDetailsCheck gidc;
	
	public GuestUsageHistory() {
		
		tab = new JTabbedPane();
		
		lblUsageHistory = new JLabel("이용내역UI");
		lblUsageHistory.setBorder(new TitledBorder(""));

		pnGuestUsageHistory = new JPanel();
		
		String tableName[] = {"순번","시작날짜","끝날짜","업체명","동물","가격","예약상태"};
		
		dtm = new DefaultTableModel(tableName, 0);
		
		tableView = new JTable(dtm);
		
		tableView.setRowHeight(90);
		
		tableView.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableView.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableView.getColumnModel().getColumn(2).setPreferredWidth(80);
		tableView.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableView.getColumnModel().getColumn(4).setPreferredWidth(60);
		tableView.getColumnModel().getColumn(5).setPreferredWidth(60);
		tableView.getColumnModel().getColumn(6).setPreferredWidth(60);
		
		JScrollPane jsp = new JScrollPane(tableView);
		
		pnGuestUsageHistory.add(lblUsageHistory);
		pnGuestUsageHistory.add(jsp);
		
		gidc = new GuestInquiryDetailsCheck();
		
		tab.add("이용내역", pnGuestUsageHistory);
		tab.addTab("문의내역", gidc.pnGuestInquiryDetailsCheck);
		
		add(tab);
		
		setVisible(true);
		setBounds(500, 300, 470, 520);
		
	}//GuestUsageHistory
	
	public static void main(String[] args) {
		new GuestUsageHistory();
	}//main
}//class
