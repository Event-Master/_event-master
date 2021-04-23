$(document).ready(function(){
    var popupBtn = $('#event-btn');
    var popupWindow = $('#popup');
    var eventBtn = $('#add-event-btn');
    popupWindow.hide();
    popupBtn.on("click",function(){
        popupWindow.show();
    });
    eventBtn.on("click",function(){
            popupWindow.hide();
    })
})