Reveal.addEventListener( 'slidechanged', function( event ) {
    if(event.currentSlide.getAttribute("fullscreen")) {
        document.getElementsByClassName("slides")[0].style.width = 100 + '%';
        document.getElementsByClassName("slides")[0].style.height = 100 + '%';
    }
} );

