    <#import "__header.ftlh" as header/>
<#import "__scrirts.ftlh" as script/>
<#import "tags/CarouselTag.ftlh" as carusel/>
<#import "tags/NavbarTag.ftlh" as navbar>
<#import "/spring.ftl" as spring/>
<@header.header />
<@script.script />
<body>
<@navbar.navbar />
<div class="main-container">
    <div class="right-background"> <br> <br>
        <form method="POST">
            <div class="sing_container">
                <div class="form-group, form_sing">
                    <small class="form-text text-muted form_sing"> </small>
                    <label for="exampleInputEmail1"><@spring.message "email"/></label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group, form_sing" >
                    <label for="exampleInputPassword1"><@spring.message "password"/></label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="form-check form_sing">
                    <input type="checkbox" class="form-check-input" name="remember-me" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                </div>
                <div class="btn_sing"><button type="submit" class="btn btn-primary"><@spring.message "submit"/></button>
                    <small class="form-text text-muted"> <a href="<@spring.url "/signup"/>" class="sing_href"><@spring.message "signup"/></a>, <@spring.message "firstTime"/></small> </div>
            </div>
        </form>
    </div>
    <div class="left-background"> <br>
        <div class="left-img">
            <@carusel.carusel />
        </div>
    </div>

</div>
</body>
</html>