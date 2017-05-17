<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Manager Home</title>
    </head>
    <body>
    
        You are logged as Secretary.
    
   
    	<div align="center">
	        <h1>Patient List</h1>
	        <h3><a href="newPatient">New Patient</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Address</th>
	        	<th>Identity Card</th>
	        	<th>CNP</th>
	        	<th>Action</th>
	        	
				<c:forEach var="patient" items="${listPatient}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${patient.name}</td>
					<td>${patient.address}</td>
					<td>${patient.identityCard}</td>
					<td>${patient.CNP}</td>
					<td>
						<a href="editPatient?idPatient=${patient.idPatient}">Edit</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
	
			</form>
			
			<form action="/Hospital/logout" method="post">
			<input type="submit" class="button red big" value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
    
    	</div>
    </body>
</html>