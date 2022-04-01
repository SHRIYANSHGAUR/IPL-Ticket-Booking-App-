package manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class fin extends JFrame implements ActionListener {

 public fin() throws ClassNotFoundException, SQLException {
String q2=("select * from ticket where id in (select id from checks)"); 
//gets all the seleced ID-OF-TICKETS by the CUSTOMER from checks table  
// and displays data from ticket table
//interface same as buy class


 Connection con=connect.createC();

Statement stm = con.createStatement();
ResultSet res = stm.executeQuery(q2);
	
	
String columns[] = { "ID", "MATCH", "PRICE", "VENUE", "DATE"};
String data[][] = new String[8][5];

int i = 0;
while (res.next()) {
int id = res.getInt("ID");   //SHOWS all the selected TICKETS by the CUSTOMER
    
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

DefaultTableModel model = new DefaultTableModel(data, columns); //creating table by adding row ,column
JTable table= new JTable(model);
table.setShowGrid(true);
table.setShowVerticalLines(true);
JScrollPane pane = new JScrollPane(table);
//add scrollpane

JButton b=new JButton("PROCEED TO PAY !");
add(b,"South");
b.addActionListener(this);

add(pane);





setSize(1500,1500);
pack(); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

getContentPane().setBackground(Color.BLUE);
setTitle(" SHRIYANSH GAUR 20115904   TICKET CART");



 }
 
 public void actionPerformed(ActionEvent ae){
     try{
    	 //when ever button is pressed launch the cost class
    	 cost obj;
			obj = new cost();
			obj.setVisible(true);
    	 
    	 
     }catch(Exception e){}
 }
 
}
