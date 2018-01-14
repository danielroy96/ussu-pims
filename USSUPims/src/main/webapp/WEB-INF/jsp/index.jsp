<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/main.js" ></script>
        <script src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/dashboard-css.css" rel="stylesheet">
        <title>PIMS</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/pims/index">PIMS - University of Surrey Students' Union</a>
                </div>
                <form class="navbar-form navbar-right" action="/pims/logout">
                    <button type="submit" class="btn btn-warning logout-button">Log out</button>
                    <div class="form-group">
                        <img class="navbar-brand" src="img/logo.png">
                    </div>
                </form>
            </div>
        </nav>
        <div class="container welcome-bar">
            <h2>Welcome to the PIMS Dashboard, ${userForename}</h3>
                <p>Hi, choose something you want to do.</p>
        </div>
        <div class="container">
            <h1><small>User dashboard tasks</small></h1>
            <hr>
        </div>
        <div class="container">
            <div class="col-sm-6">
                <button type="button" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-screenshot"></span> Start PAT testing equipment</p>
                    <ul>
                        <li>Test equipment for electrical safety</li>
                        <li>Bulk process barcodes</li>
                    </ul>
                </button>
                <button type="button" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-check"></span> Manage jobs and hires</p>
                    <ul>
                        <li>Create and modify jobs</li>
                        <li>Check equipment in or out</li>
                    </ul>
                </button>
            </div>
            <div class="col-sm-6">
                <button type="button" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-search"></span> Search for equipment</p>
                    <ul>
                        <li>Search for equipment in the database</li>
                        <li>Test and repair equipment</li>
                    </ul>
                </button>
            </div>
        </div>
        <c:if test="${userRole=='[ROLE_ADMIN]'}">
            <div class="container">
                <h1><small>Admin dashboard tasks</small></h1>
                <hr>
            </div>
            <div class="container">
                <div class="col-sm-6">
                    <form action="/pims/user">
                        <button type="submit" class="btn btn-primary dashboard-action">
                            <p class="button-heading-text"><span class="glyphicon glyphicon-user"></span> Modify users and roles</p>
                            <ul>
                                <li>Add and remove users</li>
                                <li>Modify users' roles</li>
                            </ul>
                        </button>
                    </form>
                </div>
                <div class="col-sm-6">

                </div>
            </div>
        </c:if>
    </body>
</html>
