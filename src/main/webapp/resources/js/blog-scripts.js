$(function() {
    $('#messages span').click(function() {
        
    	$(this).fadeOut();
        
    });
    setTimeout(function() {
        $('#messages span.info').fadeOut();
    }, 3000);
});