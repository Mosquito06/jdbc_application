package kr.or.dgit.jdbc_application.content;

import java.awt.GridLayout;

import javax.swing.JPanel;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Title;

@SuppressWarnings("serial")
public abstract class AbstractContent<T> extends JPanel {
	
	public abstract T getContent();
	
	public abstract void setContent(T content);
	
	public abstract void isEmptyCheck() throws Exception;
	
	public abstract void clear();
}










