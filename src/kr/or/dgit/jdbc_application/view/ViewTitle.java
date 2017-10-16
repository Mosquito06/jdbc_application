package kr.or.dgit.jdbc_application.view;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.TitleService;

public class ViewTitle extends AbstractView {

	public ViewTitle(String title) {
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		TitleService ts = new TitleService();
		ListTitle pList = new ListTitle(ts);
		return pList;
	}

	@Override
	protected JPanel createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}

}
