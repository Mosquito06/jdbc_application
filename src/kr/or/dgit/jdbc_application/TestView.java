package kr.or.dgit.jdbc_application;

import java.awt.EventQueue;

import kr.or.dgit.jdbc_application.view.AbstractView;
import kr.or.dgit.jdbc_application.view.ViewDepartment;
import kr.or.dgit.jdbc_application.view.ViewEmployee;
import kr.or.dgit.jdbc_application.view.ViewTitle;

public class TestView {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractView frame1 = new ViewDepartment("�μ�����");
					frame1.setVisible(true);
								
					AbstractView frame2 = new ViewTitle("��å����");
					frame2.setVisible(true);
					
					AbstractView frame3 = new ViewEmployee("�������");
					frame3.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
