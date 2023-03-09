//FileManager.js
const button  = document.getElementById("button");
const fileList = document.getElementById("fileList");
let count = 0;
let idx = 0;
let max = 1;
let param = 'pic';

function setParam(p) {
    param = p;
}

function setMax(m) {
    max = m;
}

function setCount(c) {
    count = c;
}

$('#button').click(() => {

    if(count >= max) {
        alert('첨부파일은 '+max+'개만 가능합니다');
        return;
    }

    let child = '<div class="row mb-2" id="d'+idx+'">';
    child = child + '<label for="" class="col-sm-1 col-form-label">Image</label>'
    child = child + '<div class="input-group mb-2 col-sm-10">';
    child = child + '<input type="file" class="form-control" name="'+param+'">';
    child = child + '<button class="dels btn btn-outline-danger" type="button" data-delete-id="'+idx+'">X</button>';
    child = child + '</div></div>';

    $('#fileList').append(child);

    idx++;
    count++;

});

$("#fileList").on('click', '.dels', function(){
    let id = $(this).attr('data-delete-id');
    $('#d'+id).remove();
    count--;
})

$('.deleteCheck').click(function(){

        let result = confirm('파일이 영구 삭제 됩니다');
        let ch = $(this);
        if(result) {
            //ajax DB에서 삭제

            let fileNum = $(this).val();

            
            $.ajax({
                type : 'POST',
                url : './boardFileDelete',
                data : {
                    fileNum : fileNum
                },
                success : function(response){
                    if(response.trim() > 0) {
                        //ajax코드 내에서의 this는 ajax객체를 의미
                        // console.log($(this));
                        // $(this).parent().parent().remove();
                        
                        ch.parent().parent().remove();
                        count--;
                        alert('삭제 되었습니다.');
                    }
                    else {
                        alert('삭제 실패, 관리자에게 문의 요망');
                    }
                },
                error : function(){

                }
            })

            //fetch(GET) 
            // fetch("URL?p=1", {
            //     method : 'GET',

            // }).then((response)=>response.text())
            // .then((res) =>{

            // })

            //ajax(GET)
            // $.get("URL?p=1", function(response){

            // })

            //fetch(POST)
            // fetch("URL", {
            //     method : 'POST',
            //     headers : {
            //         'Contents-Type' : 'X,,,'
            //     },
            //     body : 'p=1'
            // }).then((response) => response.text)
            // .then((res) => {

            // })

            //ajax(POST)
            // $.post("URL", {p:1}, function(res){

            // })
        }
        else {
            $(this).prop('checked', false);
        }
        
    
  
    
        

    
})







