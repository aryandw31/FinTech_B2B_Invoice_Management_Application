package com.highradius.implementation;

import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {
    private DatabaseConnection databaseConnection;

    public InvoiceDaoImpl() {
        databaseConnection = new DatabaseConnection();
    }

    @Override
    public ArrayList<Invoice> getInvoices() {
        return databaseConnection.getInvoices();
    }

    @Override
    public void insertInvoice(Invoice invoice) {
        databaseConnection.addInvoice(invoice);
    }

    @Override
    public void updateInvoice(int id, String DISTRIBUTION_CHANNEL, int COMPANY_CODE, String ORDER_CURRENCY) {
        // Implement the update logic here
    	databaseConnection.updateInvoice(id, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CURRENCY);
    }

    @Override
    public void deleteInvoice(int id) {
        // Implement the delete logic here
    	databaseConnection.deleteInvoice(id);
    }
    
    public static void main(String args[]) {
    	InvoiceDaoImpl imd = new InvoiceDaoImpl();
    	imd.deleteInvoice(1048577);
    }
}
