$(document).ready(function () {
    $('.datepicker').datetimepicker({
        format: 'hh:ii dd/mm/yyyy',
        weekStart: 1,
        autoclose: true,
        todayBtn: true
    });
    $('.selectpicker').selectpicker({
        size: 4
    });
    $('#newJob').parsley({
        excluded: "input[type=button], input[type=submit], input[type=reset], input[type=hidden], input:hidden"
    });
});

function addJob() {
    $('#newJob').parsley().validate();
    if ($('#newJob').parsley().isValid()) {
        var name = encodeURIComponent($('#name').val());
        var description = encodeURIComponent($('#description').val() || null);
        var client = encodeURIComponent($('#client').val() || null);
        var jobStartDatetime = encodeURIComponent($('#jobStartDatetime').val() || null);
        var jobEndDatetime = encodeURIComponent($('#jobEndDatetime').val() || null);
        var venue = encodeURIComponent($('#venue').val() || null);
        $.ajax({
            url: 'job?name=' + name + '&description=' + description + '&clientId=' + client + '&jobStartDatetime=' + jobStartDatetime + '&jobEndDatetime=' + jobEndDatetime + '&venue=' + venue,
            type: "PUT",
            success: function (response) {
                window.location.replace('job-details?JobId=' + response);
            }
        });
    }
}

function checkInOutItem() {
    if ($('#btnCheckInOut').hasClass('btn-primary')) {
        //check out
    } else {
        //check in
    }
}

function switchCheckInOut() {
    if ($('#btnCheckInOut').hasClass('btn-primary')) {
        $('#btnSwapCheckInOut').html('Switch to check out');
        $('#btnCheckInOut').addClass('btn-success').removeClass('btn-primary').html('Check in');
    } else {
        $('#btnSwapCheckInOut').html('Switch to check in');
        $('#btnCheckInOut').addClass('btn-primary').removeClass('btn-success').html('Check out');
    }
    refreshJobItems();
}

function refreshJobItems() {
    var jobId = encodeURIComponent($('#jobId').val());
    $.ajax({
        url: 'job/' + jobId,
        type: "GET",
        success: function (response) {
            $('#jobItems').html('');
            for (var i = 0; i < response.length; i++) {
                $('#jobItems').append('<tr><td>' + response[i].item.barcode + '</td><td>' + response[i].item.itemTypeName + '</td><td>' + response[i].status + '</td><td></td></tr>')
            }
        }
    });
}