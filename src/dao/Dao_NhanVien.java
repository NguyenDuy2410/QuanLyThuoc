
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enity.DiaChi;
import enity.NhanVien;

public class Dao_NhanVien {
	// lay danh sach nhan vien
	// 1 trang co 20 nhan vien
	public static ArrayList<NhanVien> DanhSachNhanVien(Connection conn, int page, String txtSearch, String trangThaiLamViec) {

		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		Statement st = null;
		ResultSet rs = null;
		if(txtSearch == null)
			txtSearch = "";

		// tinh phan trang
		int offset = page * 20;// lay du lieu bat dau tu vi tri page*20

		try {
			String ttlv = "";
			if (trangThaiLamViec.equals("1")) {
				ttlv = "1"; 
			}else if(trangThaiLamViec.equals("0")) {
				ttlv = "0"; 
			}
			
			String sql = "select * from NhanVien inner join DiaChi on  NhanVien.maDC = DiaChi.maDC where tenNhanVien like N'%"+txtSearch+"%'  and trangThaiLamViec like '%" + ttlv +"%' " 
					+ " order by maNhanVien desc" + " OFFSET " + offset + " ROWS FETCH NEXT 20 ROWS ONLY;";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				// false nu : true nam
				// true dang lam viec : false da nghi viec
				NhanVien nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
				nhanVien.setCmnd(rs.getString("cmnd"));
				nhanVien.setGioiTinh(rs.getBoolean("gioiTinh")) ;
				nhanVien.setPassLogin(rs.getString("passLogin"));
				nhanVien.setSoDienThoaiNV(rs.getString("soDienThoaiNV"));
				nhanVien.setTrangThaiLamViec(rs.getBoolean("trangThaiLamViec"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setDiaChi(new DiaChi(rs.getString("maDC"), rs.getString("tinhTp"), rs.getString("quanHuyen"),
						rs.getString("phuongXa")));
				list.add(nhanVien);
				
			}
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu nhan vien That bai . (danhSachNhanVien)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachNhanVien)" + e.getMessage());
			}

		}
		
