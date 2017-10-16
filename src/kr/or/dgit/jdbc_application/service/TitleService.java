package kr.or.dgit.jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.SqlDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Title;

public class TitleService {
	private SqlDao<Title> titleDao;

	public TitleService() {
		titleDao = TitleDao.getInstance();
	}
	
	public void insertTitle(Title title){
		try {
			titleDao.insertItem(title);
			showMessage("추가 완료");
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		
	}

	public void DeleteTitle(Title title){
		try {
			titleDao.deleteItem(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updataTitle(Title title){
		try {
			titleDao.updateItem(title);
			showMessage("수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Title selectTitleByNo(Title title){
		try {
			return titleDao.selectItemByNo(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Title> selectTitleByAll(){
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
