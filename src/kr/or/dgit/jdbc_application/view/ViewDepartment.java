package kr.or.dgit.jdbc_application.view;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.service.DepartmentService;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	
	public ViewDepartment(String title) {
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}

	
	@Override
	protected AbstractContent<Department> createContent() {
		AbstractContent<Department> pContent = new DepartmentContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();
		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertDepartment((Department)content);
		
	}

	@Override
	protected void deleteContent(Object item) {
		service.deleteDepartment((Department)item);
		
	}

	@Override
	protected void updateContent(Object item) {
		service.updateDepartment((Department)item);
		
	}

	@Override
	protected String setTitle() {
		return "ºÎ¼­";
	}

	@Override
	protected Object selectContent(Object id) {
		return service.selecteDepartmentByNo((Department)id);
	}

	@Override
	protected Object createObject(int id) {
		return new Department(id);
	}

}
