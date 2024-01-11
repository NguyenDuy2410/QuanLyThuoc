package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import enity.NhanVien;
import gui.DangNhap.DangNhapResponse;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTabbedPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI_Chinh_JFrame extends JFrame implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;


	private JTabbedPane tabbedPane;
	private gui.CuaHang_Pn cuaHang_Pn;
	private gui.NhanVien_Pn nhanVien_Pn;
	private gui.KhachHang_Pn khachHang_Pn;
	private gui.Thuoc_Pn thuoc_Pn;
	private gui.HoaDon_Pn hoaDon_Pn;
	private JButton btnDangXuat;
	private JPanel jMenu;
	public static NhanVien nhanVien;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			 GUI_Chinh_JFrame chinh_JFrame;
			class DangNhapInterface implements DangNhapResponse {

				@Override
				public void getNhanVien(NhanVien nhanVien1) {
					if (nhanVien1 != null) {
						nhanVien = nhanVien1;
						chinh_JFrame = new GUI_Chinh_JFrame();
						chinh_JFrame.setVisible(true);
					}
				}

			}
			public void run() {
				try {
					  new DangNhap(new DangNhapInterface()).setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI_Chinh_JFrame() {
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
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1290, 720);
		setResizable(false);
		getContentPane().setLayout(null);
		this.setBackground(new Color(233, 245, 237));
		this.setLocationRelativeTo(null);
		JPanel pnTitleName = new JPanel();
		pnTitleName.setBackground(new Color(0, 0, 255));
		pnTitleName.setBounds(0, 0, 1284, 113);
		pnTitleName.setBackground(new Color(135, 206, 235));
		getContentPane().add(pnTitleName);
		pnTitleName.setLayout(null);

		JLabel lblTitle = new JLabel("Nhà Thuốc Tư Nhân Phúc Thiện");
		lblTitle.setForeground(UIManager.getColor("Button.foreground"));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(285, 28, 592, 51);
		pnTitleName.add(lblTitle);
		
		JLabel lblUser= new JLabel("Nhân viên: "+nhanVien.getTenNhanVien().toUpperCase());
		lblUser.setForeground(new Color(46, 139, 87));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setVerticalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Arial", Font.ITALIC, 15));
		lblUser.setForeground(Color.BLACK);
		lblUser.setBounds(847, 30, 329, 56);
		pnTitleName.add(lblUser);
		
	
		
		btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setIcon(new ImageIcon(GUI_Chinh_JFrame.class.getResource("/img/dangxuat.png")));
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDangXuat.setBounds(1128, 35, 146, 44);
		btnDangXuat.addActionListener(this);
		pnTitleName.add(btnDangXuat);
		
		
		

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GUI_Chinh_JFrame.class.getResource("/img/logoNhaThuoc.png")));
		label_1.setBounds(39, 0, 86, 113);
		pnTitleName.add(label_1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 1284, 625);
		getContentPane().add(panel);

		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(new Color(135, 206, 235));
		tabbedPane.setBounds(0, 56, 1284, 569);
		tabbedPane.addMouseListener(this);
		panel.setLayout(null);
		panel.add(tabbedPane);


		cuaHang_Pn = new CuaHang_Pn();
		thuoc_Pn = new Thuoc_Pn();
		nhanVien_Pn = new NhanVien_Pn();
		khachHang_Pn = new KhachHang_Pn();
		hoaDon_Pn = new HoaDon_Pn();
		cuaHang_Pn.khoiTaoDuLieu();

		tabbedPane.addTab("Cửa hàng ", new ImageIcon(GUI_Chinh_JFrame.class.getResource("/img/nhaThuoc.png")),
				cuaHang_Pn, "Cửa hàng");
		cuaHang_Pn.setLayout(null);
		tabbedPane.addTab("Thuốc   ", new ImageIcon(GUI_Chinh_JFrame.class.getResource("/img/thuoc.png")), thuoc_Pn,
				"Quản lý thuốc");
		tabbedPane.addTab("Nhân viên   ", new ImageIcon(GUI_Chinh_JFrame.class.getResource("/img/nhanVien.png")),
				nhanVien_Pn, "Quản lý nhân viên");
		tabbedPane.addTab("Khách hàng   ", new ImageIcon(GUI_Chinh_JFrame.class.getResource("/img/khachHang.png")),
				khachHang_Pn, "Quản lý khách hàng");
		tabbedPane.addTab("Hóa đơn   ", new ImageIcon(GUI_Chinh_JFrame.class.getResource("/img/hoaDon.png")),
				hoaDon_Pn, "Quản lý hóa đơn");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object =  e.getSource();
		if(object.equals(btnDangXuat)) {
			int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn đăng xuất","Đăng xuất",JOptionPane.YES_NO_OPTION);
			if(check == JOptionPane.YES_OPTION) {
				nhanVien = null;
				this.setVisible(false);
				this.dispose();
				main(null);
				return;
				
			}else {
				return;
			}
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		switch (tabbedPane.getSelectedIndex()) {
		case 0: {
			cuaHang_Pn.khoiTaoDuLieu();
			break;
		}
		case 1: {
			thuoc_Pn.khoiTaoDuLieu();
			break;
		}
		case 2: {
			nhanVien_Pn.khoiTaoDuLieu();
			break;
		}
		case 3: {
			khachHang_Pn.khoiTaoDuLieu();
			break;
		}
		case 4: {
			hoaDon_Pn.khoiTaoDuLieu();
			break;
		}
		case 5: {

			break;
		}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	
}
