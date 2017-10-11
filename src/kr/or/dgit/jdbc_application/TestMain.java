package kr.or.dgit.jdbc_application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.jdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		//testDBCon();
		
		Department dept = new Department(4, "������", 10);
		
		testInsert(dept);
		testListAll();
		
		dept.setDeptName("������2");
		testUpdate(dept);
		testDeptNo(dept);
		
		testDelete(dept);
		testListAll();
		
		
	}

	private static void testUpdate(Department dept) {
		try {
			DepartmentDao.getInstance().updateItem(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private static void testDeptNo(Department dept) {
		try {
			Department SerchDept = DepartmentDao.getInstance().selectItemByNo(dept);
			System.out.println(dept);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	private static void testListAll() {
		try {
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			for(Department dept : lists){
				System.out.println(dept);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	private static void testDelete(Department dept) {
		try {
			DepartmentDao.getInstance().deleteItem(dept);
			JOptionPane.showMessageDialog(null, "�μ��� �����Ǿ����ϴ�");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "���� ����");
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "�μ��� �߰��Ǿ����ϴ�");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �ߺ�");
			}
		}
	}

	private static void testDBCon() {
		DBCon dbCon = DBCon.getInstance();
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);

		jdbcUtil.close(connection);
	}

}
