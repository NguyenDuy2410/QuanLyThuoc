package enity;

public class CongDung {
	private String maCongDung;
	private String congDung;
	private String nhomCongDung;
	public String getMaCongDung() {
		return maCongDung;
	}
	public void setMaCongDung(String maCongDung) {
		this.maCongDung = maCongDung;
	}
	public String getCongDung() {
		return congDung;
	}
	public void setCongDung(String congDung) {
		this.congDung = congDung;
	}
	public String getNhomCongDung() {
		return nhomCongDung;
	}
	public void setNhomCongDung(String nhomCongDung) {
		this.nhomCongDung = nhomCongDung;
	}
	public CongDung(String maCongDung, String congDung, String nhomCongDung) {
		super();
		this.maCongDung = maCongDung;
		this.congDung = congDung;
		this.nhomCongDung = nhomCongDung;
	}
	public CongDung() {
		super();
	}
	public CongDung(String congDung, String nhomCongDung) {
		super();
		this.congDung = congDung;
		this.nhomCongDung = nhomCongDung;
	}
	
	
	
	
	

}
