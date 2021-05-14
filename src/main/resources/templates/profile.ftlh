<#import "__header.ftlh" as header/>
<#import "__scrirts.ftlh" as script/>
<#import "tags/CarouselTag.ftlh" as carusel/>
<#import "tags/NavbarTag.ftlh" as navbar>
<body>
<@header.header />
<@script.script />
<@navbar.navbar />
<div class="profile_info">
    <div class="row">
        <dt class="col-sm-1"> Имя <br> <br>
            <div class="dropdown update">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink20" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    update
                </a>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink20">
                    <form method="post" action="/profile/changename">
                        <input type="text" name="name" placeholder="name">
                    </form>
                </div>
            </div>
        </dt>
        <dd class="col-sm-1">${user.getUsername()}</dd>

        <dt class="col-sm-1">Email</dt>
        <dd class="col-sm-2">
            <p>${user.getEmail()}</p>
        </dd>

        <dt class="col-sm-2">Мои записи</dt>
        <ul class="col-sm-2">
            <#list appointments as appointment>
                <li id="${appointment.getId()}" >${appointment.getFullName()} ${appointment.getDate()}${appointment.getTime()}
                <img src="/images/trash.png" class="removeAppointment" data-id="${appointment.getId()}" alt="">
                </li>
            </#list>
        </ul>
        <dd class="col-sm-1">
            <div class="dropdown update">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    delete
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink2">
                    <form method="post" action="/profile/delete">
                        <input type="text" name="delete" placeholder="Say Yes">
                    </form>
                </div>
            </div>
        </dd>
        <dd class="col-sm-2">
            <a href="/logout" class="btn btn-secondary btn-lg active " style="width: 130px; height: 55px; margin: -4px 0 0 10px;" role="button" aria-pressed="true">Sign Out</a>
        </dd>
    </div>
</div>
<div class="row">
    <#list capsules as capsule>
        <div class="card col-sm-4" style="width: 18rem;">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <#list capsule.getProductList() as product>
                            <div class="carousel-active">
                                <img src="${product.getPath()}" />
                            </div>
                            <#break>
                        </#list>
                        <#list capsule.getProductList() as product>
                            <div class="carousel-item">
                                <img src="${product.getPath()}" />
                            </div>
                            <#break>
                        </#list>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

            <div class="card-body">
                <a href="/capsule/${capsule.getId()}"><h5 class="card-title">${capsule.getName()}</h5></a>
            </div>
            <#list capsule.getProductList() as product>
                <div class="card-body" id="${product.getId()}">
                    <p class="card-text"> ${product.getName()} </p>
                        <p><input class="deleteItem" type="image" src="/images/trash.png" alt="ОК" data-capsule-id="${capsule.getId()}" data-product-id="${product.getId()}"></p>
                </div>
            </#list>
            <div class="card-body">
                <div class="dropdown update">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        update name
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink20">
                        <form method="post" action="/capsule/updatename">
                            <input type="text" name="name"  placeholder="name">
                            <input type="hidden" value="${capsule.getId()}" name="capsuleId"  placeholder="name">
                        </form>
                    </div>

                </div>
            </div>
            <div class="card-body">
                <div class="dropdown update">
                    <a class="btn btn-secondary dropdown-toggle remove" href="#" role="button" id="dropdownMenuLink3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        delete
                    </a>
                    <div class="dropdown-menu update" aria-labelledby="dropdownMenuLink3">
                        <form action="/capsule/remove" method="post" >
                            <input type="text" name="say" placeholder="Say Yes">
                            <input type="hidden" value="${capsule.getId()}" name="capsuleId">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </#list>
</div>

<script type="text/javascript" src="../static/js/profile.js"> </script>
</body>