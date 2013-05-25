$(document).ready(function() {
	
// Support for AJAX loaded modal window.
// Focuses on first input textbox after it loads the window.
//	https://github.com/twitter/bootstrap/issues/253
	
//  <a id="btnLink" href="/empleador/index/modal-test" data-toggle="modal">link</a>	
	
//  $('[data-toggle="modal"]').click(function(e) {
//  $('#btnLink').click(function(e) {
	$("[data-toggle=modal]").click(function(e) {
		//alert("modal");
		e.preventDefault();
		var url = $(this).attr('href');
		//alert(url);
		if (url.indexOf('#') == 0) {
			//alert("0");
			//alert( url.indexOf('#') );
			$(url).modal('open');
		} else {
			//alert("get");
			$.get(url, function(data) {
				//alert(data);
				//$('<div class="modal hide fade">' + data + '</div>').modal();
				$('<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">' + data + '</div>').modal();
			}).success(function() { /*alert("success");*/ $('input:text:visible:first').focus(); });
		}
	});

});