<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secretary Manager Home</title>
    </head>
    <body>
    
        You are logged as Admin.
    
   
    	<div align="center">
	        <h1>Secretary List</h1>
	        <h3><a href="newSecretary">New Secretary</a></h3>
	        <table border="1">
	        	<th>ID</th>
	        	<th>Name</th>
	        	<th>Username</th>
	        	<th>Password</th>
	        	<th>Action</th>
	        	
				<c:forEach var="secretary" items="${listSecretary}">
	        	<tr>
	        		<td>${secretary.idSecretary}</td>
					<td>${secretary.name}</td>
					<td>${secretary.username}</td>
					<td>${secretary.password}</td>
					<td>
						<a href="editSecretary?idSecretary=${secretary.idSecretary}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteSecretary?idSecretary=${secretary.idSecretary}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
			<a href="/Hospital/admin/listDoctor">See Doctors</a>
			</form>
			
			<form action="/Hospital/logout" method="post">
			<input type="submit" class="button red big" value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
    
    	</div>
    </body>
</html>