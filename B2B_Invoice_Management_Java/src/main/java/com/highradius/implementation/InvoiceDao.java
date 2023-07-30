package com.highradius.implementation;

import com.highradius.model.Invoice;

import java.util.ArrayList;
//import java.util.List;

public interface InvoiceDao {
    ArrayList<Invoice> getInvoices();
    void insertInvoice(Invoice invoice);
    void updateInvoice(int id, String DISTRIBUTION_CHANNEL, int COMPANY_CODE, String ORDER_CURRENCY);
    void deleteInvoice(int id);
}
