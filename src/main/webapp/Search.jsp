<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Search By</h2>
<br>
<h5>BusName</h5>
<a href ="BusName.jsp">Search</a> 

<br>
<h5>Location</h5>
<a href ="Routes.jsp">Location</a> 

<br>
<h5>Fare</h5>
<a href ="MaxFareser">Max</a> 
<a href ="MinFareSer">Min</a> 
<br>
<h5>Bus Model</h5>
 <a href="Ac.jsp">Ac</a></td>
 <a href="NonAc.jsp">Non-Ac</a></td>
<br>
<h5>Ratings</h5>
 <a href="HighRatingServ"> High</a></td>
 <a href="LowRatingServ"> Low</a></td>
 <br>
 <h5>Operators</h5>
  <a href="OpDetailsDisplay"> Operators</a></td>
 

</body>
</html>