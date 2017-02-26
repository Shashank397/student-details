import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
public class search implements ActionListener{
	private JLabel jbl1;
	private JLabel jbl2;
	private JLabel jbl3;
	private TextField tf1;
	private JButton jbt1;
	private JButton jbt3;
	JFrame fd;
	
	
	public search()
	{
		fd = new JFrame("Search query");
		jbl1 = new JLabel("search by Register number:",JLabel.LEFT);
		jbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbl1.setBounds(30,10,250,30);
		fd.add(jbl1);
		tf1 = new TextField(30);
		tf1.setBounds(30,70,250,30);
		fd.add(tf1);
		jbt1 = new JButton("Search");
		jbt1.setBounds(30,120,100,30);
		fd.add(jbt1);
		jbl2 = new JLabel("search by name:",JLabel.LEFT);
		fd.add(jbl2);
		jbl3 = new JLabel("Searched query:",JLabel.LEFT);
		fd.add(jbl3);
	
		jbt3 = new JButton("back");
		jbt3.setBounds(180,120,100,30);
		fd.add(jbt3);
		fd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fd.setLayout(null);
		fd.setVisible(true);
		fd.setSize(350,300);
		fd.setResizable(true);
		
		jbt1.addActionListener(this);
		jbt3.addActionListener(this);
	}
		public void actionPerformed(ActionEvent e){
			String url = "jdbc:mysql://localhost:3306/demo";
			String user = "root";
			String pass = "Password";
			String driver = "com.mysql.jdbc.Driver";
			int idt;
			String rln;
			if(e.getSource()==jbt1)
			{
				idt = Integer.parseInt(tf1.getText());
				showDetails obj = new showDetails(idt);
			}
			
			else
			{
				initial obj = new initial();
				fd.dispose();
			}
			}
	}
