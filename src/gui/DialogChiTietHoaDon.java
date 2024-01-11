package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;



import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.Dao_HoaDon;
import enity.CT_HoaDon;
import enity.HoaDon;
import enity.format;

import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.UIManager;


public class DialogChiTietHoaDon extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JTable table = new JTable();
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_9_1_1;
	private JLabel lblNewLabel_9_1;
	private JScrollPane scrollPane;
	
	public DialogChiTietHoaDon(String maHD) {
		setModal(true);
		
		Connection conn = connect.Connect.CreateConnection();
		HoaDon hoaDon = Dao_HoaDon.getHoaDonTheoMa(conn, maHD);
		setResizable(false);
		
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		setBackground(Color.WHITE);
		setBounds(100, 100, 785, 783);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setForeground(Color.BLACK);
	
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên nhà thuốc: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 22, 118, 13);
		contentPanel.add(lblNewLabel);

		JLabel lblaCh = new JLabel("Địa chỉ: ");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblaCh.setBounds(10, 45, 110, 13);
		contentPanel.add(lblaCh);

		JLabel lblNewLabel_1 = new JLabel("Nhà Thuốc Tư Nhân Phúc Thiện");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(112, 22, 317, 13);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Số 12 Nguyễn Văn Bảo, Phường 4 Gò vấp, TPHCM");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(112, 45, 546, 13);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("HÓA ĐƠN BÁN LẺ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_3.setBounds(211, 98, 350, 53);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNhnVin = new JLabel("Nhân viên:");
		lblNhnVin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNhnVin.setBounds(10, 170, 110, 13);
		contentPanel.add(lblNhnVin);

		JLabel lblKhchHng = new JLabel("Khách hàng:\r\n");
		lblKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKhchHng.setBounds(10, 207, 110, 13);
		contentPanel.add(lblKhchHng);

		JLabel lblNewLabel_4 = new JLabel(hoaDon.getKhachHang().getTenKhachHang().toUpperCase());
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(112, 170, 179, 13);
		contentPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel(hoaDon.getNhanVien().getTenNhanVien().toUpperCase());
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(112, 207, 215, 13);
		contentPanel.add(lblNewLabel_4_1);

		JLabel lblaCh_1 = new JLabel("Địa chỉ\r\n:");
		lblaCh_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblaCh_1.setBounds(317, 207, 409, 13);
		contentPanel.add(lblaCh_1);

		JLabel lblaCh_1_1 = new JLabel("Ngày lập\r\n");
		lblaCh_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblaCh_1_1.setBounds(325, 170, 401, 13);
		contentPanel.add(lblaCh_1_1);

		JLabel lblNewLabel_5 = new JLabel("Mã HD:\r\n");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 68, 70, 13);
		contentPanel.add(lblNewLabel_5);
        
		JLabel lblNewLabel_6 = new JLabel(hoaDon.getMaHoaDonBan());
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(112, 68, 98, 13);
		contentPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_2_1 = new JLabel("Số 12 Nguyễn Văn Bảo, Phường 4 Gò vấp, TPHCM");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_2_1.setBounds(371, 207, 355, 13);
		contentPanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_7 = new JLabel(hoaDon.getNgayLapHDBan());
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel_7.setBounds(410, 170, 316, 13);
		contentPanel.add(lblNewLabel_7);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 751, 367);

		contentPanel.add(scrollPane);
	
		table.setModel(tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Tên thuốc", "DVT", "Số lượng", "Đơn giá", "Thành tiền" }));
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		
		
		
		ArrayList<CT_HoaDon> list = dao.Dao_DialogChiTietHoaDon.chiTietHoaDon(conn, hoaDon.getMaHoaDonBan());
		double theuVat = 0;
		double tong = 0;
		double tienThu = hoaDon.getTienNhan();
		if(list != null) {
			int count = 0;
			for(CT_HoaDon ct_HoaDon: list) {
						
				count += 1;
				theuVat += ct_HoaDon.getThueVat()*(ct_HoaDon.getGiaBan()*ct_HoaDon.getSoLuong());
				
				tong += ct_HoaDon.getGiaBan()*ct_HoaDon.getSoLuong();
				String[] s = { String.valueOf(count), ct_HoaDon.getThuoc().getTenThuoc(), ct_HoaDon.getThuoc().getDonViTinh(),
						String.valueOf(ct_HoaDon.getSoLuong()),format.chuyenDoiTienTe(ct_HoaDon.getGiaBan()),format.chuyenDoiTienTe(ct_HoaDon.getGiaBan())};
				tableModel.addRow(s);
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("ERROE close :truyVanData" + e.getMessage());
		}
		

		JLabel lblNewLabel_8 = new JLabel("Tổng thành tiền:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(451, 630, 122, 20);
		contentPanel.add(lblNewLabel_8);

		JLabel lblNewLabel_8_1 = new JLabel("Thuế VAT:");
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8_1.setBounds(451, 660, 122, 20);
		contentPanel.add(lblNewLabel_8_1);

		lblNewLabel_9 = new JLabel(format.chuyenDoiTienTe(tong));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9.setBounds(570, 630, 156, 20);
		contentPanel.add(lblNewLabel_9);

		lblNewLabel_9_1 = new JLabel(format.chuyenDoiTienTe(theuVat));
	
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9_1.setBounds(570, 660, 156, 20);
		contentPanel.add(lblNewLabel_9_1);

		JLabel lblNewLabel_8_1_1 = new JLabel("Tổng");
		lblNewLabel_8_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8_1_1.setBounds(451, 690, 122, 20);
		contentPanel.add(lblNewLabel_8_1_1);

		lblNewLabel_9_1_1 = new JLabel(format.chuyenDoiTienTe(theuVat+tong));
		lblNewLabel_9_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9_1_1.setBounds(570, 690, 156, 20);
		contentPanel.add(lblNewLabel_9_1_1);

		JLabel lblNewLabel_8_1_1_1 = new JLabel("Khách đưa:\r\n");
		lblNewLabel_8_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8_1_1_1.setBounds(10, 630, 86, 20);
		contentPanel.add(lblNewLabel_8_1_1_1);

		JLabel lblNewLabel_8_1_1_1_1 = new JLabel("Tiền thừa");
		lblNewLabel_8_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8_1_1_1_1.setBounds(10, 660, 78, 20);
		contentPanel.add(lblNewLabel_8_1_1_1_1);

		JLabel lblNewLabel_9_2 = new JLabel(format.chuyenDoiTienTe(hoaDon.getTienNhan()));
		lblNewLabel_9_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9_2.setBounds(92, 630, 304, 20);
		contentPanel.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_2_1 = new JLabel(format.chuyenDoiTienTe(hoaDon.getTienNhan() - hoaDon.getTongTien()));
		lblNewLabel_9_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9_2_1.setBounds(92, 660, 284, 20);
		contentPanel.add(lblNewLabel_9_2_1);
		format format1 = new format();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		System.out.println(hoaDon.getTienNhan());

	}
	
}