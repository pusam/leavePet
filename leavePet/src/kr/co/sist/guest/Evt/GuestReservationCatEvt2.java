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
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

import kr.co.sist.guest.view.GuestReservationCat;

public class GuestReservationCatEvt2 implements ItemListener {

	private GuestReservationCat prc;
	private int year, month, day;
	private int startYearValue;
	private int startMonthValue;
	private int startDayValue;
	private int endYearValue;
	private int endMonthValue;
	private int endDayValue;
	private int lastDayValue;
	Calendar cal;
	String today = "";

	public GuestReservationCatEvt2(GuestReservationCat prc) {
		this.prc = prc;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		today = sdf.format(date);
		year = parseInt(today.substring(0, 4));
		month = parseInt(today.substring(4, 6));
		day = parseInt(today.substring(6, 8));

		this.cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		lastDayValue = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		setDate();

		this.startYearValue = parseInt(valueOf(prc.getCbStartYear().getSelectedItem()));
		this.startMonthValue = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem()));
		this.startDayValue = parseInt(valueOf(prc.getCbStartDay().getSelectedItem()));
		this.endYearValue = parseInt(valueOf(prc.getCbEndYear().getSelectedItem()));
		this.endMonthValue = parseInt(valueOf(prc.getCbEndYear().getSelectedItem()));
		this.endDayValue = parseInt(valueOf(prc.getCbEndYear().getSelectedItem()));

	}// GuestReservationCatEvt

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if (ie.getSource() == prc.getCbStartYear()) {
			this.startYearValue = parseInt(valueOf(prc.getCbStartYear().getSelectedItem()));
			changeStartMonth();
			changeStartYear();
		} // end if

		if (ie.getSource() == prc.getCbStartMonth()) {
			changeStartDay();
			changeEndMonth();
//			changeEndDay();
		} // end if
		
		if(ie.getSource() == prc.getCbStartDay()) {
			changeEndDay();
		}//end if
	
		if(ie.getSource() == prc.getCbEndYear()) {
			changeEndMonth();
		}//end if
		
		if(ie.getSource() == prc.getCbEndMonth()) {
			changeEndDay();
		}//end if
						
	}// actionPerformed

	/**
	 * 년도와 달 일 초기값 셋팅
	 */
	private void setDate() {
		prc.getCbStartYear().addItem(valueOf(year));
		prc.getCbStartYear().addItem(valueOf(year + 1));
		prc.getCbEndYear().addItem(valueOf(year));
		prc.getCbEndYear().addItem(valueOf(year + 1));

		for (int i = month; i < 13; i++) {
			prc.getCbStartMonth().addItem(valueOf(i));
			prc.getCbEndMonth().addItem(valueOf(i));
		} // end for

		for (int i = day; i <= lastDayValue; i++) {
			prc.getCbStartDay().addItem(valueOf(i));
			prc.getCbEndDay().addItem(valueOf(i));
		} // end for
	}// setDateYearMonth

	/**
	 *
	 */
	private void changeStartYear() {
		if (prc.getCbStartYear().getSelectedItem() != null) {
			this.startYearValue = parseInt(valueOf(prc.getCbStartYear().getSelectedItem()));
			prc.getCbEndYear().removeAllItems();
			if (startYearValue == year + 1) {
				prc.getCbEndYear().addItem(valueOf(year + 1));
			} else {
				prc.getCbEndYear().addItem(valueOf(year));
				prc.getCbEndYear().addItem(valueOf(year + 1));
			} // end else

		}

	}// changeDate

	/**
	 * 년 변경시 달 설정
	 */
	private void changeStartMonth() {
		if (prc.getCbStartMonth().getSelectedItem() != null) {
			prc.getCbStartMonth().removeAllItems();
		}
		if (year == startYearValue) {
			for (int i = month; i < 13; i++) {
				prc.getCbStartMonth().addItem(valueOf(i));
			} // end for
		} else {
			for (int i = 1; i < 13; i++) {
				prc.getCbStartMonth().addItem(valueOf(i));
			} // end for
		} // else if
	}// changeMonth

	/**
	 * 달 변경시 날짜 설정
	 */
	private void changeStartDay() {
		if (prc.getCbStartMonth().getSelectedItem() != null) {
			this.startMonthValue = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem()));
		} // end if

		if (prc.getCbStartMonth().getSelectedItem() != null) {
			prc.getCbStartDay().removeAllItems();
			prc.getCbEndDay().removeAllItems();
			this.cal.set(parseInt(valueOf(prc.getCbStartYear().getSelectedItem())),
					parseInt(valueOf(prc.getCbStartMonth().getSelectedItem())) - 1, day);
			this.lastDayValue = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			int startDay = 1;
			// 년도 달 별로 시작날짜 구하기
			if (year == startYearValue && month == startMonthValue) {
				startDay = day;
			}
			for (int i = startDay; i <= lastDayValue; i++) {
				prc.getCbStartDay().addItem(valueOf(i));
			} // end for
		} // end if
	}// changeDay

	private void changeEndMonth() {
		if (prc.getCbEndMonth().getSelectedItem() != null && prc.getCbStartMonth().getSelectedItem() != null) {
			prc.getCbEndMonth().removeAllItems();
			if(prc.getCbStartYear().getSelectedItem().equals(prc.getCbEndYear().getSelectedItem())) {
			for (int i = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem())); i < 13; i++) {
				prc.getCbEndMonth().addItem(valueOf(i));
			} // end for
			}else {
				for(int i=1; i<13; i++) {
					prc.getCbEndMonth().addItem(valueOf(i));
				}
			}
		} // end if
	}// changeEndMonth

	private void changeEndDay() {
		if (prc.getCbStartMonth().getSelectedItem() != null &&prc.getCbStartDay().getSelectedItem() != null) {
			this.cal.set(parseInt(valueOf(prc.getCbStartYear().getSelectedItem())),
					parseInt(valueOf(prc.getCbStartMonth().getSelectedItem())) - 1, day);
			this.lastDayValue = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			prc.getCbEndDay().removeAllItems();
			if(prc.getCbStartMonth().getSelectedItem().equals(prc.getCbEndMonth().getSelectedItem())) {
				for (int i = parseInt(valueOf(prc.getCbStartDay().getSelectedItem())); i <= lastDayValue; i++) {
					prc.getCbEndDay().addItem(valueOf(i));
				}//end for
			}else {//여기부터 다음에한다
				for (int i = 1; i <= lastDayValue; i++) {
					prc.getCbEndDay().addItem(valueOf(i));
				}//end for
			}

		}//end if
	}// changeEndDay

}// class
