package model;

public class TaiKhoan_TK {
	private int ID;
	private String SBD, hoVaTen;
	private int namSinh;
	private String maKhoi;
	private int gioiTinh;
	private float DUT;
	public TaiKhoan_TK() {
	}
	public TaiKhoan_TK(int iD, String sBD, String hoVaTen, int namSinh, String maKhoi, int gioiTinh, float dUT) {
		ID = iD;
		SBD = sBD;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.maKhoi = maKhoi;
		this.gioiTinh = gioiTinh;
		DUT = dUT;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getSBD() {
		return SBD;
	}
	public void setSBD(String sBD) {
		SBD = sBD;
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
	public String getMaKhoi() {
		return maKhoi;
	}
	public void setMaKhoi(String maKhoi) {
		this.maKhoi = maKhoi;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public float getDUT() {
		return DUT;
	}
	public void setDUT(float dUT) {
		DUT = dUT;
	}
	
}
