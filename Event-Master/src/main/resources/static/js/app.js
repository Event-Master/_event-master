var calendar = $('#calendar-main');

var eventArray;
$.get("/calendarEvents").then( function(result){
  console.log("we got it to run");
  console.log(result);
//  for(var i = 0; i < result.length; i++) eventArray.push(result[i]);
eventArray = result;
  console.log(result[0].title)
  }).catch(console.log);

console.log(eventArray[0].title);

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
//        events: [
//            {
//                title: eventArray[0].title,
//                start: eventArray[0].date
//            },
//            {
//                title: 'Long Event',
//                start: '2020-12-07',
//                end: '2020-12-10'
//            },
//            {
//                id: 999,
//                title: 'Repeating Event',
//                start: '2020-12-09T16:00:00'
//            },
//            {
//                id: 999,
//                title: 'Repeating Event',
//                start: '2020-12-16T16:00:00'
//            },
//            {
//                title: 'Conference',
//                start: '2020-12-11',
//                end: '2020-12-13'
//            },
//            {
//                title: 'Meeting',
//
//                start: '2020-12-12T10:30:00',
//                end: '2020-12-12T12:30:00'
//            },
//            {
//                title: 'Lunch',
//                start: '2020-12-12T12:00:00'
//            },
//            {
//                title: 'Meeting',
//                start: '2020-12-12T14:30:00'
//            },
//            {
//                title: 'Happy Hour',
//                start: '2020-12-12T17:30:00'
//            },
//            {
//                title: 'Dinner',
//                start: '2020-12-12T20:00:00'
//            },
//            {
//                title: 'Birthday Party',
//                start: '2020-12-13T07:00:00'
//            },
//            {
//                title: 'Click for Google',
//                url: 'https://google.com/',
//                start: '2020-12-28'
//            },
//            {
//                title: 'Christmas!',
//                start: '2020-12-25',
//                allDay: true
//            }
//        ]
    });


});
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




