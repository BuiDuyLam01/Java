package model;

public class ThiSinhC {
	private String soBaoDanh;
	private String hoVaTen;
	private int namSinh;
	private int gioiTinh;
	private float diemVan, diemSu, diemDia, diemUuTien;
	public ThiSinhC() {
	}
	public ThiSinhC(String soBaoDanh, String hoVaTen, int namSinh, int gioiTinh, float diemVan, float diemSu,
			float diemDia, float diemUuTien) {
		this.soBaoDanh = soBaoDanh;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.diemVan = diemVan;
		this.diemSu = diemSu;
		this.diemDia = diemDia;
		this.diemUuTien = diemUuTien;
	}
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
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
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public float getDiemVan() {
		return diemVan;
	}
	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}
	public float getDiemSu() {
		return diemSu;
	}
	public void setDiemSu(float diemSu) {
		this.diemSu = diemSu;
	}
	public float getDiemDia() {
		return diemDia;
	}
	public void setDiemDia(float diemDia) {
		this.diemDia = diemDia;
	}
	public float getDiemUuTien() {
		return diemUuTien;
	}
	public void setDiemUuTien(float diemUuTien) {
		this.diemUuTien = diemUuTien;
	}
	
	
}
