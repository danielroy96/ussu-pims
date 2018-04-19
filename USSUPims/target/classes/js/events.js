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
            url: 'job?searchTerm=' + searchTerm,
            type: "GET",
            success: function (response) {
                $('#jobSearch').find('option').remove();
                $.each(response, function (job) {
                    $('#jobSearch').append(
                        $('<option></option>').html(response[job].name).val(response[job].id)
                    );
                });
                $('#jobSearch').selectpicker('refresh');
            }
        });
    });
});

function selectQuickSearch() {
    var id = encodeURIComponent($('#jobSearch').val());
    window.location.replace('job-details?jobId=' + id);
}