<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>URLibrary</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" href="${contextPath}/css/main.css" type="text/css">
  </head>
  <body>
 	<div class="container row align-items-center main-container">
      <div class="col center">
        <div id="transparent-bg">
          <div id="title-area">
            <h1 class="main-title">URLibrary</h1>
            <h3 class="sub-title">Some text here</h3>
          </div>
          <div id="main-carousel" class="carousel slide" data-interval="false">
  			<div class="carousel-inner">
    		  <div class="carousel-item" id="item0">
      			<form class="login-form" action="${contextPath}/login.do" method="post">
      			  <label for="inputEmail" class="sr-only">Email address</label>
    			  <input type="email" name="id" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>

    			  <label for="inputPassword" class="sr-only">Password</label>
    			  <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required>

    			  <button class="btn btn-primary btn-block" type="submit">Login</button>
    			  <button class="btn btn-secondary btn-block" onclick="$('#main-carousel').carousel('next')">back</button>
      			</form>
    		  </div>
    		  <div class="carousel-item active" id="item1">
      			 <button type="button" class="btn btn-light" id="login" onclick="$('#main-carousel').carousel('prev')">Login</button>
          		 <button type="button" class="btn btn-primary" id="signup" onclick="$('#main-carousel').carousel('next')">Sign up</button>
    		  </div>
    		  <div class="carousel-item" id="item2">
      			<form id="signupForm" class="form-signin" action="${contextPath}/signup.do" method="post">
			      <label for="inputEmail" class="sr-only">Email address</label>
			      <input type="email" name="id" id="inputEmail" class="form-control" value="${param.id}" placeholder="Email address" required autofocus>

			   	  <label for="inputName" class="sr-only">Nickname</label>
				  <input type="text" name="nickname" id="inputNickname" class="form-control" value="${param.nickame}" placeholder="Nickame" required>

			      <label for="inputPassword" class="sr-only">Password</label>
				  <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required>

				  <label for="inputPassword" class="sr-only">Retype Password</label>
				  <input type="password" name="repwd" id="retypePassword" class="form-control" placeholder="Retype Password" required>

			      <button class="btn btn-primary btn-block" type="submit">Sign up</button>
			      <button class="btn btn-secondary btn-block" onclick="$('#main-carousel').carousel('prev')">back</button>
				</form>
    		  </div>
  			</div>
		  </div>
        </div>
      </div>
    </div>
    
    <div class="modal" id="error-modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">${title}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <p>${msg}</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
    <script src="${contextPath}/js/main.js"></script>
    <c:if test="${!empty msg}">
      <script>$(document).ready(function() { $('#error-modal').modal() })</script>
    </c:if>
    <c:if test="${!empty carousel}">
      <script>$(document).ready(function() { $('#main-carousel').carousel(${carousel}) })</script>
      <% session.removeAttribute("carousel"); %>
    </c:if>
  </body>
</html>
