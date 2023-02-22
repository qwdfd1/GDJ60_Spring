
const d1 = document.getElementById("d1");

//전역변수
let n = 'iu';
var old = 'iu';

//함수

// function 선언
function f1(){
    console.log("function Test");
    console.log(n);
    var old = 'winter'
}


//매개변수 선언시 let, const는 생략해야 함
function f2(n1, n2) {
    let name = 'iu';
    return n1+n2;
}

// function 호출
f1();
let result = f2(1,2);

console.log(result);
console.log(name);
// console.log(n1);
console.log('Old : ' + old);

let fun = function () {
    console.log('익명함수');
    return 1;
}

fun();

function f3 (f) {
    console.log('F3 : ',f,1);
}

// f3(fun);




//콜백함수
//  ()를 같이쓰면 함수호출(실행), 없으면 변수(매개변수) 사용
//  다른곳에서도 같은 함수를 사용하고 싶을 때
// d1.addEventListener("click", callback1);
// d1.addEventListener("click", callback2);

//한 곳에서만 사용하고 싶은 함수
d1.addEventListener("click", function(){
    callback1();
    callback2();
});



// 어디선가 선언만 되어있으면 코드 순서는 상관없다
function callback1() {
    console.log("CallBack1");
}

let callback2 = function () {
    console.log("CallBack2");
}