const d1 = document.getElementById("d1");
const add = document.getElementById("add");
const d1_1 = document.getElementById('d1_1');
const result = document.getElementById('result');
const dels = document.getElementsByClassName('dels');

let idx = 0;

result.addEventListener('click', function(e){
    console.log('Current target : ', e.currentTarget);
    console.log('target : ', e.target);
    // console.log(e.target.classList.contains('dels'));
    // if(e.target.classList.contains('dels')){
    //     let id = e.target.getAttribute('data-delete-id');
    //     document.getElementById(id).remove();
    //     console.log('delete : ', id);
    // } ;
});

add.addEventListener("click", function(){
    //Element 생성
    let d = document.createElement('div');
    let btn = document.createElement('button');


    //button
    //button의 contents(텍스트) 추가
    let n = document.createTextNode('DELETE');
    btn.appendChild(n);

    //button에 class 속성 추가
    let attr = document.createAttribute('class');
    attr.value = 'dels';
    btn.setAttributeNode(attr);
    

    //button에  data- 속성 추가
    //버튼 클릭 할 때 마다 idx를 이용하여 별개의 id 부여
    attr = document.createAttribute('data-delete-id');
    attr.value='del'+idx;
    btn.setAttributeNode(attr);
    
    //부모태그에게 자식 Elements 추가
    d.appendChild(btn);
    
    // 버튼의 부모태그 div에게 id 속성 추가
    // 버튼 클릭 할 때 마다 idx를 이용하여 별개의 id 부여
    attr = document.createAttribute('id');
    attr.value = 'del'+idx;
    d.setAttributeNode(attr);


    idx++;

    result.append(d);
})

d1.addEventListener("click", function(){
    d1.removeChild(d1_1);
})