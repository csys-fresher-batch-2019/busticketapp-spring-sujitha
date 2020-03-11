<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
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
<input type="hidden" name="userid"value="<%=user_id %>" readonly required/>
<br>
<br>
Enter Bus Number:<input type="text" name="busnumber"value="<%=bus_no%>" readonly required/>
<br>
<br>
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
</div>
</body>
</html>