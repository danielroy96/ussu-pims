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