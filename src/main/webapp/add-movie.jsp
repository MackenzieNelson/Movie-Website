<%--
  Created by IntelliJ IDEA.
  User: Kenzie
  Date: 5/17/2021
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="description" content="This is a website that will show movies that I like or want to watch.">
    <title>Movies: Add New Movie</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<%@ include file="includes/navigation.jsp"%>
<div class="container">
    <h3>Add a Movie to the List</h3>
    <p>${message}</p>
    <div class="container">
        <form action="AddNewMovie" method="post">
            <label for="title">Title:</label>
            <input type="text" name="title" id="title">

            <label for="lengthInMinutes">Length in Minutes:</label>
            <input type="text" name="lengthInMinutes" id="lengthInMinutes">

            <label for="director">Director:</label>
            <input type="text" name="director" id="director">

            <label for="description">Description:</label>
            <input type="text" name="description" id="description">

            <label for="rating">Rating:</label>
            <input type="text" name="rating" id="rating">

            <input type="submit" value="submit movie">
        </form>
    </div>
    <p>Thank you for visiting.</p>
</div>

<%@ include file="includes/footer.jsp"%>
</body>
</html>