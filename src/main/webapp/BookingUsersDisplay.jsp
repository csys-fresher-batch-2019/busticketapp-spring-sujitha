<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.busticketapp.domain.Booking"%>
    <%@ page import="com.chainsys.busticketapp.domain.TicketBooking"%>
<%@ page import="com.chainsys.busticketapp.dao.TicketBookingDAO"%> 
<%@ page import="com.chainsys.busticketapp.dao.impl.TicketBookingDAOImpl" %> 
<%@ page import="java.util.List" %>  
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div id="container">

<h3>My Tickets</h3>
<form action="">



<% 
TicketBookingDAOImpl tb= new TicketBookingDAOImpl();
List<Booking> list=(List<Booking>)request.getAttribute("users_display");
%>
<br>
 <br>
 <table class="table table-bordered"> 
 <thead>
 <tr>
 <th>BookingId</th>
 <th>UserId</th>
 <th>BusNumber</th>
 <th>Gender</th>
 <th>seats</th>
 <th>Journey Date</th>
 <th>Preferences</th>
 <th>Booked Date</th>
 <th>Status</th>
 <th>Amount</th>
 </tr>
 </thead>
 
 <%
 LocalDate d=LocalDate.now();
for(Booking b:list){
 %><tr>
 <td><%=b.getBookingId() %></td>
 <td><%=b.getUserId() %></td>
 <td><%=b.getBusNum() %></td>
 <td><%=b.getUserGender() %></td>
 <td><%=b.getSeatNo() %></td>
 <td><%=b.getBookedDate() %></td>
 <td><%=b.getGenderPreference() %></td>
 <td><%=b.getCreatedDate() %></td>
 <td><%=b.getStatus() %></td>
 <td><%=b.getAmount() %></td>
 <% if ( b.getStatus().equals("BOOKED") &&( b.getBookedDate().isAfter(d)|| b.getBookedDate().isEqual(d))) { %>
 <td>
 <a href="CancelTicketServlet?bookingId=<%= b.getBookingId() %>" class="btn btn-danger"> Cancel </a></td>
 <%}
 

 
 
 %>
 <% }%>
 </table>
 </form>
 </div>
</body>
</html>