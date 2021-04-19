<#import "__header.ftlh" as header/>
<#import "__scrirts.ftlh" as script/>
<#import "tags/CarouselTag.ftlh" as carusel/>
<#import "tags/NavbarTag.ftlh" as navbar>
<@header.header />
<body>
<@script.script />
<@navbar.navbar />
<div class="row">
    <#list products as product>
    <div class="card col-sm-4" style="width: 18rem;">
        <img class="card-img-top" src="<c:out value="${pageContext.request.contextPath}${product.getPath()}" />" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title"><c:out value="${product.getName()}"/></h5>
            <p class="card-text"><c:out value="${product.getDescription()}" /></p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item"><c:out value="${product.getComposition()}" /></li>
        </ul>
        <div class="card-body">
            <a href="<c:out value="${product.getLink()}" />" class="card-link">Ссылка на магазин</a>
            <c:if test="${pageContext.request.getSession().getAttribute(\"User\") != null}">
            <div class="dropdown">
                <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Добавить в список
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Создать новую..
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <form method="post">
                            <input type="text" name="nameCapsule" placeholder="name">
                        </form>
                    </div>
                    <c:forEach var="capsule" items="${capsules}">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/intocap?cap=<c:out value="${capsule.getId()}"/>&prod=<c:out value="${product.getId()}"/>&name=<c:out value="${product.getType()}"/>"> <c:out value="${capsule.getName()}"/></a>
                    </c:forEach>
                </div>
            </div>
            </c:if>
        </div>
    </div>
</c:forEach>
    <c:if test="${exception != null}">
        <script>showMessage("${exception}")</script>
    </c:if>
</div>

