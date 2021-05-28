<%--
  Created by IntelliJ IDEA.
  User: Kenzie
  Date: 4/26/2021
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="description" content="This is a list of movies that I like or want to watch.">
    <title>List of Movies</title>
    <%@include file="includes/header.jsp"%>
</head>
<body>
    <%@ include file="includes/navigation.jsp"%>

    <div class="container">
        <c:choose>
            <c:when test="${empty movies}">
                <p>Sorry, the list of Movies was empty</p>

            </c:when>
            <c:otherwise>
                <c:forEach var="movie" items="${movies}">
                   <h2>${movie.title}</h2>
                    <p>${movie.title} is ${movie.lengthInMinutes} long, and was directed by ${movie.director}<br>${movie.description}<br>I would give it a rating of ${movie.rating}</p>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>

    <%@ include file="includes/footer.jsp"%>
</body>
</html>
