const formName = document.getElementById("formName");
const formId = document.getElementById("formId");

const formPw = document.getElementById("formPw");
const formPwCk = document.getElementById("formPwCk");
let pwCkMsg = document.getElementById("pwCkMsg");

const formPhone = document.getElementById("formPhone");
const formEmail = document.getElementById("formEmail");
const formAddress = document.getElementById("formAddress");

const frm = document.getElementById("frm");

const btn = document.getElementById("btn");

let nullMsg = '*필수 입력 사항입니다';


let checks = [false, false, false, false, false, false, false, false];

function getLength (value) {
    return value.trim().length;
}


function getMsg(id, msg, check) {


    if(getLength(id.value) != 0) {
        msg.innerText = '정상 입력';
        msg.classList.add("blueResult");
        msg.classList.remove("redResult");
        check = true;
 
        
    }
    else {
        msg.innerText = nullMsg;
        msg.classList.add("redResult");
        msg.classList.remove("blueResult");
        check = false;

    }

    return check, msg;
}




formId.addEventListener("blur", function(){

    let idMsg = document.getElementById("idMsg");

    //ID 중복검사
    let xhttp = new XMLHttpRequest();

    //url, method
    xhttp.open('POST', './memberIdCheck');

    //요청 헤더 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    //요청 메서드 POST일 경우 parameter 전송
    xhttp.send('id='+formId.value);

    //응답 처리
    xhttp.addEventListener('readystatechange', function(){
        if(xhttp.readyState == 4 && xhttp.status == 200) {
            if(xhttp.responseText.trim()=='true') {
                idMsg.innerText = "사용가능한 ID";
                idMsg.classList.add("blueResult");
                idMsg.classList.remove("redResult");
                checks[0] = true;
            }
            else {
                idMsg.innerText = "중복된 ID";
                idMsg.classList.add("redResult");
                idMsg.classList.remove("blueResult");
                checks[0] = false;
            }
        }
        if(xhttp.readyState == 4 && xhttp.status != 200) {
            
        }
    })





    // checks[0] = getMsg(formId, idMsg, checks[0]);

    console.log("id : ",checks[0]);


})

formPw.addEventListener("keyup", function(){
    
    let pwMsg = document.getElementById("pwMsg");
    pwMsg.innerText = '';

    if(formPw.value.length > 5 && formPw.value.length < 13) {
        checks[1] = true;
        pwMsg.innerText = '정상 입력'
        pwMsg.classList.add("blueResult");
        pwMsg.classList.remove("redResult");
        
    }
    else {
        pwMsg.classList.add("redResult");
        pwMsg.classList.remove("blueResult");
        pwMsg.innerText = '비밀번호는 6~12글자로 입력.';
        checks[1] = false;
    }

    console.log("pwlength : ",checks[1]);
})

formPw.addEventListener("blur", function(){
    
    let pwMsg = document.getElementById("pwMsg");

    if(checks[1]) {
        checks[2] = getMsg(formPw, pwMsg, checks[2]);
    }

    console.log("pwnull : ",checks[2]);
    

    
})

formPw.addEventListener("change", function(){
    
    checks[3] = false;
    formPwCk.value = '';
    pwCkMsg.innerText = 'Pw가 틀립니다';
    pwCkMsg.classList.add("redResult");
    pwCkMsg.classList.remove("blueResult");
    
})

formPwCk.addEventListener("blur", function(){
    
    pwCkMsg.innerText = '';

    if(formPwCk.value == '') {
        pwCkMsg.innerText = '비밀번호 확인';
        pwCkMsg.classList.add("redResult");
        pwCkMsg.classList.remove("blueResult");
        checks[3] = false;
        return;
    }

    if(formPwCk.value == formPw.value) {
        pwCkMsg.innerText = '동일한 패스워드 입니다.';
        pwCkMsg.classList.add("blueResult");
        pwCkMsg.classList.remove("redResult");
        checks[3] = true;
    }
    else {
        pwCkMsg.innerText = '비밀번호가 일치하지 않습니다';
        pwCkMsg.classList.add("redResult");
        pwCkMsg.classList.remove("blueResult");
        checks[3] = false;
    }

    console.log("pwCheck : ",checks[3]);


})

formName.addEventListener("blur", function(){
    let nameMsg = document.getElementById("nameMsg");

    checks[4] = getMsg(formName, nameMsg, checks[4]);
    console.log("name : ",checks[4]);
})

formPhone.addEventListener("blur", function(){
    let phoneMsg = document.getElementById("phoneMsg");

    checks[5] = getMsg(formPhone, phoneMsg, checks[5]);
    console.log("phone : ",checks[5]);
})


formEmail.addEventListener("blur", function(){
    let emailMsg = document.getElementById("emailMsg");

    
    checks[6] = getMsg(formEmail, emailMsg, checks[6]);
    console.log("email : ",checks[6]);
    

})

formAddress.addEventListener("blur", function(){
    let addressMsg = document.getElementById("addressMsg");

    checks[7] = getMsg(formAddress, addressMsg, checks[7]);
    console.log("address : ",checks[7]);
})

btn.addEventListener("click", function(){
    if(!checks.includes(false)) {
        alert("회원가입 성공")
    }
    else {
        alert("돌아가세요");
    }
    
})





