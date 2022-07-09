
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.*;
import java.util.Scanner;

//updata_data******************************************
class Update_data {

	public void inset_mysql(String sql){

		try {
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
			Statement s = connection.createStatement();
			int count = s.executeUpdate(sql);
			
			System.out.println("삽입 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try
		
	}//insert
	
	
	
	public void delete_mysql(String sql){

		try {
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
			Statement s = connection.createStatement();
			int count = s.executeUpdate(sql);
			
			System.out.println("삭제 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//try
		
	}//insert
	
	
}//class



//update***********************************************
class update extends JDialog{
	

	JComboBox<String> comboBox = new JComboBox<String>();
	Update_data update = new Update_data();
	JTextField tf = new JTextField();
	
	
	public update(String str) {
		setTitle("Data update");
	
		//컨테이너 ----------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner---------------------------------------------------
		JPanel p_background = new JPanel(); //background 패널
		p_background.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_background.setBackground(Color.white); //색깔
		p_background.setBounds(0, 0, 500, 400);  //크기
		c.add(p_background); //컨테이너에 background 패널 부착
		
		
		JPanel p_north = new JPanel(); //상단 패널
		p_north.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_north.setBackground(new Color(31, 115, 48)); //색깔
		p_north.setBounds(0, 0, 500, 60); //크기
		p_background.add(p_north); //background에 상단 패널 부착
		
		
		
		//JButton--------------------------------------------------
		JButton ok_btn = new JButton("Ok"); //버튼 생성
		ok_btn.setBounds(0, 315, 250, 50); //버튼 위치
		ok_btn.setBackground(new Color(31, 115, 48)); //배경 색
		ok_btn.setForeground(Color.white); // 글자 색
		ok_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 테두리 색
		ok_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // 글자 폰트 및 크기
		p_background.add(ok_btn); //백그라운드 패널에 버튼 부착
		
		JButton cancel_btn = new JButton("Cancel");//버튼 생성
		cancel_btn.setBounds(250, 315, 250, 50); //버튼 위치
		cancel_btn.setBackground(new Color(31, 115, 48)); //배경 색
		cancel_btn.setForeground(Color.white); // 글자 색
		cancel_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 테두리 색
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // 글자 폰트 및 크기
		p_background.add(cancel_btn); //백그라운드 패널에 버튼 부착
		
		
		JButton insert_btn = new JButton("삽입");
		insert_btn.setBounds(330, 150, 60, 30);
		insert_btn.setBackground(new Color(31, 115, 48));
		insert_btn.setForeground(Color.white); // 글자 색
		insert_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(insert_btn);
		
		JButton delete_btn = new JButton("삭제");
		delete_btn.setBounds(410, 150, 60, 30);
		delete_btn.setBackground(new Color(31, 115, 48));
		delete_btn.setForeground(Color.white); // 글자 색
		delete_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(delete_btn);
		
		//JLabel----------------------------------------------------		
		JLabel main_title = new JLabel("Data Insert & Delete"); 
		main_title.setBounds(10, 5, 400, 50); //위치
		main_title.setForeground(Color.white); //글자 색
		main_title.setFont(new Font("Dailog", Font.BOLD, 30)); //글자 폰트, 크기
		p_north.add(main_title); //패널에 라벨 부착
			
		
		JLabel sql = new JLabel("[삽입/삭제] sql 쿼리문 작성 후, [삽입/삭제] 버튼을 누르시오.");
		sql.setBounds(10, 110, 500, 30);
		p_background.add(sql);
		sql.setFont(new Font("Dailog", Font.BOLD, 15));
		
		
		if(str.equals("가맹점 현황")) {
			JLabel table_name = new JLabel("릴레이션 명 >> 가맹점");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}else if(str.equals("가맹점 발주 현황")) {
			JLabel table_name = new JLabel("릴레이션 명 >> 발주");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}else if(str.equals("상품 제조업체 목록")) {
			JLabel table_name = new JLabel("릴레이션 명 >> 제조업체");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}else if(str.equals("가맹점 관리 매니저 목록")) {
			JLabel table_name = new JLabel("릴레이션 명 >> 본사매니저");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
			
		}else if(str.equals("매니저 담당 지점 목록")) {
			JLabel table_name = new JLabel("릴레이션 명 >> 매니저_담당_지점");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}
	
		
		Scanner sc = new Scanner(System.in);
		
		tf.setBounds(10,190, 460, 50);
		tf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		p_background.add(tf);
		
		
		//이벤트------------------------------------------------------
		
		insert_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					System.out.println("sql 쿼리문 삽입");
					String sql = tf.getText();
					update.inset_mysql(sql);


			}//public
		});
		
		
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				
				System.out.println("sql 쿼리문 삭제");
				String sql = tf.getText();
				update.delete_mysql(sql);
				
				

			}//public
		});
		
		
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
			}//public
		});
		
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
			}//public
		});
		
		setSize(500, 400);		
		sc.close();
	}

	
	
}