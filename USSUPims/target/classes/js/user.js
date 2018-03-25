$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
    $('.selectpicker').selectpicker({
        size: 4
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
                $('#userSearchSelector').find('option').remove();
                $.each(response, function (user) {
                    $('#userSearchSelector').append(
                            $('<option></option>').html(response[user].title + ' ' + response[user].forename + ' ' + response[user].surname).val(response[user].id)
                            );
                });
                $('#userSearchSelector').selectpicker('refresh');
                enableModifyButton();
            }
        });
    });
});

function enableModifyButton() {
    $('#modifyButton').prop("disabled", false);
}

function modifyUser() {
    var id = $('#userSearchSelector').val();
    window.location.replace('user-details?user=' + id);
}

