package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import enity.CT_HoaDon;
import enity.HoaDon;
import enity.KhachHang;
import enity.NhanVien;

public class Dao_HoaDon {

	
	public static ArrayList<HoaDon> timHoaDon(Connection conn, String maHD,String tenKH,String sdt_KH,String sdt_NV,String ngayLapHD,int cmb,int page) {
		ArrayList<HoaDon> list = null;
		Statement st = null;
		ResultSet rs = null;
		long millis=System.currentTimeMillis();
		Date date = new java.sql.Date(millis);
		if (maHD == null)
			maHD = "";
		if (tenKH == null)
			tenKH = "";
		if (sdt_KH == null)	
			sdt_KH = "";
		if (sdt_NV == null)
			sdt_NV = "";
		if (ngayLapHD == null)
			ngayLapHD = "";
		if (cmb == 0) {
			date = java.sql.Date.valueOf("0001-01-1");
		}else if(cmb == 1) {
			date = java.sql.Date.valueOf(LocalDate.now().toString());
		}else if(cmb == 2) {
			date = java.sql.Date.valueOf(LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-1");
		}else if(cmb == 3) {
			date = java.sql.Date.valueOf(LocalDate.now().getYear()+"-01-1");
		}
		int offset = page*25;
		try {
			
			String sql = "select * from HoaDon_View where "
					+ "maHoaDonBan like '%"
					+ maHD 
					+ "%' and tenKhachHang like N'%"
					+ tenKH
					+ "%' and soDienThoai like N'%"
					+ sdt_KH
					+ "%' and soDienThoaiNV like '%"
					+ sdt_NV
					+ "%' and ngayLapHDBan like '%"
					+ ngayLapHD
					+ "%' and ngayLapHDBan >= '"
					+ date
					+"' order by maHoaDonBan desc" + " OFFSET " + offset + " ROWS FETCH NEXT 20 ROWS ONLY";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			list = new ArrayList<HoaDon>();
			while (rs.next()) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDonBan(rs.getString("maHoaDonBan"));
				hoaDon.setNgayLapHDBan(rs.getString("ngayLapHDBan"));
				hoaDon.setNhanVien(new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),  rs.getString("soDienThoaiNV")));
				hoaDon.setKhachHang(new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),  rs.getString("soDienThoai")));
				hoaDon.setTongTien(rs.getDouble("tongTien"));
				list.add(hoaDon);
				
			}
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu hoa don That bai . (danhSachHoaDon)" + e.getMessage());
		}finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachHoaDon)" + e.getMessage());
			}
		}
		
		
		if (list.size() == 0) {
			return null;
		}
		return list;
	}
	public static int getCount(Connection conn, String maHD,String tenKH,String sdt_KH,String sdt_NV,String ngayLapHD,int cmb) {

			int count = 0;
			Statement st = null;
			ResultSet rs = null;
			long millis=System.currentTimeMillis();
			Date date = new java.sql.Date(millis);
			if (maHD == null)
				maHD = "";
			if (tenKH == null)
				tenKH = "";
			if (sdt_KH == null)	
				sdt_KH = "";
			if (sdt_NV == null)
				sdt_NV = "";
			if (ngayLapHD == null)
				ngayLapHD = "";
			if (cmb == 0) {
				date = java.sql.Date.valueOf("0001-01-1");
			}else if(cmb == 1) {
				date = java.sql.Date.valueOf(LocalDate.now().toString());
			}else if(cmb == 2) {
				date = java.sql.Date.valueOf(LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-1");
			}else if(cmb == 3) {
				date = java.sql.Date.valueOf(LocalDate.now().getYear()+"-01-1");
			}	
			
			try {
				
				String sql = "select count(*) from HoaDon_View where "
						+ "maHoaDonBan like '%"
						+ maHD 
						+ "%' and tenKhachHang like N'%"
						+ tenKH
						+ "%' and soDienThoai like N'%"
						+ sdt_KH
						+ "%' and soDienThoaiNV like '%"
						+ sdt_NV
						+ "%' and ngayLapHDBan like '%"
						+ ngayLapHD
						+ "%' and ngayLapHDBan >= '"
						+ date
						+"' and ngayLapHDBan <= '"+LocalDate.now().toString()+"'";
				st = conn.createStatement();
				rs = st.executeQuery(sql);

				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				System.err.println("ERROR: Doc du lieu hoa don That bai . (danhSachHoaDon)" + e.getMessage());
			}finally {
				try {
					st.close();
					rs.close();
				} catch (SQLException e) {
					System.err.println("ERROR: close . (danhSachHoaDon)" + e.getMessage());
				}
			}
			return count;
		
	}
	// Khoi tao ma Hoa don tu dong
	public static String phatSinhMaTuDong(Connection conn) {
		String sql = "select max(maHoaDonBan) from HoaDonBan";
		Statement st = null;
		ResultSet rs = null;
		String maHoaDon = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				throw new Exception("Khong co du lieu");
			}
			maHoaDon = rs.getString(1);

			maHoaDon = "HD" + MaTuDong.fomatAA000000(maHoaDon.substring(2));
		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (phasinhmaTuDong) DAO_HOADON" + e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (phasinhmaTuDong) DAO_HOADON" + e.getMessage());
			}
		}
		return maHoaDon;
	}
	// them hoa don 
	public static boolean themHoaDon(Connection conn ,ArrayList<CT_HoaDon> list_CT_HoaDon) {
		if(list_CT_HoaDon == null || list_CT_HoaDon.size() == 0) {
			return false;
		}
		PreparedStatement ptmt = null;
		int check = 0;
		String sql1 = " insert into HoaDonBan values(?,?,?,?,?)";
		
		try {
			// them hoa don ban
			ptmt = conn.prepareStatement(sql1);
			String maHoaDonBan = phatSinhMaTuDong(conn); // phat sinh ma Hoa don tu dong
			ptmt.setString(1, maHoaDonBan);
			ptmt.setDate(2, java.sql.Date.valueOf(list_CT_HoaDon.get(0).getHoaDon().getNgayLapHDBan()));
			ptmt.setString(3, list_CT_HoaDon.get(0).getHoaDon().getNhanVien().getMaNhanVien());
			ptmt.setString(4, list_CT_HoaDon.get(0).getHoaDon().getKhachHang().getMaKhachHang());
			ptmt.setDouble(5, list_CT_HoaDon.get(0).getHoaDon().getTienNhan());
			check = ptmt.executeUpdate();
			if(check == 0 ) { // neu k them duoc hoa don ban thi huy
				return false;
			}
			check = 0; // kiem tra CT_hoa don co them duoc khong
			// them CT hoa don ban
			for (CT_HoaDon ct_HoaDon : list_CT_HoaDon) {
				String sql2 = " insert into CT_HoaDonBan values(?,?,?,?,?)";
				ptmt = conn.prepareStatement(sql2);
				ptmt.setInt(1, ct_HoaDon.getSoLuong());
				ptmt.setString(2, ct_HoaDon.getThuoc().getMaThuoc());
				ptmt.setString(3, maHoaDonBan);
				ptmt.setDouble(4, ct_HoaDon.getGiaBan());
				ptmt.setFloat(5, (float) (ct_HoaDon.getThueVat() == 0 ? 0.1:ct_HoaDon.getThueVat()));
				check += ptmt.executeUpdate();
			}
		} catch (Exception e) {
			System.err.println("ERROR: Them that bai. (themHoaDon)" + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (themHoaDon)" + e.getMessage());
			}
		}
		if (check == 0) {
			return false;
		}
		return true;
	}

	
	public static HoaDon getHoaDonTheoMa(Connection conn, String maHD){
		HoaDon hoaDon = new HoaDon();
		Statement st = null;
		ResultSet rs = null;
	
		try {
			
			String sql = "select * from HoaDon_View where "
					+ "maHoaDonBan = '"
					+ maHD  +"'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if (rs.next()) {
			
				hoaDon.setMaHoaDonBan(rs.getString("maHoaDonBan"));
				hoaDon.setNgayLapHDBan(rs.getString("ngayLapHDBan"));
				hoaDon.setNhanVien(new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"),  rs.getString("soDienThoaiNV")));
				hoaDon.setKhachHang(new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"),  rs.getString("soDienThoai")));
				hoaDon.setTongTien(rs.getDouble("tongTien"));
				hoaDon.setTienNhan(rs.getDouble("tienNhan"));
			}
	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hoaDon;
	}
}