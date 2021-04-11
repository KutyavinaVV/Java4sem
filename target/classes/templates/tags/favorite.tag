<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="navbar" tagdir="/WEB-INF/tags" %>
<c:if test="${error == null}">
<c:if test="${favorite == null}">
<form method="post">
    <p><input type="image" id="addFromFavorite" src="${pageContext.request.contextPath}/images/star.png" alt="ОК"></p>
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="name" value="${title}">
    <input type="hidden" name="action" value="add"/>
</form>
</c:if>
<c:if test="${favorite != null}">
<form method="post">
    <p><input type="image" src="${pageContext.request.contextPath}/images/starGold.png" id="removeFromFavorite"  alt="ОК"></p>
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="name" value="${title}">
    <input type="hidden" name="action" value="delete"/>
</form>
</c:if>
</c:if>

