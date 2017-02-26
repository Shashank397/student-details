import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
public class initial extends JFrame{
	private JButton jbtn1;
	private JButton jbtn2;
	private JButton jbtn3;
	JFrame fm;
	
	public initial(){
	
	fm = new JFrame("student details");
	jbtn1 = new JButton("INSERT QUERY");
	jbtn1.setBounds(30,40,280,30);
	fm.add(jbtn1);
	jbtn2 = new JButton("SEARCH QUERY");
	jbtn2.setBounds(30,80,280,30);
	fm.add(jbtn2);
	jbtn3 = new JButton("DELETE QUERY");
	jbtn3.setBounds(30,120,280,30);
	fm.add(jbtn3);
	fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	fm.setLayout(null);
	fm.setVisible(true);
	fm.setSize(350,300);
	fm.setResizable(true);
	
	
	jbtn1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			getInput gi = new getInput();
			fm.dispose();
		}
	});
	jbtn2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			search sr = new search();
			fm.dispose();
		}
	});
	jbtn3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			delete del = new delete();
			fm.dispose();
		}
	});
	}

}
