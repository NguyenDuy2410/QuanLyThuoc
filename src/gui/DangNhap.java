package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Dao_NhanVien;
import enity.NhanVien;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DangNhap extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NhanVien nhanVien;
	public DangNhapResponse dangNhapResponse;
	private JTextField txtPassword;
	private JTextField txtSDT;
	private JButton btnXoaRong;
	private JButton btnDangNhap;
	/**
	 * Launch the application.
	 */
	public interface DangNhapResponse {
		void getNhanVien(NhanVien nhanVien);
	}
	/**
	 * Create the frame.
	 */
	public DangNhap(DangNhapResponse dangNhapResponse) {
		this.dangNhapResponse = dangNhapResponse;
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 389);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 684, 44);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 661, 44);
		panel.add(lblNewLabel);
		
		JLabel lblTenDN = new JLabel("Tên đăng nhập:");
		lblTenDN.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenDN.setBounds(113, 111, 137, 25);
		contentPane.add(lblTenDN);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMatKhau.setBounds(113, 166, 137, 25);
		contentPane.add(lblMatKhau);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(260, 109, 300, 30);
		
		txtSDT.setColumns(10);
		contentPane.add(txtSDT);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(260, 163, 300, 30);
		contentPane.add(txtPassword);
		
		JCheckBox chckbxNhMtKhu = new JCheckBox("Nhớ mật khẩu?");
		chckbxNhMtKhu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chckbxNhMtKhu.setBounds(257, 200, 297, 23);
		contentPane.add(chckbxNhMtKhu);
		
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnXoaRong.setBounds(260, 256, 120, 35);
		contentPane.add(btnXoaRong);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnDangNhap.setBounds(440, 256, 120, 35);
		contentPane.add(btnDangNhap);
		
		btnDangNhap.addActionListener(this);
		btnXoaRong.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(btnDangNhap)) {
			String sdt = txtSDT.getText();
			String password = txtPassword.getText();
			if (!sdt.matches(".*")) {
				JOptionPane.showMessageDialog(this, "Số điện thoại không đúng địng dạng");
				txtSDT.selectAll();
				txtSDT.requestFocus();
				return;
			}
			if (sdt.trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại");
				txtSDT.selectAll();
				txtSDT.requestFocus();
				return;
			}
			if (password.trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu");
				txtPassword.requestFocus();
				return;
			}
			
			if (Dao_NhanVien.dangNhap(connect.Connect.CreateConnection(), sdt, password)) {
				Connection conn = connect.Connect.CreateConnection();
				// dung
				dangNhapResponse.getNhanVien(Dao_NhanVien.layThongTinNhanVienQuaSDT(conn, sdt));
				
				
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dangNhapResponse.getNhanVien(nhanVien);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Bạn sai số điện thoại hoặc mật khẩu");
			}

		}else if(object.equals(btnXoaRong)) {
			txtPassword.setText("");
			txtSDT.setText("");
		}
	}
}
