const deleteProductFromList = ({ capsuleId, productId }) => {
    $.ajax({
        url: '/product/remove',
        type: 'DELETE',
        data: {
            capsuleId: capsuleId,
            productId: productId
        }
    });
    $(`#` + productId).remove();
}

$('.deleteItem').on('click', ( event ) => {
    deleteProductFromList(event.target.dataset);
});