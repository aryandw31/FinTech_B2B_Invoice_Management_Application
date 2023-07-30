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
import com.highradius.model.Invoice;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	    private InvoiceDao invoiceDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		invoiceDao = new InvoiceDaoImpl();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
	    response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
	    response.addHeader("Access-Control-Max-Age", "1728000");
		
		int CUSTOMER_ORDER_ID = Integer.parseInt(request.getParameter("customerOrderId"));
		int SALES_ORG = Integer.parseInt(request.getParameter("salesOrg"));
		int COMPANY_CODE = Integer.parseInt(request.getParameter("companyCode"));
		int CUSTOMER_NUMBER = Integer.parseInt(request.getParameter("customerNumber"));
		
		String DISTRIBUTION_CHANNEL = request.getParameter("distributionChannel");
		String ORDER_CREATION_DATE = request.getParameter("orderCreationDate");
		String ORDER_CURRENCY = request.getParameter("orderCurrency");
		
		double AMOUNT_IN_USD = Double.parseDouble(request.getParameter("amountInUSD"));
		
		
		Invoice inv = new Invoice(CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, COMPANY_CODE, ORDER_CREATION_DATE, ORDER_CURRENCY, CUSTOMER_NUMBER, AMOUNT_IN_USD);
		
		try {
			addInvoice(inv);
			response.getWriter().append("Invoice Successfully added to the Database!");
		}
		catch(Exception e) {
			response.getWriter().append("Failed to add Invoice to the Database!");
			response.getWriter().append("\nError: " + e);
		}
			
	}
	
	 public void addInvoice(Invoice invoice) {
	    	invoiceDao.insertInvoice(invoice);
	    }
	 
	 public static void main(String args[]) {
//	    	AddServlet ads = new AddServlet();
//	    	Invoice invoice = new Invoice();
//	    	ads.addInvoice(invoice);
	    }

}