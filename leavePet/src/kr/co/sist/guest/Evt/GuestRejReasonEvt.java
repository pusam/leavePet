package kr.co.sist.guest.Evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.sist.guest.dao.GuestDAO;
import kr.co.sist.guest.view.GuestRejReason;

public class GuestRejReasonEvt implements ActionListener {

	private GuestRejReason grr;
	
	public GuestRejReasonEvt(GuestRejReason grr) {
		this.grr=grr;
	}//GuestRejReasonEvt
	
	public void guestRejReasonList() {
		GuestDAO g_dao = GuestDAO.getInstance();
		
		try {
			grr.getTaRejReason().setText(g_dao.guestRejReasonSelect());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}//guestRejReasonList

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==grr.getBtnClose()) {
			grr.dispose();
		}//actionPerformed
	}//actionPerformed
	
	
}//class
