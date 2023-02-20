let checkAll = document.getElementById("checkAll");
let check = document.getElementsByClassName("form-check-input1");
let btn = document.getElementById("agree");


for(let i=0; i<check.length; i++) {
    check[i].addEventListener("click", function(){
        let result = true;
        console.log(this.checked);
        for(let j=0; j<check.length; j++) {
            if(!check[j].checked) {
                result = check[j].checked;
                break;
            }
        }
        
        checkAll.checked = result;
    })
}

checkAll.addEventListener("click", function(){
    for(let i=0; i<check.length; i++) {
        check[i].checked = this.checked;
    }
})

btn.addEventListener("click", function(){

    if(checkAll.checked) {
        // alert("모든 약관 동의");
        location.href="./memberJoin"
    }
    else {
        alert("모든 약관에 동의 해야합니다.");
    }
    

})




