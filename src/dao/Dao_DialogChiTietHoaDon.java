package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enity.CT_HoaDon;
import enity.HoaDon;
import enity.KhachHang;
import enity.NhanVien;
import enity.Thuoc;

public class Dao_DialogChiTietHoaDon {

	public static ArrayList<CT_HoaDon> chiTietHoaDon(Connection conn, String maHD) {
		ArrayList<CT_HoaDon> list = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select * from CT_HoaDonBan join  Thuoc on  CT_HoaDonBan.maThuoc = Thuoc.maThuoc  where maHoaDonBan = '"
					+ maHD
					+"'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			list = new ArrayList<CT_HoaDon>();
			while (rs.next()) {
				CT_HoaDon ct_HoaDon = new CT_HoaDon();
				ct_HoaDon.setSoLuong(rs.getInt("soLuong"));
				ct_HoaDon.setHoaDon(null);
				ct_HoaDon.setThuoc(new Thuoc(rs.getString("maThuoc"), rs.getString("tenThuoc"), null, rs.getString("donViTinh"), sql, sql, sql, sql, sql, sql, false, 0, sql, null, 0, null));
				ct_HoaDon.setGiaBan(rs.getDouble("giaBan"));
				ct_HoaDon.setThueVat(rs.getFloat("thueVat"));
				
				list.add(ct_HoaDon);
			}
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu hoa don That bai . (chiTietHoaDon)" + e.getMessage());
		}finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (chiTietHoaDon)" + e.getMessage());
			}
		}
		if (list.size() == 0) {
			return null;
		}
		return list;
	}
}