package com.highradius.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import com.google.gson.Gson;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
//import java.util.List;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;

/**
 * Servlet implementation class DataLoadingServlet
 */
@WebServlet("/DataLoadingServlet")
public class DataLoadingServlet extends HttpServlet {
	private InvoiceDao invoiceDao;
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		invoiceDao = new InvoiceDaoImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		
		Gson gson = new Gson();
		String json = new String();
		ArrayList<Invoice> ordersOnUi = getInvoices();
		json = gson.toJson(ordersOnUi);

		response.getWriter().append(json);
	}
	
	public ArrayList<Invoice> getInvoices() {
    	return invoiceDao.getInvoices();
    }
    
    public static void main(String args[]) {
    	
    }

}

