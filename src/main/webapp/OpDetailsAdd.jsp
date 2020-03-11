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
<form action="OpDetailsAdd">
<br>
<br>
Enter Name:<input type="text" name="name"required/>
<br>
<br>
<br>
<br>
Enter Email:<input type="text" name="email" required/>
<br>
<br>
<br>
<br>
Enter Mobile Number:<input type="number" name="number" required/>
<br>
<br>
<br>
<br>
Enter Password:<input type="text" name="password"required/>
<br>
<br>
<button type="submit">submit</button>
<br>
<br>
</form>
</div>
</body>
</html>