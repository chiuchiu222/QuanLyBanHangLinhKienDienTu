package entity;

import java.sql.Date;

public class HoaDon {
	private String maHD;
	private String maNhanVien;
	private String maKhach;
	private String ngayBan;
	private String tongTien;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaKhach() {
		return maKhach;
	}
	public void setMaKhach(String maKhach) {
		this.maKhach = maKhach;
	}
	public String getNgayBan() {
		return ngayBan;
	}
	public void setNgayBan(String ngayBan) {
		this.ngayBan = ngayBan;
	}
	public String getTongTien() {
		return tongTien;
	}
	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
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
		HoaDon other = (HoaDon) obj;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		return true;
	}
	public HoaDon(String maHD, String maKhach, String maNhanVien, String ngayBan, String tongTien) {
		super();
		setMaHD(maHD);
		setMaKhach(maKhach);
		setMaNhanVien(maNhanVien);
		setNgayBan(ngayBan);
		setTongTien(tongTien);
	}
	public HoaDon(String maHD, String maNV, String maKH, Date ngayban2, double tongTien2) {
		super();
		setMaHD(maHD);
		setMaKhach(maKhach);
		setMaNhanVien(maNhanVien);
		setNgayBan(ngayBan);
		setTongTien(tongTien);
	}
	public HoaDon(String trim) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", maNhanVien=" + maNhanVien + ", maKhach=" + maKhach + ", ngayBan=" + ngayBan
				+ ", tongTien=" + tongTien + "]";
	}
	
	
}
