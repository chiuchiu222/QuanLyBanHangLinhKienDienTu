package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entity.LinhKien;
import entity.Loai;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import dao.LinhKien_DAO;
import dao.Loai_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.HoaDon_DAO;
import connectDB.ConnectDB;

public class UI_QuanLy2 extends JFrame implements ActionListener{
	private JButton btnQuanLy, btnThoat;
	
	Color gbbtn = new Color(246, 229, 141);
	Color gbActive = new Color(255, 242, 0);
	Color gbMain = new Color(246, 229, 200);
	Color gbBox = new Color(200,221,242);
	
	DecimalFormat formatter = new DecimalFormat("###,###,### VND");
	SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private JTextField txtMaNV;
	JButton btnThem, btnSua, btnXoa, btnXoaTrang, btnLuu, btnTim;
	JCheckBox jckPhai;
	JTable table;
	DefaultTableModel tbModel;
	JLabel jlbTitle;
	
	private LinhKien_DAO lk_dao =  new LinhKien_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	private NhanVien_DAO nv_dao =  new NhanVien_DAO();
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private Loai_DAO loai_dao = new Loai_DAO();

	ArrayList<LinhKien> dslk= new ArrayList<LinhKien>();
	private JTextField txtTenNV;
	private JTextField txtLuong;
	private JTextField txtNgayNhap;
	private JTextField txtDonGiaBan;
	private JTextField txtDonGiaNhap;
	private JTextField txtSoLuong;
	private JTextField txtMaLK;
	private JTextField txtTenLK;
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTextField txtMaHD;
	private JTextField txtMaKH;
	private JTextField txtNgayBan;
	private JTextField txtTongTien;
	private JTextField txtTenKH;
	private JButton btnLmoiNV;
	private JButton btnSuaNV;
	private JButton btnXoaNV;
	private JTextField txtTmaNV;
	private JButton btnTmaNV;
	private JButton btnLmoiLK;
	private JButton btnSuaLK;
	private JButton btnXoaLK;
	private JButton btnTmaLK;
	private JTextField txtTmaLK;
	private JButton btnSuaLoai;
	private JButton btnXoaLoai;
	private JTextField txtTmaLoai;
	private JButton btnSuaHD;
	private JButton btnXoaHD;
	private JButton btnTmaHD;
	private JTextField txtTmaHD;
	private JButton btnSuaKH;
	private JButton btnXoaKH;
	private JButton btnTmaKH;
	private JTextField txtTmaKH;
	private JButton btnTmaLoai;
	private JTextField txtDiaChiNV;
	private JCheckBox chkGioiTinhNV;
	private JTextField txtDienThoaiNV;
	private JTextField txtEmailNV;
	private JTextField txtNgaySinhNV;
	private JButton btnLuuNV;
	private JButton btnLuuLK;
	private JTextField txtDiaChiKH;
	private JTextField txtDienThoaiKH;
	private JTextField txtEmailKH;
	private JButton btnLuuKH;
	private JButton btnLuuHD;
	private JTextField txtMaNV2;
	private JTextField txtMaKH2;
	private DefaultTableModel tbModelNV;
	private JTable tableNV;
	private DefaultTableModel tbModelLK;
	private JTable tableLK;
	private DefaultTableModel tbModelLoai;
	private JTable tableLoai;
	private DefaultTableModel tbModelHD;
	private JTable tableHD;
	private DefaultTableModel tbModelKH;
	private JTable tableKH;
	private JButton btnLuuLoai;
	private Loai loai;
	private KhachHang kh;
	private NhanVien nv;
	private HoaDon hd;
	private JButton btnLmoiKH;
	private JButton btnLmoiHD;
	private JButton btnLmoiLoai;
	private LinhKien lkt;
	
	
	public UI_QuanLy2() {
		// TODO Auto-generated constructor stub
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Quản Lý");
		GiaoDienQuanly();
		setSize(1400,700);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void GiaoDienQuanly(){
		
		JPanel pWest = new JPanel();
		pWest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"TÁC VỤ QUẢN LÝ"));
		Color bgColor = new Color(223,249,251);
		pWest.setBackground(bgColor);
		
