const btn = document.getElementById("btn");
let r1 = document.getElementById("r1");
let c1 = document.getElementById("c1");
let t1 = document.getElementById("t1");

const s1 = document.getElementById("s1");
const s2 = document.getElementById("s2");

//클래스명 선택자, 유사배열로 리턴
const options = document.getElementsByClassName("options");
const foods = document.getElementsByClassName("foods");

const ch = document.getElementsByClassName("ch");

s1.addEventListener("click", function(){
    for(let i=0; i<options.length; i++) {
        if(options[i].selected){
            console.log(options[i].value);
            break;
        };
    }
});

s2.addEventListener("click", function(){
    for(let i=0; i<foods.length; i++) {
        if(foods[i].checked) {
            console.log(foods[i].value);
            break;
        };
    }
})

for(let i=0; i<ch.length; i++) {
    ch[i].addEventListener("click", function(){
        console.log(this.checked);
        for(let j=0; j<ch.length;j++) {
            ch[j].checked = this.checked;
        }
    })
}


btn.addEventListener("click", function(){
    let result = '';

    for(let i=0; i<r1.value; i++) {
        result = result + '<tr>';
        for(let j=0; j<c1.value; j++) {
            result = result + '<td></td>';
        }
        result = result + '</tr>';
    }

    t1.innerHTML=result;
})

