package kr.or.dgit.jdbc_application.dto;

public class Title {
	private int title;
	private String titleName;

	public Title() {

	}

	public Title(int title, String titleName) {
		this.title = title;
		this.titleName = titleName;
	}

	public Title(int title) {
		this.title = title;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", title, titleName);
	}

}
