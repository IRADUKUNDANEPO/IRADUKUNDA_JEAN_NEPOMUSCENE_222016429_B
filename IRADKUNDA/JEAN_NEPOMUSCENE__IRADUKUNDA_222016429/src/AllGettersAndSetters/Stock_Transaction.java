package AllGettersAndSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Stock_Transaction {//Stock_Transaction_Id	Product_Id	Transaction_Type	Quantity	Transaction_Date
	private int stktrid;
	private String pid;
	private String trtype;
	private String quaty;
	private String trdate;
	
	public Stock_Transaction() {
	    // Default constructor
	}
	public Stock_Transaction(int stktrid,String pid,String trtype,String quaty,String trdate) {
		super();
		this.stktrid=stktrid;
		this.pid=pid;
		this.trtype=trtype;
		this.quaty=quaty;
		this.trdate=trdate;
	}
	public int getStktrid() {
		return stktrid;
	}
	public void setStktrid(int stktrid) {
		this.stktrid = stktrid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTrtype() {
		return trtype;
	}
	public void setTrtype(String trtype) {
		this.trtype = trtype;
	}
	public String getQuaty() {
		return quaty;
	}
	public void setQuaty(String quaty) {
		this.quaty = quaty;
	}
	public String getTrdate() {
		return trdate;
	}
	public void setTrdate(String trdate) {
		this.trdate = trdate;
	}
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to insert data
	    String sql = "INSERT INTO Stock_Transaction (Product_Id, Transaction_Type, Quantity, Transaction_Date) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.pid);
	       preparedStatement.setString(2, this.trtype);
	       preparedStatement.setString(3, this.quaty);
	       preparedStatement.setString(4, this.trdate);
	       
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

        String sql = "SELECT * FROM Stock_Transaction";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
	public void update(int inputstktrid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to update data
	    String sql = "UPDATE Stock_Transaction SET Product_Id=?, Transaction_Type=?, Quantity=?, Transaction_Date=?   WHERE Stock_Transaction_Id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setNString(1, this.getPid());
	    	  stm.setString(2, this.getTrtype());
	          stm.setString(3, this.getQuaty());
	          stm.setString(4, this.getTrdate());
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputstktrid);
	       
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
	public void delete(int inputstktrid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to delete data
	    String sql = "DELETE FROM Stock_Transaction WHERE Stock_Transaction_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputstktrid); // Assuming there is a column named 'id' for the WHERE clause

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





