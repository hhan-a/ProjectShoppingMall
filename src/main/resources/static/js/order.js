/**
 * 
 */
 //기존주소, 저장된 주소목록
$(function(){
	getBaseAddress();
	
	$("#btn-delivery").click(
		function(){
			$(this).preventDefault();
		});
	$("#addr-list").click(btnAddrListClicked);
	$("#delivery-table").submit(deliverySubmited);
	console.log("11111111111111111111111111111");
});



function getBaseAddress(){//기본배송지정보확인
	$.ajax({
		url:"/order/address/base",
		success:function(resultHTML){
			$("#base-address-disp").html(resultHTML);
			
			//$("#address-no").val($("#addressNo").val());
			//$("#menu-ad>li").removeClass("target");
			//$("#menu-ad>li").eq(0).addClass("target");
		},
		error:function(){
			memuAdClicked($("menu-ad>li").eq(1));
			console.log("배송지정보가 없습니다");
		}
	});
}

function memuAdClicked(el){
	if($(el).index()==0){
		getBaseAddress();
		return;
	}
	$("#menu-ad>li").removeClass("target");
	$(el).addClass("target");
}

function btnAddrListClicked(){
	$.get(
		"/order/addres-list",
		function(resultHTML){
			$("#addreslist").html(resultHTML);
		}
	);
}


function deliverySubmited(event){

	event.preventDefault();
	
	var queryString=$(this).serialize();
	$.ajax({
		url:"/order/deliveryInfo",
		type:"post",
		data:queryString,
		success:function(){
			alert("등록완료");
		}
		
	});

}



 
//결제
const IMP = window.IMP; // 생략 가능
IMP.init("imp88887548"); // 예: imp00000000a

 var merchant_uid;

 function pmDone(){
		  //결제 상품정보
		  var orderItems=[];
		  var checkedItems=$(".cb:checked");
		  $.each(checkedItems, function(index, item){
			  var orderItem={
				  itemNo: $(item).siblings(".item-no").val(),//결제할 아이템의 pk
				  quantity:$(item).siblings(".quantity").val()//결제할 아이템의 개수
			  }
			 orderItems.push(orderItem);
	  	  });
		  //결제번호: 전역변수에 저장되어있음
		  
		  var liIdx=$("#menu-d>li.target").index();
		  if(liIdx==1){
			  $("#form-delivery").submit();
		  }
		  //배송정보
		  // - 기본배송지 정보
		  // - 신규배송지 정보
		  //$("#form-delivery").submit()
		  console.log("배송지 정보 등록 확인!")
		  var deliveryNo=$("#delivery-no").val();
		  // $("#form-delivery").submit() 처리가 완료되야
		  // $("#delivery-no").val() 데이터를 읽어올수 있어요
		  var data={
				 	  orderItems: orderItems,
					  paymentNo: merchant_uid,
					  deliveryNo: deliveryNo
				  }
				  
			//json탑입데이터를 컨트롤러로 매핑하기위해
		  $.ajax({
			  url:"/user/order",
			  type:"post",
			  dataType:"json",
			  contentType: "application/json;charset=UTF-8",
			  data: JSON.stringify(data),
			  success: function(){
				  
			  }
		  });
		  
		  
	  }


	function btnPgClicked(){
		 //1.페이지에서 결제정보 수집 : 구매자 정보,상품정보,배송
		var checkedItems=$(".cb:checked");
		var title=$(checkedItems[0]).siblings(".title").val();
		if(checkedItems.length>1){
			title +=" 외 "+(checkedItems.length-1)+"건";
		}					
		var payPrice=0;
		console.log("length: "+checkedItems.length);
		
	  	$.each(checkedItems, function(index, item){
	  		payPrice += parseInt($(item).siblings(".payPrice").val());
	  	});
	  	merchant_uid="ORD_"+new Date().getTime();
	  	
	  	var data={
	  		merchant_uid: merchant_uid,
	  		name: title,
	  		amount: payPrice,
	  		buyer_email: $("#user-email").val(),
	  		buyer_name: $("#user-name").val(),
	  		buyer_tel: "",
			buyer_addr: "",
			buyer_postcode: ""
	  	};
	  	requestPay(data);
	  }
	  
	  //iamport 결제창 띄우기
	  function requestPay(data) {
		    IMP.request_pay({
		      pg: "html5_inicis",
		      pay_method: "card",
		      merchant_uid: data.merchant_uid,   // 결제번호(중복불가)
		      name: data.name,					 // 상품명
		      amount: data.amount,               // 결제금액
		      buyer_email: data.buyer_email,
		      buyer_name: data.buyer_name,
		      buyer_tel: data.buyer_tel,
		      buyer_addr: data.buyer_addr,
		      buyer_postcode: data.buyer_postcode
		    }, function (rsp) { // callback
		      if (rsp.success) {
		        // 결제 성공 시 로직
		        //DB에반영할 데이터 처리
		        alert("결제가 완료되었습니다.");
		        pmDone();       
		        
		      } else {
		    	alert("결제가 취소되었습니다.");
		      }
		    	
		    });
		  }
 
 
 
 
 


///////////////주소검색//////////////////////////////
 function adrList(){
    new daum.Postcode({
        oncomplete: function(data) {
        	 var roadAddr = data.roadAddress; // 도로명 주소 변수
             var extraRoadAddr = ''; // 참고 항목 변수
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
               // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddr").value = roadAddr;
                document.getElementById("jibunAddr").value = data.jibunAddress;
	           
               
       }
    }).open();
}



