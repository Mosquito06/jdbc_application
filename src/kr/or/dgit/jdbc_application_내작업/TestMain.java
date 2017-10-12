/*package kr.or.dgit.jdbc_application_���۾�;

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

import kr.or.dgit.jdbc_application.dao_���۾�.DepartmentDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.jdbc.jdbcUtil;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.EmployeeDao;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.TitleDao;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.common.ComboBoxComponent;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.common.SpinnerComponent;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.common.TextFieldComponent;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.content.DepartmentContent;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.content.EmployeeContent;
import kr.or.dgit.jdbc_application_���۾�.dao_���۾�.content.TitleContent;

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
		
		SpinnerComponent tfc = new SpinnerComponent("�׽�Ʈ");
		tfc.setSpinnerValue(1000000);

		JButton btn = new JButton("�׽�Ʈ");
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
		//tfc.setContent(new Title(1, "�Ƹ�����Ʈ"));

		JButton btn = new JButton("�׽�Ʈ");
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
		ComboBoxComponent<Department> tfc = new ComboBoxComponent("�׽�Ʈ");
		DefaultComboBoxModel<Department> value = new DefaultComboBoxModel<>();
		value.addElement(new Department(1, "��ȹ", 3));
		value.addElement(new Department(2, "������", 3));
		value.addElement(new Department(3, "����", 3));
		
		tfc.setComboValue(value);

		JButton btn = new JButton("�׽�Ʈ");
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
		tfc.setContent(new Title(1, "�Ƹ�����Ʈ"));

		JButton btn = new JButton("�׽�Ʈ");
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
		tfc.setContent(new Department(1, "����", 10));

		JButton btn = new JButton("�׽�Ʈ");
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
		TextFieldComponent tfc = new TextFieldComponent("�׽�Ʈ");
		tfc.SetTextValue("����");

		JButton btn = new JButton("�׽�Ʈ");
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
		Employee employee = new Employee(1007, "������", new Title(5), new Employee(1005), 1000000, new Department(5));

		testEmployeeInsert(employee);
		testEmployeeByAll();
		System.out.println("===============================");

		employee.setEmpName("��ȿ��");
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
			JOptionPane.showMessageDialog(null, "����� �߰��Ǿ����ϴ�");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� �ߺ�");
			}
		}
	}

	private static void testEmployeeDelete(Employee employee) {
		try {
			EmployeeDao.getInstance().deleteItem(employee);
			JOptionPane.showMessageDialog(null, "����� �����Ǿ����ϴ�");
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
		System.out.println("===============================");

		title.setTitleName("�ܱ� �Ƹ�����Ʈ");
		testTitleUpdate(title);
		testTitleByNo(title);
		System.out.println("===============================");

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
*/