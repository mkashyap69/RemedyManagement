<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Update Remedy</title>
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Kaushan+Script&family=Righteous&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
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
   height:500px;
   width:50%;
   box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
     text-align: center;
     border-radius:25px;
     background-color: white;
     text-align:center;
     margin-top: 20px;
     margin-bottom: 20px;
     background-image: url('/resources/images/b-g.jpg');
  background-size: cover;
   }
   body{

  background: -webkit-linear-gradient(left, rgba(0,168,255,0.5), rgba(185,0,255,0.5));


}

footer{
 background: -webkit-linear-gradient(left, rgba(0,168,255,0.5), rgba(185,0,255,0.5));
}
   h3{
     color: snow;
       margin-bottom: 120px;
         border-top-width: 50px;
         font-family: 'Permanent Marker', cursive;
         font-size:40px;


   }
   .sub-container{
     position: relative;
   top: 50px
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
</head>
<body>
<nav class="navbar navbar-light" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/admin-home"  style="color:darkcyan;">reMedy</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/admin-home">Home</a></li>
      <li><a href="/admin-remedy">Remedy List</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<div class="container">
<div class="sub-container">
 <h3>Update the category!!!</h3>
 </div>
 <form action="/update-remedy" method="post" >
  <div class="form-group">
  <label name="category">Category</label>
  <select  class="form-control" name="category" required="true">
  <option value="Network">Network</option>
  <option value="Leave">Leave</option>
   <option value="Travel">Travel</option>
    <option value="Software Installation">Software Installation</option>
     <option value="Desktop">Desktop</option>
     <option value="Laptop">Laptop</option>
      <option value="Management Portal">Management Portal</option>

  </select>
  </div>
  <input type="submit" name="Submit" class="btn btn-primary" style="background-image: linear-gradient(-90deg, #ccffff, #ffb8ff); color:black;">
  </form>
  </div>
  
<footer id="footer" class="container-fluid bg-4 text-center">
  <p>reMedy © Made By Manish</p>
</footer>
</body>
</html>