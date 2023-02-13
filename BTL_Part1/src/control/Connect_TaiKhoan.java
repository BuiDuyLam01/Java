package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.TaiKhoan;
import model.ThiSinhA;

public class Connect_TaiKhoan {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			String url = "jdbc:mySQL://localhost:3306/quanlituyensinh";
			String user = "root";
			String password = "";
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static List<TaiKhoan>findAll(){
		List<TaiKhoan>dstk = new ArrayList<>();
		
		String query = "SELECT IDUser, HoTen, NamSinh, Username FROM taikhoan WHERE Username IS NOT NULL";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getInt("IDUser"), rs.getString("Hoten"), 
						rs.getInt("NamSinh"), rs.getString("Username"));
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dstk;
	}
	
	public static void delete(TaiKhoan tk) {
		String query = "UPDATE taikhoan SET taikhoan.Username = NULL , taikhoan.`Password` = NULL \r\n"
				+ "WHERE HoTen = '"+tk.getHoVaTen()+"'";

		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<TaiKhoan>findbyTen(TaiKhoan s) {
		List<TaiKhoan>taikhoanl = new ArrayList<>();
		String query = "SELECT IDUser, HoTen, NamSinh, Username FROM taikhoan WHERE hoten = '"+s.getHoVaTen()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getInt("IDUser"), rs.getString("Hoten"), 
						rs.getInt("NamSinh"), rs.getString("Username"));
				taikhoanl.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taikhoanl;
	}
	
	public static String NgauNhien() {
		String characters = "ABCDEFGHIKMNLO123456789";
		String st = "";
		int length = 5;
		Random rand = new Random();
		char[] text = new char[length];
		for(int i= 0; i<length; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		for(int i = 0; i < text.length; i++) {
			st += text[i];
		}
		return st;
	}
	
	public static void Reset(TaiKhoan tk) {
		String query = "UPDATE taikhoan SET taikhoan.`Password` = ? WHERE taikhoan.Username = '"+tk.getTenNguoidung()+"'";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, NgauNhien());;
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
