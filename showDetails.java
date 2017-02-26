
import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class showDetails implements ActionListener{
	Scanner in = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String pass = "Password";
	String driver = "com.mysql.jdbc.Driver";
	int idm;
	String fname;
	String sect;
	String rolln;
	String dept;
	JFrame fs;
	private JLabel jl6;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private TextField area1;
	private TextField area2;
	private TextField area3;
	private JButton btn1;
	private JLabel jl4;
	private JLabel jl5;
	private TextField area4;
	private TextField area5;
	private JLabel jl7;
	public showDetails(int a)
	{
		fs = new JFrame("student details");
		
		jl7 = new JLabel("-:Student Details:-",JLabel.CENTER);
		jl7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		jl7.setBounds(100,10,250,30);
		fs.add(jl7);
		
		jl1 = new JLabel("Reg. no.:",JLabel.LEFT);
		jl1.setBounds(40,80,60,30);
		fs.add(jl1);
		area1 = new TextField(30);
		area1.setEditable(false);
		area1.setBounds(100,80,300,30);
		fs.add(area1);
		jl2 = new JLabel("name:",JLabel.LEFT);
		jl2.setBounds(40,120,60,30);
		fs.add(jl2);
		area2 = new TextField(30);
		area2.setEditable(false);
		area2.setBounds(100,120,300,30);
		fs.add(area2);
		jl4 = new JLabel("Roll no.:",JLabel.LEFT);
		jl4.setBounds(40,160,60,30);
		fs.add(jl4);
		area4 = new TextField(30);
		area4.setEditable(false);
		area4.setBounds(100,160,300,30);
		fs.add(area4);
		jl3 = new JLabel("Section:",JLabel.LEFT);
		jl3.setBounds(40,200,60,30);
		fs.add(jl3);
		area3 = new TextField(30);
		area3.setEditable(false);
		area3.setBounds(100,200,300,30);
		fs.add(area3);
		jl5 = new JLabel("Dept:",JLabel.LEFT);
		jl5.setBounds(40,240,60,30);
		fs.add(jl5);
		area5 = new TextField(25);
		area5.setBounds(100,240,300,30);
		area5.setEditable(false);
		fs.add(area5);
		btn1 = new JButton("back");
		btn1.setBounds(90,310,80,30);
		fs.add(btn1);
		
		
		btn1.addActionListener(this);
		
		fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fs.setLayout(null);
		fs.setVisible(true);
		fs.setSize(450,400);
		fs.setResizable(false);
		
		try{
			Class.forName(driver);
			Connection mycon = DriverManager.getConnection(url, user, pass);
			String sql = "select reg, name, section, roll, dept from employee where reg = "+a;
			Statement stmt = mycon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				idm = rs.getInt("reg");
				fname = rs.getString("name");
				sect = rs.getString("section");
				rolln = rs.getString("roll");
				dept = rs.getString("dept");
			}
			}
		catch(Exception exp){
			exp.printStackTrace();
		}
		area1.setText(Integer.toString(idm));
		area2.setText(fname);
		area3.setText(rolln);
		area4.setText(sect);
		area5.setText(dept);
	}
	public void actionPerformed(ActionEvent e){

		
		if(e.getSource()==btn1)
		{
			search obj = new search();
			fs.dispose();
	}
	}
}
