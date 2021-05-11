<#macro favorite>
<#if user??>
    <#if isFavorite??>
        <div class="star">
            <img src="/images/starGold.png" class="favorite">
        </div>
        <#else>
            <div class="star">
                <img src="/images/star.png" class="notFavorite">
            </div>
    </#if>
        <input type="hidden" id="name" value="${name}">
        <input type="hidden" id="id" value="${user}">
</#if>
<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>

    <script type="text/javascript" src="../../static/js/favorite.js"> </script>

</#macro>