		return list;
	}

	public static NhanVien layThongTinNhanVienQuaSDT(Connection conn,String sdt) {
		Statement st = null;
		ResultSet rs = null;
		NhanVien nhanVien = null;
		try {
			String sql = "select * from NhanVien inner join DiaChi on  NhanVien.maDC = DiaChi.maDC where soDienThoaiNV = '"+sdt+"'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				// false nu : true nam
				// true dang lam viec : false da nghi viec
				nhanVien = new NhanVien();
				nhanVien.setMaNhanVien(rs.getString("maNhanVien"));
				nhanVien.setCmnd(rs.getString("cmnd"));
				nhanVien.setGioiTinh(rs.getBoolean("gioiTinh") );
				nhanVien.setPassLogin(rs.getString("passLogin"));
				nhanVien.setSoDienThoaiNV(rs.getString("soDienThoaiNV"));
				nhanVien.setTrangThaiLamViec(rs.getBoolean("trangThaiLamViec"));
				nhanVien.setTenNhanVien(rs.getString("tenNhanVien"));
				nhanVien.setDiaChi(new DiaChi(rs.getString("maDC"), rs.getString("tinhTp"), rs.getString("quanHuyen"),
				rs.getString("phuongXa")));	
			}	
		} catch (Exception e) {
			System.err.println("ERROR: Doc du lieu nhan vien That bai . (TimNhanVienQuaSDT)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachNhanVien)" + e.getMessage());
			}
		}
		return nhanVien;
		
	}
	
	public static int tongHang(Connection conn,String txtSearch,String trangThaiLamViec) {
		
		String ttlv = "";
		if (trangThaiLamViec.equals("1")) {
			ttlv = "1"; 
		}else if(trangThaiLamViec.equals("0")) {
			ttlv = "0"; 
		}
		
		String sql = "select COUNT(*) from nhanvien where tenNhanVien like N'%"+txtSearch+"%'  and trangThaiLamViec like '%" + ttlv +"%'"; 
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				throw new Exception("Khong co du lieu");
			}
			count = rs.getInt(1);

		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (tongHang)" + e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (tongHang)" + e.getMessage());
			}
		}
		return count;
	}

	public static String phatSinhMaTuDong(Connection conn) {
		String sql = "select max(maNhanVien) from nhanvien";
		Statement st = null;
		ResultSet rs = null;
		String maNhanVien = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				throw new Exception("Khong co du lieu");
			}
			maNhanVien = rs.getString(1);

			maNhanVien = "NV" + MaTuDong.fomatAA000000(maNhanVien.substring(2));
		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (phasinhmaTuDong)" + e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (phasinhmaTuDong)" + e.getMessage());
			}
		}
		return maNhanVien;
	}
	
	public static boolean themNhanVien(Connection conn, NhanVien nhanVien) {
		PreparedStatement ptmt = null;
		int check = 0;
		String sql = "  insert into NhanVien(maNhanVien ,tenNhanVien ,gioiTinh, soDienThoaiNV, passLogin,trangThaiLamViec, loaiNV, cmnd, maDC) values (?,?,?,?,?,?,?,?,?);";
		try {
			ptmt = conn.prepareStatement(sql);
			String maNhanVien = phatSinhMaTuDong(conn); // phat sinh ma nhan vien tu dong
			nhanVien.setMaNhanVien(maNhanVien);
			// lay ma Dia chi tren database
			String maDC = Dao_DiaChi.getMaDC(conn, nhanVien.getDiaChi().getTinhTp(),
					nhanVien.getDiaChi().getQuanHuyen(), nhanVien.getDiaChi().getPhuongXa());

			ptmt.setString(1, maNhanVien);
			ptmt.setString(2, nhanVien.getTenNhanVien());
			ptmt.setBoolean(3, nhanVien.isGioiTinh());
			ptmt.setString(4, nhanVien.getSoDienThoaiNV());
			ptmt.setString(5, nhanVien.getPassLogin());
			ptmt.setBoolean(6, nhanVien.isTrangThaiLamViec());
			ptmt.setString(7, nhanVien.getCmnd().trim());
			ptmt.setBoolean(8, false); 
			ptmt.setString(9, maDC);
			
			check = ptmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("ERROR: Them that bai. (themNhanVien)" + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (themNhanVien)" + e.getMessage());
			}
		}
		// fix bug tam thoi
		suaCmnd(conn,nhanVien.getMaNhanVien(), nhanVien.getCmnd());
		if (check == 0) {
			return false;
		}
		return true;
	}
	public static boolean suaCmnd(Connection conn,String maNhanVien, String cmnd) {
		PreparedStatement ptmt = null;
		int i = 0;
		try {
			String sql = "UPDATE NhanVien SET " +  " cmnd = '"+cmnd 
					+ "' WHERE maNhanVien = '"+maNhanVien+"'";
			ptmt = conn.prepareStatement(sql);
			i = ptmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("ERROR: Sua Nhan vien That bai . (suaCmnd) " + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (suaCmnd)" + e.getMessage());
			}

		}
		if (i != 0) {
			return true;
		}
		return false;
	}
	

	public static boolean suaNhanVien(Connection conn, NhanVien nhanVien) {
		PreparedStatement ptmt = null;
		int i = 0;
		try {
			String sql = "UPDATE NhanVien SET " + "tenNhanVien = ?," + " gioiTinh = ?, " + "soDienThoaiNV = ?, "
					+ "passLogin = ?, " + " trangThaiLamViec = ?," + " cmnd = ? , " + " maDC = ? "
					+ "WHERE maNhanVien = ?;";

			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, nhanVien.getTenNhanVien());
			ptmt.setBoolean(2, nhanVien.isGioiTinh());
			ptmt.setString(3, nhanVien.getSoDienThoaiNV());
			ptmt.setString(4, nhanVien.getPassLogin());
			ptmt.setBoolean(5, nhanVien.isTrangThaiLamViec());
			ptmt.setString(6, nhanVien.getCmnd());
			ptmt.setString(7, Dao_DiaChi.getMaDC(conn, nhanVien.getDiaChi().getTinhTp(),
					nhanVien.getDiaChi().getQuanHuyen(), nhanVien.getDiaChi().getPhuongXa()));
			ptmt.setString(8, nhanVien.getMaNhanVien());
			i = ptmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("ERROR: Sua Nhan vien That bai . (danhSachNhanVien) " + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachNhanVien)" + e.getMessage());
			}

		}
		if (i != 0) {
			return true;
		}
		return false;
	}
	public static boolean suaTrangThaiLamViec(Connection conn, String maNhanVien, boolean trangThaiLamViec) {
		PreparedStatement ptmt = null;
		try {
			String sql = "UPDATE NhanVien SET " + "trangThaiLamViec = ? \n" + "WHERE maNhanVien = ?;";

			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, trangThaiLamViec ? 1 : 0);
			ptmt.setString(2, maNhanVien);
			ptmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR: Sua Trang thai lam viec that baio . (danhSachNhanVien) " + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachNhanVien)" + e.getMessage());
			}

		}
		return false;
	}
	// kiem tra so dien thoai co ton tai hay chua
	public static boolean kiemTraSoDienThoai(Connection conn, String sdt) {
		String sql = "select * from nhanvien where soDienThoaiNV= '"+sdt+"'";
		Statement st = null;
		ResultSet rs = null;
		boolean check = false;
		String maNhanVien = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				maNhanVien = rs.getString(1);
			};
			
		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (kiemTraSoDienThoai)" + e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (kiemTraSoDienThoai)" + e.getMessage());
			}
		}
		if(maNhanVien == null) {
			return true;
		}
		return check;
	}
	// kiem tra so Chung minh nhan dan co ton tai hay chua
		public static boolean kiemTraSoChungMinhNhanDan(Connection conn, String cmnd) {
			String sql = "select * from nhanvien where cmnd = '"+cmnd.trim()+"'";
			Statement st = null;
			boolean check = false;
			ResultSet rs = null;
			String maNhanVien = null;
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				if(rs.next()) {
					maNhanVien = rs.getString(1);
				}
				
				
			} catch (Exception e) {
				System.err.println("ERROR: lay du lieu loi . (kiemTraSoChungMinhNhanDan)" + e.getMessage());
			} finally {
				try {
					st.close();
				} catch (SQLException e) {
					System.err.println("ERROR: close . (kiemTraSoChungMinhNhanDan)" + e.getMessage());
				}
			}
			if(maNhanVien == null) {
				return true;
			}
			return check;
		}
	// Kiem tra dang nhap
	public static boolean dangNhap(Connection conn, String sdt,String pass) {
		String sql = "select * from nhanvien where soDienThoaiNV= '"+sdt+"' and passLogin = '"+pass+"'";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (dangNhap)" + e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (dangNhap)" + e.getMessage());
			}
		}
		return false;
	}
	// lay ma nhan vien qua so dien thoau
	public static String layMaNhanVienQuaSoDienThoai(Connection conn, String sdt) {
		String sql = "select maNhanVien from nhanvien where soDienThoaiNV = '"+sdt +"'";
		Statement st = null;
		ResultSet rs = null;
		String maNhanVien = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				throw new Exception("Khong co du lieu");
			}
			maNhanVien = rs.getString(1);
		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (layMaNhanVienQuaSoDienThoai)" + e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (layMaNhanVienQuaSoDienThoai)" + e.getMessage());
			}
		}
		return maNhanVien;
	}
	public static boolean xoaNhanVien(Connection conn, String maNhanVien) {
		PreparedStatement ptmt = null;
		int i = 0;
		try {
			String sql = "delete from NhanVien where maNhanVien = ?";
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, maNhanVien);
			ptmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println("ERROR:xoa Nhan vien that bai . (xoaNhanVien) " + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (xoaNhanVien)" + e.getMessage());
			}
		}
		if (i != 0) {
			return true;// sua thanh cong
		}
		return false;
	}
}
