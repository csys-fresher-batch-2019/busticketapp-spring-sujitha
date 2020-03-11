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
<h2>Login</h2>
<br/>
<br/>
<form action="Operators">
Enter Email:<input type="email" name="email"placeholder="email"required/>
<br/>
<br/>
Enter Password:<input type="password" name="password"placeholder="password"  required/>
<br/>
<br/>
<button type="submit" class="btn btn-success">submit</button>
<br>
<br>
</form>
</div>
</body>
</html>