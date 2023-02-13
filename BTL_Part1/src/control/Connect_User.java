package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ThiSinhA;
import model.User;
import view.Login;


public class Connect_User {
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
	
	public static User find_HoTen_bySBD(String username) {
		User us = new User();
		String query = "SELECT taikhoan.HoTen, taikhoan.NamSinh, taikhoan.`Password`\r\n"
				+ "FROM taikhoan \r\n"
				+ "WHERE taikhoan.Username = '"+username+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				us = new User(rs.getString("HoTen"), rs.getString("NamSinh"), rs.getString("Password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}
	
	public static void DoiPass(User us, String username) {
		String query = "UPDATE taikhoan SET taikhoan.`Password` = ? WHERE taikhoan.Username = '"+username+"'";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, us.getPassWord());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String KTPassCu(String username) {
		User us = new User();
		String query = "SELECT taikhoan.HoTen, taikhoan.NamSinh, taikhoan.`Password`\r\n"
				+ "FROM taikhoan \r\n"
				+ "WHERE taikhoan.Username = '"+username+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				us = new User(rs.getString("HoTen"), rs.getString("NamSinh"), rs.getString("Password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us.getPassWord();
	}
	
	public static void UpTT(User us, String username) {
		String query = "UPDATE taikhoan SET taikhoan.HoTen = ?, taikhoan.NamSinh = ? WHERE taikhoan.Username = '"+username+"'";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, us.getHoVaTen());
			pstmt.setString(2, us.getNamSinh());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
