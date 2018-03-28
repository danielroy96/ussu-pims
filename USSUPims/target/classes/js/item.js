$(document).ready(function () {
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
    $.ajax({
        url: 'item/' + barcode + '/event/maintenance',
        type: "GET",
        success: function (response) {
            if (response.length !== 0) {
                $('.maintenance-history').append($('<ul>', {class: 'timeline', id: 'maintenance-timeline'}));
            }
            for (var i = 0, l = response.length; i < l; i++) {
                var classToAdd = '';
                if (i % 2 !== 0) {
                    classToAdd = 'timeline-inverted';
                }
                $('#maintenance-timeline').append(
                        $('<li>', {class: classToAdd + ' maintenance-timeline-item'}).append(
                        $('<div>', {class: 'timeline-panel'}).append(
                        '<h4>' + response[i].displayText + '</h4> ' + response[i].eventDatetime + ' by ' + response[i].eventUserFullname)));
            }
            $('.maintenance-timeline-item').append($('<div>', {class: 'timeline-badge warning maintenance-timeline-badge'}));
            $('.maintenance-timeline-badge').append($('<i>', {class: 'glyphicon glyphicon-wrench'}));
            if (response.length === 0) {
                $('#maintenance-history-heading').replaceWith('<div class="alert alert-warning">This item has no maintenance history.</div>');
            }
        }
    });
});

