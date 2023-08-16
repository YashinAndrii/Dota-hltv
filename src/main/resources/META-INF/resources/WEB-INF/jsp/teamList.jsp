<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .nav {
        display: flex;
        justify-content: center;
        background-color: #f2f2f2;
        padding: 10px;
    }
    .player-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
    }

    .player-name {
        margin-top: 5px;
        font-weight: bold;
        font-size: 14px;
    }
    .player-photo {
        width: 100px;
        height: 100px;
    }
    .nav-logo {
        margin-left: 20px;
        display: flex;
        align-items: center;
    }

    .nav-logo img {
        width: 50px !important;
        height: 60px !important;
        margin-right: 10px;
    }

    .nav-photo img{
        width: 60px !important;
        height: 60px !important;
        margin-right: 10px;
    }

    .nav-item {
        margin-right: 20px;
    }

    .nav-item:last-child {
        margin-right: 0;
    }

    .nav-link {
        color: #333;
        text-decoration: none;
        font-weight: bold;
        font-size: 18px;
        padding: 10px;
        border-bottom: 2px solid transparent;
    }

    .nav-link:hover {
        border-bottom-color: #333;
    }
</style>
<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>All Teams page</title>
    </head>
    <body>
        <%@include file="fragments/nav2.jsp"%>
        <div class="container">
            <h2>Teams</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Dps points</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${team}" var="team">
                        <tr>
                            <td>
                                <div class="nav-logo img">
                                        <a href="/teams/${team.name}">
                                            <img src="/images/teamLogos/${team.logo}" alt="Team Logo">
                                        </a>
                                </div>
                            </td>
                            <td>${team.name}</td>
                            <td>Amount of DPS points </td>
                            <c:forEach items="${team.players}" var="player" varStatus="loop">
                                <td>
                                    <div class="player-container">
                                        <a href="/${player.nickName}">
                                            <img class="player-photo" src="/images/players/${player.photo}" alt="Player Photo">
                                            <div class="player-name">${player.nickName}</div>
                                        </a>
                                    </div>
                                </td>
                            </c:forEach>
                            <c:forEach begin="${team.players.size() + 1}" end="5" varStatus="loop">
                                <td>
                                    <div class="player-container">
                                        <img class="player-photo" src="${pageContext.request.contextPath}/images/players/nonplayer.png" alt="Default Player Photo">
                                        <div class="player-name">----</div>
                                    </div>
                                </td>
                            </c:forEach>
                            <td><a href="/delete-team?name=${team.name}" class="btn btn-warning">Delete</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/add-team" class="btn btn-success">Add Team</a>
        </div>

        <%@include file="fragments/footer.jsp"%>
    </body>
</html>
