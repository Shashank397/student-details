import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class getInput implements ActionListener{
	Scanner in = new Scanner(System.in);
	JFrame f;
	private JLabel jl6;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private TextField area1;
	private TextField area2;
	private TextField area3;
	private JButton btn1;
	private JButton btn2;
	private JLabel jl4;
	private JLabel jl5;
	private TextField area4;
	private TextField area5;
	private JLabel jl7;
	public getInput()
	{
		f = new JFrame("student details");
		
		jl7 = new JLabel("-:Insert Student Details:-",JLabel.CENTER);
		jl7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		jl7.setBounds(100,10,250,30);
		f.add(jl7);
		
		jl1 = new JLabel("Reg. no.:",JLabel.LEFT);
		jl1.setBounds(40,80,60,30);
		f.add(jl1);
		area1 = new TextField(30);
		area1.setEditable(true);
		area1.setBounds(100,80,300,30);
		f.add(area1);
		jl2 = new JLabel("name:",JLabel.LEFT);
		jl2.setBounds(40,120,60,30);
		f.add(jl2);
		area2 = new TextField(30);
		area2.setEditable(true);
		area2.setBounds(100,120,300,30);
		f.add(area2);
		jl4 = new JLabel("Roll no.:",JLabel.LEFT);
		jl4.setBounds(40,160,60,30);
		f.add(jl4);
		area4 = new TextField(30);
		area4.setEditable(true);
		area4.setBounds(100,160,300,30);
		f.add(area4);
		jl3 = new JLabel("Section:",JLabel.LEFT);
		jl3.setBounds(40,200,60,30);
		f.add(jl3);
		area3 = new TextField(30);
		area3.setEditable(true);
		area3.setBounds(100,200,300,30);
		f.add(area3);
		jl5 = new JLabel("Dept:",JLabel.LEFT);
		jl5.setBounds(40,240,60,30);
		f.add(jl5);
		area5 = new TextField(25);
		area5.setBounds(100,240,300,30);
		area5.setEditable(true);
		f.add(area5);
		btn1 = new JButton("submit");
		btn1.setBounds(90,310,80,30);
		f.add(btn1);
		btn2 = new JButton("back");
		btn2.setBounds(220,310,80,30);
		f.add(btn2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(450,400);
		f.setResizable(false);
	}
	public void actionPerformed(ActionEvent event)
	{
		int i;
		String nam;
		String sec;
		String roll;
		String dept;
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "Password";
		String driver = "com.mysql.jdbc.Driver";
		if(event.getSource()==btn1)
		{
			i=Integer.parseInt(area1.getText());
			nam=area2.getText();
			sec=area3.getText();
			roll=area4.getText();
			dept=area5.getText();
			try{
				Class.forName(driver);
				Connection mycon = DriverManager.getConnection(url, user, pass);
				String sql = "insert into employee "
						+ "(reg, name, roll, section, dept)"
						+ "values(?, ?, ?, ?, ?)";
				PreparedStatement preparestmt = mycon.prepareStatement(sql);
				preparestmt.setInt(1, i);
				preparestmt.setString(2, nam);
				preparestmt.setString(3, roll);
				preparestmt.setString(4, sec);
				preparestmt.setString(5, dept);
				preparestmt.execute();
				}
			catch(Exception exp){
				exp.printStackTrace();
			}
			area1.setText("");
			area2.setText("");
			area3.setText("");
			area4.setText("");
			area5.setText("");
	}
		else
		{
			initial obj = new initial();
			f.dispose();
		}
}
}
