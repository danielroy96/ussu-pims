<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
        <li class="breadcrumb-item">${job.name}</li>
    </ol>
    <h2>${job.name}</h2>
    <h1>
        <small>Event details</small>
    </h1>
    <hr>
    <input id="jobId" value="${job.id}" hidden>
    <div class='form-row'>
        <div class='form-group col-md-6'>
            <label for="name">Event name</label>
            <input id="name" class="form-control" value="${job.name}" disabled>
        </div>
        <div class="form-group col-md-6">
            <label for="venue">Venue</label>
            <input id="venue" class="form-control" value="${job.venue}" disabled>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="client">Client</label>
            <input id="client" class="form-control" value="${job.client.name}" disabled>
        </div>
        <div class="form-group col-md-6">
            <label for="description">Description</label>
            <textarea id="description" class="form-control" disabled>${job.description}</textarea>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-3">
            <label for="jobStartDatetime">Event start date</label>
            <input id="jobStartDatetime" class="form-control datepicker" value="${job.jobStartDatetime}" disabled>
        </div>
        <div class="form-group col-md-3">
            <label for="jobEndDatetime">Event end date</label>
            <input id="jobEndDatetime" class="form-control datepicker" value="${job.jobEndDatetime}" disabled>
        </div>

    </div>
    <div class="form-row">
        <div class="form-group col-md-12">
        <h1><small>Export this job</small></h1>
        <hr>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <a class='btn btn-primary dashboard-action' href="job/${job.id}/report">
                <p class='button-heading-text'><span class='glyphicon glyphicon-stats'></span> Download report</p>
                <ul>
                    <li>Includes all items on this job</li>
                    <li>Generates a Microsoft&reg; Excel spreadsheet</li>
                </ul>
            </a>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12">
            <h1>
                <small>Equipment on the event</small>
            </h1>
            <hr>
        </div>
    </div>
    <div class="form-row">
        <form onsubmit="checkInOutItem(); return false;">
            <div class="form-group col-md-6">
                <input id="barcode" class="form-control" placeholder="Scan a barcode">
            </div>
            <div class="form-group col-md-3">
                <button id="btnCheckInOut" type="submit" class="btn btn-primary btn-fullwidth">Check out</button>
            </div>
            <div class="form-group col-md-3">
                <button id="btnSwapCheckInOut" class="btn btn-secondary btn-fullwidth" onclick="switchCheckInOut();">
                    Switch to check in
                </button>
            </div>
        </form>
    </div>
</div>
<div class="form-row container">
    <table class="table">
        <thead>
        <tr>
            <th>Barcode</th>
            <th>Item type</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody id="jobItems">

        </tbody>
    </table>
</div>
<%@include file="/WEB-INF/jspf/foot.jspf" %>
</body>
</html>
