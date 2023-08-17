<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Events</title>
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
    <h3 style="text-align: center">Upcoming events</h3>
    <table class="table">
        <thead></thead>
        <tbody>
        <c:forEach items="${events}" var="event" varStatus="loop">
            <c:set var="prevEvent" value="${loop.index > 0 ? event[loop.index - 1] : null}" />
            <c:if test="${prevEvent == null || prevEvent.startDate != event.startDate}">
                <tr>
                    <td colspan="4" style="font-weight: bold; background-color: #f2f2f2;">
                        <fmt:formatDate value="${event.startDate}" pattern="d MMMM" />
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>${event.name}</td>
                <td>
                    <c:choose>
                        <c:when test="${event.startDate <= currentTime}">
                            <strong style="color: red;">Ongoing</strong>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatDate value="${event.startDate}" pattern="d MMMM" />
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <fmt:formatDate value="${event.endDate}" pattern="d MMMM" />
                </td>
                <td><a href="/delete-event?id=${event.id}" class="btn btn-warning">Delete</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/add-event" class="btn btn-success">Add Event</a>
</div>
<%@ include file="fragments/footer.jsp" %>
</body>
</html>