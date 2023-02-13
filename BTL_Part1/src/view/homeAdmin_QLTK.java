package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import control.Connect_TaiKhoan;
import model.TaiKhoan;

public class homeAdmin_QLTK extends JFrame {

	private JPanel contentPane;
	private JTextField txtTim;
	private static JTable table;
	private JTextField txtUser;
	private JTextField txtNamSinh;
	private JTextField txtTen;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeAdmin_QLTK frame = new homeAdmin_QLTK();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public homeAdmin_QLTK() {
		
	}

	/**
	 * Create the frame.
	 */
	public homeAdmin_QLTK(String user) {
		setTitle("Quản lí tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1191, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1182, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Trợ giúp");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Giới thiệu");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "CHƯƠNG TRÌNH QUẢN LÍ QUẢN LÝ TUYỂN SINH\n\n"
						+ "Giáo viên hướng dẫn: Ths.Hà Mạnh Đào\n\n"
						+ "Nhóm thực hiện: Nhóm 3\n\n"
						+ "Thành viên nhóm: \nBùi Duy Lẫm\n"
						+ "Nguyễn Ngọc Hưng\n"
						+ "\tNguyễn Xuân Lộc");
			}
		});
		menuBar.add(mnNewMenu_2);

		JButton btnKhoiA = new JButton("Quản lí khối A");
		Image img = new ImageIcon(this.getClass().getResource("/image/khoia.png")).getImage();
		btnKhoiA.setIcon(new ImageIcon(img));
		btnKhoiA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeAdmin_khoiA ka = new homeAdmin_khoiA(user);
				ka.setVisible(true);
			}
		});
		btnKhoiA.setBounds(195, 21, 168, 57);
		contentPane.add(btnKhoiA);

		JButton btnKhoiB = new JButton("Quản lí khối B");
		btnKhoiB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeAdmin_khoiB kb = new homeAdmin_khoiB(user);
				kb.setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/image/khoib.png")).getImage();
		btnKhoiB.setIcon(new ImageIcon(img2));
		btnKhoiB.setBounds(360, 21, 168, 57);
		contentPane.add(btnKhoiB);

		JButton btnKhoiC = new JButton("Quản lí khối C");
		btnKhoiC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeAdmin_khoiC kc = new homeAdmin_khoiC(user);
				kc.setVisible(true);
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/image/khoic.png")).getImage();
		btnKhoiC.setIcon(new ImageIcon(img3));
		btnKhoiC.setBounds(527, 21, 168, 57);
		contentPane.add(btnKhoiC);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeAdmin_ThongKe kb = new homeAdmin_ThongKe(user);
				kb.setVisible(true);
			}
		});
		Image img7 = new ImageIcon(this.getClass().getResource("/image/list.png")).getImage();
		btnThongKe.setIcon(new ImageIcon(img7));
		btnThongKe.setBounds(879, 21, 159, 57);
		contentPane.add(btnThongKe);

		JLabel label = new JLabel();
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fr = new JFrame("EXIT");
				Object[] options = {"Đăng xuất", "Hủy bỏ"};
                int result = JOptionPane.showOptionDialog(fr,
                        "Bạn có muốn đăng xuất không?",
                        "EXIT",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(result == JOptionPane.YES_OPTION){
                    label.setText("Bạn chọn: Yes");
					dispose();
					Login cp = new Login();
					cp.setVisible(true);
                }else if (result == JOptionPane.NO_OPTION){
                    label.setText("Bạn chọn : No");
                } else {
                    label.setText("Chưa ");
                }
			}
		});
		contentPane.add(label);
		Image img4 = new ImageIcon(this.getClass().getResource("/image/logout.png")).getImage();
		btnDangXuat.setIcon(new ImageIcon(img4));
		btnDangXuat.setBounds(1037, 21, 145, 57);
		contentPane.add(btnDangXuat);

		JButton btnHome = new JButton("Sự kiện - Thông tin");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeAdmin kb = new homeAdmin(user);
				kb.setVisible(true);
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/image/event.png")).getImage();
		btnHome.setIcon(new ImageIcon(img5));
		btnHome.setBounds(0, 21, 197, 57);
		contentPane.add(btnHome);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 81, 1182, 9);
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel("Quản lí tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(515, 81, 180, 47);
		contentPane.add(lblNewLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 127, 1182, 9);
		contentPane.add(separator_1);

		JButton btnRe = new JButton("Xóa tài khoản");
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoan tk = new TaiKhoan();
				tk.setHoVaTen(txtTen.getText());
				int luachon  = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?");
				if(luachon == JOptionPane.YES_OPTION) {
					Connect_TaiKhoan.delete(tk);
				}
				showData(Connect_TaiKhoan.findAll());
			}
		});
		btnRe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRe.setBounds(972, 468, 129, 32);
		contentPane.add(btnRe);

		JLabel lblNewLabel_1_2 = new JLabel("Tìm kiếm thông tin(theo họ tên)");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(68, 151, 248, 32);
		contentPane.add(lblNewLabel_1_2);

		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(304, 156, 178, 26);
		contentPane.add(txtTim);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoan tk = new TaiKhoan();
				tk.setHoVaTen(txtTim.getText());
				showData(Connect_TaiKhoan.findbyTen(tk));
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Không có thí sinh này.\n"
							+ "Vui lòng nhập lại!");
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(492, 151, 97, 32);
		contentPane.add(btnTimKiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 208, 635, 305);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				
				txtID.setText(model_table.getValueAt(selectedIndex, 0).toString());
				txtTen.setText(model_table.getValueAt(selectedIndex, 1).toString());
				txtNamSinh.setText(model_table.getValueAt(selectedIndex, 2).toString());
				txtUser.setText(model_table.getValueAt(selectedIndex, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "H\u1ECD v\u00E0 t\u00EAn", "N\u0103m sinh", "T\u00EAn ng\u01B0\u1EDDi d\u00F9ng"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(Connect_TaiKhoan.findAll());
			}
		});
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuyTim.setBounds(599, 151, 97, 32);
		contentPane.add(btnHuyTim);
		
		JLabel label1 = new JLabel();
		JButton btnTao = new JButton("Reset mật khẩu");
		btnTao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaiKhoan tk = new TaiKhoan();
				tk.setTenNguoidung(txtUser.getText());
				
				JFrame fr = new JFrame("EXIT");
				Object[] options = {"Có, chắc chắn", "Không, tôi đã thay đổi ý định", "Hủy bỏ"};
                int result = JOptionPane.showOptionDialog(fr,
                        "Bạn có chắc reset tài khoản này?",
                        "Xác nhận",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(result == JOptionPane.YES_OPTION){
                    label1.setText("Bạn chọn: Yes");
                    Connect_TaiKhoan.Reset(tk);
    				JOptionPane.showMessageDialog(null, "Reset thành công!");
    				showData(Connect_TaiKhoan.findAll());
                }else if (result == JOptionPane.NO_OPTION){
                    label1.setText("Bạn chọn : No");
                } else if (result == JOptionPane.CANCEL_OPTION) {
                    label1.setText("Ban chon cancel");
                }else {
                    label1.setText("Chưa ");
                }
				
			}
		});
		contentPane.add(label);
		btnTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTao.setBounds(806, 468, 145, 32);
		contentPane.add(btnTao);
		
		JButton btn_User = new JButton("Quản lí tài khoản");
		btn_User.setBackground(new Color(32, 178, 170));
		Image img6 = new ImageIcon(this.getClass().getResource("/image/user.png")).getImage();
		btn_User.setIcon(new ImageIcon(img6));
		btn_User.setBounds(692, 21, 188, 57);
		contentPane.add(btn_User);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(-2, 491, 521, 9);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(806, 208, 82, 32);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(924, 390, 178, 28);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(806, 268, 82, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Năm sinh");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(806, 325, 82, 32);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tên người dùng");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(806, 386, 108, 32);
		contentPane.add(lblNewLabel_1_4);
		
		txtNamSinh = new JTextField();
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(924, 325, 119, 28);
		contentPane.add(txtNamSinh);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(924, 268, 213, 28);
		contentPane.add(txtTen);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(924, 212, 97, 28);
		contentPane.add(txtID);
		showData(Connect_TaiKhoan.findAll());
	}

	public void showData(List<TaiKhoan> thisinhl) {
		List<TaiKhoan> dsts = new ArrayList<>();
		dsts = thisinhl;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		dsts.forEach((thisinh) -> {
			tableModel.addRow(new Object[] { thisinh.getID(), thisinh.getHoVaTen(), thisinh.getNamSinh(), thisinh.getTenNguoidung()});
		});
	}
}
