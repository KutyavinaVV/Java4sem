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
    <#if notification??>
        <script>
            alert("Ваше запись успешно создана!")
        </script>
    </#if>
    <div class="card col-sm-8" style="width: 18rem;">
        <div class="card-body">
            <form id="timik">
                <h5 class="card-title">Выберите услугу:</h5>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="a" value="cons30" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        Консультация (30 минут)
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="a" value="cons60" id="defaultCheck2">
                    <label class="form-check-label" for="defaultCheck2">
                        Консультация (1 час)
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input"  name="a" type="radio" value="analysis" id="defaultCheck3">
                    <label class="form-check-label" for="defaultCheck4">
                        Разбор гардероба (3 часа)
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" name="a" type="radio" value="newG" id="defaultCheck4">
                    <label class="form-check-label" for="defaultCheck4">
                        Подбор нового гардероба (целый день)
                    </label>
                </div>
                <input type="date" class="form-control" id="date" max="${maxDate}" min="${today}" name="date" placeholder="Дата" required>
                <button type="submit" id="#checkData" class="btn btn-primary">Проверить дату </button>
                <input type="hidden" name="action" value="data"/>
            </form>
            <br>
            <form id="saveApp"  action="/about/add" method="POST" style="display: none">
                <div class="timeSpace"></div>
                <div id="myDiv" class="answer_list" >
                    <div class="form-group, form_sing" >
                        <label for="FIO">ФИО</label>
                        <input type="text" name="FIO" class="form-control" id="FIO" placeholder="Enter name">
                    </div>
                    <div class="form-group, form_sing" >
                        <label for="tel">Номер телефона</label>
                        <input type="text" name="tel" class="form-control" id="tel" placeholder="Номер телефона">
                    </div>
                    <input type="hidden" value="" name='date' id="dataInForm" required>
                    <input type="hidden" value="" name='time' id="time" required>
                    <input type="hidden" value="" name='name' id="name" required>
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1" required>Согласен получить звонок от администратора</label>
                    <div class="btn_sing"><button type="submit" id="ok" class="btn btn-primary"  >Submit</button> </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>

<script type="text/javascript" src="../static/js/appointment.js"> </script>

</body>