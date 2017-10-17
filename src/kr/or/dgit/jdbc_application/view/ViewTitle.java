package kr.or.dgit.jdbc_application.view;

import java.awt.event.ActionEvent;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.TitleService;

public class ViewTitle extends AbstractView {
	private TitleService service;
		
	public ViewTitle(String title) {
		super(title);
	}
	
	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}

	@Override
	protected AbstractContent<Title> createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new TitleService();
		
	}

}
