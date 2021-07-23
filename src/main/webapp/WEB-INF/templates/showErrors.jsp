<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="lstErrors" type="java.util.ArrayList"--%>
<c:if test="${!empty lstErrors }">
    <ul >
        <c:forEach var="error" items="${lstErrors }">
            <li class="text-danger list-group-item border-0">
                    ${error }
            </li>
        </c:forEach>
    </ul>
</c:if>