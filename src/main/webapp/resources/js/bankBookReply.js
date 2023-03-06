const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentList = document.getElementById("commentList");

const contentsConfirm = document.getElementById('contentsConfirm');
const closeModal = document.getElementById('closeModal');



replyAdd.addEventListener("click", function() {

    ;
    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "../bankBookComment/add");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("contents="+replyContents.value+'&bookNumber='+replyAdd.getAttribute("data-bookNumber"));

    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            if(xhttp.responseText.trim() == 1) {
                alert("댓글이 등록되었습니다");
                replyContents.value = '';
                getList(1);
            }
            else {
                alert("댓글 등록 실패");
            }

            
        }
    })
})

getList(1);

function getList(page) {
    let xhttp = new XMLHttpRequest();

    xhttp.open('GET', '../bankBookComment/list?bookNumber='+replyAdd.getAttribute("data-bookNumber")+'&page='+page);

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            commentList.innerHTML = xhttp.responseText.trim();
        }
    })

}



commentList.addEventListener('click', function(e){
    
    

    //페이징
    if(e.target.classList.contains('page-link')) {    
        let page = e.target.getAttribute('data-board-page');
        getList(page);
        


    }

    //댓글 삭제
    if(e.target.classList.contains('del')) {
        let xhttp = new XMLHttpRequest();

        let num = e.target.getAttribute('data-board-num');
        console.log(num);

    
        xhttp.open('POST', '../bankBookComment/delete');

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send('num='+e.target.getAttribute('data-board-num'));
    
        xhttp.addEventListener('readystatechange', function(){
            if(this.readyState == 4 && xhttp.status == 200) {
                let result = xhttp.responseText;
                if(result > 0) {
                    alert('댓글이 삭제되었습니다');
                    getList(1);
                }
                else {
                    alert('삭제 실패');
                }

            }
        })
    }

    //댓글 수정

    if(e.target.classList.contains('update')) {
        let updateBtn = e.target

        let num = updateBtn.getAttribute('data-board-num');

        let contents = document.getElementById('contents'+num);


        let contentsTextArea = document.getElementById('contents');

        

        contentsTextArea.value = contents.innerText;
        contentsConfirm.setAttribute('data-board-num', num);

      

    } 

    e.preventDefault();

})

contentsConfirm.addEventListener('click', function(){
    console.log('Update Post');
    let updateContents = document.getElementById('contents').value;
    let num = contentsConfirm.getAttribute('data-board-num');

    let xhttp = new XMLHttpRequest();

    xhttp.open('POST', '../bankBookComment/update');

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send('num='+ num + '&contents=' + updateContents);

    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState == 4 && xhttp.status == 200) {
            let result = xhttp.responseText;
            if(result > 0) {
                alert('수정 성공');
                getList(1);
                closeModal.click();
            }
            else {
                alert('수정 실패');
            }


        }
    })
})









