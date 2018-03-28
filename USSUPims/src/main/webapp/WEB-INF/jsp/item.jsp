<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/item.js" ></script>
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
                    <h1><small>Item type details</small></h1>
                    <hr>
                    <div id="itemTypeIdGroup" hidden>
                        <input name="itemTypeId" id =" itemTypeId" class="form-control" value="${item.itemTypeId}">
                    </div>
                    <div>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="itemTypeValue">Value</label>
                    <input name="itemTypeValue" id="itemTypeValue" class="form-control" value="${item.value}" disabled>

                </div>
                <div class="form-group col-md-3">
                    <label for="itemTypeWeight">Weight</label>
                    <input name="itemTypeWeight" id="itemTypeWeight" class="form-control" value="${item.weight}" disabled>

                </div>
                <div class="form-group col-md-3">
                    <p><strong>PAT Testing</strong></p>
                    <div class="checkbox">
                        <label for="itemTypeRequiresPat"><input name="itemTypeRequiresPat" id="itemTypeRequiresPat" type="checkbox" <c:if test="${item.requiresPat=='true'}">checked</c:if> disabled> Required</label>
                        </div>
                    </div>
                    <div class="form-group col-md-3">
                        <label for="itemTypePatIntervalMonths">PAT Test Interval</label>
                        <div class="input-group">
                            <input name=itemTypePatIntervalMonths" id="itemTypePatIntervalMonths" type="tel" class="form-control" value="${item.patIntervalMonths}" disabled>
                        <span class="input-group-addon">months</span>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Item details</small></h1>
                    <hr>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="barcode">Barcode</label>
                    <input name="barcode" id="barcode" class="form-control" value="${item.barcode}">
                </div>
                <div class="form-group col-md-6">
                    <label for="description">Description</label>
                    <textarea name="description" id="description" class="form-control">${item.description}</textarea>
                </div>
            </div>
            <div class="form-row">
                <div class-form-group col-md-12>

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Item history</small></h1>
                    <hr>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6 pat-test-history">
                    <h2 id="pat-test-history-heading"><small>PAT test history</small></h2>
                </div>
                <div class="form-group col-md-6 maintenance-history">
                    <h2 id="maintenance-history-heading"><small>Maintenance history</small></h2>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
