$(function(){
    		createCategory($(".left-cate"));
    	});
    	
    	function createCategory(target){
    		var parentNo=$(target).attr("value");
    		console.log("pno:"+parentNo);
    		$.ajax({
    			url:`/common/layout/categorys/${parentNo}`,
    			success:function(olTag){
    				$(target).children(".cate-wrap").html(olTag);
    				
    				//$(target).children(".sub").children("ol").css("left",left+'px').css("top",0);
    				//left = left+179;
    				var sub=$(target).find(".cate");
    				//console.log(sub);
    				$.each(sub, subCategory);
    			}
    		});
    	}
    	function subCategory(){
    		//console.log($(this).attr("value"));
    		createCategory($(this));
    	}
