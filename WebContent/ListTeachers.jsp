<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="dao.Connections" %>
    <%@ page import="model.Teacher" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="dao.TeacherDao" %>
    <% ArrayList<Teacher> teachers = (ArrayList<Teacher>) request.getAttribute("teachers"); %>
    <% ArrayList<Teacher> tfs = (ArrayList<Teacher>) request.getAttribute("teachersFiltered"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professores</title>
</head>
<body>
	<table border="1">
		<caption> Lista de professores na faculdade </caption>
		<tr>
			<th> Nome </th>
		</tr>
		<% for(Teacher t : teachers){ %>
		<tr>
			<td align="center"><a href="DetailTeacher?id=<%= t.getId() %>"><%= t.getName() %></a></td>
		</tr>
		<%} %>
	</table>
	
	<form action="ListTeachersByDegree">
		<table border="1">
			<caption> Pesquisa de professor por Nivel</caption>
			<tr>
				<th> Nivel </th>
			</tr>
			<tr>
				<td> <input type="text" name="degree"></td>
			</tr>
		</table>
		<input type="submit" value="Pesquisar">
	</form>
	
	<% if(request.getAttribute("teachersFiltered") != null){ %>
		<table border="1">
			<tr>
				<th> Nome </th>
			</tr>
			<%for(Teacher t : tfs){ %>
			<tr>
				<td><%= t.getName() %></td>
			</tr>
			<%} %>
		</table>
	<%} %>
</body>
</html>

<!--  Crie  uma  tela  de  consulta  onde  seja  possível  pesquisar 
 os  Professores  por  Titulação,  ou  seja,  exibir  apenas  os  Professores  
 com  determinada  titulação  informada  pelo  usuário -->