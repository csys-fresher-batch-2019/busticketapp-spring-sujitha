<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.chainsys.busticketapp.dao.UserDetailsDAO" %>
        <%@ page import="com.chainsys.busticketapp.dao.impl.UserDetailsDAOImpl" %>
        <%@ page import="com.chainsys.busticketapp.dto.Users" %>
            <%@ page import="java.util.List" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="container">
<%
UserDetailsDAO user=new  UserDetailsDAOImpl();
List<Users> list =  (List<Users>)request.getAttribute("View_list");
%>
<table class="table table-bordered"> 
 <thead >
 <tr>
 <th>Name</th>
 <th>MobileNumber</th>
 <th>Gender</th>
 <th>SeatNo</th>
 </tr>
 </thead>
 <%
 if ( list != null){
 for(Users u:list){
 %><tr>
 <td><%=u.getUserName() %></td>
 <td><%=u.getUserPhnNum()%></td>
 <td><%=u.getUserGender()%></td>
 <td><%=u.getSeatNo() %></td>
 <%}}%>
 </tr>
 </table>
 
</body>
</html>