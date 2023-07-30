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

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
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
		
//		int id = Integer.parseInt(request.getParameter("rowSl_no"));
		int id = Integer.parseInt(request.getParameter("DEL_ID"));
		
//		response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType("application/json");
		
		try {
			deleteInvoice(id);
			response.getWriter().append("Successfully deleted the Invoice from the Database!");
		}
		catch(Exception e) {
			response.getWriter().append("Failed to deleted the Invoice from the Database!");
			response.getWriter().append("\nError: " + e);
		}

	}
	
	 public void deleteInvoice(int id) {
	    	invoiceDao.deleteInvoice(id);
	    }
	 
	 public static void main(String args[]) {
//	    	AddServlet ads = new AddServlet();
//	    	Invoice invoice = new Invoice();
//	    	ads.addInvoice(invoice);
	    }

}