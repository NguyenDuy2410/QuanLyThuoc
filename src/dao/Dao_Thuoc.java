//package DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//import BEAN.CongDung;
//import BEAN.Thuoc;
//
//public class DAO_Thuoc {
//	public static ArrayList<Thuoc> danhSachThuoc(Connection con, int page,
//			String tenThuoc, String thanhPhan, String dvt, String congDung, String nhomCongDung, String dangBaoChe, String nuoc) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung "
//					+ "where tenThuoc like N'%"+tenThuoc+"%' "
//					+ "and congDung like N'%"+congDung+"%' "
//					+ "and donViTinh like N'%"+dvt+"%' "
//					+ "and nhomCongDung like N'%"+nhomCongDung+"%'"
//					+ "and dangBaoChe like N'%"+dangBaoChe+"%'"
//					+ "and nuocSanXuat like N'%"+nuoc+"%'"
//					+ "and thanhPhan like N'%"+thanhPhan+"%' order by Thuoc.tenThuoc offset "
//					+ offset + " rows fetch next 20 rows only";
//		
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				if(!thuoc.getMaThuoc().equals("")){
//					danhSach.add(thuoc);
//				}
//				
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<Thuoc> danhSachThuoc(Connection con, int page) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung order by Thuoc.tenThuoc offset "
//					+ offset + " rows fetch next 20 rows only";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet == null) {
//				return null;
//			}
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				danhSach.add(thuoc);
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<Thuoc> danhSachThuocTheoTen(Connection con,
//			int page, String txtSearchTen) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where Thuoc.tenThuoc like N'%"
//					+ txtSearchTen
//					+ "%' order by Thuoc.tenThuoc offset "
//					+ offset + " rows fetch next 20 rows only";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				danhSach.add(thuoc);
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<Thuoc> danhSachThuocTheoThanhPhan(Connection con,
//			int page, String txtSearchThanhPhan) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where Thuoc.thanhPhan like N'%"
//					+ txtSearchThanhPhan
//					+ "%' order by Thuoc.tenThuoc offset "
//					+ offset + " rows fetch next 20 rows only";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				danhSach.add(thuoc);
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<Thuoc> danhSachThuocTheoDVT(Connection con,
//			int page, String cbDVTItem) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where Thuoc.donViTinh like N'"
//					+ cbDVTItem
//					+ "' order by Thuoc.tenThuoc offset "
//					+ offset
//					+ " rows fetch next 20 rows only";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				danhSach.add(thuoc);
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<Thuoc> danhSachThuocTheoCongDung(Connection con,
//			int page, String cbcongdungtem) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where CongDung.congDung like N'"
//					+ cbcongdungtem
//					+ "' order by Thuoc.tenThuoc offset "
//					+ offset + " rows fetch next 20 rows only";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				danhSach.add(thuoc);
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<Thuoc> danhSachThuocTheoThanhPhan_DVT(
//			Connection con, int page, String thanhphan, String cbDVTItem) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where (Thuoc.thanhPhan like N'"
//					+ thanhphan
//					+ "')and (Thuoc.donViTinh like N'"
//					+ cbDVTItem
//					+ "') order by Thuoc.tenThuoc offset "
//					+ offset
//					+ " rows fetch next 20 rows only";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				danhSach.add(thuoc);
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<Thuoc> danhSachThuocTheoCongDung_DVT(
//			Connection con, int page, String cbcongdungItem, String cbDVTItem) {
//		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
//		try {
//			int offset = page * 20;
//			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where (CongDung.congDung like N'"
//					+ cbcongdungItem
//					+ "')and (Thuoc.donViTinh like N'"
//					+ cbDVTItem
//					+ "') order by Thuoc.tenThuoc offset "
//					+ offset
//					+ " rows fetch next 20 rows only";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				Thuoc thuoc = new Thuoc();
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//				danhSach.add(thuoc);
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return danhSach;
//	}
//
//	public static ArrayList<String> getDonViTinh(Connection con) {
//		ArrayList<String> listDVT = new ArrayList<String>();
//		listDVT.add("Tất cả");
//		try {
//			String sql = "select distinct donViTinh from Thuoc";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				listDVT.add(resultSet.getString("donViTinh"));
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return listDVT;
//
//	}
//
//	public static ArrayList<String> getCongDung(Connection con) {
//		ArrayList<String> listCongDung = new ArrayList<String>();
//		listCongDung.add("Tất cả");
//		try {
//			String sql = "select congDung from CongDung";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				listCongDung.add(resultSet.getString("congDung"));
//			}
//			preparedStatement.close();
//			resultSet.close();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return listCongDung;
//	}
//
//	public static Thuoc getThuocTheoMa(Connection con, String maThuoc) {
//		Thuoc thuoc = new Thuoc();
//		try {
//			String sql = "select *from Thuoc join CongDung on Thuoc.maCongDung = CongDung.maCongDung where Thuoc.maThuoc like N'"
//					+ maThuoc + "'";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
//				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
//				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
//				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
//				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
//				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
//				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
//				thuoc.setHamLuong(resultSet.getString("hamLuong"));
//				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
//				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
//				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
//				thuoc.setThue(resultSet.getFloat("thueVAT"));
//				thuoc.setSoDangKy(resultSet.getString("soDK"));
//				thuoc.setCongDung(new CongDung(resultSet
//						.getString("maCongDung"), resultSet
//						.getString("congDung"), resultSet
//						.getString("nhomCongDung")));
//				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
//				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
//			}
//			preparedStatement.close();
//			resultSet.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return thuoc;
//	}
//
//	public static int tongHang(Connection con, String tenThuoc, String congDung, String dvt, String thanhPhan) {
//		int count = 0;
//		try {
//
//			String sql = "select count(*) from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung "
//					+ "where tenThuoc like N'%"+tenThuoc+"%' "
//					+ "and congDung like N'%"+congDung+"%' "
//					+ "and donViTinh like N'%"+dvt+"%' "
//					+ "and thanhPhan like N'%"+thanhPhan+"%' ";
//			
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (!resultSet.next()) {
//				throw new Exception("Khong co du lieu");
//			}
//			count = resultSet.getInt(1);		
//			preparedStatement.close();
//			resultSet.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return count;
//	}
//
//	public static int tongHangDVT(Connection con, String cbDVTItem) {
//		int count = 0;
//		try {
//
//			String sql = "select COUNT(*) from Thuoc where donViTinh like N'"
//					+ cbDVTItem + "'";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (!resultSet.next()) {
//				throw new Exception("Khong co du lieu");
//			}
//			count = resultSet.getInt(1);
//			preparedStatement.close();
//			resultSet.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return count;
//	}
//
//	public static int tongHangCongDung(Connection con, String cbCongDung) {
//		int count = 0;
//		try {
//
//			String sql = "select COUNT(*) from Thuoc join CongDung on Thuoc.maCongDung = CongDung.maCongDung where CongDung.congDung like N'"
//					+ cbCongDung + "'";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (!resultSet.next()) {
//				throw new Exception("Khong co du lieu");
//			}
//			count = resultSet.getInt(1);
//			preparedStatement.close();
//			resultSet.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return count;
//	}
//
//	public static int tongHangCongDungDVT(Connection con, String cbCongDung,
//			String cbDVTItem) {
//		int count = 0;
//		try {
//
//			String sql = "select COUNT(*) from Thuoc join CongDung on Thuoc.maCongDung = CongDung.maCongDung where (CongDung.congDung like N'"
//					+ cbCongDung
//					+ "') and (Thuoc.donViTinh like N'"
//					+ cbDVTItem + "')";
//			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (!resultSet.next()) {
//				throw new Exception("Khong co du lieu");
//			}
//			count = resultSet.getInt(1);
//			preparedStatement.close();
//			resultSet.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return count;
//	}
//	public static boolean setNgungBan(Connection con, boolean trangThai, String maThuoc) {
//		try {
//			PreparedStatement p = con.prepareStatement("update Thuoc set trangThaiKD = ? where maThuoc = ?");
//			p.setBoolean(1, trangThai);
//			p.setString(2, maThuoc);
//			p.execute();
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//		return true;
//	}
//	
//	public void upDateSoLuongThuoc( Connection con){
//		
//	}
//
//}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import enity.CongDung;
import enity.Thuoc;
import connect.Connect;

public class Dao_Thuoc {
	public static ArrayList<Thuoc> danhSachThuoc(Connection con, int page, String tenThuoc, String thanhPhan,
			String dvt, String congDung, String nhomCongDung, String dangBaoChe, String nuoc) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung "
					+ "where tenThuoc like N'%" + tenThuoc + "%' " + "and congDung like N'%" + congDung + "%' "
					+ "and donViTinh like N'%" + dvt + "%' " + "and nhomCongDung like N'%" + nhomCongDung + "%'"
					+ "and dangBaoChe like N'%" + dangBaoChe + "%'" + "and nuocSanXuat like N'%" + nuoc + "%'"
					+ "and thanhPhan like N'%" + thanhPhan + "%' and trangThaiKD = 1 order by Thuoc.tenThuoc offset " + offset
					+ " rows fetch next 20 rows only";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				if (!thuoc.getMaThuoc().equals("")) {
					danhSach.add(thuoc);
				}

			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return danhSach;
	}

	public static ArrayList<Thuoc> danhSachThuoc(Connection con, int page) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung order by Thuoc.tenThuoc offset "
					+ offset + " rows fetch next 20 rows only";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet == null) {
				return null;
			}
			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				danhSach.add(thuoc);
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return danhSach;
	}

	public static ArrayList<Thuoc> danhSachThuocTheoTen(Connection con, int page, String txtSearchTen) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where Thuoc.tenThuoc like N'%"
					+ txtSearchTen + "%' order by Thuoc.tenThuoc offset " + offset + " rows fetch next 20 rows only";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				danhSach.add(thuoc);
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return danhSach;
	}

	public static ArrayList<Thuoc> danhSachThuocTheoThanhPhan(Connection con, int page, String txtSearchThanhPhan) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where Thuoc.thanhPhan like N'%"
					+ txtSearchThanhPhan + "%' order by Thuoc.tenThuoc offset " + offset
					+ " rows fetch next 20 rows only";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				danhSach.add(thuoc);
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return danhSach;
	}

	public static ArrayList<Thuoc> danhSachThuocTheoDVT(Connection con, int page, String cbDVTItem) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where Thuoc.donViTinh like N'"
					+ cbDVTItem + "' order by Thuoc.tenThuoc offset " + offset + " rows fetch next 20 rows only";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				danhSach.add(thuoc);
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return danhSach;
	}

	public static ArrayList<Thuoc> danhSachThuocTheoCongDung(Connection con, int page, String cbcongdungtem) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where CongDung.congDung like N'"
					+ cbcongdungtem + "' order by Thuoc.tenThuoc offset " + offset + " rows fetch next 20 rows only";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				danhSach.add(thuoc);
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return danhSach;
	}

	public static ArrayList<Thuoc> danhSachThuocTheoThanhPhan_DVT(Connection con, int page, String thanhphan,
			String cbDVTItem) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where (Thuoc.thanhPhan like N'"
					+ thanhphan + "')and (Thuoc.donViTinh like N'" + cbDVTItem + "') order by Thuoc.tenThuoc offset "
					+ offset + " rows fetch next 20 rows only";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				danhSach.add(thuoc);
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return danhSach;
	}

	public static ArrayList<Thuoc> danhSachThuocTheoCongDung_DVT(Connection con, int page, String cbcongdungItem,
			String cbDVTItem) {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		try {
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung where (CongDung.congDung like N'"
					+ cbcongdungItem + "')and (Thuoc.donViTinh like N'" + cbDVTItem
					+ "') order by Thuoc.tenThuoc offset " + offset + " rows fetch next 20 rows only";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Thuoc thuoc = new Thuoc();
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
				danhSach.add(thuoc);
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return danhSach;
	}

	public static ArrayList<String> getDonViTinh(Connection con) {
		ArrayList<String> listDVT = new ArrayList<String>();
		listDVT.add("Tất cả");
		try {
			String sql = "select distinct donViTinh from Thuoc";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listDVT.add(resultSet.getString("donViTinh"));
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listDVT;

	}

	public static ArrayList<String> getCongDung(Connection con) {
		ArrayList<String> listCongDung = new ArrayList<String>();
		listCongDung.add("Tất cả");
		try {
			String sql = "select congDung from CongDung";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listCongDung.add(resultSet.getString("congDung"));
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listCongDung;
	}

	public static Thuoc getThuocTheoMa(Connection con, String maThuoc) {
		Thuoc thuoc = new Thuoc();
		try {
			String sql = "select *from Thuoc join CongDung on Thuoc.maCongDung = CongDung.maCongDung where Thuoc.maThuoc like N'"
					+ maThuoc + "'";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				thuoc.setMaThuoc(resultSet.getString("maThuoc"));
				thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
				thuoc.setGiaBan(resultSet.getDouble("giaBan"));
				thuoc.setDonViTinh(resultSet.getString("donViTinh"));
				thuoc.setThanhPhan(resultSet.getString("thanhPhan"));
				thuoc.setQuyCachDongGoi(resultSet.getString("quyCachDongGoi"));
				thuoc.setDangBaoChe(resultSet.getString("dangBaoChe"));
				thuoc.setHamLuong(resultSet.getString("hamLuong"));
				thuoc.setCongTySanXuat(resultSet.getString("cTySanXuat"));
				thuoc.setNuocSanXuat(resultSet.getString("nuocSanXuat"));
				thuoc.setTrangThaiKinhDoanh(resultSet.getBoolean("trangThaiKD"));
				thuoc.setThue(resultSet.getFloat("thueVAT"));
				thuoc.setSoDangKy(resultSet.getString("soDK"));
				thuoc.setCongDung(new CongDung(resultSet.getString("maCongDung"), resultSet.getString("congDung"),
						resultSet.getString("nhomCongDung")));
				thuoc.setSoLuongBanDau(resultSet.getInt("soLuongBanDau"));
				thuoc.setHanSuDung(resultSet.getDate("hanSuDung"));
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return thuoc;
	}

	public static int tongHang(Connection con, String tenThuoc, String congDung, String dvt, String thanhPhan) {
		int count = 0;
		try {

			String sql = "select count(*) from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung "
					+ "where tenThuoc like N'%" + tenThuoc + "%' " + "and congDung like N'%" + congDung + "%' "
					+ "and donViTinh like N'%" + dvt + "%' " + "and thanhPhan like N'%" + thanhPhan + "%' ";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Khong co du lieu");
			}
			count = resultSet.getInt(1);
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	public static int tongHangDVT(Connection con, String cbDVTItem) {
		int count = 0;
		try {

			String sql = "select COUNT(*) from Thuoc where donViTinh like N'" + cbDVTItem + "'";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Khong co du lieu");
			}
			count = resultSet.getInt(1);
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	public static int tongHangCongDung(Connection con, String cbCongDung) {
		int count = 0;
		try {

			String sql = "select COUNT(*) from Thuoc join CongDung on Thuoc.maCongDung = CongDung.maCongDung where CongDung.congDung like N'"
					+ cbCongDung + "'";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Khong co du lieu");
			}
			count = resultSet.getInt(1);
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	public static int tongHangCongDungDVT(Connection con, String cbCongDung, String cbDVTItem) {
		int count = 0;
		try {

			String sql = "select COUNT(*) from Thuoc join CongDung on Thuoc.maCongDung = CongDung.maCongDung where (CongDung.congDung like N'"
					+ cbCongDung + "') and (Thuoc.donViTinh like N'" + cbDVTItem + "')";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Khong co du lieu");
			}
			count = resultSet.getInt(1);
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	public static boolean setNgungBan(Connection con, boolean trangThai, String maThuoc) {
		try {
			PreparedStatement p = con.prepareStatement("update Thuoc set trangThaiKD = ? where maThuoc = ?");
			p.setBoolean(1, trangThai);
			p.setString(2, maThuoc);
			p.execute();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public static boolean capNhatThuoc(Connection con, String ma, Thuoc thuoc) {
		try {
			PreparedStatement p = con.prepareStatement(
					"update Thuoc set tenThuoc = ?, giaBan = ?, thueVAT = ?, donViTinh = ?, dangBaoChe = ?, soDK = ?, "
					+ "hamLuong = ?, thanhPhan = ?, quyCachDongGoi = ?, cTySanXuat = ?, nuocSanXuat = ? where maThuoc = ?");
			p.setString(1, thuoc.getTenThuoc());
			p.setDouble(2, thuoc.getGiaBan());
			p.setFloat(3, thuoc.getThue());
			p.setString(4, thuoc.getDonViTinh());
			p.setString(5, thuoc.getDangBaoChe());
			p.setString(6, thuoc.getSoDangKy());
			p.setString(7, thuoc.getHamLuong());
			p.setString(8, thuoc.getThanhPhan());
			p.setString(9, thuoc.getQuyCachDongGoi());
			p.setString(10, thuoc.getCongTySanXuat());
			p.setString(11, thuoc.getNuocSanXuat()); 
			p.setString(12, thuoc.getMaThuoc());
			p.execute();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	public static String phatSinhMaThuocTuDong(Connection conn) {
		String sql = "select max(maThuoc) from Thuoc";
		Statement st = null;
		ResultSet rs = null;
		String maThuoc = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				throw new Exception("Khong co du lieu");
			}
			maThuoc = rs.getString(1);

			maThuoc = "DP" + MaThuocTuDong.fomatDPAA000000(maThuoc.substring(2));
		} catch (Exception e) {
			System.err.println("ERROR: lay du lieu loi . (phasinhmathuocTuDong)" + e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (phasinhmathuocTuDong)" + e.getMessage());
			}
		}
		return maThuoc;
	}
	public static ArrayList<String> danhSachDVT(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT donViTinh FROM Thuoc ";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu DVT that bai . (danhSachDVT)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachDVT)" + e.getMessage());
			}

		}
		return list;
	}
	
	public static ArrayList<String> danhSachDangBaoChe(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT dangBaoChe FROM Thuoc ";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu dang bao che that bai . (danhSachDangBaoChe)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachDangBaoChe)" + e.getMessage());
			}

		}
		return list;
	}
	public static ArrayList<String> danhSachNuocSX(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT nuocSanXuat FROM Thuoc";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu nuoc san xuat that bai . (danhSachNuocSX)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachNuocSX)" + e.getMessage());
			}

		}
		return list;
	}
	public static ArrayList<String> danhSachQuyCachDongGoi(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT DISTINCT quyCachDongGoi FROM Thuoc order by quyCachDongGoi";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu dang bao che that bai . (danhSachQuyCachDongGoi)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachQuyCachDongGoi)" + e.getMessage());
			}

		}
		return list;
	}
	
	public static ArrayList<String> danhSachThanhPhan(Connection conn){
		ArrayList<String> list = new ArrayList<String>();
		Statement st = null;
		ResultSet rs = null;
//		Connection conn = Connect.CreateConnection();
		
		try {
			String sql = "SELECT DISTINCT thanhPhan FROM Thuoc";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("ERROR: Lay du lieu dang bao che that bai . (danhSachThanhPhan)" + e.getMessage());
		} finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (danhSachThanhPhan)" + e.getMessage());
			}

		}
		return list;
	}
	public static ArrayList<Thuoc> getAllThuoc() {
		ArrayList<Thuoc> danhSach = new ArrayList<Thuoc>();
		
		try {
			
			Connection con = Connect.CreateConnection();
			String sql = "select * from Thuoc" ;
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				String mathuoc = resultSet.getString(1);
				String tenthuoc = resultSet.getString(2);
				Double giaban = resultSet.getDouble(3);
				String dvt = resultSet.getString(4);
				String thanhphan = resultSet.getString(5);
				String quycachdonggoi = resultSet.getString(6);
				String dangbaoche = resultSet.getString(7);
				String hamluong = resultSet.getString(8);
				String ctysanxuat = resultSet.getString(9);
				String nuocsanxuat = resultSet.getString(10);
				Boolean ttkinhdoanh = resultSet.getBoolean(11);
				Float thue = resultSet.getFloat(12);
				String sodk = resultSet.getString(13);
				CongDung congdung = new CongDung(resultSet.getString(14), resultSet.getString(14),
						resultSet.getString(14));
				int slbandau = resultSet.getInt(15);
				Date hansudung = resultSet.getDate(16);
				Thuoc thuoc = new Thuoc(mathuoc, tenthuoc, giaban, dvt, thanhphan, quycachdonggoi, dangbaoche, hamluong, ctysanxuat, nuocsanxuat, false, thue, sodk, congdung, slbandau, hansudung);
				danhSach.add(thuoc);

			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return danhSach;
	}
	public static boolean themThuoc(Connection conn, Thuoc thuoc) {
		PreparedStatement ptmt = null;
		int check = 0;
		String sql = "  insert into Thuoc(maThuoc ,tenThuoc ,giaBan, donViTinh, thanhPhan,quyCachDongGoi, "
				+ "dangBaoChe, hamLuong, cTySanXuat, nuocSanXuat, trangThaiKD, thueVAT, soDK, maCongDung, soLuongBanDau, "
				+ "hanSuDung) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			ptmt = conn.prepareStatement(sql);
			String maThuoc = phatSinhMaThuocTuDong(conn); // phat sinh ma thuoc tu dong
			thuoc.setMaThuoc(maThuoc);
			// lay ma Thuoc tren Database
			String maCongDung = Dao_CongDung.getMaCD(conn, thuoc.getCongDung().getCongDung(), thuoc.getCongDung().getNhomCongDung());

			ptmt.setString(1, maThuoc);
			ptmt.setString(2, thuoc.getTenThuoc());
			ptmt.setDouble(3, thuoc.getGiaBan());
			ptmt.setString(4, thuoc.getDonViTinh());
			ptmt.setString(5, thuoc.getThanhPhan());
			ptmt.setString(6, thuoc.getQuyCachDongGoi());
			ptmt.setString(7, thuoc.getDangBaoChe());
			ptmt.setString(8, thuoc.getHamLuong());
			ptmt.setString(9, thuoc.getCongTySanXuat());
			ptmt.setString(10, thuoc.getNuocSanXuat());
			ptmt.setBoolean(11, thuoc.isTrangThaiKinhDoanh());
			ptmt.setFloat(12, thuoc.getThue());
			ptmt.setString(13, thuoc.getSoDangKy());
			ptmt.setString(14, maCongDung);
			ptmt.setInt(15, thuoc.getSoLuongBanDau());
			ptmt.setDate(16, thuoc.getHanSuDung());
			
			
			System.out.println(maThuoc);
			check = ptmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("ERROR: Them that bai. (themThuoc)" + e.getMessage());
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				System.err.println("ERROR: close . (themThuoc)" + e.getMessage());
			}
		}
		if (check == 0) {
			return false;
		}
		return true;
	}
}

