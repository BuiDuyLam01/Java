package model;

public class ThiSinhA {
	private String soBaoDanh;
	private String hoVaTen;
	private int namSinh;
	private int gioiTinh;
	private float diemToan, diemLy, diemHoa, diemUuTien;
	public ThiSinhA() {
	}
	public ThiSinhA(String soBaoDanh, String hoVaTen, int namSinh, int gioiTinh, float diemToan, float diemLy,
			float diemHoa, float diemUuTien) {
		super();
		this.soBaoDanh = soBaoDanh;
		this.hoVaTen = hoVaTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
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
	public float getDiemToan() {
		return diemToan;
	}
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}
	public float getDiemLy() {
		return diemLy;
	}
	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}
	public float getDiemHoa() {
		return diemHoa;
	}
	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}
	public float getDiemUuTien() {
		return diemUuTien;
	}
	public void setDiemUuTien(float diemUuTien) {
		this.diemUuTien = diemUuTien;
	}
	
}
