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
            width: 70px !important;
            height: auto !important;
        }
        table {
            width: 100%;
        }
        table td {
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
        }
        .logo-container {
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<%@ include file="fragments/nav2.jsp" %>
<div class="container">
    <h3 style="text-align: center">Upcoming matches</h3>
    <table class="table">
        <thead></thead>
        <tbody>
            <c:forEach items="${matches}" var="match" varStatus="loop">
                <c:set var="prevMatch" value="${loop.index > 0 ? matches[loop.index - 1] : null}" />
                <c:if test="${prevMatch == null || prevMatch.time.date != match.time.date}">
                    <tr>
                        <td colspan="4" style="font-weight: bold; background-color: #f2f2f2;">
                            <fmt:formatDate value="${match.time}" pattern="d MMMM" />
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <div class="logo-container">
                            <a href="/teams/${match.team1.name}">
                                <img class="team-logo" src="/images/teamLogos/${match.team1.logo}" alt="Team Logo">
                            </a>
                        </div>
                    </td>
                    <td><strong style="font-size: 20px;">${match.score[0]} - ${match.score[1]}</strong></td>
                    <td>
                        <div class="logo-container">
                            <a href="/teams/${match.team2.name}">
                                <img class="team-logo" src="/images/teamLogos/${match.team2.logo}" alt="Team Logo">
                            </a>
                        </div>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${match.time <= currentTime}">
                                <strong style="color: red;">Live</strong>
                            </c:when>
                            <c:otherwise>
                                <fmt:formatDate value="${match.time}" pattern="HH:mm" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><a href="/update-match?id=${match.id}" class="btn btn-success">Update</a> </td>
                    <td><a href="/delete-match?id=${match.id}" class="btn btn-warning">Delete</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/add-match" class="btn btn-success">Add Match</a>
</div>
<%@ include file="fragments/footer.jsp" %>
</body>
</html>