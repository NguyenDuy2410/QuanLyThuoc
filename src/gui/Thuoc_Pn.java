package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.Dao_CongDung;
import dao.Dao_Thuoc;
import enity.CongDung;
import enity.Thuoc;

public class Thuoc_Pn extends JPanel implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField txtTen;
	private static JTextField txtHoatChat;
	private static JTable table;
	private JButton btnLui1;
	private JButton btnTien1;
	private JButton btnTienCuoi;
	private JButton btnLuiCuoi;
	private static JLabel lblSoTrang;
	private JButton btnNgungBan;
	private JButton btnChiTiet;
	private JButton btnSuaChua;
	private JButton btnLamMoi;
	private JButton btnThem;
	private static JComboBox<String> cboNuocSanXuat;
	private static JComboBox<String> cboDVT;
	private static JComboBox<String> cboDangBaoChe;
	private static JComboBox<String> cboNCongDung;
	private static JComboBox<String> cboCongDung;
	private static DefaultTableModel model;

	private static ArrayList<Thuoc> listThuoc;

	public Thuoc_Pn() {

		setBackground(Color.white);
		setLayout(null);
		setSize(1091, 570);

		JLabel lblNewLabel = new JLabel("Tên thuốc: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 465, 98, 22);
		add(lblNewLabel);

		JLabel lblHotCht = new JLabel("Hoạt chất: ");
		lblHotCht.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHotCht.setBounds(584, 457, 98, 22);
		add(lblHotCht);

		JLabel lblNhpm = new JLabel("N.Công dụng: ");
		lblNhpm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhpm.setBounds(20, 498, 109, 22);
		add(lblNhpm);

		JLabel lblCngDng = new JLabel("Công dụng: ");
		lblCngDng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngDng.setBounds(584, 490, 98, 22);
		add(lblCngDng);

		txtTen = new JTextField();
		txtTen.setBounds(128, 457, 400, 30);
		add(txtTen);
		txtTen.setColumns(10);

		txtHoatChat = new JTextField();
		txtHoatChat.setColumns(10);
		txtHoatChat.setBounds(703, 457, 378, 30);
		add(txtHoatChat);

		cboNCongDung = new JComboBox<String>();
		cboNCongDung.setBounds(128, 493, 400, 30);
		add(cboNCongDung);

		cboCongDung = new JComboBox<String>();
		cboCongDung.setBounds(703, 493, 378, 30);
		add(cboCongDung);

		JLabel lblDngBoCh = new JLabel("Dạng bào chế: ");
		lblDngBoCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDngBoCh.setBounds(20, 538, 109, 22);
		add(lblDngBoCh);

		cboDangBaoChe = new JComboBox<String>();
		cboDangBaoChe.setBounds(128, 530, 400, 30);
		add(cboDangBaoChe);

		JLabel lblCngDng_1 = new JLabel("ĐVTính: ");
		lblCngDng_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngDng_1.setBounds(584, 530, 98, 22);
		add(lblCngDng_1);

		cboDVT = new JComboBox<String>();
		cboDVT.setBounds(703, 530, 125, 30);
		add(cboDVT);

		JLabel lblCngDng_1_1 = new JLabel("Nước SX: ");
		lblCngDng_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngDng_1_1.setBounds(870, 530, 98, 22);
		add(lblCngDng_1_1);

		cboNuocSanXuat = new JComboBox<String>();
		cboNuocSanXuat.setBounds(978, 530, 103, 30);
		add(cboNuocSanXuat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 907, 371);
		add(scrollPane);
		model = new DefaultTableModel(new String[] { "Tên thuốc", "Thành phần", "Dạng bào chế", "ĐVT", "Hàm lượng",
				"Nước sản xuất", "Nhóm công dụng", "Công dụng", "Giá (Vnđ)", "Số lượng", "Trạng Thái kinh doanh" }, 0);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 410, 1130, 37);
		add(panel_1);
		panel_1.setLayout(null);

		btnLuiCuoi = new JButton("");
		btnLuiCuoi.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/previousEnd.png")));
		btnLuiCuoi.setBounds(315, 0, 89, 37);
		panel_1.add(btnLuiCuoi);

		btnLui1 = new JButton("");
		btnLui1.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/rewind-button.png")));
		btnLui1.setBounds(414, 0, 89, 37);
		panel_1.add(btnLui1);

		btnTien1 = new JButton("");
		btnTien1.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/nextbutton.png")));
		btnTien1.setBounds(574, 0, 89, 37);
		panel_1.add(btnTien1);

		btnTienCuoi = new JButton("");
		btnTienCuoi.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/nextEnd.png")));
		btnTienCuoi.setBounds(684, 0, 89, 37);
		panel_1.add(btnTienCuoi);

		lblSoTrang = new JLabel("1");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoTrang.setBounds(518, 0, 46, 37);
		panel_1.add(lblSoTrang);

		table.setRowHeight(35);
		cboDangBaoChe.setFont(new Font("Arial", Font.PLAIN, 16));
		cboDangBaoChe.setModel(new DefaultComboBoxModel<String>(new String[] { "Tất cả", "dung dịch tiêm",
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

		cboNuocSanXuat.setFont(new Font("Arial", Font.PLAIN, 16));
		cboNuocSanXuat.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Tất cả", "Việt Nam", "Pháp", "India", "France", "Đức", "Germany", "Anh", "Mỹ",
						"Na Uy, đóng gói Ý", "Italy", "VietNam", "Ý, đóng gói Anh", "Áo", "Mỹ, Đóng gói Đức", "Thụy Sỹ",
						"Slovenia", "Hàn Quốc", "Tây Ban Nha, đóng gói Anh", "Bỉ", "Indonesia", "Hy Lạp", "Ukraine",
						"Cyprus", "Ý", "Greece", "Thụy Sỹ (xuất xưởng: Hà Lan)", "Síp", "Nhật", "Bồ Đào Nha", "Hungary",
						"Taiwan", "Poland", "Korea", "Mỹ; Đóng gói: Đức", "Bỉ", "Ấn Độ", "Bulgaria", "Portugal" }));

		cboDVT.setFont(new Font("Arial", Font.PLAIN, 16));
		cboDVT.setModel(new DefaultComboBoxModel<String>(new String[] { "Tất cả", "Bịch nhựa", "Lọ", "Ống", "Chai",
				"Tuýp", "Hộp", "Viên", "Miếng", "Viên sủi", "Chai thủy tinh", "Chai nhựa" }));

		cboNCongDung.addItem("Tất cả");
		cboNCongDung.setFont(new Font("Arial", Font.PLAIN, 16));
		ArrayList<CongDung> list1 = new Dao_CongDung().getNCongDung();
		for (CongDung congDung : list1) {
			cboNCongDung.addItem(congDung.getNhomCongDung());
		}

		cboCongDung.addItem("Tất cả");
		cboCongDung.setFont(new Font("Arial", Font.PLAIN, 16));
		ArrayList<CongDung> list2 = new Dao_CongDung().getCongDung();
		for (CongDung congDung : list2) {
			cboCongDung.addItem(congDung.getCongDung());
		}

		btnThem = new JButton("Thêm");
		btnThem.setBounds(940, 323, 141, 47);
		add(btnThem);
		btnThem.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/them.png")));
		btnThem.setFont(new Font("Arial", Font.PLAIN, 14));

		addInToTable();
		btnLui1.addActionListener(this);
		btnLuiCuoi.addActionListener(this);
		btnTien1.addActionListener(this);
		btnTienCuoi.addActionListener(this);

		txtTen.addKeyListener(this);
		txtHoatChat.addKeyListener(this);

		cboCongDung.addActionListener(this);
		cboDangBaoChe.addActionListener(this);
		cboDVT.addActionListener(this);
		cboNCongDung.addActionListener(this);
		cboNuocSanXuat.addActionListener(this);

		btnThem.addActionListener(this);

		table.addMouseListener(this);

		btnNgungBan = new JButton("Ngừng bán");
		btnNgungBan.setBounds(940, 29, 141, 47);
		add(btnNgungBan);
		btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stop.png")));
		btnNgungBan.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNgungBan.addActionListener(this);

		btnChiTiet = new JButton("Chi tiết");
		btnChiTiet.setBounds(940, 102, 141, 47);
		add(btnChiTiet);
		btnChiTiet.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/xemchitiet.png")));
		btnChiTiet.setFont(new Font("Arial", Font.PLAIN, 14));

		btnChiTiet.addActionListener(this);

		btnSuaChua = new JButton("Sửa");
		btnSuaChua.setBounds(940, 173, 141, 47);
		add(btnSuaChua);
		btnSuaChua.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/sua.png")));
		btnSuaChua.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSuaChua.addActionListener(this);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(940, 248, 141, 47);
		add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/lammoi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLamMoi.addActionListener(this);
	}

	public static Thuoc dataChiTietThuoc() {
		int row = table.getSelectedRow();
		if (row == -1) {
			return null;
		}
		String maThuoc = table.getValueAt(row, 0).toString();
		Connection con = connect.Connect.CreateConnection();
		Thuoc thuoc = Dao_Thuoc.getThuocTheoMa(con, maThuoc);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thuoc;

	}

	public static void addInToTable() {
		Connection con = connect.Connect.CreateConnection();

		int page = Integer.parseInt(lblSoTrang.getText());

		String ten = txtTen.getText();
		String thanhPhan = txtHoatChat.getText();
		String nhomCongDung = "";
		if (cboNCongDung.getSelectedIndex() != 0)
			nhomCongDung = cboNCongDung.getSelectedItem().toString();
		String congDung = "";
		if (cboCongDung.getSelectedIndex() != 0)
			congDung = cboCongDung.getSelectedItem().toString();
		String dangBaoChe = "";
		if (cboDangBaoChe.getSelectedIndex() != 0)
			dangBaoChe = cboDangBaoChe.getSelectedItem().toString();
		String dvt = "";
		if (cboDVT.getSelectedIndex() != 0)
			dvt = cboDVT.getSelectedItem().toString();
		String nuoc = "";
		if (cboNuocSanXuat.getSelectedIndex() != 0)
			nuoc = cboNuocSanXuat.getSelectedItem().toString();

		listThuoc = Dao_Thuoc.danhSachThuoc(con, page - 1, ten, thanhPhan, dvt, congDung, nhomCongDung, dangBaoChe,
				nuoc);

		for (Thuoc thuoc : listThuoc) {
			model.addRow(new Object[] { thuoc.getTenThuoc(), thuoc.getThanhPhan(), thuoc.getDangBaoChe(),
					thuoc.getDonViTinh(), thuoc.getHamLuong(), thuoc.getNuocSanXuat(),
					thuoc.getCongDung().getNhomCongDung(), thuoc.getCongDung().getCongDung(), thuoc.getGiaBan(),
					thuoc.getSoLuongBanDau(), thuoc.isTrangThaiKinhDoanh() ? "Đang kinh doanh" : "Ngừng kinh doanh" });
		}
	}

	public void khoiTaoDuLieu() {
		xoaToanBoBang();
		addInToTable();
	}

	public static void xoaToanBoBang() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		Connection con = connect.Connect.CreateConnection();
		int tongHang = Dao_Thuoc.tongHang(con, "", "", "", "");
		int tongPage = tongHang % 20 == 0 ? tongHang / 20 : (tongHang / 20) + 1;
		if (o.equals(btnChiTiet)) {
			int row = table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần xem chi tiết");
			} else {
				new ChiTietThuoc_JFrame(listThuoc.get(row).getMaThuoc()).setVisible(true);
			}
		}
		if (o.equals(btnTien1)) {

			int page = Integer.parseInt(lblSoTrang.getText()) + 1;
			btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stopping.png")));
			btnNgungBan.setText("Ngừng bán");
			if (page <= tongPage) {
				lblSoTrang.setText(Integer.toString(page));
				xoaToanBoBang();
				table.clearSelection();
				addInToTable();

			}

		}
		if (o.equals(btnLui1)) {
			int page = Integer.parseInt(lblSoTrang.getText()) - 1;
			btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stopping.png")));
			btnNgungBan.setText("Ngừng bán");
			if (page >= 1) {
				lblSoTrang.setText(Integer.toString(page));
				xoaToanBoBang();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnTienCuoi)) {
			int page = Integer.parseInt(lblSoTrang.getText());
			btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stopping.png")));
			btnNgungBan.setText("Ngừng bán");
			if (page != tongPage) {
				lblSoTrang.setText(Integer.toString(tongPage));
				xoaToanBoBang();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnLuiCuoi)) {
			int page = Integer.parseInt(lblSoTrang.getText());
			btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stopping.png")));
			btnNgungBan.setText("Ngừng bán");
			if (page != 1) {
				lblSoTrang.setText(Integer.toString(1));
				xoaToanBoBang();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnLamMoi)) {
			btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stopping.png")));
			btnNgungBan.setText("Ngừng bán");
			txtTen.setText("");
			txtHoatChat.setText("");
			cboDangBaoChe.setSelectedIndex(0);
			cboNuocSanXuat.setSelectedIndex(0);
			cboDVT.setSelectedIndex(0);

			lblSoTrang.setText("1");
			xoaToanBoBang();
			table.clearSelection();
			addInToTable();
		}
		if (o.equals(cboCongDung) || o.equals(cboDVT) || o.equals(cboDangBaoChe) || o.equals(cboNCongDung)
				|| o.equals(cboNuocSanXuat)) {
			lblSoTrang.setText("1");
			xoaToanBoBang();
			addInToTable();
		}
		if (o.equals(btnSuaChua)) {
			int row = table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần sửa");
			} else {
				Thuoc thuoc = listThuoc.get(row);
				SuaThuoc_JFrame s = new SuaThuoc_JFrame(thuoc);
				s.setVisible(true);

			}
		}
		if (o.equals(btnNgungBan)) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn thuốc");
			} else {
				String ma = listThuoc.get(row).getMaThuoc();
				boolean tt = listThuoc.get(row).isTrangThaiKinhDoanh();
				int check;
				if (tt) {
					check = JOptionPane.showConfirmDialog(null, "Bạn có muốn ngừng bán", "Thông báo",
							JOptionPane.YES_NO_OPTION);
				} else {
					check = JOptionPane.showConfirmDialog(null, "Bạn có muốn bán lại", "Thông báo",
							JOptionPane.YES_NO_OPTION);
				}
				if (check == JOptionPane.YES_OPTION) {

					boolean t = Dao_Thuoc.setNgungBan(con, !tt, ma);
					if (t) {
						JOptionPane.showMessageDialog(null, "Thành công");
						listThuoc.get(row).setTrangThaiKinhDoanh(!tt);

						if (!tt) {
							btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stop.png")));
							btnNgungBan.setText("Ngừng bán");
							table.setValueAt("Đang Kinh doanh", row, 10);
						} else {
							btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/banhang.png")));
							btnNgungBan.setText("Bán lại");
							table.setValueAt("Ngừng Kinh doanh", row, 10);
						}
					} else
						JOptionPane.showMessageDialog(null, "Thất bại");
				}
			}
		}
		if (o.equals(btnThem)) {
			new DialogThemThuoc().setVisible(true);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		Object o = e.getSource();
		if (o.equals(txtTen) || o.equals(txtHoatChat)) {
			lblSoTrang.setText("1");
			xoaToanBoBang();
			addInToTable();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();

		boolean trangThai = listThuoc.get(row).isTrangThaiKinhDoanh();
		if (trangThai) {
			btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stopping.png")));
			btnNgungBan.setText("Ngừng bán");

		} else {
			btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/money-bag.png")));
			btnNgungBan.setText("Bán lại");

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
