<%@page import="org.hibernate.annotations.Check"%>
<%@page import="javax.persistence.UniqueConstraint"%>
<%@page import="com.tac.entity.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/J2EE-Project/UpdateContact" method="post">
		<%
			Contact c = (Contact) request.getAttribute("contactToModify");
			if (c != null) {
				out.println("<div>");
				out.println("<label for=\"POST-ID\">ID :</label>");
				out.println("<input id=\"POST-ID\" value=\"" + c.getContact_id()+ "\" type=\"text\" name=\"id\"><br>");
				out.println("<label for=\"POST-FIRSTNAME\">First name :</label>");
				out.println("<input id=\"POST-FIRSTNAME\" value=\"" + c.getFirstName()+ "\" type=\"text\" name=\"firstname\"><br>");
				out.println("<label for=\"POST-LASTNAME\">Last name :</label>");
				out.println("<input id=\"POST-LASTNAME\" value=\"" + c.getLastName()+ "\" type=\"text\" name=\"lastname\"><br>");
				out.println("<label for=\"POST-EMAIL\">E-mail :</label>");
				out.println("<input id=\"POST-EMAIL\" value=\"" + c.getEmail()+ "\" type=\"text\" name=\"email\"><br>");
				Address a = c.getAddress();
				
				if(a!=null){
					out.println("<label for=\"POST-STREET\">Rue :</label>");
					out.println("<input id=\"POST-STREET\" value=\"" + a.getStreet()+ "\" type=\"text\" name=\"street\"><br>");
					out.println("<label for=\"POST-CITY\">Ville :</label>");
					out.println("<input id=\"POST-CITY\" value=\"" + a.getCity()+ "\" type=\"text\" name=\"city\"><br>");
					out.println("<label for=\"POST-COUNTRY\">Rue :</label>");
					out.println("<input id=\"POST-COUNTRY\" value=\"" + a.getCountry()+ "\" type=\"text\" name=\"country\"><br>");
				}
				
				
				Set<PhoneNumber> hs = c.getPhoneNumbers();
				if(hs!=null){
					Iterator<PhoneNumber> it = (Iterator<PhoneNumber>)hs.iterator();
					int i=0;
					while(it.hasNext()){
						out.println("<label for=\"POST-PHONENUMBER\">Numero"+i+" :</label>");
						out.println("<input id=\"POST-PHONENUMBER\" value=\"" + it.next().getNumber()+ "\" type=\"text\" name=\"phonenumber"+(i++)+"\"><br>");
					}
					
					
					
				}
				out.println("<label for=\"POST-PHONENUMBER\">Nouveau Numero :</label>");
				out.println("<input id=\"POST-PHONENUMBER\" value=\"\" type=\"text\" name=\"newphonenumber\"><br>");
				out.println(" </div>");
				
				out.println("<div>");
				out.println("<input type=\"submit\" value=\"submit\">");
				out.println("<input type=\"reset\" value=\"reset\">");
				out.println(" </div>");
				
				
			}
		%>
	</form>

</body>
</html>