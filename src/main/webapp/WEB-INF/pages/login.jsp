<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <title>Login Customer</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <form class="form-signin" method="post" action="/auth/login">--%>
<%--        <h2 class="form-signin-heading">Login</h2>--%>
<%--        <p>--%>
<%--            <label for="username">Username</label>--%>
<%--            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>--%>
<%--        </p>--%>
<%--        <p>--%>
<%--            <label for="password">Password</label>--%>
<%--            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>--%>
<%--        </p>--%>
<%--        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
<%--    </form>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/hotels/allhotels">See all hotels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/persons/create">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/auth/login">Login</a>
            </li>
            <li class="nav-item">
                <form class="btn__item" action="/auth/logout" method="POST">
                    <button class="btn" type="submit">Logout </button>
                </form>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <form class="form-signin" method="post" action="/auth/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <div class="form-control">
            <p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" placeholder="Username" required autofocus>
            </p>
            <p>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password"  placeholder="Password" required>
            </p>
        </div>
        <div class="btn__block">
            <button class="btn" type="submit">Sign in</button>
            <button class="btn"><a class="btn_out" href="/persons/create">Sign up</a></button>
        </div>
    </form>
</div>
</body>
</html>
