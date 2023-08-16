<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Matches</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="fragments/nav2.jsp" %>
<div class="container">
    <h2>Edit Matches</h2>
    <form action="/update-match" method="POST">
        <input type="hidden" name="id" value="${match.id}">
        <div class="mb-3">
            <label for="score" class="form-label">Score</label>
            <input type="text" class="form-control" id="score" name="score" value="${match.score[0]} - ${match.score[1]}" required>
        </div>
        <div class="mb-3">
            <label for="time" class="form-label">Time</label>
            <input type="datetime-local" class="form-control" id="time" name="time" value="<fmt:formatDate value="${match.time}" pattern="yyyy-MM-dd'T'HH:mm" />" required>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
<%@ include file="fragments/footer.jsp" %>
</body>
</html>