$(function () {
    let ctx = document.getElementById('myChart').getContext('2d');
    let load_type_id_all_readings = $('#load_type_id_all_readings');
    let selected_load_type;
    let start = moment().subtract(7, 'days');
    let end = moment();
    let result;
    let chart;

    Chart.defaults.global.defaultFontSize = 14;

    load_type_id_all_readings.change(function () {
        chartRequest(false);
    });


    function cb(s, e) {

        $('input[name="start"]').val(s.format('YYYY-MM-DD'));
        $('input[name="end"]').val(e.format('YYYY-MM-DD'));

        start = s;
        end = e;
        chartRequest(true);
    }

    function chartRequest(isChange) {
        let form = $('#chartDateForm');

        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form.serialize(),
            success: function (res) {
                result = res;

                if (jQuery.isEmptyObject(result.data)) {
                    //alert('Для данного промежутка времени данных нет');
                    load_type_id_all_readings.children().prop('selected', false);
                    if (selected_load_type) {
                        load_type_id_all_readings.children('option[value=' + selected_load_type + ']').prop('selected', true);
                    }

                    let rangeSpan = $('#reportrange span');

                    if(!rangeSpan.html()) {
                        rangeSpan.html(start.format('DD/MM/YYYY') + ' - ' + end.format('DD/MM/YYYY'));
                        createEmptyChart();
                    }

                    return;
                }

                selected_load_type = load_type_id_all_readings.val();

                if (isChange) {
                    $('#reportrange span').html(start.format('DD/MM/YYYY') + ' - ' + end.format('DD/MM/YYYY'));
                }

                createChart();
            }
        });
    }

    function createEmptyChart() {

        //clear canvas
        let myChart = $('#myChart');
        let parent = myChart.parent();
        myChart.remove(); // this is my <canvas> element
        parent.prepend('<canvas id="myChart"><canvas>');
        ctx = document.getElementById('myChart').getContext('2d');

        chart = new Chart(ctx, {
            // The type of chart we want to create
            type: 'bar',

            // The data for our dataset
            data: {
                labels: [],
                datasets: []
            },

            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            min: 6,
                            max: 20,
                            stepSize: 2
                        },
                    }]
                }
            }
        });
    }

    function createChart() {

        //clear canvas
        let myChart = $('#myChart');
        let parent = myChart.parent();
        myChart.remove(); // this is my <canvas> element
        parent.prepend('<canvas id="myChart"><canvas>');
        ctx = document.getElementById('myChart').getContext('2d');

        chart = new Chart(ctx, {
            // The type of chart we want to create
            type: result.type,

            // The data for our dataset
            data: {
                labels: result.labels,
                datasets: [{
                    label: "Красная зона",
                    backgroundColor: 'rgba(255, 99, 132, 1)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    data: result.redLine,
                    fill: false,
                    // showLine: false,
                    // pointStyle: 'line',
                    // pointRadius: 1,
                    // pointHoverRadius: 350,
                    // hitRadius: -20,
                    type: 'line'
                }, {
                    label: "Результат по Боргу",
                    borderWidth: 2,
                    backgroundColor: 'rgba(151, 46, 175, .5)',
                    borderColor: 'rgb(151, 46, 175)',
                    data: result.data,
                    fill: false,
                    hitRadius: 20,
                    spanGaps: true
                }]
            },

            options: {
                tooltips: {
                    mode: 'x',
                    callbacks: {
                        // label: function (tt, data) {
                        //     if (tt.datasetIndex === 0) {
                        //         return null;
                        //     } else {
                        //         return data.datasets[tt.datasetIndex].label + ': ' + tt.yLabel;
                        //     }
                        // }
                    }
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            min: 6,
                            max: 20,
                            stepSize: 2
                        },
                    }],
                    xAxes: [{
                        stacked: true,
                        ticks: {
                        }
                    }]
                },
                elements: {
                    line: {
                        tension: 0, // disables bezier curves
                    }
                },
                onResize: function () {
                    // createChart();
                }
            }
        });
    }

    $('#reportrange').daterangepicker({
        "locale": {
            "format": "DD/MM/YYYY",
            "separator": " - ",
            "applyLabel": "Применить",
            "cancelLabel": "Отмена",
            "fromLabel": "С",
            "toLabel": "По",
            "customRangeLabel": "Произвольно",
            "weekLabel": "Н",
            "daysOfWeek": [
                "Вс",
                "Пн",
                "Вт",
                "Ср",
                "Чт",
                "Пт",
                "Сб"
            ],
            "monthNames": [
                "Январь",
                "Февраль",
                "Март",
                "Апрель",
                "Май",
                "Июнь",
                "Июль",
                "Август",
                "Сентябрь",
                "Октябрь",
                "Ноябрь",
                "Декабрь"
            ],
            "firstDay": 1
        },
        startDate: start,
        endDate: end,
        ranges: {
            'Сегодня': [moment(), moment()],
            'Вчера': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Последние 7 дней': [moment().subtract(7, 'days'), moment()],
            'Последние 30 дней': [moment().subtract(30, 'days'), moment()],
            'Этот месяц': [moment().startOf('month'), moment().endOf('month')],
            'Предыдущий месяц': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        }
    }, cb);

    cb(start, end);
});