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
            var patStatsContext = $('#patStatsWeek');
            var patStatsChart = new Chart(patStatsContext, {
                type: 'line',
                data: {
                    labels: last7days,
                    datasets: [{
                            label: 'Me',
                            data: last7testsMe,
                            borderColor: "rgb(92, 184, 92)",
                            backgroundColor: "rgba(92, 184, 92, 0.2)"
                        }, {
                            label: 'Everyone',
                            data: last7tests,
                            borderColor: "rgb(217, 83, 79)",
                            backgroundColor: "rgba(255, 255, 255, 0.2)"
                        }]
                }
            });
        }
    });
    $.ajax({
        url: 'dashboard/chart/test14days',
        type: "GET",
        success: function (response) {
            var last14days = [];
            var last14tests = [];
            var last14testsMe = [];
            for (var i = 0; i < response.length; i++) {
                last14days.push(response[i].label);
                last14tests.push(response[i].value);
                last14testsMe.push(response[i].myValue);
            }
            var patStatsContext = $('#patStatsMonth');
            var patStatsChart = new Chart(patStatsContext, {
                type: 'line',
                data: {
                    labels: last14days,
                    datasets: [{
                            label: 'Me',
                            data: last14testsMe,
                            borderColor: "rgb(92, 184, 92)",
                            backgroundColor: "rgba(92, 184, 92, 0.2)"
                        }, {
                            label: 'Everyone',
                            data: last14tests,
                            borderColor: "rgb(51, 122, 183)",
                            backgroundColor: "rgba(255, 255, 255, 0.2)"
                        }]
                }
            });
        }
    });
    $.ajax({
        url: 'dashboard/chart/test1year',
        type: "GET",
        success: function (response) {
            var months = ["", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"];
            var last12months = [];
            var last12tests = [];
            var last12testsMe = [];
            for (var i = 0; i < response.length; i++) {
                last12months.push(months[response[i].label]);
                last12tests.push(response[i].value);
                last12testsMe.push(response[i].myValue);
            }
            var patStatsContext = $('#patStatsYear');
            var patStatsChart = new Chart(patStatsContext, {
                type: 'line',
                data: {
                    labels: last12months,
                    datasets: [{
                            label: 'Me',
                            data: last12testsMe,
                            borderColor: "rgb(92, 184, 92)",
                            backgroundColor: "rgba(92, 184, 92, 0.2)"
                        }, {
                            label: 'Everyone',
                            data: last12tests,
                            borderColor: "rgb(240, 173, 78)",
                            backgroundColor: "rgba(255, 255, 255, 0.2)"
                        }]
                }
            });
        }
    });
});