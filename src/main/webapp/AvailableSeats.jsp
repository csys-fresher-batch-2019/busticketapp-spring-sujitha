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
<%
Integer seat=(Integer)request.getAttribute("seatno");
%>
<button type="button" class="btn btn-info" value ="seat">1 </button>
<button type="button" class="btn btn-info" value ="seat">3</button>
<button type="button" class="btn btn-info" value ="seat">5</button>
<button type="button" class="btn btn-info" value ="seat">7</button>
<button type="button" class="btn btn-info" value ="seat">9</button>
<br>
<br>
<button type="button" class="btn btn-info" value ="seat">2</button>
<button type="button" class="btn btn-info" value ="seat">4</button>
<button type="button" class="btn btn-info" value ="seat">6</button>
<button type="button" class="btn btn-info" value ="seat">8</button>
<button type="button" class="btn btn-info" value ="seat">10</button>


<button type="button" class="btn btn-primary" disabled>Disabled Primary</button>
</body>
</html>