		ImageIcon iconQuanLy = new ImageIcon("img/icon_quanly.png");
		ImageIcon iconThoat = new ImageIcon("img/icon_thoat.png");
		
		
	
		
	
	
		pWest.add(btnThoat= new JButton("THOÁT",iconThoat));
		btnThoat.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.red));
		Color bgExit = new Color(255, 121, 121);
		btnThoat.setBackground(bgExit);
		btnThoat.setForeground(Color.black);
		btnThoat.setPreferredSize(new Dimension(200, 50));
		pWest.add(Box.createVerticalStrut(80));
		
		add(pWest, BorderLayout.WEST);
		pWest.setPreferredSize(new Dimension(250,243));

		btnThoat.addActionListener(this);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel xx =  new JPanel();
		tabbedPane.addTab("Nhân Viên",quanLyNhanVien());
        tabbedPane.addTab("Linh Kiện", quanLyLinhKien());
        tabbedPane.addTab("Khách Hàng", quanLyKhachHang());
        tabbedPane.addTab("Loại Linh Kiện", quanLyLoai());
        tabbedPane.addTab("Hóa Đơn", quanLyHoaDon());
        tabbedPane.setBackground(gbMain);
        add(tabbedPane, BorderLayout.CENTER);
	}

	private Box quanLyNhanVien() {
		
		ImageIcon iconLM = new ImageIcon("img/icon_lammoi.png");
		ImageIcon iconL = new ImageIcon("img/icon-add.png");
		ImageIcon iconS = new ImageIcon("img/icon-sua.png");
		ImageIcon iconX = new ImageIcon("img/icon-remove.png");
		ImageIcon iconT = new ImageIcon("img/icon_TKSP.png");

		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		JPanel pnKhungTren = new JPanel();
		pnKhungTren.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnKhungTren.setLayout(new GridLayout(3, 3, 5, 5));
		pnKhungTren.setBackground(gbBox);
		box.add(pnKhungTren);
		Box b1, b2, b3;

		box.add(b1 = Box.createHorizontalBox());// b1 -> b7: Box theo chi�?u ngang
		box.add(b2 = Box.createHorizontalBox());
		box.add(b3 = Box.createHorizontalBox());
		JLabel lblMaNV, lblTenNV, lblLoai, lblGioiTinh, lblNgaySinh, lblLuong, lblDiaChi, lblDienThoai, lblEmail;

		b1.add(lblMaNV = new JLabel("Mã nhân viên:   "));
		b1.add(txtMaNV = new JTextField());
		txtMaNV.setMaximumSize(new Dimension(303, 20));
		b1.add(lblTenNV = new JLabel("  Tên nhân viên:  "));
		b1.add(txtTenNV = new JTextField());
		txtTenNV.setMaximumSize(new Dimension(301, 20));
		b1.add(lblGioiTinh = new JLabel("    Giới tính :  "));
		b1.add(chkGioiTinhNV = new JCheckBox("Nữ"));
		chkGioiTinhNV.setBackground(gbBox);
		chkGioiTinhNV.setMaximumSize(new Dimension(300, 20));
		b2.add(lblNgaySinh = new JLabel("Ngày sinh:          "));
		b2.add(txtNgaySinhNV = new JTextField());
		txtNgaySinhNV.setMaximumSize(new Dimension(300, 20));
		b2.add(lblLuong = new JLabel("   Tiền lương:       "));
		b2.add(txtLuong = new JTextField());
		txtLuong.setMaximumSize(new Dimension(300, 20));
		b2.add(lblDiaChi = new JLabel("    Địa Chỉ:     "));
		b2.add(txtDiaChiNV = new JTextField());
		txtDiaChiNV.setMaximumSize(new Dimension(300, 20));
		b3.add(lblDienThoai = new JLabel("Điện Thoại:        "));
		b3.add(txtDienThoaiNV = new JTextField());
		txtDienThoaiNV.setMaximumSize(new Dimension(279, 20));
		b3.add(lblEmail = new JLabel("    Email:                "));
		b3.add(txtEmailNV = new JTextField());
		txtEmailNV.setMaximumSize(new Dimension(278, 20));

		pnKhungTren.add(b1);
		pnKhungTren.add(b2);
		pnKhungTren.add(b3);

		box.add(pnKhungTren);

		Box KhungDuoi;
		box.add(KhungDuoi = Box.createVerticalBox());
		KhungDuoi.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));

		String[] str = { "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Lương", "Địa Chỉ", "Điện thoại",
				"Email" };
		tbModelNV = new DefaultTableModel(str, 0);
		tableNV = new JTable(tbModelNV);
		JScrollPane jsc = new JScrollPane(tableNV);
		KhungDuoi.add(jsc);
		ArrayList<NhanVien> dsnv = nv_dao.getAllNhanVien();
		for (NhanVien nv : dsnv) {
			tbModelNV.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Nữ" : "Nam",
					nv.getNgaySinh(), formatter.format(nv.getLuong() * 1000), nv.getDiaChi(), nv.getDienThoai(),
					nv.getEmail() });
		}
		
		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createTitledBorder("Tác vụ"));

		bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBackground(gbBox);

		bottom.add(btnLmoiNV = new JButton("Làm mới",iconLM));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnLuuNV = new JButton("Lưu",iconL));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnSuaNV = new JButton("Sửa",iconS));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnXoaNV = new JButton("Xóa",iconX));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnTmaNV = new JButton("Tìm theo mã: ",iconT));
		bottom.add(Box.createRigidArea(new Dimension(7, 15)));
		bottom.add(txtTmaNV = new JTextField());
		txtTmaNV.setMaximumSize(new Dimension(700, 25));

		KhungDuoi.add(bottom);
		tableNV.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		     
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableNV.getSelectedRowCount() == 1) {
					int row = tableNV.getSelectedRow();
					String maNV = (String) tableNV.getValueAt(row, 0);
					NhanVien nv = new NhanVien_DAO().getNhanVienTheoMaNV(maNV);
					txtMaNV.setText(nv.getMaNhanVien());
					txtTenNV.setText(nv.getTenNhanVien());
					chkGioiTinhNV.setSelected(nv.isGioiTinh()); 
					txtNgaySinhNV.setText(nv.getNgaySinh().toString());
					txtLuong.setText(String.valueOf(nv.getLuong()));
					txtDiaChiNV.setText(nv.getDiaChi());
					txtDienThoaiNV.setText(nv.getDienThoai());
					txtEmailNV.setText(nv.getEmail());
				}	
			}
	    });
		btnLmoiNV.addActionListener(this);
		btnLuuNV.addActionListener(this);
		btnSuaNV.addActionListener(this);
		btnXoaNV.addActionListener(this);
		btnTmaNV.addActionListener(this);

		// updateTableData();
		

		return box;
	}

	private Box quanLyLinhKien() {
		ImageIcon iconLM = new ImageIcon("img/icon_lammoi.png");
		ImageIcon iconL = new ImageIcon("img/icon-add.png");
		ImageIcon iconS = new ImageIcon("img/icon-sua.png");
		ImageIcon iconX = new ImageIcon("img/icon-remove.png");
		ImageIcon iconT = new ImageIcon("img/icon_TKSP.png");
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		JPanel pnKhungTren = new JPanel();
		pnKhungTren.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnKhungTren.setLayout(new GridLayout(3, 3, 5, 5));
		pnKhungTren.setBackground(gbBox);
		box.add(pnKhungTren);
		Box b1, b2, b3;

		box.add(b1 = Box.createHorizontalBox());// b1 -> b7: Box theo chi�?u ngang
		box.add(b2 = Box.createHorizontalBox());
		box.add(b3 = Box.createHorizontalBox());

		JLabel lblMaLK, lblTenLK, lblLoai, lblSoLuong, lblDonGiaNhap, lblDonGiaBan, lblNgayNhap;

		b1.add(lblMaLK = new JLabel("Mã linh kiện:      "));
		b1.add(txtMaLK = new JTextField());
		txtMaLK.setMaximumSize(new Dimension(300, 20));
		b1.add(lblTenLK = new JLabel("       Tên linh kiện:    "));
		b1.add(txtTenLK = new JTextField());
		txtTenLK.setMaximumSize(new Dimension(300, 20));
		b2.add(lblSoLuong = new JLabel("Số lượng:          "));
		b2.add(txtSoLuong = new JTextField());
		txtSoLuong.setMaximumSize(new Dimension(303, 20));
		b3.add(lblDonGiaNhap = new JLabel("Đơn giá nhập:   "));
		b3.add(txtDonGiaNhap = new JTextField());
		txtDonGiaNhap.setMaximumSize(new Dimension(303, 20));
		b3.add(lblDonGiaBan = new JLabel("       Đơn giá bán:     "));
		b3.add(txtDonGiaBan = new JTextField());
		txtDonGiaBan.setMaximumSize(new Dimension(300, 20));
		b2.add(lblNgayNhap = new JLabel("       Ngày nhập:        "));
		b2.add(txtNgayNhap = new JTextField());
		txtNgayNhap.setMaximumSize(new Dimension(300, 20));

		pnKhungTren.add(b1);
		pnKhungTren.add(b2);
		pnKhungTren.add(b3);

		box.add(pnKhungTren);

		Box KhungDuoi;
		box.add(KhungDuoi = Box.createVerticalBox());
		KhungDuoi.setBorder(BorderFactory.createTitledBorder("Danh sách linh kiện"));

		String[] str = { "Mã linh kiện", "Tên linh kiện", "Số lượng", "Đơn giá nhập", "Đơn giá bán",
				"Ngày nhập" };
		tbModelLK = new DefaultTableModel(str, 0);
		tableLK = new JTable(tbModelLK);
		JScrollPane jsc = new JScrollPane(tableLK);
		KhungDuoi.add(jsc);
		ArrayList<LinhKien> dslk = lk_dao.getAllLinhKien();
		for (LinhKien lk : dslk) {
			tbModelLK.addRow(new Object[] { lk.getMaLinhkien(), lk.getTenLinhkien(), lk.getSoLuong(),
					formatter.format(lk.getDonGiaNhap() * 1000), formatter.format(lk.getDonGiaBan() * 1000),
					lk.getNgayNhap() });
		}

		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createTitledBorder("Tác vụ"));

		bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBackground(gbBox);

		bottom.add(btnLmoiLK = new JButton("Làm mới",iconLM));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnLuuLK = new JButton("Lưu",iconL));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnSuaLK = new JButton("Sửa",iconS));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnXoaLK = new JButton("Xóa",iconX));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnTmaLK = new JButton("Tìm theo mã: ",iconT));
		bottom.add(Box.createRigidArea(new Dimension(7, 15)));
		bottom.add(txtTmaLK = new JTextField());
		txtTmaLK.setMaximumSize(new Dimension(800, 25));

		KhungDuoi.add(bottom);
		
		tableLK.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		     
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableLK.getSelectedRowCount() == 1) {
					int row = tableLK.getSelectedRow();
					String maLK = (String) tableLK.getValueAt(row, 0);
					LinhKien lk = new LinhKien_DAO().getLinhKienTheoMaLK(maLK);
					txtMaLK.setText(lk.getMaLinhkien());
					txtTenLK.setText(lk.getTenLinhkien());
					txtSoLuong.setText(String.valueOf(lk.getSoLuong())); 
					txtNgayNhap.setText(lk.getNgayNhap().toString());
					txtDonGiaNhap.setText(String.valueOf(lk.getDonGiaNhap()));
					txtDonGiaBan.setText(String.valueOf(lk.getDonGiaBan()));
					//cboLoai.setSelectedItem(lk.getLoai().getMaLoai());
				}	
			}
	    });
		btnLmoiLK.addActionListener(this);
		btnLuuLK.addActionListener(this);
		btnSuaLK.addActionListener(this);
		btnXoaLK.addActionListener(this);
		btnTmaLK.addActionListener(this);

		return box;
	}

	private Box quanLyLoai() {
		ImageIcon iconLM = new ImageIcon("img/icon_lammoi.png");
		ImageIcon iconL = new ImageIcon("img/icon-add.png");
		ImageIcon iconS = new ImageIcon("img/icon-sua.png");
		ImageIcon iconX = new ImageIcon("img/icon-remove.png");
		ImageIcon iconT = new ImageIcon("img/icon_TKSP.png");
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		JPanel pnKhungTren = new JPanel();
		pnKhungTren.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnKhungTren.setLayout(new GridLayout(1, 3, 5, 5));
		pnKhungTren.setBackground(gbBox);
		box.add(pnKhungTren);

		Box b1;
		box.add(b1 = Box.createHorizontalBox());
		JLabel lblMaLoai, lblTenLoai;

		b1.add(lblMaLoai = new JLabel("  Mã loại:   "));
		b1.add(txtMaLoai = new JTextField());
		txtMaLoai.setMaximumSize(new Dimension(300, 20));
		b1.add(lblTenLoai = new JLabel("                                                    Tên loại: "));
		b1.add(txtTenLoai = new JTextField());
		txtTenLoai.setMaximumSize(new Dimension(300, 20));

		pnKhungTren.add(b1);

		box.add(pnKhungTren);

		Box KhungDuoi;
		box.add(KhungDuoi = Box.createVerticalBox());
		KhungDuoi.setBorder(BorderFactory.createTitledBorder("Danh sách loại"));
		String[] str = { "Mã loại", "Tên loại" };
		tbModelLoai = new DefaultTableModel(str, 0);
		tableLoai = new JTable(tbModelLoai);

		JScrollPane jsc = new JScrollPane(tableLoai);
		KhungDuoi.add(jsc);

		ArrayList<Loai> dsloai = loai_dao.getAllLoai();
		for (Loai loai : dsloai) {
			tbModelLoai.addRow(new Object[] { loai.getMaLoai(), loai.getTenLoai() });
		}

		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createTitledBorder("Tác vụ"));
		bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBackground(gbBox);

		bottom.add(btnLmoiLoai = new JButton("Làm mới",iconLM));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnLuuLoai = new JButton("Lưu",iconL));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnSuaLoai = new JButton("Sửa",iconS));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnXoaLoai = new JButton("Xóa",iconX));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnTmaLoai = new JButton("Tìm theo mã: ",iconT));
		bottom.add(Box.createRigidArea(new Dimension(7, 15)));
		bottom.add(txtTmaLoai = new JTextField());
		txtTmaLoai.setMaximumSize(new Dimension(700, 25));

		KhungDuoi.add(bottom);
		tableLoai.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		     
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableLoai.getSelectedRowCount() == 1) {
					int row = tableLoai.getSelectedRow();
					String maLoai = (String) tableLoai.getValueAt(row, 0);
					Loai loai = new Loai_DAO().getLoaiTheoMaL(maLoai);
					txtMaLoai.setText(loai.getMaLoai());
					txtTenLoai.setText(loai.getTenLoai());
				}	
			}
	    });
		btnLmoiLoai.addActionListener(this);
		btnLuuLoai.addActionListener(this);
		btnSuaLoai.addActionListener(this);
		btnXoaLoai.addActionListener(this);
		btnTmaLoai.addActionListener(this);

		return box;
	}

	private Box quanLyHoaDon() {
		ImageIcon iconLM = new ImageIcon("img/icon_lammoi.png");
		ImageIcon iconL = new ImageIcon("img/icon-add.png");
		ImageIcon iconS = new ImageIcon("img/icon-sua.png");
		ImageIcon iconX = new ImageIcon("img/icon-remove.png");
		ImageIcon iconT = new ImageIcon("img/icon_TKSP.png");
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		JPanel pnKhungTren = new JPanel();
		pnKhungTren.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnKhungTren.setLayout(new GridLayout(2, 2, 5, 5));
		pnKhungTren.setBackground(gbBox);
		box.add(pnKhungTren);
		Box b1, b2, b3;

		box.add(b1 = Box.createHorizontalBox());// b1 -> b7: Box theo chi�?u ngang
		box.add(b2 = Box.createHorizontalBox());

		JLabel lblMaNV, lblMaHD, lblMaKH, lblNgayBan, lblTongTien;

		b1.add(lblMaHD = new JLabel("Mã hóa đơn:         "));
		b1.add(txtMaHD = new JTextField());
		txtMaHD.setMaximumSize(new Dimension(300, 20));
		b1.add(lblMaNV = new JLabel("         Mã nhân viên: "));
		b1.add(txtMaNV2 = new JTextField());
		txtMaNV2.setMaximumSize(new Dimension(300, 20));
		
		b2.add(lblMaKH = new JLabel("Mã khách hàng :   "));
		b2.add(txtMaKH2 = new JTextField());
		txtMaKH2.setMaximumSize(new Dimension(268, 20));
		
		b1.add(lblNgayBan = new JLabel("      Ngày bán: "));
		b1.add(txtNgayBan = new JTextField());
		txtNgayBan.setMaximumSize(new Dimension(300, 20));
		b2.add(lblTongTien = new JLabel("         Tổng tiền:         "));
		b2.add(txtTongTien = new JTextField());
		txtTongTien.setMaximumSize(new Dimension(268, 20));

		pnKhungTren.add(b1);
		pnKhungTren.add(b2);

		box.add(pnKhungTren);

		Box KhungDuoi;
		box.add(KhungDuoi = Box.createVerticalBox());
		KhungDuoi.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));

		String[] str = { "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày bán", "Tổng tiền" };
		tbModelHD = new DefaultTableModel(str, 0);
		tableHD = new JTable(tbModelHD);
		JScrollPane jsc = new JScrollPane(tableHD);
		KhungDuoi.add(jsc);
		ArrayList<HoaDon> dsHoaDon = hd_dao.getAllHoaDon();
		for (HoaDon hoaDon : dsHoaDon) {
			tbModelHD.addRow(new Object[] { hoaDon.getMaHD(), hoaDon.getMaNhanVien(), hoaDon.getMaKhach(),
					hoaDon.getNgayBan(), hoaDon.getTongTien() });
		}
		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createTitledBorder("Tác vụ"));

		bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBackground(gbBox);

		bottom.add(btnLmoiHD = new JButton("Làm mới",iconLM));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnLuuHD = new JButton("Lưu",iconL));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnSuaHD = new JButton("Sửa",iconS));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnXoaHD = new JButton("Xóa",iconX));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnTmaHD = new JButton("Tìm theo mã: ",iconT));
		bottom.add(Box.createRigidArea(new Dimension(7, 15)));
		bottom.add(txtTmaHD = new JTextField());
		txtTmaHD.setMaximumSize(new Dimension(700, 25));

		KhungDuoi.add(bottom);
		tableHD.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		     
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableHD.getSelectedRowCount() == 1) {
					int row = tableHD.getSelectedRow();
					String maHD = (String) tableHD.getValueAt(row, 0);
					HoaDon hoaDon = new HoaDon_DAO().getHoaDonTheoMaHD(maHD);
					txtMaHD.setText(hoaDon.getMaHD());
					txtMaKH2.setText(hoaDon.getMaNhanVien());
					txtMaNV2.setText(hoaDon.getMaKhach());
					txtTongTien.setText(hoaDon.getTongTien());
					txtNgayBan.setText(hoaDon.getNgayBan());
				}	
			}
	    });
		btnLmoiHD.addActionListener(this);
		btnLuuHD.addActionListener(this);
		btnSuaHD.addActionListener(this);
		btnXoaHD.addActionListener(this);
		btnTmaHD.addActionListener(this);
		
		return box;
	}

	private Box quanLyKhachHang() {
		ImageIcon iconLM = new ImageIcon("img/icon_lammoi.png");
		ImageIcon iconL = new ImageIcon("img/icon-add.png");
		ImageIcon iconS = new ImageIcon("img/icon-sua.png");
		ImageIcon iconX = new ImageIcon("img/icon-remove.png");
		ImageIcon iconT = new ImageIcon("img/icon_TKSP.png");
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createTitledBorder("Thông tin chung"));
		JPanel pnKhungTren = new JPanel();
		pnKhungTren.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		pnKhungTren.setLayout(new GridLayout(2, 3, 5, 5));
		pnKhungTren.setBackground(gbBox);
		box.add(pnKhungTren);
		Box b1, b2;

		box.add(b1 = Box.createHorizontalBox());// b1 -> b7: Box theo chi�?u ngang
		box.add(b2 = Box.createHorizontalBox());

		JLabel lblMaKH, lblTenKH, lblDiaChi, lblDienThoai, lblEmail;

		b1.add(lblMaKH = new JLabel("Mã khách hàng: "));
		b1.add(txtMaKH = new JTextField());
		txtMaKH.setMaximumSize(new Dimension(300, 20));
		b1.add(lblTenKH = new JLabel("    Tên khách hàng: "));
		b1.add(txtTenKH = new JTextField());
		txtTenKH.setMaximumSize(new Dimension(300, 20));
		b2.add(lblDiaChi = new JLabel("Địa chỉ:               "));
		b2.add(txtDiaChiKH = new JTextField());
		txtDiaChiKH.setMaximumSize(new Dimension(274, 20));
		b1.add(lblDienThoai = new JLabel("    Điện thoại: "));
		b1.add(txtDienThoaiKH = new JTextField());
		txtDienThoaiKH.setMaximumSize(new Dimension(300, 20));
		b2.add(lblDiaChi = new JLabel("     Email:                    "));
		b2.add(txtEmailKH = new JTextField());
		txtEmailKH.setMaximumSize(new Dimension(270, 20));

		pnKhungTren.add(b1);
		pnKhungTren.add(b2);

		box.add(pnKhungTren);

		Box KhungDuoi;
		box.add(KhungDuoi = Box.createVerticalBox());
		KhungDuoi.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));

		String[] str = { "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Điện thoại", "Email" };
		tbModelKH = new DefaultTableModel(str, 0);
		tableKH = new JTable(tbModelKH);
		JScrollPane jsc = new JScrollPane(tableKH);
		KhungDuoi.add(jsc);

		ArrayList<KhachHang> dsKhachHang = kh_dao.getAllKhachHang();
		for (KhachHang khachHang : dsKhachHang) {
			tbModelKH.addRow(new Object[] { khachHang.getMaKhach(), khachHang.getTenKhach(), khachHang.getDiaChi(),
					khachHang.getDienThoai(), khachHang.getEmail() });
		}
		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createTitledBorder("Tác vụ"));
		bottom.setAlignmentX(Component.CENTER_ALIGNMENT);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		bottom.setBackground(gbBox);

		bottom.add(btnLmoiKH = new JButton("Làm mới",iconLM));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnLuuKH = new JButton("Lưu",iconL));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnSuaKH = new JButton("Sửa",iconS));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnXoaKH = new JButton("Xóa",iconX));
		bottom.add(Box.createRigidArea(new Dimension(30, 15)));
		bottom.add(btnTmaKH = new JButton("Tìm theo mã: ",iconT));
		bottom.add(Box.createRigidArea(new Dimension(7, 15)));
		bottom.add(txtTmaKH = new JTextField());
		txtTmaKH.setMaximumSize(new Dimension(700, 25));

		KhungDuoi.add(bottom);
		
		tableKH.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		     
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tableKH.getSelectedRowCount() == 1) {
					int row = tableKH.getSelectedRow();
					String maKH = (String) tableKH.getValueAt(row, 0);
					KhachHang khachHang = new KhachHang_DAO().getKhachHangTheoMaKH(maKH);
					txtMaKH.setText(khachHang.getMaKhach());
					txtTenKH.setText(khachHang.getTenKhach());
					txtDiaChiKH.setText(khachHang.getDiaChi());
					txtEmailKH.setText(khachHang.getEmail());
					txtDienThoaiKH.setText(khachHang.getDienThoai());
				}	
			}
	    });
		btnLmoiKH.addActionListener(this);
		btnLuuKH.addActionListener(this);
		btnSuaKH.addActionListener(this);
		btnXoaKH.addActionListener(this);
		btnTmaKH.addActionListener(this);
		return box;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI_QuanLy2();
		UI_QuanLy2 frmQuanLy;

	}
	
	public boolean KiemTraSoDouble(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	public boolean KiemTraLoai() {
		if (txtTenLoai.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên loại không được bỏ trống");
			txtTenLoai.requestFocus();
			return false;
		} else if (!txtMaLoai.getText().trim().matches("[A-Z]{3}")) {
			JOptionPane.showMessageDialog(this, "Mã linh kiện có định dạng: AAA");
			txtMaLoai.requestFocus();
			txtMaLoai.selectAll();
			return false;
		}
		return true;
	}
	public boolean KiemTraLK() {
		if (txtTenLK.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên link kiện không được bỏ trống");
			txtTenNV.requestFocus();
			return false;
		} 
		
		else if(txtSoLuong.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Số lượng không được để trống");
			txtSoLuong.requestFocus();
			return false;
		}
		
		
		
		else if(!txtSoLuong.getText().trim().matches("[0-9]{1,}")) {
			JOptionPane.showMessageDialog(this, "Số lượng chỉ được nhập số nguyên");
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return false;
		} 
		
		else if(txtDonGiaNhap.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Đơn giá nhập không được để trống");
			txtDonGiaNhap.requestFocus();
			return false;
		}
		else if(!KiemTraSoDouble(txtDonGiaNhap.getText().trim())) {
			JOptionPane.showMessageDialog(this, "Đơn giá nhập chỉ được nhập số và 1 dấu chấm VD: 1999.0 ");
			txtDonGiaNhap.requestFocus();
			txtDonGiaNhap.selectAll();
			return false;
		}
		else if(txtDonGiaBan.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Đơn giá bán không được để trống");
			txtDonGiaNhap.requestFocus();
			return false;
		}
		else if(!KiemTraSoDouble(txtDonGiaBan.getText().trim())) {
			JOptionPane.showMessageDialog(this, "Đơn giá nhập chỉ được bán số và 1 dấu chấm VD: 1999.0 ");
			txtDonGiaBan.requestFocus();
			txtDonGiaBan.selectAll();
			return false;
		}
		else if(txtNgayNhap.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Ngày nhập không được để trống");
			txtDonGiaNhap.requestFocus();
			return false;
		}
		else if(!txtNgayNhap.getText().trim().matches("\\d{4}-\\d{2}-\\d{2}")) {
			JOptionPane.showMessageDialog(this, "Ngày nhập có dạng 2001-02-03");
			txtTongTien.requestFocus();
			txtTongTien.selectAll();
			return false;
		}
		else if (!txtMaLK.getText().trim().matches("LK[0-9]{5}")) {
			JOptionPane.showMessageDialog(this, "Mã LK có định dạng: LK99999");
			txtMaLK.requestFocus();
			txtMaLK.selectAll();
			return false;
		}
		return true;
	}
	public boolean KiemTraHD() {
		if (!txtMaHD.getText().trim().matches("HD[0-9]{5}")) {
			JOptionPane.showMessageDialog(this, "Mã Hóa Đơn có định dạng: HD99999");
			txtMaHD.requestFocus();
			txtMaHD.selectAll();
			return false;
		}
		else if (!txtMaNV2.getText().trim().matches("NV[0-9]{5}")) {
			JOptionPane.showMessageDialog(this, "Mã Nhân viên có định dạng: NV99999");
			txtMaNV2.requestFocus();
			txtMaNV2.selectAll();
			return false;
		}
		else if (!txtMaKH2.getText().trim().matches("KH[0-9]{5}")) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng có định dạng: KH99999");
			txtMaKH2.requestFocus();
			txtMaKH2.selectAll();
			return false;
		}
		else if(txtTongTien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Tổng tiền không được để trống");
			txtTongTien.requestFocus();
			return false;
		}
		else if(!KiemTraSoDouble(txtTongTien.getText().trim())) {
			JOptionPane.showMessageDialog(this, "Đơn tong tiền chỉ được nhập số và 1 dấu chấm VD: 1999.0 ");
			txtTongTien.requestFocus();
			txtTongTien.selectAll();
			return false;
		}
		else if(txtNgayBan.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Ngày bán không được để trống");
			txtNgayBan.requestFocus();
			return false;
		}
		else if(!txtNgayBan.getText().trim().matches("\\d{4}-\\d{2}-\\d{2}")) {
			JOptionPane.showMessageDialog(this, "Ngày bán có dạng 2001-02-03");
			txtNgayBan.requestFocus();
			txtNgayBan.selectAll();
			return false;
		}
		return true;
	}
	public boolean KiemTraNV() {

		if (txtTenNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên nhân viên không được bỏ trống");
			txtTenNV.requestFocus();
			return false;
		} else if (!txtTenNV.getText().trim().matches("([A-Z]{1}[A-Za-z']{1,}[ ]{0,1}){1,}")) {
			JOptionPane.showMessageDialog(this,
					"Tên phải bắt đầu bằng chữ viết in hoa, các chữ cái sau viết thường và không được chứa số");
			txtTenNV.requestFocus();
			txtTenNV.selectAll();
			return false;
		} else if (txtDiaChiNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được bỏ trống");
			txtDiaChiNV.requestFocus();
			return false;
		} else if (txtEmailNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được bỏ trống");
			txtEmailNV.requestFocus();
			return false;
		} else if (!txtEmailNV.getText().trim().matches("^[A-Za-z0-9._%+-]+@[a-z.-]+\\.[a-z]{2,6}$")) {
			JOptionPane.showMessageDialog(this, "Email phải có định dạng example@xyz.abc hoặc eXAmple123@xyz.abc");
			txtEmailNV.requestFocus();
			txtEmailNV.selectAll();
			return false;
		} else if (txtDienThoaiNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được bỏ trống");
			txtDienThoaiNV.requestFocus();
			return false;
		} else if (!txtDienThoaiNV.getText().trim().matches("[0][1-9][0-9]{8}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại đạn 10 số và đầu số là 0 ");
			txtDienThoaiNV.requestFocus();
			txtDienThoaiNV.selectAll();
			return false;
		}else if(txtNgaySinhNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Ngày sinh không được để trống");
			txtNgaySinhNV.requestFocus();
			return false;
		}
		else if(!txtNgaySinhNV.getText().trim().matches("\\d{4}-\\d{2}-\\d{2}")) {
			JOptionPane.showMessageDialog(this, "Ngày sinh có dạng 2001-02-03");
			txtNgaySinhNV.requestFocus();
			txtNgaySinhNV.selectAll();
			return false;
		} 
		else if (txtMaNV.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Mã  không được để trống");
			txtMaNV.requestFocus();
			return false;
		} 
		else if (!txtMaNV.getText().trim().matches("NV[0-9]{5}")) {
			JOptionPane.showMessageDialog(this, "Mã Nhân viên có định dạng: NV99999");
			txtMaNV.requestFocus();
			txtMaNV.selectAll();
			return false;
		}
		else if (txtLuong.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Lương  không được để trống");
			txtLuong.requestFocus();
			return false;
		}
		else if(!KiemTraSoDouble(txtLuong.getText().trim())) {
			JOptionPane.showMessageDialog(this, "Lương chỉ được nhập số và 1 dấu chấm VD: 1999.0 ");
			txtLuong.requestFocus();
			txtLuong.selectAll();
			return false;
		}
		else if (Double.parseDouble(txtLuong.getText().trim()) <= 0.0){
			JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 0");
			txtLuong.requestFocus();
			txtLuong.selectAll();
			return false;
		}
		return true;
	}
	public boolean KiemTraKH() {

		if (txtTenKH.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên khách không được bỏ trống");
			txtTenKH.requestFocus();
			return false;
		} else if (!txtTenKH.getText().trim().matches("([A-Z]{1}[A-Za-z']{1,}[ ]{0,1}){1,}")) {
			JOptionPane.showMessageDialog(this,
					"Tên phải bắt đầu bằng chữ viết in hoa, các chữ cái sau viết thường và không được chứa số");
			txtTenKH.requestFocus();
			txtTenKH.selectAll();
			return false;
		} else if (txtDiaChiKH.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ không được bỏ trống");
			txtDiaChiKH.requestFocus();
			return false;
		} else if (txtEmailKH.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được bỏ trống");
			txtEmailKH.requestFocus();
			return false;
		} else if (!txtEmailKH.getText().trim().matches("^[A-Za-z0-9._%+-]+@[a-z.-]+\\.[a-z]{2,6}$")) {
			JOptionPane.showMessageDialog(this, "Email phải có định dạng example@xyz.abc hoặc eXAmple123@xyz.abc");
			txtEmailKH.requestFocus();
			txtEmailKH.selectAll();
			return false;
		} else if (txtDienThoaiKH.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được bỏ trống");
			txtDienThoaiKH.requestFocus();
			return false;
		} else if (!txtDienThoaiKH.getText().trim().matches("[0][1-9][0-9]{8}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại đạn 10 số và đầu số là 0 ");
			txtDienThoaiKH.requestFocus();
			txtDienThoaiKH.selectAll();
			return false;
		} else if (txtMaKH.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Mã  không được để trống");
			txtMaKH.requestFocus();
			return false;
		}
			return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Object sou = e.getSource();
				///////////////////////////////////////////////////////////////////
				if(sou.equals(btnQuanLy)) {
					UI_QuanLy2 frmQuanLy= new UI_QuanLy2();
					this.dispose();
				}
				else if(sou.equals(btnThoat)) {
					UI_TrangChu frmTrangChu= new UI_TrangChu();
					this.dispose();
			}
				
				//////////
				else if (sou.equals(btnLuuNV)) {
					if (KiemTraNV()) {
						NhanVien nv = nv_dao.getNhanVienTheoMaNV(txtMaNV.getText().trim().toUpperCase());
						if(nv != null) {
							JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
							return;
						}
						nv = new NhanVien(txtMaNV.getText(), txtTenNV.getText(), chkGioiTinhNV.isSelected(),
								Date.valueOf(txtNgaySinhNV.getText().trim()), txtDiaChiNV.getText(), txtDienThoaiNV.getText(),
								txtEmailNV.getText(), Double.parseDouble(txtLuong.getText()));
						if (nv_dao.create(nv)) {
								tbModelNV.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Nữ" : "Nam",
										nv.getNgaySinh(), formatter.format(nv.getLuong() * 1000), nv.getDiaChi(), nv.getDienThoai(),
										nv.getEmail() });
							JOptionPane	.showMessageDialog(this, "Lưu thành công");
						} else
							JOptionPane.showMessageDialog(this, "Lưu không thành công");
					}
				}
				
				else if (sou.equals(btnLuuLK)) {
					if (KiemTraLK()) {
						LinhKien lk = lk_dao.getLinhKienTheoMaLK(txtMaLK.getText().trim());
						if(lk != null) {
							JOptionPane.showMessageDialog(this, "Mã linh kiện đã tồn tại");
							return;
						}
					 lk = new LinhKien(txtMaLK.getText().trim(), txtTenLK.getText().trim(),
							Integer.parseInt(txtSoLuong.getText()), Double.parseDouble(txtDonGiaNhap.getText()),
							Double.parseDouble(txtDonGiaBan.getText()), Date.valueOf(txtNgayNhap.getText()));
					if (lk_dao.create(lk)) {
						tbModelLK.addRow(new Object[] { lk.getMaLinhkien(), lk.getTenLinhkien(), lk.getSoLuong(),
								formatter.format(lk.getDonGiaNhap() * 1000), formatter.format(lk.getDonGiaBan() * 1000),
								lk.getNgayNhap() });
						JOptionPane.showMessageDialog(this, "Lưu thành công");
					} else
						JOptionPane.showMessageDialog(this, "Lưu không thành công");

				} 
				}
				else if (sou.equals(btnLuuHD)) {
					if (KiemTraHD()) {
					hd = new HoaDon(txtMaHD.getText().trim().toUpperCase());
					ArrayList <HoaDon> dsHD = hd_dao.getAllHoaDon();
					for (HoaDon hdt : dsHD) {
						if (hdt.getMaHD().equalsIgnoreCase(hd.getMaHD())) {
							JOptionPane.showMessageDialog(this, "Mã HĐ đã tồn tại");
							return;
						}
					}
					hd = new HoaDon(txtMaHD.getText().trim(), txtMaNV2.getText().trim(), txtMaKH2.getText().trim(),txtNgayBan.getText().trim(), txtTongTien.getText().trim());
					if (hd_dao.create(hd)) {
						Object[] rowData = { txtMaHD.getText(), txtMaNV2.getText(), txtMaKH2.getText(),txtNgayBan.getText(), txtTongTien.getText() };
						tbModelHD.addRow(rowData);
						JOptionPane.showMessageDialog(this, "Lưu thành công");
					} else
						JOptionPane.showMessageDialog(this, "Lưu không thành công");
				} 
				}
						
				else if (sou.equals(btnLuuKH)) {
					if (KiemTraKH()) {
						KhachHang kh  = kh_dao.getKhachHangTheoMaKH(txtMaKH.getText().trim().toUpperCase());
						if(kh != null) {
							JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại");
							return;
						}
						kh = new KhachHang(txtMaKH.getText().trim(), txtTenKH.getText().trim(),
								txtDiaChiKH.getText().trim(), txtDienThoaiKH.getText().trim(), txtEmailKH.getText().trim());
					if (kh_dao.create(kh)) {
						Object[] rowData = { txtMaKH.getText(), txtTenKH.getText(), txtDiaChiKH.getText(),
								txtDienThoaiKH.getText(), txtEmailKH.getText() };
						tbModelKH.addRow(rowData);
						JOptionPane.showMessageDialog(this, "Lưu thành công");
					} else
						JOptionPane.showMessageDialog(this, "Lưu không thành công");

				}
				}

				else if (sou.equals(btnLuuLoai)) {
					if (KiemTraLoai()) {
					loai = new Loai(txtMaLoai.getText().trim().toUpperCase());
					ArrayList<Loai> dsloai = loai_dao.getAllLoai();
					for (Loai loait : dsloai) {
						if (loait.getMaLoai().equalsIgnoreCase(loai.getMaLoai())) {
							JOptionPane.showMessageDialog(this, "Mã loại đã tồn tại");
							return;
						}
					}
					loai = new Loai(txtMaLoai.getText().trim(), txtTenLoai.getText().trim());
					if (loai_dao.create(loai)) {
						Object[] rowData = { txtMaLoai.getText(), txtTenLoai.getText() };
						tbModelLoai.addRow(rowData);
						JOptionPane.showMessageDialog(this, "Lưu thành công");
					} else
						JOptionPane.showMessageDialog(this, "Lưu không thành công");
				} 
				} 
				else if (sou.equals(btnLmoiNV)) {
					tableNV.getSelectionModel().clearSelection();
					txtMaNV.setText("");
					txtTenNV.setText("");
					chkGioiTinhNV.setSelected(false);
					txtNgaySinhNV.setText("");
					txtDiaChiNV.setText("");
					txtDienThoaiNV.setText("");
					txtEmailNV.setText("");
					txtLuong.setText("");
					
					tbModelNV.getDataVector().removeAllElements();
					if (tbModelNV.getRowCount()<2) {
						ArrayList<NhanVien> dsnv = nv_dao.getAllNhanVien();
						for (NhanVien nv : dsnv) {
							tbModelNV.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Nữ" : "Nam",
									nv.getNgaySinh(), formatter.format(nv.getLuong() * 1000), nv.getDiaChi(), nv.getDienThoai(),
									nv.getEmail() });
					}
				}
				} else if (sou.equals(btnLmoiLK)) {
					tableLK.getSelectionModel().clearSelection();
					txtMaLK.setText("");
					txtTenLK.setText("");
					txtSoLuong.setText("");
					txtDonGiaNhap.setText("");
					txtDonGiaBan.setText("");
					txtNgayNhap.setText("");
					
					tbModelLK.getDataVector().removeAllElements();
					if (tbModelLK.getRowCount()<2) {
						ArrayList<LinhKien> dslk = lk_dao.getAllLinhKien();
						for (LinhKien lk : dslk) {
							tbModelLK.addRow(new Object[] { lk.getMaLinhkien(), lk.getTenLinhkien(),
									lk.getSoLuong(),
									formatter.format(lk.getDonGiaNhap() * 1000), formatter.format(lk.getDonGiaBan() * 1000),
									lk.getNgayNhap() });
						}
					}

				} else if (sou.equals(btnLmoiLoai)) {
					tableLoai.getSelectionModel().clearSelection();
					txtMaLoai.setText("");
					txtTenLoai.setText("");
					tbModelLoai.getDataVector().removeAllElements();
					if (tbModelLoai.getRowCount()<2) {
					ArrayList<Loai> dsloai = loai_dao.getAllLoai();
					for (Loai loai : dsloai) {
						tbModelLoai.addRow(new Object[] { loai.getMaLoai(), loai.getTenLoai() });
					}
					}
				} else if (sou.equals(btnLmoiKH)) {
					tableKH.getSelectionModel().clearSelection();
					txtMaKH.setText("");
					txtTenKH.setText("");
					txtDiaChiKH.setText("");
					txtDienThoaiKH.setText("");
					txtEmailKH.setText("");
					tbModelKH.getDataVector().removeAllElements();
					if (tbModelKH.getRowCount()<2) {
					ArrayList<KhachHang> dsKhachHang = kh_dao.getAllKhachHang();
					for (KhachHang khachHang : dsKhachHang) {
						tbModelKH.addRow(new Object[] { khachHang.getMaKhach(), khachHang.getTenKhach(), khachHang.getDiaChi(),
								khachHang.getDienThoai(), khachHang.getEmail() });
					}
					}
				} else if (sou.equals(btnLmoiHD)) {
					tableHD.getSelectionModel().clearSelection();
					txtMaHD.setText("");
					txtMaNV2.setText("");
					txtMaKH2.setText("");
					txtNgayBan.setText("");
					txtTongTien.setText("");
					tbModelHD.getDataVector().removeAllElements();
					if (tbModelHD.getRowCount()<2) {
					ArrayList<HoaDon> dsHoaDon = hd_dao.getAllHoaDon();
					for (HoaDon hoaDon : dsHoaDon) {
						tbModelHD.addRow(new Object[] { hoaDon.getMaHD(), hoaDon.getMaNhanVien(), hoaDon.getMaKhach(),
								hoaDon.getNgayBan(), hoaDon.getTongTien() });
					
					}
					}
				}
				else if (sou.equals(btnXoaNV)) {
					int row = tableNV.getSelectedRow();
					if (row == -1)
						JOptionPane.showMessageDialog(this, "Chưa chọn dòng cần xóa");
					else {
						System.out.println(row);
						String maNV = tbModelNV.getValueAt(row, 0).toString();
						System.out.println(tbModelNV.getRowCount());
						if (new NhanVien_DAO().delete(maNV)) {
							tbModelNV.removeRow(row);
							tableNV.getSelectionModel().clearSelection();
							JOptionPane.showMessageDialog(this, "Đã xóa thành công");
						} else {
							JOptionPane.showMessageDialog(this, "Xóa không thành công");
						}
					}
				} else if (sou.equals(btnXoaKH)) {
					if (tableKH.getSelectedRow() == -1)
						JOptionPane.showMessageDialog(this, "Chưa chọn dòng cần xóa");
					else {
						int row = tableKH.getSelectedRow();

						if (kh_dao.delete(String.valueOf(tbModelKH.getValueAt(row, 0)))) {
							tbModelKH.removeRow(row);
							tableKH.getSelectionModel().clearSelection();
							JOptionPane.showMessageDialog(this, "Đã xóa thành công");
						} else {
							JOptionPane.showMessageDialog(this, "Xóa không thành công");
						}
					}
				} else if (sou.equals(btnXoaLK)) {
					if (tableLK.getSelectedRow() == -1)
						JOptionPane.showMessageDialog(this, "Chưa chọn dòng cần xóa");
					else {
						int row = tableLK.getSelectedRow();

						if (lk_dao.delete(String.valueOf(tbModelLK.getValueAt(row, 0)))) {
							tbModelLK.removeRow(row);
							JOptionPane.showMessageDialog(this, "Đã xóa thành công");
						} else {
							JOptionPane.showMessageDialog(this, "Xóa không thành công");
						}
					}
				} else if (sou.equals(btnXoaLoai)) {
					if (tableLoai.getSelectedRow() == -1)
						JOptionPane.showMessageDialog(this, "Chưa chọn dòng cần xóa");
					else {
						int row = tableLoai.getSelectedRow();

						if (loai_dao.delete(String.valueOf(tbModelLoai.getValueAt(row, 0)))) {
							tbModelLoai.removeRow(row);
							JOptionPane.showMessageDialog(this, "Đã xóa thành công");
						} else {
							JOptionPane.showMessageDialog(this, "Xóa không thành công");
						}
					}
				} else if (sou.equals(btnXoaHD)) {
					if (tableHD.getSelectedRow() == -1)
						JOptionPane.showMessageDialog(this, "Chưa chọn dòng cần xóa");
					else {
						//hd = new HoaDon(txtMaHD.getText().trim(), txtMaNV2.getText().trim(), txtMaKH2.getText().trim(),txtNgayBan.getText().trim(), txtTongTien.getText().trim());
						int row = tableHD.getSelectedRow();
						if (hd_dao.delete(txtMaHD.getText().trim())) {
							tbModelHD.removeRow(row);
							JOptionPane.showMessageDialog(this, "Đã xóa thành công");
						} else {
							JOptionPane.showMessageDialog(this, "Xóa không thành công");
						}
					}
				} 
				else if (sou.equals(btnSuaNV)) {
					int row = tableNV.getSelectedRow();
					if (tableNV.getSelectedRow() == -1)
						JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa.");
					else {
						if (KiemTraNV()) {
							NhanVien nv = new NhanVien(txtMaNV.getText(), txtTenNV.getText(), chkGioiTinhNV.isSelected(),
									Date.valueOf(txtNgaySinhNV.getText().trim()), txtDiaChiNV.getText(), txtDienThoaiNV.getText(),
									txtEmailNV.getText(), Double.parseDouble(txtLuong.getText()));
							if (nv_dao.update(nv)) {
								tbModelNV.setValueAt(nv.getTenNhanVien(), row, 1);
								tbModelNV.setValueAt(nv.isGioiTinh() == true ? "Nữ":"Nam", row, 2);
								tbModelNV.setValueAt(nv.getNgaySinh(), row, 3);
								tbModelNV.setValueAt(formatter.format(nv.getLuong() * 1000), row, 4);
								tbModelNV.setValueAt(nv.getDiaChi(), row, 5);
								tbModelNV.setValueAt(nv.getDienThoai(), row, 6);
								tbModelNV.setValueAt(nv.getEmail(), row, 7);

								JOptionPane.showMessageDialog(this, "Sửa thông tin thành công");
							} else
								JOptionPane.showMessageDialog(this, "Sửa thông tin không thành công");
						}
						
					}
				}
				
				else if (sou.equals(btnSuaLoai)) {
					int row = tableLoai.getSelectedRow();
					if (tableLoai.getSelectedRow() == -1)
						JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa.");
					else {
						if (KiemTraLoai()) {
							Loai loai = new Loai(txtMaLoai.getText(), txtTenLoai.getText());
							if (loai_dao.update(loai)) {
								  tbModelLoai.setValueAt(loai.getTenLoai(), row, 1);
								 // tbModelLoai.setValueAt("Chiêu", row, 2);
								 
								JOptionPane.showMessageDialog(this, "Sửa thông tin thành công");
							} else
								JOptionPane.showMessageDialog(this, "Sửa thông tin không thành công");
						}
						
					}
				}			
				else if (sou.equals(btnSuaKH)){
					int row = tableKH.getSelectedRow();
					if (row == -1)
						JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa.");
					
					else {
						if (KiemTraKH()) {
							KhachHang kh = new KhachHang(txtMaKH.getText(), txtTenKH.getText(), txtDiaChiKH.getText(), txtDienThoaiKH.getText(), txtEmailKH.getText());
							if (kh_dao.update(kh)) {
								tbModelKH.setValueAt(kh.getTenKhach(), row, 1);
								tbModelKH.setValueAt(kh.getDiaChi(), row, 2);
								tbModelKH.setValueAt(kh.getDienThoai() ,row, 3);
								tbModelKH.setValueAt(kh.getEmail(), row, 4);
								JOptionPane.showMessageDialog(this, "Sửa thông tin thành công");
							} else
								JOptionPane.showMessageDialog(this, "Sửa thông tin không thành công");
						}
						
					}
				}else if (sou.equals(btnSuaHD)){
					if (tableHD.getSelectedRow() == -1)
						JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa.");
					else {
						if (KiemTraHD()) {
							int row = tableHD.getSelectedRow();
							HoaDon hoaDon = new HoaDon(txtMaHD.getText(), txtMaKH2.getText(), txtMaNV2.getText(), txtNgayBan.getText(),txtTongTien.getText() );
							if (hd_dao.update(hoaDon)) {
								tbModelHD.setValueAt(hoaDon.getMaNhanVien(),row, 1);
								tbModelHD.setValueAt(hoaDon.getMaKhach(),row, 2);
								tbModelHD.setValueAt(hoaDon.getNgayBan(),row, 3);
								tbModelHD.setValueAt(hoaDon.getTongTien() , row, 4);
								JOptionPane.showMessageDialog(this, "Sửa thông tin thành công");
							} else
								JOptionPane.showMessageDialog(this, "Sửa thông tin không thành công");
						}
						
					}
				}	

				
				else if(sou.equals(btnSuaLK)) {
					int row = tableLK.getSelectedRow();
					if (row == -1)
						JOptionPane.showMessageDialog(this, "Phải chọn dòng cần sửa.");
					
					else {
						if (KiemTraLK()) {
							//Loai loai = new Loai_DAO().getLoaiTheoMaL(cboLoai.getSelectedItem().toString());
							LinhKien lk = new LinhKien(txtMaLK.getText().trim(), txtTenLK.getText() ,Integer.parseInt(txtSoLuong.getText()), 
								Double.valueOf(txtDonGiaNhap.getText()), Double.valueOf(txtDonGiaBan.getText()) , Date.valueOf(txtNgayNhap.getText()));
							
							if (lk_dao.update(lk)) {
								tbModelLK.setValueAt(lk.getTenLinhkien(), row, 1);
								//tbModelLK.setValueAt(lk.getLoai().getMaLoai(), row, 2);
								tbModelLK.setValueAt(lk.getSoLuong() ,row, 2);
								tbModelLK.setValueAt(formatter.format(lk.getDonGiaNhap() * 1000), row, 3);
								tbModelLK.setValueAt(formatter.format(lk.getDonGiaBan() * 1000), row, 4);
								tbModelLK.setValueAt(lk.getNgayNhap().toString(), row, 5);
								JOptionPane.showMessageDialog(this, "Sửa thông tin thành công");
							} else
								JOptionPane.showMessageDialog(this, "Sửa thông tin không thành công");
						}
						
					}
				}
				
				
				
				
				
				
				else if(sou.equals(btnTmaNV)) {
						tableNV.getSelectionModel().clearSelection();
						tbModelNV.getDataVector().removeAllElements();
						NhanVien nv = nv_dao.getNhanVienTheoMaNV(txtTmaNV.getText().trim().toUpperCase());
						if(nv == null) {
							JOptionPane.showMessageDialog(this,"Không tồn tại nhân viên có mã trên");
							txtTmaNV.selectAll();
							txtTmaNV.requestFocus();
						}
						else
							tbModelNV.addRow(new Object[] { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.isGioiTinh() ? "Nữ" : "Nam",
									nv.getNgaySinh(), formatter.format(nv.getLuong() * 1000), nv.getDiaChi(), nv.getDienThoai(),
									nv.getEmail() });
							}
				
				else if(sou.equals(btnTmaLK)) {
					tableLK.getSelectionModel().clearSelection();
					tbModelLK.getDataVector().removeAllElements();;
					LinhKien lk = lk_dao.getLinhKienTheoMaLK(txtTmaLK.getText().trim().toUpperCase());
					if(lk == null) {
						JOptionPane.showMessageDialog(this,"Không tồn tại linh kiện có mã trên");
						txtTmaLK.selectAll();
						txtTmaLK.requestFocus();
					}
					else
						tbModelLK.addRow(new Object[] {lk.getMaLinhkien(),lk.getTenLinhkien(),String.valueOf(formatter.format(lk.getDonGiaNhap() * 1000)),String.valueOf(formatter.format(lk.getDonGiaBan() * 1000)),lk.getNgayNhap()});
			}
				else if(sou.equals(btnTmaKH)) {
					tableKH.getSelectionModel().clearSelection();
					tbModelKH.getDataVector().removeAllElements();;
					KhachHang kh = kh_dao.getKhachHangTheoMaKH(txtTmaKH.getText().trim().toUpperCase());
					if(kh == null) {
						JOptionPane.showMessageDialog(this,"Không tồn tại khách hàng có mã trên");
						txtTmaKH.selectAll();
						txtTmaKH.requestFocus();
					}
					else
						tbModelKH.addRow(new Object[] {kh.getMaKhach(),kh.getTenKhach(),kh.getDiaChi(),kh.getDienThoai(),kh.getEmail()});
				}
				else if(sou.equals(btnTmaLoai)){
					tableLoai.getSelectionModel().clearSelection();
					tbModelLoai.getDataVector().removeAllElements();;
					Loai loai = loai_dao.getLoaiTheoMaL(txtTmaLoai.getText().trim().toUpperCase());
					if(loai == null) {
						JOptionPane.showMessageDialog(this,"Không tồn tại loại linh kiện có mã trên");
						txtTmaLoai.selectAll();
						txtTmaLoai.requestFocus();
					}
					else
						tbModelLoai.addRow(new Object[] {loai.getMaLoai(),loai.getTenLoai()});
				}
				else if(sou.equals(btnTmaHD)){
					tableHD.getSelectionModel().clearSelection();
					tbModelHD.getDataVector().removeAllElements();
					HoaDon hd = hd_dao.getHoaDonTheoMaHD(txtTmaHD.getText().trim().toUpperCase());
					if(hd == null) {
						JOptionPane.showMessageDialog(this,"Không tồn tại hóa đơn có mã trên");
						txtTmaHD.selectAll();
						txtTmaHD.requestFocus();
					}
					else
						tbModelHD.addRow(new Object[] {hd.getMaHD(),hd.getMaKhach(),hd.getMaNhanVien(),hd.getNgayBan(),hd.getTongTien()});
				}
			}



}
