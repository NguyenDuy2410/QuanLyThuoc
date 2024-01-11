package gui;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Dao_HoaDon;
import enity.CT_HoaDon;
import enity.HoaDon;
import enity.KhachHang;
import enity.format;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class HoaDon_Pn extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaHD;
	private JTable table;
	private JTextField txtTenKhachHang;
	private JTextField txtSdtKH;
	private JTextField textField_3;
	private JTextField txtNgayLapHD;
	private DefaultTableModel tableModel;
	private JComboBox<String> cbNgay;
	private JButton btnChiTiet;
	private JButton btnLamMoi;
	private JButton btnDau;
	private JButton btntru1;
	private JLabel lbPage;
	private JButton btnCong1;
	private JButton btnCuoi;

	/**
	 * Create the panel.
	 */
	public HoaDon_Pn() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(UIManager.getColor("Button.light"));
		setLayout(null);

		JLabel lblTenKH = new JLabel("Tên KH: ");
		lblTenKH.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenKH.setForeground(Color.BLACK);
		lblTenKH.setBounds(10, 447, 91, 41);
		add(lblTenKH);

		txtMaHD = new JTextField();
		txtMaHD.setBounds(84, 514, 308, 35);
		add(txtMaHD);
		txtMaHD.setColumns(10);

		cbNgay = new JComboBox();
		cbNgay.setFont(new Font("Arial", Font.PLAIN, 16));
		cbNgay.setModel(new DefaultComboBoxModel(new String[] {"(Tất cả)", "Hôm nay", "Trong tháng ", "Trong năm"}));
		cbNgay.setBounds(929, 453, 155, 35);
		add(cbNgay);

		JLabel lblThoiGian = new JLabel("Thời gian");
		lblThoiGian.setForeground(Color.BLACK);
		lblThoiGian.setFont(new Font("Arial", Font.BOLD, 16));
		lblThoiGian.setBounds(814, 453, 80, 35);
		add(lblThoiGian);

		JPanel panel = new JPanel();
		panel.setBounds(10, 108, 1300, 1);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1074, 386);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(35);
		table.setModel(tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Mã khách hàng", "Ngày lập", "Tên Khách hàng", "Số điện thoại KH",
						"Nhân viên lập", "Số điện thoại NV", "Tổng tiền" }));

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/previousEnd.png")));
		btnDau.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDau.setBounds(284, 406, 80, 30);
		add(btnDau);

		btntru1 = new JButton("");
		btntru1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/rewind-button.png")));
		btntru1.setFont(new Font("Arial", Font.PLAIN, 16));
		btntru1.setBounds(379, 406, 80, 30);
		add(btntru1);

		btnCong1 = new JButton("");
		btnCong1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/forward-button.png")));
		btnCong1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCong1.setBounds(558, 406, 80, 30);
		add(btnCong1);

		JLabel lblMaHD = new JLabel("Mã HD: ");
		lblMaHD.setForeground(Color.BLACK);
		lblMaHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblMaHD.setBounds(10, 509, 91, 41);
		add(lblMaHD);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(84, 452, 308, 35);
		add(txtTenKhachHang);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/lammoi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLamMoi.setBounds(778, 406, 141, 35);
		add(btnLamMoi);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/nextEnd.png")));
		btnCuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCuoi.setBounds(653, 406, 80, 30);
		add(btnCuoi);

		lbPage = new JLabel("1");
		lbPage.setForeground(new Color(0, 0, 0));
		lbPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbPage.setBounds(506, 406, 46, 30);
		add(lbPage);

		JLabel lblSdtNV = new JLabel("SĐT NV: ");
		lblSdtNV.setForeground(Color.BLACK);
		lblSdtNV.setFont(new Font("Arial", Font.BOLD, 16));
		lblSdtNV.setBounds(418, 509, 91, 41);
		add(lblSdtNV);

		JLabel lblSdtKh = new JLabel("SĐT KH: ");
		lblSdtKh.setForeground(Color.BLACK);
		lblSdtKh.setFont(new Font("Arial", Font.BOLD, 16));
		lblSdtKh.setBounds(418, 447, 91, 41);
		add(lblSdtKh);

		txtSdtKH = new JTextField();
		txtSdtKH.setColumns(10);
		txtSdtKH.setBounds(493, 452, 284, 35);
		add(txtSdtKH);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(493, 514, 284, 35);
		add(textField_3);

		btnChiTiet = new JButton("Chi tiết");

		btnChiTiet.setIcon(new ImageIcon(HoaDon_Pn.class.getResource("/img/xemchitiet.png")));
		btnChiTiet.setHorizontalAlignment(SwingConstants.LEFT);
		btnChiTiet.setFont(new Font("Arial", Font.PLAIN, 16));
		btnChiTiet.setBounds(947, 408, 127, 35);
		add(btnChiTiet);

		JLabel lblNgayLapHD = new JLabel("Ngày lập HĐ");
		lblNgayLapHD.setForeground(Color.BLACK);
		lblNgayLapHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblNgayLapHD.setBounds(814, 514, 105, 35);
		add(lblNgayLapHD);

		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setBounds(929, 514, 155, 35);
		add(txtNgayLapHD);
		txtNgayLapHD.setColumns(10);

		cbNgay.addActionListener(this);
		txtMaHD.addKeyListener(this);
		txtTenKhachHang.addKeyListener(this);
		txtSdtKH.addKeyListener(this);
		textField_3.addKeyListener(this);
		txtNgayLapHD.addKeyListener(this);
		btnChiTiet.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.setDefaultEditor(Object.class, null);

		btnCong1.addActionListener(this);
		btnDau.addActionListener(this);
		btntru1.addActionListener(this);
		btnCuoi.addActionListener(this);

	}

	public void khoiTaoDuLieu() {
		xoaData();
		truyVanData();
	}

	public void lamMoi() {
		cbNgay.setSelectedIndex(0);
		txtMaHD.setText("");
		txtTenKhachHang.setText("");
		txtSdtKH.setText("");
		textField_3.setText("");
		txtNgayLapHD.setText("");
		xoaData();
		truyVanData();
	}

	private void xoaData() {
		for (int i = tableModel.getRowCount(); i > 0; i--) {
			tableModel.removeRow(0);
		}
	}

	private void truyVanData() {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<HoaDon> list = dao.Dao_HoaDon.timHoaDon(conn, txtMaHD.getText(), txtTenKhachHang.getText(),
				txtSdtKH.getText(), textField_3.getText(), txtNgayLapHD.getText(), cbNgay.getSelectedIndex(),
				Integer.parseInt(lbPage.getText() ) -1);
		if (list != null) {
			for (HoaDon hoaDon : list) {
				String[] s = { hoaDon.getMaHoaDonBan(), hoaDon.getKhachHang().getMaKhachHang(),
						hoaDon.getNgayLapHDBan(), hoaDon.getKhachHang().getTenKhachHang().toUpperCase(),
						hoaDon.getKhachHang().getSoDienThoai(), hoaDon.getNhanVien().getTenNhanVien().toUpperCase(),
						hoaDon.getNhanVien().getSoDienThoaiNV(), format.chuyenDoiTienTe(hoaDon.getTongTien())};
				tableModel.addRow(s);
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("ERROE close :truyVanData" + e.getMessage());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		lbPage.setText("1");
		xoaData();
		truyVanData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		Connection conn = connect.Connect.CreateConnection();
		int sumCount = Dao_HoaDon.getCount(conn, txtMaHD.getText(), txtTenKhachHang.getText(), txtSdtKH.getText(),
				textField_3.getText(), txtNgayLapHD.getText(), cbNgay.getSelectedIndex()); 
		int sumPage = sumCount % 25 == 0 ? sumCount / 25 : sumCount / 25 + 1; // tong so page
		int page = Integer.parseInt(lbPage.getText()); // so page hien tai
		
		if (sumCount == 0) {
			System.err.println("Loi sum count == 0  (HoaDon)");
			return;
		}
		if (object.equals(btnLamMoi)) {
			lamMoi();
		} else if (object.equals(btnChiTiet)) {
			int row = -1;
			row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Chưa chọn hàng dữ liệu");
			} else {
				String maHoaDon = table.getValueAt(row, 0).toString();
				String tenNhanVien = table.getValueAt(row, 3).toString();
				String tenKhacHang = table.getValueAt(row, 5).toString();
				String ngayLapHD = table.getValueAt(row, 2).toString();
			
				
				new DialogChiTietHoaDon(maHoaDon).setVisible(true);
			}
		} else if (object.equals(btnCong1)) { // trang ke tiep
			
			if (page != sumPage) { // dang la page cuoi
				
				lbPage.setText(Integer.toString(++page));// page = gage + 1
				xoaData();
				truyVanData();
			}

		} else if (object.equals(btntru1)) { // lui 1 trang
			if (page != 1) { // dang la page cuoi
				
				lbPage.setText(Integer.toString(--page)); // page = gage - 1
				xoaData();
				truyVanData();
			}
		} else if (object.equals(btnCuoi)) { // trang cuoi
			if (page != sumPage) {
				lbPage.setText(Integer.toString(sumPage));
				xoaData();
				truyVanData();
			}

		} else if (object.equals(btnDau)) { // trang Dau
			if (page != 1) {
				lbPage.setText("1");
				xoaData();
				truyVanData();
			}
		}

		else if (object.equals(cbNgay)) {
			lbPage.setText("1");
			xoaData();
			truyVanData();
		}
		try {
			conn.close();
		} catch (Exception e2) {
			System.err.println(e2.getMessage());
		}
	}

}