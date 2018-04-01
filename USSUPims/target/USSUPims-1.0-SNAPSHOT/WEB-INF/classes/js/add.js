$(document).ready(function () {
    $('#addItemType').parsley({
        excluded: "input[type=button], input[type=submit], input[type=reset], input[type=hidden], input:hidden"
    });
    window.Parsley.addValidator('patmonths', {
        validateString: function (value) {
            if ($('#newItemTypePATinterval').attr('checked') && $('#newItemTypePATinterval').val() === "") {
                return false;
            } else {
                return true;
            }
        }
    });
    $('.selectpicker').selectpicker({
        size: 4
    });
    $('.bootstrap-select-searchbox').children(['input']).attr("autocomplete", 'off');
    $('.bootstrap-select-searchbox').children(['input']).attr("autocorrect", 'off');
    $('.bootstrap-select-searchbox').children(['input']).attr("autocapitalize", 'off');
    $('.bootstrap-select-searchbox').children(['input']).attr("spellcheck", 'false');
    $('.bootstrap-select-searchbox').children(['input']).keyup(function (e) {
        var code = (e.keyCode || e.which);
        if (code == 37 || code == 38 || code == 39 || code == 40) {
            return;
        }
        var searchTerm = $('.bootstrap-select-searchbox').children(['input']).val();
        if (searchTerm.length < 4) {
            return;
        }
        $('.bootstrap-select').removeClass('parsley-error');
        $.ajax({
            url: 'item/type/search?searchTerm=' + searchTerm,
            type: "GET",
            success: function (response) {
                $('#itemTypeName').find('option').remove();
                $.each(response, function (itemType) {
                    $('#itemTypeName').append(
                            $('<option>').html(response[itemType].name).val(response[itemType].id)
                            );
                });
                $('#itemTypeName').selectpicker('refresh');
            }
        });
    });

});

function addItemType() {
    $('#addItemType').parsley().validate();
    if ($('#newItemTypePATrequired').prop('checked') && $('#newItemTypePATinterval').val() == "") {
        $('#newItemTypePATinterval').addClass('parsley-error');
    }
    if ($('#addItemType').parsley().isValid() && $('.parsley-error').length === 0) {
        var newItemTypeName = encodeURIComponent($('#newItemTypeName').val());
        var newItemTypeValue = encodeURIComponent($('#newItemTypeValue').val() || null);
        var newItemTypeWeight = encodeURIComponent($('#newItemTypeWeight').val() || null);
        var newItemTypePATrequired = 0;
        if ($('#newItemTypePATrequired').val() === 'on') {
            newItemTypePATrequired = 1;
        } else {
            newItemTypePATrequired = 0;
        }
        var newItemTypePATinterval = encodeURIComponent($('#newItemTypePATinterval').val() || null);
        $.ajax({
            url: 'item-type?name=' + newItemTypeName + '&value=' + newItemTypeValue + '&weight=' + newItemTypeWeight + '&requiresPAT=' + newItemTypePATrequired + '&PATIntervalMonths=' + newItemTypePATinterval,
            type: "PUT",
            success: function (response) {
                $('#itemTypeName').append($('<option>', {id: response.id, selected: "true"}).html(response.name));
                $('#itemTypeName').selectpicker('refresh');
            }
        });
        $('#itemTypeAddModal').modal('hide');
    } else {
        return false;
    }
}

function enableDisablePATInterval() {
    $('#newItemTypePATinterval').html('').removeClass('parsley-error');
    $('#PATIntervalGroup').toggle();
}

function addItem() {
    $('#newItem').parsley().validate();
    var itemBarcode = encodeURIComponent($('#itemBarcode').val());
    var itemTypeName = encodeURIComponent($('#itemTypeName').val());
    if (itemTypeName === "null") {
        $('.bootstrap-select').addClass('parsley-error');
    }
    $.ajax({
        url: 'item/' + itemBarcode + '/check',
        type: "GET",
        success: function (response) {
            if (response === "barcode_in_use") {
                $('#itemBarcode').addClass('parsley-error');
                return;
            } else {
                $('#itemBarcode').removeClass('parsley-error');
            }
        }
    });
    
    if ($('#newItem').parsley().isValid() && $('.parsley-error').length === 0) {
        var description = encodeURIComponent($('#description').val() || null);
        $.ajax({
            url: 'item?itemType=' + itemTypeName + '&description=' + description + '&barcode=' + itemBarcode,
            type: "PUT",
            success: function (response) {
                window.location.replace('item?itemBarcode=' + response);
            }
        });
    }

}