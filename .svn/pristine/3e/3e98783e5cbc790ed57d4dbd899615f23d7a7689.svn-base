jQuery(document).ready(function($) {
	$(window).scroll(function(){
	    if ($(window).scrollTop() >= 10) {
	        $('.main-header').addClass('fixed-header');
	   }
	    else {
	        $('.main-header').removeClass('fixed-header');
	    }
	});
	//active menu on click
	var selector = '.nav-links>li';

	$(selector).on('click', function(){
	    $(selector).removeClass('current-menu-item');
	    $(this).addClass('current-menu-item');
	});
	
	
	"use strict";
  $(".slide-toggle").click(function(){
      $(".box").slideToggle("slow");
  });

  
/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon 
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
      x.className += " responsive";
    } else {
      x.className = "topnav";
    }
  } 

*/

var siteCarousel = function () {
  if ( $('.nonloop-block-13').length > 0 ) {
    $('.nonloop-block-13').owlCarousel({
      center: false,
      items: 1,
      loop: true,
      stagePadding: 0,
      margin: 0,
      autoplay: true,
      smartSpeed: 800,
      nav: true,
      navText: ['<span class="icon-arrow_back">', '<span class="icon-arrow_forward">'],
      responsive:{
        600:{
          margin: 0,
          nav: true,
          items: 2
        },
        1000:{
          margin: 0,
          stagePadding: 0,
          nav: true,
          items: 3
        },
        1200:{
          margin: 0,
          stagePadding: 0,
          nav: true,
          items: 4
        }
      }
    });
  }


  if ( $('.nonloop-block-14').length > 0 ) {
    $('.nonloop-block-14').owlCarousel({
      center: false,
      items: 1,
      loop: true,
      stagePadding: 0,
      margin: 0,
      autoplay: true,
      smartSpeed: 800,
      nav: true,
      navText: ['<span class="icon-arrow_back">', '<span class="icon-arrow_forward">'],
      responsive:{
        600:{
          margin: 20,
          nav: true,
          items: 2
        },
        1000:{
          margin: 30,
          stagePadding: 0,
          nav: true,
          items: 3
        },
        1200:{
          margin: 30,
          stagePadding: 0,
          nav: true,
          items: 4
        }
      }
    });
  }

  $('.slide-one-item').owlCarousel({
    center: false,
    items: 1,
    loop: true,
    stagePadding: 0,
    margin: 0,
    autoplay: true,
    pauseOnHover: false,
    nav: true,
    navText: ['<span class="icon-keyboard_arrow_left">', '<span class="icon-keyboard_arrow_right">']
  });

  $('.slide-one-item-alt').owlCarousel({
    center: false,
    items: 1,
    loop: true,
    stagePadding: 0,
    margin: 0,
    smartSpeed: 3000,
    autoplay: true,
    pauseOnHover: true,
    autoplayHoverPause:true,
    onDragged: function(event) {
      console.log('event : ',event.relatedTarget['_drag']['direction'])
      if ( event.relatedTarget['_drag']['direction'] == 'left') {
        $('.slide-one-item-alt-text').trigger('next.owl.carousel');
      } else {
        $('.slide-one-item-alt-text').trigger('prev.owl.carousel');
      }
    }
  });
  $('.slide-one-item-alt-text').owlCarousel({
    center: false,
    items: 1,
    loop: true,
    stagePadding: 0,
    margin: 0,
    smartSpeed: 1000,
    autoplay: true,
    pauseOnHover: true,
    onDragged: function(event) {
      console.log('event : ',event.relatedTarget['_drag']['direction'])
      if ( event.relatedTarget['_drag']['direction'] == 'left') {
        $('.slide-one-item-alt').trigger('next.owl.carousel');
      } else {
        $('.slide-one-item-alt').trigger('prev.owl.carousel');
      }
    }
  });

  


  $('.custom-next').click(function(e) {
    e.preventDefault();
    $('.slide-one-item-alt').trigger('next.owl.carousel');
    $('.slide-one-item-alt-text').trigger('next.owl.carousel');
  });
  $('.custom-prev').click(function(e) {
    e.preventDefault();
    $('.slide-one-item-alt').trigger('prev.owl.carousel');
    $('.slide-one-item-alt-text').trigger('prev.owl.carousel');
  });

  


};
siteCarousel();


$('.counter-count').each(function () {
  $(this).prop('Counter',0).animate({
      Counter: $(this).text()
  }, {
      duration: 5000,
      easing: 'swing',
      step: function (now) {
          $(this).text(Math.ceil(now));
      }
  });
});



$('.collapse').on('shown.bs.collapse', function(){
  $(this).parent().find(".glyphicon-plus").removeClass("glyphicon-plus").addClass("glyphicon-minus");
  }).on('hidden.bs.collapse', function(){
  $(this).parent().find(".glyphicon-minus").removeClass("glyphicon-minus").addClass("glyphicon-plus");
  });




