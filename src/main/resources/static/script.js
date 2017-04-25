/**
 * Created by rickiecashwell on 4/18/17.
 */
$(function(){
 alert("loaded");
    $(".playerImg").hide().fadeIn("slow");
    $(".clickImg").click(function (){
        var url = $(this).attr("data-th-href");
        console.log("works");
        $(".choiceImg").fadeIn("slow",function(){
            document.location=url;
        });

    });
});

