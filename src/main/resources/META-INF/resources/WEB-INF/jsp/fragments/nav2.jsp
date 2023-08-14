<style>
    .nav {
        display: flex;
        justify-content: center;
        background-color: #f2f2f2;
        padding: 10px;
    }
    .nav-logo {
        margin-left: 20px;
        display: flex;
        align-items: center;
    }

    .nav-logo img {
        width: 30px;
        height: 30px;
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
<nav class="navbar navbar-expand navbar-light bg-light justify-content-center">
    <a class="navbar-brand m-3" href="/todos">HLTV Dota</a>
    <div class="nav">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="/todos">News</a></li>
            <li class="nav-item"><a class="nav-link" href="/matches">Matches</a></li>
            <li class="nav-item"><a class="nav-link" href="/events">Events</a></li>
            <li class="nav-item"><a class="nav-link" href="/teams">Teams</a></li>
        </ul>
    </div>
</nav>