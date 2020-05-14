<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Kaushan+Script&family=Righteous&display=swap" rel="stylesheet">
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
       rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <title>Welcome to Remedy</title>
  <style >
 .container{
height:500px;
width:500px;
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

.sub-container{
  position: relative;
top: 50px
}

h1{
  color: snow;
    margin-bottom: 150px;
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
.form-control{
  border-radius:10px;
  }
  </style>
  </head>
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
    </ul>
  </div>
</nav>
<div class="container">


  <div class="sub-container">

  <h1>REGISTER !</h1>
  </div>
    <div class="form-group">
    <form class="index-form" action="/" method="post">
      <select class="form-control"  name="role">
        <label for="role">Choose the role assigned:-</label>
          <option value="None">---None---</option>
        <option value="User">User</option>
        <option value="Admin">Admin</option>
        <option value="Analyst">Analyst</option>
      </select>
  </div>
    <input class="btn btn-primary" type="submit" name="Register" value="Register" style="background-image: linear-gradient(-90deg, #ccffff, #ffb8ff); margin-right: 30px; margin-right: 30px; color:black;">
  </form>
<a href="/login" role="button" class="btn btn-info" style="background-image: linear-gradient(-90deg, #ccffff, #ffb8ff); color:black;">User Login</a>

</div>

<footer  class="container-fluid bg-4 text-center">
  <p>reMedy © Made By Manish</p>
</footer>
  </body>
</html>
