const p1 = document.getElementById("p1");
const b1 = document.getElementById("b1");

const p2 = document.getElementById("p2");
const b2 = document.getElementById("b2");

const naver = document.getElementById("naver");

// 함수의 매개변수로 click의 Event객체가 인자값으로 전달됨

// 캡쳐링
b1.addEventListener("click", function(e){
    console.log("Button Click");
    console.log(e)
}, true)

p1.addEventListener("click", function(event){
    console.log("Div Click")
    console.log(event);
    event.stopPropagation();
}, true)


// 버블링 
b2.addEventListener("click", function(e){
    console.log("Button2 Click");
    console.log(e)
    e.stopPropagation();
    console.log("Button This :", this);
})

p2.addEventListener("click", function(event){
    console.log("Div2 Click")
    console.log(event);
    console.log("Current Target : ", event.currentTarget);
    console.log("Target : ", event.target);
    console.log("This : ", this);
    
})

naver.addEventListener("click", function(event){
    console.log("Naver Click");
    event.preventDefault();
    // return false;
})
