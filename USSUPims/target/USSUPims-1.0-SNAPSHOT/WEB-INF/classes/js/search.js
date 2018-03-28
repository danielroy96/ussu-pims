$(document).ready(function () {
    $('.selectpicker').selectpicker({
        size: 4
    });
    $('span.filter-option.pull-left').html("Enter a barcode or search term...");
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
        if (searchTerm.length < 3) {
            return;
        }
        $.ajax({
            url: 'item/search?searchTerm=' + searchTerm,
            type: "GET",
            success: function (response) {
                $('#itemSearch').find('option').remove();
                $.each(response, function (item) {
                    $('#itemSearch').append(
                            $('<option></option>').html(response[item].itemTypeName).val(response[item].barcode)
                            );
                });
                $('#itemSearch').selectpicker('refresh');
            }
        });
    });
    $('#barcode').focus();
});

function scanBarcode() {
    var barcode = encodeURIComponent($('#barcode').val());
    window.location.replace('item?itemBarcode=' + barcode);
}

function selectQuickSearch() {
    var barcode = encodeURIComponent($('#itemSearch').val());
    window.location.replace('item?itemBarcode=' + barcode);
}

function advancedSearch() {
    null;
}