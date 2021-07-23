<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr">
<%@include file="templates/head.jsp"%>
<body class="m-2">
  <c:if test="${page == 'login'}">
    <%@include file="pagesWeb/login.jsp"%>
  </c:if>
  
  <c:if test="${page == 'createLogin'}">
    <%@include file="pagesWeb/createLogin.jsp"%>
  </c:if>
  
  <c:if test="${page == 'home'}">
    <%@include file="pagesWeb/home.jsp"%>
  </c:if>
  
  <c:if test="${page == 'profile'}">
    <%@include file="pagesWeb/profile.jsp"%>
  </c:if>
  
  <c:if test="${page == 'updateProfile'}">
    <%@include file="pagesWeb/updateProfile.jsp"%>
  </c:if>

  <c:if test="${page == 'createVente'}">
    <%@include file="pagesWeb/createVente.jsp"%>
  </c:if>
  
  <c:if test="${page == 'seeEnchere'}">
    <%@include file="pagesWeb/enchere.jsp"%>
  </c:if>
  
  <c:if test="${page == 'setEnchere'}">
    <%@include file="pagesWeb/setEnchere.jsp"%>
  </c:if>
  
</body>
</html>