<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="navbar" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="_header.jsp"%>
<body>
<%@include file="_script.jsp"%>
<navbar:NavbarTag/>
<div class="row">
    <div class="card col-sm-4" style="width: 18rem;">
        <img class="card-img-top" src="${pageContext.request.contextPath}/images/avatar.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Диана Милканова</h5>
            <p class="card-text">описание которого нет но которое здесь  точно должно быть</p>
        </div>
    </div>
    <div class="card col-sm-8" style="width: 18rem;">
        <div class="card-body">
            <form method="post">
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
                    <input class="form-check-input" name="a" type="radio" value="analysis" id="defaultCheck3">
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
                <input type="date" class="form-control" id="date" value="${date}" max="${maxDate}" min="${today}" name="date" placeholder="Дата" required>
                <button type="submit" class="btn btn-primary">Проверить дату </button>
                <input type="hidden" name="action" value="data"/>
            </form>
            <br>
            <c:if test="${exception != null}">
                <script> showMessage('\'${exception}\'')</script>
            </c:if>
            <c:if test="${appo != null}">
                <script> showMessage('\'${appo}\'')</script>
            </c:if>
            <br> <form method="POST">
                <c:if test="${post != null}">

                    <c:forEach var="time" items="${time}">
                        <input type="button" name="time" class="btn btn-primary" value="<c:out value="${time}"/>" onclick="ShowDiv('\'<c:out value="${time}"/>\'')" />
                    </c:forEach>
                </c:if>
                <br>
                <div id="myDiv" style="display:none;" class="answer_list" >
                    <input type="hidden" id="myTime" name="myTime" value=""/>
                    <div class="form-group, form_sing" >
                        <label for="FIO">ФИО</label>
                        <input type="text" name="FIO" class="form-control" id="FIO" placeholder="Enter name">
                    </div>
                    <div class="form-group, form_sing" >
                        <label for="tel">Номер телефона</label>
                        <input type="text" name="tel" class="form-control" id="tel" onClick="ValidPhone()" placeholder="Номер телефона">
                        <div id="message"></div>
                    </div>
                    <input type="checkbox" onclick="ValidCheck()" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Согласен получить звонок от администратора</label>
                    <div class="btn_sing"><button disabled type="submit" id="ok" class="btn btn-primary"  >Submit</button> </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>