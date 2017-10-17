package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;

public class ListEmployee extends AbstractList {
	private static final String[] COL_NAMES = { "사원번호", "사원명", "직책", "관리자", "급여", "부서" };
	private EmployeeService service;

	public ListEmployee(EmployeeService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);
		setAlign(SwingConstants.RIGHT, 4);
		setCellWidth(100, 100, 100, 100, 200, 100);

	}

	@Override
	protected Object[][] getData() {
		List<Employee> lists = service.selectEmployeeByAll();
		
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			Employee emp = lists.get(i);
			datas[i] = emp.toArray();
			datas[i][2] = getTitle(emp.getTitle());
			datas[i][3] = getManager(emp.getManager());
			datas[i][4] = String.format("%,d", datas[i][4]);
			datas[i][5] = getDno(emp.getDno());
		}

		return datas;
	}

	private Object getDno(Department dno) {
		return service.selecteDepartmentByNo(dno).getDeptName();
	}

	private Object getManager(Employee manager) {
		Employee emp = (Employee) service.selectEmployeeByNo(manager);
		if(emp == null){
			return String.format("%s", "");
		}
		return String.format("%s(%s)", emp.getEmpName(), emp.getEmpNo());
			
	}

	private Object getTitle(Title title) {
		return service.selectTitleByNo(title).getTitleName();
	}

	@Override
	protected String[] getColumnNames() {
		return COL_NAMES;
	}

	@Override
	public Object getSelectedItem() {
		int seletedIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(seletedIndex, 0);
		return service.selectEmployeeByNo(new Employee(empNo));
	}

}
