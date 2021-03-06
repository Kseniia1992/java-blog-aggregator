<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <title><tiles:getAsString name="title"/></title>
</head>
<body>
    <tilesx:useAttribute name="current"/>

    <div class="container">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href='<spring:url value="/"></spring:url> '>JBA</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/"></spring:url> '>Home</a></li>
                        <li class="${current == 'users' ? 'active' : ''}"><a href='<spring:url value="/users.html"></spring:url> '>Users</a></li>
                        <li class="${current == 'register' ? 'active' : ''}"><a href='<spring:url value="/register.html"></spring:url> '>Register</a></li>
                        <li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html"></spring:url> '>Login</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>
        <tiles:insertAttribute name="body"/>
        <br>
        <br>
        <tiles:insertAttribute name="footer"/>
    </div>
</body>
</html>
