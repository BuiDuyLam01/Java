package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Connect_User;
import model.User;

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
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class homeUser_TTCN extends JFrame {

	private JPanel contentPane;
	private JTextField txtNam;
	private JTextField txtTen;
	private JPasswordField txtOld;
	private JPasswordField txtNew;
	private JPasswordField txtReNew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeUser_TTCN frame = new homeUser_TTCN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public homeUser_TTCN() {
		
	}
	
	/**
	 * Create the frame.
	 */
	public homeUser_TTCN(String username) {
		setTitle("Trang chủ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1106, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Trợ giúp");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Giới thiệu");
		menuBar.add(mnNewMenu_2);

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
		btnDangXuat.setBounds(397, 20, 161, 58);
		contentPane.add(btnDangXuat);
		
		JButton btnHome = new JButton("Sự kiện - Thông tin");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				homeUser kb = new homeUser(username);
				kb.setVisible(true);
			}
		});
		Image img5 = new ImageIcon(this.getClass().getResource("/image/event.png")).getImage();
		btnHome.setIcon(new ImageIcon(img5));
		btnHome.setBounds(0, 21, 203, 57);
		contentPane.add(btnHome);
		
		JButton btnPerson = new JButton("Thông tin cá nhân");
		btnPerson.setBackground(new Color(32, 178, 170));
		Image img6 = new ImageIcon(this.getClass().getResource("/image/info.png")).getImage();
		btnPerson.setIcon(new ImageIcon(img6));
		btnPerson.setBounds(195, 21, 203, 57);
		contentPane.add(btnPerson);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 79, 1106, 13);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Thông tin cá nhân");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(473, 79, 203, 58);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 124, 1106, 13);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 151, 65, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Năm sinh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(36, 193, 65, 22);
		contentPane.add(lblNewLabel_1_1);
		
		txtNam = new JTextField();
		txtNam.setColumns(10);
		txtNam.setBounds(202, 194, 791, 25);
		contentPane.add(txtNam);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User us = new User();
				us.setHoVaTen(txtTen.getText());
				us.setNamSinh(txtNam.getText());
				Connect_User.UpTT(us, username);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				showdata(Connect_User.find_HoTen_bySBD(username));
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBounds(909, 269, 115, 34);
		contentPane.add(btnCapNhat);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 315, 1106, 13);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đổi mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 325, 143, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mật khẩu cũ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(36, 385, 101, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(36, 440, 101, 22);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Nhập lại mật khẩu mới");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3_2.setBounds(36, 496, 143, 22);
		contentPane.add(lblNewLabel_1_3_2);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(202, 152, 791, 25);
		contentPane.add(txtTen);
		
		txtOld = new JPasswordField();
		txtOld.setBounds(202, 386, 791, 25);
		contentPane.add(txtOld);
		
		txtNew = new JPasswordField();
		txtNew.setBounds(202, 440, 791, 25);
		contentPane.add(txtNew);
		
		txtReNew = new JPasswordField();
		txtReNew.setBounds(202, 493, 791, 25);
		contentPane.add(txtReNew);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User us = new User();
				us.setPassWord(txtNew.getText());
				String s1 = txtNew.getText();
				String s2 = txtReNew.getText();
				String s3 = Connect_User.KTPassCu(username);
				String s4 = txtOld.getText();
				if(s1.equals(s2) && s3.equals(s4)) {
					Connect_User.DoiPass(us, username);
					JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
				} else {
					JOptionPane.showMessageDialog(null, "Sai  mật khẩu cũ hoặc chưa đồng bộ mật khẩu mới\nVui lòng nhập lại!");
				}
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXacNhan.setBounds(909, 555, 115, 34);
		contentPane.add(btnXacNhan);
		
		showdata(Connect_User.find_HoTen_bySBD(username));
	}
	
	public void showdata(User us) {
		txtTen.setText(us.getHoVaTen());
		txtNam.setText(us.getNamSinh());
	}
	
}
