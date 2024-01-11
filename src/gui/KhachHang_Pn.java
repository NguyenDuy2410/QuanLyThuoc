 
package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.Connect;
import dao.Dao_KhachHang;
import enity.KhachHang;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class KhachHang_Pn extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JTable table;
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel_1;
	private JComboBox<String> cbGioiTinh;
	private JTextField txtSearch;
	private JButton btnTim;
	private JButton btnLamMoi;
	private JLabel txtPage;
	private JButton btnDau;
	private JButton btnTru1;
	private JButton btnCong1;
	private JButton btnCuoi;
	private JButton btnThemKhachHang;
	private JButton btnSua;

	public KhachHang_Pn() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(UIManager.getColor("Button.light"));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nh\u1EADp t\u00EAn: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(527, 503, 91, 41);
		add(lblNewLabel);

		txtSDT = new JTextField();
		txtSDT.setBounds(104, 509, 389, 35);
		add(txtSDT);
		txtSDT.setColumns(10);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "(Tất cả)", "Nam", "Nữ" }));
		cbGioiTinh.setBounds(869, 458, 120, 35);
		cbGioiTinh.addActionListener(this);
		add(cbGioiTinh);

		lblNewLabel_1 = new JLabel("Giới tính");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(781, 458, 120, 35);
		add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 108, 1300, 1);
		add(panel);

		btnThemKhachHang = new JButton("Th\u00EAm");
		btnThemKhachHang.addActionListener(this);
		btnThemKhachHang.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/them.png")));
		btnThemKhachHang.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThemKhachHang.setBounds(973, 220, 120, 51);
		add(btnThemKhachHang);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(this);
		btnSua.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/sua.png")));
