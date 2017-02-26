import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
public class delete implements ActionListener{
	private JLabel jbl1;
	private JLabel jbl3;
	private TextField tf1;
	private JLabel jbl2;
	private TextArea area;
	private JButton jbtn1;
	private JButton jbtn2;
	JFrame ft;
	public delete()
	{
		ft = new JFrame("Delete Query");
		
		jbl3 = new JLabel("Delete Query:",JLabel.LEFT);
		jbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbl3.setBounds(30,10,250,30);
		ft.add(jbl3);
		
		jbl1 = new JLabel("Register number to be deleted:",JLabel.LEFT);
		jbl1.setBounds(30,50,180,30);
		ft.add(jbl1);
		tf1  = new TextField(30);
		tf1.setBounds(220,50,205,25);
		ft.add(tf1);
		jbtn1 = new JButton("Delete");
		jbtn1.setBounds(30,100,100,30);
		ft.add(jbtn1);
		jbl2 = new JLabel("Deleted Query:",JLabel.LEFT);
		jbl2.setBounds(30,150,250,30);
		ft.add(jbl2);
		area = new TextArea(6,80);
		area.setBounds(30,200,350,90);
		area.setEditable(false);
		ft.add(area);
		jbtn2 = new JButton("back");
		jbtn2.setBounds(30,310,100,30);
		ft.add(jbtn2);
		ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ft.setLayout(null);
		ft.setVisible(true);
		ft.setSize(450,400);
		ft.setResizable(true);
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e){
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "Password";
		String driver = "com.mysql.jdbc.Driver";
		int idt;
		if(e.getSource()==jbtn1)
		{
			idt = Integer.parseInt(tf1.getText());
			try
			{
			Class.forName(driver);
			Connection mycon = DriverManager.getConnection(url, user, pass);
			
			String sql = "select * from employee where reg = "+idt;
			Statement stmt = mycon.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				int idm = rs.getInt("reg");
				String fname = rs.getString("name");
				int reg = rs.getInt("reg");
				area.setText("Reg no.-"+idm+"\nName - "+fname+"\nReg - "+reg);
			}
			
			String sql1 = "delete from employee where reg = ?";
			PreparedStatement preparestmt = mycon.prepareStatement(sql1);
			preparestmt.setInt(1, idt);
			preparestmt.execute();
			}
			catch(Exception exp)
			{
				area.setText("got error");
			}
		}
		else
		{
			initial obj = new initial();
			ft.dispose();
		}
	}

}
