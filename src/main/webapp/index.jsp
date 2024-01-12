<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Validar</title>
	</head>

<body>
   <form action="ValidadorServlet" method="post">
   		Usuario: <input type="text" name="usuario"/><BR/>
   		Contraseña: <input type="password" name="password"/><BR/>
   		<input type="submit" value="Enviar"/>
   </form>
 
</body>
</html>