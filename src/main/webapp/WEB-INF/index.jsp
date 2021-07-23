<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr">
<%@include file="templates/head.jspf"%>
<body class="m-2">
  <c:if test="${page == 'login'}">
    <%@include file="pagesWeb/login.jspf"%>
  </c:if>
  
  <c:if test="${page == 'createLogin'}">
    <%@include file="pagesWeb/createLogin.jspf"%>
  </c:if>
  
  <c:if test="${page == 'home'}">
    <%@include file="pagesWeb/home.jspf"%>
  </c:if>
  
  <c:if test="${page == 'profile'}">
    <%@include file="pagesWeb/profile.jspf"%>
  </c:if>
  
  <c:if test="${page == 'updateProfile'}">
    <%@include file="pagesWeb/updateProfile.jspf"%>
  </c:if>
  
  <c:if test="${page == 'postEnchere'}">
    <%@include file="pagesWeb/createEnchere.jspf"%>
  </c:if>
  
  <c:if test="${page == 'seeEnchere'}">
    <%@include file="pagesWeb/enchere.jspf"%>
  </c:if>
  
  <c:if test="${page == 'updateEncher'}">
    <%@include file="pagesWeb/updateEnchere.jspf"%>
  </c:if>
  
</body>
</html>