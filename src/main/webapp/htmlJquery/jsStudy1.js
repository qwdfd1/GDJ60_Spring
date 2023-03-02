//css 선택자 유형
const btn = document.querySelector("#btn1");

//querySelector == querySelectorAll[0]
const btns = document.querySelectorAll(".buttons");                          // getElementsByClassName("buttons");

btn.addEventListener("click", function(){
    console.log("Btn1 click");
})

for(let i=0; i<btns.length; i++) {
    btns[i].addEventListener("click", function(){
        console.log('Btn'+ (i+2) +' click');
    })
}