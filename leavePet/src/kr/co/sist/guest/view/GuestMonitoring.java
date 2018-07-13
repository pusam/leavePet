package kr.co.sist.guest.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import kr.co.sist.guest.Evt.GuestMonitoringEvt;

/**
 * 게스트 모니터링 뷰
 * @author owner
 */
public class GuestMonitoring extends JFrame {

	private JLabel lblTitle, lblSelectDate, lblBigPetView, lblMonitorView;
	private JComboBox<String> cbSelectDate;
	private JButton btnSearch, btnSmallPetView1, btnSmallPetView2, btnSmallPetView3,
	btnSmallPetView4, btnSmallPetView5;
	private String bSeq;
	
	public GuestMonitoring(String bSeq) {
		lblTitle = new JLabel("타이틀 가져와서 쓸것임");
		lblSelectDate = new JLabel("날짜 선택");
		lblBigPetView = new JLabel();
		btnSmallPetView1 = new JButton();
		btnSmallPetView2 = new JButton();
		btnSmallPetView3 = new JButton();
		btnSmallPetView4 = new JButton();
		btnSmallPetView5 = new JButton();
		lblMonitorView = new JLabel();
		cbSelectDate = new JComboBox<>();
		lblMonitorView = new JLabel();
		btnSearch = new JButton("검색");
		this.bSeq=bSeq;

		int x = 0;
		int xGep = 20;
		int y = 0;
		int yGep = 10;
		int width = 300;
		int height = 25;
		int imgWidth = 85;
		int imgHeight = 100;

		x = x + xGep;
		lblTitle.setBounds(x, 10, 750, 30);
		y = y + height + yGep + 10;
		lblSelectDate.setBounds(x, y, 450, 30);
		y = y + height + yGep;
		cbSelectDate.setBounds(x, y+5, 320, 20);
		btnSearch.setBounds(x+330, y, 60, 25);
		y = y + height + yGep;
		lblBigPetView.setBounds(x, y, 450, 330);
		y = y + height + yGep;
		btnSmallPetView1.setBounds(x, y + 300, imgWidth, imgHeight);
		btnSmallPetView2.setBounds(x + 90, y + 300, imgWidth, imgHeight);
		btnSmallPetView3.setBounds(x + 180, y + 300, imgWidth, imgHeight);
		btnSmallPetView4.setBounds(x + 270, y + 300, imgWidth, imgHeight);
		btnSmallPetView5.setBounds(x + 360, y + 300, imgWidth, imgHeight);
		y = y + height + yGep;
		lblMonitorView.setBounds(x + 460, 45, 290, 510);

		lblTitle.setBorder(new TitledBorder(""));
		lblSelectDate.setBorder(new TitledBorder(""));
		lblBigPetView.setBorder(new TitledBorder(""));
		btnSmallPetView1.setBorder(new TitledBorder(""));
		btnSmallPetView2.setBorder(new TitledBorder(""));
		btnSmallPetView3.setBorder(new TitledBorder(""));
		btnSmallPetView4.setBorder(new TitledBorder(""));
		btnSmallPetView5.setBorder(new TitledBorder(""));
		lblMonitorView.setBorder(new TitledBorder(""));

		add(lblTitle);
		add(lblSelectDate);
		add(cbSelectDate);
		add(lblBigPetView);
		add(btnSmallPetView1);
		add(btnSmallPetView2);
		add(btnSmallPetView3);
		add(btnSmallPetView4);
		add(btnSmallPetView5);
		add(lblMonitorView);
		add(btnSearch);

		GuestMonitoringEvt gme = new GuestMonitoringEvt(this);
		gme.setDateTitle();
		
		setResizable(false);
		setLayout(null);
		setBounds(600, 200, 800, 600);
		setVisible(true);

	}// GuestMonitoringView

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public JLabel getLblSelectDate() {
		return lblSelectDate;
	}

	public JLabel getLblBigPetView() {
		return lblBigPetView;
	}

	public JLabel getLblMonitorView() {
		return lblMonitorView;
	}

	public JComboBox<String> getCbSelectDate() {
		return cbSelectDate;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnSmallPetView1() {
		return btnSmallPetView1;
	}

	public JButton getBtnSmallPetView2() {
		return btnSmallPetView2;
	}

	public JButton getBtnSmallPetView3() {
		return btnSmallPetView3;
	}

	public JButton getBtnSmallPetView4() {
		return btnSmallPetView4;
	}

	public JButton getBtnSmallPetView5() {
		return btnSmallPetView5;
	}

	public String getbSeq() {
		return bSeq;
	}

	
}// class
