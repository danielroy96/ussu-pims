<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
        <script src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="js/main.js" ></script>
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
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
        <div class="modal fade" id="passwordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form id="passwordReset" onsubmit="resetPassword(); return false;" data-parsley-validate>
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Change my password</h5>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <p>Enter your new password. Passwords must contain at least 8 characters.</p>
                                <label for="newPassword">New password</label>
                                <input id="newPassword" class="form-control" type="password" data-parsley-minlength="8" placeholder="New Password" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Change Password</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container welcome-bar">
            <h2>Welcome to the PIMS Dashboard, ${userForename}</h2>
        </div>
        <div class="container">
            <h1><small>PIMS Dashboard stats</small></h1>
            <hr>
            <h4>Current Test Stats <small> Equipment PAT testing progress</small></h4>
            <div class="progress">
                <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" style="width:40%">
                    Tested
                </div>
                <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" style="width:35%">
                    Expiring
                </div>
                <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" style="width:25%">
                    Expired
                </div>
            </div>
            <h4>Stock location <small> Equipment out on jobs</small></h4>
            <div class="progress">
                <div class="progress-bar progress-bar-default progress-bar-striped" role="progressbar" style="width:80%">
                    In
                </div>
                <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" style="width:20%">
                    Out
                </div>

            </div>
        </div>
        <div class="container">
            <h1><small>User dashboard tasks</small></h1>
            <hr>
        </div>
        <div class="container">
            <div class="col-sm-6">
                <a href="test" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-screenshot"></span> PAT test equipment</p>
                    <ul>
                        <li>Test equipment for electrical safety</li>
                        <li>Bulk process barcodes</li>
                    </ul>
                </a>
                <a href="add" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-qrcode"></span> Add new items</p>
                    <ul>
                        <li>Add a new item to PIMS</li>
                        <li>Bulk add items</li>
                    </ul>
                </a>
            </div>
            <div class="col-sm-6">
                <a href="search" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-search"></span> Search for items</p>
                    <ul>
                        <li>Search for equipment in the database</li>
                        <li>Test and repair equipment</li>
                    </ul>
                </a>
                <a href="event" class="btn btn-primary dashboard-action">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-check"></span> Manage events</p>
                    <ul>
                        <li>Create and modify jobs</li>
                        <li>Check equipment in or out</li>
                    </ul>
                </a>
            </div>
        </div>
        <div class="container">
            <h1><small>Account options</small></h1>
            <hr>
        </div>
        <div class="container">
            <div class="col-sm-6">
                <a class="btn btn-primary dashboard-action" data-toggle="modal" data-target="#passwordModal">
                    <p class="button-heading-text"><span class="glyphicon glyphicon-lock"></span> Change my password</p>
                    <ul>
                        <li>Account tasks</li>
                        <li>Change my account password</li>
                    </ul>
                </a>
            </div>
        </div>
        <c:if test="${userRole=='[ROLE_ADMIN]'}">
            <div class="container">
                <h1><small>Admin dashboard tasks</small></h1>
                <hr>
            </div>
            <div class="container">
                <div class="col-sm-6">
                    <a href="user" class="btn btn-primary dashboard-action">
                        <p class="button-heading-text"><span class="glyphicon glyphicon-user"></span> Users and Roles</p>
                        <ul>
                            <li>Add and remove users</li>
                            <li>Modify users' roles</li>
                        </ul>
                    </a>
                </div>
                <div class="col-sm-6">

                </div>
            </div>
        </c:if>
    </body>
</html>
