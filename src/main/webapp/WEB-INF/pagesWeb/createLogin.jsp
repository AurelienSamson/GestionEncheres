<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form id="createLoginForm" method="post" action="${pageContext.request.contextPath}/createLogin" >

    <%@include file="../templates/utilisateurForm.jspf"%>
    
    <div  id="password_block">
        <label  for="password">Mot&nbsp;de&nbsp;passe<i class="text-danger">*</i></label></label>
        <div class="col-md-4">
            <input required type="password"  name="password" id="password" placeholder="Mot de passe">
        </div>
        <label  for="confirm_password">Confirmation<i class="text-danger">*</i></label></label>
        
        <div >
            <input required type="password"  name="confirm_password" id="confirm_password" placeholder="Répétez le mot de passe">
        </div>
    </div>
    
    <%@include file="../templates/showErrors.jspf"%>
    
    <div >
        <input type="submit" value="Créer" >
        <a href="${pageContext.request.contextPath}" >
            <button type="button" >Annuler</button>
        </a>
    </div>
</form>
