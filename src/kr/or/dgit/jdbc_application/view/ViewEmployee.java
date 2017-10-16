package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application.service.EmployeeService;

public class ViewEmployee extends AbstractView {

	public ViewEmployee(String title) {
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		EmployeeService es = new EmployeeService();
		ListEmployee pList = new ListEmployee(es);
		return pList;
	}

	@Override
	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent();
		return pContent;
	}

}
