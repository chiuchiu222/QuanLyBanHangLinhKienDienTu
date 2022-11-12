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

public class UI_DangNhap extends JFrame implements ActionListener {
	JLabel lblTaiKhoan, lblMatKhau, lblTieuDe, lblnote;
	JTextField txtTaiKhoan;
	JPasswordField txtMatKhau;
	JButton btnDangNhap, btnThoat;
	Color gbMain = new Color(246, 229, 200);

	public UI_DangNhap(){
		// TODO Auto-generated constructor stub
		setTitle("ĐĂNG NHẬP");
		
		JPanel pNorth;
		add(pNorth = new JPanel(), BorderLayout.NORTH);
		


		JPanel pCenter;
		add(pCenter = new JPanel(), BorderLayout.CENTER);
		pCenter.setBackground(gbMain);
		Box x;
		pCenter.add(x = Box.createVerticalBox());
		x.add(Box.createVerticalStrut(30));
		
		Box x0;
		x.add(x0= Box.createHorizontalBox());
		x0.add(lblTieuDe= new JLabel("CHƯƠNG TRÌNH QUẢN LÝ MUA BÁN LINH KIỆN MÁY TÍNH"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 15));
		lblTieuDe.setForeground(Color.RED);
		x.add(Box.createVerticalStrut(30));
		
		Box x1;
		x.add(x1= Box.createHorizontalBox());
		x1.add(Box.createHorizontalStrut(50));
		x1.add(lblTaiKhoan= new JLabel("Tài khoản: "));
		x1.add(Box.createHorizontalStrut(20));
		x1.add(txtTaiKhoan = new JTextField());
		x1.add(Box.createHorizontalStrut(50));
		x.add(Box.createVerticalStrut(15));
		
		Box x2;
		x.add(x2= Box.createHorizontalBox());
		x2.add(Box.createHorizontalStrut(50));
		x2.add(lblMatKhau = new JLabel("Mật khẩu:  "));
		x2.add(Box.createHorizontalStrut(20));
		x2.add(txtMatKhau = new JPasswordField());
		x2.add(Box.createHorizontalStrut(50));
		x.add(Box.createVerticalStrut(20));
		
		Box x3;
		x.add(x3= Box.createHorizontalBox());
		x3.add(btnDangNhap= new JButton("Đăng nhập"));
		btnDangNhap.setForeground(Color.CYAN);
		btnDangNhap.setBackground(Color.GRAY);
		x3.add(Box.createHorizontalStrut(20));
		x3.add(btnThoat= new JButton("    Thoát    "));
		btnThoat.setForeground(Color.CYAN);
		btnThoat.setBackground(Color.GRAY);
		x.add(Box.createVerticalStrut(30));
		
		Box x4;
		x.add(x4 = Box.createHorizontalBox());
		x4.add(lblnote= new JLabel("Tài Khoản: admin | Mật khẩu: 123456"));
		
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		txtTaiKhoan.addActionListener(this);
		txtMatKhau.addActionListener(this);
		setSize(500, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new UI_DangNhap();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object sou = e.getSource();
		if(sou.equals(btnDangNhap) || sou.equals(txtMatKhau) || sou.equals(txtTaiKhoan)) {
			String dangNhap = txtTaiKhoan.getText();
			char[] char_matKhau = txtMatKhau.getPassword();
			String matKhau = new String(char_matKhau);
			if(dangNhap.equalsIgnoreCase("admin") == true && matKhau.equalsIgnoreCase("123456") == true)
			{
				UI_TrangChu frm1 = new UI_TrangChu();
				this.dispose();
			}
			else
				JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng");
		}
		else if(sou.equals(btnThoat)){
			int temp = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Cảnh báo", JOptionPane.YES_NO_CANCEL_OPTION);
			if(temp == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			else if(temp == JOptionPane.NO_OPTION) {
				new UI_DangNhap();
				this.dispose();
			}
			
		}
	}
}
