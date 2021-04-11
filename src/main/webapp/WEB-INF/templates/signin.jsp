<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="navbar" tagdir="/WEB-INF/tags" %>
<%@include file="_header.jsp"%>
<body>
<%@include file="_script.jsp"%>
<navbar:NavbarTag/>
<div class="main-container">
    <div class="right-background"> <br> <br>
        <form method="POST">
            <div class="sing_container">
            <div class="form-group, form_sing">
                <small class="form-text text-muted form_sing"> ${content}</small>
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group, form_sing" >
                <label for="exampleInputPassword1">Password</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="btn_sing"><button type="submit" class="btn btn-primary">Submit</button>
                <small class="form-text text-muted"> <a href="${pageContext.request.contextPath}/signup" class="sing_href">Зарегистрируйтесь</a>, если вы впервые на нашем сайте.</small> </div>
            </div>
        </form>
    </div>
    <div class="left-background"> <br>
        <div class="left-img">
            <navbar:CarouselTag/>
        </div>
    </div>

</div>

</body>
</html>
