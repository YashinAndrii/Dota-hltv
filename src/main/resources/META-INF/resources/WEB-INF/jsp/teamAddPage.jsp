<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Team</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="fragments/nav2.jsp"%>
<div class="container">
    <h2>Add Team</h2>
    <form action="/add-team" method="POST">
        <div class="mb-3">
            <label for="teamName" class="form-label">Team Name</label>
            <input type="text" class="form-control" id="teamName" name="teamName" required>
        </div>
        <div class="mb-3">
            <label for="teamLogo" class="form-label">Team Logo</label>
            <input type="text" class="form-control" id="teamLogo" name="teamLogo">
        </div>
        <h3>Players</h3>
        <div class="player-fields">
            <c:forEach begin="0" end="4" varStatus="status">
            <div class="player-field">
                <div class="row">
                    <div class="col mb-3">
                        <label for="playerName${status.index+1}" class="form-label">Player ${status.index+1} Name</label>
                        <input type="text" class="form-control" id="playerName${status.index+1}" name="playerName${status.index+1}" required>
                    </div>
                    <div class="col mb-3">
                        <label for="playerNickname${status.index+1}" class="form-label">Player ${status.index+1} Nickname</label>
                        <input type="text" class="form-control" id="playerNickname${status.index+1}" name="playerNickname${status.index+1}" required>
                    </div>
                    <div class="col mb-3">
                        <label for="playerSurname${status.index+1}" class="form-label">Player ${status.index+1} Surname</label>
                        <input type="text" class="form-control" id="playerSurname${status.index+1}" name="playerSurname${status.index+1}" required>
                    </div>
                </div>
            </div>
            </c:forEach>
        <button type="submit" class="btn btn-primary">Add Team</button>
    </form>
</div>
<%@include file="fragments/footer.jsp"%>
</body>
</html>