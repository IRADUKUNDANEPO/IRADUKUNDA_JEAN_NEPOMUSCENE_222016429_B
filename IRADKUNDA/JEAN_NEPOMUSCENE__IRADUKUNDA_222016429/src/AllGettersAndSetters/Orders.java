package AllGettersAndSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Orders {
	private int orderid;
	private String cid;
	private String orderdate;
	private String totamnt;
	private String orderstts;
	public Orders() {
	    // Default constructor
	}
	public Orders(int orderid,String cid,String orderdate,String totamnt,String orderstts) {
		super();
		this.orderid=orderid;
		this.cid=cid;
		this.orderdate=orderdate;
		this.totamnt=totamnt;
		this.orderstts=orderstts;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getTotamnt() {
		return totamnt;
	}
	public void setTotamnt(String totamnt) {
		this.totamnt = totamnt;
	}
	public String getOrderstts() {
		return orderstts;
	}
	public void setOrderstts(String orderstts) {
		this.orderstts = orderstts;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to insert data
	    String sql = "INSERT INTO Orders (Customer_Id,  Order_Date,  Total_Amount,  Order_Status) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.cid);
	       preparedStatement.setString(2, this.orderdate);
	       preparedStatement.setString(3, this.totamnt);
	       preparedStatement.setString(4, this.orderstts);
	       
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
	 public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
        String user = "222016429";
        String password = "222016429";

        String sql = "SELECT * FROM Orders";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void update(int inputorderid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to update data
	    String sql = "UPDATE Orders SET Customer_Id,  Order_Date,  Total_Amount,  Order_Status   WHERE Order_Id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getCid());
	    	  stm.setString(2, this.getOrderdate());
	          stm.setString(3, this.getTotamnt());
	          stm.setString(4, this.getOrderstts());
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputorderid);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputorderid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to delete data
	    String sql = "DELETE FROM Orders  WHERE Order_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputorderid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}


