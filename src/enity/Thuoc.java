package enity;

import java.sql.Date;
import java.time.LocalDate;

public class Thuoc {
	private String maThuoc;
	private String tenThuoc;
	private Double giaBan;
	private String donViTinh;
	private String thanhPhan;
	private String quyCachDongGoi;
	private String dangBaoChe;
	private String hamLuong;
	private String congTySanXuat;
	private String nuocSanXuat;
	private boolean trangThaiKinhDoanh;
	private float thue;
	private String soDangKy;
	private CongDung congDung;
	private int soLuongBanDau;
	private Date hanSuDung;

	public String getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public Double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Double giaBan) {
		this.giaBan = giaBan;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getThanhPhan() {
		return thanhPhan;
	}

	public void setThanhPhan(String thanhPhan) {
		this.thanhPhan = thanhPhan;
	}

	public String getQuyCachDongGoi() {
		return quyCachDongGoi;
	}

	public void setQuyCachDongGoi(String quyCachDongGoi) {
		this.quyCachDongGoi = quyCachDongGoi;
	}

	public String getDangBaoChe() {
		return dangBaoChe;
	}

	public void setDangBaoChe(String dangBaoChe) {
		this.dangBaoChe = dangBaoChe;
	}

	public String getHamLuong() {
		return hamLuong;
	}

	public void setHamLuong(String hamLuong) {
		this.hamLuong = hamLuong;
	}

	public String getCongTySanXuat() {
		return congTySanXuat;
	}

	public void setCongTySanXuat(String congTySanXuat) {
		this.congTySanXuat = congTySanXuat;
	}

	public String getNuocSanXuat() {
		return nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	public boolean isTrangThaiKinhDoanh() {
		return trangThaiKinhDoanh;
	}

	public void setTrangThaiKinhDoanh(boolean trangThaiKinhDoanh) {
		this.trangThaiKinhDoanh = trangThaiKinhDoanh;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}

	public String getSoDangKy() {
		return soDangKy;
	}

	public void setSoDangKy(String soDangKy) {
		this.soDangKy = soDangKy;
	}

	public CongDung getCongDung() {
		return congDung;
	}

	public void setCongDung(CongDung congDung) {
		this.congDung = congDung;
	}

	public int getSoLuongBanDau() {
		return soLuongBanDau;
	}

	public void setSoLuongBanDau(int soLuongBanDau) {
		this.soLuongBanDau = soLuongBanDau;
	}

	public Date getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public Thuoc() {
		super();
	}

	public Thuoc(String maThuoc, String tenThuoc, Double giaBan,
			String donViTinh, String thanhPhan, String quyCachDongGoi,
			String dangBaoChe, String hamLuong, String congTySanXuat,
			String nuocSanXuat, boolean trangThaiKinhDoanh, float thue,
			String soDangKy, CongDung congDung, int soLuongBanDau,
			Date hanSuDung) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.thanhPhan = thanhPhan;
		this.quyCachDongGoi = quyCachDongGoi;
		this.dangBaoChe = dangBaoChe;
		this.hamLuong = hamLuong;
		this.congTySanXuat = congTySanXuat;
		this.nuocSanXuat = nuocSanXuat;
		this.trangThaiKinhDoanh = trangThaiKinhDoanh;
		this.thue = thue;
		this.soDangKy = soDangKy;
		this.congDung = congDung;
		this.soLuongBanDau = soLuongBanDau;
		this.hanSuDung = hanSuDung;
	}
	

	public Thuoc(String maThuoc, int soLuongBanDau) {
		super();
		this.maThuoc = maThuoc;
		this.soLuongBanDau = soLuongBanDau;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thuoc other = (Thuoc) obj;
		if (maThuoc == null) {
			if (other.maThuoc != null)
				return false;
		} else if (!maThuoc.equals(other.maThuoc))
			return false;
		return true;
	}

	public Thuoc(String maThuoc, Double giaBan, int soLuongBanDau) {
		super();
		this.maThuoc = maThuoc;
		this.giaBan = giaBan;
		this.soLuongBanDau = soLuongBanDau;
	}

//	@Override
//	public String toString() {
//		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", giaBan=" + giaBan + ", donViTinh="
//				+ donViTinh + ", thanhPhan=" + thanhPhan + ", quyCachDongGoi=" + quyCachDongGoi + ", dangBaoChe="
//				+ dangBaoChe + ", hamLuong=" + hamLuong + ", congTySanXuat=" + congTySanXuat + ", nuocSanXuat="
//				+ nuocSanXuat + ", trangThaiKinhDoanh=" + trangThaiKinhDoanh + ", thue=" + thue + ", soDangKy="
//				+ soDangKy + ", congDung=" + congDung + ", soLuongBanDau=" + soLuongBanDau + ", hanSuDung=" + hanSuDung
//				+ "]";
//	}
	
	
	
	

}
