package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enity.DiaChi;
import enity.NhanVien;

public class Dao_DiaChi {
	public static String getMaDC(Connection conn,String tinhTp, String quanHuyen, String phuongXa) {
		Statement st = null;
		ResultSet rs = null;
		String maDC = null;
		String sql = "  select maDC from DiaChi where tinhTp = N'"+tinhTp+"' and quanHuyen = N'"+quanHuyen+"' and phuongXa = N'"+phuongXa+"'";
		try {
			st  = conn.createStatement();
			rs = st.executeQuery(sql);
			if(!rs.next()) {
				throw new Exception("K ti thay maDC");
			}
			return rs.getString(1);
		} catch (Exception e) {
			System.err.println("ERROR (getMaDC)"+e.getMessage());
		}
		return maDC;
	}
	public static ArrayList<String> danhSachTinhTP(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT tinhTP FROM DiaChi order by tinhTP";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu tinh that bai . (danhSachTinh)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachTinh)" + e.getMessage());
			}

		}
		return list;
	}
	public static ArrayList<String> danhSachQuanHuyen(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT quanHuyen FROM DiaChi";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu tinh that bai . (danhSachTinh)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachTinh)" + e.getMessage());
			}

		}
		return list;
	}
	public static ArrayList<String> danhSachPhuongXa(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT phuongXa FROM DiaChi";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu tinh that bai . (danhSachTinh)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachTinh)" + e.getMessage());
			}

		}
		return list;
	}
	
	public static ArrayList<String> danhSachQuanHuyenTheoTinh(Connection conn,String tinhTP){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT quanHuyen FROM DiaChi where tinhTP like N'%"+tinhTP+"%' order by quanHuyen";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu tinh that bai . (danhSachQuanHuyenTheoTinh)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachQuanHuyenTheoTinh)" + e.getMessage());
			}

		}
		return list;
	}
	public static ArrayList<String> danhSachPhuongXaTheoQuanHuyen(Connection conn,String quanHuyen){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT phuongXa FROM DiaChi where quanHuyen like N'%"+quanHuyen+"%'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu danhSachPhuongXaTheoQuanHuyen that bai . (danhSachPhuongXaTheoQuanHuyen)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachPhuongXaTheoQuanHuyen)" + e.getMessage());
			}

		}
		return list;
	}
	
	public static ArrayList<String> danhSachTinhTPTheoQuanHuyen(Connection conn,String quanHuyen){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT DISTINCT tinhTP FROM DiaChi where quanHuyen like N'%"+quanHuyen+"%'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu tinh that bai . (danhSachTinhTPTheoQuanHuyen)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachTinhTPTheoQuanHuyen)" + e.getMessage());
			}

		}
		return list;
	}
	public static void main(String[] args) {
		Connection conn = connect.Connect.CreateConnection();
		ArrayList<String> list = danhSachTinhTP(conn);
		for (String string : list) {
			System.out.println(string);
		}
	}
}
