package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enity.DiaChi;
import enity.KhachHang;
import enity.NhanVien;

public class Dao_KhachHang {

	// phat sinh ma khach hang
	public static String phatSinhMaKhachHang(Connection conn) {
		// tinh phan trang
	
		
		try {
			String sql = "select max(MaKhachHang) from KhachHang";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				return "KH"+MaTuDong.fomatAA000000(rs.getString(1).substring(2));

			}
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (DanhSachKhachHang)" + e.getMessage());
			}
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu nhan vien That bai . (DanhSachKhachHang)" + e.getMessage());
		}
		return null;
	}
	// lay du lieu
	public static ArrayList<KhachHang> danhSachKhachHang(Connection conn, int page, String txtSearch, String gioiTinh) {

		ArrayList<KhachHang> list = null;
		Statement st = null;
		ResultSet rs = null;
		if (txtSearch == null)
			txtSearch = "";
		if (gioiTinh == null)
			gioiTinh = "";

		// tinh phan trang
		int offset = page * 20;// lay du lieu bat dau tu vi tri page*20

		try {
			String sql = "select * from KhachHang inner join DiaChi on  KhachHang.maDC = DiaChi.maDC where tenKhachHang like N'%"
					+ txtSearch + "%' and gioiTinh like '%" + gioiTinh + "%'" + " order by maKhachHang desc "
					+ " OFFSET " + offset + " ROWS FETCH NEXT 20 ROWS ONLY";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			list = new ArrayList<KhachHang>();
			while (rs.next()) {
				// false nu : true nam
				// true dang lam viec : false da nghi viec
				KhachHang khachHang = new KhachHang();
				khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
				khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
				khachHang.setSoDienThoai(rs.getString("soDienThoai"));
				khachHang.setMaKhachHang(rs.getString("MaKhachHang"));
				khachHang.setDiaChi(new DiaChi(rs.getString("maDC"), rs.getString("tinhTp"), rs.getString("quanHuyen"),
						rs.getString("phuongXa")));
				list.add(khachHang);
			}
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu nhan vien That bai . (DanhSachKhachHang)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (DanhSachKhachHang)" + e.getMessage());
			}
		}
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public static KhachHang layThongTinKhachHangQuaSDT(Connection conn, String sdt) {

		// tinh phan trang
		KhachHang khachHang = null;
		if (!sdt.matches("[0-9]+")) {
			return null;
		}
		try {
			String sql = "select * from KhachHang inner join DiaChi on  KhachHang.maDC = DiaChi.maDC where soDienThoai = "
					+ sdt;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				khachHang = new KhachHang();
				khachHang.setTenKhachHang(rs.getString("tenKhachHang"));
				khachHang.setGioiTinh(rs.getBoolean("gioiTinh"));
				khachHang.setSoDienThoai(rs.getString("soDienThoai"));
				khachHang.setMaKhachHang(rs.getString("MaKhachHang"));
				khachHang.setDiaChi(new DiaChi(rs.getString("maDC"), rs.getString("tinhTp"), rs.getString("quanHuyen"),
						rs.getString("phuongXa")));
			}
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (DanhSachKhachHang)" + e.getMessage());
			}
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu nhan vien That bai . (DanhSachKhachHang)" + e.getMessage());
		}
		return khachHang;
	}

	
	
	public static int tongSoHang(Connection conn,String txtSearch ,String trangThaiLamViec) {
		try {
			String ttlv = "";
			if (trangThaiLamViec.equals("1")) {
				ttlv = "1"; 
			}else if(trangThaiLamViec.equals("0")) {
				ttlv = "0"; 
			}
			String sql = "select COUNT(*) from KhachHang where tenKhachHang like N'%"+txtSearch+"%'  and gioiTinh like '%" + ttlv +"%'"; 
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt(1);
			}
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (tongSoHang)" + e.getMessage());
			}
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu nhan vien That bai . (tongSoHang)" + e.getMessage());
		}
		return -1;

	}
	public static boolean themKhachHang (Connection conn , KhachHang khachHang) {
		String sql = "insert into KhachHang values(?,?,?,?,?,?)";
		PreparedStatement ptmt = null;
		int check =  0;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, khachHang.getMaKhachHang());
			ptmt.setString(2,khachHang.getTenKhachHang());
			ptmt.setBoolean(3, khachHang.isGioiTinh());
			ptmt.setString(4, khachHang.getSoDienThoai());
			ptmt.setBoolean(5, true);
			ptmt.setString(6, Dao_DiaChi.getMaDC(conn, khachHang.getDiaChi().getTinhTp(), khachHang.getDiaChi().getQuanHuyen(), khachHang.getDiaChi().getPhuongXa()));
			check =  ptmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("ERROR:  (themKhachHang)" + e.getMessage());	
			
		}finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (themKhachHang)" + e.getMessage());
			}
		}
		if(check == 0)
			return false;
		return true;
	}
	// true la chua ton tai sdt 
	public static boolean kiemTraSoDienThoai(Connection conn, String sdt) {
		String sql = "select * from khachHang where soDienThoai= '"+sdt+"'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (kiemTraSoDienThoai)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (kiemTraSoDienThoai)" + e.getMessage());
			}
		}
		return false;
	}
	public static Boolean suaKhachHang(Connection conn,KhachHang khachHang) {

		PreparedStatement ptmt = null;
		int check = 0;
		try {
			String sql = "update KhachHang set tenKhachHang = ?,"
					+ "gioiTinh = ?,"
					+ " soDienThoai = ? ,"
					+ " maDC = ? "
					+ "where maKhachHang = ? ";
			ptmt =  conn.prepareStatement(sql);
			ptmt.setString(1, khachHang.getTenKhachHang());
			ptmt.setBoolean(2, khachHang.isGioiTinh());
			ptmt.setString(3, khachHang.getSoDienThoai());
			ptmt.setString(4, khachHang.getDiaChi().getMaDC()); // tui lam bang 2 cach (khac voi them) 
			ptmt.setString(5, khachHang.getMaKhachHang());
			check = ptmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu nhan vien That bai . (DanhSachKhachHang)" + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (DanhSachKhachHang)" + e.getMessage());
			}
		}
		if(check == 0) {
			return false;
		}
		return true;
	}

}
