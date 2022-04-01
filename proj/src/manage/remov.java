package manage;

import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;


import java.awt.*;
import java.awt.event.*;

public class remov extends JFrame implements ActionListener{
    
    JButton b1,b2;
    Choice c2;
    
    remov(){
       
        setLayout(new GridLayout(4,2,50,50));
        c2 = new Choice();
        try{
        	Connection con=connect.createC();
        	 Statement stm = con.createStatement();
   	            ResultSet rs = stm.executeQuery("select * from checks");  //shows the selected id of tickets from checks table
            while(rs.next()){
                c2.add(rs.getString("ID"));
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel("Select Ticket ID"));
        add(c2);
        b1 =new JButton("REMOVE from CART");
      
        b2 = new JButton("Cancel");
              
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getRootPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(300,400);
        setLocation(600,200);
       

          setTitle(" SHRIYANSH GAUR 20115904   Remove Booking");
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
       String id1=c2.getSelectedItem();
        
        try{
        	Connection con=connect.createC();
        	 String qry = "delete from checks where id=?";    //now delete that id of ticket the customer removes
        	
       		PreparedStatement pstmt = con.prepareStatement(qry);
		       	pstmt.setString(1,id1);
            pstmt.executeUpdate();     //execute command
            
            //shows a popup
            
            JOptionPane.showMessageDialog(null,"BOOKING REMOVED !");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    }