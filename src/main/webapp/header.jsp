<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">BusTicketApp</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

<%
Integer userId = (Integer)session.getAttribute("userid");
%>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
     
      <li class="nav-item">
        <a class="nav-link" href="DisplayBookedUserDetails">My Tickets</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Admin.jsp">Admin</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Operators.jsp">Operators</a>
      </li>
      
      </ul>     
       <ul class="navbar-nav mr-auto">
      <% if ( userId == null){ %>
      <li class="nav-item">
        <a class="nav-link" href="Login.jsp">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Registration.jsp">Register</a>
      </li>
      <%}else{ %>
       <li class="nav-item">
        <a class="nav-link" href="">Welcome <%=userId %> !!!</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Search.jsp">Search</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Logout</a>
      </li>
      <%} %>
      
      </ul>     
  </div>
</nav>
</header>