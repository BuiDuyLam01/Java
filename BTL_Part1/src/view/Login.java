package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnLogin;
	private JPanel contentPane;
	private JButton btnThoat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Nhóm 3 VipPro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 698, 480);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblNewLabel.setBounds(216, 11, 262, 68);
		contentPane.add(lblNewLabel);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtUser.setBounds(248, 149, 361, 45);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtPass.setBounds(248, 240, 361, 45);
		contentPane.add(txtPass);

		JLabel lblUsername = new JLabel("Tên đăng nhập");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblUsername.setBounds(57, 149, 162, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPassword.setBounds(57, 240, 104, 52);
		contentPane.add(lblPassword);

		btnLogin = new JButton("Đăng nhập");
		btnLogin.setMnemonic(KeyEvent.VK_ENTER);
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnLogin.setBounds(187, 340, 162, 52);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String userName = txtUser.getText();
				String password = txtPass.getText();
				try {
					Connection connection = (Connection) DriverManager
							.getConnection("jdbc:mysql://localhost:3306/quanlituyensinh", "root", "");

					PreparedStatement st = (PreparedStatement) connection
							.prepareStatement("Select Username, Password from taikhoan where Username=? and Password=? and Type=1");
					
					PreparedStatement st2 = (PreparedStatement) connection
							.prepareStatement("Select Username, Password from taikhoan where Username=? and Password=? and Type=0");

					st.setString(1, userName);
					st.setString(2, password);
					
					st2.setString(1, userName);
					st2.setString(2, password);
					
					ResultSet rs = st.executeQuery();
					
					ResultSet rs2 = st2.executeQuery();
					
					if (rs.next()) {
						dispose();
						homeAdmin ah = new homeAdmin(userName);
						ah.setVisible(true);
					} else  if (rs2.next()) {
						dispose();
						homeUser_TTCN ah = new homeUser_TTCN(userName);
						ah.setVisible(true);
					} 
					else {
						JOptionPane.showMessageDialog(btnLogin, "Tài khoản hoặc mật khẩu không đúng. Vui lòng nhập lại!");
					}
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}

			}
		});

		contentPane.add(btnLogin);
		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fr = new JFrame("EXIT");	
				if(JOptionPane.showConfirmDialog(fr, "Bạn có muốn thoát không?", "EXIT",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThoat.setBackground(Color.RED);
		btnThoat.setBounds(388, 340, 162, 52);
		contentPane.add(btnThoat);

	}
}
