package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Dao_DiaChi;
import dao.Dao_KhachHang;
import enity.DiaChi;
import enity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class DialogThemKhachHang extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTenKhachHang;
	private JTextField txtSDT;
	private JComboBox<String> cbTinhTP;
	private JComboBox<String> cbQuanHuyen;
	private DefaultComboBoxModel<String> modalQuanHuyen;
	private DefaultComboBoxModel<String> modelTinh;
	private DefaultComboBoxModel<String> modalPhuongXa;
	private JComboBox<String> cbGioiTinh;
	private JButton btnHuy;
	private JButton btnLamMoi;
	private JButton btnLuu;
	private JLabel lbMaKhachHang;
	private JComboBox<String> cbPhuongXa;
	private DialogThemKhachHangResponse response;

	public interface  DialogThemKhachHangResponse{
		void getResponse(KhachHang khachHang);
	}

	public DialogThemKhachHang(DialogThemKhachHangResponse dialogThemKhachHangResponse ) {
		setResizable(false);
		response = dialogThemKhachHangResponse;
		setModal(true);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 850, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nhà Thuốc Tư Nhân Phúc Thiện");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBounds(136, 10, 582, 78);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Thêm khách hàng");
			lblNewLabel_1.setForeground(new Color(0, 0, 128));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_1.setBounds(301, 89, 255, 31);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Mã Khách hàng:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(25, 141, 131, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Giới tính:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(567, 141, 110, 35);
contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Tên khách hàng:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(25, 198, 131, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbGioiTinh = new JComboBox<String>();
			cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
			cbGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] { "Nam", "Nữ", "Khác" }));
			cbGioiTinh.setBounds(674, 141, 131, 35);
			contentPanel.add(cbGioiTinh);
		}
		{
			lbMaKhachHang = new JLabel("");
			lbMaKhachHang.setFont(new Font("Arial", Font.ITALIC, 16));
			lbMaKhachHang.setBounds(170, 141, 341, 35);
			maKhachHang(); // phat sinh ma khach hang
			contentPanel.add(lbMaKhachHang);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Địa chỉ:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(25, 255, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			btnHuy = new JButton("Hủy");
			btnHuy.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/huy.png")));
			btnHuy.setFont(new Font("Arial", Font.PLAIN, 16));
			btnHuy.setBounds(28, 400, 120, 35);
			btnHuy.addActionListener(this);
			contentPanel.add(btnHuy);
		}
		{
			btnLamMoi = new JButton("Làm mới");
			btnLamMoi.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/lammoi.png")));
			btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
			btnLamMoi.setBounds(513, 400, 120, 35);
			btnLamMoi.addActionListener(this);
			contentPanel.add(btnLamMoi);
		}
		{
			btnLuu = new JButton("Lưu");
			btnLuu.addActionListener(this);
			btnLuu.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/luu.png")));
			btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnLuu.setBounds(674, 400, 131, 35);
			contentPanel.add(btnLuu);
		}
		{
			txtTenKhachHang = new JTextField();
			txtTenKhachHang.setBounds(170, 200, 635, 35);
			contentPanel.add(txtTenKhachHang);
			txtTenKhachHang.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("SĐT:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(25, 310, 44, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtSDT = new JTextField();
			txtSDT.setBounds(170, 310, 635, 35);
			contentPanel.add(txtSDT);
			txtSDT.setColumns(10);
		}

		cbTinhTP = new JComboBox<String>();
		modelTinh = new DefaultComboBoxModel<String>(new String[] { "Tỉnh/TP" });
		cbTinhTP.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTinhTP.setModel(modelTinh);
		cbTinhTP.addActionListener(this);
		cbTinhTP.setBounds(170, 255, 200, 35);
		themDuLieuTinh();
		contentPanel.add(cbTinhTP);

		cbQuanHuyen = new JComboBox<String>();
		modalQuanHuyen = new DefaultComboBoxModel<String>(new String[] { "Quận/Huyện" });
		cbQuanHuyen.addActionListener(this);
		cbQuanHuyen.setModel(modalQuanHuyen);
		cbQuanHuyen.setFont(new Font("Arial", Font.PLAIN, 16));
cbQuanHuyen.setBounds(387, 255, 200, 35);
		contentPanel.add(cbQuanHuyen);

		cbPhuongXa = new JComboBox<String>();
		cbPhuongXa.setFont(new Font("Arial", Font.PLAIN, 16));
		modalPhuongXa = new DefaultComboBoxModel<String>(new String[] { "Phường xã" });
		cbPhuongXa.setModel(modalPhuongXa);
		cbPhuongXa.addActionListener(this);
		cbPhuongXa.setBounds(605, 255, 200, 35);
		contentPanel.add(cbPhuongXa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	public void maKhachHang() {
		Connection conn = connect.Connect.CreateConnection();
		lbMaKhachHang.setText(dao.Dao_KhachHang.phatSinhMaKhachHang(conn));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void themDuLieuTinh() {
		Connection conn = connect.Connect.CreateConnection();

		ArrayList<String> list = Dao_DiaChi.danhSachTinhTP(conn);
		for (String string : list) {
			modelTinh.addElement(string);
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public KhachHang layDuLieu() {
		String sdt = txtSDT.getText();
		Connection conn = connect.Connect.CreateConnection();
		String tenKhachHang =  txtTenKhachHang.getText().toString().trim();
		
		
		if(tenKhachHang.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Tên nhân khách hàng không được rỗng");
			txtTenKhachHang.selectAll();
			txtTenKhachHang.requestFocus();
			return null;
		}
		if(!tenKhachHang.matches("[^0-9!@#$%^&*()_+{}:]*")) {
			JOptionPane.showMessageDialog(this, "Tên nhân khách hàng phải là chữ Không được chứa số và kí tự đặc biệt");
			txtTenKhachHang.selectAll();
			txtTenKhachHang.requestFocus();
			return null;
		}
		String tinh = cbTinhTP.getSelectedItem().toString();
		if(cbTinhTP.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this,"Bạn chưa chọn địa chỉ");
			return null;
		}
		
		if(sdt.equals("")){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập số điện thoại");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return null;
		}
		
		else if(!sdt.matches("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			txtSDT.selectAll();
			txtSDT.requestFocus();
			JOptionPane.showMessageDialog(this,"Số điện thoại không đúng địng dạng");
			return null;
		}else if(!Dao_KhachHang.kiemTraSoDienThoai(conn, sdt)){
			JOptionPane.showMessageDialog(this,"Số điện thoại đã tồn tại ");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return null;
		}
	
		KhachHang khachHang = new KhachHang(lbMaKhachHang.getText(), tenKhachHang, cbGioiTinh.getSelectedIndex() == 0 ?true:false, sdt, new DiaChi(" ", tinh, cbQuanHuyen.getSelectedItem().toString(), cbPhuongXa.getSelectedItem().toString()));
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHang;
		
			
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		Connection conn = connect.Connect.CreateConnection();

		if (object.equals(cbTinhTP)) {
			ArrayList<String> list = Dao_DiaChi.danhSachQuanHuyenTheoTinh(conn, cbTinhTP.getSelectedItem().toString());
			modalQuanHuyen.removeAllElements();
			for (String string : list) {
				modalQuanHuyen.addElement(string);
			}
		} else if (object.equals(cbQuanHuyen)) {

			if (cbQuanHuyen.getSelectedItem() != null) {
				String quanHuyen = cbQuanHuyen.getSelectedItem().toString();
				ArrayList<String> list = Dao_DiaChi.danhSachPhuongXaTheoQuanHuyen(conn, quanHuyen);
				modalPhuongXa.removeAllElements();
				for (String string : list) {
					modalPhuongXa.addElement(string);
				}
			}

		} else if (object.equals(btnHuy)) {
			response.getResponse(null);
			dispose();
		} else if (object.equals(btnLamMoi)) { 
			txtSDT.setText("");
			txtTenKhachHang.setText("");
			cbTinhTP.setSelectedIndex(0);
			cbQuanHuyen.addItem("Quận Huyện");
			cbPhuongXa.addItem("Phường xã");
			
		} else if (object.equals(btnLuu)) { 
			KhachHang khachHang = layDuLieu();
			if (khachHang != null && Dao_KhachHang.themKhachHang(conn, khachHang)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công");
				if(response != null) {
					response.getResponse(khachHang);
				}
				dispose();
			}

		}

	}
}