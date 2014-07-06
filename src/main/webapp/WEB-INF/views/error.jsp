<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="baseUrl">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="kalaha.error"/></title>
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
   <div class="container-fluid">
	 <div class="hero-unit text-center">
        <div>
           <h1>Ops! Something went wrong</h1>
 		   <a href="${baseUrl}">Return to Home</a>
      </div>
     </div>
  </div>
<script src="${baseUrl}/assets/js/jquery-1.9.1.min.js"></script>
<script src="${baseUrl}/assets/js/bootstrap.min.js"></script>
</body>
</html>
