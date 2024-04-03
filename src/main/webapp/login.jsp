<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div class="login-page">
        <div class="form">
            <h2>Admin Login</h2>
            <form action="LoginServlet" class="login-form">
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password" placeholder="Password">
                
                <button type="submit">Login</button>
                <p class="message">Not registered? <a href="#">Create an account</a></p>
            </form>
        </div>
    </div>
</body>
</html>
