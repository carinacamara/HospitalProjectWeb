<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Consultation</title>
</head>
<body>
	<div align="center">
		<h1>Edit Consultation</h1>
		<form:form action="/Hospital/doctor/saveConsultation" method="POST" modelAttribute="consultation" commandName="consultation">
		
		<table>
			<form:hidden path="idConsultation"/>
			
			<tr>
				<td>ID Doctor:</td>
				<td><form:input path="idDoctor" readonly="true" /><form:errors path="idDoctor" ></form:errors></td>
			</tr>
			<tr>
				<td>ID Patient:</td>
				<td><form:input path="idPatient" /><form:errors path="idPatient" ></form:errors></td>
			</tr>
			<tr>
				<td>Start:</td>
				<td><form:input path="start" readonly="true"/><form:errors path="start" ></form:errors></td>
			</tr>
			<tr>
				<td>Done:</td>
				<td><form:input path="done" /><form:errors path="done" ></form:errors></td>
			</tr>
			
			<tr>
				<td>Observations:</td>
				<td><form:input path="observations" /><form:errors path="observations" ></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
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