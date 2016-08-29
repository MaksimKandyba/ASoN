<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 13.08.16
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Animal Social Network - My Page</title>
</head>
<body>
    <form action="/" method="get">
        <input type="submit" value="Sign out">
    </form>
    <form action="/delAnimal" method="post">
        <input type="submit" value="Delete Myself">
        <input type="hidden" name="name" value=${name}>
    </form>

    <h4>Name</h4>
    ${name}

    <h4>Birthday</h4>
    ${birthday}

    <h4>Places</h4>
    <c:if test="${not empty places}">
        <ul>
            <c:forEach var="obj" items="${places}">
                <li>${obj.title} - ${obj.description}</li>
            </c:forEach>
        </ul>
    </c:if>

    <h4>Hobbies</h4>
    <c:if test="${not empty hobbies}">
        <ul>
            <c:forEach var="obj" items="${hobbies}">
                <li>${obj.title} - ${obj.description}</li>
            </c:forEach>
        </ul>
    </c:if>

    <h4>Posts</h4>
    <c:if test="${not empty posts}">
        <ul>
            <c:forEach var="obj" items="${posts}">
                <li>${obj.title}: ${obj.content} - ${obj.publicationTime} -
                ${obj.likesCounter} like(s)</li>
            </c:forEach>
        </ul>
    </c:if>

    <form action="/addPost" method="post">
        <p><input type="text" placeholder="title" name="title"></p>
        <p><input type="text" placeholder="content" name="content">
        <input type="submit" value="Publish Post"></p>
        <input type="hidden" name="name" value=${name}>
    </form>

    <h4>Incoming</h4>
    <c:if test="${not empty incoming}">
        <ul>
            <c:forEach var="obj" items="${incoming}">
                <li>${obj.sender} --> ${obj.content} -
                ${obj.sendingOffTime}</li>
            </c:forEach>
        </ul>
    </c:if>

    <h4>Outgoing</h4>
    <c:if test="${not empty outgoing}">
        <ul>
            <c:forEach var="obj" items="${outgoing}">
                <li>${obj.content} --> ${obj.addressee} -
                ${obj.sendingOffTime}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form action="/sendMsg" method="post">
        <p><input type="text" placeholder="content" name="content"></p>
        <p><input type="text" placeholder="addressee" name="addressee">
            <input type="submit" value="Send Message"></p>
        <input type="hidden" name="name" value=${name}>
    </form>

    <h4>Friends</h4>
    <c:if test="${not empty friends}">
        <ul>
            <c:forEach var="obj" items="${friends}">
                <li>${obj.name}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form action="/addFriend" method="post">
        <input type="submit" value="Make Friends">
        with
        <c:if test="${not empty animals}">
            <select name="friendId">
                <c:forEach var="obj" items="${animals}">
                    <option value=${obj.id}>${obj.name}</option>
                </c:forEach>
            </select>
        </c:if>
        <input type="hidden" name="name" value=${name}>
    </form>
</body>
</html>
