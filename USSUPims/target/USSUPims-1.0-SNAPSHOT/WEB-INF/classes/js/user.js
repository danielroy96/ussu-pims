$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});

var xmlHttpRequest = new XMLHttpRequest();

function searchUsers() {
    var forename = document.getElementById('forename').value;
    var surname = document.getElementById('surname').value;
    xmlHttpRequest.open('GET', "user/search/f=" + forename + "/s=" + surname, true);
    xmlHttpRequest.send();
    xmlHttpRequest.onreadystatechange = processSearchUsersResults;
}

function processSearchUsersResults() {
    var container = document.getElementById('search-result-tbody')
    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        results = JSON.parse(xmlHttpRequest.response);
        $("#search-result-container").hide();
        while (container.firstChild) {
            container.removeChild(container.firstChild);
        }
        results.forEach(function (result) {
            $("#search-result-container").show();
            appendSearchResult(result.username, result.title, result.forename, result.surname, result.id);
        });
    }
    if ($("#search-result-tbody").children().length === 0) {
        $("#no-results-alert").show();
    } else {
        $("#no-results-alert").hide();
    }

}

function appendSearchResult(username, title, forename, surname, id) {
    var container = document.getElementById('search-result-tbody');
    var resultContainer = document.createElement('tr');
    var usernameContainer = document.createElement('td');
    var fullNameContainer = document.createElement('td');
    var modifyUserContainer = document.createElement('td');
    //var button = document.createElement('button');
    //button.appendChild(document.createTextNode('Modify user'));

    usernameContainer.appendChild(document.createTextNode(username));
    fullNameContainer.appendChild(document.createTextNode(title + ' ' + forename + ' ' + surname));
    //modifyUserContainer.appendChild(button);
    $("<a>", {
        href: "/pims/user-details?user=" + id,
        text: "Modify user..."
    }).appendTo(modifyUserContainer);
    resultContainer.appendChild(usernameContainer);
    resultContainer.appendChild(fullNameContainer);
    resultContainer.appendChild(modifyUserContainer);
    container.appendChild(resultContainer);
}

function resetPassword() {
    var newPassword = $('#newPassword').val();
    var userID = $('#userID').val();
    ;
    xmlHttpRequest.open('GET', 'user/' + userID + '/resetpassword/password=' + newPassword, true);
    xmlHttpRequest.send();
    xmlHttpRequest.onreadystatechange = processResetPassword;
}

function processResetPassword() {
    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
        $('#newPassword').val('');
        $('#passwordModal').modal('hide')

        $('#passwordResetAlert').show();
    }
}

function closePasswordResetAlert() {
    $('#passwordResetAlert').hide();
}

function closeUserCreateAlert() {
    $('#userCreateAlert').hide();
}

function closeUserUpdateAlert() {
    $('#userUpdateAlert').hide();
}

function closeUserDeleteAlert() {
    $('#userDeleteAlert').hide();
}

function createUser() {
    var username = encodeURIComponent($('#username').val());
    var password = encodeURIComponent($('#password').val());
    var title = encodeURIComponent($('#title').val());
    var forename = encodeURIComponent($('#forename').val());
    var surname = encodeURIComponent($('#surname').val());
    var userType = encodeURIComponent($('input[name=userType]:checked').val());
    var userRole = encodeURIComponent($('input[name=userRole]:checked').val());
    $.ajax({
        url: 'user?username=' + username + '&password=' + password + '&title=' + title + '&forename=' + forename + '&surname=' + surname + '&userRole=' + userRole + '&userType=' + userType,
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            window.location = "user-details?user=" + response + "&created=true";
        },
        error: function (xhr, status, error) {
            alert(xhr.responseText);
        }
    });
    return false;
}

function updateUser() {
    var userID = $('#userID').val();
    var title = encodeURIComponent($('#title').val());
    var forename = encodeURIComponent($('#forename').val());
    var surname = encodeURIComponent($('#surname').val());
    var userType = encodeURIComponent($('input[name=userType]:checked').val());
    var userRole = encodeURIComponent($('input[name=userRole]:checked').val());
    $.ajax({
        url: 'user/' + userID + '?title=' + title + '&forename=' + forename + '&surname=' + surname + '&userRole=' + userRole + '&userType=' + userType,
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            $('#userUpdateAlert').show();
        },
        error: function (xhr, status, error) {
            alert(status);
        }
    });
}

function deleteUser() {
    var userID = $('#userID').val();
    $.ajax({
        url: 'user/' + userID,
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            $('#deleteModal').modal('hide')
            $('#userDeleteAlert').show();
        },
        error: function (xhr, status, error) {
            alert(status);
        }
    });
}

function processCreateUser() {

}