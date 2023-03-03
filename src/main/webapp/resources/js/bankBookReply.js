const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentList = document.getElementById("commentList");


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
                getList();
            }
            else {
                alert("댓글 등록 실패");
            }

            
        }
    })
})

function getList() {
    let xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/bankBookComment/list?bookNumber="+replyAdd.getAttribute("data-bookNumber"));

    xhttp.send();

    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            commentList.innerHTML = xhttp.responseText.trim();
        }
    })

}

getList();

