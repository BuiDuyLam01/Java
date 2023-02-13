package control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.TaiKhoan_TK;

public class Connect_ThongKe {
	private static String[] columns = { "ID", "Số báo danh", "Họ tên", "Năm sinh", "Mã khối", "Giới tính",
			"Điểm ưu tiên" };

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

	public static List<TaiKhoan_TK> findAll() {
		List<TaiKhoan_TK> dstk = new ArrayList<>();

		String query = "SELECT taikhoan.IDUser, thisinh.SBD, taikhoan.HoTen,\r\n"
				+ "taikhoan.NamSinh, thisinh.MaKhoi, thisinh.GioiTinh, thisinh.UuTien\r\n"
				+ "FROM taikhoan, thisinh\r\n" + "WHERE taikhoan.SBD = thisinh.SBD";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				TaiKhoan_TK tk = new TaiKhoan_TK(rs.getInt("IDUser"), rs.getString("SBD"), rs.getString("Hoten"),
						rs.getInt("NamSinh"), rs.getString("MaKhoi"), rs.getInt("GioiTinh"), rs.getFloat("UuTien"));
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dstk;
	}

	public static void XuatFile() throws IOException {

		List<TaiKhoan_TK> ds = new ArrayList<>();

		String query = "SELECT taikhoan.IDUser, thisinh.SBD, taikhoan.HoTen,\r\n"
				+ "taikhoan.NamSinh, thisinh.MaKhoi, thisinh.GioiTinh, thisinh.UuTien\r\n"
				+ "FROM taikhoan, thisinh\r\n" + "WHERE taikhoan.SBD = thisinh.SBD";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				TaiKhoan_TK tk = new TaiKhoan_TK(rs.getInt("IDUser"), rs.getString("SBD"), rs.getString("Hoten"),
						rs.getInt("NamSinh"), rs.getString("MaKhoi"), rs.getInt("GioiTinh"), rs.getFloat("UuTien"));
				ds.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		int rowNum = 1;
		for (TaiKhoan_TK taikhoan : ds) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(taikhoan.getID());
			row.createCell(1).setCellValue(taikhoan.getSBD());
			row.createCell(2).setCellValue(taikhoan.getHoVaTen());
			row.createCell(3).setCellValue(taikhoan.getNamSinh());
			row.createCell(4).setCellValue(taikhoan.getMaKhoi());
			row.createCell(5).setCellValue(taikhoan.getGioiTinh()==0?"Nam":"Nữ");
			row.createCell(6).setCellValue(taikhoan.getDUT());
		}

		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\liam\\OneDrive\\Desktop\\ds.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}
	
	public static List<TaiKhoan_TK> SapXep() {
		List<TaiKhoan_TK> dstk = new ArrayList<>();

		String query = "SELECT taikhoan.IDUser, thisinh.SBD, taikhoan.HoTen,\r\n"
				+ "taikhoan.NamSinh, thisinh.MaKhoi, thisinh.GioiTinh, thisinh.UuTien\r\n"
				+ "FROM taikhoan, thisinh\r\n" + "WHERE taikhoan.SBD = thisinh.SBD";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				TaiKhoan_TK tk = new TaiKhoan_TK(rs.getInt("IDUser"), rs.getString("SBD"), rs.getString("Hoten"),
						rs.getInt("NamSinh"), rs.getString("MaKhoi"), rs.getInt("GioiTinh"), rs.getFloat("UuTien"));
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Comparator<TaiKhoan_TK> compa = new Comparator<TaiKhoan_TK>() {

			@Override
			public int compare(TaiKhoan_TK o1, TaiKhoan_TK o2) {
				String name1 = o1.getHoVaTen();
				String name2 = o2.getHoVaTen();
				return name1.compareTo(name2);	
			}
		};
		Collections.sort(dstk, compa);
		
		return dstk;
	}
	
	public static List<TaiKhoan_TK> SapXepSBD() {
		List<TaiKhoan_TK> dstk = new ArrayList<>();

		String query = "SELECT taikhoan.IDUser, thisinh.SBD, taikhoan.HoTen,\r\n"
				+ "taikhoan.NamSinh, thisinh.MaKhoi, thisinh.GioiTinh, thisinh.UuTien\r\n"
				+ "FROM taikhoan, thisinh\r\n" + "WHERE taikhoan.SBD = thisinh.SBD";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				TaiKhoan_TK tk = new TaiKhoan_TK(rs.getInt("IDUser"), rs.getString("SBD"), rs.getString("Hoten"),
						rs.getInt("NamSinh"), rs.getString("MaKhoi"), rs.getInt("GioiTinh"), rs.getFloat("UuTien"));
				dstk.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Comparator<TaiKhoan_TK> compa = new Comparator<TaiKhoan_TK>() {

			@Override
			public int compare(TaiKhoan_TK o1, TaiKhoan_TK o2) {
				String name1 = o1.getSBD();
				String name2 = o2.getSBD();
				return name1.compareTo(name2);	
			}
		};
		Collections.sort(dstk, compa);
		
		return dstk;
	}
	
}
