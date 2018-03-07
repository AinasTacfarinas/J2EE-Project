package com.tac.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

		Address a = c.getAddress();
		a.setStreet(request.getParameter("street"));
		a.setCity(request.getParameter("city"));
		a.setCountry(request.getParameter("country"));


		Set<PhoneNumber> lp = c.getPhoneNumbers();

		HashSet<PhoneNumber> newset = new HashSet<PhoneNumber>();

		for(int i=0;i<lp.size();i++) {
			String n = request.getParameter("phonenumber"+i);
			if(!n.equals("")) {
				PhoneNumber np = new PhoneNumber(n);
				np.setContact(c);
				newset.add(np);
			}
		}


		lp.addAll(newset);

		lp.retainAll(newset);



		String newphone = request.getParameter("newphonenumber");
		if(!newphone.equals("")) {
			PhoneNumber pn = new PhoneNumber(newphone);
			pn.setContact(c);
			lp.add(pn);
		}





		ContactGroupService cgs = new ContactGroupService();

		String []checkedGroups = request.getParameterValues("groups");

		if(checkedGroups==null) {
			checkedGroups = new String[] {};
		}

		Set<ContactGroup> scg = c.getGroups();

		
		Iterator<ContactGroup> it = scg.iterator();

		while(it.hasNext()) {
			ContactGroup cg = it.next();
			boolean b = false;
			for(int i=0;i<checkedGroups.length;i++) {

				if(cg.getName().equals(checkedGroups[i])) {
					b = true;
					break;
				}

			}

			if(!b) {

				boolean az = cg.getContacts().remove(c);
				System.out.println("ALLO "+az);
				it.remove();
			}
		}


		scg.stream().forEach(e->System.out.println(e.getName()));

		for(int i=0;i<checkedGroups.length;i++) {

			String name = checkedGroups[i];

			Iterator<ContactGroup> it2 = scg.iterator();
			boolean b = false;
			while(it2.hasNext()) {

				ContactGroup cg = it2.next();
				if(cg.getName().equals(name)) {
					b = true;
					break;
				}

			}

			if(!b) {
				ContactGroup cg = cgs.getContactGroupByName(name);
				cg.getContacts().add(c);
				scg.add(cg);
			}

		}
		System.out.println("FIN");
		scg.stream().forEach(e->System.out.println(e.getName()));



		String newgroup = request.getParameter("groupnamenew");
		if(!newgroup.equals("")) {
			ContactGroup cg = new ContactGroup(newgroup);
			cg.getContacts().add(c);
			scg.add(cg);
		}

		c.setGroups(scg);

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
