package AllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllGettersAndSetters.Orders;
import AllGettersAndSetters.Product;

public class OrderForm implements ActionListener {
	
	JFrame frame;// Customer_Id,  Order_Date,  Total_Amount,  Order_Status   WHERE Order_Id 
	JLabel orderid_lb=new JLabel("Order_Id");
	JLabel cid_lb=new JLabel("Customer_Id");
	JLabel orderdate_lb=new JLabel("Order_Date");
	JLabel totamnt_lb=new JLabel("Total_Amount");
	JLabel orderstts_lb=new JLabel("Order_Status");
	
	
	JTextField orderid_txf=new JTextField();
	JTextField cid_txf=new JTextField();
	JTextField orderdate_txf=new JTextField();
	JTextField totamnt_txf=new JTextField();
	JTextField orderstts_txf=new JTextField();
	

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public OrderForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("ORDERS FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		orderid_lb.setBounds(10,10,200,30);
		cid_lb.setBounds(10,50,170,30);
		orderdate_lb.setBounds(10,90,250,30);
		totamnt_lb.setBounds(10,130,270,30);
		orderstts_lb.setBounds(10,170,170,30);
	
		
		orderid_txf.setBounds(200,10,190,30);
		cid_txf.setBounds(200,50,190,30);
		orderdate_txf.setBounds(200,90,190,30);
		totamnt_txf.setBounds(200,130,190,30);
		orderstts_txf.setBounds(200,170,190,30);
		
		
		insert_btn.setBounds(10,235,85,30);
		read_btn.setBounds(110,235,85,30);
		update_btn.setBounds(210,235,85,30);
		delete_btn.setBounds(310,235,85,30);
		
		table.setBounds(500, 10, 600, 250);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		orderid_lb.setFont(font);
		cid_lb.setFont(font);
		orderdate_lb.setFont(font);
		totamnt_lb.setFont(font);
		orderstts_lb.setFont(font);
		
		orderid_txf.setFont(font);
		cid_txf.setFont(font);
		orderdate_txf.setFont(font);
		totamnt_txf.setFont(font);
		orderstts_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(orderid_lb);
		frame.add(cid_lb);
		frame.add(orderdate_lb);
		frame.add(totamnt_lb);
		frame.add(orderstts_lb);
		
		frame.add(orderid_txf);
		frame.add(cid_txf);
		frame.add(orderdate_txf);
		frame.add(totamnt_txf);
		frame.add(orderstts_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Orders or=new Orders();
		if(e.getSource()==insert_btn) {
			
			or.setCid(cid_txf.getText());
			or.setOrderdate(orderdate_txf.getText());
			or.setTotamnt(totamnt_txf.getText());
			or.setOrderstts(orderstts_txf.getText());
			or.insertData();
		   }
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Order_Id");
            model.addColumn("Customer_Id");
            model.addColumn("Order_Date");
            model.addColumn("Total_Amount");
            model.addColumn("Order_Status");
            
            
            ResultSet resultSet =Orders.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 

	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(orderid_txf.getText());
			or.setCid(cid_txf.getText());
			or.setOrderdate(orderdate_txf.getText());
			or.setTotamnt(totamnt_txf.getText());
			or.setOrderstts(orderstts_txf.getText());
			or.update(id);
	    }
	  else {
			int id=Integer.parseInt(orderid_txf.getText());
			or.delete(id);}

	  }

	public static void main(String[] args) {
		OrderForm orf= new OrderForm();
		System.out.println(orf);

	}

}

