<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="jquery-1.11.3.min.js"></script>
  </head>
<body>
<!-- <h1>The onclick Event</h1>

<p>The onclick event is used to trigger a function when an element is clicked on.</p>

<p>Click the button to trigger a function that will output "Hello World" in a p element with id="demo".</p>

<button onclick="myFunction()">Click me</button>

<p id="demo"></p>

<script>
function myFunction() {
  document.getElementById("demo").innerHTML = "Hello World";
}
</script>
Field1: <input type="number" id="field1" value=800><br>
Field2: <input type="number" id="field2"><br><br>

<button onclick="myFunction()">Copy Text</button>

<p>A function is triggered when the button is clicked. The function copies the text from Field1 into Field2.</p>

<script>
function myFunction() {
  document.getElementById("field2").value = document.getElementById("field1").value;
}
</script>
<button  id="field1"  value="800"onclick="myFunction()"></button>
<button id="field2"  onclick="myFunction()"></button>

<p id="demo"></p>

<script>
function myFunction() {
	document.getElementById("field2").value = document.getElementById("field1").value;
	document.getElementById("demo").innerHTML = "Hello World"
}
</script> -->
<div class="display">

 <button type="button">0</button>

<button type="button">1</button>

<button type="button">2</button>

<button type="button">3</button>

<button type="button">4</button>

<button type="button">5</button>

<button type="button">6</button>

<button type="button">7</button>

<button type="button">8</button>

<button type="button">9</button>



 <div class = "operators">
 <button type="button">+</button>
 <button type="button">-</button>
 <button type="button">*</button>
 <button type="button">/</button>
 <button type="button">=</button>
 <button type="button">clear</button>


<script>
$('button').on('click', function(){
    var i = $(this).text();
    var display = $('.display');

    display.text( display.text() + i );
});
</script>
</div>
</div>
<button onClick={this.showOffline} id='offline'>Offline</button>

  <script type="text/javascript">
  showOffline(){  
	   this.props.offline()    
	  }
  showOffline(e){  
    console.log(e.target.id)
   this.props.offline()    
  }
  </script>
</body>
</html>
