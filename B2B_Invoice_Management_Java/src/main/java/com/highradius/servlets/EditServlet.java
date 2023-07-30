package com.highradius.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
//import com.highradius.model.Invoice;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao invoiceDao;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		invoiceDao = new InvoiceDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
	    response.addHeader("Access-Control-Max-Age", "1728000");
	    
		int id = Integer.parseInt(request.getParameter("UPD_ID"));
		int COMPANY_CODE = Integer.parseInt(request.getParameter("UPD_COMPANY_CODE"));
		String DISTRIBUTION_CHANNEL = request.getParameter("UPD_DISTRIBUTION_CHANNEL");
		String ORDER_CURRENCY = request.getParameter("UPD_ORDER_CURRENCY");
		
		try {
			updateInvoice(id, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CURRENCY);
			response.getWriter().append("Invoice Successfully Edited in the Database!");
		}
		catch(Exception e) {
			response.getWriter().append("Failed to Edit Invoice in the Database!");
			response.getWriter().append("\nError: " + e);
		}

	}
	
	 public void updateInvoice(int id, String DISTRIBUTION_CHANNEL, int COMPANY_CODE, String ORDER_CURRENCY) {
	    	invoiceDao.updateInvoice(id, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CURRENCY);
	    }
	 
	 public static void main(String args[]) {
//	    	AddServlet ads = new AddServlet();
//	    	Invoice invoice = new Invoice();
//	    	ads.addInvoice(invoice);
	    }

}