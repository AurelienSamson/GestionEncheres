<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Use JavaBean to display informations --%>
<h1 >Profil</h1>

<jsp:useBean id="utilisateurRequest"
             scope="request"
             class="fr.formation.gestionencheres.bo.Utilisateur">
</jsp:useBean>
<table >
    <tbody>
        <tr >
            <th  scope="row">Pseudo</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="pseudo"/></td>
        </tr>
        <tr >
            <th  scope="row">Nom</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="nom"/></td>
        </tr>
        <tr class="row">
            <th scope="row">Prénom</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="prenom"/></td>
        </tr>
        <tr class="row">
            <th  scope="row">Email</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="email"/></td>
        </tr>
        <tr class="row">
            <th  scope="row">Téléphone</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="telephone"/></td>
        </tr>
        <tr >
            <th scope="row">Rue</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="rue"/></td>
        </tr>
        <tr >
            <th scope="row">Code&nbsp;Postal</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="codePostal"/></td>
        </tr>
        <tr class="row">
            <th scope="row">Ville</th>
            <td ><jsp:getProperty name="utilisateurRequest" property="ville"/></td>
        </tr>
    </tbody>
</table>
<%--@elvariable id="canUpdate" type="boolean"--%>
<c:if test="${ canUpdate }">
    <a  href="${pageContext.request.contextPath}/updateProfile">
        <button >Modifier mon profil</button>
    </a>
</c:if>