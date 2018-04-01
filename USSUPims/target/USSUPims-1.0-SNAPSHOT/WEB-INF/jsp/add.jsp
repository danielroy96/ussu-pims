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

                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add a new item type</h5>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">
                            <form id="addItemType" data-parsley-validate>
                                <div class="row">
                                    <div class="form-group col-sm-12">
                                        <label for="newItemTypeName">Name</label>
                                        <input name="newItemTypeName" id="newItemTypeName" class="form-control" required>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label for="newItemTypeValue">Value</label>
                                        <input name="newItemTypeValue" id="newItemTypeValue" class="form-control">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="newItemTypeWeight">Weight</label>
                                        <input name="newItemTypeWeight" id="newItemTypeWeight" class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <label for="newItemTypePATrequired">PAT Testing</label>
                                        <div class="checkbox">
                                            <label for="newItemTypePATrequired"><input id="newItemTypePATrequired" type="checkbox" onchange="enableDisablePATInterval();" checked>Required</label>
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6" id="PATIntervalGroup">
                                        <label for="newItemTypePATinterval">PAT Test Interval</label>
                                        <div class="input-group">
                                            <input id="newItemTypePATinterval" type="tel" class="form-control">
                                            <span class="input-group-addon">months</span>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="form-row">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" class="btn btn-primary" onclick="addItemType();">Add item type</button>
                        </div>
                    </div>

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
                        <label for="itemTypeName">Item Type</label>
                        <select id="itemTypeName" class="selectpicker form-control" data-live-search="true">
                        </select>
                        <p class="form-text text-muted">Start typing to find an item type</p>
                        <a data-toggle="modal" data-target="#itemTypeAddModal">Add a new item type...</a>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="description">Description</label>
                        <textarea id="description" class="form-control" placeholder="Enter a description or notes about this item"></textarea>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="itemBarcode">Item Barcode</label>
                        <input id="itemBarcode" class="form-control" type="tel" placeholder="Scan barcode" required>
                        <p class="text-muted">This barcode can't be in use by another item on PIMS</p>
                    </div>
                    <div class="form-group col-md-6">

                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <button id="btnAddItem" class="btn btn-primary" onclick="addItem(); return false;">Add Item</button>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
