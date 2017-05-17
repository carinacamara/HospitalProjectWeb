<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Secretary</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Secretary</h1>
		<form:form action="/Hospital/admin/saveSecretary" method="post" modelAttribute="secretary" commandName="secretary">
		
		<table>
			<form:hidden path="idSecretary"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /><form:errors path="name" ></form:errors></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><form:input path="username" /><form:errors path="username" ></form:errors></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" /><form:errors path="password" ></form:errors></td>
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