package manage;

import javax.swing.JOptionPane;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;


import java.awt.*;
import java.awt.event.*;

public class cost extends JFrame {

	cost() throws ClassNotFoundException, SQLException{
		  Connection con=connect.createC();
	       	
		  Statement stmt = con.createStatement();
	    
	      ResultSet rs = stmt.executeQuery("select price from ticket where id in (select id from checks)");
	      // query selets data entry from PRICE COLUMN from ticket table 
	      // of only those tickets WHOOSE ID WAS SELECTED through BUY class
	      
	      
          int sum=0;
          //sums up the total cost of tickets selected by customer
          
	      while(rs.next()) {
	         sum += Integer.valueOf(rs.getString("PRICE"));
	        	      }
		
		
        JPanel	 p=new JPanel();  

         //dislays popup        
        
        JOptionPane.showMessageDialog (p,"TOTAL COST : Rs."+ sum,"SHRIYANSH GAUR 20115904 TOTAL COST",JOptionPane.INFORMATION_MESSAGE);     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    

}
}
