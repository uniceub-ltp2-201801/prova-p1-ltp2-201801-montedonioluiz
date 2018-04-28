<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="model.Teacher" %>
 <%@ page import="model.Course" %>
 <%@ page import="java.util.ArrayList" %>
 <% Teacher t = (Teacher) request.getAttribute("teacher"); %>
 <% ArrayList<Course> cs = (ArrayList<Course>) request.getAttribute("courses"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes Professor</title>
</head>
<body>
	<table border="1">
		<caption> Detalhes</caption>
		<tr>
			<th> Código </th>
			<th> Nome </th>
			<th> Nome da Mãe </th>
			<th> Data de Nascimento </th>
			<th> Titulação </th>
		</tr>
		<tr>
			<td align="center"> <%= t.getId() %></td>
			<td align="center"> <%= t.getName() %></td>
			<td align="center"> <%= t.getMomName() %></td>
			<td align="center"> <%= t.getDob() %></td>
			<td align="center"> <%= request.getAttribute("degree") %></td>
		</tr><!-- int id, int degree, String name, String momname, LocalDate dob) { -->
	</table>
	<table border="1">
		<caption> Disciplinas </caption> <!-- int id, int hours, int teacherid, String name, String major -->
		<tr>
			<th> Nome </th>
			<th> Apagar? </th>
		</tr>
		<%for(Course c : cs){ %>
		<tr>
			<td align="center"> <%= c.getName() %></td>
			<td align="center"> <a href="DeleteCourse?id=<%= c.getId()%>"> Apagar</a> </td>
		</tr>
		<% } %>
	</table>
	<form action="AddCourse">
		<table>
			<caption> Adicionar Disciplinas Ao Professor</caption>
			<tr>
				<th>Nome</th>
				<th>Curso</th>
				<th>Carga Horaria</th>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="major"></td>
				<td><input type="number" name="hours"></td>
			</tr>
		</table>
		<input type="submit" value="Criar">
		<input type="hidden" name="teacherId" value="<%= t.getId() %>">
	</form>
</body>
</html>