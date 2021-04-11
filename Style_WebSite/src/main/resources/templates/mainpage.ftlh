<#import "__header.ftlh" as header/>
<#import "__scrirts.ftlh" as script/>
<#import "tags/CarouselTag.ftlh" as carusel/>
<#import "tags/NavbarTag.ftlh" as navbar>
<@header.header />
<@script.script />
<body>
<@navbar.navbar />
<div class="main-container">
    <div class="right-background"> <br> <br>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Миучча Прада</h5>
                <h6 class="card-subtitle mb-2 text-muted"></h6>
                <p class="card-text">«Ваша одежда – это способ преподнести себя миру, особенно сейчас, когда общение становится таким быстрым. Мода – это моментальный язык».</p>
            </div>
        </div>
        <br> <br>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Джорджо Армани</h5>
                <h6 class="card-subtitle mb-2 text-muted">Подзаголовок карты</h6>
                <p class="card-text"> «Элегантность состоит не в том, чтобы выделиться, а в том, чтобы запомниться.»

            </div>
        </div>
        <br>
        <br>
        <br>
        <br>

    </div>
    <div class="left-background"> <br>
        <div class="left-img">
            <@carusel.carusel />
        </div>
        <br>
        <br>
        <br>
        <br>
    </div>

</div>

</body>
</html>