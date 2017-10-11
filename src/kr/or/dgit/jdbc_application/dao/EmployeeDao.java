package kr.or.dgit.jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class EmployeeDao implements SqlDao<Employee> {
	private static final EmployeeDao instance = new EmployeeDao();

	public static EmployeeDao getInstance() {
		return instance;
	}

	private EmployeeDao() {

	}

	@Override
	public void insertItem(Employee item) throws SQLException {
		String sql = "insert into employee values(?,?,?,?,?,?)";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getEmpNo());
			pstmt.setString(2, item.getEmpName());
			pstmt.setString(3, item.getTitle().getTitleName());
			pstmt.setString(4, item.getManager().getEmpName());
			pstmt.setInt(5, item.getSalary());
			pstmt.setInt(6, item.getDno().getDeptNo());
			pstmt.executeUpdate();
			
		}

	}

	@Override
	public void deleteItem(Employee item) throws SQLException {
		String sql = "delete from employee where empno = ?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getEmpNo());
			pstmt.executeUpdate();

		}

	}

	@Override
	public void updateItem(Employee item) throws SQLException {
		String sql = "update employee set empname = ?, title = ?, manager = ?, salary = ?, dno = ? from employee where empno =?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, item.getEmpName());
			pstmt.setString(2, item.getTitle().getTitleName());
			pstmt.setString(3, item.getManager().getEmpName());
			pstmt.setInt(4, item.getSalary());
			pstmt.setInt(5, item.getDno().getDeptNo());
			pstmt.setInt(6, item.getEmpNo());
			
			pstmt.executeUpdate();

		}

	}

	@Override
	public Employee selectItemByNo(Employee item) throws SQLException {
		String sql = "select empno, empname, title, manager, salary, dno from employee where empno =?";
		Connection con = DBCon.getInstance().getConnection();
		Employee employee = null;

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getEmpNo());

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					employee = getEmployee(rs);
				}
			}

		}

		return employee;
	}

	@Override
	public List<Employee> selectItemByAll() throws SQLException {
		String sql = "select empno, empname, title, manager, salary, dno from employee";
		Connection con = DBCon.getInstance().getConnection();
		List<Employee> lists = new ArrayList<>();

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getEmployee(rs));
			}
		}

		return lists;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt(1);
		String empName = rs.getString(2);
		Title title = new Title(rs.getString(3));
		Employee manager = new Employee(rs.getString(4));
		int salary = rs.getInt(5);
		Department dno = new Department(rs.getString(6));
		return new Employee(empNo, empName, title, manager, salary, dno);
	}

}
