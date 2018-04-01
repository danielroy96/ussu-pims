$(document).ready(function () {
    Chart.defaults.global.defaultFontFamily = "Open Sans";
    $.ajax({
        url: 'dashboard/chart/test7days',
        type: "GET",
        success: function (response) {
            var days = ["Su", "M", "Tu", "W", "Th", "F", "Sa"];
            var last7days = [];
            var last7tests = [];
            var last7testsMe = [];
            for (var i = 0; i < response.length; i++) {
                last7days.push(days[new Date(response[i].label).getDay()]);
                last7tests.push(response[i].value);
                last7testsMe.push(response[i].myValue);
            }
            var patStatsContext = $('#patStatsChart');
            var patStatsChart = new Chart(patStatsContext, {
                type: 'line',
                data: {
                    labels: last7days,
                    datasets: [{
                            label: 'Me',
                            data: last7testsMe,
                            borderColor: "#d9534f",
                            backgroundColor: "rgba(217, 83, 79, 0.2)"
                        }, {
                            label: 'Everyone',
                            data: last7tests,
                            borderColor: "#5cb85c"
                        }]
                }
            });
        }
    });


});

function resetPassword() {
    $('#passwordReset').parsley().validate();
    if ($('#passwordReset').parsley().isValid()) {

        var newPassword = $('#newPassword').val();
        var userID = $('#userID').val();

        xmlHttpRequest.open('GET', 'user/' + userID + '/resetpassword/password=' + newPassword, true);
        xmlHttpRequest.send();
        xmlHttpRequest.onreadystatechange = processResetPassword;
    }
}