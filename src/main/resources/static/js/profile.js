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
};

const deleteAppointment = ({ id }) => {
    $.ajax({
        url: '/about/delete',
        type: 'DELETE',
        data: {
            id: id
        }
    });
    $(`#` + id).remove();
};

$('.deleteItem').on('click', ( event ) => {
    deleteProductFromList(event.target.dataset);
});

$('.removeAppointment').on('click', ( event ) => {
    deleteAppointment(event.target.dataset);
});