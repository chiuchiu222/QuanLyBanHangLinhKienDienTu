package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LinhKien;
import entity.Loai;
public class LinhKien_DAO {
	public ArrayList<LinhKien> getAllLinhKien() {
		ArrayList<LinhKien> dslk = new ArrayList<LinhKien>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from LinhKien";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maLK=rs.getString(1);
				String tenLK=rs.getString(2);	
			//	Loai loai = new Loai(rs.getString(3));
				int sl = rs.getInt(3);
				Double giaNhap = rs.getDouble(4);
				Double giaBan = rs.getDouble(5);
				Date ngayNhap = rs.getDate(6);
				LinhKien lk=new LinhKien(maLK, tenLK, sl, giaNhap, giaBan,ngayNhap);
				dslk.add(lk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dslk;
	}

	public boolean create(LinhKien lk) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into"+" LinhKien values( ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, lk.getMaLinhkien());
			stmt.setString(2, lk.getTenLinhkien());
		//	stmt.setString(3, lk.getLoai().getMaLoai());
			stmt.setInt(3,    lk.getSoLuong());
			stmt.setDouble(4, lk.getDonGiaNhap());
			stmt.setDouble(5, lk.getDonGiaBan());
			stmt.setDate(6, (Date) lk.getNgayNhap());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return n>0;
	}
	public boolean delete(String maLK) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			String str = "delete from LinhKien where maLinhKien = ?";
			stmt=con.prepareStatement(str);
			stmt.setString(1,maLK);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public LinhKien getLinhKienTheoMaLK(String maLK) {
		LinhKien lk = null;
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Select * from LinhKien where maLinhKien = ?";
			statement=con.prepareStatement(sql);
			statement.setString(1, maLK);
			ResultSet rs=statement.executeQuery();
			 if (rs.next() == false) {
				  return lk;
			 }
			 else {
				String malk=rs.getString(1);
				String tenLK=rs.getString(2);	
				//Loai loai = new Loai(rs.getString(3));
				int sl = rs.getInt(3);
				Double giaNhap = rs.getDouble(4);
				Double giaBan = rs.getDouble(5);
				Date ngayNhap = rs.getDate(6);
				lk=new LinhKien(malk, tenLK, sl, giaNhap, giaBan,ngayNhap);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}return lk;
	}
	public boolean update(LinhKien lk) {
		ConnectDB.getInstance();
		Connection con=(Connection) ConnectDB.getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update LinhKien set tenLinhkien=?, soLuong= ?, donGiaNhap=?, donGiaBan= ?,ngayNhap = ? where maLinhkien= ?");
			stmt.setString(1, lk.getTenLinhkien());
		//	stmt.setString(2, lk.getLoai().getMaLoai());
			stmt.setInt(2,    lk.getSoLuong());
			stmt.setDouble(3, lk.getDonGiaNhap());
			stmt.setDouble(4, lk.getDonGiaBan());
			stmt.setDate(5, (Date) lk.getNgayNhap());
			stmt.setString(6, lk.getMaLinhkien());
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n>0;
	}
	public ArrayList<LinhKien> getDSLinhKien(int x) {
		ArrayList<LinhKien> dslk = new ArrayList<LinhKien>();
		String sql = "select * from LinhKien where soLuong = 0"; 
		if(x > 0 )
			sql = "select * from LinhKien where soLuong > 0";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maLK=rs.getString(1);
				String tenLK=rs.getString(2);	
				Loai loai = new Loai(rs.getString(3));
				int sl = rs.getInt(4);
				Double giaNhap = rs.getDouble(5);
				Double giaBan = rs.getDouble(6);
				Date ngayNhap = rs.getDate(7);
				LinhKien lk=new LinhKien(maLK, tenLK,  sl, giaNhap, giaBan,ngayNhap);
				dslk.add(lk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dslk;
	}
	
	public ArrayList<LinhKien> getLinhKienTheoLoai(String l) {
		ArrayList<LinhKien> dslk = new ArrayList<LinhKien>();
		PreparedStatement statement=null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from LinhKien where maLoai =?";
			statement=con.prepareStatement(sql);
			statement.setString(1,l);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				String maLK=rs.getString(1);
				String tenLK=rs.getString(2);	
				Loai loai = new Loai(rs.getString(3));
				int sl = rs.getInt(4);
				Double giaNhap = rs.getDouble(5);
				Double giaBan = rs.getDouble(6);
				Date ngayNhap = rs.getDate(7);
				LinhKien lk=new LinhKien(maLK, tenLK, sl, giaNhap, giaBan,ngayNhap);
				dslk.add(lk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dslk;
	}
	public ArrayList<LinhKien> getLinhKienTheoNgay(String date) {
		ArrayList<LinhKien> dslk = new ArrayList<LinhKien>();
		PreparedStatement statement=null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from LinhKien where ngayNhap =?";
			statement=con.prepareStatement(sql);
			statement.setString(1,date);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				String maLK=rs.getString(1);
				String tenLK=rs.getString(2);	
				//Loai loai = new Loai(rs.getString(3));
				int sl = rs.getInt(3);
				Double giaNhap = rs.getDouble(4);
				Double giaBan = rs.getDouble(5);
				Date ngayNhap = rs.getDate(6);
				LinhKien lk=new LinhKien(maLK, tenLK,  sl, giaNhap, giaBan,ngayNhap);
				dslk.add(lk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dslk;
	}
	
}
