package kr.co.sist.guest.Evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.guest.dao.GuestDAO;
import kr.co.sist.guest.view.GuestInquiryDetailsCheck;
import kr.co.sist.guest.view.QNA;
import kr.co.sist.guest.vo.GuestInquiryDetailsCheckVO;

public class GuestInquiryDetailsCheckEvt extends MouseAdapter implements ActionListener {

	private GuestInquiryDetailsCheck gidc;

	public GuestInquiryDetailsCheckEvt(GuestInquiryDetailsCheck gidc) {
		this.gidc = gidc;
	}// GuestInquiryDetailsCheckEvt

	public void guestDetailsCheckList() {
		GuestDAO g_dao = GuestDAO.getInstance();

		try {
			List<GuestInquiryDetailsCheckVO> list = g_dao.guestDetailsCheckSelect();
			Object[] tempData = null;

			DefaultTableModel dtmGD = gidc.getDtm();
			dtmGD.setRowCount(0);

			for (GuestInquiryDetailsCheckVO gdcv : list) {
				tempData = new Object[4];
				tempData[0] = gdcv.getqSeq();
				tempData[1] = gdcv.getqDate();
				tempData[2] = gdcv.getqTitle();
				tempData[3] = gdcv.getqStatus();

				dtmGD.addRow(tempData);
			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// GuestDetailsCheckList

	@Override
	public void mouseClicked(MouseEvent me) {
		JTable temp = (JTable) gidc.getTbView();

		String status = (String) temp.getValueAt(temp.getSelectedRow(), 3);
		if (status.equals("Y")) {
			switch (JOptionPane.showConfirmDialog(gidc, "문의내역을 확인 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				new QNA();
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	}

}// class