$("#owl-demo").owlCarousel({
	center: false,
	items: 7,
	loop: true,
margin: 10,
nav: true,
autoplay:true,
responsiveClass:true,
responsive:{
    0:{
        items:1,
        
    },
    900:{
        items:7,
        
    },
    600:{
        items:5,
       
    }
   
   
},
dots:false
 });

 $("#owl-demo-imp").owlCarousel({
	center: false,
items: 5,
loop: true,
margin: 20,
autoplay:true,
responsiveClass:true,
responsive:{
    0:{
        items:2,
        nav:false
    },
    900:{
        items:6,
        nav:false
    },
    600:{
        items:3,
        nav:false
    }
   
   
}

 });
 
 //Guidance slide
 $("#owl-guidline-slider").owlCarousel({
		center: false,
	items: 7,
	loop: true,
	margin: 20,
	autoplay:true,
	responsiveClass:true,
	responsive:{
	    0:{
	        items:1,
	        nav:false
	    },
	    580:{
	        items:2,
	        nav:false
	    },
	    
	    767:{
	        items:2,
	        nav:false
	    },
	    991:{
	        items:3,
	        nav:false
	    },
	    1024:{
	        items:3,
	        nav:false
	    },
	    1280:{
	        items:4,
	        nav:false
	    },
	    
	    1366:{
	        items:4,
	        nav:false
	    }
	   
	   
	}

	 });
 
 
 
 new WOW().init();


 $(".demo1").bootstrapNews({
     newsPerPage: 7,
     autoplay: true,
		pauseOnHover:true,
     direction: 'up',
     newsTickerInterval: 4000,
     onToDo: function () {
         //console.log(this);
     }
 });
 


 

 $("#menuToggle_alert").click(function(){
     $(".alerts_med").toggleClass("alerts_medc");
 }); 

 

 
 $('#datetimepicker6').datetimepicker({format: 'MM/DD/YYYY'});
 $('#datetimepicker7').datetimepicker({format: 'MM/DD/YYYY'});
 
 
//Get the button
 var mybutton = document.getElementById("myBtn");

 // When the user scrolls down 20px from the top of the document, show the button
 window.onscroll = function() {$.fn.scrollFunction()};

 $.fn.scrollFunction= function(){ 
   if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
     mybutton.style.display = "block";
   } else {
     mybutton.style.display = "none";
   }
 }


 $(".fancybox").fancybox({
     openEffect: "none",
     closeEffect: "none"
 });
 
 $(".zoom").hover(function(){
		
		$(this).addClass('transition');
	}, function(){
     
		$(this).removeClass('transition');
	});
 

 

 
 $('.map').click(function(e){
	    e.stopPropagation();
	});
	$("#menuToggle").click(function(e) {
	    e.preventDefault();
	    e.stopPropagation();
	    $("#message1").removeClass("in");
	    $(".map").toggleClass("mapc");
	    
	    /*alert("yeah");
	    
	    document.getElementById("frm").action = "${pageContext.request.contextPath}/getStatisticsData";
		document.getElementById("frm").method = "GET";
		document.getElementById("frm").submit(); */
	});
	
	
	/*$("#menuToggle").click(function(){
	     $(".map").toggleClass("mapc");
	 }); */
	
	 // this is the jQuery function if testButton is clicked
	
	 $('#message1').click(function(e){
		    e.stopPropagation();
		});
		$("#btnFly").click(function(e) {
		    e.preventDefault();
		    e.stopPropagation();
		    $('#message1').toggleClass('in');
		});
		$(".semreset").click(function(e) {
			
			$('#sem-login').hide();
			$('.modal-backdrop').remove();
		});
		
		
		$(document).click(function() {
			$(".map").removeClass("mapc");
			$("#message1").removeClass("in");
			$("#navbar6").removeClass("in");
			});
		/*$(document).click(function() {
		$(".map").removeClass("mapc");
		});
	 $('#btnFly').click(function() {
	     $('#message1').toggleClass('in');	 });*/
	 
	 $('.jmbclose').click(function() {
	     $('#message1').toggleClass('in');	 });
	
 
	 
	 
	
});


//When the user clicks on the button, scroll to the top of the document
function topFunction() {
document.body.scrollTop = 0;
document.documentElement.scrollTop = 0;
}

$(document).ready(function () { $('#consolPopup').modal('show'); });


/*** gallery jquery  starts*/

	
$(document).ready(function() {
	  

	  
	    var numItems = $('li.fancyTab').length;
			
				  if (numItems == 5){
						$("li.fancyTab").width('20%');
					}
				  if (numItems == 4){
						$("li.fancyTab").width('25%');
					}
				  if (numItems == 3){
						$("li.fancyTab").width('33.3%');
					}
				  if (numItems == 2){
						$("li.fancyTab").width('50%');
					}
			  
		 

		
			});

$(window).on('load', function() {

	  $('.fancyTabs').each(function() {

	    var highestBox = 0;
	    $('.fancyTab a', this).each(function() {

	      if ($(this).height() > highestBox)
	        highestBox = $(this).height();
	    });

	    $('.fancyTab a', this).height(highestBox);

	  });
	});
	



		
	

	
		


	




/*** gallery jquery ends */






	

