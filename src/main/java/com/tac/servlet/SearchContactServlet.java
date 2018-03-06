package com.tac.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tac.entity.Contact;
import com.tac.entity.ContactGroup;
import com.tac.service.ContactGroupService;
import com.tac.service.ContactService;

/**
 * Servlet implementation class SearchContactServlet
 */
@WebServlet(name = "SearchContact", urlPatterns = { "/SearchContact" })
public class SearchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String req = request.getParameter("searchcontact");
		
		ContactService cs = new ContactService();
		
		ArrayList<Contact> l = null;
		
		if(req.equals("")) {
			l = cs.getSearchAllContact();
		}
		
		request.setAttribute("contactlist", l);
		
		Map<String,String[]> m = request.getParameterMap();
		
		for (Map.Entry<String,String[]> e : m.entrySet()){
			
			System.out.println("KEY "+ e.getKey());
			
		}

		if(m!=null){
			for (Map.Entry<String,String[]> e : m.entrySet()){
				String[] res = e.getKey().split("\\.");
				if(res[0].equals("modif")){
					request.setAttribute("contactToModify",l.get(Integer.parseInt(res[1])));
					ContactGroupService cgs = new ContactGroupService();
					Set<ContactGroup> cg= cgs.getContactGroups();
					request.setAttribute("AllGroups", cg);
					getServletContext().getRequestDispatcher("/Form/Detail/DetailContact.jsp").forward(request, response);
					return;
				}else{
					if(res[0].equals("supr")){
						cs.deleteContactById(l.get(Integer.parseInt(res[1])).getContact_id());
						//a.deleteAddress(l.get(Integer.parseInt(res[1])).getAddress().getAddressID());
						getServletContext().getRequestDispatcher("/index.html").forward(request, response);
						return;
					}
				}

			}
			
		}

		getServletContext().getRequestDispatcher("/Form/Search/SearchContact.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
