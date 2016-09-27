// http://caibaojian.com/bootstrap-modal2.html
jQuery(document).ready(function($){ 
	$('body').append('<div class="rs-overlay" />'); 
	$("a[rel='rs-dialog']").each(function(){ 
		var trigger = $(this); 
		var rs_dialog = $('#' + trigger.data('target')); 
		var rs_box = rs_dialog.find('.rs-dialog-box'); 
		var rs_close = rs_dialog.find('.rs-close'); 
		var rs_overlay = $('.rs-overlay'); 
		if( !rs_dialog.length ) 
			return true; 
		// Open dialog 
		trigger.click(function(){ 
			//Get the scrollbar width and avoid content being pushed 
			var w1 = $(window).width(); 
			$('html').addClass('dialog-open'); 
			var w2 = $(window).width(); 
			c = w2-w1 + parseFloat($('body').css('padding-right')); 
			if( c > 0 ) 
				$('body').css('padding-right', c + 'px' ); 
			rs_overlay.fadeIn('fast'); 
			rs_dialog.show( 'fast', function(){ 
				rs_dialog.addClass('in'); 
			});
			$('#prod_id').val(trigger.attr('target'));
			return false; 
		}); 
		// Close dialog when clicking on the close button 
		rs_close.click(function(e){ 
			rs_dialog.removeClass('in').delay(150).queue(function(){ 
				rs_dialog.hide().dequeue(); 
				rs_overlay.fadeOut('slow'); 
				$('html').removeClass('dialog-open'); 
				$('body').css('padding-right', ''); 
			}); 
			return false; 
		}); 
		// Close dialog when clicking outside the dialog 
		rs_dialog.click(function(e){ 
			rs_close.trigger('click'); 
		});
		rs_box.click(function(e){
			e.stopPropagation(); 
		}); 
	}); 
});
		