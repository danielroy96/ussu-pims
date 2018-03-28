<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
        <script src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="js/add.js" ></script>
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/dashboard-css.css" rel="stylesheet">
        <link href="css/add-css.css" rel="stylesheet">
        <title>PIMS</title>
    </head>
    <body>
        <div class="modal fade" id="itemTypeAddModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form id="addItemType" onsubmit="addItemType(); return false;" data-parsley-validate>
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add a new item type</h5>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="form-group col-sm-12">
                                        <label for="itemTypeName">Name</label>
                                        <input name="itemTypeName" id="itemTypeName" class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label for="itemTypeValue">Value</label>
                                        <input name="itemTypeValue" id="itemTypeValue" class="form-control">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="itemTypeWeight">Weight</label>
                                        <input name="itemTypeWeight" id="itemTypeWeight" class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label for="PATrequired">PAT Testing</label>
                                        <div class="checkbox">
                                            <label for="PATrequired"><input id="PATrequired" type="checkbox" onchange="enableDisablePATInterval();" checked>Required</label>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6" id="PATIntervalGroup">
                                        <label for="PATinterval">PAT Test Interval</label>
                                        <div class="input-group">
                                            <input id="PATinterval" type="tel" class="form-control">
                                            <span class="input-group-addon">months</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div class="form-row">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-primary">Add item type</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
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
            <li class="breadcrumb-item">Add items</li>
        </ol>
        <h2>Add items to PIMS</h2>
        <h1><small>Item details</small></h1>
        <hr>
        <form id="newItem">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="name">Item type</label>
                    <input id="name" class="form-control" type="text">
                    <a data-toggle="modal" data-target="#itemTypeAddModal">Add a new item type...</a>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="description">Description</label>
                    <textarea id="description" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="itemBarcode">Item Barcode</label>
                    <input id="itemBarcode" class="form-control" type="tel" placeholder="Scan barcode" required>
                </div>
                <div class="form-group col-md-6">

                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <button id="btnAddItem" class="btn btn-primary">Add Item</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
