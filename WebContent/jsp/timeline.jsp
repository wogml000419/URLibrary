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
  	<link rel="stylesheet" href="${contextPath}/css/timeline.css" type="text/css">
  </head>
  <body>
	<script id="post-template" type="text/template">
      <div class="post">
        <div class="profile-area">
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
          <div class="post">
            <div class="profile-area">
              <img src="${contextPath}/image/tmpprofile2.jpg">
              <p>시공좋아</p>
            </div>
          	<div class="title-area">
              <h3 class="post-title">Sample blog post</h3>
              <h3 class="post-simple-url"><a href='#'>@Facebook.com</a></h3>
              <p class="post-url">URL <a href="#">https://www.facebook.com/choich00?fref=nf</a></p>
            </div>            
			<hr>
			<div class="url-text-area">
			  <img class="tumbnail" src="${contextPath}/image/library.jpg">

              <p>
              Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
              </p>
              <div class="clear-float"></div>
            </div>
            <hr>
            <div class="user-text-area">
              <p>
              Etiam porta sem malesuada magna mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.

Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
              </p>
            </div>
            <div class="tag-area">
              <p class="tags">#집가고싶어 #asdf #워쓰한궈런 #인디_게임_위크엔드 #후성아_고생이_많다 #더_써야_하는데 #프론트엔드_너무_어려워</p>
            </div>
          </div><!-- /.blog-post -->

          <div class="post">
            <div class="profile-area">
              <img src="${contextPath}/image/tmpprofile1.jpg">
              <p>나는스레기에오</p>
            </div>
          	<div class="title-area">
              <h3 class="post-title">Sample blog post</h3>
              <h3 class="post-simple-url"><a href='#'>@Facebook.com</a></h3>
              <p class="post-url">URL <a href="#">https://www.facebook.com/choich00?fref=nf</a></p>
            </div>            
			<hr>
			<div class="url-text-area">
			  <img class="tumbnail" src="${contextPath}/image/wooden.jpg">

              <p>
              Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
              </p>
              <div class="clear-float"></div>
            </div>
            <hr>
            <div class="user-text-area">
              <p>
              Etiam porta sem malesuada magna mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.

Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
              </p>
            </div>
            <div class="tag-area">
              <p class="tags">#집가고싶어 #asdf #워쓰한궈런 #인디_게임_위크엔드 #후성아_고생이_많다 #더_써야_하는데 #프론트엔드_너무_어려워 #태그_하나_더</p>
            </div>
          </div>

          <div class="post">
            <div class="profile-area">
              <img src="${contextPath}/image/tmpprofile3.png">
              <p>클릭클락</p>
            </div>
          	<div class="title-area">
              <h3 class="post-title">Sample blog post</h3>
              <h3 class="post-simple-url"><a href='#'>@Facebook.com</a></h3>
              <p class="post-url">URL <a href="#">https://www.facebook.com/choich00?fref=nf</a></p>
            </div>            
			<hr>
			<div class="url-text-area">
			  <img class="tumbnail" src="${contextPath}/image/whiteboard.jpg">

              <p>
              Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
              </p>
              <div class="clear-float"></div>
            </div>
            <hr>
            <div class="user-text-area">
              <p>
              Etiam porta sem malesuada magna mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.

Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
              </p>
            </div>
            <div class="tag-area">
              <p class="tags">#집가고싶어 #asdf #워쓰한궈런 #인디_게임_위크엔드 #후성아_고생이_많다 #더_써야_하는데 #프론트엔드_너무_어려워 #태그_하나_더 #대기대기김대기</p>
            </div>
          </div>
          </div>
          <button class="btn btn-primary" onclick="load_more_post()">Load more</button>
        </div>
        
      </div>
    </main>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
  	<script src="${contextPath}/js/plugins/jquery.loadTemplate.js"></script>
  	<script src="${contextPath}/js/getposts.js"></script>
  </body>
</html>