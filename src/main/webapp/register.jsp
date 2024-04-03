<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"href="register.css">
<title>Insert title here</title>
</head>



</head>
<body>

<div class="container">
    <h2>Registration Form</h2>
    <form action="RegisterServlet" method="post">
        <label for="name">Name</label>
        <input type="text" id="name" name="username" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <label for="phone">Phone</label>
        <input type="tel" id="phone" name="phoneNumber" pattern="[0-9]{10}" required>

        <input type="submit" value="Register">
    </form>
</div>
</body>


</html>