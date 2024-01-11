package enity;

public class NhanVien { 
	// false nu : true nam
	// true dang lam viec : false da nghi viec
	private String maNhanVien;
	private String tenNhanVien;
	private boolean gioiTinh;
	private String soDienThoaiNV;
	private String passLogin;
	private boolean trangThaiLamViec;
	private String cmnd;
	private DiaChi diaChi;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoaiNV) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoaiNV = soDienThoaiNV;
	}

	public NhanVien(String maNhanVien, String tenNhanVien, boolean gioiTinh, String soDienThoaiNV, String passLogin,
			boolean trangThaiLamViec, String cmnd, DiaChi diaChi) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.soDienThoaiNV = soDienThoaiNV;
		this.passLogin = passLogin;
		this.trangThaiLamViec = trangThaiLamViec;
		this.cmnd = cmnd;
		this.diaChi = diaChi;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public String getSoDienThoaiNV() {
		return soDienThoaiNV;
	}
	public String getPassLogin() {
		return passLogin;
	}
	public boolean isTrangThaiLamViec() {
		return trangThaiLamViec;
	}
	public String getCmnd() {
		return cmnd;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public void setSoDienThoaiNV(String soDienThoaiNV) {
		this.soDienThoaiNV = soDienThoaiNV;
	}
	public void setPassLogin(String passLogin) {
		this.passLogin = passLogin;
	}
	public void setTrangThaiLamViec(boolean trangThaiLamViec) {
		this.trangThaiLamViec = trangThaiLamViec;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	

}