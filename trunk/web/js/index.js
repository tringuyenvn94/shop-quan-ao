/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function dangKyClick(){
	//$('.overlay').fadeTo(500, 0.8);
	$('.overlay').fadeIn(500, function(){
		$('#regBlock').fadeIn(500);	
	});
	
}
function btnDangKyClick(){
	$('.overlay').fadeOut(500, function(){
		$('#regBlock').fadeOut(500);	
	});
	
}

