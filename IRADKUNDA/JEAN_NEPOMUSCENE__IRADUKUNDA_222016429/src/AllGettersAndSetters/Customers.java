package AllGettersAndSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customers {//Customer_Id,	Product_Id,	Name,	Email,	Phone_Number,	Gender
	private int cid;
	private String pid;
	private String name;
	private String email;
	private String phnmbr;
	private String gender;
	
	public Customers() {
	    // Default constructor
	}
	public Customers(int cid,String pid,String name,String email,String phnmbr,String gender) {
		super();
		this.cid=cid;
		this.pid=pid;
		this.name=name;
		this.email=email;
		this.phnmbr=phnmbr;
		this.gender=gender;
	}
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String string) {
		this.pid = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnmbr() {
		return phnmbr;
	}
	public void setPhnmbr(String phnmbr) {
		this.phnmbr = phnmbr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to insert data
	    String sql = "INSERT INTO Customers (Product_Id,	Name,	Email,	Phone_Number,	Gender) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.pid);
	       preparedStatement.setString(2, this.name);
	       preparedStatement.setString(3, this.email);
	       preparedStatement.setString(4, this.phnmbr);
	       preparedStatement.setString(5, this.gender);
	       
	        
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

        String sql = "SELECT * FROM Customers";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void update(int inputcid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to update data
	    String sql = "UPDATE Customers SET Product_Id=?, Name=?, Email=?, Phone_Number=?, Gender=?   WHERE Customer_Id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getPid());
	    	  stm.setString(2, this.getName());
	          stm.setString(3, this.getEmail());
	          stm.setString(4, this.getPhnmbr());
	          stm.setString(5, this.getGender()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(6, inputcid);
	       
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
	public void delete(int inputcid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to delete data
	    String sql = "DELETE FROM Customers WHERE  Customer_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputcid); // Assuming there is a column named 'id' for the WHERE clause

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



