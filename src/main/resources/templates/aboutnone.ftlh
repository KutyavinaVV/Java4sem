<#import "__header.ftlh" as header/>
<#import "__scrirts.ftlh" as script/>
<#import "tags/CarouselTag.ftlh" as carusel/>
<#import "tags/NavbarTag.ftlh" as navbar>
<@header.header />
<body>
<@script.script />
<@navbar.navbar />
<div class="row">
    <div class="card col-sm-4" style="width: 18rem;">
        <img class="card-img-top" src="/images/avatar.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Диана Милканова</h5>
            <p class="card-text">описание которого нет но которое здесь  точно должно быть</p>
        </div>
    </div>
    <div class="card col-sm-8" style="width: 18rem;">
        <div class="card-body">
            Для того, чтобы совершить запись <a href="/signin" class="sing_in">войдите в свой аккаунт</a>, или <a href="/signup"> зарегистрируйтесь</a>, если вы с нами впервый раз.
        </div>
    </div>
</div>

<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>

<script type="text/javascript" src="../static/js/appointment.js"> </script>

</body>