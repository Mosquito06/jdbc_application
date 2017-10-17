package kr.or.dgit.jdbc_application.view;

import java.awt.event.ActionEvent;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application.service.EmployeeService;

public class ViewEmployee extends AbstractView {
	private EmployeeService service;
	
	public ViewEmployee(String title) {
		super(title);
		
	}
	
	@Override
	protected AbstractList createList() {
		ListEmployee pList = new ListEmployee(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Employee> createContent() {
		EmployeeContent pContent = new EmployeeContent(service);
		return pContent;
	}

	@Override
	protected void createService() {
		service = new EmployeeService();
		
	}

}
