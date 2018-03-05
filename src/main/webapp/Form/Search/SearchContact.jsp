<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.tac.entity.Contact" %>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chercher contact</title>
</head>
<body>
	<form action="/J2EE-Project/SearchContact" method="post">

  <div>
	<label for="POST-SEARCH">Chercher :</label>
	<input id="POST-SEARCH" type="text" name="searchcontact"><br>
  </div>
  	
  <div>
    <input type="submit" value="submit">
  	<input type="reset" value="reset">
  </div>
  

  
  <%
  	ArrayList<Contact> l  = (ArrayList<Contact>)request.getAttribute("contactlist");
  
  	if(l!=null){
  		Contact c;
  		for(int i=0;i<l.size();i++){
  			c = l.get(i);
  			out.println("<label for=\"POST-uname"+i+"\">"+c.getFirstName()+" "+c.getLastName()+"</label>");
  	  		out.println("<input type=\"submit\" value=\"Modifier\" name=\"modif."+i+"\">");
  	  		out.println("<input type=\"submit\" value=\"Supprimer\" name=\"supr."+i+"\"><br>");	
  		}
  	}
  	
  %>
  
  </form>

</body>
</html>