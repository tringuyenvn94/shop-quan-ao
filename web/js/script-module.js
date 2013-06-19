// JavaScript Document

$(document).ready(function(e) {
    $('#left-list').click(function()
	{
		var current_left=$('#list-item').position().left;
		var now_left=current_left+840;
		if(now_left<=0)
		{
			$('#list-item').animate({left:now_left},300);
		}
		else
		{
			$('#list-item').animate({left:current_left},300);
			
		}
	});
	
	$('#right-list').click(function()
	{
		var current_left=$('#list-item').position().left;
		var now_left=current_left-840;
		if($('#list-item').find('.cd-item').length*140+now_left>0)
		{
			$('#list-item').animate({left:now_left},300);
		}
		else
		{
			$('#list-item').animate({left:current_left},300);
			
		}
	});
	
	
});