<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/test.js" ></script>
        <link href="css/test-css.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
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
                                <th>Item Type</th>
                                <th>Test Operator</th>
                            </tr>
                        </thead>
                        <tbody class="testedItems">
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
