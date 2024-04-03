<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 100px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        p {
            text-align: center;
            margin-bottom: 20px;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Logout Page</h1>
        <%-- Check if the user is logged in --%>
        <% if (session.getAttribute("username") != null) { %>
            <%-- Invalidate the session --%>
            <% session.invalidate(); %>
            <p>You have been logged out successfully.</p>
            <p><a href="login.jsp">Click here to login again</a></p>
        <% } else { %>
            <p>You are already logged out.</p>
            <p><a href="login.jsp">Click here to login</a></p>
        <% } %>
    </div>
</body>
</html>
