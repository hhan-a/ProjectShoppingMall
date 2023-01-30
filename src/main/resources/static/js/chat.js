/**
 * 
 */
 var stompClient = null;
 $(function(){
	
 });
 
 function openChat(){
	 setConnectStated(true);//접속
	 connect();
 }

 function showMessage(message) {
    $("#chat-content").append(message);
    //대화창 스크롤을 항상 최하위에 배치   
    $("#chat-content").scrollTop($("#chat-content").prop("scrollHeight"));
 }

 function setConnectStated(isTrue){
	if(isTrue){
		$("#btn-chat-open").hide();
		$("#chat-disp").show();
	}else{
		$("#btn-chat-open").show();
		$("#chat-disp").hide();
	}
	$("#chat-content").html("");
 }

 function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnectStated(false);
    console.log("Disconnected");
 }
 

 //버튼클릭시 접속
 function connect() {
    var socket = new SockJS('/my-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        console.log('Connected: ' + frame);
        //브라우저에서 메시지를 수신하려면 STOMP 클라이언트가 먼저 대상을 구독
        //subscribe()방법을 사용하여 대상에 가입
        //2개의 필수 인수를 사용. destination목적지에 해당하는 문자열, callback,
        stompClient.subscribe('/topic/greetings', function (botMessage) {
            showMessage(JSON.parse(botMessage.body).message);
        });
        stompClient.subscribe('/topic/message', function (botMessage) {
            showMessage(JSON.parse(botMessage.body).message);
        });
        stompClient.send("/app/hello",{},JSON.stringify({'content':'guest'}));
        //stompClient.subscribe('/topic/message', onmessage);
    });
}

function inputTagString(text){
	var now = new Date();
	var ampm= (now.getHours()>11)?"오후 ":"오전 "
	var time = ampm + now.getHours()%12 + ":" + now.getMinutes();
	var message=`
		<div class="msg user flex end">
			<div class="message">
				<div class="part">
					<p>${text}</p>
				</div>
				<div class="time">${time}</div>
			</div>
		</div>
	`;
	return message;
}

//메뉴클릭시 메뉴텍스트 화면에 표현
function menuclicked(el){
	var text = $(el).text().trim();
	var message = inputTagString(text);
	showMessage(message);
	stompClient.send("/app/message",{},JSON.stringify({'content':text}));
}

//질문에 엔터키가 입력되었을 때
function questionKeyup(){
	if(event.keyCode!=13)return;
	btnMsgSendClicked()
}

//전송 버튼을 클릭했을 때
function btnMsgSendClicked(){
	var question = $("#question").val().trim();
	if(question=="" || question.length<2) return;
	
	var message = inputTagString(question);
	showMessage(message);
	$("#question").val(""); //비우기
	stompClient.send("/app/message",{},JSON.stringify({'content':question}));
}


