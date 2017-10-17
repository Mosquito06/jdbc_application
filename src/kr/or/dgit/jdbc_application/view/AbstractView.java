package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.list.AbstractList;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	protected AbstractContent<?> pContent;
	protected AbstractList pList;
	private JButton btnOk;

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
		
		pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pBtn = new JPanel();
		pNorth.add(pBtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("\uCD94\uAC00");
		btnOk.addActionListener(this);
		pBtn.add(btnOk);
		
		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
		
		pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	protected abstract void createService();

	protected abstract AbstractList createList();

	protected abstract AbstractContent<?> createContent();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
	}
	
	protected void btnCancelActionPerformed(ActionEvent e){
		pContent.clear();
	};
	protected void btnOkActionPerformed(ActionEvent e) {
		// 0. 공백 체크
		try {
			pContent.isEmptyCheck();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return;
		}
		
		
		// 1. pContent에서 입력된 내용(DTO)를 가져옴
		Object content = pContent.getContent();
		
		// 2. 입력된 DTO를 service를 이용해서 DB에 insert
		insertContent(content);
		
		// 3. pList에서 목록을 새로 load
		pList.loadData();
		
		// 4. 추가 후 content 클리어
		pContent.clear();
	}

	protected abstract void insertContent(Object content);
}
