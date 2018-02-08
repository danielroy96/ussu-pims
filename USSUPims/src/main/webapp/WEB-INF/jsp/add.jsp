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
                <li class="breadcrumb-item">Add items</li>
            </ol>
            <h2>Add items to PIMS</h2>
        </div>
    </body>
</html>
