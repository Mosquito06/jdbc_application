package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.service.DepartmentService;

public class ViewDepartment extends AbstractView {

	public ViewDepartment(String title) {
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		DepartmentService ds = new DepartmentService();
		ListDepartment pList = new ListDepartment(ds);
		return pList;
	}

	@Override
	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}

}
