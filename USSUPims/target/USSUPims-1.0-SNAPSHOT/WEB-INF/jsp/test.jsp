<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
        <script src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="webjars/parsleyjs/2.7.2/parsley.min.js"></script>
        <script src="webjars/bootstrap-select/1.4.2/bootstrap-select.min.js"></script>
        <script src="webjars/ajax-bootstrap-select/1.4.0/dist/js/ajax-bootstrap-select.js"></script>
        <script src="js/test.js" ></script>
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-select/1.4.2/bootstrap-select.min.css" rel="stylesheet">
        <link href="webjars/ajax-bootstrap-select/1.4.0/dist/css/ajax-bootstrap-select.css" rel="stylesheet">
        <link href="css/dashboard-css.css" rel="stylesheet">
        <link href="css/test-css.css" rel="stylesheet">
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
                <li class="breadcrumb-item">PAT Testing</li>
            </ol>
            <h2>PAT Testing</h2>
            <h1><small>Test an item</small></h1>
            <hr>
            <form id="patTest" data-parsley-validate onsubmit="test(); return false;">
                <div class="form-row">
                    <div class="form-group col-md-8">
                        <label for="testOperator">Test Operator</label>
                        <select id="testOperator" class="selectpicker form-control" data-live-search="true">
                            <option value="${userID}">${userFullName}</option>
                        </select>
                        <p class="form-text text-muted">Start typing to find a user</p>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="itemBarcode">Item Barcode</label>
                        <input id="itemBarcode" class="form-control" type="tel" placeholder="Scan barcode" autofocus required>
                        <p class="form-text text-muted">Your barcode must match an item in PIMS</p>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <div class="checkbox">
                            <p><strong>Test measurements</strong></p>
                            <label for="includeTestMeasurements"><input name="includeTestMeasurements" id="includeTestMeasurements" type="checkbox" onchange="enableDisableTestMeasurements()"> Record test measurements</label>
                        </div>
                    </div>
                    <div class="form-group col-md-4 testMeasurements">
                        <label for="earthResistanceOhms">Earth resistance</label>
                        <div class="input-group">
                            <input class="form-control" type="tel" id="earthResistanceOhms" name="earthResistanceOhms" aria-describedby="earthResistanceOhmsUnits" required>
                            <span class="input-group-addon" id="earthResistanceOhmsUnits">Ω</span>
                        </div>
                    </div>
                    <div class="form-group col-md-4 testMeasurements">
                        <label for="insulationResistanceMOhms">Insulation resistance</label>
                        <div class="input-group">
                            <input class="form-control" type="tel" id="insulationResistanceMOhms" name="insulationResistanceMOhms" aria-describedby="insulationResistanceMOhmsUnits" required>
                            <span class="input-group-addon" id="insulationResistanceMOhmsUnits">MΩ</span>
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <button id="btnTest" class="btn btn-success" type="submit">Test</button>
                    </div>
                </div>
            </form>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <h1><small>Successful tests</small></h1>
                    <hr>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <div id="noTestAlert" class="alert alert-info alert-dismissable">
                        As you test items, their test results will appear here.
                    </div>
                    <table id="completedTestTable" class="table" hidden>
                        <thead>
                            <tr>
                                <th>Barcode</th>
                                <th>Test Operator</th>
                            </tr>
                        </thead>
                        <tbody class="testedItems">
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
