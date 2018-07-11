package kr.co.sist.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.guest.vo.GuestUsageHistoryVO;
import kr.co.sist.properties.DataBaseConnection;

public class GuestDAO {

	private static GuestDAO g_dao;
	
	public GuestDAO() {
		
	}
	
	public static GuestDAO getInstance() {
		
		if(g_dao==null) {
			g_dao = new GuestDAO();
		}//getInstance
		return g_dao;
	}//getInstance
	
	public List<GuestUsageHistoryVO> selectUsageHistory() throws SQLException{
		List<GuestUsageHistoryVO> listUH = new ArrayList<GuestUsageHistoryVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 1 ����̹��ε�
		// 2 Ŀ�ؼ� ���
		con = DataBaseConnection.getInstance().getConnection();
		// 3 ������ ���
		String selectUH="select A.CHK_IN_DATE, A.CHK_OUT_DATE, B.CO_NAME, A.PET_NAME, A.B_STATUS, C.RT_PRICE\r\n" + 
				"from BOOK_LIST A INNER JOIN CORPORATION B\r\n" + 
				"ON A.LICENSE_NUM = B.LICENSE_NUM\r\n" + 
				"INNER JOIN ROOM C\r\n" + 
				"ON B.LICENSE_NUM = C.LICENSE_NUM ";
		// 4 ���ε� ������ �� �Ҵ�
		// 5 ���� ���� �� ��� ���
		pstmt=con.prepareStatement(selectUH);
		
		rs = pstmt.executeQuery();
		
		GuestUsageHistoryVO guhy= null;
		while(rs.next()) {
			guhy = new GuestUsageHistoryVO();
			guhy.setChkInDate(rs.getString("CHK_IN_DATE"));
			guhy.setChkOutDate(rs.getString("CHK_OUT_DATE"));
			guhy.setCoName(rs.getString("CO_NAME"));
			guhy.setPetName(rs.getString("PET_NAME"));
			guhy.setbStatus(rs.getString("B_STATUS"));
			guhy.setRtPrice(rs.getInt("RT_PRICE"));
			
			listUH.add(guhy);
		}
		
		
		return listUH;
	}//selectUsageHistory
	
}//class
