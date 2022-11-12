package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UI_TrangChu extends JFrame implements ActionListener{
	private JLabel lblTitle, lblCenter1, lblCenter2;
	private JButton btnQuanLy, btnThoat;
	Color gbbtn = new Color(246, 229, 141);
	Color gbActive = new Color(255, 242, 0);
	Color gbMain = new Color(246, 229, 200);
	public UI_TrangChu() {
		// TODO Auto-generated constructor stub
		setTitle("Trang Chủ");
		GiaoDienTrangChu();
		setSize(1400,700);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void GiaoDienTrangChu(){
		
		
		JPanel pWest = new JPanel();
		pWest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Tác vụ"));
		Color bgColor = new Color(223,249,251);
		pWest.setBackground(bgColor);
		
		ImageIcon iconQuanLy = new ImageIcon("img/icon_quanly.png");
		ImageIcon iconThoat = new ImageIcon("img/icon_thoat.png");
		

		
		pWest.add(btnQuanLy= new JButton("QUẢN LÝ",iconQuanLy));
		btnQuanLy.setBorder(BorderFactory.createLineBorder(Color.black));
		btnQuanLy.setBackground(gbbtn);
		btnQuanLy.setForeground(Color.DARK_GRAY);
		btnQuanLy.setPreferredSize(new Dimension(200, 70));	
		pWest.add(Box.createVerticalStrut(80));
		

		
		pWest.add(btnThoat= new JButton("Đóng ứng dụng",iconThoat));
		btnThoat.setBorder(BorderFactory.createEtchedBorder(Color.red, Color.red));
		Color bgExit = new Color(255, 121, 121);
		btnThoat.setBackground(bgExit);
		btnThoat.setForeground(Color.black);
		btnThoat.setPreferredSize(new Dimension(200, 50));
		pWest.add(Box.createVerticalStrut(80));
		
		add(pWest, BorderLayout.WEST);
		pWest.setPreferredSize(new Dimension(250,243));
		
		btnQuanLy.addActionListener(this);
		btnThoat.addActionListener(this);
		

		JPanel pCenter= new JPanel();
		pCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), " "));
		add(pCenter, BorderLayout.CENTER);
		pCenter.setBackground(gbMain);
		pCenter.add(lblCenter1= new JLabel("CHƯƠNG TRÌNH QUẢN LÝ"));
		lblCenter1.setFont(new Font("Arial", Font.BOLD, 45));
		lblCenter1.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		lblCenter1.setForeground(Color.red);
		
		pCenter.add(lblCenter2= new JLabel("BÁN HÀNG LINH KIỆN MÁY TÍNH"));
		lblCenter2.setFont(new Font("Arial", Font.BOLD, 45));
		lblCenter2.setForeground(Color.red);
		lblCenter2.setBorder(BorderFactory.createEmptyBorder(10, 130, 5, 130));
		
		JLabel lblTemp, lblNhom17, lblNHN, lblNQK,lblNNQ,lblHTP;
		Box temp, nhom17, lhv, nld, ttc;
		
		pCenter.add(temp= Box.createHorizontalBox());
		temp.add(lblTemp= new JLabel("~~~~~~~~~o~~~~~~~~~"));
		lblTemp.setFont(new Font("Arial", Font.BOLD, 30));
		lblTemp.setForeground(Color.red);
		lblTemp.setBorder(BorderFactory.createEmptyBorder(0, 500, 70, 500) );
		
		pCenter.add(nhom17= Box.createHorizontalBox());
		nhom17.add(lblNhom17= new JLabel("Nhóm ABC"));
		lblNhom17.setFont(new Font("Arial", Font.BOLD, 30));
		lblNhom17.setForeground(Color.GRAY);
		lblNhom17.setBorder(BorderFactory.createEmptyBorder(0, 500, 10, 500) );
		
		pCenter.add(lhv= Box.createHorizontalBox());
		lhv.add(lblNQK= new JLabel("Hồ Viên Chiêu - 4501104028"));
		lblNQK.setFont(new Font("Arial", Font.BOLD, 30));
		lblNQK.setForeground(Color.GRAY);
		lblNQK.setBorder(BorderFactory.createEmptyBorder(0, 500, 10, 500) );
		
		pCenter.add(nld= Box.createHorizontalBox());
		nld.add(lblNHN= new JLabel("Võ Thành Quang - 4501104189"));
		lblNHN.setFont(new Font("Arial", Font.BOLD, 30));
		lblNHN.setForeground(Color.GRAY);
		lblNHN.setBorder(BorderFactory.createEmptyBorder(0, 500, 10, 500) );
		
		pCenter.add(ttc= Box.createHorizontalBox());
		ttc.add(lblNNQ= new JLabel("Lê Nguyễn Phú Hưng - 46.01.104.060"));
		lblNNQ.setFont(new Font("Arial", Font.BOLD, 30));
		lblNNQ.setForeground(Color.GRAY);
		lblNNQ.setBorder(BorderFactory.createEmptyBorder(0, 500, 10, 500) );
		
		pCenter.add(ttc= Box.createHorizontalBox());
		ttc.add(lblHTP= new JLabel("Đinh Trần Thanh Tú - 46.01.104.205"));
		lblHTP.setFont(new Font("Arial", Font.BOLD, 30));
		lblHTP.setForeground(Color.GRAY);
		lblHTP.setBorder(BorderFactory.createEmptyBorder(0, 500, 10, 500) );
		
		pCenter.add(ttc= Box.createHorizontalBox());
		ttc.add(lblHTP= new JLabel("Lê Quốc Tài - 46.01.104."));
		lblHTP.setFont(new Font("Arial", Font.BOLD, 30));
		lblHTP.setForeground(Color.GRAY);
		lblHTP.setBorder(BorderFactory.createEmptyBorder(0, 500, 10, 500) );
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI_TrangChu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Object sou = e.getSource();
				if(sou.equals(btnQuanLy)) {
					UI_QuanLy2 frmQuanLy= new UI_QuanLy2();
					this.dispose();
				}
				else if(sou.equals(btnThoat)) {
					int temp = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Cảnh báo", JOptionPane.YES_NO_CANCEL_OPTION);
					if(temp == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					else if(temp == JOptionPane.NO_OPTION) {
						new UI_TrangChu();
						this.dispose();
					}
				}
	}

}
