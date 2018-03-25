$(document).ready(function () {
    $('.selectpicker').selectpicker({
        size: 4
    });
    $('#patTest').parsley({
    excluded: "input[type=button], input[type=submit], input[type=reset], input[type=hidden], input:hidden"
});
    $('.bootstrap-select-searchbox').children(['input']).keyup(function (e) {
        var code = (e.keyCode || e.which);
        if (code == 37 || code == 38 || code == 39 || code == 40) {
            return;
        }
        var searchTerm = $('.bootstrap-select-searchbox').children(['input']).val();
        $.ajax({
            url: 'user/quicksearch?searchTerm=' + searchTerm,
            type: "GET",
            success: function (response) {
                $('#testOperator').find('option').remove();
                $.each(response, function (user) {
                    $('#testOperator').append(
                            $('<option></option>').html(response[user].title + ' ' + response[user].forename + ' ' + response[user].surname).val(response[user].id)
                            );
                });
                $('#testOperator').selectpicker('refresh');
            }
        });
    });
});

function test() {
    $('#patTest').parsley().validate();
    if ($('#patTest').parsley().isValid()) {
        var testOperator = $('#testOperator').val();
        var testOperatorName = $("#testOperator option:selected").text();
        var barcode = $('#itemBarcode').val();
        var earthResistanceOhms = $('#earthResistanceOhms').val();
        var insulationResistanceMOhms = $('#insulationResistanceMOhms').val();
        var includeTestMeasurements = $('#includeTestMeasurements').prop('checked');
        $.ajax({
            url: 'item/' + barcode + '/check',
            type: "GET",
            success: function (response) {
                actionTest(testOperator, testOperatorName, barcode, earthResistanceOhms, insulationResistanceMOhms, includeTestMeasurements);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#itemBarcode').addClass('parsley-error');
            }
        });

    }
}

function enableDisableTestMeasurements() {
    $('.testMeasurements').toggle();
}

function actionTest(testOperator, testOperatorName, barcode, earthResistanceOhms, insulationResistanceMOhms, includeTestMeasurements) {
            if (includeTestMeasurements === true) {
            $.ajax({
                url: 'item/' + barcode + '/testmeasurements?earthResistanceOhms=' + earthResistanceOhms + '&insulationResistanceMOhms=' + insulationResistanceMOhms + '&testOperator=' + testOperator,
                type: "PUT",
                success: function (response) {
                    addCompletedTestRow(barcode, testOperatorName);
                    resetScreen();
                }
            });
        } else {
            $.ajax({
                url: 'item/' + barcode + '/test?testOperator=' + testOperator,
                type: "PUT",
                success: function (response) {
                    addCompletedTestRow(barcode, testOperatorName);
                    resetScreen();
                }
            });
        }
        $('#noTestAlert').hide();
}

function addCompletedTestRow(barcode, testOperator) {
    $('#completedTestTable').show();
    $('#completedTestTable tr:first').after('<tr><td>' + barcode + '</td><td>' + testOperator + '</td></tr>');
}

function resetScreen() {
    $('#itemBarcode').val('');
    $('#earthResistanceOhms').val('');
    $('#insulationResistanceMOhms').val('');
}
