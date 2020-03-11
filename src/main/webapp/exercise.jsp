<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>BusApp</h2>
<h3>Registration</h3>
<form action="next.jsp">
Enter Name:<input type="text" name="name"placeholder="Enter name" required autofocus/>
<br/>
Enter Email:<input type="text" name="email"placeholder="email"required/>
<br/>
Enter Password:<input type="password" name="password"placeholder="password" required/>
<br/>
Enter Date of Birth:<input type="date" name="dob" required min="2000-01-01" max="2020-02-03" required>
<br/>
Enter Mobile No:<input type="number" name="mobile no" required/>
<br/>
Gender 
<input type="radio" name="gender" value="M">male
<input type="radio" name="gender" value="F">female
<br/>
Hobbbies
<input type="checkbox" name="hobbies" value="cricket">cricket

<input type="checkbox" name="hobbies" value="football">football
<br/>
Select Movie
<select name="movie">
<option value="darbar">Darbar</option>
<option value="sarkar">sarkar</option>
</select>
Display Movies:
<table border="1">
<thead><tr><th>#</th> <th>Movie Name </th> </tr>
<tbody>
<tr><td>1</td> <td>Darbar </td></tr>
<tr><td>2</td> <td>Sarkar </td></tr>
</tbody>
</table>

<image src="assets/images/images.jpg" width="100" height="100" alt="Darbar">
<br/>
<style>

body {
  background-image: url('assets/images/images.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>

</style>
<button type="submit">submit</button>
</body>
</html>