<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/user.js" ></script>
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
            <h2>Modify users and roles</h3>
        </div>
        <div class="container">
            <h1><small>User and role tasks</small></h1>
            <hr>
        </div>
        <div class="container">
            <div class="col-sm-6">
                <button type="button" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-flash"></span> Add a new user</p>
                    <ul>
                        <li>Allow someone new to use PIMS</li>
                        <li>You'll need the user present to set a password</li>
                    </ul>
                </button>
            </div>
        </div>
        <div class="container">
            <h1><small>Search for users</small></h1>
            <hr>
        </div>
        <div class="container">
            <form onsubmit="searchUsers(); return false;">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="forename">Forename</label>
                        <input type="text" class="form-control" id="forename" placeholder="Forename">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="surname">Surname</label>
                        <input type="text" class="form-control" id="surname" placeholder="Surname">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <button type="submit" onclick="" class="btn btn-primary">Search</button>
                    </div>
                </div>
            </form>
        </div>
        <div id="search-result-container" class="container" style="display:none;">
            <table class="table">
                <thead>
                    <tr><th scope="col">Username</th><th scope="col">Full Name</th><th scope="col">Modify User</th></tr>
                </thead>
                <tbody id="search-result-tbody">
                </tbody>
            </table>
        </div>
        <div class="container">
            <div id="no-results-alert" class="alert alert-info" style="display:none;">No users were found for those search criteria.</div>
        </div>
    </body>
</html>
