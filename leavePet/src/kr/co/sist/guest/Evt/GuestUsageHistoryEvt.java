package kr.co.sist.guest.Evt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.guest.dao.GuestDAO;
import kr.co.sist.guest.view.GuestMonitoring;
import kr.co.sist.guest.view.GuestRejReason;
import kr.co.sist.guest.view.GuestUsageHistory;
import kr.co.sist.guest.vo.GuestUsageHistoryVO;

public class GuestUsageHistoryEvt extends MouseAdapter {

	private GuestUsageHistory guh;

	public GuestUsageHistoryEvt(GuestUsageHistory guh) {
		this.guh = guh;

	}// GuestUsageHistoryEvt

	public void setUsageHistory() {
		GuestDAO g_dao = GuestDAO.getInstance();

		try {
			List<GuestUsageHistoryVO> list = g_dao.selectUsageHistory();
			Object[] tempData = null;

			DefaultTableModel dtmUH = guh.getDtm();
			dtmUH.setRowCount(0);

			for (GuestUsageHistoryVO guhv : list) {
				tempData = new Object[7];
				tempData[0] = guhv.getbSeq();
				tempData[1] = guhv.getChkInDate();
				tempData[2] = guhv.getChkOutDate();
				tempData[3] = guhv.getCoName();
				tempData[4] = guhv.getPetName();
				tempData[5] = guhv.getRtPrice();
				tempData[6] = guhv.getbStatus();
				// 생성된 배열을 JTable에 반영하기 위해 D.T.M에 추가 한다.
				dtmUH.addRow(tempData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getClickCount() == 2) {

			JTable temp = (JTable) me.getSource();

			String bSeq = (String) temp.getValueAt(temp.getSelectedRow(), 0);

			String status = (String) temp.getValueAt(temp.getSelectedRow(), 6);
			if (status.equals("N"))	{
				switch (JOptionPane.showConfirmDialog(guh, "거절 내역을 보시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					new GuestRejReason();
					break;
				}//end switch
			}//else if
			
			if( status.equals("Y")) {
				switch (JOptionPane.showConfirmDialog(guh, "모니터링 내용을 보시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					new GuestMonitoring(bSeq);
					break;
				}//end switch
			}

		} // end if
	}// mouseClicked

}// GuestUsageHistoryEvt
