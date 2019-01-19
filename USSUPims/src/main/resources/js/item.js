$(document).ready(function () {

    buildTestTimeline();
    buildMaintenanceTimeline();

    $('.selectpicker').selectpicker({
        size: 4
    });
    $('#patTest').parsley({
        excluded: "input[type=button], input[type=submit], input[type=reset], input[type=hidden], input:hidden"
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

function maintainItem() {
    $('#maintainItem').parsley().validate();
    if ($('#maintainItem').parsley().isValid()) {
        var itemBarcode = encodeURIComponent($('#barcode').val());
        var description = encodeURIComponent($('#maintenanceDescription').val());
        console.log('maintain?barcode=' + itemBarcode + '&description=' + description);
        $.ajax({
            url: 'item/' + itemBarcode + '/maintain?description=' + description,
            type: "PUT",
            success: function() {
                $('#maintenanceModal').modal('hide');
                buildMaintenanceTimeline();
            }
        })
    }
}

function test() {
    $('#patTest').parsley().validate();
    if ($('#patTest').parsley().isValid()) {
        var testOperator = $('#testOperator').val();
        var testOperatorName = $("#testOperator option:selected").text();
        var barcode = encodeURIComponent($('#barcode').val());
        var earthResistanceOhms = encodeURIComponent($('#earthResistanceOhms').val() || null);
        var insulationResistanceMOhms = encodeURIComponent($('#insulationResistanceMOhms').val() || null);
        $.ajax({
            url: 'item/' + barcode + '/test?earthResistanceOhms=' + earthResistanceOhms + '&insulationResistanceMOhms=' + insulationResistanceMOhms + '&testOperator=' + testOperator,
            type: "PUT",
            success: function(response) {
                $('#pat-test-timeline').remove();
                buildTestTimeline();
                $('#testModal').modal('hide');
            }
        });

    }
}

function enableDisableTestMeasurements() {
    $('.testMeasurements').toggle();
}

function buildMaintenanceTimeline() {
    var barcode = encodeURIComponent($('#barcode').val());
    $.ajax({
        url: 'item/' + barcode + '/event/maintenance',
        type: "GET",
        success: function (response) {
            if (response.length !== 0) {
                $('#maintenance-timeline').remove();
                $('.maintenance-history').append($('<ul>', {class: 'timeline', id: 'maintenance-timeline'}));
            }
            for (var i = 0, l = response.length; i < l; i++) {
                var classToAdd = '';
                if (i % 2 !== 0) {
                    classToAdd = 'timeline-inverted';
                }
                var maintenanceDescription = "";
                if (response[i].description !== null) {
                    maintenanceDescription = response[i].description;
                }
                $('#maintenance-timeline').append(
                    $('<li>', {class: classToAdd + ' maintenance-timeline-item'}).append(
                        $('<div>', {class: 'timeline-panel'}).append(
                            '<h4>' + response[i].displayText + '</h4><p>' + maintenanceDescription + '</p><p>' + response[i].eventDatetime + ' by ' + response[i].eventUserFullname + '</p>')));
            }
            $('.maintenance-timeline-item').append($('<div>', {class: 'timeline-badge warning maintenance-timeline-badge'}));
            $('.maintenance-timeline-badge').append($('<i>', {class: 'glyphicon glyphicon-wrench'}));
            if (response.length === 0) {
                $('#maintenance-history-heading').replaceWith('<div class="alert alert-warning">This item has no maintenance history.</div>');
            }
        }
    });
}

function buildTestTimeline () {
    var barcode = encodeURIComponent($('#barcode').val());
    $.ajax({
        url: 'item/' + barcode + '/event/test',
        type: "GET",
        success: function (response) {
            if (response.length !== 0) {
                $('.pat-test-history').append($('<ul>', {class: 'timeline', id: 'pat-test-timeline'}));
            }
            for (var i = 0, l = response.length; i < l; i++) {
                var classToAdd = '';
                if (i % 2 !== 0) {
                    classToAdd = 'timeline-inverted';
                }
                $('#pat-test-timeline').append(
                    $('<li>', {class: classToAdd + ' test-timeline-item'}).append(
                        $('<div>', {class: 'timeline-panel'}).append(
                            '<h4>' + response[i].displayText + '</h4> ' + response[i].eventDatetime + ' by ' + response[i].eventUserFullname)));
            }
            $('.test-timeline-item').append($('<div>', {class: 'timeline-badge success test-timeline-badge'}));
            $('.test-timeline-badge').append($('<i>', {class: 'glyphicon glyphicon-ok'}));
            if (response.length === 0) {
                $('#pat-test-history-heading').replaceWith('<div class="alert alert-info">This item has never been PAT tested.</div>');
            }
        }
    });
}