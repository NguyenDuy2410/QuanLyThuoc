package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Dao_Thuoc;
import dao.Dao_CongDung;
import enity.CongDung;

import enity.Thuoc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class DialogThemThuoc extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaThuoc;
	private JTextField txtTenThuoc;
	private JTextField txtGiaBan;
	private JTextField txtHamLuong;
	private JTextField txtCTySX;
	private JTextField txtThue;
	private JTextField txtSoDK;
	private JTextField txtSoLuongBanDau;
	private JTextField txtHanSD;

	private JComboBox<String> cbDonViTinh;
	private JComboBox<String> cbThanhPhan;
	private JComboBox<String> cbQuyCachDongGoi;
	private JComboBox<String> cbDangBaoChe;
	private JComboBox<String> cbTrangThaiKD;
	private JComboBox<String> cbCongDung;
	private JComboBox<String> cbNuocSX;
	private JComboBox<String> cbNhomCongDung;

	private DefaultComboBoxModel<String> modelDonViTinh;
	private DefaultComboBoxModel<String> modelThanhPhan;
	private DefaultComboBoxModel<String> modelQuyCachDongGoi;
	private DefaultComboBoxModel<String> modelDangBaoChe;
	private DefaultComboBoxModel<String> modelTrangThaiKD;
	private DefaultComboBoxModel<String> modelCongDung;
	private DefaultComboBoxModel<String> modelNuocSX;
	private DefaultComboBoxModel<String> modelNhomCongDung;

	private JButton btnLuu;
	private JButton btnHuy;
	private JButton btnLamMoi;
	private JLabel lbMaThuoc;

	private Dao_CongDung dao_congdung;
	private Dao_Thuoc dao_thuoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogThemThuoc dialog = new DialogThemThuoc();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogThemThuoc() {
		setResizable(false);
		setModal(true);
		setBackground(UIManager.getColor("Button.light"));
		getContentPane().setBackground(UIManager.getColor("Button.light"));

		setBounds(100, 100, 950, 700);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 10, 936, 653);
		contentPanel.setForeground(Color.BLACK);
		;
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Nhà Thuốc Tư Nhân Phúc Thiện");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBounds(188, 10, 627, 78);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Thêm thuốc mới");
			lblNewLabel_1.setForeground(new Color(0, 0, 128));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_1.setBounds(336, 73, 255, 31);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Mã Thuốc:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 141, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Tên Thuốc:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 186, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtTenThuoc = new JTextField();
			txtTenThuoc.setBounds(150, 186, 750, 35);
			contentPanel.add(txtTenThuoc);
			txtTenThuoc.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Giá Bán:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 231, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtGiaBan = new JTextField();
			txtGiaBan.setBounds(149, 231, 300, 35);
			contentPanel.add(txtGiaBan);
			txtGiaBan.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Đơn vị tính:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 276, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbDonViTinh = new JComboBox<String>();
			modelDonViTinh = new DefaultComboBoxModel<String>(new String[] { "Đơn vị tính" });
			cbDonViTinh.setModel(modelDonViTinh);
			cbDonViTinh.setFont(new Font("Arial", Font.PLAIN, 16));
			cbDonViTinh.setBounds(640, 276, 260, 35);
			cbDonViTinh.addActionListener(this);
			themDuLieuDonViTinh();
			contentPanel.add(cbDonViTinh);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Thành Phần:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 231, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbThanhPhan = new JComboBox<String>();
			modelThanhPhan = new DefaultComboBoxModel<String>(new String[] { "Thành Phần" });
			cbThanhPhan.setModel(modelThanhPhan);
			cbThanhPhan.setFont(new Font("Arial", Font.PLAIN, 16));
			cbThanhPhan.setBounds(640, 231, 260, 35);
			cbThanhPhan.addActionListener(this);
			themDuLieuThanhPhan();
			contentPanel.add(cbThanhPhan);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Q.Cách Đóng Gói:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 421, 150, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbQuyCachDongGoi = new JComboBox<String>();
			modelQuyCachDongGoi = new DefaultComboBoxModel<String>(new String[] { "Quy Cách Đóng Gói" });
			cbQuyCachDongGoi.setModel(modelQuyCachDongGoi);
			cbQuyCachDongGoi.setFont(new Font("Arial", Font.PLAIN, 16));
			cbQuyCachDongGoi.setBounds(640, 421, 260, 35);
			cbQuyCachDongGoi.addActionListener(this);
			themDuLieuQCDG();
			contentPanel.add(cbQuyCachDongGoi);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Dạng Bào Chế:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 476, 150, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbDangBaoChe = new JComboBox<String>();
			modelDangBaoChe = new DefaultComboBoxModel<String>(new String[] { "Dạng Bào Chế" });
			cbDangBaoChe.setModel(modelDangBaoChe);
			cbDangBaoChe.setFont(new Font("Arial", Font.PLAIN, 16));
			cbDangBaoChe.setBounds(640, 476, 260, 35);
			cbDangBaoChe.addActionListener(this);
			themDuLieuDangBaoChe();
			contentPanel.add(cbDangBaoChe);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Hàm Lượng:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 276, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtHamLuong = new JTextField();
			txtHamLuong.setBounds(150, 276, 300, 35);
			contentPanel.add(txtHamLuong);
			txtHamLuong.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("C.Ty SX:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 326, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtCTySX = new JTextField();
			txtCTySX.setBounds(150, 326, 300, 35);
			contentPanel.add(txtCTySX);
			txtCTySX.setColumns(10);
		}

		{
			JLabel lblNewLabel_2 = new JLabel("N.Công Dụng:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 326, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbNhomCongDung = new JComboBox<String>();
			modelNhomCongDung = new DefaultComboBoxModel<String>(new String[] { "Nhóm Công Dụng" });
			cbNhomCongDung.setModel(modelNhomCongDung);
			cbNhomCongDung.setFont(new Font("Arial", Font.PLAIN, 16));
			cbNhomCongDung.setBounds(640, 326, 260, 35);
			cbNhomCongDung.addActionListener(this);
			cbNhomCongDung.addActionListener(this);
			themDuLieuNCongDung();
			contentPanel.add(cbNhomCongDung);
		}

		{
			JLabel lblNewLabel_2 = new JLabel("Nước SX:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 521, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbNuocSX = new JComboBox<String>();
			modelNuocSX = new DefaultComboBoxModel<String>(new String[] { "Nước Sản Xuất" });
			cbNuocSX.setModel(modelNuocSX);
			cbNuocSX.setFont(new Font("Arial", Font.PLAIN, 16));
			cbNuocSX.setBounds(640, 521, 260, 35);
			cbNuocSX.addActionListener(this);
			themDuLieuNuocSanXuat();
			contentPanel.add(cbNuocSX);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("T.T Kinh Doanh:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 141, 150, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbTrangThaiKD = new JComboBox();
			cbTrangThaiKD.setFont(new Font("Arial", Font.PLAIN, 16));
			cbTrangThaiKD.setModel(new DefaultComboBoxModel(new String[] { "Đang Kinh doanh", "Ngừng Bán" }));
			cbTrangThaiKD.setBounds(640, 141, 260, 35);
			contentPanel.add(cbTrangThaiKD);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Thuế VAT");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 376, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtThue = new JTextField();
			txtThue.setBounds(150, 376, 300, 35);
			contentPanel.add(txtThue);
			txtThue.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Số DK");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 421, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtSoDK = new JTextField();
			txtSoDK.setBounds(150, 421, 300, 35);
			contentPanel.add(txtSoDK);
			txtSoDK.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Công Dụng:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(480, 376, 150, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbCongDung = new JComboBox<String>();
			modelCongDung = new DefaultComboBoxModel<String>(new String[] { "Công Dụng" });
			cbCongDung.setModel(modelCongDung);
			cbCongDung.setFont(new Font("Arial", Font.PLAIN, 16));
			cbCongDung.setBounds(640, 376, 260, 35);
			cbCongDung.addActionListener(this);
			contentPanel.add(cbCongDung);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("SL Ban Đầu");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 476, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtSoLuongBanDau = new JTextField();
			txtSoLuongBanDau.setBounds(150, 476, 300, 35);
			contentPanel.add(txtSoLuongBanDau);
			txtSoLuongBanDau.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Hạn SD");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 521, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtHanSD = new JTextField();
			txtHanSD.setBounds(150, 521, 300, 35);
			contentPanel.add(txtHanSD);
			txtHanSD.setColumns(10);
		}

		{
			Connection conn = connect.Connect.CreateConnection();
			lbMaThuoc = new JLabel("Mã Thuốc");
			lbMaThuoc.setText(Dao_Thuoc.phatSinhMaThuocTuDong(conn));
			lbMaThuoc.setFont(new Font("Arial", Font.ITALIC, 16));
			lbMaThuoc.setBounds(150, 141, 110, 35);
			contentPanel.add(lbMaThuoc);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		{
			btnHuy = new JButton("Hủy");
			btnHuy.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/huy.png")));
			btnHuy.setFont(new Font("Arial", Font.PLAIN, 16));
			btnHuy.setBounds(28, 590, 120, 35);
			btnHuy.addActionListener(this);
			contentPanel.add(btnHuy);
		}
		{
			btnLamMoi = new JButton("Làm mới");
			btnLamMoi.addActionListener(this);
			btnLamMoi.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/lammoi.png")));
			btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
			btnLamMoi.setBounds(496, 590, 151, 35);
			contentPanel.add(btnLamMoi);
		}
		{
			btnLuu = new JButton("Lưu");
			btnLuu.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/luu.png")));
			btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnLuu.setBounds(727, 590, 131, 35);
			contentPanel.add(btnLuu);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 653, 936, 10);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
		}

		ArrayList<Thuoc> listThuoc = dao_thuoc.getAllThuoc();
		for (Thuoc thuoc : listThuoc) {
			cbDonViTinh.addItem(thuoc.getDonViTinh());
			cbDangBaoChe.addItem(thuoc.getDangBaoChe());
			cbNuocSX.addItem(thuoc.getNuocSanXuat());
			cbQuyCachDongGoi.addItem(thuoc.getQuyCachDongGoi());
			cbThanhPhan.addItem(thuoc.getThanhPhan());
		}

		ArrayList<CongDung> listCD = dao_congdung.getAllCongDung();
		for (CongDung cd : listCD) {
			cbCongDung.addItem(cd.getCongDung());
		}

		btnHuy.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
	}

	public void themDuLieuNCongDung() {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<String> listNCD = Dao_CongDung.danhSachNCongDung(conn);
		for (String string : listNCD) {
			modelNhomCongDung.addElement(string);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void themDuLieuThanhPhan() {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<String> listTP = Dao_Thuoc.danhSachThanhPhan(conn);
		for (String string : listTP) {
			modelThanhPhan.addElement(string);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void themDuLieuQCDG() {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<String> listQCDG = Dao_Thuoc.danhSachQuyCachDongGoi(conn);
		for (String string : listQCDG) {
			modelQuyCachDongGoi.addElement(string);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void themDuLieuNuocSanXuat() {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<String> listSX = Dao_Thuoc.danhSachNuocSX(conn);
		for (String string : listSX) {
			modelNuocSX.addElement(string);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void themDuLieuDangBaoChe() {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<String> listDBC = Dao_Thuoc.danhSachDangBaoChe(conn);
		for (String string : listDBC) {
			modelDangBaoChe.addElement(string);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void themDuLieuDonViTinh() {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<String> listDVT = Dao_Thuoc.danhSachDVT(conn);
		for (String string : listDVT) {
			modelDonViTinh.addElement(string);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object object = arg0.getSource();
		Connection conn = connect.Connect.CreateConnection();

		if (object.equals(cbNhomCongDung)) {
			ArrayList<String> list = Dao_CongDung.danhSachCongDungTheoNhomCD(conn,
					cbNhomCongDung.getSelectedItem().toString());
			modelCongDung.removeAllElements();
			for (String string : list) {
				modelCongDung.addElement(string);
			}

		} else if (object.equals(btnHuy)) {
			dispose();
		} else if (object.equals(btnLamMoi)) {
			txtTenThuoc.setText("");
			txtGiaBan.setText("");
			txtCTySX.setText("");
			txtHamLuong.setText("");
			txtHanSD.setText("");
			txtSoDK.setText("");
			txtSoLuongBanDau.setText("");
			txtThue.setText("");
			cbCongDung.setSelectedIndex(0);
			cbDangBaoChe.setSelectedIndex(0);
			cbDonViTinh.setSelectedIndex(0);
			cbNuocSX.setSelectedIndex(0);
			cbQuyCachDongGoi.setSelectedIndex(0);
			cbThanhPhan.setSelectedIndex(0);
			cbTrangThaiKD.addItem("Đang Kinh Doanh");
		} else if (object.equals(btnLuu)) {
			Thuoc thuoc = layDuLieu();

			if (thuoc != null) {
				if (Dao_Thuoc.themThuoc(conn, thuoc)) {
					JOptionPane.showMessageDialog(new Frame(), "Them Thuoc Thanh cong");

					dispose(); // dong cua so

				} else {
					JOptionPane.showMessageDialog(new Frame(), "Them Thuoc That bai");
					dispose(); // dong cua so
				}

			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Thuoc layDuLieu() {
		Connection conn = connect.Connect.CreateConnection();

		String tenThuoc = txtTenThuoc.getText().trim();
		Double giaBan = Double.parseDouble(txtGiaBan.getText().trim());
		String donViTinh = cbDonViTinh.getSelectedItem().toString();
		String thanhPhan = cbThanhPhan.getSelectedItem().toString();
		String quyCachDongGoi = cbQuyCachDongGoi.getSelectedItem().toString();
		String dangBaoChe = cbDangBaoChe.getSelectedItem().toString();
		String hamLuong = txtHamLuong.getText().trim();
		String congTySanXuat = txtCTySX.getText().trim();
		String nuocSanXuat = cbNuocSX.getSelectedItem().toString();
		boolean trangThaiKinhDoanh = cbTrangThaiKD.getSelectedItem().toString().equalsIgnoreCase("Đang Kinh Doanh")
				? true
				: false;
		Float thue = Float.parseFloat(txtThue.getText().trim());
		String soDangKy = txtSoDK.getText().trim();
		String congDung = cbCongDung.getSelectedItem().toString();
		String nhomCongDung = cbNhomCongDung.getSelectedItem().toString();
		int soLuongBanDau = Integer.parseInt(txtSoLuongBanDau.getText().trim());
		Date hanSuDung = Date.valueOf(txtHanSD.getText().toString());

		if (tenThuoc.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên thuốc");
			txtTenThuoc.selectAll();
			txtTenThuoc.requestFocus();
			return null;
		}
		if (!tenThuoc.matches("[^!@#$%^&*()_+{}:]*")) {
			JOptionPane.showMessageDialog(this,
					"Tên thuốc phải là chữ(có số hoặc không) và Không được chứa kí tự đặc biệt ");
			txtTenThuoc.selectAll();
			txtTenThuoc.requestFocus();
			return null;
		}
		if (giaBan.toString().trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá bán");
			txtGiaBan.selectAll();
			txtGiaBan.requestFocus();
			return null;
		}

		if (hamLuong.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập hàm lượng");
			txtHamLuong.selectAll();
			txtHamLuong.requestFocus();
			return null;
		}
		if (congTySanXuat.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập công ty sản xuất");
			txtCTySX.selectAll();
			txtCTySX.requestFocus();
			return null;
		}
		if (thue.toString().trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập thuế");
			txtThue.selectAll();
			txtThue.requestFocus();
			return null;
		}
		if (soDangKy.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số đăng ký");
			txtSoDK.selectAll();
			txtSoDK.requestFocus();
			return null;
		}
		if (txtSoLuongBanDau.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng ban đầu");
			txtSoLuongBanDau.selectAll();
			txtSoLuongBanDau.requestFocus();
			return null;
		}

		if (txtHanSD.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập hạn sử dụng");
			txtHanSD.selectAll();
			txtHanSD.requestFocus();
			return null;
		}
		if (soLuongBanDau < 0) {
			JOptionPane.showMessageDialog(this, "Số lượng ban đầu phải lớn hơn hoặc bằng 0");
			txtSoLuongBanDau.selectAll();
			txtSoLuongBanDau.requestFocus();
			return null;
		}
		if (giaBan < 0) {
			JOptionPane.showMessageDialog(this, "Giá bán không được nhỏ hơn 0");
			txtGiaBan.selectAll();
			txtGiaBan.requestFocus();
			return null;
		}
		if (!thue.toString().matches("[0]\\.[0-9]*")) {
			JOptionPane.showMessageDialog(this, "Thuế phải là số thập phân dạng 0.X");
			txtThue.selectAll();
			txtThue.requestFocus();
			return null;
		}
		if (cbNhomCongDung.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn Nhóm công dụng");
			return null;
		}
		if (cbDangBaoChe.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn dạng bào chế");
			return null;
		}
		if (cbDonViTinh.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn đơn vị tính");
			return null;
		}
		if (cbNuocSX.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn nước sản xuất");
			return null;
		}
		if (cbQuyCachDongGoi.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn quy cách đóng gói");
			return null;
		}
		if (cbThanhPhan.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn thành phần");
			return null;
		}

		Thuoc tthuoc = new Thuoc("", tenThuoc, giaBan, donViTinh, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong,
				congTySanXuat, nuocSanXuat, trangThaiKinhDoanh, thue, soDangKy,
				new CongDung("", congDung, nhomCongDung), soLuongBanDau, hanSuDung);

		return tthuoc;
	}
}
