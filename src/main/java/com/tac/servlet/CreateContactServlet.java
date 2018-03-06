package com.tac.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tac.entity.Address;
import com.tac.entity.Contact;
import com.tac.entity.ContactGroup;
import com.tac.entity.PhoneNumber;
import com.tac.service.AddressService;
import com.tac.service.ContactService;
import com.tac.service.PhoneNumberService;

/**
 * Servlet implementation class CreateContactServlet
 */
@WebServlet(name = "CreateContact", urlPatterns = { "/CreateContact" })
public class CreateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateContactServlet() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String group = request.getParameter("groupname");
		
		PhoneNumber pn = new PhoneNumber();
		pn.setNumber(phonenumber);
		HashSet<PhoneNumber> ht = new HashSet<PhoneNumber>();
		
		Contact c = new Contact();
		c.setEmail(email);
		c.setFirstName(firstname);
		c.setLastName(lastname);
		
		Address a = new Address();
		a.setCity(city);
		a.setCountry(country);
		a.setStreet(street);
		
		ContactGroup cg = new ContactGroup(group);
		cg.getContacts().add(c);
		Set<ContactGroup> scg = c.getGroups();
		scg.add(cg);
		
		pn.setContact(c);
		
		ht.add(pn);
		c.setAddress(a);
		c.setPhoneNumbers(ht);
		
		
		
		ContactService cs = new ContactService();
		cs.createContact(c);
		
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
