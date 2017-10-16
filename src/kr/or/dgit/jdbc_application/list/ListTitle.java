package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.TitleService;

public class ListTitle extends AbstractList {
	private static final String[] COL_NAMES = { "직책 번호", "직책 명" };
	private TitleService service;

	public ListTitle(TitleService service) {
		this.service = service;
	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0, 1);
		setCellWidth(100, 100);

	}

	@Override
	protected Object[][] getData() {
		List<Title> lists = service.selectTitleByAll();
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			datas[i] = lists.get(i).toArray();
		}

		return datas;
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
