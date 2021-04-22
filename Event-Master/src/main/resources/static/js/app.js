$(document).ready(function() {
var eventArray = [];
$.get("/calendarEvents").then( function(result){
    eventArray = result;

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
        });
    }).catch(console.log);
});
//        events: [
//            {
//                title: eventArray[0].title,
//                start: eventArray[0].date
//            },
//            {
//                title: 'Long Event',
//                start: '2020-12-07',
//                end: '2020-12-10'
//            },//
//            {
//                title: 'Christmas!',
//                start: '2020-12-25',
//                allDay: true
//            }
//        ]


//
// calendar.addEvent({
//    title: 'Add Event....',
//    start: 2020-12-04,
//    allDay: true
//  });
//  function displayCalendar(request, response) {
//    const sqlStr = "SELECT * FROM events WHERE id=$1;";
//    const sqlArr = ["default"];
//
//  }




