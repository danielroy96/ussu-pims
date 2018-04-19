<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/events.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
        <div class="container welcome-bar">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="glyphicon glyphicon-home" href="index"></a></li>
                <li class="breadcrumb-item">Events</li>
            </ol>
            <h2>Events and hires</h2>
            <h1><small>Event tasks</small></h1>
            <hr>
            <div class='form-row'>
                <div class='col-md-6'>
                    <a href="new-job" class="btn btn-primary dashboard-action">
                        <p class="button-heading-text"><span class="glyphicon glyphicon-search"></span> Create a new job</p>
                        <ul>
                            <li>Start a new job</li>
                            <li>Prep and check out items</li>
                        </ul>
                    </a>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-12">
                    <h1><small>Search for events</small></h1>
                    <hr>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select id="jobSearch" class="selectpicker form-control" data-live-search="true">
                    </select>
                    <div class="form-text text-muted">Start typing to find an event</div>
                </div>
                <div class="form-group col-md-6">
                    <button class="btn btn-fullwidth btn-primary" onclick="selectQuickSearch();">Select event</button>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
