
var familyPics = [
    "/img/starfamily.jpeg","/img/phone-thieves.jpg",
    "/img/beetles.jpg", "/img/bat-trooper.jpg", "/img/dadandkids.jpeg"
    ]
const choosePic = () => {
    var members = $('[id=member-pic]');
    for(var i=0;i<members.length;i++){
        var randomNum = Math.floor(Math.random() * familyPics.length);
        $(members[i]).attr('src',familyPics[randomNum]);
        }
    }
choosePic();

    var calendarEl = $('#calendar-profile');
    calendarEl.fullCalendar({
     header:
         {
              left: 'prev,next today',
              center: 'title',
              right: 'listMonth,listWeek,listDay'
         },
        defaultView: 'listWeek',
        events: [
        {
            title: 'All Day Event',
            start: '2021-04-20'
        },
        {
            title: 'Long Event',
            start: '2020-04-21',
            end: '2020-04-24'
        },
        {
            id: 999,
            title: 'Repeating Event',
            start: '2020-12-09T16:00:00'
        }]});

     $('.member-btn').click(function(){
          $('#member-btn').toggle();
          $('#member-form').toggle();
         });



