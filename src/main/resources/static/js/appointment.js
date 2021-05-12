const onTimeGetting = () => {
    $('#saveApp').show()
    console.log(time)
}

let time = "";

$.fn.query = function () {
    const form = this;
    form.on('submit', () => {
        $.ajax({
            url: '/about/data',
            type: 'GET',
            data: form.serialize(),
            success: function(result) {
                if (result[0].includes('Ошибка')) {
                    alert(result[0].replace('Ошибка: ', ''))
                }
                else {
                    $('#dataInForm').val($('#date').val())
                    $('.timer').hide();
                    result.map( time => {
                        $('.timeSpace').append('<input type="button" class=timer name="timer" class="btn btn-primary" value="' + time + '">');
                    })
                    onTimeGetting();
                    $('.timer').on('click', ( event ) => {
                        console.log(event.currentTarget.value)
                        $('#time').val(event.currentTarget.value.toString());
                    });
                    $('#name').val(document.querySelector('input[name="a"]:checked').value );
                }
            }
        });
        return false;
    });
};

$('#timik').query()