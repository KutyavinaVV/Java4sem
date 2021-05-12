const addProductInList = ({capsuleId, productId }) => {
    $.ajax({
        url: '/product/add',
        type: 'PUT',
        data: {
            capsuleId: capsuleId,
            productId: productId
        }
    });
}

$('.capsule').on('click', (event) => {
    addProductInList(event.target.dataset);
});