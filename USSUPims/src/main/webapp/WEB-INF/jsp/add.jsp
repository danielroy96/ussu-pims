<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
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
                <li class="breadcrumb-item">Add items</li>
            </ol>
            <h2>Add items to PIMS</h2>
            <h1><small>Item details</small></h1>
            <hr>
            <form id="newItem">
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="name">Item name</label>
                        <input id="name" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="description">Description</label>
                        <input id="description" class="form-control" type="text">
                    </div>
                    <div class="form-group col-md-3">
                        <p><strong>PAT Testing</strong></p>
                        <div class="checkbox">
                            <label for="PATrequired"><input id="PATrequired" type="checkbox">Required</label>
                        </div>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="PATinterval">PAT Test Interval</label>
                        <div class="input-group">
                            <input id="PATinterval" type="tel" class="form-control">
                            <span class="input-group-addon">months</span>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
