var calendar = $('#calendar-main');

var eventArray;
$.get("/calendarEvents").then( function(result){
  console.log("we got it to run");
  console.log(result);
//  for(var i = 0; i < result.length; i++) eventArray.push(result[i]);
eventArray = result;
  console.log(result[0].title)
  }).catch(console.log);
//console.log(eventArray[0].title);

$(document).ready(function() {
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
        events: eventArray,
//        plugins: [ dayGridPlugin, interactionPlugin ],
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
//                start: '2021-04-25T20:15:00',
//                end: '2021-04-27T20:30:00'
//
//            }
//        ]
    });

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

