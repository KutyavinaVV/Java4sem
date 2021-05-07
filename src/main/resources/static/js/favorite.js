const addFavorite = (userId, name) => {
    $.ajax({
        url: '/favorite/add',
        type: 'PATCH',
        data: {
            userId: userId,
            name: name
        }
    });
    console.log("hi")
    $('.notFavorite').remove();
    $('.star').append(' <img src="/images/starGold.png" class="favorite">')
    actionHeandler();

}

const removeFavorite = (userId, name) => {
    $.ajax({
        url: '/favorite/remove',
        type: 'DELETE',
        data: {
            userId: userId,
            name: name
        }
    });
    console.log("hi")
    $('.favorite').remove();
    $('.star').append(' <img src="/images/star.png" class="notFavorite">')
    actionHeandler();

}

const id = $('#id').val();
const namee = $('#name').val();

const actionHeandler = () => {
    $('.favorite').on('click', () => {
        removeFavorite(id, namee);
    });

    $('.notFavorite').on('click', () => {
        addFavorite(id, namee);
    });
}

actionHeandler();