function inIframe () {
    try {
        return window.self !== window.top;
    } catch (e) {
        return true;
    }
}

if (inIframe()) {
    var body = document.getElementsByTagName('body')[0];
    body.className = body.className + ' speaker-mode';
    var parentDocument = parent.document;
    parentDocument.getElementById('current-slide').style.width = '50%';
    parentDocument.getElementById('upcoming-slide').style.width = '50%';
    parentDocument.getElementById('speaker-controls').style.width = '50%';

    parentDocument.getElementById('current-slide').style.height = '50%';
    parentDocument.getElementById('upcoming-slide').style.height = '50%';
    parentDocument.getElementById('speaker-controls').style.height = '100%';

    parentDocument.getElementById('upcoming-slide').style.left = '0';

    parentDocument.getElementById('upcoming-slide').style.top = '50%';
    parentDocument.getElementById('speaker-controls').style.top = '0';
}

Reveal.addEventListener( 'slidechanged', function( event ) {
    var footer = document.getElementById('footer');
    if (footer) {
        if (!Reveal.isFirstSlide() && !Reveal.isLastSlide()) {
            footer.className = footer.className.replace('show', 'hide');
        } else {
            footer.className = footer.className.replace('hide', 'show');
        }
    }
} );

