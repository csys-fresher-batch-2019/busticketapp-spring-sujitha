<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl" %>
    <%@ page import="com.chainsys.busticketapp.domain.OperatorsDetails"%>
        <%@ page import="com.chainsys.busticketapp.dto.Buses"%>
    
    <%@ page import="java.util.List" %>  
        <%@ page import="java.util.ArrayList" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Operators List</h2>
<div id="container">
<%
OperatorsDetailsDAOImpl od= new OperatorsDetailsDAOImpl();
Buses b=new Buses();
List<Buses> list = (List<Buses>)request.getAttribute("op_list");
%>
<br>
 <br>
 <table class="table table-bordered"> 
 <thead >
 <tr>
<th>Operators
 </th>
 </tr>
 </thead>
  <%
for(Buses b1:list){
 %><tr>
 <td><%=b1.getOpName()%></td>
 <td><a href="OpBusDisplay?OperatorName=<%=b1.getOpName()%>" class="btn btn-success">Search</a></td>
 <%} %>
 </table>
 </div>
</body>
</html>