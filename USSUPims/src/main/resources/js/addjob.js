$(document).ready(function() {
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
        $.ajax({
            url: 'client?searchTerm=' + searchTerm,
            type: "GET",
            success: function (response) {
                $('#client').find('option').remove();
                $.each(response, function (client) {
                    $('#client').append(
                        $('<option></option>').html(response[client].name).val(response[client].id)
                    );
                });
                $('#client').selectpicker('refresh');
            }
        });
    });
});

function addClient() {
    $('#newClient').parsley().validate();
    if ($('#newClient').parsley().isValid()) {
        var newClientName = encodeURIComponent($('#newClientName').val());
        var newClientContactName = encodeURIComponent($('#newClientContactName').val() || null);
        var newClientContactEmail = encodeURIComponent($('#newClientContactEmail').val() || null);
        var newClientContactPhone = encodeURIComponent($('#newCLientContactPhone').val() || null);
        $.ajax({
            url: 'client?name=' + newClientName + '&contactName=' + newClientContactName + '&contactEmail=' + newClientContactEmail + '&contactPhone=' + newClientContactPhone,
            type: "PUT",
            success: function (response) {
                $('#client').append($('<option>', {id: response, selected: "true"}).html($('#newClientName').val()));
                $('#client').selectpicker('refresh');
            }
        });
        $('#clientModal').modal('hide');
    } else {
        return false;
    }
}