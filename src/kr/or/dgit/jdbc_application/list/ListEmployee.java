package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Employee;

public class ListEmployee extends AbstractList {
	private static final String[] COL_NAMES = {"�����ȣ", "�����", "��å", "������", "�޿�", "�μ�"};
	
	
	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);
		setAlign(SwingConstants.RIGHT, 4);
		setCellWidth(100, 100, 100, 100, 200, 100);

	}

	@Override
	protected Object[][] getData() {
		Object[][] data = {
				{1, "������", 1, 3, 150000, "��ȹ"},
				{2, "��ȿ��", 2, 2, 550000, "��ȹ"},
				{3, "����", 3, 1, 350000, "��ȹ"}};  
		return data;
	}

	@Override
	protected String[] getColumnNames() {
		return COL_NAMES;
	}

	@Override
	public Object getSelectedItem() {
				
		return null;
	}

}
