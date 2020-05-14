<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Active Remedy</title>
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Kaushan+Script&family=Righteous&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
       rel="stylesheet">
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
  .container{
     width:80%;
     box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
     text-align: center;
     border-radius:25px;
     background-color: white;
     text-align:center;
     margin-top: 20px;
     margin-bottom: 20px;
     background-image: url('/resources/images/b---g.jpg');
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
       margin-bottom: 80px;
         border-top-width: 50px;
         font-family: 'Permanent Marker', cursive;


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

<nav class="navbar navbar-light">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/analyst-home" style="color:darkcyan;">reMedy</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/analyst-home">Home</a></li>
      <li><a href="/analyst-remedy">Remedy List</a></li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<div class="container">
<div class="sub-container">
  <h3>REMEDIES ASSIGNED!!!</h3>
  </div>
  <table class="table table-hover table-primary table-primary ">
  <thead>
  <tr class="table-primary">
  <th>Seat No.</th>
  <th>IP Address</th>
  <th>RemId</th>
  <th>Remedy</th>
  <th>Date</th>
  <th>Close</th>
  <th>Transfer</th>
  </tr>	
  </thead>
  <tbody>
  <c:forEach items="${analystRemedyList}" var="list">
  <tr class="table-info">
  <td>${list.seatNo}</td>
  <td>${list.IPaddress}</td>
  <td>${list.remId}</td>
   <td>${list.remedy}</td>
   <td>${list.remedyDate}</td>
    <td><a href="/analyst-close?remId=${list.remId}" class="btn btn-danger" role="button"  style="background-image: linear-gradient(-90deg, #ccffff, #ffb8ff); color:black;">Close</a></td>
    <td><a href="/get-transfer-remedy?remId=${list.remId}" class="btn btn-danger" role="button"  style="background-image: linear-gradient(-90deg, #ccffff, #ffb8ff); color:black;">Transfer</a></td>
  </tr>
  </c:forEach>
  </tbody>
  </table>
</div>
<footer id="footer" class="container-fluid bg-4 text-center">
  <p>reMedy © Made By Manish</p>
</footer>
</body>
</html>
