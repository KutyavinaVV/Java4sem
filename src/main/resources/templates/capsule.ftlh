<#import "__header.ftlh" as header/>
<#import "__scrirts.ftlh" as script/>
<#import "tags/CarouselTag.ftlh" as carusel/>
<#import "tags/NavbarTag.ftlh" as navbar>
<#import "/spring.ftl" as spring/>
<body>
<@header.header />
<@script.script />
<@navbar.navbar />
<div class="profile_info">
    <div class="row">
        <dt class="col-sm-1"> <@spring.message "name"/> <br> <br>
            <div class="dropdown update">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink20" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <@spring.message "edit"/>
                </a>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink20">
                    <form method="post" action="/profile/changename">
                        <input type="text" name="name" placeholder="name">
                    </form>
                </div>
            </div>
        </dt>
        <dd class="col-sm-1">${user.getUsername()}</dd>

        <dt class="col-sm-1"><@spring.message "email"/></dt>
        <dd class="col-sm-2">
            <p>${user.getEmail()}</p>
        </dd>

        <dt class="col-sm-2"><@spring.message "appointment"/></dt>
        <ul class="col-sm-2">
            <#list appointments as appointment>
                <li>${appointment.getFullName()} ${appointment.getDate()}${appointment.getTime()}</li>
            </#list>
        </ul>
        <dd class="col-sm-1">
            <div class="dropdown update">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <@spring.message "delete"/>
                </a>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink2">
                    <form method="post" action="/profile/delete">
                        <input type="text" name="delete" placeholder="Say Yes">
                    </form>
                </div>
            </div>
        </dd>
        <dd class="col-sm-2">
            <a href="<@spring.url "/logout"/>" class="btn btn-secondary btn-lg active " style="width: 130px; height: 55px; margin: -4px 0 0 10px;" role="button" aria-pressed="true">Sign Out</a>
        </dd>
    </div>
</div>
<div class="row">
    <#list capsule.getProductList() as product>
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
                <a href="${product.getLink()}" class="card-link"><@spring.message "link"/></a>
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
</div>

</body>