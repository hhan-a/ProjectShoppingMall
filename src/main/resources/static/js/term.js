/**
 * 
 */
$(function(){
	$("#term-all").click(termsAllClicked);
	$(".term :checkbox").not("#term-all").click(termsEachClicked);
	
}); 


function termsAllClicked(){
	if($(this).prop("checked")){
		$(".term :checkbox").prop("checked", true);
	}else{
		$(".term :checkbox").prop("checked", false);
	}
}

function termsEachClicked(){
	
	
	if($(this).prop("checked")){
		
		var tot=$(".term :checkbox").not("#term-all").length;
		
		var checkdTot=$(".term :checkbox:checked").not("#term-all").length
			
		
		if(tot==checkdTot){
			
			$("#term-all").prop("checked", true);
		}else{
			
			$("#term-all").prop("checked", false);
		}
		
	}else{
		$("#term-all").prop("checked", false);
	}
}
