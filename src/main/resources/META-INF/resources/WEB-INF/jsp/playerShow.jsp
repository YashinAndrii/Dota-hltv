<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Player Details</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="fragments/nav2.jsp"%>
<div class="container">
    <h2 class="col text-center">Player Details</h2>
    <div class="row justify-content-center align-items-center">
        <div class="col text-center">
            <img src="/images/players/${player.photo}" alt="Player Photo" style="width: 200px; height: 200px;">
            <h4 class="mt-3">${player.nickName}</h4>
            <p>${player.fname} ${player.lname}</p>
        </div>
    </div>
</div>
<%@include file="fragments/footer.jsp"%>
</body>
</html>