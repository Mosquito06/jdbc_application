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
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.list.AbstractList;

@SuppressWarnings("serial")
public abstract class AbstractView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCancel;
	protected AbstractContent pContent;
	protected AbstractList pList;
	private JButton btnOk;
	protected String Title;

	public AbstractView(String title) {
		setTitle(title);
		createService();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Title = setTitle();
		
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
		JMenuItem delItem = new JMenuItem("삭제");
		JMenuItem updateItem = new JMenuItem("수정");
		JMenuItem searchItem = new JMenuItem("검색");

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
			if(e.getActionCommand().equals("추가")){
				btnOkActionPerformed(e);
			}
			if(e.getActionCommand().equals("수정")){
				//실제 수정
				// 1. pConent에서 입력된 내용(DTO)을 가져옴
				Object item = pContent.getContent();
				
				// 2. 입력된 DTO를 service를 이용해서 DB에 update
				updateContent(item);
				
				// 3. pList에서 목록을 새로 load
				pList.loadData();
				
				// 4. pContent 입력된 내용 Clear
				pContent.clear();
				
				// 5. btn "수정" -> "추가"
				btnOk.setText("추가");
				
			}
			if(e.getActionCommand().equals("확인")){
				// 1. pContent 내용을 clear
				pContent.clear();
				
				// 2. pContent 내용을 setEnable;
				pContent.contentEnable(true);
				
				// 3. btn 확인 -> 추가
				btnOk.setText("추가");
			}	
			
			
		}
		
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		
		if (e.getActionCommand().equals("삭제")) {
			// 1. 리스트에서 선택된 Item을 가져옴
			Object item = pList.getSelectedItem();
			
			// 2. service에서 delete 메소드 호출
			deleteContent(item);
		
			// 3. 삭제 후 목록을 다시 load
			pList.loadData();
			
		}
		
		if (e.getActionCommand().equals("수정")) {
			// 1. 리스트에서 선택된 Item을 가져옴
			Object item = pList.getSelectedItem();
						
			// 2. 가져온 Item을 pContent에 setContent() 호출;
			pContent.setContent(item);
			
			// 3. 버튼의 글자를 추가에서 수정으로 변경
			btnOk.setText("수정");
			
			
			
		}
		
		if (e.getActionCommand().equals("검색")) {
			// 1. 다이얼로그 상자를 띄워서 사원번호, 부서번호, 직책번호를 가져옴
			String Input = JOptionPane.showInputDialog(Title + "번호를 입력하세요.");			
			int Id = 0;
			
			try{
				Id = Integer.parseInt(Input);
			}catch(NumberFormatException err){
				JOptionPane.showMessageDialog(null, "숫자로만 입력하세요");
				return;
			}
			
			// 2. 해당하는 번호로 service에서 검색한 content를 가져옴
			
			Object item = selectContent(createObject(Id));
			
			
			// 3. 검색된 content를 pContent.setContent()
			try{
				pContent.setContent(item);
			}catch(NullPointerException err2){
				JOptionPane.showMessageDialog(null, "존재하지 않는" + Title + "번호입니다.");
			}
			// 4. pContent setEnable(false);
			pContent.contentEnable(false);
						
			// 5. btn -> "확인"
			btnOk.setText("확인");
		}

	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pContent.clear();
	};

	protected void btnOkActionPerformed(ActionEvent e) {
		// 0. 공백 체크
		try {
			pContent.isEmptyCheck();
		} catch (Exception e1) {
			System.out.println(e1);
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
	
	protected abstract void deleteContent(Object item);
	
	protected abstract void updateContent(Object item);
	
	protected abstract Object selectContent(Object id);
	
	protected abstract Object createObject(int id);
	
	protected abstract String setTitle();

}
