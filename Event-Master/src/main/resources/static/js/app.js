$(document).ready(function() {
var eventArray = [];
var EventCreator = function (title, startDay, endDay, color, reward, dow){
    this.title = title;
    this.start = startDay;
    this.end = endDay;
    this.color = color;
    this.dow = dow;
    eventArray.push(this);
}

$.get("/calendarEvents").then( function(result){
    if (!result.length == 0){
    for (i = 0 ; i < result.length; i++){
        new EventCreator(result[i].title, result[i].startDay, result[i].endDay, result[i].color,
        result[i].reward,result[i].dow);
    }}
    var calendar = $('#calendar-main');

  calendar.fullCalendar({
        header: {
            left: 'prev,next, today',
            center: 'title',
            right: 'month,basicWeek,basicDay'
        },
        defaultDate: '2021-4-12',
        navLinks: true, // can click day/week names to navigate views
        editable: true,
        eventLimit: true, // allow "more" link when too many events
        events: eventArray
//        events: [
//            {
//                color: 'red',
//                title: 'test event hardcoded',
//                start: '2021-04-21',
//                dow: [1, 2, 3, 4],
//                startTime: '10:45:00',
//                endTime: '12:45:00',
////                startRecur: '2021-04-21',
////                endRecur: '2021-04-28'
//            },
//            {
//                title: 'start',
//                startTime: '2021-04-22T03:36',
//                endTime: '2021-04-24T11:37'
//
//            }
//        ]
        });

    }).catch(console.log);
//});



   $('.dateField').hide();

    $('#allDayCheckbox').change(function() {
        if(!this.checked){
                $('.dateField').hide();
                $('.timeField').show();
            }
        else{
               $('.dateField').show();
               $('.timeField').hide();
            }
    });


});

