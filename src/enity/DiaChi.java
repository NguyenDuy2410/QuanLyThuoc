package enity;

public class DiaChi {
	private String maDC;
	private String tinhTp;
	private String quanHuyen;
	private String phuongXa;
	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiaChi(String maDC, String tinhTp, String quanHuyen, String phuongXa) {
		super();
		this.maDC = maDC;
		this.tinhTp = tinhTp;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
	}
	public String getMaDC() {
		return maDC;
	}
	public String getTinhTp() {
		return tinhTp;
	}
	public String getQuanHuyen() {
		return quanHuyen;
	}
	public String getPhuongXa() {
		return phuongXa;
	}
	public void setMaDC(String maDC) {
		this.maDC = maDC;
	}
	public void setTinhTp(String tinhTp) {
		this.tinhTp = tinhTp;
	}
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}
	
}
