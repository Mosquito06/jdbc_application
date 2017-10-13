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

	
	// �߻� Ŭ�������� �����ϰ� �ֱ� ������ �ּ� ó��
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

		// ������ ���̺��� ���ΰ�ħ �� ������ ��������� �ϱ� ������ �����͸� �ҷ����� �Լ��� ���� �������� �������ִ� ���� ����
		setAlignWidth();

	}*/
	
	
	// �߻� Ŭ������ �߻� �޼ҵ� ����
	@Override
	protected void setAlignWidth() {
		// ���� �����ϴ� ���� ���ڸ� ���� �Լ�
		setCellWidth(100, 150, 50);

		// ������ �����ϴ� ���� ���ڸ� ���� �Լ�
		setAlign(SwingConstants.CENTER, 0, 2);
		setAlign(SwingConstants.RIGHT, 1);
	}

	
	// �߻� Ŭ�������� �����ϰ� �ֱ� ������ �ּ� ó��
	/*private void setWith(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	private void setAlign(int align, int... idx) {
		// ��� ������ ���� ��ɹ�
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		// ��� ������ �����ϴ� �Ӽ��� �����ϴ� ��ɹ�
		TableColumnModel cModel = table.getColumnModel();

		// idx = [ 0, 2]�� �迭
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}*/
	
	
	// �߻� Ŭ������ �߻� �޼ҵ� ����
	@Override
	protected Object[][] getData() {
		Object[][] datas = { { 1, "����", 10 }, { 2, "�λ�", 20 }, { 3, "������", 30 } };

		return datas;
	}
	
	
	// �߻� Ŭ������ �߻� �޼ҵ� ����
	@Override
	protected String[] getColumnNames() {
		return new String[] { "�μ���ȣ", "�μ���", "��ġ" };
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
