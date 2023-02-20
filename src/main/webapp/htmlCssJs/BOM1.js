const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
let c4 = document.getElementById("c4");
const btn3 = document.getElementById("btn3");

btn3.addEventListener("click", function(){
    
    let test =  document.getElementById("test");
    console.log(test.value);
})

btn2.addEventListener("click", function(){
    let c3 = document.getElementById("c3");
    console.log(c3.getAttribute("title"));
})

btn.addEventListener("click", function(){
    
    let c2 = window.document.getElementById("c2");
    console.log(c2.innerText);
    console.log(c2.innerHTML);
    
    c2.innerHTML='<img src="../resources/images/beef.jpg">';
})


let c1 = window.document.getElementById("c1");
// alert(c1);

// console.log(c1);
// c1.
console.log(c1.innerText);
console.log(c1.innerHTML);



