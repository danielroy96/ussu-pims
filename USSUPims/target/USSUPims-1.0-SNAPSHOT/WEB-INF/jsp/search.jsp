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
        <script src="js/search.js" ></script>
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-select/1.4.2/bootstrap-select.min.css" rel="stylesheet">
        <link href="webjars/ajax-bootstrap-select/1.4.0/dist/css/ajax-bootstrap-select.css" rel="stylesheet">
        <link href="css/dashboard-css.css" rel="stylesheet">
        <link href="css/search-css.css" rel="stylesheet">
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
                <li class="breadcrumb-item">Search</li>
            </ol>
            <h2>Search for items</h2>
            <h1><small>Quick search</small></h1>
            <hr>
            <form id="barcodeSearch">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <select id="itemSearch" class="selectpicker form-control" data-live-search="true">

                        </select>
                        <p class="form-text text-muted">Start typing to find an item</p>
                    </div>
                    <div class="form-group col-md-6">
                        <button id="btnSearch" class="btn btn-primary btn-fullwidth" type="button">Select item</button>
                    </div>
                </div>
                <div class="form-row">

                </div>
            </form>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Advanced search</small></h1>
                    <hr>
                </div>
            </div>
            <form id="advancedSearch">
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="searchTerms">Search Terms</label>
                        <input id="searchTerms" class="form-control" type="text">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <p><strong>PAT Test Status</strong></p>
                        <div class="checkbox">
                            <label for="validPAT"><input name="validPAT" id="validPAT" type="checkbox">PAT test in date</label>
                        </div>
                        <div class="checkbox">
                            <label for="expiringPAT"><input name="expiringPAT" id="expiringPAT" type="checkbox">PAT expiring soon</label>
                        </div>
                        <div class="checkbox">
                            <label for="invalidPAT"><input name="invalidPAT" id="invalidPAT" type="checkbox">PAT test expired</label>
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <p><strong>Other Parameters</strong></p>
                        <div class="checkbox">
                            <label for="validPAT"><input name="validPAT" id="validPAT" type="checkbox">PAT test in date</label>
                        </div>
                        <div class="checkbox">
                            <label for="expiringPAT"><input name="expiringPAT" id="expiringPAT" type="checkbox">PAT expiring soon</label>
                        </div>
                        <div class="checkbox">
                            <label for="invalidPAT"><input name="invalidPAT" id="invalidPAT" type="checkbox">PAT test expired</label>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <button id="btnSearchAdvanced" onclick="advancedSearch(); return false;" class="btn btn-primary btn-fullwidth" type="button">Search</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
