package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;

@SuppressWarnings("serial")
public class DepartmentContent extends AbstractContent<Department> {

	private TextFieldComponent pDeptNo;
	private TextFieldComponent pDeptName;
	private TextFieldComponent pFloor;
	
	public DepartmentContent() {
		setLayout(new GridLayout(0, 1, 0, 10));

		pDeptNo = new TextFieldComponent("부서 번호");
		add(pDeptNo);

		pDeptName = new TextFieldComponent("부서 명");
		add(pDeptName);

		pFloor = new TextFieldComponent("위치");
		add(pFloor);
	}
	
	@Override
	public Department getContent() {
		int deptNo = Integer.parseInt(pDeptNo.getTextValue());
		String deptName = pDeptName.getTextValue();
		int floor = Integer.parseInt(pFloor.getTextValue());
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public void setContent(Department department) {
		pDeptNo.setTextValue(department.getDeptNo() + "");
		pDeptName.setTextValue(department.getDeptName());
		pFloor.setTextValue(department.getFloor() + "");
	}
	
	@Override
	public void isEmptyCheck() throws Exception {
		pDeptNo.isEmptyCheck();
		pDeptName.isEmptyCheck();
		pFloor.isEmptyCheck();
	}

	@Override
	public void clear() {
		pDeptNo.setTextValue("");
		pDeptName.setTextValue("");
		pFloor.setTextValue("");

	}

	@Override
	public void contentEnable(boolean tf) {
		if(tf == false){
			pDeptNo.setEnable(false);
			pDeptName.setEnable(false);
			pFloor.setEnable(false);
		}else{
			pDeptNo.setEnable(true);
			pDeptName.setEnable(true);
			pFloor.setEnable(true);
		}
		
		
	}
}
