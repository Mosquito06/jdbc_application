package kr.or.dgit.jdbc_application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.view.AbstractView;
import kr.or.dgit.jdbc_application.view.ViewDepartment;
import kr.or.dgit.jdbc_application.view.ViewEmployee;
import kr.or.dgit.jdbc_application.view.ViewTitle;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErpApplication extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnTitle;
	private JButton btnEmployee;
	private JButton btnDepartment;
	private AbstractView deptFr;
	private AbstractView empFr;
	private AbstractView titleFr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ErpApplication() {
		setTitle("\uD68C\uC0AC ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnEmployee = new JButton("荤盔包府");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);
		
		btnDepartment = new JButton("何辑包府");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);
		
		btnTitle = new JButton("流氓包府");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDepartment) {
			btnDepartmentActionPerformed(e);
		}
		if (e.getSource() == btnEmployee) {
			btnEmployeeActionPerformed(e);
		}
		if (e.getSource() == btnTitle) {
			btnTitleActionPerformed(e);
		}
	}
	
	protected void btnTitleActionPerformed(ActionEvent e) {
		if(titleFr == null){
			titleFr = new ViewTitle("流氓包府");
			titleFr.setVisible(true);
		}
		titleFr.setVisible(true);
	}
	
	protected void btnEmployeeActionPerformed(ActionEvent e) {
		if(empFr == null){
			empFr = new ViewEmployee("荤盔包府");
			empFr.setVisible(true);
		}
		empFr.setVisible(true);
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		if(deptFr == null){
			deptFr = new ViewDepartment("何辑包府");
			deptFr.setVisible(true);
		}
		deptFr.setVisible(true);
		
	}
}
