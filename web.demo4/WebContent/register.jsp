<%@page import="web.demo4.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<form action="register" method="post">
		Name: <input type= 'text' name= 'name' />
		<br>
		Email: <input type= 'text' name= 'email' />
		<br>
		Phone: <input type= 'number' name= 'phone' />
		<br>
		Batch type : <select name = 'batch'>
						<option value="java">java</option>
						<option value="informatica">informatica</option>
						<option value="cloud">cloud</option>
		</select>
		<br>
		<button type='submit' name = 'regBtn'>Register</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>Name</th><th>Email</th><th>Phone</th><th>Batch</th>
			</tr>
		</thead>
		<tbody>
		<%
		
			List<Student> student = null; 
			student = (List<Student>)request.getAttribute("students");
			
			if(student!=null){
				for(Student s : student){
					out.write("<form action='register' method='get'><tr>");
					out.write("<td><button type='submit'name='del'>Delete<input type = 'hidden' name = 'a' value = '"+s.getName()+"'/></button><button type='submit' name='update'><input type = 'hidden' name = 'b' value = '"+s.getName()+"'/>Edit</button>"+s.getName()+"</td>");
					out.write("<td>"+s.getEmail()+"</td>");
					out.write("<td>"+s.getPhone()+"</td>");
					out.write("<td>"+s.getBatch()+"</td>");
					out.write("</tr></form>");	
				}
			}
		%>
		</tbody>
	</table>
	

</body>
</html>