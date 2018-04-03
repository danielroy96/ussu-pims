<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/job.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
        <div class="container welcome-bar">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="glyphicon glyphicon-home" href="index"></a></li>
                <li class="breadcrumb-item"><a href="event">Events</a></li>
                <li class="breadcrumb-item">New job</li>
            </ol>
            <h2>Create a new job</h2>
            <h1><small>Event details</small></h1>
            <hr>
            <form id="newJob" data-parsley-validate>
                <div class='form-row'>
                    <div class='form-group col-md-6'>
                        <label for="name">Event name</label>
                        <input id="name" class="form-control" placeholder="Event name" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="venue">Venue</label>
                        <input id="venue" class="form-control" placeholder="Venue">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="client">Client</label>
                        <select id="client" class="form-control selectpicker">

                        </select>
                        <a>Add a new client...</a>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="description">Description</label>
                        <textarea id="description" class="form-control" placeholder="Enter a description or notes about this event"></textarea>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="jobStartDatetime">Event start date</label>
                        <input id="jobStartDatetime" class="form-control datepicker" placeholder="Select a date">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="jobEndDatetime">Event end date</label>
                        <input id="jobEndDatetime" class="form-control datepicker" placeholder="Select a date">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <button class="btn btn-primary btn-fullwidth" onclick="addJob(); return false;">Create event</button>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
