<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h2>Welcome <%= user.getName() %></h2>

<a href="addPost.jsp">Add Blog Post</a>
<br><br>

<a href="logout">Logout</a>

</body>
</html>