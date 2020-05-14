<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Kaushan+Script&family=Righteous&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
       rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
   src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

<!--  <script>
   $('#dob').datepicker({
     format : 'yyyy/MM/dd'
   });
 </script> -->
	
    <title>Registration Form</title>
  </head>
  <style>
.form-control{
 
  border-radius:10px;
  }
    .container{
       width: 50%;
    height: 1200px;
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
   body{

  background: -webkit-linear-gradient(left, rgba(0,168,255,0.5), rgba(185,0,255,0.5));



}

footer{
 background: -webkit-linear-gradient(left, rgba(0,168,255,0.5), rgba(185,0,255,0.5));
}
    .sub-container{
      position: relative;
    top: 50px
    }
    h2{
      color: snow;
        margin-bottom: 80px;
          border-top-width: 50px;
          font-family: 'Permanent Marker', cursive;


    }
     .btn-primary{
      position: relative;
    left:0px;
    }
    .dropdown{
    margin-bottom:35px;
    }
    h1{
      color: darkcyan;
    }

    .errors{
    color:red;
    font-size:15px;
    font-family: "Lucida Console", Courier, monospace;
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

  </style>
  <body>

    <nav class="navbar navbar-light" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/" style="color:darkcyan;">reMedy</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Role</a>
        <ul class="dropdown-menu">
          <li><a href="/user-reg">User</a></li>
          <li><a href="/sa-reg">Analyst</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
    <div class="container">

        <div class="sub-container">
      <h2>WELCOME ! Enter the following details </h2>
      </div>
        <form:form class="reg" action="/user-reg" method="post" modelAttribute="details">
     <div class="form-group">
 <%--  <form:label path="firstName">First Name</form:label> --%>
  <form:input  class="form-control" type="text" path="firstName"  placeholder="First Name" />
  <form:errors path="firstName" cssClass="errors"></form:errors>
</div>
<div class="form-group">

  <form:input  class="form-control" type="text" path="lastName" placeholder="Last Name" />
  <form:errors path="lastName" cssClass="errors"></form:errors>
</div>
<div class="form-group">

  <form:input class="form-control" type="text" path="contact" placeholder="Contact Number"/>
  <form:errors path="contact" cssClass="errors"></form:errors>
</div>

<div class="form-group">
<%--   <form:label path="password">Password</form:label> --%>
  <form:input class="form-control"  type="password" path="password" placeholder="Password"/>
  <form:errors path="password" cssClass="errors"></form:errors>
</div>
<div class="form-group">
  <%-- <form:label path="dob">DOB</form:label> --%>
  <form:input class="form-control" type="date" path="dob" placeholder="DOB" required="true"/><br>
  <p>${errormessage}</p>
  
</div>
<div class="form-group">

  <form:select class="form-control" path="gender" placeholder="Gender">
  <form:option value="Male">Male</form:option>
  <form:option value="Female">Female</form:option>
  </form:select>

</div>
<div class="form-group">
<%--   <form:label path="level">Support Level</form:label> --%>
  <form:select class="form-control" path="level" placeholder="Support Level" readonly="true">
    <form:option value="none">USER</form:option>
  </form:select>
</div>

<input type="submit" name="Register"  value="Register" class="btn btn-primary" style="background-image: linear-gradient(-90deg, #ccffff, #ffb8ff); color:black;">
</form:form>
</div>


<footer id="footer" class="container-fluid bg-4 text-center">
  <p>reMedy © Made By Manish</p>
</footer>
  </body>
</html>
