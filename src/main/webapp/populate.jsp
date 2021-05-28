<%--
  Created by IntelliJ IDEA.
  User: Kenzie
  Date: 5/17/2021
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="description" content="This is a website that will show movies that I like or want to watch.">
    <title>Movies: Populate Database</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<%@ include file="includes/navigation.jsp"%>
<div class="container">
    <h3>Populate the Database</h3>
    <p>WARNING: This action will over-write the existing Database.</p>

    <div class="container">
        <form action="Populate" method="post">
            <input type="submit" value="Populate Database">
        </form>
    </div>
    <p>${message}</p>
    <p>Thank you for visiting.</p>
</div>

<%@ include file="includes/footer.jsp"%>
</body>
</html>
