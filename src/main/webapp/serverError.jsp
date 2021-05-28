<%--
  Created by IntelliJ IDEA.
  User: Kenzie
  Date: 4/26/2021
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internal Server Error</title>
</head>
<body>
<h2>Sorry, We are experiencing technical difficulties.</h2>
<h3>Error Details:</h3>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.toString()}</p>
<p>Please Try Again! Return <a href="index.jsp">Home</a> or <a href="view-all.jsp">View All</a></p>
</body>
</html>
