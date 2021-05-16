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
            <img class="card-img-top" src="${product.getPath()}" />
            <div class="card-body">
                <h5 class="card-title">${product.getName()}</h5>
                <p class="card-text">${product.getDescription()}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${product.getComposition()}</li>
            </ul>
            <div class="card-body">
                <a href="${product.getLink()}" class="card-link">Ссылка на магазин</a>
                <#if user??>
                    <div class="dropdown">
                        <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Добавить в список
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Создать новую..
                            </a>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <form method="post" action="/capsule/create">
                                    <input type="text" name="name" placeholder="name">
                                </form>
                            </div>
                            <#if capsules??>
                                <#list capsules as capsul>
                                    <a class="dropdown-item capsule" data-capsule-id="${capsul.getId()}" data-product-id="${product.getId()}" > ${capsul.getName()} </a>
                                </#list>
                            </#if>
                        </div>
                    </div>
                </#if>
            </div>
        </div>
    </#list>

    <script
            src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
            crossorigin="anonymous"></script>

    <script type="text/javascript" src="../static/js/product.js"> </script>
</div>