package kr.co.sist.guest.view;

import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import kr.co.sist.guest.Evt.QNAEvt;
import kr.co.sist.guest.vo.QNAVO;

public class QNA extends JFrame {
	
	private JLabel lblQText, lblQAnswer;
	private JTextArea taQText, taQAnswer; 

	public QNA() {
		
		lblQText = new JLabel("고객 문의 내역 상세");
		lblQAnswer= new JLabel("답변 내역");
		taQText = new JTextArea();
		taQAnswer = new JTextArea();
		
		lblQText.setBorder(new TitledBorder(""));
		lblQAnswer.setBorder(new TitledBorder(""));
		
		
		lblQText.setBounds(10, 10, 420, 30);
		taQText.setBounds(10, 50, 420, 240);
		lblQAnswer.setBounds(10, 300, 420, 30);
		taQAnswer.setBounds(10, 340, 420, 240);
		
		add(lblQText);
		add(taQText);
		add(lblQAnswer);
		add(taQAnswer);
		
		QNAEvt qnae = new QNAEvt(this);
		qnae.requestSelect();
		
		setResizable(false);
		setLayout(null);
		setBounds(600, 200, 450, 620);
		setVisible(true);		
		
	}// GuestInquirydetailsCheck

	public JTextArea getTaQText() {
		return taQText;
	}

	public JTextArea getTaQAnswer() {
		return taQAnswer;
	}
	
}// class
