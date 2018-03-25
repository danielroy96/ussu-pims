var xmlHttpRequest = new XMLHttpRequest();

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
    $('#userDetails').parsley().validate();
    if ($('#userDetails').parsley().isValid()) {
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
}

function updateUser() {
    $('#userDetails').parsley().validate();
    if ($('#userDetails').parsley().isValid()) {
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
}

function deleteUser() {
    var userID = $('#userID').val();
    $.ajax({
        url: 'user/' + userID,
        type: "DELETE",
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            $('#deleteModal').modal('hide');
            $('#userDeleteAlert').show();
        },
        error: function (xhr, status, error) {
            alert(status);
        }
    });
}