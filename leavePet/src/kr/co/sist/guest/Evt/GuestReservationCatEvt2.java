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
	String today="";

	public GuestReservationCatEvt2(GuestReservationCat prc) {
		this.prc = prc;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		today = sdf.format(date);
		year = parseInt(today.substring(0, 4));
		month = parseInt(today.substring(4, 6));
		day = parseInt(today.substring(6, 8));
		
		this.cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		lastDayValue=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		setDate();
		
		
		this.startMonthValue = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem()));
		this.startDayValue = parseInt(valueOf(prc.getCbStartDay().getSelectedItem()));
		this.endYearValue = parseInt(valueOf(prc.getCbEndYear().getSelectedItem()));
		this.endMonthValue = parseInt(valueOf(prc.getCbEndYear().getSelectedItem()));
		this.endDayValue = parseInt(valueOf(prc.getCbEndYear().getSelectedItem()));
		
	}// GuestReservationCatEvt

	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==prc.getCbStartYear()) {
//			this.startYearValue = parseInt(valueOf(prc.getCbStartYear().getSelectedItem()));
//			this.startMonthValue = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem()));
			changeDate();
		}//end if
		
		if(ie.getSource()==prc.getCbStartMonth()) {
//			this.startYearValue = parseInt(valueOf(prc.getCbStartYear().getSelectedItem()));
//			this.startMonthValue = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem()));
			changeDate();
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
		
		for(int i=month; i<13; i++) {
			prc.getCbStartMonth().addItem(valueOf(i));
			prc.getCbEndMonth().addItem(valueOf(i));
		}//end for
		
		for(int i=day; i<=lastDayValue; i++) {
			prc.getCbStartDay().addItem(valueOf(i));
			prc.getCbEndDay().addItem(valueOf(i));
		}//end for
	}// setDateYearMonth

	private void changeDate() {
		if(prc.getCbStartYear().getSelectedItem()!=null && prc.getCbStartMonth().getSelectedItem()!=null) {
		this.startYearValue = parseInt(valueOf(prc.getCbStartYear().getSelectedItem()));
		this.startMonthValue = parseInt(valueOf(prc.getCbStartMonth().getSelectedItem()));
		}
		cal.set(startYearValue, 2-1, day);
		this.lastDayValue=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		if(year==startYearValue) {
		}else {
			if(prc.getCbStartMonth()!=null) {
			prc.getCbStartMonth().removeAllItems();
			}
			for(int i=1; i<13; i++ ) {
				prc.getCbStartMonth().addItem(valueOf(i));
			}//end for
			prc.getCbStartDay().removeAllItems();
			for(int i=1; i<lastDayValue; i++) {
				prc.getCbStartDay().addItem(valueOf(i));
			}
		}//else if
	}//changeDate

}// class
