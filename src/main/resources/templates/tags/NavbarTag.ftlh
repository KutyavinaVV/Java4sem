<#macro navbar>
    <#import "/spring.ftl" as spring/>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">Your Style</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="<@spring.url "/"/>">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Articles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="<@spring.url "/title/youronestyle"/>">Your own style</a>
                    <a class="dropdown-item" href="<@spring.url "/title/whyone"/>">Why do some people get many outfit, while others have many questions</a>
                    <a class="dropdown-item" href="">some</a>
                    <a class="dropdown-item" href="">some(2)</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Clothes
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink2">
                    <a class="dropdown-item" href="<@spring.url "/product/jeans"/>">jeans</a>
                    <a class="dropdown-item" href="<@spring.url "/product/outerwear"/>">outerwear</a>
                    <a class="dropdown-item" href="<@spring.url "/product/blazer"/>">blazer</a>
                    <a class="dropdown-item" href="<@spring.url "/product/my" />">All My</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<@spring.url "/about"/>">About</a>
            </li>

            <#if user??>
                <a class="nav-link" href="<@spring.url "/profile/"/>">Profile</a>
            </#if>

            <#if !user??>
                <a class="nav-link" href="<@spring.url "/signin"/>">Sign in</a>
            </#if>
        </ul>
    </div>
</nav>
</#macro>