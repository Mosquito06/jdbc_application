package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;

public abstract class AbstractView extends JFrame {

	private JPanel contentPane;

	public AbstractView(String title) {
		setTitle(title);
		createService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pBtn = new JPanel();
		pNorth.add(pBtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("\uCD94\uAC00");
		pBtn.add(btnOk);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		pBtn.add(btnCancel);
		
		AbstractList pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	protected abstract void createService();

	protected abstract AbstractList createList();

	protected abstract JPanel createContent();

}
