package kr.co.sist.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.guest.vo.GuestInquiryDetailsCheckVO;
import kr.co.sist.guest.vo.GuestMonitoringSetDateVO;
import kr.co.sist.guest.vo.GuestUsageHistoryVO;
import kr.co.sist.guest.vo.QNAVO;
import kr.co.sist.properties.DataBaseConnection;

public class GuestDAO {

	private static GuestDAO g_dao;

	public GuestDAO() {

	}

	public static GuestDAO getInstance() {

		if (g_dao == null) {
			g_dao = new GuestDAO();
		} // getInstance
		return g_dao;
	}// getInstance
	
	private void dbClose(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		} // end if
		if (pstmt != null) {
			pstmt.close();
		} // end if
		if (con != null) {
			con.close();
		} // end if
	}//dbClose

	public List<GuestUsageHistoryVO> selectUsageHistory() throws SQLException {
		List<GuestUsageHistoryVO> listUH = new ArrayList<GuestUsageHistoryVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1 드라이버로딩
			// 2 커넥션 얻기
			con = DataBaseConnection.getInstance().getConnection();
			// 3 쿼리문 얻기
			String selectUH = "select A.B_SEQ, to_char(A.CHK_IN_DATE,'YYYY-MM-DD') AS CHK_IN_DATE, to_char(A.CHK_OUT_DATE,'YYYY-MM-DD') as CHK_OUT_DATE, B.CO_NAME, A.PET_NAME, A.B_STATUS, C.RT_PRICE\r\n"
					+ "from BOOK_LIST A INNER JOIN CORPORATION B\r\n" + "ON A.LICENSE_NUM = B.LICENSE_NUM\r\n"
					+ "INNER JOIN ROOM C\r\n" + "ON B.LICENSE_NUM = C.LICENSE_NUM\r\n" + "order by B_STATUS desc";
			// 4 바인드 변수에 값 할당
			// 5 쿼리 수행 후 결과 얻기
			pstmt = con.prepareStatement(selectUH);

			rs = pstmt.executeQuery();

			GuestUsageHistoryVO guhy = null;
			while (rs.next()) {
				guhy = new GuestUsageHistoryVO();
				guhy.setbSeq(rs.getString("B_SEQ"));
				guhy.setChkInDate(rs.getString("CHK_IN_DATE"));
				guhy.setChkOutDate(rs.getString("CHK_OUT_DATE"));
				guhy.setCoName(rs.getString("CO_NAME"));
				guhy.setPetName(rs.getString("PET_NAME"));
				guhy.setbStatus(rs.getString("B_STATUS"));
				guhy.setRtPrice(rs.getInt("RT_PRICE"));

				listUH.add(guhy);
			}
		} finally {
			dbClose(rs, pstmt, con);
		}//end finally

		return listUH;
	}// selectUsageHistory

	public String guestRejReasonSelect() throws SQLException {
		String data = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DataBaseConnection.getInstance().getConnection();
			data = "select REJ_REASON\r\n" + 
					"from BOOK_LIST\r\n" + 
					"where B_STATUS = 'N'";
			pstmt = con.prepareStatement(data);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				data = rs.getString("REJ_REASON");
			}
			
		}finally {
			dbClose(rs, pstmt, con);
		}
		return data;
	}// guestRejReasonSelect
	
	public List<GuestInquiryDetailsCheckVO> guestDetailsCheckSelect() throws SQLException{
		List<GuestInquiryDetailsCheckVO> listGIDCV = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DataBaseConnection.getInstance().getConnection();
			String selectGD="select q_seq, q_date, q_title, q_status\r\n" + 
					"from QUESTION";
			pstmt = con.prepareStatement(selectGD);
			
			rs = pstmt.executeQuery();
			
			GuestInquiryDetailsCheckVO gdcv = null;
			while(rs.next()) {
				gdcv = new GuestInquiryDetailsCheckVO();
				gdcv.setqSeq(rs.getString("q_seq"));
				gdcv.setqDate(rs.getString("q_date"));
				gdcv.setqTitle(rs.getString("q_title"));
				gdcv.setqStatus(rs.getString("q_status"));
				
				listGIDCV.add(gdcv);
			}//end while
			
		}finally {
			dbClose(rs, pstmt, con);
		}//end finally
		
		return listGIDCV;
	}//guestDetailsCheckSelect
	
	public List<GuestMonitoringSetDateVO> guestMonitoringDateSelect(String bSeq) throws SQLException{
		List<GuestMonitoringSetDateVO> listGMSDV= new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DataBaseConnection.getInstance().getConnection();
			String data = "";
			data = "select to_char(A.chk_In_Date,'yyyy-mm-dd') as chk_In_Date, to_char(A.chk_Out_Date,'yyyy-mm-dd') as chk_Out_Date, B.co_Name, B.pet_Type, C.rt_price\r\n" + 
					"from BOOK_LIST A inner join CORPORATION B\r\n" + 
					"ON A.LICENSE_NUM = B.LICENSE_NUM\r\n" + 
					"inner join ROOM C\r\n" + 
					"ON B.LICENSE_NUM = C.LICENSE_NUM\r\n" + 
					"where B_SEQ = ?";
			pstmt = con.prepareStatement(data);
			pstmt.setString(1, bSeq);
			rs = pstmt.executeQuery();
			
			GuestMonitoringSetDateVO gmsdv=null;
			while(rs.next()) {
				gmsdv = new GuestMonitoringSetDateVO();
				gmsdv.setChkInDate(rs.getString("chk_In_Date"));
				gmsdv.setChkOutDate(rs.getString("chk_Out_Date"));
				gmsdv.setCoName(rs.getString("co_Name"));
				gmsdv.setPetType(rs.getString("pet_Type"));
				gmsdv.setRtPrice(Integer.parseInt(rs.getString("rt_price")));
				
				listGMSDV.add(gmsdv);
				
			}//end while
			
		}finally {
			dbClose(rs, pstmt, con);
		}//end finally
		
		return listGMSDV;
	}//guestMonitoringDateSelect
	
	public List<QNAVO> guestQNASelect() throws SQLException{
		List<QNAVO> listQNA = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DataBaseConnection.getInstance().getConnection();
			
			String data = "select Q_TITLE, Q_TEXT\r\n" + 
					"from QUESTION\r\n" + 
					"where Q_STATUS = 'Y'";
			
			pstmt = con.prepareStatement(data);
			
			rs = pstmt.executeQuery();
			
			Object[] temp = null;
			
			QNAVO qnavo = null;
			while(rs.next()) {
				qnavo = new QNAVO();
				qnavo.setqText(rs.getString("Q_TITLE"));
				qnavo.setqAnswer(rs.getString("Q_TEXT"));
				
				listQNA.add(qnavo);
				
			}//end while
			
		}finally {
			dbClose(rs, pstmt, con);
		}//end finally
		
		return listQNA;
	}//guestQNASelect
	
}// class
