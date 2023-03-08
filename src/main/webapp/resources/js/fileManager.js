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
    console.log(count);
    if($(this).prop('checked')){
        let result = confirm('파일이 영구 삭제 됩니다');
        if(result) {
            count--;
        }
        else {
            $(this).prop('checked', false);
        }
        
    }
    else {        

        if(count == 5) {
                console.log(count-1);
                idx--;
                $('#d'+(idx)).remove();
                // count--
                return;
        }
        idx++;    
    
        

    }
})