btnSua.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSua.setBounds(973, 140, 120, 51);
		add(btnSua);

		btnDau = new JButton("");
		btnDau.addActionListener(this);
		btnDau.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/previousEnd.png")));
		btnDau.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDau.setBounds(211, 458, 80, 30);
		add(btnDau);

		btnTru1 = new JButton("");
		btnTru1.addActionListener(this);
		btnTru1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/rewind-button.png")));
		btnTru1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTru1.setBounds(306, 458, 80, 30);
		add(btnTru1);

		btnCong1 = new JButton("");
		btnCong1.addActionListener(this);
		btnCong1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/forward-button.png")));
		btnCong1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCong1.setBounds(485, 458, 80, 30);
		add(btnCong1);

		JLabel lblNhpSdt = new JLabel("Nhập SDT: ");
		lblNhpSdt.setForeground(Color.BLACK);
		lblNhpSdt.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSdt.setBounds(10, 504, 91, 41);
		add(lblNhpSdt);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);

		txtSearch.setBounds(621, 508, 389, 35);
		txtSearch.addKeyListener(this);
		add(txtSearch);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(this);
		btnLamMoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/lammoi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLamMoi.setBounds(972, 62, 120, 51);
		add(btnLamMoi);

		btnCuoi = new JButton("");
		btnCuoi.addActionListener(this);
		btnCuoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/nextEnd.png")));
		btnCuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCuoi.setBounds(580, 458, 80, 30);
		add(btnCuoi);

		txtPage = new JLabel("1");
		txtPage.setForeground(new Color(0, 0, 0));
		txtPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPage.setBounds(433, 458, 46, 30);
		add(txtPage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 945, 426);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã khách hàng",
				"Tên Khách hàng", "Giới tính", "SDT", "Tỉnh/TP", "Quận/Huyện", "Phường xã" }));
		table.setRowHeight(35);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(KhachHang_Pn.class.getResource("/img/timkiem.png")));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.addActionListener(this);
		btnTim.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTim.setBounds(973, 302, 114, 51);
		add(btnTim);
		themDuLieuVaoTable();

		// khong cho sua table
		table.setDefaultEditor(Object.class, null);
		
	}
	public void khoiTaoDuLieu(){
		xoaALLDuLieuTable();
		themDuLieuVaoTable();
	}
	private void xoaALLDuLieuTable() {
		for(int i = tableModel.getRowCount() ; i>0; i--) {
		tableModel.removeRow(0);
		}
		
	}

	public void themDuLieuVaoTable() {

		Connection conn = connect.Connect.CreateConnection();
int gtIndex = cbGioiTinh.getSelectedIndex();
		// loc theo gioi tinh
		String gt = "";
		if (gtIndex == 1) {
			gt = "1";
		} else if (gtIndex == 2) {
			gt = "0";
		}
		// phan trang
		int page = Integer.parseInt(txtPage.getText());
		// loc theo search
		String search = txtSearch.getText();
		if (search.trim().length() == 0) {
			search = "";
		}
		ArrayList<KhachHang> list = dao.Dao_KhachHang.danhSachKhachHang(conn, page - 1, search, gt);
		if (list != null) {
			for (KhachHang khachHang : list) {
				String[] s = { khachHang.getMaKhachHang(), khachHang.getTenKhachHang().toUpperCase(),
						khachHang.isGioiTinh() ? "Nam" : "Nữ", khachHang.getSoDienThoai(),
						khachHang.getDiaChi().getTinhTp(), khachHang.getDiaChi().getQuanHuyen(),
						khachHang.getDiaChi().getPhuongXa() };
				tableModel.addRow(s);
			}
		} else {
			xoaALLDuLieuTable();
		}

		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("ERROE close :themDuLieuVaoTable" + e.getMessage());
		}
	}

	public void lamMoi() {
		cbGioiTinh.setSelectedIndex(0);
		txtPage.setText("1");
		txtSDT.setText("");
		txtSearch.setText("");
		xoaALLDuLieuTable();
		themDuLieuVaoTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Connection conn = connect.Connect.CreateConnection();
		String gioiTinh = "";
		if (cbGioiTinh.getSelectedIndex( ) != 0) {
			gioiTinh  = cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nam") ? "1" : "0";
		}
		int tongSoHang = Dao_KhachHang.tongSoHang(conn,txtSearch.getText(), gioiTinh );
		int pageCuoi = tongSoHang % 20 == 0 ? tongSoHang / 20 : tongSoHang / 20 + 1;
		Object object = e.getSource();
		if (object.equals(cbGioiTinh)) { // loc du lieu theo gioi tinh
			xoaALLDuLieuTable();
			themDuLieuVaoTable();
		} else if (object.equals(btnTim)) { // tim kiem qua sdt
			xoaALLDuLieuTable();
			String sdt = txtSDT.getText();
			if (sdt.trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "Ban chua nhap SDT");
				return;
			}
			KhachHang khachHang = Dao_KhachHang.layThongTinKhachHangQuaSDT(conn, sdt);
			if (khachHang != null) {
				tableModel.addRow(new Object[] { khachHang.getMaKhachHang(), khachHang.getTenKhachHang(),
						khachHang.isGioiTinh() ? "Nam" : "Nữ", khachHang.getSoDienThoai(),
						khachHang.getDiaChi().getTinhTp(), khachHang.getDiaChi().getQuanHuyen(),
						khachHang.getDiaChi().getPhuongXa() });
			} else {
				JOptionPane.showMessageDialog(this, "Khong tim thay");
			}
		} else if (object.equals(btnLamMoi)) {
			lamMoi();
		}
		// phan trang
		else if (object.equals(btnDau)) {
			txtPage.setText("1");
			xoaALLDuLieuTable();
			themDuLieuVaoTable();

		} else if (object.equals(btnCong1)) {
			int page = Integer.parseInt(txtPage.getText());
			if (page != pageCuoi) {
				page++;
				txtPage.setText(Integer.toString(page));
				xoaALLDuLieuTable();
				themDuLieuVaoTable();
			}
		} else if (object.equals(btnTru1)) {
			int page = Integer.parseInt(txtPage.getText());
			if (page != 1) {
				page--;
txtPage.setText(Integer.toString(page));
				xoaALLDuLieuTable();
				themDuLieuVaoTable();
			}

		} else if (object.equals(btnCuoi)) {
			txtPage.setText(Integer.toString(pageCuoi));
			xoaALLDuLieuTable();
			themDuLieuVaoTable();
		} else if (object.equals(btnThemKhachHang)) { // them khach hang
			DialogThemKhachHang dialogThemKhachHang = new DialogThemKhachHang(null);
			dialogThemKhachHang.setVisible(true);
			lamMoi();
		}else if(object.equals(btnSua)) {
			int selectRow = table.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(this, "Ban chua chon khach hang");
				return;
			}
			String sdt = (String) table.getValueAt(table.getSelectedRow(), 3);
		
			DialogSuaKhachHang dialogSuaKhachHang = new DialogSuaKhachHang(sdt);
			dialogSuaKhachHang.setVisible(true);
			lamMoi();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		txtPage.setText("1");
		xoaALLDuLieuTable();
		themDuLieuVaoTable();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
