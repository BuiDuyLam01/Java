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
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Connect_KhoiA;
import model.ThiSinhA;

public class homeAdmin_khoiA extends JFrame {

	private JPanel contentPane;
	private JTextField txtSBD;
	private JTextField txtTen;
	private JTextField txtNamSinh;
	private JTextField txtToan;
	private JTextField txtDUT;
	private JTextField txtTim;
	private static JTable table;
	private JTextField txtLy;
	private JTextField txtHoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeAdmin_khoiA frame = new homeAdmin_khoiA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public homeAdmin_khoiA() {

	}

	/**
	 * Create the frame.
	 */
	public homeAdmin_khoiA(String user) {
		setTitle("Quản lí khối A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1191, 650);
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
				JOptionPane.showMessageDialog(null,
						"CHƯƠNG TRÌNH QUẢN LÍ QUẢN LÝ TUYỂN SINH\n\n" + "Giáo viên hướng dẫn: Ths.Hà Mạnh Đào\n\n"
								+ "Nhóm thực hiện: Nhóm 3\n\n" + "Thành viên nhóm: \nBùi Duy Lẫm\n"
								+ "Nguyễn Ngọc Hưng\n" + "\tNguyễn Xuân Lộc");
			}
		});
		menuBar.add(mnNewMenu_2);

		JButton btnKhoiA = new JButton("Quản lí khối A");
		btnKhoiA.setBackground(new Color(32, 178, 170));
		Image img = new ImageIcon(this.getClass().getResource("/image/khoia.png")).getImage();
		btnKhoiA.setIcon(new ImageIcon(img));
		btnKhoiA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		JLabel lblNewLabel = new JLabel("Quản lí khối A");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(515, 81, 136, 47);
		contentPane.add(lblNewLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 127, 1182, 9);
		contentPane.add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("Số báo danh");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(84, 140, 92, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(84, 179, 92, 32);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Năm sinh");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(84, 222, 92, 32);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(84, 265, 92, 32);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Điểm Toán");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(84, 310, 92, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Điểm ưu tiên");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(84, 451, 92, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);

		txtSBD = new JTextField();
		txtSBD.setBounds(186, 145, 92, 26);
		contentPane.add(txtSBD);
		txtSBD.setColumns(10);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(186, 184, 193, 26);
		contentPane.add(txtTen);

		txtNamSinh = new JTextField();
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(186, 227, 106, 26);
		contentPane.add(txtNamSinh);

		JComboBox cboGT = new JComboBox();
		cboGT.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cboGT.setBounds(186, 267, 92, 30);
		contentPane.add(cboGT);

		txtToan = new JTextField();
		txtToan.setColumns(10);
		txtToan.setBounds(186, 310, 83, 26);
		contentPane.add(txtToan);

		txtDUT = new JTextField();
		txtDUT.setColumns(10);
		txtDUT.setBounds(186, 451, 71, 26);
		contentPane.add(txtDUT);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThiSinhA ts = new ThiSinhA();
				ts.setSoBaoDanh(txtSBD.getText());
				ts.setHoVaTen(txtTen.getText());
				ts.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
				ts.setGioiTinh(cboGT.getSelectedIndex());
				ts.setDiemToan(Float.parseFloat(txtToan.getText()));
				ts.setDiemLy(Float.parseFloat(txtLy.getText()));
				ts.setDiemHoa(Float.parseFloat(txtHoa.getText()));
				ts.setDiemUuTien(Float.parseFloat(txtDUT.getText()));

				if (Connect_KhoiA.kiemtratontai(ts) == true) {
					JOptionPane.showMessageDialog(null, "Sinh viên này đã tồn tại!");
				} else {
					Connect_KhoiA.insert(ts);
					JOptionPane.showMessageDialog(null, "Lưu thông tin thành công!");
					showData(Connect_KhoiA.findAll());
				}
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLuu.setBounds(94, 513, 97, 32);
		contentPane.add(btnLuu);

		JButton btnRe = new JButton("Làm mới");
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSBD.setText("");
				txtTen.setText("");
				txtNamSinh.setText("");
				txtToan.setText("");
				txtHoa.setText("");
				txtLy.setText("");
				txtDUT.setText("");
			}
		});
		btnRe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRe.setBounds(227, 513, 97, 32);
		contentPane.add(btnRe);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThiSinhA ts = new ThiSinhA();
				ts.setSoBaoDanh(txtSBD.getText());
				ts.setHoVaTen(txtTen.getText());
				ts.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
				ts.setGioiTinh(cboGT.getSelectedIndex());
				ts.setDiemToan(Float.parseFloat(txtToan.getText()));
				ts.setDiemLy(Float.parseFloat(txtLy.getText()));
				ts.setDiemHoa(Float.parseFloat(txtHoa.getText()));
				ts.setDiemUuTien(Float.parseFloat(txtDUT.getText()));
				Connect_KhoiA.update(ts);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				showData(Connect_KhoiA.findAll());
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBounds(94, 568, 97, 32);
		contentPane.add(btnCapNhat);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThiSinhA ts = new ThiSinhA();
				ts.setSoBaoDanh(txtSBD.getText());
				int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?");
				if (luachon == JOptionPane.YES_OPTION) {
					Connect_KhoiA.delete(ts);
				}
				showData(Connect_KhoiA.findAll());
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(227, 568, 97, 32);
		contentPane.add(btnXoa);

		JLabel lblNewLabel_1_2 = new JLabel("Tìm kiếm thông tin(theo SBD)");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(555, 140, 210, 32);
		contentPane.add(lblNewLabel_1_2);

		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(768, 145, 178, 26);
		contentPane.add(txtTim);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThiSinhA ts = new ThiSinhA();
				ts.setSoBaoDanh(txtTim.getText());
				showData(Connect_KhoiA.findbySBD(ts));
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Không có thí sinh này.\n"
							+ "Vui lòng nhập lại!");
				}
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBounds(958, 140, 97, 32);
		contentPane.add(btnTimKiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 187, 635, 305);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model_table = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();

				txtSBD.setText(model_table.getValueAt(selectedIndex, 0).toString());
				txtTen.setText(model_table.getValueAt(selectedIndex, 1).toString());
				txtNamSinh.setText(model_table.getValueAt(selectedIndex, 2).toString());
				cboGT.setSelectedItem(model_table.getValueAt(selectedIndex, 3).toString());
				txtToan.setText(model_table.getValueAt(selectedIndex, 4).toString());
				txtLy.setText(model_table.getValueAt(selectedIndex, 5).toString());
				txtHoa.setText(model_table.getValueAt(selectedIndex, 6).toString());
				txtDUT.setText(model_table.getValueAt(selectedIndex, 7).toString());
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "SBD", "H\u1ECD v\u00E0 t\u00EAn", "N\u0103m sinh", "Gi\u1EDBi t\u00EDnh", "To\u00E1n",
						"L\u00FD", "H\u00F3a", "\u0110i\u1EC3m UT", "T\u1ED5ng \u0111i\u1EC3m" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Điểm Lý");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2.setBounds(84, 359, 92, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);

		txtLy = new JTextField();
		txtLy.setColumns(10);
		txtLy.setBounds(186, 359, 83, 26);
		contentPane.add(txtLy);

		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Điểm Hóa");
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_3.setBounds(84, 408, 92, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1_3);

		txtHoa = new JTextField();
		txtHoa.setColumns(10);
		txtHoa.setBounds(186, 408, 83, 26);
		contentPane.add(txtHoa);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(Connect_KhoiA.findAll());
			}
		});
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuyTim.setBounds(1061, 140, 97, 32);
		contentPane.add(btnHuyTim);

		JButton btnTao = new JButton("Tạo tài khoản");
		btnTao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThiSinhA ts = new ThiSinhA();
				ts.setSoBaoDanh(txtSBD.getText());
				if (Connect_KhoiA.kiemtratontai2(ts) == true) {
					JOptionPane.showMessageDialog(null, "Sinh viên này đã có tài khoản!");
				} else {
					Connect_KhoiA.Add_User(ts);
					;
					JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công!");
					showData(Connect_KhoiA.findAll());
				}
			}
		});
		btnTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTao.setBounds(1012, 506, 145, 32);
		contentPane.add(btnTao);

		JButton btn_User = new JButton("Quản lí tài khoản");
		btn_User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeAdmin_QLTK kb = new homeAdmin_QLTK();
				kb.setVisible(true);
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/image/user.png")).getImage();
		btn_User.setIcon(new ImageIcon(img6));
		btn_User.setBounds(692, 21, 188, 57);
		contentPane.add(btn_User);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(-2, 491, 521, 9);
		contentPane.add(separator_1_1);
		showData(Connect_KhoiA.findAll());
	}

	public void showData(List<ThiSinhA> thisinhl) {
		List<ThiSinhA> dsts = new ArrayList<>();
		dsts = thisinhl;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		dsts.forEach((thisinh) -> {
			String gioitinh;
			if (thisinh.getGioiTinh() == 0)
				gioitinh = "Nam";
			else {
				gioitinh = "Nữ";
			}
			tableModel.addRow(new Object[] { thisinh.getSoBaoDanh(), thisinh.getHoVaTen(), thisinh.getNamSinh(),
					gioitinh, thisinh.getDiemToan(), thisinh.getDiemLy(), thisinh.getDiemHoa(), thisinh.getDiemUuTien(),
					thisinh.getDiemToan() + thisinh.getDiemLy() + thisinh.getDiemHoa() + thisinh.getDiemUuTien() });
		});
	}
}
