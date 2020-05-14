<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Remedy</title>
  <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Kaushan+Script&family=Righteous&display=swap" rel="stylesheet">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
       rel="stylesheet">
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

  <style>
  .form-control{

  border-radius:10px;
  }
    .container{
   height:1300px;
   width:50%;
     box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
     text-align: center;
     border-radius:25px;
     background-color: white;
     text-align:center;
     margin-top: 20px;
     margin-bottom: 20px;
     width: 500px;
     background-image: url('/resources/images/b-g.jpg');
  background-size: cover;
   }
   .sub-container{
     position: relative;
   top: 50px
   }
   body{

  background: -webkit-linear-gradient(left, rgba(0,168,255,0.5), rgba(185,0,255,0.5));

}

footer{
 background: -webkit-linear-gradient(left, rgba(0,168,255,0.5), rgba(185,0,255,0.5));
}

    h1{
      color: snow;
        margin-bottom: 120px;
          border-top-width: 50px;
          font-family: 'Permanent Marker', cursive;


    }
.bg-4 {
  background-color: aliceblue;
  color: darkcyan;
  font-family: 'Permanent Marker', cursive;
  font-size: 20px;
}
.navbar-brand{
  font-family: 'Permanent Marker', cursive;
  font-size: 25px;

}
.navbar-nav{
  font-family: 'Righteous', cursive;
}
.form-group{
  margin-bottom:50px;
}

.errors{
color:red;

}
</style>
</head>
<body>
<nav class="navbar navbar-light">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/user-home" style="color:darkcyan;">reMedy</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/user-home">Home</a></li>
      <li><a href="/add-remedy">Add Remedy</a></li>
      <li><a href="/active-remedy">Acitve Remedies</a></li>
      <li><a href="/history">History</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<div class="container">
  <div class="sub-container">
    <h1>Enter the following details</h1>
 </div>

 <form:form action="/add-remedy" method="post" modelAttribute="list">
 <div class="form-group">
  <form:label path="userId">User Id :-</form:label>
 <form:input class="form-control" type="number" value="${userId}" path="userId" readonly="true"/>
 </div>
 <div class="form-group">
<%--  <form:label path="userName">User Name:-</form:label> --%>
 <form:input class="form-control" type="text" path="userName" placeholder="User Name"/>
 <form:errors path="userName" cssClass="errors"></form:errors>
 </div>
 <div class="form-group">
 
  <form:select  class="form-control" path="category">
  <form:option value="Network">Network</form:option>
  <form:option value="Leave">Leave</form:option>
   <form:option value="Travel">Travel</form:option>
    <form:option value="Software Installation">Software Installation</form:option>
     <form:option value="Desktop">Desktop</form:option>
     <form:option value="Laptop">Laptop</form:option>
      <form:option value="Management Portal">Management Portal</form:option>
  <form:errors path="category" cssClass="errors"></form:errors>
  </form:select>
  </div>
 <div class="form-group">
<%--  <form:label path="remedy">Issue(Limit: 500 words)</form:label> --%>
 <form:textarea  type="text" path="remedy" class="form-control" rows="10" cols="50" placeholder="Issue(Limit: 500 words)"/>
 <form:errors path="remedy" cssClass="errors"></form:errors>
 </div>
 <div class="form-group">
  <form:label path="remedyActive">Active</form:label>
  <form:checkbox  path="remedyActive"/>
  </div>
  <div class="form-group">
<%--  <form:label path="seatNo">Seat No</form:label> --%>
 <form:input class="form-control" type="number" path="seatNo"  placeholder="Enter your Seat No."/>
  <form:errors path="seatNo" cssClass="errors"></form:errors>
 </div>
 <div class="form-group">
<%--  <form:label path="IPaddress">IP Address</form:label> --%>
 <form:input class="form-control" type="text" path="IPaddress" placeholder="IP Address"/>
  <form:errors path="IPaddress" cssClass="errors"></form:errors>
 </div>
			<input type="submit" name="Submit" value="SUBMIT" class="btn btn-primary"
				style="background-image: linear-gradient(-90deg, #ccffff, #ffb8ff); color: black;">
		</form:form>
  </div>
<footer id="footer" class="container-fluid bg-4 text-center">
  <p>reMedy © Made By Manish</p>
</footer>
</body>
</html>
