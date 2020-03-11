<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div id="container">

<h2>Login</h2>
<br/>
<br/>
<form action="LoginDetails">
Enter Mobile Number:<input type="number" name="phonenumber"placeholder="phonenumber"required/>
<br/>
<br/>
Enter Password:<input type="password" name="password"placeholder="password" minlength="8" required/>
<br/>
<br/>
<button type="submit" class="btn btn-success">submit</button>
<br>
<br>
<a href ="Registration.jsp" class="btn btn-primary">Create New Account</a>

</form>
</div>
</body>
</html>