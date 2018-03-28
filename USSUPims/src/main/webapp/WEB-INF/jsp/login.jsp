<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/lib.jspf" %>
        <link type="text/css" href="css/login-css.css" rel="stylesheet"></link>
    </head>
    <body>
        <div class="site-wrapper">
            <!--Simple login form-->
            <div class="site-wrapper-inner">
                <div class="cover-container">
                    <form name='f' class="form-signin" action="login" method='POST'>
                        <h2 class="form-signin-heading"><img src="img/logo.png">PIMS Login</h2>
                        <div id="loginFailAlert" class="alert alert-danger alert-dismissable" <c:if test="${empty error}">hidden="true"</c:if>>
                                Your login attempt failed. Please try again.
                            </div>
                            <div id="logoutAlert" class="alert alert-info alert-dismissable" <c:if test="${empty logout}">hidden="true"</c:if>>
                            You've been successfully logged out.
                        </div>
                        <label for="username" class="sr-only">Username</label>
                        <input type='text' name='username' class="form-control" value='' placeholder="Username" required autofocus>
                        <label for="password" class="sr-only">Password</label>
                        <input type='password' name='password' class="form-control" placeholder="Password" required/>
                        <input name="submit" class="btn btn-lg btn-primary btn-block" type="submit" value="Login" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>