package kr.or.dgit.jdbc_application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.jdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		// testDBCon();

		// testDepartmentDao();

		// testTitleDao();
		
		Employee employee = null;
		employee = new Employee(1007, "������", new Title(6), new Employee(1006), 1000000, new Department(1));
			
		
		
		/*try {
			EmployeeDao.getInstance().insertItem(employee);
			JOptionPane.showMessageDialog(null, "������ �߰��Ǿ����ϴ�");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "������ȣ�� �ߺ�");
			}
		}*/
		
		testEmployeeByAll();
		
		
		// testEmployeeDelete(employee);
		
		// testEmployeeByNo(employee);
		
		// testEmployeeByAll();
		
	}

	private static void testEmployeeDelete(Employee employee) {
		try {
			EmployeeDao.getInstance().deleteItem(employee);
			JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "���� ����");
		}
	}

	private static void testEmployeeByAll() {
		try {
			List<Employee> lists = EmployeeDao.getInstance().selectItemByAll();
			for (Employee e : lists) {
				System.out.println(e);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private static void testEmployeeByNo(Employee employee) {
		try {
			Employee SearchEmployee = EmployeeDao.getInstance().selectItemByNo(employee);
			System.out.println(SearchEmployee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testTitleDao() {
		Title title = new Title(6, "�Ƹ�����Ʈ");
		
		testTitleInsert(title);
		testTitleAll();
		
		title.setTitleName("�ܱ� �Ƹ�����Ʈ");
		testTitleUpdate(title);
		testTitleByNo(title);
		
		testTitleDelete(title);
		testTitleAll();
	}

	private static void testTitleDelete(Title title) {
		try {
			TitleDao.getInstance().deleteItem(title);
			JOptionPane.showMessageDialog(null, "������ �����Ǿ����ϴ�");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "���� ����");
		}
	}

	private static void testTitleInsert(Title title) {
		try {
			TitleDao.getInstance().insertItem(title);
			JOptionPane.showMessageDialog(null, "������ �߰��Ǿ����ϴ�");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "������ȣ�� �ߺ�");
			}
		}
	}

	private static void testTitleUpdate(Title title) {
		try {
			TitleDao.getInstance().updateItem(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testTitleByNo(Title title) {
		try {
			Title SerchTitle = TitleDao.getInstance().selectItemByNo(title);
			System.out.println(SerchTitle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testTitleAll() {
		try {
			List<Title> lists = TitleDao.getInstance().selectItemByAll();
			for (Title t : lists) {
				System.out.println(t);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private static void testDepartmentDao() {
		Department dept = new Department(4, "������", 10);

		testInsert(dept);
		testListAll();

		dept.setDeptName("������2");
		testUpdate(dept);
		testListAll();
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
			for (Department dept : lists) {
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
			if (e.getErrorCode() == 1062) {
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
