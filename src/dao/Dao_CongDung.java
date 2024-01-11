package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.Connect;
import enity.CongDung;


public class Dao_CongDung {
	public ArrayList<CongDung> getNCongDung(){
		ArrayList<CongDung> list = new ArrayList<CongDung>();
		try {
			Connection con = connect.Connect.CreateConnection();
			PreparedStatement st = con.prepareStatement("select nhomCongDung from CongDung group by nhomCongDung");
			ResultSet rt = st.executeQuery();
			while(rt.next()) {
				list.add(new CongDung("", "", rt.getString("nhomCongDung")));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public ArrayList<CongDung> getCongDung(){
		ArrayList<CongDung> list = new ArrayList<CongDung>();
		try {
			Connection con = connect.Connect.CreateConnection();
			PreparedStatement st = con.prepareStatement("select CongDung from CongDung group by CongDung");
			ResultSet rt = st.executeQuery();
			while(rt.next()) {
				list.add(new CongDung("", rt.getString("CongDung").trim(), ""));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new Dao_CongDung().getCongDung());
	}
	
	public static ArrayList<CongDung> getAllCongDung() {
		ArrayList<CongDung> danhSach = new ArrayList<CongDung>();
		
		try {
			
			Connection con = Connect.CreateConnection();
			String sql = "select DISTINCT * from CongDung" ;
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				String macongdung = resultSet.getString(1);
				String congdung = resultSet.getString(2);
				String nhomcongdung = resultSet.getString(3);
				CongDung cd = new CongDung(congdung, nhomcongdung);
				danhSach.add(cd);

			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return danhSach;
	}
	public static String getMaCD(Connection conn,String congDung, String nhomCongDung) {
		Statement st = null;
		ResultSet rs = null;
		String maCD = null;
		String sql = "  select maCongDung from CongDung where congDung = N'"+congDung+"' and nhomCongDung = N'"+nhomCongDung+"'";
		try {
			st  = conn.createStatement();
			rs = st.executeQuery(sql);
			if(!rs.next()) {
				// k tim thay ma
				throw new Exception("K tim thay maCongDung");
			}
			return rs.getString(1);
		} catch (Exception e) {
			System.err.println("ERROR (getMaCD)"+e.getMessage());
		}
		return maCD;
	}
	public static ArrayList<String> danhSachCongDungTheoNhomCD(Connection conn,String nhomCD){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT congDung FROM CongDung where nhomCongDung like N'%"+nhomCD+"%' order by congDung";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu tinh that bai . (danhSachCongDungTheoNhomCD)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachCongDungTheoNhomCD)" + e.getMessage());
			}

		}
		return list;
	}
	
	public static ArrayList<String> danhSachNCongDung(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT nhomCongDung FROM CongDung order by nhomCongDung";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu tinh that bai . (danhSachNCongDung)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachNCongDung)" + e.getMessage());
			}

		}
		return list;
	}
}
