$(function () {


    $('.radio-group .radio').click(function () {
        $(this).parent().find('.radio').removeClass('selected');
        $('.service-block').removeClass('selected-block');
        $(this).addClass('selected');

        $(this).parent().addClass('selected-block');
        var val = $(this).attr('data-value');
        //alert(val);
        $('#radio-value').val(val);
    });

});