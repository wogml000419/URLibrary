<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  	<link rel="stylesheet" href="${contextPath}/css/timeline.css" type="text/css">
  </head>
  <body>
    <%@ include file="nav.jsp" %>
    <main role="main" class="container content-area">
      <div class="row">
        <div class="col-sm-8 userinfo-main">
          <div class="userinfo-area">
            <img src="${contextPath}/image/profiles/${user.id}.jpg">
            <h3>${user.nickname}</h3>
            <p>정보 1</p>
            <p>정보 2</p>
            <p>정보 3</p>
          </div>
          
          <h2 class="white">You are following: </h2>
          <c:forEach items="${follows}" var="follow">
	        <div class="user row">
	          <img class="small-profile" src="${contextPath}/image/profiles/${follow.id.replace('@', '')}.jpg">
	          <div class="col"><h3 class="username">${follow.nickname}</h3></div>
	          <button class="btn btn-danger" id="unfollow" user="${follow.id}">Unfollow</button>
	        </div>
          </c:forEach>
        </div>
      </div>
    </main>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>	
  </body>
</html>