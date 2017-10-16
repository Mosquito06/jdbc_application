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

public abstract class AbstractList extends JPanel {
	protected JTable table;

	public AbstractList() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		// loadData();

	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel(getData(), getColumnNames());
		table.setModel(model);

		// 정렬은 테이블이 새로고침 될 때마다 수행해줘야 하기 때문에 데이터를 불러오는 함수의 제일 마지막에 수행해주는 것이 좋음
		setAlignWidth();

	}

	protected abstract void setAlignWidth();

	protected void setCellWidth(int... width) {
		TableColumnModel cModel = table.getColumnModel();

		for (int i = 0; i < width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	protected void setAlign(int align, int... idx) {
		// 0번 컬럼을 정렬(left, right, center)

		// 가운데 정렬을 위한 명령문
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		// 가운데 정렬을 적용하는 속성을 지정하는 명령문
		TableColumnModel cModel = table.getColumnModel();

		// idx = [ 0, 2]의 배열
		for (int i = 0; i < idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

	protected abstract Object[][] getData(); 

	protected abstract String[] getColumnNames();
	
	public abstract Object getSelectedItem();

}
