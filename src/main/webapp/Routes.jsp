<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.busticketapp.domain.BusRoutes" %>   
<%@ page import="com.chainsys.busticketapp.dao.BusRoutesDAO"%> 
<%@ page import="com.chainsys.busticketapp.dao.impl.BusRoutesDAOImpl" %> 
<%@ page import="java.util.List" %>  
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Select Locations</h2>
<br>
<br>
<form action="DisplayBusList">
<%
	BusRoutesDAOImpl bri= new BusRoutesDAOImpl();
List<BusRoutes> fromlocation=bri.findFromLocation();
%>

<%
	BusRoutesDAOImpl br= new BusRoutesDAOImpl();
List<BusRoutes> tolocation=br.findToLocations();
%>

Select From Location:<input type="text"  name="FromLocation" list="fromlocationlist" required>
<datalist id="fromlocationlist">
<%
for(BusRoutes s:fromlocation){
	%>
	<option value ="<%=s.getFromLocation() %>"><%=s.getFromLocation() %> </option>
	<%}
%>
</datalist>
<br/>
<br/>
Select To Location:<input type="text" name="ToLocation" list="tolocationlist" required>
<datalist id ="tolocationlist">
<%
for(BusRoutes d:tolocation){
	%>
	<option value ="<%=d.getToLocation() %>"><%=d.getToLocation() %> </option>
	<%}
%>
<br>
<br>
</datalist>
<br/>
<br/>
Enter Date:<input type="date" name="date" id="date"required>
<br/>
<br/>
<button type="submit">submit</button>
<br>
<br>
<script>
function setTodayDate(){
var today = new Date();
console.log(today);
var dateStr  = today.toJSON().substr(0,10); //toJSON returns "2020-02-20T09:32:45.644Z" ( get only date)
console.log(dateStr);
$("#date").val(dateStr);
$("#date").attr("min", dateStr);
}
setTodayDate();
</script>
</form>
</body>
</html>