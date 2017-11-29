<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

    <link rel="stylesheet" href="${contextPath}/css/nav.css" type="text/css">
    <nav class="navbar navbar-expand-md navbar-dark bg-darkslateblue">
      <a class="navbar-brand" href="${contextPath}/jsp/timeline.jsp">U</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbar">
        <div class="search-area">
          <form class="form-inline my-2 my-md-0 search">
            <input class="form-control" type="text" placeholder="태그(#)나 사이트 URL(@), 내용으로 검색">
          </form>
        </div>
        
        <div class="link-area">
          <ul class="navbar-nav mr-auto">
            <c:if test="${!empty user}"> 
              <li class="nav-item">
                <a class="nav-link" href="#">Timeline</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Other's URLs</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${user.nickname}</a>
                <div class="dropdown-menu" aria-labelledby="dropdown04">
                  <a class="dropdown-item" href="#">My URLs</a>
                  <a class="dropdown-item" href="#">My Friends</a>
                  <a class="dropdown-item" href="${contextPath}/logout.do">Logout</a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" onclick="$('#post-modal').modal()"><img class="postimg" src="${contextPath}/image/Editing-Pen-icon.png"></img></a>
              </li>
            </c:if>
            <c:if test="${empty user}">
              <%
              session.setAttribute("carousel", 0);
              %>
              <form action="${contextPath}/jsp/main.jsp" method="post">
                <button class="btn btn-primary" type="submit">login</button>
              </form>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>
    
    <div class="modal" id="post-modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">새 글 쓰기</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <form action="${contextPath}/post.do" method="post">
	          <div class="modal-body">
	              <div class="form-group">
				    <label for="titleinput">title</label>
				    <input type="text" class="form-control" name="title" id="titleinput" required>
				  </div>
				  <div class="form-group">
				    <label for="urlinput">URL</label>
				    <input type="url" class="form-control" name="url" id="urlinput" required>
				  </div>
				  <div class="form-group">
				    <label for="textinput">text</label>
				    <textarea class="form-control" name="text" id="textinput" rows="3"></textarea>
				  </div>
				  <div class="form-group">
				    <label for="taginput">tags (separated with ",")</label>
				    <input type="text" class="form-control" name="tags" id="taginput">
				  </div>
				  <div class="form-group">
				    <label for="sharewithinput">share with</label>
				    <select class="form-control" id="sharewithinput" name="sharewith" required>
				      <option>everyone</option>
				      <option>friends</option>
				      <option>no one</option>
				    </select>
				  </div>
	          </div>
	          <div class="modal-footer">
	          	<button type="submit" class="btn btn-primary">Submit</button>
	            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	          </div>
          </form>
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
    
    <c:if test="${!empty msg}">
      <script>$(document).ready(function() { $('#error-modal').modal() })</script>
    </c:if>