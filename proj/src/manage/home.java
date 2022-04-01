package manage;

import manage.show;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class home extends JFrame implements ActionListener{
    home(){
        
        setSize(950,965);
    	setResizable(false);
    	setLayout(new BorderLayout());
        ImageIcon ic =  new ImageIcon(("C:\\Users\\Dell\\eclipse-workspace\\proj\\src\\1.jpg"));
         JLabel l1 = new JLabel();
        l1.setIcon(ic);
        JLabel l2 = new JLabel();
        l2.setText("IPL Ticket Counter");
        l2.setFont(new Font("monospaced",Font.BOLD,36));
        l2.setHorizontalAlignment(JLabel.CENTER);
        JLabel l3 = new JLabel();
        
        l3.setText("Dont miss out any of these Epic Matches!");
        l3.setFont(new Font("monospaced",Font.BOLD,32));
        l3.setHorizontalAlignment(JLabel.CENTER);
	  
        
   JButton bb1=new JButton("MATCH SCHEDULE and TICKET-PRICES");
   bb1.setBounds(160,160,50,50);
   
      JButton bb2= new JButton("BUY TICKET");
      bb2.setBounds(80,80,50,50);
      
      JPanel jj=new JPanel(new BorderLayout());
      
      //Home PANEL 
        JPanel jjp=new JPanel(new BorderLayout());
        jjp.add(l3,BorderLayout.NORTH);
        
        jjp.add(bb2,BorderLayout.SOUTH);
       
        jjp.add(l1,BorderLayout.CENTER);
        
        //MAKING A CUSTOM BUTTON GROUP 
        JPanel bb=new JPanel(new FlowLayout());
        bb.add(bb2);
        bb.add(bb1);
        
        
       //making another panel  
        JPanel jjp1=new JPanel(new BorderLayout());
        jjp1.add(l2,BorderLayout.CENTER);
        jjp1.add(bb,BorderLayout.SOUTH);
        
       
      //adding another panel below home panel 
         
        jj.add(jjp1,BorderLayout.SOUTH); 
        jj.add(jjp,BorderLayout.WEST); 
        
       //add action listener on buttons 
    bb2.addActionListener(this);
    bb1.addActionListener(this);
        
       add(jj); 
        
        
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("DATA");
      
        JMenuItem m2 = new JMenuItem("MATCH DATA");
        master.setForeground(Color.RED);
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        m2.setBackground(Color.WHITE);
        m2.addActionListener(this);
        master.add(m2);
                
  
        JMenu by = new JMenu("BUY");
        JMenuItem u1 = new JMenuItem("BUY TICKET");
        by.setForeground(Color.RED);
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        u1.setBackground(Color.WHITE);
        u1.addActionListener(this);
        by.add(u1);
        
        
        JMenu cart = new JMenu("CART");
        JMenuItem a1 = new JMenuItem("TICKETS-SELECTED");
        cart.setForeground(Color.RED);
        a1.setFont(new Font("monospaced",Font.BOLD,16));
         a1.setBackground(Color.WHITE);
        cart.add(a1);
         a1.addActionListener(this);
        
        JMenu upd = new JMenu("Update");
        JMenuItem b1 = new JMenuItem("UPDATE-BOOKINGS");
        upd.setForeground(Color.RED);
        b1.setFont(new Font("monospaced",Font.BOLD,16));
        b1.setBackground(Color.WHITE);
        upd.add(b1);
        b1.addActionListener(this);
        
        
        JMenu ck = new JMenu("CHECKOUT");
        JMenuItem c1 = new JMenuItem("PROCEED TO PAY !");
        
        ck.setForeground(Color.RED);
        
        c1.setFont(new Font("monospaced",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.addActionListener(this);
        ck.add(c1);
        
                
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.RED);
        ex.setFont(new Font("monospaced",Font.BOLD,16));
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
            
        
        JMenu ab = new JMenu("Deligently Crafted By SHRIYANSH GAUR ( 20115904 ) ");
        ab.setForeground(Color.BLACK);
        
        //add menus in menubar
        
        mb.add(master);
        mb.add(by);
        mb.add(cart);
        mb.add(upd);
        mb.add(ck);
        mb.add(exit);
        mb.add(ab); 
        setJMenuBar(mb);    //adding menubar in frame
        
        getContentPane().setBackground(Color.BLUE);
        setTitle(" SHRIYANSH GAUR 20115904   IPL-TICKET COUNTER");
        setFont(new Font("Senserif",Font.BOLD,16));   
        setLayout(new FlowLayout());   //flowlayout for default
        setVisible(false);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    	
        String msg = ae.getActionCommand();
        // Our Action triggers the following options
        
        if(msg.equals("MATCH SCHEDULE and TICKET-PRICES")|| (msg.equals("MATCH DATA"))){
	        show obj;
			
			try {
				obj = new show();  //calling show cost and implementing abstraction and modularity!
			
			    obj.setVisible(true);
	            	
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
        }else if(msg.equals("BUY TICKET")){
        	buy obj;
        	//calling class buy and implementing abstraction and modularity!
 				obj = new buy();
 			
 				obj.setVisible(true);
	            
 			
            
        }
        
        else if(msg.equals("Exit")){
            System.exit(0);
        }
        else if(msg.equals("TICKETS-SELECTED")){
       
        	  fin obj;   //calling class fin and implementing abstraction and modularity!
				
				try {
					obj = new fin();
					obj.setVisible(true);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
          
        	
        	
            
        }else if(msg.equals("UPDATE-BOOKINGS")){
          
        	 remov obj;  //calling class remov and implementing abstraction and modularity!
					obj = new remov();
					obj.setVisible(true);
				
			
				
        }else if(msg.equals("PROCEED TO PAY !")){
         
        	cost obj;   //calling class cost and implementing abstraction and modularity!
			
			
			try {
				obj = new cost();
				obj.setVisible(true);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    	 
            
        }
        
    }
    
    
    public static void main(String[] args){
       
    	home p=new home();
    	p.setVisible(true);
    	
    }
    
}
