package enity;

public class CT_HoaDon {
	private int soLuong;
	private HoaDon hoaDon;
	private Thuoc thuoc;
	private double giaBan;
	private float thueVat;
	
	public CT_HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CT_HoaDon(int soLuong,HoaDon hoaDon,Thuoc thuoc ,double giaBan,float thueVat) {
		super();
		this.setSoLuong(soLuong);
		this.setHoaDon(hoaDon);
		this.setThuoc(thuoc);
		this.setGiaBan(giaBan);
		this.setThueVat(thueVat);
		

	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public Thuoc getThuoc() {
		return thuoc;
	}
	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public float getThueVat() {
		return thueVat;
	}
	public void setThueVat(float thueVat) {
		this.thueVat = thueVat;
	}

}