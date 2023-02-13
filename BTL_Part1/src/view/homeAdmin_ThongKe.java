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
import java.io.IOException;
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

import control.Connect_ThongKe;
import model.TaiKhoan_TK;


public class homeAdmin_ThongKe extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeAdmin_ThongKe frame = new homeAdmin_ThongKe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public homeAdmin_ThongKe() {
		
	}

	/**
	 * Create the frame.
	 */
	public homeAdmin_ThongKe(String user) {
		setTitle("Thống kê");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1191, 614);
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
		btnThongKe.setBackground(new Color(32, 178, 170));
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

		JButton btnHome = new JButton("Thông tin - sự kiện");
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

		JLabel lblNewLabel = new JLabel("Danh sách thí sinh tuyển sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(474, 81, 303, 47);
		contentPane.add(lblNewLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 127, 1182, 9);
		contentPane.add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 218, 1061, 305);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "S\u1ED1 b\u00E1o danh", "H\u1ECD v\u00E0 t\u00EAn", "N\u0103m sinh", "M\u00E3 kh\u1ED1i", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m \u01B0u ti\u00EAn"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(56);
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JButton btn_User = new JButton("Quản lí tài khoản");
		btn_User.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeAdmin_QLTK kb = new homeAdmin_QLTK(user);
				kb.setVisible(true);
			}
		});
		Image img6 = new ImageIcon(this.getClass().getResource("/image/user.png")).getImage();
		btn_User.setIcon(new ImageIcon(img6));
		btn_User.setBounds(692, 21, 188, 57);
		contentPane.add(btn_User);
		
		JButton btnXuatFile = new JButton("Xuất file");
		btnXuatFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "Xuất file thành công!");
					Connect_ThongKe.XuatFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXuatFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXuatFile.setBounds(979, 534, 133, 32);
		contentPane.add(btnXuatFile);
		showData(Connect_ThongKe.findAll());
		
		JButton btnSapXep1 = new JButton("Sắp xếp theo tên");
		btnSapXep1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(Connect_ThongKe.SapXep());
			}
		});
		btnSapXep1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSapXep1.setBounds(84, 159, 179, 32);
		contentPane.add(btnSapXep1);
		
		JButton btnSpXpTheo = new JButton("Sắp xếp theo SBD");
		btnSpXpTheo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(Connect_ThongKe.SapXepSBD());
			}
		});
		btnSpXpTheo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSpXpTheo.setBounds(306, 159, 179, 32);
		contentPane.add(btnSpXpTheo);
//		showData(Connect_ThongKe.findAll());
	}

	public void showData(List<TaiKhoan_TK> thisinhl) {
		List<TaiKhoan_TK> dsts = new ArrayList<>();
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
			tableModel.addRow(new Object[] { thisinh.getID(), thisinh.getSBD(), thisinh.getHoVaTen(),
					thisinh.getNamSinh(), thisinh.getMaKhoi() ,gioitinh, thisinh.getDUT()});
		});
	}
}
