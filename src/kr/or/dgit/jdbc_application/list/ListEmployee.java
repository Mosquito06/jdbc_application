package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Employee;

public class ListEmployee extends AbstractList {
	private static final String[] COL_NAMES = {"사원번호", "사원명", "직책", "관리자", "급여", "부서"};
	
	
	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1, 2, 3, 5);
		setAlign(SwingConstants.RIGHT, 4);
		setCellWidth(100, 100, 100, 100, 200, 100);

	}

	@Override
	protected Object[][] getData() {
		Object[][] data = {
				{1, "아이유", 1, 3, 150000, "기획"},
				{2, "이효리", 2, 2, 550000, "기획"},
				{3, "김상순", 3, 1, 350000, "기획"}};  
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
