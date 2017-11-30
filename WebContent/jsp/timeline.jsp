<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>URLibrary</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
  	<link rel="stylesheet" href="${contextPath}/css/timeline.css" type="text/css">
  	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
  </head>
  <body>
	<script id="post-template" type="text/template">
      <div class="post">
        <div class="profile-area" data-link-wrap="profile_href">
          <img data-src="profile_src">
          <p data-content="nickname"></p>
        </div>
        <div class="title-area">
          <h3 class="post-title" data-content="title"></h3>
          <h3 class="post-simple-url"><a data-href="url" data-content-append="surl">@</a></h3>
          <p class="post-url">URL <a data-href="url" data-content="url"></a></p>
        </div>            
	    <hr>
        <div class="url-text-area">
		  <img class="tumbnail" data-src="url_thumbnail">
		  <h4 data-content="url_title"></h4>
          <p data-content="url_text"></p>
          <div class="clear-float"></div>
        </div>
        <hr>
        <div class="user-text-area">
          <p data-content="user_text"></p>
        </div>
        <div class="tag-area">
          <p class="tags" data-content="tags"></p>
        </div>
      </div>
    </script>
	
    <%@ include file="nav.jsp" %>
    <main role="main" class="container content-area">
      <div class="row">
        <div class="col-sm-8 blog-main">
          <div id="posts">
          
          </div>
          <button class="btn btn-primary" onclick="load_more_post('${search}', ${isTimeline}, '${userToSearch}', true)">Load more</button>
        </div>
        
      </div>
    </main>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  	<script src="${contextPath}/js/plugins/jquery.loadTemplate.js"></script>
  	<script src="${contextPath}/js/getposts.js"></script>
  	<script>$(document).ready(function() { load_more_post('${search}', ${isTimeline}, '${userToSearch}', '${showerror}') })</script>
  </body>
</html>