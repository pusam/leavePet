package kr.co.sist.guest.Evt;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import kr.co.sist.guest.dao.GuestDAO;
import kr.co.sist.guest.view.GuestMonitoring;
import kr.co.sist.guest.vo.GuestMonitoringSetDateVO;
import static java.lang.String.valueOf;

public class GuestMonitoringEvt {

	private GuestMonitoring gm;

	public GuestMonitoringEvt(GuestMonitoring gm) {
		this.gm = gm;
	}

	public void setDateTitle() {
		GuestDAO g_dao = GuestDAO.getInstance();

		try {
			List<GuestMonitoringSetDateVO> list = g_dao.guestMonitoringDateSelect(gm.getbSeq());
			String[] tempData = null;

			for (GuestMonitoringSetDateVO gmsdv : list) {
				tempData = new String[2];
				tempData[0] = gmsdv.getChkInDate();
				tempData[1] = gmsdv.getChkOutDate();
			} // end for

			int startDate = Integer.parseInt(tempData[0].substring(8, 10));
			int endDate = Integer.parseInt(tempData[1].substring(8, 10));

			int startYear = Integer.parseInt(tempData[0].substring(0, 4));
			int endYear = Integer.parseInt(tempData[1].substring(0, 4));
			int startMonth = Integer.parseInt(tempData[0].substring(5, 7));
			int endMonth = Integer.parseInt(tempData[1].substring(5, 7));

			Calendar cal = null;
			int startLastDay = 0;
			cal = Calendar.getInstance();
			cal.set(startYear, startMonth - 1, 1);
			startLastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			int endLastDay = 0;
			cal.set(endYear, endMonth - 1, 1);
			endLastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			System.out.println(startYear);
			System.out.println(endYear);
			System.out.println(startMonth);
			System.out.println(endMonth);
			
			int cnt = 0;
			if (startYear == endYear && startMonth == endMonth)
				for (int i = startDate; i < endDate + 1; i++) {
					gm.getCbSelectDate().addItem(valueOf(i));
					cnt++;
				} // end for

			if (startYear == endYear && startMonth != endMonth) {
				for (int i = startDate; i < startLastDay + 1; i++) {
					gm.getCbSelectDate().addItem(valueOf(i));
					cnt++;
				} // end for
				for (int i = 1; i < endDate + 1; i++) {
					gm.getCbSelectDate().addItem(valueOf(i));
					cnt++;
				} // end for
			}
			
			if (startYear != endYear && startMonth != endMonth) {
				System.out.println(startDate);
				System.out.println(startLastDay);
				for (int i = startDate; i < startLastDay + 1; i++) {
					gm.getCbSelectDate().addItem(valueOf(i));
					cnt++;
				}
				for (int i = 1; i < endDate + 1; i++) {
					gm.getCbSelectDate().addItem(valueOf(i));
					cnt++;
				}
			}

			Object[] titleData = null;
			StringBuilder sb = new StringBuilder();
			for (GuestMonitoringSetDateVO gmsdv : list) {
				titleData = new Object[5];
				titleData[0] = gmsdv.getChkInDate();
				titleData[1] = gmsdv.getChkOutDate();
				titleData[2] = gmsdv.getCoName();
				titleData[3] = gmsdv.getPetType();
				titleData[4] = gmsdv.getRtPrice();
				sb.append("이용 날짜 : ").append((String) titleData[0]).append("~").append((String) titleData[1])
						.append("   업체명 : ").append((String) titleData[2]).append("   종류 : ")
						.append((String) titleData[3]).append("   가격 : ")
						.append(valueOf(Integer.parseInt(valueOf(titleData[4])) * cnt));
				gm.getLblTitle().setText(sb.toString());

			} // end for

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// dateSearch

}// class
