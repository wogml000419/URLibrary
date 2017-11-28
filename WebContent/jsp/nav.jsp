<%@ page language="java" contentType="text/html; charset=UTF-8"
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
                <a class="nav-link" href="${contextPath}/jsp/post.jsp"></a>
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