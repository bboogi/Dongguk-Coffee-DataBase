import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.util.Scanner;

//company**********************************************
class Company extends JFrame{
	
	private JPanel p_background; 
	private JPanel p_north;
	List list = new List();
	

	
	JComboBox<String> comboBox = new JComboBox<String>();
	
	public Company() {
		set_layout();
		setSize(410, 600);
		setVisible(false);
	}//Company()
	
	public void set_layout() {
		setTitle("Company DataBase System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫으면 프로그램 종료
		//컨테이너 ------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner------------------------------------------------
		p_background = new JPanel();
		p_background.setLayout(null);
		p_background.setBackground(Color.white);
		p_background.setBounds(0, 0, 410, 600);
		c.add(p_background);
		
		//상단 바-------------------------------------------------
		p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(31, 115, 48));
		p_north.setBounds(0, 0, 410, 80);
		p_background.add(p_north);
		
		
		//JLabel-------------------------------------------------
		
		JLabel title_label = new JLabel("본사 DataBase");
		title_label.setBounds(10, 15, 600, 50); //위치
		title_label.setForeground(Color.white); //글자 색
		title_label.setFont(new Font("Dailog", Font.BOLD, 35)); //글자 폰트, 크기
		p_north.add(title_label);
		
		JLabel select_stores = new JLabel("> 조회 설정");
		select_stores.setBounds(30, 95, 300, 35); //위치
		select_stores.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
		p_background.add(select_stores);
		
		
		//JButton-------------------------------------------------
		
		JButton show_btn = new JButton("조회");
		show_btn.setBounds(220, 130, 60, 30);
		show_btn.setBackground(new Color(31, 115, 48));
		show_btn.setForeground(Color.white); // 글자 색
		show_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(show_btn);
		
		JButton update_btn = new JButton("갱신"); 
		update_btn.setBounds(300, 130, 60, 30);
		update_btn.setBackground(new Color(31, 115, 48));
		update_btn.setForeground(Color.white); // 글자 색
		update_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(update_btn);
		
		
		JButton back_btn = new JButton("back");
		back_btn.setBounds(305, 25, 60, 30);
		back_btn.setBackground(new Color(31, 115, 48));
		back_btn.setForeground(Color.white); // 글자 색
		back_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		p_north.add(back_btn);
		
		//JComboBox-------------------------------------------------
		
	
		comboBox.addItem("가맹점 현황");
		comboBox.addItem("가맹점 발주 현황");
		comboBox.addItem("상품 제조업체 목록");
		comboBox.addItem("가맹점 관리 매니저 목록");
		comboBox.addItem("매니저 담당 지점 목록");
		comboBox.setBounds(30, 130, 170, 30);
		p_background.add(comboBox);
	
		btn_listener(show_btn, update_btn, back_btn);
		
		 
		 
		//JTable-------------------------------------------------
	
		 
		
	}//set_layout()
	
	
	public void btn_listener(JButton show_btn, JButton update_btn, JButton back_btn) {
		
		
		
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_screen m = new main_screen();
				setVisible(false);
				m.setVisible(true);
							}
		});
		
		
		
		
		
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str =comboBox.getSelectedItem().toString();
				update u = new update(str);
				u.setVisible(true);
				System.out.println(str);
							}
		});
		
		
		
		
		
		list.setBounds(25, 200, 350, 300);
		
		
		
		
		
		show_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list.removeAll();
				
				
				if(comboBox.getSelectedItem().toString().equals("가맹점 현황")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select 지점, 본사매니저, 판매수익, 아르바이트_고용_수 from 가맹점");
						
					
						String col = "[ 지점" + "  >>  " + "본사매니저" + "  >>  " + "판매수익" +  "  >>  " + "아르바이트_고용_수 ]";
						list.add(col);
						list.add(" ");
						
						while(result.next()) {	
							String store =  result.getNString("지점");;
							int manager = result.getInt("본사매니저");
							int revenue = result.getInt("판매수익");
							int employment = result.getInt("아르바이트_고용_수");
					
							
							list.add("");
							String print =  store+ "  >>  " + manager +  "  >>  " + revenue +  "  >>  " + employment;
						
							list.add(print);
						
						}//while
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					//list.add("가맹점 현황");
					System.out.println("가맹점 현황");
				
//****************************************************************************************************************************				
				}else if(comboBox.getSelectedItem().toString().equals("가맹점 발주 현황")){
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select 발주번호, 상품종류, 지점 from 발주");
						
						String col = "[ 발주번호" + "  >>  " + "상품종류" + "  >>  " + "지점 ]";
						list.add(col);
						list.add(" ");
						
						while(result.next()) {	
							int order_num =  result.getInt("발주번호");;
							String produt_kind = result.getNString("상품종류");
							String store = result.getNString("지점");
					
							
							list.add("");
							String print =  order_num+ "  >>  " + produt_kind +  "  >>  " + store;
						
							list.add(print);
						
						}//while
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					//list.add("가맹점 발주 현황");
					System.out.println("가맹점 발주 현황");
//****************************************************************************************************************************					
				}else if(comboBox.getSelectedItem().toString().equals("상품 제조업체 목록")){
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select 제조업체명, 제조상품명, 담당자 from 제조업체");
						
						String col = "[ 제조업체명" + "  >>  " + "제조상품명" + "  >>  " + "담당자 ]";
						list.add(col);
						list.add(" ");
						
						while(result.next()) {
							
							String manufacturer =  result.getNString("제조업체명");;
							String produt_name = result.getNString("제조상품명");
							String owner = result.getNString("담당자");
					
					
							
							list.add("");
							String print =  manufacturer+ "  >>  " + produt_name +  "  >>  " + owner;
						
							list.add(print);
						
						
						}//while

						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try

					//check
					//list.add("상품 제조업체 목록");
					System.out.println("상품 제조업체 목록");
//****************************************************************************************************************************
				}else if(comboBox.getSelectedItem().toString().equals("가맹점 관리 매니저 목록")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery("select 사원번호, 사원명, 직급 from 본사매니저");
						
					

						String col = "[ 사원번호" + "  >>  " + "사원명" +"  >>  " + "직급 ]";
						list.add(col);
						list.add(" ");
				
						while(result.next()) {
							
							int num =  result.getInt("사원번호");
							String name = result.getNString("사원명");
							String level = result.getNString("직급");
					
							
							list.add("");
							String print = Integer.toString(num) + "  >>  " + name + "  >>  " + level;
						
							list.add(print);
						
						
						}//while

						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					//list.add("가맹점 관리 매니저 목록");
					System.out.println("가맹점 관리 매니저 목록");
					
//****************************************************************************************************************************
				}else if(comboBox.getSelectedItem().toString().equals("매니저 담당 지점 목록")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery("select 매니저_담당_지점.사원번호, 매니저_담당_지점.담당지점, 매니저_담당_지점.담당_지점_판매수익, 본사매니저.사원명 from 매니저_담당_지점 inner join 본사매니저 "
								+ "									where 본사매니저.사원번호 = 매니저_담당_지점.사원번호 ");
						
						String col = "[ 사원번호" +  "  >>  " + "사원명"+"  >>  " + "담당지점" + "  >>  " + "담당_지점_판매수익 ]";
						list.add(col);
						list.add(" ");
				
						while(result.next()) {
							
							int num =  result.getInt("사원번호");
							String name = result.getNString("사원명");
							String store = result.getNString("담당지점");
							int revenue =result.getInt("담당_지점_판매수익");
					
							
							list.add("");
							String print = Integer.toString(num) +  "  >>  " + name + "  >>  " + store +  "  >>  " + revenue;
						
							list.add(print);
						
						
						}//while

						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					

					//check
					//list.add("매니저 담당 지점 목록");
					System.out.println("매니저 담당 지점 목록");
				}//if				
			}//void
		});
		
		p_background.add(list);
	}//btn_listener()
}//class
