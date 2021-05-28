<%--
  Created by IntelliJ IDEA.
  User: Kenzie
  Date: 5/10/2021
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="description" content="This is a website that will show movies that I like or want to watch.">
    <title>Movies: Search</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<%@ include file="includes/navigation.jsp"%>
<div class="container">
    <h3>Search for a movie to watch tonight!</h3>

    <div class="container">
        <form action="Search" method="get">
            <label for="title">Search by Title:</label>
            <input type="text" name="title" id="title">

            <label for="director">Search by Director:</label>
            <input type="text" name="director" id="director">

            <input type="submit" value="submit">
        </form>
    </div>
    <p>Thank you for visiting.</p>
</div>

<%@ include file="includes/footer.jsp"%>
</body>
</html>
