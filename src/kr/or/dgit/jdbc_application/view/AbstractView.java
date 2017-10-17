package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.list.AbstractList;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	protected AbstractContent pContent;
	protected AbstractList pList;
	private JButton btnOk;

	public AbstractView(String title) {
		setTitle(title);
		createService();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 700);
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
		pList.setPopupMenu(createPopupMenu());
		contentPane.add(pList, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popUpMenu = new JPopupMenu();
		JMenuItem delItem = new JMenuItem("����");
		JMenuItem updateItem = new JMenuItem("����");
		JMenuItem searchItem = new JMenuItem("�˻�");

		delItem.addActionListener(this);
		updateItem.addActionListener(this);
		searchItem.addActionListener(this);

		popUpMenu.add(delItem);
		popUpMenu.add(updateItem);
		popUpMenu.add(searchItem);

		return popUpMenu;
	}

	protected abstract void createService();

	protected abstract AbstractList createList();

	protected abstract AbstractContent createContent();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			if(e.getActionCommand().equals("�߰�")){
				btnOkActionPerformed(e);
			}
			if(e.getActionCommand().equals("����")){
				//���� ����
				// 1. pConent���� �Էµ� ����(DTO)�� ������
				Object item = pContent.getContent();
				
				// 2. �Էµ� DTO�� service�� �̿��ؼ� DB�� update
				updateContent(item);
				
				// 3. pList���� ����� ���� load
				pList.loadData();
				
				// 4. pContent �Էµ� ���� Clear
				pContent.clear();
				
				// 5. btn "����" -> "�߰�"
				btnOk.setText("�߰�");
				
			}
			if(e.getActionCommand().equals("Ȯ��")){
				// 1. pContent ������ clear
				pContent.clear();
				// 2. pContent ������ setEnable;
				pContent.setEnabled(true);
				// 3. btn Ȯ�� -> �߰�
				btnOk.setText("�߰�");
			}	
			
			
		}
		
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		
		if (e.getActionCommand().equals("����")) {
			// 1. ����Ʈ���� ���õ� Item�� ������
			Object item = pList.getSelectedItem();
			
			// 2. service���� delete �޼ҵ� ȣ��
			deleteContent(item);
		
			// 3. ���� �� ����� �ٽ� load
			pList.loadData();
			
		}
		
		if (e.getActionCommand().equals("����")) {
			// 1. ����Ʈ���� ���õ� Item�� ������
			Object item = pList.getSelectedItem();
			
			// 2. ������ Item�� pContent�� setContent() ȣ��;
			pContent.setContent(item);
			
			// 3. ��ư�� ���ڸ� �߰����� �������� ����
			btnOk.setText("����");
			
			
			
		}
		
		if (e.getActionCommand().equals("�˻�")) {
			// 1. ���̾�α� ���ڸ� ����� �����ȣ, �μ���ȣ, ��å��ȣ�� ������
						
			// 2. �ش��ϴ� ��ȣ�� service���� �˻��� content�� ������
			
			// 3. �˻��� content�� pContent.setContent()
			
			
			// 4. pContent setEnable(false);
			pContent.setEnabled(false);
			
			// 5. btn -> "Ȯ��"
			btnOk.setText("Ȯ��");
		}

	}

	
	protected void btnCancelActionPerformed(ActionEvent e) {
		pContent.clear();
	};

	protected void btnOkActionPerformed(ActionEvent e) {
		// 0. ���� üũ
		try {
			pContent.isEmptyCheck();
		} catch (Exception e1) {
			System.out.println(e1);
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return;
		}

		// 1. pContent���� �Էµ� ����(DTO)�� ������
		Object content = pContent.getContent();

		// 2. �Էµ� DTO�� service�� �̿��ؼ� DB�� insert
		insertContent(content);

		// 3. pList���� ����� ���� load
		pList.loadData();

		// 4. �߰� �� content Ŭ����
		pContent.clear();
	}

	protected abstract void insertContent(Object content);
	
	protected abstract void deleteContent(Object item);
	
	protected abstract void updateContent(Object item);

}
