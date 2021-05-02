<#macro navbar>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">Your Style</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Articles
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="/title/youronestyle">Your own style</a>
                    <a class="dropdown-item" href="/title/whyone">Why do some people get many outfit, while others have many questions</a>
                    <a class="dropdown-item" href="">some</a>
                    <a class="dropdown-item" href="">some(2)</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Clothes
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink2">
                    <a class="dropdown-item" href="/product/jeans">jeans</a>
                    <a class="dropdown-item" href="/product/outerwear">outerwear</a>
                    <a class="dropdown-item" href="/product/blazer">blazer</a>
                    <a class="dropdown-item" href="#">swimsuit</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/about">About</a>
            </li>

            <#if user??>
                <a class="nav-link" href="/profile/">Profile</a>
            </#if>

            <#if !user??>
                <a class="nav-link" href="/signin">Sign in</a>
            </#if>
        </ul>
    </div>
</nav>
</#macro>