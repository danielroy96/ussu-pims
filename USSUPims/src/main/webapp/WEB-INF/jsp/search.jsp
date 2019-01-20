<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/search.js" ></script>
        <link href="css/search-css.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
        <div class="container welcome-bar">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="glyphicon glyphicon-home" href="index"></a></li>
                <li class="breadcrumb-item">Search</li>
            </ol>
            <h2>Search for items</h2>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Scan barcode</small></h1>
                    <hr>
                </div>
            </div>
            <form>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <input name="barcode" id="barcode" class="form-control" placeholder="Scan barcode..." autofocus>
                        <p class="form-text text-muted"><a href="add">Add a new item...</a></p>
                    </div>
                    <div class="form-group col-md-6">
                        <button id="btnScanBarcode" onclick="scanBarcode(); return false;" type="submit" class="btn btn-primary btn-fullwidth">Select item</button>
                    </div>
                </div>
            </form>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Quick search</small></h1>
                    <hr>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <select id="itemSearch" class="selectpicker form-control" data-live-search="true">

                    </select>
                </div>
                <div class="form-group col-md-6">
                    <button id="btnSearch" class="btn btn-primary btn-fullwidth" type="button" onclick="selectQuickSearch();">Select item</button>
                </div>
            </div>
            <div class="form-row">

            </div>
            <%--<div class="form-row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<h1><small>Advanced search</small></h1>--%>
                    <%--<hr>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<label for="searchTerms">Search Terms</label>--%>
                    <%--<input id="searchTerms" class="form-control" type="text">--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-row">--%>
                <%--<div class="form-group col-md-4">--%>
                    <%--<p><strong>PAT Test Status</strong></p>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label for="validPAT"><input name="validPAT" id="validPAT" type="checkbox">PAT test in date</label>--%>
                    <%--</div>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label for="expiringPAT"><input name="expiringPAT" id="expiringPAT" type="checkbox">PAT expiring soon</label>--%>
                    <%--</div>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label for="invalidPAT"><input name="invalidPAT" id="invalidPAT" type="checkbox">PAT test expired</label>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group col-md-4">--%>
                    <%--<p><strong>Other Parameters</strong></p>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label for="validPAT"><input name="validPAT" id="validPAT" type="checkbox">PAT test in date</label>--%>
                    <%--</div>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label for="expiringPAT"><input name="expiringPAT" id="expiringPAT" type="checkbox">PAT expiring soon</label>--%>
                    <%--</div>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label for="invalidPAT"><input name="invalidPAT" id="invalidPAT" type="checkbox">PAT test expired</label>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-row">--%>
                <%--<div class="form-group col-md-12">--%>
                    <%--<button id="btnSearchAdvanced" onclick="advancedSearch(); return false;" class="btn btn-primary btn-fullwidth" type="button">Search</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
