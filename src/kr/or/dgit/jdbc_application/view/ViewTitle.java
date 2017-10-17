package kr.or.dgit.jdbc_application.view;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.TitleService;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {
	private TitleService service;
			
	public ViewTitle(String title) {
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Title> createContent() {
		AbstractContent<Title> pContent = new TitleContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new TitleService();
		
	}

	@Override
	protected void insertContent(Object content) {
		service.insertTitle((Title)content);
	}

	@Override
	protected void deleteContent(Object item) {
		service.DeleteTitle((Title)item);
		
	}

	@Override
	protected void updateContent(Object item) {
		service.updataTitle((Title)item);
		
	}

}
