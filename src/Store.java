import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;
import java.util.Scanner;

//store************************************************
class Store extends JFrame {
	
	private JPanel p_background; 
	private JPanel p_north;
	List list = new List();
	JComboBox<String> comboBox = new JComboBox<String>();
	JComboBox<String> comboBox2 = new JComboBox<String>();
	private static String store_name;
	
	public Store() {
		set_layout();
		setSize(410, 600);
		setVisible(false);
	}//store()
	
	public void set_layout() {
		setTitle("Stores DataBase System");
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
		
		JLabel title_label = new JLabel("가맹점 DataBase");
		title_label.setBounds(10, 15, 600, 50); //위치
		title_label.setForeground(Color.white); //글자 색
		title_label.setFont(new Font("Dailog", Font.BOLD, 35)); //글자 폰트, 크기
		p_north.add(title_label);
		
		JLabel select_stores = new JLabel("> 지점 & 조회 설정");
		select_stores.setBounds(30, 95, 300, 30); //위치
		select_stores.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
		p_background.add(select_stores);
		
		
		//Image---------------------------------------------------
	
	
		//JButton-------------------------------------------------
		
		JButton select_btn = new JButton("선택");
		select_btn.setBounds(150, 130, 60, 30);
		select_btn.setBackground(new Color(31, 115, 48));
		select_btn.setForeground(Color.white); // 글자 색
		select_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(select_btn);
				
		JButton show_btn = new JButton("조회");
		show_btn.setBounds(220, 180, 60, 30);
		show_btn.setBackground(new Color(31, 115, 48));
		show_btn.setForeground(Color.white); // 글자 색
		show_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(show_btn);
		
		
		JButton back_btn = new JButton("back");
		back_btn.setBounds(305, 25, 60, 30);
		back_btn.setBackground(new Color(31, 115, 48));
		back_btn.setForeground(Color.white); // 글자 색
		back_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		p_north.add(back_btn);
		
				
				
		//JComboBox-------------------------------------------------
				
		comboBox = new JComboBox<String>();
		comboBox.addItem("동국대본점");
		comboBox.addItem("충무로점");
		comboBox.addItem("약수점");
		comboBox.addItem("강남점");
		comboBox.addItem("역삼점");
		comboBox.addItem("선릉점");
		comboBox.addItem("광화문점");
		comboBox.addItem("종로점");
				
		comboBox.setBounds(30, 130, 100, 30);
		p_background.add(comboBox);
			
		
		comboBox2 = new JComboBox<String>();
		comboBox2.addItem("제조업체 현황");
		comboBox2.addItem("본사 지정 발주 상품 현황");
		comboBox2.addItem("상품 목록");
		comboBox2.addItem("담당 지점 관리 매니저");
		
		comboBox2.setBounds(30, 180, 170, 30);
		p_background.add(comboBox2);
		
		btn_listener(select_btn, show_btn, back_btn);
		
	}//set_layout()
	
	
	public void btn_listener(JButton select_btn, JButton show_btn, JButton back_btn ) {
		
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_screen m = new main_screen();
				setVisible(false);
				m.setVisible(true);
							}
		});
		
		list.setBounds(30, 235, 350, 300);
		
		
		//지점 select 버튼 이벤트
		select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				list.removeAll();
				
				if(comboBox.getSelectedItem().toString().equals("동국대본점")) {
					store_name ="동국대본점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("충무로점")) {
					store_name ="충무로점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("약수점")) {
					store_name ="약수점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("강남점")) {
					store_name ="강남점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("역삼점")) {
					store_name ="역삼점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("선릉점")) {
					store_name ="선릉점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("광화문점")) {
					store_name ="광화문점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("종로점")) {
					store_name ="종로점";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
				}//if
			}//void
		});
		
		
		show_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list.removeAll();
				
				
				if(comboBox2.getSelectedItem().toString().equals("제조업체 현황")) {
					try {
					
						
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select 제조업체명, 제조상품명, 담당자 from 제조업체");
						
						String col = "[ 제조업체명  >> " + "제조상품명  >>  " + "담당자 ]";
						list.add(col);
						list.add(" ");
				
						while(result.next()) {
							String manufacturer =  result.getNString("제조업체명");
							String produt_name = result.getNString("제조상품명");
							String owner = result.getNString("담당자");
					
							
							list.add("");
							String print =  manufacturer+ "  >>  " + produt_name +  "  >>  " + owner;
						
							list.add(print);
						
						}
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					
					System.out.println("상품 제조업체 현황");
				
//****************************************************************************************************************************				
				}else if(comboBox2.getSelectedItem().toString().equals("본사 지정 발주 상품 현황")){

							try {
								Connection connection = null;
								connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
								java.sql.Statement statement = connection.createStatement();
							
							
								ResultSet result = statement.executeQuery("select 발주번호, 상품종류, 지점 from 발주 where 지점 = '" + store_name + "'");
								
								list.add("< "+store_name + ">");
								list.add(" ");
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
							//list.add("발주 현황");
							System.out.println( store_name +" 발주 현황");
					
				
				
//****************************************************************************************************************************					
				}else if(comboBox2.getSelectedItem().toString().equals("상품 목록")){
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
					
					
						ResultSet result = null;
						
					
						result = statement.executeQuery("select 상품종류, 제조업체명, 상품명, 재고량 from 상품");
						
						String col = "[ 상품종류" + "  >>  " + "제조업체명" + "  >>  " + "상품명 " + "  >>  " + "재고량 ]";
						list.add(col);
						list.add(" ");
						
						while(result.next()) {	
							
							String produt_kind = result.getNString("상품종류");
							String manufacturer = result.getNString("제조업체명");
							String product_name = result.getNString("상품명");
							int stock = result.getInt("재고량");
					
							
							list.add("");
							String print =  produt_kind+ "  >>  " + manufacturer +  "  >>  " + product_name +  "  >>  "+ stock;
						
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
				}else if(comboBox2.getSelectedItem().toString().equals("담당 지점 관리 매니저")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
					
					
						ResultSet result = statement.executeQuery("select  본사매니저.사원명, 매니저_담당_지점.사원번호 from  본사매니저 inner join 매니저_담당_지점 where 매니저_담당_지점.담당지점 = '" + store_name + 
								"' AND 본사매니저.사원번호 = (select 사원번호 from 매니저_담당_지점 where 매니저_담당_지점.담당지점 = '" + store_name + "')");
						
						list.add("< "+store_name + " 담당 지점 관리 매니저 >");
						list.add(" ");
						String col = "[ 사원번호" + "  >>  " + "사원명 ]";
						list.add(col);
						list.add(" ");
						while(result.next()) {
							int num =  result.getInt("사원번호");
							String name = result.getNString("사원명");
							

							list.add("");
							String print =  num + "  >>  " + name;
						
							list.add(print);
						
						}
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
				    //	list.add("담당 지점 관리 매니저");
					System.out.println( store_name + " 담당 지점 관리 매니저");
				}//if				
			}//void
		});
		
		p_background.add(list);
	}//btn_listener()
}//class