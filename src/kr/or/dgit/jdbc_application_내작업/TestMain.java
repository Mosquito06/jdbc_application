/*package kr.or.dgit.jdbc_application_내작업;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application.dao_내작업.DepartmentDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.jdbcUtil;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.EmployeeDao;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.TitleDao;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.common.ComboBoxComponent;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.common.SpinnerComponent;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.common.TextFieldComponent;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.content.DepartmentContent;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.content.EmployeeContent;
import kr.or.dgit.jdbc_application_내작업.dao_내작업.content.TitleContent;

public class TestMain {

	public static void main(String[] args) {
		// testDBCon();
		// testDepartmentDao();
		// testTitleDao();
		// testEmployeeDao();

		// testTestFieldComponent();
		// testDepartmentContent();

		// testTItleContent();
		
		// testComboBoxComponentTest();
		
		testEmployeeContent();
		
		SpinnerComponent tfc = new SpinnerComponent("테스트");
		tfc.setSpinnerValue(1000000);

		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getSpinnerValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}

			}
		});

		testContent(tfc, btn);
		
	}

	private static void testEmployeeContent() {
		EmployeeContent tfc = new EmployeeContent();
		//tfc.setContent(new Title(1, "아르바이트"));

		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getContent());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}

			}
		});

		testContent(tfc, btn);
	}

	private static void testComboBoxComponentTest() {
		ComboBoxComponent<Department> tfc = new ComboBoxComponent("테스트");
		DefaultComboBoxModel<Department> value = new DefaultComboBoxModel<>();
		value.addElement(new Department(1, "기획", 3));
		value.addElement(new Department(2, "마케팅", 3));
		value.addElement(new Department(3, "생산", 3));
		
		tfc.setComboValue(value);

		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getComboValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}

			}
		});

		testContent(tfc, btn);
	}

	private static void testTItleContent() {
		TitleContent tfc = new TitleContent();
		tfc.setContent(new Title(1, "아르바이트"));

		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getContent());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}

			}
		});

		testContent(tfc, btn);
	}

	private static void testDepartmentContent() {
		DepartmentContent tfc = new DepartmentContent();
		tfc.setContent(new Department(1, "개발", 10));

		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getContent());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}

			}
		});

		testContent(tfc, btn);
	}

	private static void testTestFieldComponent() {
		TextFieldComponent tfc = new TextFieldComponent("테스트");
		tfc.SetTextValue("재진");

		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getTextValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}

			}
		});

		testContent(tfc, btn);
	}

	private static void testContent(JPanel panel, JButton btn) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 500, 550);
		jf.add(panel);
		jf.add(btn, BorderLayout.SOUTH);
		jf.setVisible(true);
	}

	private static void testEmployeeDao() {
		Employee employee = new Employee(1007, "아이유", new Title(5), new Employee(1005), 1000000, new Department(5));

		testEmployeeInsert(employee);
		testEmployeeByAll();
		System.out.println("===============================");

		employee.setEmpName("이효리");
		testEmployeeUpdate(employee);
		testEmployeeByNo(employee);
		System.out.println("===============================");

		testEmployeeDelete(employee);
		testEmployeeByAll();
	}

	private static void testEmployeeUpdate(Employee employee) {
		try {
			EmployeeDao.getInstance().updateItem(employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testEmployeeInsert(Employee employee) {
		try {
			EmployeeDao.getInstance().insertItem(employee);
			JOptionPane.showMessageDialog(null, "사원이 추가되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "사원번호가 중복");
			}
		}
	}

	private static void testEmployeeDelete(Employee employee) {
		try {
			EmployeeDao.getInstance().deleteItem(employee);
			JOptionPane.showMessageDialog(null, "사원이 삭제되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제 실패");
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
		Title title = new Title(6, "아르바이트");

		testTitleInsert(title);
		testTitleAll();
		System.out.println("===============================");

		title.setTitleName("단기 아르바이트");
		testTitleUpdate(title);
		testTitleByNo(title);
		System.out.println("===============================");

		testTitleDelete(title);
		testTitleAll();

	}

	private static void testTitleDelete(Title title) {
		try {
			TitleDao.getInstance().deleteItem(title);
			JOptionPane.showMessageDialog(null, "직위가 삭제되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제 실패");
		}
	}

	private static void testTitleInsert(Title title) {
		try {
			TitleDao.getInstance().insertItem(title);
			JOptionPane.showMessageDialog(null, "직위가 추가되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "직위번호가 중복");
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
		Department dept = new Department(4, "마케팅", 10);

		testInsert(dept);
		testListAll();

		dept.setDeptName("마케팅2");
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
			JOptionPane.showMessageDialog(null, "부서가 삭제되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "삭제 실패");
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 추가되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "부서번호가 중복");
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
*/