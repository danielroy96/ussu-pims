<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/job.js"></script>
        <script src="js/addjob.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
        <div class="modal fade" id="clientModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form id="newClient" data-parsley-validate>
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add a new client</h5>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <p>Enter the details of the new client.</p>
                                <label for="newClientName">Client name</label>
                                <input id="newClientName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="newClientContactName">Contact name</label>
                                <input id="newClientContactName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="newClientContactEmail">Contact email</label>
                                <input id="newClientContactEmail" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="newCLientContactPhone">Contact phone</label>
                                <input id="newCLientContactPhone" class="form-control">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary" onclick="addClient(); return false;">Add client</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
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
                        <select id="client" class="form-control selectpicker" data-live-search="true">

                        </select>
                        <a data-toggle="modal" data-target="#clientModal">Add a new client...</a>
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
