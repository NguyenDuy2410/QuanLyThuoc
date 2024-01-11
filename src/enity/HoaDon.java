package enity;

public class HoaDon {
	private String maHoaDonBan;
	private String ngayLapHDBan;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private double tongTien;
	private double tienNhan;
	
	
	
	


	public String getMaHoaDonBan() {
		return maHoaDonBan;
	}

	public void setMaHoaDonBan(String maHoaDonBan) {
		this.maHoaDonBan = maHoaDonBan;
	}

	public String getNgayLapHDBan() {
		return ngayLapHDBan;
	}

	public void setNgayLapHDBan(String ngayLapHDBan) {
		this.ngayLapHDBan = ngayLapHDBan;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public double getTienNhan() {
		return tienNhan;
	}

	public void setTienNhan(double tienNhan) {
		this.tienNhan = tienNhan;
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDonBan, String ngayLapHDBan, NhanVien nhanVien,
			KhachHang khachHang, double tongTien, double tienNhan) {
		super();
		this.maHoaDonBan = maHoaDonBan;
		this.ngayLapHDBan = ngayLapHDBan;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.tongTien = tongTien;
		this.tienNhan = tienNhan;
	}

	
}