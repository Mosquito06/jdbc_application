package kr.or.dgit.jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.SqlDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

public class EmployeeService {
	private SqlDao<Employee> empDao;
	private SqlDao<Department> deptDao;
	private SqlDao<Title> titleDao;
	
	public EmployeeService() {
		empDao = EmployeeDao.getInstance();
		deptDao = DepartmentDao.getInstance();
		titleDao = TitleDao.getInstance();
	}
	
	public void insertEmployee(Employee employee){
		try {
			empDao.insertItem(employee);
			showMessage("추가 완료");
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		
	}

	public void DeleteEmployee(Employee employee){
		try {
			empDao.deleteItem(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updataEmployee(Employee employee){
		try {
			empDao.updateItem(employee);
			showMessage("수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Employee selectEmployeeByNo(Employee employee){
		try {
			return empDao.selectItemByNo(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> selectEmployeeByAll(){
		try {
			return empDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Title selectTitleByNo(Title title){
		try {
			return titleDao.selectItemByNo(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Department selecteDepartmentByNo(Department dept){
		try {
			return deptDao.selectItemByNo(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Title> selectTitleByAll(){
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
	

