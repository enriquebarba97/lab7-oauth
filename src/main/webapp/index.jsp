<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <title>Laboratorio de OAuth</title>
  </head>

  <body>
    <h1>Laboratorio de OAuth</h1>
	
    <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Servlets disponibles:</td>        
      </tr>
      <tr>
        <td><a href="/googleDriveListing">Listado de ficheros de Google Drive</a></td>
      </tr>           
      <tr>
        <td><a href="/editPost.jsp">Crear post en Facebook</a></td>
      </tr>
      <tr>
        <td><a href="/facebookFriendsListing">Listado de amigos en Facebook</a></td>
      </tr>
    </table>
    <h2> Tokens de OAuth </h2>
    <table>
    	<tr><th>Google Drive:<th><td><c:out value='${sessionScope["GoogleDrive-token"]}' />
    	<tr><th>Facebook:<th><td><c:out value='${sessionScope["Facebook-token"]}' />
    </table>
  </body>
</html>
