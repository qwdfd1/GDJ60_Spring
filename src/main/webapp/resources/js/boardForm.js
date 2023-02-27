const frm = document.getElementById("frm");
const delBtn = document.getElementById("delete");

delBtn.addEventListener("click", function(){
    
    let check = window.confirm("삭제하쉴?");

    if(check) {
        frm.setAttribute("action", "./delete");
        frm.setAttribute("method", "post");

        frm.submit();
    }
    

    
})


