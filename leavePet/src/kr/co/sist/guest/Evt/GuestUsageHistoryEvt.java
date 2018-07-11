package kr.co.sist.guest.Evt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.guest.dao.GuestDAO;
import kr.co.sist.guest.view.GuestUsageHistory;
import kr.co.sist.guest.vo.GuestUsageHistoryVO;

public class GuestUsageHistoryEvt extends MouseAdapter{

	private GuestUsageHistory guh;
	
	public GuestUsageHistoryEvt(GuestUsageHistory guh) {
		this.guh=guh;
		
	}//GuestUsageHistoryEvt
	
	public void setUsageHistory() {
		GuestDAO g_dao = GuestDAO.getInstance();
		
		try {
			List<GuestUsageHistoryVO> list = g_dao.selectUsageHistory();
			Object[] tempData = null;
			
			DefaultTableModel dtmUH = guh.getDtm();
			dtmUH.setRowCount(0);
			
			for(GuestUsageHistoryVO guhv : list) {
			tempData = new Object[6];
			tempData[0] = guhv.getChkInDate();
			tempData[1] = guhv.getChkOutDate();
			tempData[2] = guhv.getCoName();
			tempData[3] = guhv.getPetName();
			tempData[4] = guhv.getbStatus();
			tempData[5] = guhv.getRtPrice();
			// 생성된 배열을 JTable에 반영하기 위해 D.T.M에 추가 한다.
			dtmUH.addRow(tempData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getClickCount()==2) {
			
			JTable temp =(JTable)me.getSource();
			
			String date = (String)temp.getValueAt(temp.getSelectedRow(), 0);
			
			System.out.println(date);
			
		}//end if
	}//mouseClicked
	
	
	
}//GuestUsageHistoryEvt
