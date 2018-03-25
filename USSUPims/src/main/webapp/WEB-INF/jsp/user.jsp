<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
        <script src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="webjars/bootstrap-select/1.4.2/bootstrap-select.min.js"></script>
        <script src="webjars/ajax-bootstrap-select/1.4.0/dist/js/ajax-bootstrap-select.js"></script>
        <script src="js/user.js" ></script>
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-select/1.4.2/bootstrap-select.min.css" rel="stylesheet">
        <link href="webjars/ajax-bootstrap-select/1.4.0/dist/css/ajax-bootstrap-select.css" rel="stylesheet">
        <link href="css/dashboard-css.css" rel="stylesheet">
        <title>PIMS</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/pims/index">PIMS - Surrey Stage Crew</a>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div id="navbar" class="navbar-collapse collapse" aria-expanded="false">
                    <ul class="nav navbar-nav navbar-form navbar-right">
                        <li>
                            <button onclick="window.location = 'logout'" class="btn btn-warning logout-button">Log out</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container welcome-bar">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="glyphicon glyphicon-home" href="index"></a></li>
                <li class="breadcrumb-item">Users</li>
            </ol>
        </div>
        <div class="container">
            <h2>Modify users and roles</h3>
        </div>
        <div class="container">
            <h1><small>User and role tasks</small></h1>
            <hr>
        </div>
        <div class="container">
            <div class="col-sm-6">
                <a href="user-details" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-flash"></span> Add a new user</p>
                    <ul>
                        <li>Allow someone new to use PIMS</li>
                        <li>You'll need the user to set a password</li>
                    </ul>
                </a>
            </div>
        </div>
        <div class="container">
            <h1><small>Search for users</small></h1>
            <hr>
        </div>
        <div class="container">
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <select id="userSearchSelector" class="selectpicker form-control" data-live-search="true">
                        </select>
                        <p class="form-text text-muted">Start typing to find a user</p>

                    </div>
                    <div class="form-group col-md-6">
                        <button type="button" id="modifyButton" onclick="modifyUser();" class="btn btn-primary" disabled>Modify User</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
