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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â ������ ���α׷� ����
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
		
		JLabel title_label = new JLabel("���� DataBase");
		title_label.setBounds(10, 15, 600, 50); //��ġ
		title_label.setForeground(Color.white); //���� ��
		title_label.setFont(new Font("Dailog", Font.BOLD, 35)); //���� ��Ʈ, ũ��
		p_north.add(title_label);
		
		JLabel select_stores = new JLabel("> ��ȸ ����");
		select_stores.setBounds(30, 95, 300, 35); //��ġ
		select_stores.setFont(new Font("Dailog", Font.BOLD, 15)); //���� ��Ʈ, ũ��
		p_background.add(select_stores);
		
		
		//JButton-------------------------------------------------
		
		JButton show_btn = new JButton("��ȸ");
		show_btn.setBounds(220, 130, 60, 30);
		show_btn.setBackground(new Color(31, 115, 48));
		show_btn.setForeground(Color.white); // ���� ��
		show_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(show_btn);
		
		JButton update_btn = new JButton("����"); 
		update_btn.setBounds(300, 130, 60, 30);
		update_btn.setBackground(new Color(31, 115, 48));
		update_btn.setForeground(Color.white); // ���� ��
		update_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(update_btn);
		
		
		JButton back_btn = new JButton("back");
		back_btn.setBounds(305, 25, 60, 30);
		back_btn.setBackground(new Color(31, 115, 48));
		back_btn.setForeground(Color.white); // ���� ��
		back_btn.setFont(new Font("Dialog", Font.BOLD, 12));
		p_north.add(back_btn);
		
		//JComboBox-------------------------------------------------
		
	
		comboBox.addItem("������ ��Ȳ");
		comboBox.addItem("������ ���� ��Ȳ");
		comboBox.addItem("��ǰ ������ü ���");
		comboBox.addItem("������ ���� �Ŵ��� ���");
		comboBox.addItem("�Ŵ��� ��� ���� ���");
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
				
				
				if(comboBox.getSelectedItem().toString().equals("������ ��Ȳ")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select ����, ����Ŵ���, �Ǹż���, �Ƹ�����Ʈ_���_�� from ������");
						
					
						String col = "[ ����" + "  >>  " + "����Ŵ���" + "  >>  " + "�Ǹż���" +  "  >>  " + "�Ƹ�����Ʈ_���_�� ]";
						list.add(col);
						list.add(" ");
						
						while(result.next()) {	
							String store =  result.getNString("����");;
							int manager = result.getInt("����Ŵ���");
							int revenue = result.getInt("�Ǹż���");
							int employment = result.getInt("�Ƹ�����Ʈ_���_��");
					
							
							list.add("");
							String print =  store+ "  >>  " + manager +  "  >>  " + revenue +  "  >>  " + employment;
						
							list.add(print);
						
						}//while
						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					//list.add("������ ��Ȳ");
					System.out.println("������ ��Ȳ");
				
//****************************************************************************************************************************				
				}else if(comboBox.getSelectedItem().toString().equals("������ ���� ��Ȳ")){
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select ���ֹ�ȣ, ��ǰ����, ���� from ����");
						
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
					//list.add("������ ���� ��Ȳ");
					System.out.println("������ ���� ��Ȳ");
//****************************************************************************************************************************					
				}else if(comboBox.getSelectedItem().toString().equals("��ǰ ������ü ���")){
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						
						ResultSet result = statement.executeQuery("select ������ü��, ������ǰ��, ����� from ������ü");
						
						String col = "[ ������ü��" + "  >>  " + "������ǰ��" + "  >>  " + "����� ]";
						list.add(col);
						list.add(" ");
						
						while(result.next()) {
							
							String manufacturer =  result.getNString("������ü��");;
							String produt_name = result.getNString("������ǰ��");
							String owner = result.getNString("�����");
					
					
							
							list.add("");
							String print =  manufacturer+ "  >>  " + produt_name +  "  >>  " + owner;
						
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
				}else if(comboBox.getSelectedItem().toString().equals("������ ���� �Ŵ��� ���")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery("select �����ȣ, �����, ���� from ����Ŵ���");
						
					

						String col = "[ �����ȣ" + "  >>  " + "�����" +"  >>  " + "���� ]";
						list.add(col);
						list.add(" ");
				
						while(result.next()) {
							
							int num =  result.getInt("�����ȣ");
							String name = result.getNString("�����");
							String level = result.getNString("����");
					
							
							list.add("");
							String print = Integer.toString(num) + "  >>  " + name + "  >>  " + level;
						
							list.add(print);
						
						
						}//while

						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					
					//check
					//list.add("������ ���� �Ŵ��� ���");
					System.out.println("������ ���� �Ŵ��� ���");
					
//****************************************************************************************************************************
				}else if(comboBox.getSelectedItem().toString().equals("�Ŵ��� ��� ���� ���")) {
					try {
						Connection connection = null;
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeedb?serverTimezone=Asia/Seoul&useSSL=false", "root", "deming4585!");
						java.sql.Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery("select �Ŵ���_���_����.�����ȣ, �Ŵ���_���_����.�������, �Ŵ���_���_����.���_����_�Ǹż���, ����Ŵ���.����� from �Ŵ���_���_���� inner join ����Ŵ��� "
								+ "									where ����Ŵ���.�����ȣ = �Ŵ���_���_����.�����ȣ ");
						
						String col = "[ �����ȣ" +  "  >>  " + "�����"+"  >>  " + "�������" + "  >>  " + "���_����_�Ǹż��� ]";
						list.add(col);
						list.add(" ");
				
						while(result.next()) {
							
							int num =  result.getInt("�����ȣ");
							String name = result.getNString("�����");
							String store = result.getNString("�������");
							int revenue =result.getInt("���_����_�Ǹż���");
					
							
							list.add("");
							String print = Integer.toString(num) +  "  >>  " + name + "  >>  " + store +  "  >>  " + revenue;
						
							list.add(print);
						
						
						}//while

						
					}catch(SQLException sqle) {
						System.out.println("Exception : " + sqle.getMessage());
						System.out.println("sql State : " + sqle.getSQLState());
					}//try
					

					//check
					//list.add("�Ŵ��� ��� ���� ���");
					System.out.println("�Ŵ��� ��� ���� ���");
				}//if				
			}//void
		});
		
		p_background.add(list);
	}//btn_listener()
}//class
