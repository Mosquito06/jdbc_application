package kr.or.dgit.jdbc_application.list;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.jdbc_application.dto.Department;

public class ListDepartment extends AbstractList {

	
	// 추상 클래스에서 정의하고 있기 때문에 주석 처리
	/*private JTable table;

	public ListDepartment() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		loadData();

	}

	private void loadData() {
		DefaultTableModel model = new DefaultTableModel(getData(), getColumnNames());
		table.setModel(model);

		// 정렬은 테이블이 새로고침 될 때마다 수행해줘야 하기 때문에 데이터를 불러오는 함수의 제일 마지막에 수행해주는 것이 좋음
		setAlignWidth();

	}*/
	
	
	// 추상 클래스의 추상 메소드 구현
	@Override
	protected void setAlignWidth() {
		// 폭을 조절하는 가변 인자를 가진 함수
		setCellWidth(100, 150, 50);

		// 정렬을 조절하는 가변 인자를 가진 함수
		setAlign(SwingConstants.CENTER, 0, 2);
		setAlign(SwingConstants.RIGHT, 1);
	}

	
	// 추상 클래스에서 정의하고 있기 때문에 주석 처리
	/*private void setWith(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	private void setAlign(int align, int... idx) {
		// 가운데 정렬을 위한 명령문
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		// 가운데 정렬을 적용하는 속성을 지정하는 명령문
		TableColumnModel cModel = table.getColumnModel();

		// idx = [ 0, 2]의 배열
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}*/
	
	
	// 추상 클래스의 추상 메소드 구현
	@Override
	protected Object[][] getData() {
		Object[][] datas = { { 1, "개발", 10 }, { 2, "인사", 20 }, { 3, "마케팅", 30 } };

		return datas;
	}
	
	
	// 추상 클래스의 추상 메소드 구현
	@Override
	protected String[] getColumnNames() {
		return new String[] { "부서번호", "부서명", "위치" };
	}


	@Override
	public Object getSelectedItem() {
		int selectedIndex = table.getSelectedRow(); 
		int deptNo = (int) table.getValueAt(selectedIndex, 0);
		String deptName = (String) table.getValueAt(selectedIndex, 1);
		int floor = (int) table.getValueAt(selectedIndex, 2);
		
		return new Department(deptNo, deptName, floor);
	}

}
