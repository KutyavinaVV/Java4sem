<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="navbar" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="_header.jsp"%>
<body>
<%@include file="_script.jsp"%>
<navbar:NavbarTag/>
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
            <navbar:CarouselTag/>
        </div>
        <br>
        <br>
        <br>
        <br>
    </div>

</div>

</body>
</html>

