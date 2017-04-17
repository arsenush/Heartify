$(document).ready(function () {
    "use strict";

    // OWL CAROUSELS
    $("#bg-slider").owlCarousel({
        slideSpeed: 300,
        autoPlay: true,
        pagination: false,
        singleItem: true

    });

    $("#cap-slider").owlCarousel({
        slideSpeed: 400,
        singleItem: true,
        autoPlay: true,
        pagination: false
    });

    $("#time-plan").owlCarousel({
        slideSpeed: 400,
        singleItem: true,
        autoPlay: false,
        pagination: false,
        navigation: true,
        navigationText: ["<", ">"]
    })

    $("#tweet-slider").owlCarousel({
        slideSpeed: 400,
        singleItem: true,
        autoPlay: true,
        pagination: false
    });

    // Sticky Header 
    $('.sticky-header').waypoint('sticky');

});

// Scroll page on click
$(function () {
    $('a[href*=#]:not([href=#])').click(function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: target.offset().top
                }, 1000);
                return false;
            }
        }
    });
});

// Isotope Plugin
$(function () {
    "use strict";
    // init Isotope
    var $container = $('#container').isotope({
        itemSelector: '.item',
        layoutMode: 'fitRows'
    });

    // bind filter button click
    $('#filters').on('click', 'a', function () {
        var filterValue = $(this).attr('data-filter');
        // use filterFn if matches value
        filterValue = filterFns[filterValue] || filterValue;
        $container.isotope({
            filter: filterValue
        });
    });
    // change is-checked class on buttons
    $('#filters a').click(function () {
        $('#filters .current').removeClass('current');
        $(this).addClass('current');

        var selector = $(this).attr('data-filter');
        $container.isotope({
            filter: selector,
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        return false;
    });

    $(function () {

        $("#add_prescr input[type=radio]").on("change", function () {

            var current = new Date();
            var currentMinutes = current.getMinutes();
            var currentHours = current.getHours();
            var currentDate = current.getDate();
            var currentMonth = current.getMonth() + 1;

            var currentYear = current.getFullYear();
            if (currentMonth < 10) {
                currentMonth = "0" + currentMonth;
            }
            if (currentDate < 10) {
                currentDate = "0" + currentDate;
            }
            if (currentHours < 10) {
                currentHours = "0" + currentHours;
            }
            if (currentMinutes < 10) {
                currentMinutes = "0" + currentMinutes;
            }
            var formattedDate = currentYear + "-" + currentMonth + "-" + currentDate;
            var formattedDateTime = currentYear + "-" + currentMonth + "-" + currentDate + "T" + currentHours + ":" + currentMinutes;

            if ($("#treatment").prop("checked")) {
                $("input#appointed_date").removeAttr("min");
                $(".form-group.one input").prop("required", true);
                $(".form-group.two input").prop("required", false);
                $("input#frequency").prop("min", 1);
                $("input#final_date").prop("min", formattedDate);
                $(".form-group.two").slideUp(500);
                $(".form-group.one").delay(500).slideDown(500);
            }
            if ($("#operation").prop("checked")) {
                $("input#frequency").removeAttr("min");
                $("input#final_date").removeAttr("min");
                $("input#appointed_date").prop("min", formattedDateTime);
                $(".form-group.two input").prop("required", true);
                $(".form-group.one input").prop("required", false);
                $(".form-group.one").slideUp(500);
                $(".form-group.two").delay(500).slideDown(500);
            }

        });
    });

    $(function () {
        $("#add_pers input[type=radio]").on("change", function () {
            if ($("#doctor").prop("checked")) {
                $("input#doctor_type").prop("required", true);
                $("#add_pers div.hide").slideDown(500);
            }
            if ($("#nurse").prop("checked")) {
                $("input#doctor_type").prop("required", false);
                $("#add_pers div.hide").slideUp(500);
            }
        });
    });

    $(function () {
        $(".bed.free").on("click", function(){
            var temp = $(this);
            $(".bed.free").removeClass("active");
            temp.addClass("active");
            $("input#location").val(temp.attr("id"));
        });     
    });
    
    $(function () {
        $("button#newPatient").on("click", function(){
            if (!$("input#location").val().length){
                $("p#errorMsg").text("You must choose the ward!")
            }
        });
    });
    
    

});