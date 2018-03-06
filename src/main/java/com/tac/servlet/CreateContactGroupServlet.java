package com.tac.servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tac.entity.Address;
import com.tac.entity.Contact;
import com.tac.entity.ContactGroup;
import com.tac.entity.PhoneNumber;
import com.tac.service.ContactGroupService;
import com.tac.service.ContactService;

/**
 * Servlet implementation class CreateContactGroupServlet
 */
@WebServlet("/CreateContactGroupServlet")
public class CreateContactGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateContactGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("namegroup");
		
		
		if(!name.equals("")) {
			ContactGroup cg = new ContactGroup();
			cg.setName(name);
			ContactGroupService cgs = new ContactGroupService();
			cgs.createContactGroup(cg);
		}

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
