package kr.co.sist.guest.Evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import kr.co.sist.guest.dao.GuestDAO;
import kr.co.sist.guest.view.QNA;
import kr.co.sist.guest.vo.QNAVO;

public class QNAEvt implements ActionListener{

	private QNA q;
	
	public QNAEvt(QNA q) {
		this.q=q;
	}//QNAEvt

	public void requestSelect() {
		GuestDAO g_dao = GuestDAO.getInstance();
		
		try {
			List<QNAVO> list = g_dao.guestQNASelect();
			
			Object tempData[] = null; 
			for(QNAVO qnavo : list) {
				tempData = new Object[2];
				tempData[0]=qnavo.getqText();
				tempData[1]=qnavo.getqAnswer();
				
				q.getTaQText().setText(qnavo.getqText());
				q.getTaQAnswer().setText(qnavo.getqAnswer());
			}//end for
			
		}catch (SQLException se) {
			se.printStackTrace();
		}
		
	}//requestSelect
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	
	
}//class
