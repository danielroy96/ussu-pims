<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/user.js" ></script>
        <title>PIMS</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
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
