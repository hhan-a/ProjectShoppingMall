/**
 * 
 */
 function boardDelete(){
		//체크박스 체크된 항목
        var query = 'input[name="chk"]:checked'
        var selectedElements = document.querySelectorAll(query)

        //체크박스 체크된 항목의 개수
        var selectedElementsCnt = selectedElements.length;

        alert(selectedElementsCnt.value)
        if(selectedElementsCnt == 0){
            alert("삭제할 항목을 선택해주세요.");
            return false;
        }

        else{
            if (confirm("정말로 삭제하시겠습니까?")) {
                
              
            }
        }
	}
	//자식 체크박스 클릭 이벤트
    function chkClicked(){

        //체크박스 전체개수
        const allCount = document.querySelectorAll(".chk").length;

        //체크된 체크박스 전체개수
        const query = 'input[name="chk"]:checked'
        const selectedElements = document.querySelectorAll(query)
        const selectedElementsCnt = selectedElements.length;

        //체크박스 전체개수와 체크된 체크박스 전체개수가 같으면 전체 체크박스 체크
        if(allCount == selectedElementsCnt){
             document.getElementById('allCheckBox').checked = true;
        }

        //같지않으면 전체 체크박스 해제
        else{
            document.getElementById('allCheckBox').checked = false;
        }
    }
	//체크박스 전체 선택 클릭 이벤트
    function allChecked(target){
        //전체 체크박스 버튼
        var checkbox = document.getElementById('allCheckBox');

        //전체 체크박스 버튼 체크 여부
        var is_checked = checkbox.checked;

        //전체 체크박스 제외한 모든 체크박스
        if(is_checked){
            //체크박스 전체 체크
            chkAllChecked()
        }

        else{
            //체크박스 전체 해제
            chkAllUnChecked()
        }
    }
    //체크박스 전체 체크
    function chkAllChecked(){
        document.querySelectorAll(".chk").forEach(function(v, i) {
            v.checked = true;
        });
    }

    //체크박스 전체 체크 해제
    function chkAllUnChecked(){
        document.querySelectorAll(".chk").forEach(function(v, i) {
            v.checked = false;
        });
    }