<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="baseUrl">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html>
<head>
<title>Kalaha Game</title>
<link rel="stylesheet" href="${baseUrl}/assets/css/bootstrap.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron text-center">
			<h1>Welcome to Kalaha Game</h1>
			<form role="form" class="form-horizontal" action="${baseUrl}/kalahagame/start.htm" method="post">
				<div class="form-group">
				    <label for="player1" class="col-sm-2 control-label">Player 1</label>
				    <div class="col-sm-10">
				      <input type="text" name="player1" class="form-control col-sm-6" id="player1" placeholder="Type Player 1 Name">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="player2" class="col-sm-2 control-label">Player 2</label>
				    <div class="col-sm-10">
				      <input type="text" name="player2" class="form-control col-sm-6 " id="player2" placeholder="Type Player 2 Name">
				    </div>
				  </div>
				  <div class="text-center">
				      <button type="submit" class="btn btn-primary">Start Game</button>
				  </div>
			</form>
		</div>
	</div>
</body>
</html>
