package com.highradius.connection;

import com.highradius.model.Invoice;
import java.sql.*;
import java.util.ArrayList;
//import java.util.List;

public class DatabaseConnection {
    private ArrayList<Invoice> invoices;
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pd = null;
    final String URL = "jdbc:mysql://localhost:3306/oap_h2h";
    final String USER = "root";
    final String PASS = "root";
    String query;
    public DatabaseConnection() {
        invoices = new ArrayList<>();
    }
    
    // Method to open connection with MySQL database
    void openConnection() {
    	try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(URL ,USER, PASS);
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
    }

    // Method to get the list of invoices
    public ArrayList<Invoice> getInvoices() {
    	invoices.clear();;
    	try {
    		openConnection();
        	query = "Select * from h2h_oap limit 10000";
        	pd = con.prepareStatement(query);
        	rs = pd.executeQuery();
            while(rs.next()) {
            	Invoice inv = new Invoice(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDouble(6), 
            			rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getDouble(13),
            			rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(17), rs.getDouble(18), rs.getLong(19));
            	inv.set_Sl_no(rs.getInt(1));
            	invoices.add(inv);
            }
            System.out.println("size: " + invoices.size());
            closeConnection();
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
        return invoices;
    }

    // Method to add an invoice to the database
    public void addInvoice(Invoice invoice) {
//        invoices.add(invoice);
    	query = "Insert into h2h_oap(CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_CURRENCY, CUSTOMER_NUMBER, AMOUNT_IN_USD) values(?, ?, ?, ?, ?, ?, ?, ?);";
    	try {
    		openConnection();
    		pd = con.prepareStatement(query);
    		
    		pd.setInt(1, invoice.get_CUSTOMER_ORDER_ID());
    		pd.setInt(2, invoice.get_SALES_ORG());
    		pd.setString(3, invoice.get_DISTRIBUTION_CHANNEL());
    		pd.setInt(4, invoice.get_COMPANY_CODE());
    		pd.setString(5, invoice.get_ORDER_CREATION_DATE());
    		pd.setString(6, invoice.get_ORDER_CURRENCY());
    		pd.setInt(7, invoice.get_CUSTOMER_NUMBER());
    		pd.setDouble(8, invoice.get_AMOUNT_IN_USD());
    		
    		pd.executeUpdate();
    		closeConnection();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    // Method to delete an invoice record with a given id from the database
    public void deleteInvoice(int id) {
    	query = "Delete from h2h_oap where sl_no = ?";
    	try {
    		openConnection();
    		pd = con.prepareStatement(query);
    		pd.setInt(1, id);
    		pd.execute();
    		closeConnection();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
 // Method to update an invoice record with a given id in the database
    public void updateInvoice(int id, String DISTRIBUTION_CHANNEL, int COMPANY_CODE, String ORDER_CURRENCY) {
    	query = "Update h2h_oap set ORDER_CURRENCY = ?, COMPANY_CODE = ?, DISTRIBUTION_CHANNEL = ? where Sl_no = ?";
    	try {
    		openConnection();
    		pd = con.prepareStatement(query);
    		pd.setString(1, ORDER_CURRENCY);
    		pd.setInt(2, COMPANY_CODE);
    		pd.setString(3, DISTRIBUTION_CHANNEL);
    		pd.setInt(4, id);
    		pd.execute();
    		closeConnection();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    // Method to close connection with the database
    void closeConnection() {
    	try {
    		if(con != null)
    			con.close();
		} 
    	catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public static void main(String args[]) {
    	DatabaseConnection dbc = new DatabaseConnection();
    	dbc.getInvoices();
//    	Invoice inv= new Invoice(111, 111, "ARYAN", "aaa", 111, "aaa", 9295434, "aaa", "aaa", "aaa", 111, 111, "aaa", "SAGAR", "aaa", 111, 111, 111);
//    	dbc.addInvoice(inv);
//////    	dbc.deleteInvoice(1048576);
//////    	dbc.updateInvoice(1048576, inv);
////    	
    	System.out.println("type: " + dbc.getClass().getName());
    }
//    
}
