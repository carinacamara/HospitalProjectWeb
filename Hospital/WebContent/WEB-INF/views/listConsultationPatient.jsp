<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultations</title>
    </head>
    <body>
    
        You are logged as Doctor.
    
   
    	<div align="center">
	        <h1>Consultation List</h1>
	        <table border="1">
	        	<th>ID</th>
	        	<th>ID Doctor</th>
	        	<th>ID Patient</th>
	        	<th>Start</th>
	        	<th>Done</th>
	        	<th>Observations</th>
	        	<th>Action</th>
	        	
				<c:forEach var="consultation" items="${listConsultation}">
	        	<tr>
	        		<td>${consultation.idConsultation}</td>
					<td>${consultation.idDoctor}</td>
					<td>${consultation.idPatient}</td>
					<td>${consultation.start}</td>
					<td>${consultation.done}</td>
					<td>${consultation.observations}</td>
					<td>
						<a href="editConsultation?idConsultation=${consultation.idConsultation}">Edit</a>
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