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
		//�����̳� ------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner------------------------------------------------
		p_background = new JPanel();
		p_background.setLayout(null);
		p_background.setBackground(Color.white);
		p_background.setBounds(0, 0, 410, 600);
		c.add(p_background);
		
		
		//��� ��-------------------------------------------------
		p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(31, 115, 48));
		p_north.setBounds(0, 0, 410, 80);
		p_background.add(p_north);
		

		//JLabel-------------------------------------------------
		
		JLabel title_label = new JLabel("������ DataBase");
		title_label.setBounds(10, 15, 600, 50); //��ġ
		title_label.setForeground(Color.white); //���� ��
		title_label.setFont(new Font("Dailog", Font.BOLD, 35)); //���� ��Ʈ, ũ��
		p_north.add(title_label);
		
		JLabel select_stores = new JLabel("> ���� & ��ȸ ����");
		select_stores.setBounds(30, 95, 300, 30); //��ġ
		select_stores.setFont(new Font("Dailog", Font.BOLD, 15)); //���� ��Ʈ, ũ��
		p_background.add(select_stores);
		
		
		//Image---------------------------------------------------
	
	
		//JButton-------------------------------------------------
		
		JButton select_btn = new JButton("����");
		select_btn.setBounds(150, 130, 60, 30);
		select_btn.setBackground(new Color(31, 115, 48));
		select_btn.setForeground(Color.white); // ���� ��
		select_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(select_btn);
				
		JButton show_btn = new JButton("��ȸ");
		show_btn.setBounds(220, 180, 60, 30);
		show_btn.setBackground(new Color(31, 115, 48));
		show_btn.setForeground(Color.white); // ���� ��
		show_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(show_btn);
		
		
		JButton back_btn = new JButton("back");
		back_btn.setBounds(305, 25, 60, 30);
		back_btn.setBackground(new Color(31, 115, 48));
		back_btn.setForeground(Color.white); // ���� ��
		back_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		p_north.add(back_btn);
		
				
				
		//JComboBox-------------------------------------------------
				
		comboBox = new JComboBox<String>();
		comboBox.addItem("�����뺻��");
		comboBox.addItem("�湫����");
		comboBox.addItem("�����");
		comboBox.addItem("������");
		comboBox.addItem("������");
		comboBox.addItem("������");
		comboBox.addItem("��ȭ����");
		comboBox.addItem("������");
				
		comboBox.setBounds(30, 130, 100, 30);
		p_background.add(comboBox);
			
		
		comboBox2 = new JComboBox<String>();
		comboBox2.addItem("������ü ��Ȳ");
		comboBox2.addItem("���� ���� ���� ��ǰ ��Ȳ");
		comboBox2.addItem("��ǰ ���");
		comboBox2.addItem("��� ���� ���� �Ŵ���");
		
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
		
		
		//���� select ��ư �̺�Ʈ
		select_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				list.removeAll();
				
				if(comboBox.getSelectedItem().toString().equals("�����뺻��")) {
					store_name ="�����뺻��";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("�湫����")) {
					store_name ="�湫����";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("�����")) {
					store_name ="�����";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("������")) {
					store_name ="������";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("������")) {
					store_name ="������";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("������")) {
					store_name ="������";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("��ȭ����")) {
					store_name ="��ȭ����";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
					
				}else if(comboBox.getSelectedItem().toString().equals("������")) {
					store_name ="������";
					
					//check
					list.add(store_name);
					System.out.println("select : "+store_name);
				}//if
			}//void
		});
		
		
		show_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list.removeAll();
				
				
				if(comboBox2.getSelectedItem().toString().equals("������ü ��Ȳ")) {
					try {
					
						
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select ������ü��, ������ǰ��, ����� from ������ü");
						
						String col = "[ ������ü��  >> " + "������ǰ��  >>  " + "����� ]";
						list.add(col);
						list.add(" ");
				
						while(result.next()) {
							String manufacturer =  result.getNString("������ü��");
							String produt_name = result.getNString("������ǰ��");
							String owner = result.getNString("�����");
					
							
							list.add("");
							String print =  manufacturer+ "  >>  " + produt_name +  "  >>  " + owner;
						
							list.add(print);
						
						}
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					
					System.out.println("��ǰ ������ü ��Ȳ");
				
//****************************************************************************************************************************				
				}else if(comboBox2.getSelectedItem().toString().equals("���� ���� ���� ��ǰ ��Ȳ")){

							try {
								Connection connection = null;
								connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
								java.sql.Statement statement = connection.createStatement();
							
							
								ResultSet result = statement.executeQuery("select ���ֹ�ȣ, ��ǰ����, ���� from ���� where ���� = '" + store_name + "'");
								
								list.add("< "+store_name + ">");
								list.add(" ");
								String col = "[ ���ֹ�ȣ" + "  >>  " + "��ǰ����" + "  >>  " + "���� ]";
								list.add(col);
								list.add(" ");
								
								while(result.next()) {	
									int order_num =  result.getInt("���ֹ�ȣ");;
									String produt_kind = result.getNString("��ǰ����");
									String store = result.getNString("����");
							
									
									list.add("");
									String print =  order_num+ "  >>  " + produt_kind +  "  >>  " + store;
								
									list.add(print);
								
								}//while
							
							}catch(SQLException sqle) {
								System.out.println("Exception : " + sqle.getMessage());
								System.out.println("sql State : " + sqle.getSQLState());
							}//try
							
							//check
							//list.add("���� ��Ȳ");
							System.out.println( store_name +" ���� ��Ȳ");
					
				
				
//****************************************************************************************************************************					
				}else if(comboBox2.getSelectedItem().toString().equals("��ǰ ���")){
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
					
					
						ResultSet result = null;
						
					
						result = statement.executeQuery("select ��ǰ����, ������ü��, ��ǰ��, ��� from ��ǰ");
						
						String col = "[ ��ǰ����" + "  >>  " + "������ü��" + "  >>  " + "��ǰ�� " + "  >>  " + "��� ]";
						list.add(col);
						list.add(" ");
						
						while(result.next()) {	
							
							String produt_kind = result.getNString("��ǰ����");
							String manufacturer = result.getNString("������ü��");
							String product_name = result.getNString("��ǰ��");
							int stock = result.getInt("���");
					
							
							list.add("");
							String print =  produt_kind+ "  >>  " + manufacturer +  "  >>  " + product_name +  "  >>  "+ stock;
						
							list.add(print);
						
						}//while
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					//list.add("��ǰ ������ü ���");
					System.out.println("��ǰ ������ü ���");			
					
//****************************************************************************************************************************
				}else if(comboBox2.getSelectedItem().toString().equals("��� ���� ���� �Ŵ���")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
					
					
						ResultSet result = statement.executeQuery("select  ����Ŵ���.�����, �Ŵ���_���_����.�����ȣ from  ����Ŵ��� inner join �Ŵ���_���_���� where �Ŵ���_���_����.������� = '" + store_name + 
								"' AND ����Ŵ���.�����ȣ = (select �����ȣ from �Ŵ���_���_���� where �Ŵ���_���_����.������� = '" + store_name + "')");
						
						list.add("< "+store_name + " ��� ���� ���� �Ŵ��� >");
						list.add(" ");
						String col = "[ �����ȣ" + "  >>  " + "����� ]";
						list.add(col);
						list.add(" ");
						while(result.next()) {
							int num =  result.getInt("�����ȣ");
							String name = result.getNString("�����");
							

							list.add("");
							String print =  num + "  >>  " + name;
						
							list.add(print);
						
						}
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
				    //	list.add("��� ���� ���� �Ŵ���");
					System.out.println( store_name + " ��� ���� ���� �Ŵ���");
				}//if				
			}//void
		});
		
		p_background.add(list);
	}//btn_listener()
}//class