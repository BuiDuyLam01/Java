package model;

public class User {
	private String hoVaTen;
	private String namSinh;
	private String passWord;
	public User() {
	}
	public User(String hoVaTen, String namSinh, String passWord) {
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.passWord = passWord;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
