<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/add.js" ></script>
        <link href="css/add-css.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
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
