<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl" %>
    <%@ page import="com.chainsys.busticketapp.dto.Buses" %>
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
OperatorsDetailsDAOImpl od=new OperatorsDetailsDAOImpl();
List<Buses> list =  (List<Buses>)request.getAttribute("Op_list");
%>
<table class="table table-bordered"> 
 <thead >
 <tr>
 <th>BusName</th>
 <th>TotalSeats</th>
 <th>SeatType</th>
 <th>Model</th>
 <th>StartTime</th>
 <th>EndTime</th>
 <th>Fare</th>
 <th>Ratings</th>
 <th>Available Seats</th>
 <th></th>
 </tr>
 </thead>
 <%
 if ( list != null){
 for(Buses b:list){
 %><tr>
 
 <td><%=b.getBusName() %></td>
 <td><%=b.getNoOfSeats()%></td>
 <td><%=b.getSeatType() %></td>
 <td><%=b.getBusModel() %></td>
 <td><%=b.getStartTime()%></td>
 <td><%=b.getEndTime() %></td>
 <td><%=b.getFair() %></td>
 <td><%=b.getRatings()%></td>
 <td><%=b.getAvailableSeats()%></td>
<td><a href="BookingDetail.jsp?busNo=<%=b.getBusNum() %>" class="btn btn-success">Book</a></td>

 </tr><% 
 HttpSession sess=request.getSession();
 sess.setAttribute("busNo",b.getBusNum());
 sess.setAttribute("amount",b.getFair());
}}%>
</tr>

</table>
</form>
</body>
</html>