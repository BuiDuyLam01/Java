package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ThiSinhB;

public class Connect_KhoiB {
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
	
	public static List<ThiSinhB>findAll(){
		List<ThiSinhB>dsts = new ArrayList<>();
		
		String query = "SELECT thisinh.SBD, taikhoan.HoTen, taikhoan.NamSinh, \r\n"
				+ "thisinh.GioiTinh,khoib.Toan, khoib.Sinh, khoib.Hoa,thisinh.UuTien\r\n"
				+ "FROM thisinh, taikhoan, khoib\r\n"
				+ "WHERE thisinh.SBD = taikhoan.SBD\r\n"
				+ "AND thisinh.SBD = khoib.SBD";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				ThiSinhB ts = new ThiSinhB(rs.getString("SBD"), rs.getString("HoTen"), 
						rs.getInt("NamSinh"), rs.getInt("GioiTinh"), rs.getFloat("Toan"),
						rs.getFloat("Sinh"), rs.getFloat("Hoa"), rs.getFloat("UuTien"));
				dsts.add(ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsts;
	}
	
	public static void insert(ThiSinhB ts) {
		String query = "insert into thisinh(SBD, GioiTinh, MaKhoi, UuTien) values(?,?,?,?)";
		
		String query1 = "insert into taikhoan(Username, Password, HoTen, NamSinh, Type, SBD)values(?,?,?,?,?,?)";
		
		String query2 = "insert into khoib(SBD, Toan, Sinh, Hoa) values(?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			PreparedStatement pstmt1 = connection.prepareStatement(query1);
			PreparedStatement pstmt2 = connection.prepareStatement(query2);

			pstmt.setString(1, ts.getSoBaoDanh());
			pstmt.setInt(2, ts.getGioiTinh());
			pstmt.setString(3, "KB");
			pstmt.setFloat(4, ts.getDiemUuTien());
			
			pstmt1.setString(1, null);
			pstmt1.setString(2, null);
			pstmt1.setString(3, ts.getHoVaTen());
			pstmt1.setInt(4, ts.getNamSinh());
			pstmt1.setInt(5, 0);
			pstmt1.setString(6, ts.getSoBaoDanh());
			
			pstmt2.setString(1, ts.getSoBaoDanh());
			pstmt2.setFloat(2, ts.getDiemToan());
			pstmt2.setFloat(3, ts.getDiemSinh());
			pstmt2.setFloat(4, ts.getDiemHoa());
			
			pstmt.execute();
			pstmt1.execute();
			pstmt2.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(ThiSinhB ts) {
		String query = "DELETE FROM `quanlituyensinh`.`thisinh` WHERE `SBD`='"+ts.getSoBaoDanh()+"'";
		String query2 = "DELETE FROM `quanlituyensinh`.`taikhoan` WHERE  `SBD`='"+ts.getSoBaoDanh()+"'";
		String query3 = "DELETE FROM `quanlituyensinh`.`khoib` WHERE  `SBD`='"+ts.getSoBaoDanh()+"'";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt2 = connection.prepareStatement(query2);
			PreparedStatement pstmt3 = connection.prepareStatement(query3);
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(ThiSinhB ts) {
		String query = "update thisinh set SBD=?, GioiTinh=?, MaKhoi=?, UuTien=? where SBD = '"+ts.getSoBaoDanh()+"'";
		
		String query1 = "update taikhoan set Username=?, Password=?, HoTen=?, NamSinh=?, Type=?, SBD=? where SBD = '"+ts.getSoBaoDanh()+"'";
		
		String query2 = "update khoib set SBD=?, Toan=?, Sinh=?, Hoa=? where SBD = '"+ts.getSoBaoDanh()+"'";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			PreparedStatement pstmt1 = connection.prepareStatement(query1);
			PreparedStatement pstmt2 = connection.prepareStatement(query2);
			
			pstmt.setString(1, ts.getSoBaoDanh());
			pstmt.setInt(2, ts.getGioiTinh());
			pstmt.setString(3, "KB");
			pstmt.setFloat(4, ts.getDiemUuTien());
			
			pstmt1.setString(1, null);
			pstmt1.setString(2, null);
			pstmt1.setString(3, ts.getHoVaTen());
			pstmt1.setInt(4, ts.getNamSinh());
			pstmt1.setInt(5, 0);
			pstmt1.setString(6, ts.getSoBaoDanh());
			
			pstmt2.setString(1, ts.getSoBaoDanh());
			pstmt2.setFloat(2, ts.getDiemToan());
			pstmt2.setFloat(3, ts.getDiemSinh());
			pstmt2.setFloat(4, ts.getDiemHoa());
			
			pstmt.executeUpdate();
			pstmt1.execute();
			pstmt2.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<ThiSinhB>findbySBD(ThiSinhB s) {
		List<ThiSinhB>thisinhl = new ArrayList<>();
		String query = "SELECT thisinh.SBD, taikhoan.HoTen, taikhoan.NamSinh, \r\n"
				+ "thisinh.GioiTinh, khoib.Toan, khoib.Sinh, khoib.Hoa,thisinh.UuTien\r\n"
				+ "FROM thisinh, taikhoan, khoib\r\n"
				+ "WHERE thisinh.SBD = taikhoan.SBD\r\n"
				+ "AND thisinh.SBD = khoib.SBD\r\n"
				+ "AND thisinh.SBD = '"+s.getSoBaoDanh()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				ThiSinhB ts = new ThiSinhB(rs.getString("SBD"), rs.getString("HoTen"), 
						rs.getInt("NamSinh"), rs.getInt("GioiTinh"), rs.getFloat("Toan"),
						rs.getFloat("Sinh"), rs.getFloat("Hoa"), rs.getFloat("UuTien"));
				thisinhl.add(ts);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thisinhl;
	}
	
	public static boolean kiemtratontai(ThiSinhB s) {
		String query = "select*from thisinh where thisinh.SBD = '"+s.getSoBaoDanh()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				System.out.println("That bai");
				return true;
			} else {
				System.out.println("Thanh cong");
			}
		} catch (Exception e) {
			
		}
		return false;
	}		
	
	public static void Add_User(ThiSinhB ts) {
		String query1 = "update taikhoan set Username=?, Password=? where SBD = '"+ts.getSoBaoDanh()+"'";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt1 = connection.prepareStatement(query1);
			pstmt1.setString(1, ts.getSoBaoDanh());
			pstmt1.setString(2, ts.getSoBaoDanh());
			pstmt1.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean kiemtratontai2(ThiSinhB s) {
		String query = "SELECT * FROM taikhoan WHERE taikhoan.Username IS NOT NULL\r\n"
				+ "AND taikhoan.SBD = '"+s.getSoBaoDanh()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				System.out.println("Thanh cong");
				return true;
			} else {
				System.out.println("That bai");
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	
}
