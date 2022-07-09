
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
			
			System.out.println("���� ����");

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
			
			System.out.println("���� ����");

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
	
		//�����̳� ----------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner---------------------------------------------------
		JPanel p_background = new JPanel(); //background �г�
		p_background.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_background.setBackground(Color.white); //����
		p_background.setBounds(0, 0, 500, 400);  //ũ��
		c.add(p_background); //�����̳ʿ� background �г� ����
		
		
		JPanel p_north = new JPanel(); //��� �г�
		p_north.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_north.setBackground(new Color(31, 115, 48)); //����
		p_north.setBounds(0, 0, 500, 60); //ũ��
		p_background.add(p_north); //background�� ��� �г� ����
		
		
		
		//JButton--------------------------------------------------
		JButton ok_btn = new JButton("Ok"); //��ư ����
		ok_btn.setBounds(0, 315, 250, 50); //��ư ��ġ
		ok_btn.setBackground(new Color(31, 115, 48)); //��� ��
		ok_btn.setForeground(Color.white); // ���� ��
		ok_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư �׵θ� ��
		ok_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // ���� ��Ʈ �� ũ��
		p_background.add(ok_btn); //��׶��� �гο� ��ư ����
		
		JButton cancel_btn = new JButton("Cancel");//��ư ����
		cancel_btn.setBounds(250, 315, 250, 50); //��ư ��ġ
		cancel_btn.setBackground(new Color(31, 115, 48)); //��� ��
		cancel_btn.setForeground(Color.white); // ���� ��
		cancel_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư �׵θ� ��
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // ���� ��Ʈ �� ũ��
		p_background.add(cancel_btn); //��׶��� �гο� ��ư ����
		
		
		JButton insert_btn = new JButton("����");
		insert_btn.setBounds(330, 150, 60, 30);
		insert_btn.setBackground(new Color(31, 115, 48));
		insert_btn.setForeground(Color.white); // ���� ��
		insert_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(insert_btn);
		
		JButton delete_btn = new JButton("����");
		delete_btn.setBounds(410, 150, 60, 30);
		delete_btn.setBackground(new Color(31, 115, 48));
		delete_btn.setForeground(Color.white); // ���� ��
		delete_btn.setFont(new Font("Dialog", Font.BOLD, 13));
		p_background.add(delete_btn);
		
		//JLabel----------------------------------------------------		
		JLabel main_title = new JLabel("Data Insert & Delete"); 
		main_title.setBounds(10, 5, 400, 50); //��ġ
		main_title.setForeground(Color.white); //���� ��
		main_title.setFont(new Font("Dailog", Font.BOLD, 30)); //���� ��Ʈ, ũ��
		p_north.add(main_title); //�гο� �� ����
			
		
		JLabel sql = new JLabel("[����/����] sql ������ �ۼ� ��, [����/����] ��ư�� �����ÿ�.");
		sql.setBounds(10, 110, 500, 30);
		p_background.add(sql);
		sql.setFont(new Font("Dailog", Font.BOLD, 15));
		
		
		if(str.equals("������ ��Ȳ")) {
			JLabel table_name = new JLabel("�����̼� �� >> ������");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}else if(str.equals("������ ���� ��Ȳ")) {
			JLabel table_name = new JLabel("�����̼� �� >> ����");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}else if(str.equals("��ǰ ������ü ���")) {
			JLabel table_name = new JLabel("�����̼� �� >> ������ü");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}else if(str.equals("������ ���� �Ŵ��� ���")) {
			JLabel table_name = new JLabel("�����̼� �� >> ����Ŵ���");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
			
		}else if(str.equals("�Ŵ��� ��� ���� ���")) {
			JLabel table_name = new JLabel("�����̼� �� >> �Ŵ���_���_����");
			table_name.setBounds(10, 80, 500, 30);
			table_name.setFont(new Font("Dailog", Font.BOLD, 20));
			p_background.add(table_name);
			
		}
	
		
		Scanner sc = new Scanner(System.in);
		
		tf.setBounds(10,190, 460, 50);
		tf.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		p_background.add(tf);
		
		
		//�̺�Ʈ------------------------------------------------------
		
		insert_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					System.out.println("sql ������ ����");
					String sql = tf.getText();
					update.inset_mysql(sql);


			}//public
		});
		
		
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				
				System.out.println("sql ������ ����");
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