package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.Dao_Thuoc;
import enity.Thuoc;

public class SuaThuoc_JFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenThuoc;
	private JTextField txtTrangThai;
	private JTextField txtGiaBan;
	private JTextField txtVAT;
	private JTextField txtSoDangKy;
	private JTextField txtHoatChat;
	private JTextField txtHamLuong;
	private JTextField txtHangSX;
	private JButton btnHuy;
	private JButton btnLu;
	private JComboBox<String> cboDVT;
	private JLabel lblTenthuoc;
	private JLabel lblGiaBan;
	private JComboBox<String> cboDBC;
	private JComboBox<String> cboNuocSX;
	private JTextField txtQCDG;
	private Thuoc thuoc;

	public SuaThuoc_JFrame( Thuoc thuoc) {
		this.thuoc = thuoc;
		setModalExclusionType(getModalExclusionType());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		setBounds(100, 100, 1185, 614);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabel1 = new JLabel();
		jLabel1.setBackground(new Color(51, 51, 102));
		jLabel1.setOpaque(true);
		jLabel1.setText("Sửa thông tin thuốc");
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setForeground(Color.WHITE);
		jLabel1.setFont(new Font("Arial", Font.BOLD, 25));
		jLabel1.setBounds(0, 0, 1184, 45);
		contentPane.add(jLabel1);

		lblTenthuoc = new JLabel();
		lblTenthuoc.setText("Tên thuốc:");
		lblTenthuoc.setPreferredSize(new Dimension(101, 17));
		lblTenthuoc.setMinimumSize(new Dimension(101, 17));
		lblTenthuoc.setMaximumSize(new Dimension(101, 17));
		lblTenthuoc.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenthuoc.setBounds(23, 74, 101, 30);
		contentPane.add(lblTenthuoc);

		txtTenThuoc = new JTextField();
		txtTenThuoc.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTenThuoc.setBounds(134, 74, 895, 30);
		contentPane.add(txtTenThuoc);

		txtTrangThai = new JTextField();
		txtTrangThai.setHorizontalAlignment(SwingConstants.CENTER);
		txtTrangThai.setText("Đang kinh doanh");
		txtTrangThai.setForeground(Color.RED);
		txtTrangThai.setFont(new Font("Arial", Font.ITALIC, 14));
		txtTrangThai.setEditable(false);
		txtTrangThai.setBorder(null);
		txtTrangThai.setBackground(Color.WHITE);
		txtTrangThai.setBounds(1039, 74, 135, 30);
		contentPane.add(txtTrangThai);

		lblGiaBan = new JLabel();
		lblGiaBan.setText("Giá bán:");
		lblGiaBan.setPreferredSize(new Dimension(101, 17));
		lblGiaBan.setMinimumSize(new Dimension(101, 17));
		lblGiaBan.setMaximumSize(new Dimension(101, 17));
		lblGiaBan.setFont(new Font("Arial", Font.BOLD, 14));
		lblGiaBan.setBounds(23, 129, 101, 30);
		contentPane.add(lblGiaBan);

		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Arial", Font.PLAIN, 14));
		txtGiaBan.setBounds(134, 129, 289, 30);
		contentPane.add(txtGiaBan);

		JLabel lblQCDG7 = new JLabel();
		lblQCDG7.setText("VAT(%):");
		lblQCDG7.setFont(new Font("Arial", Font.BOLD, 14));
		lblQCDG7.setBounds(433, 129, 50, 30);
		contentPane.add(lblQCDG7);

		txtVAT = new JTextField();
		txtVAT.setFont(new Font("Arial", Font.PLAIN, 14));
		txtVAT.setBounds(493, 129, 289, 30);
		contentPane.add(txtVAT);

		JLabel lblQCDG12 = new JLabel();
		lblQCDG12.setText("ĐVT:");
		lblQCDG12.setFont(new Font("Arial", Font.BOLD, 14));
		lblQCDG12.setBounds(800, 129, 31, 30);
		contentPane.add(lblQCDG12);

		cboDVT = new JComboBox<String>();
		cboDVT.setFont(new Font("Arial", Font.BOLD, 14));
		cboDVT.setBackground(new Color(153, 153, 153));
		cboDVT.setBounds(841, 129, 315, 30);
		contentPane.add(cboDVT);

		JLabel lblQCDG2 = new JLabel();
		lblQCDG2.setText("Dạng bào chế:");
		lblQCDG2.setFont(new Font("Arial", Font.BOLD, 14));
		lblQCDG2.setBounds(23, 185, 100, 30);
		contentPane.add(lblQCDG2);

		JLabel lblMaThuoc = new JLabel();
		lblMaThuoc.setText("Số đăng ký:");
		lblMaThuoc.setPreferredSize(new Dimension(101, 17));
		lblMaThuoc.setMinimumSize(new Dimension(101, 17));
		lblMaThuoc.setMaximumSize(new Dimension(101, 17));
		lblMaThuoc.setFont(new Font("Arial", Font.BOLD, 14));
		lblMaThuoc.setBounds(23, 245, 107, 30);
		contentPane.add(lblMaThuoc);

		txtSoDangKy = new JTextField();
		txtSoDangKy.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSoDangKy.setFocusable(false);
		txtSoDangKy.setEditable(false);
		txtSoDangKy.setBackground(new Color(245, 245, 245));
		txtSoDangKy.setBounds(134, 246, 1022, 30);
		contentPane.add(txtSoDangKy);

		JLabel lblTenHC = new JLabel();
		lblTenHC.setText("Hoạt chất:");
		lblTenHC.setPreferredSize(new Dimension(101, 17));
		lblTenHC.setMinimumSize(new Dimension(101, 17));
		lblTenHC.setMaximumSize(new Dimension(101, 17));
		lblTenHC.setFont(new Font("Arial", Font.BOLD, 14));
		lblTenHC.setBounds(611, 300, 81, 30);
		contentPane.add(lblTenHC);

		txtHoatChat = new JTextField();
		txtHoatChat.setFont(new Font("Arial", Font.PLAIN, 14));
		txtHoatChat.setBounds(697, 301, 459, 30);
		contentPane.add(txtHoatChat);

		JLabel lblQCDG6 = new JLabel();
		lblQCDG6.setText("Hàm lượng:");
		lblQCDG6.setPreferredSize(new Dimension(101, 17));
		lblQCDG6.setMinimumSize(new Dimension(101, 17));
		lblQCDG6.setMaximumSize(new Dimension(101, 17));
		lblQCDG6.setFont(new Font("Arial", Font.BOLD, 14));
		lblQCDG6.setBounds(23, 301, 107, 30);
		contentPane.add(lblQCDG6);

		txtHamLuong = new JTextField();
		txtHamLuong.setFont(new Font("Arial", Font.PLAIN, 14));
		txtHamLuong.setBounds(134, 301, 459, 30);
		contentPane.add(txtHamLuong);

		JLabel lblQCDG = new JLabel();
		lblQCDG.setText("QC đóng gói:");
		lblQCDG.setPreferredSize(new Dimension(101, 17));
		lblQCDG.setMinimumSize(new Dimension(101, 17));
		lblQCDG.setMaximumSize(new Dimension(101, 17));
		lblQCDG.setFont(new Font("Arial", Font.BOLD, 14));
		lblQCDG.setBounds(23, 355, 107, 30);
		contentPane.add(lblQCDG);

		JLabel lblQCDG4 = new JLabel();
		lblQCDG4.setText("Hãng sản xuất:");
		lblQCDG4.setPreferredSize(new Dimension(101, 17));
		lblQCDG4.setMinimumSize(new Dimension(101, 17));
		lblQCDG4.setMaximumSize(new Dimension(101, 17));
		lblQCDG4.setFont(new Font("Arial", Font.BOLD, 14));
		lblQCDG4.setBounds(23, 416, 107, 30);
		contentPane.add(lblQCDG4);

		txtHangSX = new JTextField();
		txtHangSX.setFont(new Font("Arial", Font.PLAIN, 14));
		txtHangSX.setBounds(134, 416, 459, 30);
		contentPane.add(txtHangSX);

		JLabel lblQCDG5 = new JLabel();
		lblQCDG5.setText("Nước SX:");
		lblQCDG5.setPreferredSize(new Dimension(101, 17));
		lblQCDG5.setMinimumSize(new Dimension(101, 17));
		lblQCDG5.setMaximumSize(new Dimension(101, 17));
		lblQCDG5.setFont(new Font("Arial", Font.BOLD, 14));
		lblQCDG5.setBounds(611, 416, 107, 30);
		contentPane.add(lblQCDG5);

		btnHuy = new JButton();
		btnHuy.setIcon(new ImageIcon(SuaThuoc_JFrame.class.getResource("/img/stopping.png")));
		btnHuy.setToolTipText("Hủy thêm nhân viên");
		btnHuy.setText("Hủy");
		btnHuy.setFont(new Font("Arial", Font.BOLD, 16));
		btnHuy.setBackground(new Color(204, 204, 204));
		btnHuy.setBounds(23, 503, 131, 41);
		contentPane.add(btnHuy);

		btnLu = new JButton();
		btnLu.setIcon(new ImageIcon(SuaThuoc_JFrame.class.getResource("/img/cap_nhat.png")));
		btnLu.setToolTipText("Thêm nhân viên");
		btnLu.setText("Lưu");
		btnLu.setFont(new Font("Arial", Font.BOLD, 16));
		btnLu.setBackground(new Color(204, 204, 204));
		btnLu.setBounds(1016, 503, 140, 41);
		contentPane.add(btnLu);

		JSeparator separator = new JSeparator();
		separator.setBounds(23, 117, 1133, 14);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 171, 1133, 14);
		contentPane.add(separator_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(23, 231, 1133, 14);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(23, 289, 1133, 14);
		contentPane.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(23, 342, 1133, 14);
		contentPane.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(23, 399, 1133, 14);
		contentPane.add(separator_6);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(23, 460, 1133, 14);
		contentPane.add(separator_7);

		txtTenThuoc.setText(thuoc.getTenThuoc());
		txtGiaBan.setText(thuoc.getGiaBan().toString());
		txtHamLuong.setText(thuoc.getHamLuong());
		txtHangSX.setText(thuoc.getCongTySanXuat());
		txtHoatChat.setText(thuoc.getThanhPhan());
		txtSoDangKy.setText(thuoc.getSoDangKy());
		txtVAT.setText(thuoc.getThue() + "");

		cboDVT.setModel(new DefaultComboBoxModel<String>(new String[] { "Bịch nhựa", "Lọ", "Ống", "Chai", "Tuýp", "Hộp",
				"Viên", "Miếng", "Viên sủi", "Chai thủy tinh", "Chai nhựa" }));

		cboDVT.setSelectedItem(thuoc.getDonViTinh());

		cboDBC = new JComboBox<String>();
		cboDBC.setBounds(134, 186, 1022, 30);
		contentPane.add(cboDBC);

		cboNuocSX = new JComboBox<String>();
		cboNuocSX.setFont(new Font("Arial", Font.BOLD, 14));
		cboNuocSX.setBackground(new Color(153, 153, 153));
		cboNuocSX.setBounds(696, 416, 460, 30);
		contentPane.add(cboNuocSX);

		cboNuocSX.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Việt Nam", "Pháp", "India", "France", "Đức", "Germany", "Anh", "Mỹ",
						"Na Uy, đóng gói Ý", "Italy", "VietNam", "Ý, đóng gói Anh", "Áo", "Mỹ, Đóng gói Đức", "Thụy Sỹ",
						"Slovenia", "Hàn Quốc", "Tây Ban Nha, đóng gói Anh", "Bỉ", "Indonesia", "Hy Lạp", "Ukraine",
						"Cyprus", "Ý", "Greece", "Thụy Sỹ (xuất xưởng: Hà Lan)", "Síp", "Nhật", "Bồ Đào Nha", "Hungary",
						"Taiwan", "Poland", "Korea", "Mỹ; Đóng gói: Đức", "Bỉ", "Ấn Độ", "Bulgaria", "Portugal" }));
		cboNuocSX.setSelectedItem(thuoc.getNuocSanXuat());

		cboDBC.setModel(new DefaultComboBoxModel<String>(new String[] { "dung dịch tiêm",
				"Thuốc tiêm (gây tê tủy sống)", "Nhũ dịch tiêm truyền", "dung dịch để hít",
				"Chất lỏng dễ bay hơi dùng gây mê đường hô hấp", "hơi dùng gây mê đường hô hấp", "Thuốc tiêm", "Gel",
				"Kem bôi", "Nhũ tương dùng tiêm hoặc truyền tĩnh mạch", "Nhũ tương tiêm hoặc truyền tĩnh mạch",
				"Nhũ tương để tiêm hoặc tiêm truyền tĩnh mạch", "Nhũ tương để tiêm hoặc truyền", "Dung dịch hít",
				"Chất lỏng dễ bay hơi dung gây mê đường hô hấp", "Viên nang", "Viên nang cứng ( trắng - trắng)",
				"Viên nang cứng", "Gel bôi ngoài da", "Dung dịch nhỏ mắt", "Viên nén", "viên nén bao phim",
				"Miếng dán phóng thích qua da", "dung dịch tiêm", "Viên sủi", "Viên", "Dung dịch tiêm truyền tĩnh mạch",
				"dung dịch tiêm truyền", "dung dịch truyền tĩnh mạch", "Bột pha dung dịch đậm đặc pha dung dịch truyền",
				"Dung dịch đậm đặt để pha dung dịch tiêm truyền", "Dung dịch tiêm truyền",
				"Dung dịch đậm đặc pha tiêm truyền", "thuốc tiêm đông khô",
				"Dung dịch đậm đặc để tiêm hoặc tiêm truyền tĩnh mạ", "Thuốc Bột", "bột pha tiêm",
				"dung dịch vô khuẩn dùng trong phẫu thuật", "Viên tác dụng kéo dài", "viên nén dài bao phim",
				"viên bao phim tan trong ruột", "Viên nén bao phim phóng thích kéo dài", "viên nén dài",
				"Viên nang cam-kem", "Bột pha dung dịch tiêm hoặc truyền tĩnh mạch", "thuốc tiêm bột",
				"Viên nén bao phim giải phóng chậm", "viên nang cứng (xám+vàng)", "Bột pha dung dịch tiêm/truyền",
				"Hộp 1 lọ thuốc + 1 ống 10 ml dung môi pha tiêm", "Thuốc tiêm",
				"Bột pha dung dịch tiêm/truyền tĩnh mạch", "bột đông khô pha tiêm hoặc tiêm truyền" }));
		cboDBC.setSelectedItem(thuoc.getDangBaoChe());

		txtQCDG = new JTextField();
		txtQCDG.setText((String) null);
		txtQCDG.setFont(new Font("Arial", Font.PLAIN, 14));
		txtQCDG.setBounds(134, 356, 1022, 30);
		contentPane.add(txtQCDG);

		txtQCDG.setText(thuoc.getQuyCachDongGoi());

		btnLu.addActionListener(this);
		btnHuy.addActionListener(this);

		if (thuoc.isTrangThaiKinhDoanh())
			txtTrangThai.setText("Đang kinh doanh");
		else
			txtTrangThai.setText("Ngừng kinh doanh");
		
	
	}
	public boolean validData() {
		String gia = txtGiaBan.getText().trim();
		try {
			Double.parseDouble(gia);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Thông báo giá bán sai");
			txtGiaBan.selectAll();
			txtGiaBan.requestFocus();
			return false;
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLu)&& validData()) {
			String ten = txtTenThuoc.getText();
			Double gia = Double.parseDouble(txtGiaBan.getText());
			float vat = Float.parseFloat(txtVAT.getText());
			String dvt = cboDVT.getSelectedItem().toString();
			String dbc = cboDBC.getSelectedItem().toString();
			String sdk = txtSoDangKy.getText();
			String hl = txtHamLuong.getText();
			String hc = txtHoatChat.getText();
			String dg = txtQCDG.getText();
			String hangsx = txtHangSX.getText();
			String nuocsx = cboNuocSX.getSelectedItem().toString();

			Thuoc thuoc1 = new Thuoc(thuoc.getMaThuoc(), ten, gia, dvt, hc, dg, dbc, hl, hangsx, nuocsx,
					thuoc.isTrangThaiKinhDoanh(), vat, sdk, thuoc.getCongDung(), thuoc.getSoLuongBanDau(),
					thuoc.getHanSuDung());

			Connection con = connect.Connect.CreateConnection();
			boolean tt = Dao_Thuoc.capNhatThuoc(con, thuoc.getMaThuoc(), thuoc1);
			if (tt)
			{
				JOptionPane.showMessageDialog(null, "Sửa thành công");
				Thuoc_Pn.xoaToanBoBang();
				Thuoc_Pn.addInToTable();
				this.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(null, "Sửa không thành công");
		} else {
			dispose();
		}
		
	}
}
