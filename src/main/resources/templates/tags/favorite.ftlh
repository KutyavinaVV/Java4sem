<#macro favorite>
<#if userId??>
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
        <input type="hidden" id="id" value="${userId}">
</#if>
<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>

    <script>

        const addFavorite = (userId, name) => {
            // $.ajax({
            //     url: '/favorite/remove',
            //     type: 'DELETE',
            //     data: {
            //         userId: userId,
            //         name: name
            //     }
            // });
               console.log("hi")
            $('.notFavorite').remove();
            $('.star').append(' <img src="/images/starGold.png" class="favorite">')

        }

        const removeFavorite = (userId, name) => {
            // $.ajax({
            //     url: '/favorite/add',
            //     type: 'PATCH',
            //     data: {
            //         userId: userId,
            //         name: name
            //     }
            // });
            console.log("hi")
            $('.favorite').remove();
            $('.star').append(' <img src="/images/star.png" class="favorite">')

        }

        const id = $('#id');
        const namee = $('#name');


        $('.favorite').on('click', () => {
            removeFavorite(id, namee);
        });

        $('.notFavorite').on('click', ( ) => {
            addFavorite(id, namee);
        });


    </script>

</#macro>