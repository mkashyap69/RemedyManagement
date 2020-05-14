<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Active Remedy</title>
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Kaushan+Script&family=Righteous&display=swap" rel="stylesheet">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
.bg-4 {
  background-color: aliceblue;
  color: darkcyan;
  font-family: 'Permanent Marker', cursive;
  font-size: 20px;
}
.navbar-brand{
  font-family: 'Kaushan Script', cursive;
  font-size: 25px;
}
.navbar-nav{
  font-family: 'Righteous', cursive;
}

</style>
</head>
<body>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/user-home">reMedy</a>
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
  <h3>Here is the history of your active remedies:-</h3>
  <table class="table table-hover table-striped ">
  <thead>
  <tr class="table-primary">
  <th>RemId</th>
  <th>Remedy</th>
  <th>Date Of Issue</th>
  <th>Delete</th>
  <th>Reopen</th>
  </tr>	
  </thead>
  <tbody>
  <c:forEach items="${historyRemedyList}" var="list">
  <tr class="table-info">
  <td>${list.remId}</td>
   <td>${list.remedy}</td>
   <td>${list.remedyDate}</td>
    <td><a href="/delete?remId=${list.remId}" class="btn btn-danger" role="button">Delete</a></td>
        <td><a href="/reopen?remId=${list.remId}" class="btn btn-warning" role="button">Reopen</a></td>
  </tr>
  </c:forEach>
  </tbody>
  </table>
</div>
<footer class="container-fluid bg-4 text-center">
  <p>reMedy © Made By Manish</p>
</footer>
</body>
</html>
