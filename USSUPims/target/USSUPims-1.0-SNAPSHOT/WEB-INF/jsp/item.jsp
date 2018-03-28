<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
        <div class="container welcome-bar">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="glyphicon glyphicon-home" href="index"></a></li>
                <li class="breadcrumb-item"><a href="search">Search</a></li>
                <li>${item.itemTypeName}</li>
            </ol>
            <h2>${item.itemTypeName}</h2>
            <p>Last updated ${item.lastChangedDateTime} by ${item.lastChangedByUserFullname}</p>
        </div>
        <div class="container">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Item type</small></h1>
                    <hr>
                    <input name="itemTypeId" id =" itemTypeId" class="form-control" value="${item.itemTypeId}" hidden>
                    <input name ="itemTypeName" id="itemTypeName" class="form-control" value="${item.itemTypeName}" disabled>
                    <input name="itemTypeValue" id="itemTypeValue" class="form-control" value="${item.value}" disabled>
                    <input name="itemTypeWeight" id="itemTypeWeight" class="form-control" value="${item.weight}" disabled>
                    <input name="itemTypeRequiresPat" id="itemTypeRequiresPat" class="form-control" value="${item.requiresPat}" disabled>
                    <input name=itemTypePatIntervalMonths" id="itemTypePatIntervalMonths" class="form-control" value="${item.patIntervalMonths}" disabled>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Item details</small></h1>
                    <hr>
                    <input name="createdByUserId" id="createdByUserId" class="form-control" value="${item.createdByUserId}" disabled>
                    <input name="createdDateTime" id="createdDateTime" class="form-control" value="${item.createdDatetime}" disabled>
                    <input name="lastChangedByUserId" id="lastChangedByUserId" class="form-control" value="${item.lastChangedByUserId}" disabled>
                    <input name="lastChangedDateTime" id=lastChangedDateTime" class="form-control" value="${item.lastChangedDateTime}" disabled>
                    <input name="barcode" id="barcode" class="form-control" value="${item.barcode}">
                    <input name="description" id="description" class="form-control" value="${item.description}">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Item history</small></h1>
                    <hr>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
