<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <script src="js/user-details.js" ></script>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/nav.jspf" %>
        <div class="container welcome-bar">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a class="glyphicon glyphicon-home" href="index"></a></li>
                <li class="breadcrumb-item"><a href="user">Users</a></li>
                <li class="breadcrumb-item">${userFullName}<c:if test="${empty user.id}">Create a new user</c:if></li>
                </ol>
            </div>
            <div class="modal fade" id="passwordModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form id="passwordReset" onsubmit="resetPassword(); return false;" data-parsley-validate>
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Reset Password for ${userFullName}</h5>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <p>Enter a new password for this user. Passwords must contain at least 8 characters.</p>
                                <label for="newPassword">New password</label>
                                <input id="newPassword" class="form-control" type="password" data-parsley-minlength="8" placeholder="New Password" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Reset Password</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form onsubmit="deleteUser(); return false;">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Delete ${userFullName}</h5>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <p>Deleting users is irreversible, so you wont be able to undo this. Are you sure you want to continue?</p>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-danger">Delete ${userFullName}</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container">
            <h2>${userFullName}<c:if test="${empty user.id}">Create a new user</c:if></h2>
            <p><c:if test="${not empty user.id}">Last updated ${user.start_datetime} by ${user.last_changed_by_user}</c:if></p>
            </div>
            <form id='userDetails' data-parsley-validate>
                <div class="container">
                    <div id="userCreateAlert" class="alert alert-success alert-dismissable" <c:if test="${empty created}">hidden="true"</c:if>>
                        <a href="#" class="close" onclick="closeUserCreateAlert();" aria-label="close">&times;</a>
                        User successfully created.
                    </div>
                    <div id="userDeleteAlert" class="alert alert-warning alert-dismissable" hidden="true">
                        <a href="#" class="close" onclick="closeUserDeleteAlert();" aria-label="close">&times;</a>
                        This user has been deleted.
                    </div>
                    <h1><small>Account details</small></h1>
                    <hr>
                    <input type="text" id="currentUserID" hidden="true" value="${currentUserID}">
                <input type="text" id="userID" hidden="true" value="${user.id}">
                <div id="passwordResetAlert" class="alert alert-success alert-dismissable" hidden="true">
                    <a href="#" class="close" onclick="closePasswordResetAlert();" aria-label="close">&times;</a>
                    Password successfully reset.
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="username">Username</label>
                        <input type="text" required <c:if test="${not empty user.id}">disabled="true"</c:if> class="form-control" id="username" placeholder="Username" value="${user.username}">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="password">Password</label>
                            <input type="password" required data-parsley-minlength="8" <c:if test="${not empty user.id}">disabled="true"</c:if> class="form-control" id="password" placeholder="Password" value="${user.password}">
                            <p class="form-text text-muted">Your password must be at least 8 characters in length.</p>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <c:if test="${not empty user.id}">                            
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#passwordModal">Reset Password</button>

                        </c:if>
                    </div>
                </div>
            </div>
            <div class="container">
                <h1><small>User details</small></h1>
                <hr>
                <div id="userUpdateAlert" class="alert alert-success alert-dismissable" hidden="true">
                    <a href="#" class="close" onclick="closeUserUpdateAlert();" aria-label="close">&times;</a>
                    User successfully updated.
                </div>
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="title">Title</label>
                        <input type="text" id="title" class="form-control" placeholder="Title" value="${user.title}" required>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="forename">Forename</label>
                        <input type="text" id="forename" class="form-control" placeholder="Forename" value="${user.forename}" required>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="surname">Surname</label>
                        <input type="text" id="surname" class="form-control" placeholder="Surname" value="${user.surname}" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="userType">Membership type</label>
                        <div class="radio">
                            <label for="typeStudent"><input name="userType" type="radio" id="typeStudent" value="STUDENT" required <c:if test="${user.type == 'STUDENT' || empty user.type}">checked</c:if>>Current student member</label>
                            </div>
                            <div class="radio">
                                <label for="typeAssociate"><input name="userType" type="radio" id="typeAssociate" value="ASSOCIATE" required <c:if test="${user.type == 'ASSOCIATE'}">checked</c:if>>Associate member</label>
                            </div>
                            <div class="radio">
                                <label for="typeStaff"><input name="userType" type="radio" id="typeStaff" value="STAFF" required <c:if test="${user.type == 'STAFF'}">checked</c:if>>Students' union staff</label>
                            </div>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="userRole">User account role</label>
                            <div class="radio">
                                <label for="roleUser"><input name="userRole" type="radio" id="roleUser" value="ROLE_USER" required <c:if test="${user.role == 'ROLE_USER' || empty user.role}">checked</c:if>>Normal user account</label>
                            </div>
                            <div class="radio">
                                <label for="roleAdmin" data-toggle="tooltip" data-placement="right" title="Admin users can create/modify user accounts"><input name="userRole" type="radio" id="roleAdmin" value="ROLE_ADMIN" required <c:if test="${user.role == 'ROLE_ADMIN'}">checked</c:if>>Admin user account</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-12">
                        <c:if test="${empty user.id}"><button type="button" onclick="createUser(); return false;" class="btn btn-primary">Create user</button></c:if>
                        <c:if test="${not empty user.id}"><button type="button" onclick="updateUser(); return false;" class="btn btn-primary">Update user</button></c:if>
                        <c:if test="${not empty user.id}"><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete user</button></c:if>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
