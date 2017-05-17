<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Patient</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Patient</h1>
		<form:form action="/Hospital/secretary/savePatient" method="POST" modelAttribute="patient" commandName="patient">
		
		<table>
			<form:hidden path="idPatient"/>
			
			<tr>
				<td>Identity Card:</td>
				<td><form:input path="identityCard" /><form:errors path="identityCard" ></form:errors></td>
			</tr>
			<tr>
				<td>CNP:</td>
				<td><form:input path="CNP" /><form:errors path="CNP" ></form:errors></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /><form:errors path="name" ></form:errors></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /><form:errors path="address" ></form:errors></td>
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