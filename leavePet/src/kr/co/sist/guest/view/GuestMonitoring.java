package kr.co.sist.guest.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

/**
 * 게스트 모니터링 뷰
 * @author owner
 */
public class GuestMonitoring extends JFrame {

	private JLabel lblTitle, lblSelectDate, lblBigPetView, lblSmallPetView1, lblSmallPetView2, lblSmallPetView3,
			lblSmallPetView4, lblSmallPetView5, lblMonitorView;
	private JComboBox<String> cbSelectDate;
	private JButton btnSearch;

	public GuestMonitoring() {
		lblTitle = new JLabel("타이틀 가져와서 쓸것임");
		lblSelectDate = new JLabel("날짜 선택");
		lblBigPetView = new JLabel();
		lblSmallPetView1 = new JLabel();
		lblSmallPetView2 = new JLabel();
		lblSmallPetView3 = new JLabel();
		lblSmallPetView4 = new JLabel();
		lblSmallPetView5 = new JLabel();
		lblMonitorView = new JLabel();
		cbSelectDate = new JComboBox<>();
		lblMonitorView = new JLabel();
		btnSearch = new JButton("검색");

		int x = 0;
		int xGep = 20;
		int y = 0;
		int yGep = 10;
		int width = 300;
		int height = 25;

		x = x + xGep;
		lblTitle.setBounds(x, 10, 700, 30);
		y = y + height + yGep + 10;
		lblSelectDate.setBounds(x, y, 400, 30);
		y = y + height + yGep;
		cbSelectDate.setBounds(x, y+5, 320, 20);
		btnSearch.setBounds(x+330, y, 60, 25);
		y = y + height + yGep;
		lblBigPetView.setBounds(x, y, 400, 330);
		y = y + height + yGep;
		lblSmallPetView1.setBounds(x, y + 300, 80, 100);
		lblSmallPetView2.setBounds(x + 80, y + 300, 80, 100);
		lblSmallPetView3.setBounds(x + 160, y + 300, 80, 100);
		lblSmallPetView4.setBounds(x + 240, y + 300, 80, 100);
		lblSmallPetView5.setBounds(x + 320, y + 300, 80, 100);
		y = y + height + yGep;
		lblMonitorView.setBounds(x + 410, 45, 290, 510);

		lblTitle.setBorder(new TitledBorder(""));
		lblSelectDate.setBorder(new TitledBorder(""));
		lblBigPetView.setBorder(new TitledBorder(""));
		lblSmallPetView1.setBorder(new TitledBorder(""));
		lblSmallPetView2.setBorder(new TitledBorder(""));
		lblSmallPetView3.setBorder(new TitledBorder(""));
		lblSmallPetView4.setBorder(new TitledBorder(""));
		lblSmallPetView5.setBorder(new TitledBorder(""));
		lblMonitorView.setBorder(new TitledBorder(""));

		add(lblTitle);
		add(lblSelectDate);
		add(cbSelectDate);
		add(lblBigPetView);
		add(lblSmallPetView1);
		add(lblSmallPetView2);
		add(lblSmallPetView3);
		add(lblSmallPetView4);
		add(lblSmallPetView5);
		add(lblMonitorView);
		add(btnSearch);

		setResizable(false);
		setLayout(null);
		setBounds(600, 200, 750, 600);
		setVisible(true);

	}// GuestMonitoringView

	public static void main(String[] args) {
		new GuestMonitoring();
	}// main

}// class
