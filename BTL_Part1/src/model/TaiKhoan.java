package model;

public class TaiKhoan {
	private int ID;
	private String hoVaTen;
	private int namSinh;
	private String tenNguoidung;
	public TaiKhoan() {
	}
	public TaiKhoan(int iD, String hoVaTen, int namSinh, String tenNguoidung) {
		ID = iD;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.tenNguoidung = tenNguoidung;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getTenNguoidung() {
		return tenNguoidung;
	}
	public void setTenNguoidung(String tenNguoidung) {
		this.tenNguoidung = tenNguoidung;
	}
	
	
}
