package com.tac.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tac.entity.Contact;
import com.tac.entity.PhoneNumber;
import com.tac.service.ContactService;
import com.tac.util.HibernateUtil;

/**
 * Servlet implementation class UpdateContactServlet
 */
@WebServlet(name = "UpdateContact", urlPatterns = { "/UpdateContact" })
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ContactService cs = new ContactService();
		Contact c = (Contact) cs.getContactById(Integer.parseInt(request.getParameter("id")));
		if(c==null){
			System.out.println("LE CONTACT N'EXISTE PAS ??");
		}

		c.setEmail(request.getParameter("email"));
		c.setFirstName(request.getParameter("firstname"));
		c.setLastName(request.getParameter("lastname"));
		
		Iterator<PhoneNumber> it = c.getPhoneNumbers().iterator();
		
		
		
		
		cs.updateContact(c);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
