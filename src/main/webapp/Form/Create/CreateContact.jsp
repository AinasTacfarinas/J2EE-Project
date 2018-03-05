<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creer un contact</title>
</head>
<body>
<form action="/J2EE-Project/CreateContact" method="post">

  <div>
	<label for="POST-FIRSTNAME">Prenom :</label>
	<input id="POST-FIRSTNAME" type="text" name="firstname"><br>
  	<label for="POST-LASTNAME">Nom :</label>
  	<input id="POST-LASTNAME" type="text" name="lastname"><br>
  	<label for="POST-EMAIL">E-mail :</label>
  	<input id="POST-EMAIL" type="text" name="email"><br>
  </div>
  	
  <div>
  	<label for="POST-STREET">Rue :</label>
  	<input id="POST-STREET" type="text" name="street"><br>
  	<label for="POST-CITY">Ville :</label>
  	<input id="POST-CITY" type="text" name="city"><br>
  	<label for="POST-COUNTRY">Pays :</label>
  	<input id="POST-COUNTRY" type="text" name="country"><br>
  </div>
  
  <div>
  	<label for="POST-GROUPNAME">Nom de Groupe : </label>
  	<input id="POST-GROUPNAME" type="text" name="groupname"><br>
  </div>
  
   <div>
  	<label for="POST-NUMBER">Numero de telephone :</label>
  	<input id="POST-NUMBER" type="text" name="phonenumber"><br>
  </div>
  
  <div>
    <input type="submit" value="submit">
  	<input type="reset" value="reset">
  </div>
</form>
</body>
</html>