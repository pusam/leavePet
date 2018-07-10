package kr.co.sist.guest.Evt;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

import kr.co.sist.guest.view.GuestReservationCat;

public class GuestReservationCatEvt implements ItemListener {

	private GuestReservationCat prc;
	private boolean yearCheck;
	private int year;
	private int month;
	private int day;
	private int yearIndex;
	private int monthIndex;
	private String today;

	public GuestReservationCatEvt(GuestReservationCat prc) {
		this.prc = prc;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		today = sdf.format(date);
		year = parseInt(today.substring(0, 4));
		month = parseInt(today.substring(4, 6));
		day = parseInt(today.substring(6, 8));

		setDateYearMonth();
		yearCheck = isLeapYear(year);
		setDays(yearCheck, month, parseInt(valueOf(prc.getCbStartYear().getSelectedItem())));
	}// GuestReservationCatEvt

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if (ie.getSource() == prc.getCbStartYear()) {
			this.yearIndex = prc.getCbStartYear().getSelectedIndex();
			setDateYearMonth();
			int a = parseInt(valueOf(prc.getCbStartYear().getSelectedItem()) + 1);
			if (year == parseInt(valueOf(prc.getCbStartYear().getSelectedItem()))) {
				prc.getCbEndYear().removeAllItems();
				prc.getCbEndYear().addItem(valueOf(prc.getCbStartYear().getSelectedItem()));
				prc.getCbEndYear().addItem(valueOf(parseInt(valueOf(prc.getCbStartYear().getSelectedItem())) + 1));
			} else {
				prc.getCbEndYear().removeAllItems();
				prc.getCbEndYear().addItem(valueOf(prc.getCbStartYear().getSelectedItem()));
			} // end else
		} // end if
		if (ie.getSource() == prc.getCbStartMonth()) {
			this.monthIndex = prc.getCbStartMonth().getSelectedIndex();
			if (prc.getCbStartMonth().getSelectedItem() != null) {
				setDays(yearCheck, parseInt(valueOf(prc.getCbStartMonth().getSelectedItem())),
						parseInt(valueOf(prc.getCbStartYear().getSelectedItem())));
				prc.getCbEndMonth().removeAllItems();
				for (int i = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem())); i < 13; i++) {
					prc.getCbEndMonth().addItem(valueOf(i) );
				} // end for
			} // end if
		} // end if
		
		if(ie.getSource()==prc.getCbStartDay()) {
		}//end if
		
		if(ie.getSource()==prc.getCbEndYear()) {
		}//end if
		
		}// actionPerformed

	/**
	 * 년도와 달을 셋팅
	 */
	private void setDateYearMonth() {
		if (prc.getCbStartYear().getSelectedItem() == null) {
			prc.getCbStartYear().addItem(valueOf(year));
			prc.getCbStartYear().addItem(valueOf(year + 1));
			prc.getCbEndYear().addItem(valueOf(year));
			prc.getCbEndYear().addItem(valueOf(year + 1));
		} // end if

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int otherYear = parseInt(sdf.format(date));

		if (otherYear == year + yearIndex) {
			prc.getCbStartMonth().removeAllItems();
			for (int i = month; i < 13; i++) {
				prc.getCbStartMonth().addItem(valueOf(i));
				prc.getCbEndMonth().addItem(valueOf(i));
			} // end for
		} else {
			prc.getCbStartMonth().removeAllItems();
			prc.getCbEndMonth().removeAllItems();
			for (int i = 1; i < 13; i++) {
				prc.getCbStartMonth().addItem(valueOf(i));
				prc.getCbEndMonth().addItem(valueOf(i));
			} // end for
		} // end else

	}// dateSet

	// 해당 년도가 윤년인지 판별
	private boolean isLeapYear(int year) {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	}// isLeapYear

	/**
	 * 달의 일자 계산
	 * 
	 * @param year
	 * @return
	 */
	private void setDays(boolean yearCheck, int monthCheck, int yearDate) {
		int dayCheck = 0;
		// 윤년이면 2월달은 29일
		if (yearCheck == false) {
			switch (monthCheck) {
			case 1:
				dayCheck = 31;
				break;
			case 2:
				dayCheck = 28;
				break;
			case 3:
				dayCheck = 31;
				break;
			case 4:
				dayCheck = 30;
				break;
			case 5:
				dayCheck = 31;
				break;
			case 6:
				dayCheck = 30;
				break;
			case 7:
				dayCheck = 31;
				break;
			case 8:
				dayCheck = 31;
				break;
			case 9:
				dayCheck = 30;
				break;
			case 10:
				dayCheck = 31;
				break;
			case 11:
				dayCheck = 30;
				break;
			case 12:
				dayCheck = 31;
				break;
			}// end switch
		} // end if

		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		int otherMonth = parseInt(sdf.format(new Date()));

		// 윤년 2월달은 29일
		if (yearCheck == true && (monthCheck) == 2) {
			dayCheck = 29;
		} // end if

		prc.getCbStartDay().removeAllItems();
		prc.getCbEndDay().removeAllItems();
		if (otherMonth == monthCheck && year == yearDate) {
			for (int i = day; i <= dayCheck; i++) {
				prc.getCbStartDay().addItem(valueOf(i));
				prc.getCbEndDay().addItem(valueOf(i));
			} // end for
		} else {
			for (int i = 1; i <= dayCheck; i++) {
				prc.getCbStartDay().addItem(valueOf(i));
				prc.getCbEndDay().addItem(valueOf(i));
			} // end for
		} // end else
	}// setDays

}// class
