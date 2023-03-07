// const replyAdd = document.getElementById("replyAdd");
const replyContents = document.getElementById("replyContents");
const commentList = document.getElementById("commentList");

const contentsConfirm = document.getElementById('contentsConfirm');
const closeModal = document.getElementById('closeModal');
let page = 1;


//댓글 등록 
$('#replyAdd').click(() => {
     //JS에서 사용할 가상의 Form 태그 생성
     const form = new FormData();

     //"contents="+replyContents.value+'&bookNumber='+replyAdd.getAttribute("data-bookNumber")

     //$('#replyContents').val() == replyContents.value;
     form.append('contents', $('#replyContents').val()); 

     //$('#replyAdd').attr('data-bookNumber') == replyAdd.getAttribute("data-bookNumber");
     form.append('bookNumber', $('#replyAdd').attr('data-bookNumber')); 
 
     fetch('../bankBookComment/add', {
         method : 'POST',
         //headers : {"Content-type" : "application/x-www-form-urlencoded"},
         body : form
     })
     // response : 요청에 대한 응답 객체, 변수명은 변경 가능 
     .then((response) => response.text())
     .then((res) => {
         if(res.trim() == 1) {
             alert("댓글이 등록되었습니다");
             $('#replyContents').val('');
             getList(1);
         }    
         else{
             alert("댓글 등록 실패");
         }
     }).catch(() => {
         console.log('등록 실패');
     })
}) 


getList(1);

function getList(page) {

    fetch('../bankBookComment/list?bookNumber='+$('#replyAdd').attr("data-bookNumber") + '&page='+page, {
        //GET과 HEAD 메서드 형식은 body를 가질 수 없다.
        method : 'GET'
    }).then((response) => response.text())
    .then((res) => {
        $('#commentList').html(res.trim());
        console.log(res);
    })


}


//댓글 삭제
$('#commentList').on('click', '.del',function(e){
    fetch('../bankBookComment/delete', {
        method : 'POST',
        headers : {"Content-type" : "application/x-www-form-urlencoded"},
        body : 'num='+$(this).attr('data-board-num')

    }).then((response) => response.text())          //응답객체에서 data 추출
    .then((res) => {                            //추출한 data 사용
        if(res.trim() > 0) {
            alert('댓글이 삭제되었습니다');
            getList(page); 
        }
        else {
            alert('삭제 실패');
        }
    }).catch(() => {
        alert('삭제 실패');
    })

    e.preventDefault();
})

//페이징
$('#commentList').on('click', '.page-link', function(e){
    page = $(this).attr('data-board-page')
    getList(page);

    e.preventDefault();
})

// 댓글 수정
$('#commentList').on('click', '.update', function(e){
    let num = $(this).attr('data-board-num');


    $('#contents').text($('#contents'+num).text());
    $('#contentsConfirm').attr('data-board-num', num);

    e.preventDefault();
})

commentList.addEventListener('click', function(e){
    
    




    // //댓글 수정

    // if(e.target.classList.contains('update')) {
    //     let updateBtn = e.target

    //     let num = updateBtn.getAttribute('data-board-num');

    //     let contents = document.getElementById('contents'+num);


    //     let contentsTextArea = document.getElementById('contents');

        

    //     contentsTextArea.value = contents.innerText;
    //     contentsConfirm.setAttribute('data-board-num', num);

      

    // } 



})

//모달창 확인버튼

$('#contentsConfirm').click(function() {
    fetch('../bankBookComment/update', {
        method : 'POST',
        headers : {"Content-type" : "application/x-www-form-urlencoded"},
        body : 'num='+ $(this).attr('data-board-num') + '&contents=' + $('#contents').val()
    }).then((response) => response.text())
    .then((res) => {
        if(res.trim() > 0) {
            alert('수정 성공');
            getList(page);
            $('#closeModal').click();
        }            
        else {
            alert('수정 실패');
        }
    }).catch(() => {
        alert('관리자에게 문의하세요');
    })
})

// contentsConfirm.addEventListener('click', function(){
//     let updateContents = document.getElementById('contents').value;
//     let num = contentsConfirm.getAttribute('data-board-num');

//     fetch('../bankBookComment/update', {
//         method : 'POST',
//         headers : {"Content-type" : "application/x-www-form-urlencoded"},
//         body : 'num='+ $(this).attr('data-board-num') + '&contents=' + $('#contents').val()
//     }).then((response) => response.text())
//     .then((res) => {
//         if(res.trim() > 0) {
//             alert('수정 성공');
//             getList(page);
//             $('#closeModal').click();
//             closeModal.click();
//         }            
//         else {
//             alert('수정 실패');
//         }
//     }).catch(() => {
//         alert('관리자에게 문의하세요');
//     })

    // let xhttp = new XMLHttpRequest();

    // xhttp.open('POST', '../bankBookComment/update');

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send('num='+ num + '&contents=' + updateContents);

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState == 4 && xhttp.status == 200) {
    //         let result = xhttp.responseText;
    //         if(result > 0) {
    //             alert('수정 성공');
    //             getList(1);
    //             closeModal.click();
    //         }
    //         else {
    //             alert('수정 실패');
    //         }


    //     }
    // })
//})

//Test후 삭제할 영역
    //1. 선택
    // const b1 = document.getElementById('b1');
    // const b1 = document.querySelector('#b1');
    
    //Jquery
    // $('#b1').click(()=> {
    //     let v = $('#t1').val();
    //     console.log(v);
    // });

    // $('#t1').blur(()=> {
    //     console.log('blur');
    // })

    // $('#t1').on({
    //     click:function(){
    //         console.log('t1 click');
    //     },
    //     blur: ()=>{
    //         console.log('t1 blur');
    //     }
    // })

    // $('#b1').on('click', function(){})

    // $('#commentList').on('click', '.update', () => {});

    // // const ch = document.getElementsByClassName('ch');

    // // for(let c of ch) {
    // //     c.addEventListener('click', function(){

    // //     })
    // // }

    // $('.ch').click(function(e){
    //     console.log('e : ', e)
    //     console.log(this.value);
    //     console.log($(this).val());
    // })

    // $('.ch').click((e) => {
    //     console.log('e : ', e)
    //     console.log(e.target);
    //     console.log($(e.target).val());
    // })







