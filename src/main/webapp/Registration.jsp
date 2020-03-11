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

<div id="container">
<div class="row">
<div class="col">
<h3>Registration</h3>
<form action="Registration">

Enter Name:<input type="text" name="name"placeholder="Enter name" required autofocus/>
<br/>
<br/>
Gender 
<input type="radio" name="gender" value="M">male
<input type="radio" name="gender" value="F">female
<br/>
<br/>
Enter Mobile No:<input type="number" name="mobileno"required/>
<br/>
<br/>
Enter Password:<input type="password" name="password"placeholder="password" minlength="8" required/>
<br/>
<br/>
<button type="submit">submit</button>
<br>
<br>
<a href ="Login.jsp">Login</a>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red"style="font: bold"><%=errorMessage%>
<%}%>

</form>
</div>
</div>


</div>
</body>
</html>