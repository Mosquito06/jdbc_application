package kr.or.dgit.jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class TitleDao implements SqlDao<Title> {
	private static final TitleDao instance = new TitleDao();

	public static TitleDao getInstance() {
		return instance;
	}

	private TitleDao() {

	}

	@Override
	public void insertItem(Title item) throws SQLException {
		String sql = "insert into title values(?,?)";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getTitle());
			pstmt.setString(2, item.getTitleName());
			pstmt.executeUpdate();

		}
	}

	@Override
	public void deleteItem(Title item) throws SQLException {
		String sql = "delete from title where titleno = ?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getTitle());
			pstmt.executeUpdate();

		}

	}

	@Override
	public void updateItem(Title item) throws SQLException {
		String sql = "update title set titlename = ? where titleno = ?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, item.getTitleName());
			pstmt.setInt(2, item.getTitle());
			pstmt.executeUpdate();

		}

	}

	@Override
	public Title selectItemByNo(Title item) throws SQLException {
		String sql = "select titleno, titlename from title where titleno =?";
		Connection con = DBCon.getInstance().getConnection();
		Title title = null;

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getTitle());

			// ResultSet 다음에 setInt 문이 있으면 setInt가 되지 않기 때문에 try문을 두 번 사용하여
			// executeQuery 문을 뒤로 뺌
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					title = getTitle(rs);
				}
			}

		}

		return title;

	}

	@Override
	public List<Title> selectItemByAll() throws SQLException {
		String sql = "select titleno, titlename from title";
		Connection con = DBCon.getInstance().getConnection();
		List<Title> lists = new ArrayList<>();

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				lists.add(getTitle(rs));
			}
		}

		return lists;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int title = rs.getInt(1);
		String titleName = rs.getString(2);
		return new Title(title, titleName);
	}

}
