<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/pat.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
        <div class="container welcome-bar">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="glyphicon glyphicon-home" href="index"></a></li>
                <li class="breadcrumb-item">PAT Test Reporting</li>
            </ol>
            <h2>PAT Test Reporting</h2>
            <h1><small>PAT testing stats</small></h1>
            <hr>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <canvas id="patStatsWeek"></canvas>
                    <div class="text-muted text-center">Last week</div>
                </div>
                <div class="form-group col-md-4">
                    <canvas id="patStatsMonth"></canvas>
                    <div class="text-muted text-center">Last month</div>
                </div>
                <div class="form-group col-md-4">
                    <canvas id="patStatsYear"></canvas>
                    <div class="text-muted text-center">Last year</div>
                </div>
            </div>
            <div class="form-row">
                <h1><small>Download Microsoft&reg; Excel reports</small></h1>
                <hr>
            </div>
            <div class="form-row">
                <div class="col-md-6">
                    <a href='report/all' class='btn btn-primary dashboard-action'>
                        <p class='button-heading-text'><span class='glyphicon glyphicon-stats'></span> All items</p>
                        <ul>
                            <li>Includes all items in the database</li>
                            <li>Generates a Microsoft&reg; Excel spreadsheet</li>
                        </ul>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/jspf/foot.jspf" %>
</body>
</html>
