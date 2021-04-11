<%@ taglib prefix="navbar" tagdir="/src/main/webapp/templateswebapp/templates/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Your Style</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Articles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}?name=YourOwnStyle">Your own style</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}?name=WhyOne">Why do some people get many outfit, while others have many questions</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}?name=YourOwnStyle">some</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}?name=YourOwnStyle">some(2)</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Clothes
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink2">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/title?name=jeans">jeans</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/title?name=outerwear">outerwear</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/title?name=blazer">blazer</a>
                    <a class="dropdown-item" href="#">swimsuit</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">About</a>
            </li>

            <li class="nav-item">
                <c:if test="${pageContext.request.getSession().getAttribute(\"User\") == null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/signin">Sign in</a>
                </c:if>
                <c:if test="${pageContext.request.getSession().getAttribute(\"User\") != null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/profile">Profile</a>
                </c:if>
            </li>
        </ul>
    </div>
</nav>
