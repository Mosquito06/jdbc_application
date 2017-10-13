package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

public class ListTitle extends AbstractList {
	private static final String[] COL_NAMES = {"��å ��ȣ", "��å ��"};
	
	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1);
		setCellWidth(100, 100);

	}

	@Override
	protected Object[][] getData() {
		Object[][] data = {{1, "����"}, {2, "����"}};		
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
