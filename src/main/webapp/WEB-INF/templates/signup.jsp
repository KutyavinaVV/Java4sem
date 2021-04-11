
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="navbar" tagdir="/src/main/webapp/templateswebapp/templates/tags" %>
<%@include file="_header.jsp"%>
<%@include file="_script.jsp"%>
<navbar:NavbarTag/>
<div class="main-container">
    <div class="right-background"> <br> <br>
        <form  action="" method='POST'>
            <div class="sing_container">
                <small class="form-text text-muted form_sing"> ${content}</small>
                <div class="form-group, form_sing" >
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                </div>
                <div class="form-group, form_sing">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group, form_sing" >
                    <label for="password">Password</label>
                    <input type="password" name="psw" class="form-control" id="password" placeholder="Password">
                </div>
                <div class="form-group, form_sing" >
                    <label for="passwordr">Password</label>
                    <input type="password" name="psw-repeat" class="form-control" id="passwordr" placeholder="Password Repeat">
                </div>
                <div class="form-check form_sing">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <div class="btn_sing"><button type="submit" class="btn btn-primary">Submit</button> </div>
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
