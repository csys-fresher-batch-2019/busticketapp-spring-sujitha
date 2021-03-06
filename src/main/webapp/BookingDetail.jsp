<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h3> Book Ticket</h3>
<%
HttpSession sess=request.getSession(false);
String bus_no=request.getParameter("busNo");
Integer user_id=(Integer)sess.getAttribute("userid");
LocalDate date=(LocalDate)sess.getAttribute("date");
LocalDate today = LocalDate.now();
%>
<form action="BusBooking">
Number Of Tickets:<input type="number" name="numberofseats"value="numberofseats" required/>
<br>
<br>
Date:<input type="date" id="date" name="date" value="<%=date%>" readonly  required>
<br>
<br>
Gender 
<input type="radio" name="gender" value="M">male 
<input type="radio" name="gender" value="F">female
<br>
<br>
Select preferences:
<select name="preferences">
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
<br>
<br>
<button type="submit" class="btn btn-success">submit</button>
<br>
<br>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red"style="font: bold"><%=errorMessage%>
<%}%>
<input type="hidden" name="userid"value="<%=user_id %>" readonly required/>
<br>
<br>
<input type="hidden" name="busnumber"value="<%=bus_no%>" readonly required/>
<br>
<br>

</form>
</div>
</body>
</html>