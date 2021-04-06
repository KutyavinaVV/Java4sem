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
        <form method="POST">
            <div class="sing_container">
                <div class="form-group, form_sing">
                    <small class="form-text text-muted form_sing"> </small>
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group, form_sing" >
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="btn_sing"><button type="submit" class="btn btn-primary">Submit</button>
                    <small class="form-text text-muted"> <a href="/signup" class="sing_href">Зарегистрируйтесь</a>, если вы впервые на нашем сайте.</small> </div>
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