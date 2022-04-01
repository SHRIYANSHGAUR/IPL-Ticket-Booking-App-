package manage;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import manage.connect;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class show extends JFrame{

	
	  public show() throws ClassNotFoundException 
	  {
	    try 
	  {
	    	//create A CONNECTION with SQL DATABASE 
	      Connection con=connect.createC();
			
	      String query = "SELECT * FROM ticket";
	    	    
	      Statement stm = con.createStatement();  //sql statement
	      ResultSet res = stm.executeQuery(query);   //executing query 
	    
	      String columns[] = { "ID", "MATCH", "PRICE", "VENUE", "DATE"};
	      String data[][] = new String[8][5];
	    
	    //Adding SQL table DATA in JTable  
	      
	      
	      int i = 0;
	      while (res.next()) {
	        int id = res.getInt("ID");
	    	    
	        String mat = res.getString("MATCH");
	        String pri = res.getString("PRICE");
	        String ven = res.getString("VENUE");
	        String dat = res.getString("DATE");
	        data[i][0] = id + "";
	        data[i][1] = mat;
	        data[i][2] = pri;
	        data[i][3] = ven;
	        data[i][4] = dat;
	        i++;
	      }
	      
	      JPanel bp= new JPanel();
	    
	      DefaultTableModel model = new DefaultTableModel(data, columns);  //Setting table rows and column
	      JTable table= new JTable(model);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      JScrollPane pane = new JScrollPane(table);  //Adding scroll pane in table
	      
	       
	     //add scrollpane 
	      add(pane);
	      
	      
		 
	     setSize(500,500);
	     pack(); 
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         getContentPane().setBackground(Color.BLUE);
	        setTitle(" SHRIYANSH GAUR 20115904  MATCH DATA");
	      
	        
	      
	    } catch(SQLException e) {
	      e.printStackTrace();
	    }
	  }
	}
	

