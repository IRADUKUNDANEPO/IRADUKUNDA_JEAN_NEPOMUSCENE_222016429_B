package AllGettersAndSetters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Supplier {//Supplier_Id	Product_Id	Supplier_Name	Supplier_Address	Supplier_Contact	Gender	

	private int sid;
	private String pid;
	private String sname;
	private String saddress;
	private String scontact;
	private String gender;
	
	public Supplier() {
	    // Default constructor
	}
	public Supplier(int sid,String pid,String sname,String saddress,String scontact,String gender) {
		super();
		this.sid=sid;
		this.pid=pid;
		this.sname=sname;
		this.saddress=saddress;
		this.scontact=scontact;
		this.gender=gender;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getScontact() {
		return scontact;
	}
	public void setScontact(String scontact) {
		this.scontact = scontact;
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
	    String sql = "INSERT INTO Supplier (Product_Id, Supplier_Name, Supplier_Address, Supplier_Contact, Gender) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.pid);
	       preparedStatement.setString(2, this.sname);
	       preparedStatement.setString(3, this.saddress);
	       preparedStatement.setString(4, this.scontact);
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

        String sql = "SELECT * FROM Supplier";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    

	public void update(int inputsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to update data
	    String sql = "UPDATE Supplier SET Product_Id=?, Supplier_Name=?, Supplier_Address=?, Supplier_Contact=?, Gender=?   WHERE Supplier_Id= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setNString(1, this.getPid());
	    	  stm.setString(2, this.getSname());
	          stm.setString(3, this.getSaddress());
	          stm.setString(4, this.getScontact());
	          stm.setString(5, this.getGender()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(6, inputsid);
	       
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
	public void delete(int inputsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/jean_nepomuscene_iradukunda_stock_mgt_system";
	    String user = "222016429";
	    String password = "222016429";

	    // SQL query to delete data
	    String sql = "DELETE FROM Supplier WHERE  Supplier_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputsid); // Assuming there is a column named 'id' for the WHERE clause

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

	


