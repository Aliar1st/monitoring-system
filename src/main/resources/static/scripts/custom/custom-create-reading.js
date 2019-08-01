$('#load_type_id_readings').change(function () {
    setLoadNames();
});

function setLoadNames() {
    let select = $('#load_name_id');
    let load_type = $('#load_type_id_readings').val();
    select.children('option:not(:first)').css('display', 'none');
    select.children('option[data-load-type="' + load_type + '"]').css('display', 'block');
}

$(function () {
    setLoadNames();
});