$.ajaxSetup({
    headers: {
        'X-CSRF-TOKEN': $('#uploadPhotoForm>input[name="_token"]').attr('value')
    }
});

$uploadCrop = $('#upload-demo').croppie({
    enableExif: true,
    viewport: {
        width: 300,
        height: 300,
        type: 'circle'
    },
    boundary: {
        width: 300,
        height: 300
    }
});


$('#upload').on('change', function () {
    let reader = new FileReader();
    reader.onload = function (e) {
        $uploadCrop.croppie('bind', {
            url: e.target.result
        }).then(function () {
            console.log('jQuery bind complete');
        });
    };
    reader.readAsDataURL(this.files[0]);
});


$('.upload-result').on('click', function (ev) {

    let form = $("#uploadPhotoForm");

    $uploadCrop.croppie('result', {
        type: 'canvas',
        size: 'viewport'
    }).then(function (resp) {
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: {'photo': resp},
            success: function (data) {
                location.reload();;
            }
        });
    });
});