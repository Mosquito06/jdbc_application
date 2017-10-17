package kr.or.dgit.jdbc_application.view;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application.service.EmployeeService;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {
	private EmployeeService service;
		
	public ViewEmployee(String title) {
		super(title);
		
	}
	
	@Override
	protected AbstractList createList() {
		pList = new ListEmployee(service);
		pList.loadData();
		return pList;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(service);
		return (AbstractContent<Employee>) pContent;
	}

	@Override
	protected void createService() {
		service = new EmployeeService();
		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertEmployee((Employee)content);
		
	}

}
