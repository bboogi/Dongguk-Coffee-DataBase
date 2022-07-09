import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.util.Scanner;

//main_screen******************************************
class main_screen extends JFrame{
	
	private JPanel p_background;
	private JPanel p_north;
	private JPanel p_south;
	
	
	public main_screen(){
		set_layout();
		setSize(600, 700);
		setVisible(true);
	}
	 
	
	public void set_layout(){
		
		setTitle("동국커피 DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫으면 프로그램 종료
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//JPanner------------------------------------------------
	
		JPanel p_background = new JPanel();
		p_background.setLayout(null);
		p_background.setBackground(Color.white);
		p_background.setBounds(0, 0, 600, 600);
		c.add(p_background);
		
		
		//BorderLayout.NORTH

		JPanel p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(31, 115, 48));
		p_north.setBounds(0, 0, 600, 100);
		p_background.add(p_north);
		
		
		//BorderLayout.SOUTH
		p_south = new JPanel(new GridLayout());	
		p_south.setBackground(new Color(255, 158, 60));		
		c.add(p_south,BorderLayout.SOUTH);
		
		//p_north title--------------------------------------------		
		JLabel title = new JLabel("Dongguk Coffee DataBase");		
		
		title.setBounds(100, 25, 500, 50); //위치
		title.setForeground(Color.white); //글자 색
		title.setFont(new Font("Dailog", Font.BOLD, 30)); //글자 폰트, 크기
		p_north.add(title);
		
		//JLabel-------------------------------------------------

		JLabel company_label = new JLabel("본사 user");
		company_label.setBounds(105, 450, 300, 50); //위치
		company_label.setFont(new Font("Dailog", Font.BOLD, 20)); //글자 폰트, 크기
		p_background.add(company_label);
		
		
		JLabel store_label = new JLabel("가맹점 user");
		store_label.setBounds(395, 450, 300, 50); //위치
		store_label.setFont(new Font("Dailog", Font.BOLD, 20)); //글자 폰트, 크기
		p_background.add(store_label);
		
		
		//Image & Button---------------------------------------------------
		
		ImageIcon company_icon = new ImageIcon("src/images/company.png");
		ImageIcon store_icon = new ImageIcon("src/images/store.png");
		
   /* jar 실행파일 새성용  
   ImageIcon company_icon = new ImageIcon(getClass().getClassLoader().getResource("company3.png"));
		ImageIcon store_icon = new ImageIcon(getClass().getClassLoader().getResource("store3.png"));
   */
		
		JButton company_btn = new JButton(company_icon);
		JButton store_btn = new JButton(store_icon);
		
		company_btn.setBorder(BorderFactory.createLineBorder(Color.white));
		company_btn.setBounds(0, 260, 300, 200);
		company_btn.setBackground(Color.white);
		p_background.add(company_btn);
		
		
		store_btn.setBorder(BorderFactory.createLineBorder(Color.white));
		store_btn.setBounds(300, 260, 300, 200);
		store_btn.setBackground(Color.white);
		p_background.add(store_btn );
		
		
		btn_listener(company_btn,store_btn);
	}

	private void btn_listener(JButton company_btn,JButton store_btn) {
		
		Company c = new Company();
		Store s = new Store();
		
		c.setLocation(550, 200);
		company_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.setVisible(true); 
				setVisible(false);
			}
		});
		
		store_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.setVisible(true);
				setVisible(false);
			}
		});
	}

}