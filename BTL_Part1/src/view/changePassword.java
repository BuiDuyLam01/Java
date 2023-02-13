package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class changePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public changePassword(String name) {
		setTitle("Đổi mật khẩu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mật khẩu mới");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(21, 54, 207, 34);
		contentPane.add(lblNewLabel);
		
		textField = new JPasswordField();
		textField.setBounds(232, 54, 394, 34);
		contentPane.add(textField);
		
		JButton btnRe = new JButton("Đổi mật khẩu");
		btnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pstr = textField.getText();
				try {
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlituyensinh",
							"root", "");

					PreparedStatement st = (PreparedStatement) con
							.prepareStatement("Update taikhoan set Password=? where Username=?");

					st.setString(1, pstr);
					st.setString(2, name);
					st.executeUpdate();
					JOptionPane.showMessageDialog(btnRe, "Thay đổi mật khẩu thành công");
					dispose();
					homeAdmin cp = new homeAdmin(name);
					cp.setVisible(true);
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});
		btnRe.setBackground(Color.BLUE);
		btnRe.setForeground(Color.WHITE);
		btnRe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRe.setBounds(244, 142, 200, 47);
		contentPane.add(btnRe);
	}
}
