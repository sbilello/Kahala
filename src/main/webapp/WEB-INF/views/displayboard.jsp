<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="baseUrl">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="play.kalaha" /></title>
<link rel="stylesheet" href="${baseUrl}/assets/css/bootstrap.min.css">
</head>
<body>
	<div class="container-fluid">
       <div class="jumbotron text-center">
			<h3><fmt:message key="welcome.game"/></h3>
				  <div class="text-center">
				 	<c:set var="turn">${gameStatus.currentPlayer}</c:set>
				 	<c:if test="${feedbackMessage == null}">
				  		<p><fmt:message key="player.turn"/>: ${gameStatus.players[turn].name} </p>
				  	</c:if>
				  </div>
				  <table class="table table-bordered table-condensed">
				  	<tbody>
				  		    <tr>
				  		    	<td rowspan="2">${gameStatus.board.stonesInPit(1,0)}</td>
					  		    <c:forEach var="i" begin="1" end="${gameStatus.board.playingpits}">  
	      							<td>
	      								<div>${gameStatus.board.stonesInPit(1,i)}</div>
	      								<c:choose>
		      								<c:when test="${gameStatus.currentPlayer eq 1 and gameStatus.board.stonesInPit(1,i)>0}">
				      							<form action="${baseUrl}/kalahagame/play.htm" method="post">
				      								<input type="hidden" name="pitIndex" value="${i}">
		        									<button type="submit" class="btn btn-default"> <fmt:message key="pick.stones"/> </button>
		    									</form>
			      							</c:when>
			      							<c:otherwise>
			      								<button type="submit" class="btn btn-default" disabled="disabled"> <fmt:message key="pick.stones"/> </button>
			      							</c:otherwise>
		      							</c:choose>
	      							</td>
	    						</c:forEach>
	    						<td rowspan="2">${gameStatus.board.stonesInPit(0,0)}</td>
    						</tr>
    						<tr>
					  		    <c:forEach var="i" begin="1" end="${gameStatus.board.playingpits}" >
					  		     	<c:set var="decr" value="${gameStatus.board.playingpits+1-i}"/>  
	      							<td>
	      								<div>${gameStatus.board.stonesInPit(0,decr)}</div>
	      								<c:choose>
		      								<c:when test="${gameStatus.currentPlayer eq 0 and gameStatus.board.stonesInPit(0,decr)>0}">
			      								<form action="${baseUrl}/kalahagame/play.htm" method="post">
				      								<input type="hidden" name="pitIndex" value="${decr}">
				      								<button type="submit" class="btn btn-default"> <fmt:message key="pick.stones"/> </button>
				      							</form>
			      							</c:when>
			      							<c:otherwise>
			      								<button type="submit" class="btn btn-default" disabled="disabled"> <fmt:message key="pick.stones"/> </button>
			      							</c:otherwise>
		      							</c:choose>
		      						</td>
	    						</c:forEach>
    						</tr>
				  	</tbody>
				  </table>
			<c:if test="${feedbackMessage != null}">
				<div class="text-center">
					<div class="alert alert-success"><c:out value="${feedbackMessage}"/></div>
					<a href="${baseUrl}"><fmt:message key="new.game"/></a>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>
