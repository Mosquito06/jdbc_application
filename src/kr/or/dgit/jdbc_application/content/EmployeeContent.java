package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import kr.or.dgit.jdbc_application.common.ComboComponent;
import kr.or.dgit.jdbc_application.common.SpinnerComponent;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EmployeeContent extends AbstractContent<Employee> {

	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboComponent<Department> pDno;
	private ComboComponent<Employee> pManager;
	private SpinnerComponent pSalary;
	private ComboComponent<Title> pTitle;
	private EmployeeService service;
	
	
	public EmployeeContent(EmployeeService service) {
		this.service = service;
		
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원 번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("사원 명");
		add(pEmpName);
		
		pDno = new ComboComponent<>("부서");
		pDno.getCombo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setManagerByDno(service);	
			}
		});
		add(pDno);
				
		pManager = new ComboComponent<>("관리자");
		add(pManager);
		
		pSalary = new SpinnerComponent("급여");
		pSalary.setDefaultValue(1500000, 1000000, 5000000, 100000);
		add(pSalary);
		
		pTitle = new ComboComponent<>("직책");
		add(pTitle);
		
		setDepartModel();
		setTitleModel();
		setManagerModel();
	}
	
	private void setManagerByDno(EmployeeService service) {
		Department dept = pDno.getSelectedItem();
		Employee ceo = new Employee(4377);
		
		List<Employee> lists = service.selectEmployeeByDno(dept);
		if (!lists.contains(ceo)){
			lists.add(service.selectEmployeeByNo(new Employee(4377)));
		}
		Vector<Employee> manager = new Vector<>(lists);
		pManager.setComboBoxModel(manager);
	}

	private void setManagerModel() {
		List<Employee> lists = service.selectEmployeeByAll();
		Vector<Employee> manager = new Vector<>(lists);
		pManager.setComboBoxModel(manager);	
	}

	private void setTitleModel() {
		List<Title> lists = service.selectTitleByAll();
		Vector<Title> titles = new Vector<>(lists);
		pTitle.setComboBoxModel(titles);		
	}

	public void setDepartModel(){
		List<Department> lists = service.selectDepartmentByAll();
		Vector<Department> depart = new Vector<>(lists);
		pDno.setComboBoxModel(depart);
	}
	
	@Override
	public Employee getContent(){
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = pManager.getSelectedItem();
		int salary = pSalary.getSpinValue();
		Department dno = pDno.getSelectedItem();
		return new Employee(empNo, empName, title, manager, salary, dno);
	}
	
	@Override
	public void setContent(Employee employee){
		pEmpNo.setTextValue(employee.getEmpNo()+"");
		pEmpName.setTextValue(employee.getEmpName());
		pDno.setSelectedItem(employee.getDno());
		pManager.setSelectedItem(employee.getManager());
		pSalary.setSpinValue(employee.getSalary());
		pTitle.setSelectedItem(employee.getTitle());
	}
	
	@Override
	public void isEmptyCheck() throws Exception {
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		pDno.isEmptyCheck();
		pManager.isEmptyCheck();
		pSalary.isEmptyCheck();
		pTitle.isEmptyCheck();
	}

	@Override
	public void clear() {
		pEmpNo.setTextValue("");
		pEmpName.setTextValue("");
		pDno.setSelectedIndex(0);
		pManager.setSelectedIndex(0);
		pSalary.setSpinValue(1500000);
		pTitle.setSelectedIndex(0);
		
	}

	@Override
	public void contentEnable(boolean tf) {
		if(tf == false){
			pEmpNo.setEnable(false);
			pEmpName.setEnable(false);
			pDno.setEnable(false);
			pManager.setEnable(false);
			pSalary.setEnable(false);
			pTitle.setEnable(false);
		}else{
			pEmpNo.setEnable(true);
			pEmpName.setEnable(true);
			pDno.setEnable(true);
			pManager.setEnable(true);
			pSalary.setEnable(true);
			pTitle.setEnable(true);
		}
		
		
	}
}