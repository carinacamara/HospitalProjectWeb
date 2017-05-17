<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Find Doctor</title>
</head>
<body>
<div align="center">
	<h1>Find Doctor</h1>
    <form:form action="/Hospital/doctor/listConsultationPatient" method="POST">
    
    <table>
    <tr>
     <td>  ID Patient:
       <input name="idPatient" type="text" /><form:errors path="idPatient" ></form:errors>
       </td>
       </tr>
     
         <tr>
     <td> 
        <input type="submit" value="Find"/>
         </td>
       </tr> 
        
         </table>
    </form:form>
    
    
    
			<form action="/Hospital/logout" method="post">
			<input type="submit" class="button red big" value="Sign Out" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
    </div>
</body>
</html>