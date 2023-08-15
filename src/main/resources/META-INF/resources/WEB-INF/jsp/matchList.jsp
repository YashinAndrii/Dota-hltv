<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Matches</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .team-logo {
            width: 70px !important;/* Установите желаемую ширину */
            height: auto !important;
        }
    </style>
</head>
<body>
<%@ include file="fragments/nav2.jsp" %>
<div class="container">
    <h2>All Matches</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Team 1</th>
            <th>Score</th>
            <th>Team 2</th>
            <th>Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${matches}" var="match">
            <tr>
                <td>
                    <div class="nav-logo img">
                        <a href="/teams/${match.team1.name}">
                            <img class="team-logo" src="/images/teamLogos/${match.team1.logo}" alt="Team Logo">
                        </a>
                    </div>
                </td>
                <td>${match.score[0]} - ${match.score[1]}</td>
                <td>
                    <div class="nav-logo img">
                        <a href="/teams/${match.team2.name}">
                            <img class="team-logo" src="/images/teamLogos/${match.team2.logo}" alt="Team Logo">
                        </a>
                    </div>
                </td>
                <td>
                    <fmt:formatDate value="${match.time}" pattern="yyyy-MM-dd HH:mm:ss" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/add-match" class="btn btn-success">Add Match</a>
</div>
<%@ include file="fragments/footer.jsp" %>
</body>
</html>