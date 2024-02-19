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

import AllGettersAndSetters.Product;
import AllGettersAndSetters.Stock_Transaction;

public class Stock_TransactionForm implements ActionListener{
	JFrame frame;//Stock_Transaction_Id	Product_Id	Transaction_Type	Quantity	Transaction_Date
	JLabel stktrid_lb=new JLabel("Stock_Transaction_Id");
	JLabel pid_lb=new JLabel("Product_Id");
	JLabel trtype_lb=new JLabel("Transaction_Type");
	JLabel quaty_lb=new JLabel("Quantity");
	JLabel trdate_lb=new JLabel("Transaction_Date");
	
	JTextField stktrid_txf=new JTextField();
	JTextField pid_txf=new JTextField();
	JTextField trtype_txf=new JTextField();
	JTextField quaty_txf=new JTextField();
	JTextField trdate_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public Stock_TransactionForm(){
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
		frame.setTitle("STOCK TRANSACTION FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		stktrid_lb.setBounds(10,10,300,30);
		pid_lb.setBounds(10,50,300,30);
		trtype_lb.setBounds(10,90,300,30);
		quaty_lb.setBounds(10,130,200,30);
		trdate_lb.setBounds(10,170,300,30);
		
		stktrid_txf.setBounds(250,10,200,30);
		pid_txf.setBounds(250,50,200,30);
		trtype_txf.setBounds(250,90,200,30);
		quaty_txf.setBounds(250,130,200,30);
		trdate_txf.setBounds(250,170,200,30);
       
		
		insert_btn.setBounds(10,250,85,30);
		read_btn.setBounds(110,250,85,30);
		update_btn.setBounds(210,250,85,30);
		delete_btn.setBounds(310,250,85,30);
		
		table.setBounds(500, 10, 600, 270);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		stktrid_lb.setFont(font);
		pid_lb.setFont(font);
		trtype_lb.setFont(font);
		quaty_lb.setFont(font);
		trdate_lb.setFont(font);
		
		
		stktrid_txf.setFont(font);
		pid_txf.setFont(font);
		trtype_txf.setFont(font);
		quaty_txf.setFont(font);
		trdate_txf.setFont(font);
		
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(stktrid_lb);
		frame.add(pid_lb);
		frame.add(trtype_lb);
		frame.add(quaty_lb);
		frame.add(trdate_lb);
		
		frame.add(stktrid_txf);
		frame.add(pid_txf);
		frame.add(trtype_txf);
		frame.add(quaty_txf);
		frame.add(trdate_txf);
		
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Stock_Transaction stkf=new Stock_Transaction();
		if(e.getSource()==insert_btn) {
			
			stkf.setPid(pid_txf.getText());
			stkf.setTrtype(trtype_txf.getText());
			stkf.setQuaty(quaty_txf.getText());
			stkf.setTrdate(trdate_txf.getText());
			stkf.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Stock_Transaction_Id");
            model.addColumn("Product_Id");
            model.addColumn("Transaction_Type");
            model.addColumn("Quantity");
            model.addColumn("Transaction_Date");
           
            ResultSet resultSet =Stock_Transaction.viewData();
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
			int id=Integer.parseInt(stktrid_txf.getText());
			stkf.setPid(pid_txf.getText());
			stkf.setTrtype(trtype_txf.getText());
			stkf.setQuaty(quaty_txf.getText());
			stkf.setTrdate(trdate_txf.getText());
			stkf.update(id);
	    }
	  else {
			int id=Integer.parseInt(stktrid_txf.getText());
			stkf.delete(id);}

	  }
	public static void main(String[] args) {
		Stock_TransactionForm stockf= new Stock_TransactionForm();
		System.out.println(stockf);

	}
}
