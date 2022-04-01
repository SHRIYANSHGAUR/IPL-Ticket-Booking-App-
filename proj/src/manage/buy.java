

package manage;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;


import java.awt.*;
import java.awt.event.*;

public class buy extends JFrame implements ActionListener{
    
    JButton b1,b2;
    Choice c2;
    
    buy(){
       
        setLayout(new GridLayout(4,2,50,50));
        c2 = new Choice();
        try{
        	//create A CONNECTION with SQL DATABASE 
        	Connection con=connect.createC();
        	
        	 Statement stm = con.createStatement();  //sql statement
   	            ResultSet rs = stm.executeQuery("select * from ticket");  //executing query 
   	            
            while(rs.next()){
                c2.add(rs.getString("ID"));   //show ID of tickets in choice
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel("Select Ticket ID"));
        add(c2);
        b1 =new JButton("Submit");
      
        b2 = new JButton("Cancel");
              
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getRootPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(300,400);
        setLocation(600,200);
      
        setTitle(" SHRIYANSH GAUR 20115904  BUY");
      
      
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
       String id1=c2.getSelectedItem();  //comes with id selcted
        
        try{
        	Connection con=connect.createC();
        	 String qry = "insert into checks values(?)";   //ADDS THE SELCTED TICKET into checks table of ipl database
        	
       		PreparedStatement pstmt = con.prepareStatement(qry);
		       	pstmt.setString(1,id1);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"BOOKINGS Confirmed !");
            
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    }