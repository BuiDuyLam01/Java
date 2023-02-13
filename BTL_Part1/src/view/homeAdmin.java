package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Connect_KhoiA;

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
import java.awt.Font;
import javax.swing.JTextArea;

public class homeAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeAdmin frame = new homeAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public homeAdmin() {
		
	}
	
	/**
	 * Create the frame.
	 */
	public homeAdmin(String user) {
		setTitle("Trang chủ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1226, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1212, 22);
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

		JMenu mnNewMenu_3 = new JMenu("Đổi mật khẩu");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				changePassword cp = new changePassword(user);
				cp.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_3);

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
		btnKhoiA.setBounds(198, 21, 177, 57);
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
		btnKhoiB.setBounds(373, 21, 177, 57);
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
		btnKhoiC.setBounds(549, 21, 177, 57);
		contentPane.add(btnKhoiC);
		
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
		btn_User.setBounds(723, 21, 191, 57);
		contentPane.add(btn_User);

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
		btnDangXuat.setBounds(1069, 21, 159, 57);
		contentPane.add(btnDangXuat);
		
		JButton btnHome = new JButton("Sự kiện - Thông tin");
		btnHome.setBackground(new Color(32, 178, 170));
		Image img5 = new ImageIcon(this.getClass().getResource("/image/event.png")).getImage();
		btnHome.setIcon(new ImageIcon(img5));
		btnHome.setBounds(0, 21, 199, 57);
		contentPane.add(btnHome);
		
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
		btnThongKe.setBounds(912, 21, 159, 57);
		contentPane.add(btnThongKe);
		
		JLabel lblNewLabel = new JLabel("THÔNG BÁO TỪ BAN QUẢN LÍ TUYỂN SINH KHU VỰC I");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(328, 89, 524, 40);
		contentPane.add(lblNewLabel);
		
		JTextArea txtriTng = new JTextArea();
		txtriTng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtriTng.setText("1.1 Đối tượng tuyển sinh\r\n\r\nLà những thí sinh đã tốt nghiệp Trung học phổ thông hoặc tương đương.\r\n\r\n1.2 Phạm vi tuyển sinh\r\n\r\nTuyển sinh trên toàn quốc.\r\n\r\n1.3 Phương thức tuyển sinh\r\n\r\nNăm 2022, Trường Đại học Hàng hải Việt Nam tuyển sinh 3600 chỉ tiêu trình độ Đại học chính quy với 47 chuyên ngành đào tạo theo 04 phương thức xét tuyển độc lập:\r\n\r\n- Phương thức 1 (PT1): Xét tuyển dựa trên kết quả Kỳ thi tốt nghiệp Trung học phổ thông năm 2022. Áp dụng cho toàn bộ các chuyên ngành.\r\n\r\n- Phương thức 2 (PT2): Xét tuyển thẳng theo đề án riêng của Trường Đại học Hàng hải Việt Nam (Xét tuyển kết hợp) áp dụng cho toàn bộ các chuyên ngành đối với những thí sinh có tổng điểm\n\n các môn thi tốt nghiệp THPT năm 2022 trong tổ hợp môn xét tuyển đạt ngưỡng chất lượng đầu vào theo Quy định của Nhà trường và đáp ứng một trong các tiêu chí sau:\r\n\r\nTiêu chí 1: Có chứng chỉ Tiếng Anh quốc tế IELTS 5.0 hoặc TOEFL 494 ITP hoặc TOEFL 58 iBT hoặc Toeic (L&R) 595 trở lên trong thời hạn (tính đến ngày 30/08/2022).\r\n\r\nTiêu chí 2:  Đạt các giải Nhất, Nhì, Ba các môn thi Toán học, Vật lý, Hóa học, Sinh học, Ngữ văn, Lịch sử, Địa lý, Tin học và Ngoại ngữ trong kỳ thi chọn học sinh giỏi cấp Tỉnh, Thành phố trở lên.\r\n\r\nTiêu chí 3:  Học 03 năm THPT tại các lớp Chuyên: Toán học, Vật Lý, Hóa học, Sinh học, Ngữ văn, Tiếng Anh, Tin học, Khoa học tự nhiên thuộc các trường Chuyên cấp Tỉnh/Thành phố. Có học lực\n\n Khá trở lên và hạnh kiểm Tốt các năm lớp 10, 11, 12.\r\n\r\n- Phương thức 3 (PT3): Xét tuyển dựa trên kết quả học tập và rèn luyện trung học phổ thông (xét Học bạ) với 30% chỉ tiêu. Áp dụng 28 chuyên ngành thuộc nhóm Kỹ thuật & Công nghệ,\n\n 02 chuyên ngành thuộc nhóm Chất lượng cao (Công nghệ thông tin và Điện tự động công nghiệp), và 02 chuyên ngành thuộc nhóm Chọn (Điều khiển tàu biển và Khai thác máy tàu biển).\r\n\r\n- Phương thức 4 (PT4): Xét tuyển thẳng theo quy định của Bộ GDĐT tại Điều 8 Quy chế tuyển sinh ban hành kèm theo Thông tư số 08/2022/TT-BGDĐT ban hành ngày 6 tháng 6 năm 2022.");
		txtriTng.setBounds(79, 151, 1094, 511);
		contentPane.add(txtriTng);
	}
}
