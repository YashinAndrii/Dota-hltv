<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Event</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="fragments/nav2.jsp"%>
<div class="container">
    <h2>Add Event</h2>
    <form action="/add-event" method="POST">
        <div class="mb-3">
            <label for="eventName" class="form-label">Event name</label>
            <input type="text" class="form-control" id="eventName" name="name" required>
        </div>
        <div class="mb-3">
            <label for="startDate" class="form-label">Start date</label>
            <input type="datetime-local" class="form-control" id="startDate" name="startDate" value="<fmt:formatDate value="${event.startDate}" pattern="yyyy-MM-dd" />" required>
        </div>
        <div class="mb-3">
            <label for="endDate" class="form-label">End date</label>
            <input type="datetime-local" class="form-control" id="endDate" name="endDate" value="<fmt:formatDate value="${event.endDate}" pattern="yyyy-MM-dd" />" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Event</button>
    </form>
</div>
<%@include file="fragments/footer.jsp"%>
</body>
</html>