<%@page import="crud_operation_using_hibernate_servlet_jsp.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="crud_operation_using_hibernate_servlet_jsp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>

<title>Display</title>
</head>
<body>
	<%
	UserDao dao=new UserDao();
	List<User> user = dao.displyAllUser();
	%>
	<h1 align="center">Person Information</h1>
	<div align="center"
		style="margin-bottom: 20px; width: 30%; display: flex; justify-content: center; margin-left: 500px;">
		<form action="saveUser" method="post" style="">
			<input type="text" name="name" class="form-control form-control-sm"
				placeholder="Name" required><br> <br> <input
				type="text" name="address" class="form-control form-control-sm"
				placeholder="Address" required><br> <br> <input
				type="tel" name="phone" class="form-control form-control-sm"
				placeholder="Phone" required><br> <br> <input
				type="submit" class="btn btn-primary" value="Add Person">
		</form>
	</div>
	<div style="width: 1500px; margin-left: 20px; margin-right: 20px" align="center">
	<table class="table table-striped table-dark">
		<thead>
			<tr align="center">
				<th>Sr.</th>
				<th>Name</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
			int ct = 1;
			for (User b : user) {
		%>
		<tbody align="center">
			<tr>
				<td><%=ct++%></td>
				<td><%=b.getName()%></td>
				<td><%=b.getAddress()%></td>
				<td><%=b.getPhone()%></td>

				<td><a href="update?id=<%=b.getId()%>"><button
							class="btn btn-warning">Update</button></a> <a
					href="delete?id=<%=b.getId()%>"><button class="btn btn-danger">Delete</button></a>
				</td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	</div>
</body>
</html>