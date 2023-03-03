//css 선택자 유형
const btn = document.querySelector("#btn1");

//querySelector == querySelectorAll[0]
const btns = document.querySelectorAll(".buttons");                          
// const btns = document.getElementsByClassName("buttons");

// const d1 = document.querySelector("#d1 > .buttons li");

btn.addEventListener("click", function(){
    console.log("Btn1 click");
})

for(let i=0; i<btns.length; i++) {
    btns[i].addEventListener("click", function(){
        console.log('Btn'+ (i+2) +' click');
    })
}

let ar = [1,2,3];

console.log('Old');
for(let i=0; i<ar.length; i++) {
    console.log(ar[i]);
}


// console.log('For Of');
// for(let a of ar) {
//     console.log(a);
// }

console.log('For in');
for(let j in ar) {
    console.log(j)
    console.log(ar[j]);
}

console.log('for each');
ar.forEach(function(v, i, list){
    console.log('v : ' ,v , ' i : ' ,i , 'ar : ', list);
})


// alert(btns);
// alert(ar);
console.log(btns);
console.log(ar);


btns.forEach(function(v, i){
    v.addEventListener("click", function(){
        console.log('click' + i);
    })
})

console.log(parseInt('1')+1);
console.log('1'-1+1);