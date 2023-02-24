//FileManager.js
const button  = document.getElementById("button");
const fileList = document.getElementById("fileList");
let count = 0;
let max = 1;
let param = 'pic';

function setParam(p) {
    param = p;
}

function setMax(m) {
    max = m;
}

button.addEventListener("click", function(){

    

    if(count >= max) {
        alert('첨부파일은 '+max+'개만 가능합니다');
        return;
    }

        

        //Element, Text 생성
        let div1 = document.createElement('div');
        let label = document.createElement('label');
        let text = document.createTextNode('Image');
        let div2 = document.createElement('div');
        let input = document.createElement('input');
        let delBtn = document.createElement('button');

        div2.appendChild(input);
        div2.appendChild(delBtn);
        label.appendChild(text);
        div1.appendChild(label);
        div1.appendChild(div2);

        //input
        let attr = document.createAttribute('type');
        attr.value = 'file';
        input.setAttributeNode(attr);

        attr = document.createAttribute('class');
        attr.value = 'form-control';
        input.setAttributeNode(attr);

        attr = document.createAttribute('name');
        attr.value = param;
        input.setAttributeNode(attr);

        attr = document.createAttribute('id');
        attr.value = 'files';
        input.setAttributeNode(attr);

        //div2
        attr = document.createAttribute('class');
        attr.value = 'input-group mb-3 col-sm-10';
        div2.setAttributeNode(attr);

        //label

        attr = document.createAttribute('for');
        attr.value = 'files';
        label.setAttributeNode(attr);
        
        attr = document.createAttribute('class');

        attr.value = 'col-sm-1 col-form-label';
        label.setAttributeNode(attr);
        
        //div1
        attr = document.createAttribute('class');
        attr.value = 'row mb-3';
        div1.setAttributeNode(attr);

        attr = document.createAttribute("type");
        attr.value = 'button';
        delBtn.setAttributeNode(attr);

        attr = document.createAttribute('id');
        attr.value = 'd'+count;
        div1.setAttributeNode(attr);


        //Delete
        let n = document.createTextNode("X");
        delBtn.appendChild(n);

        attr = document.createAttribute("class");
        attr.value = "dels btn btn-outline-primary";
        delBtn.setAttributeNode(attr);

        attr = document.createAttribute("type");
        attr.value = 'button';
        delBtn.setAttributeNode(attr);

        attr = document.createAttribute("data-delete-id");
        attr.value = 'd'+count;
        delBtn.setAttributeNode(attr);


        fileList.prepend(div1);

        count++;

})

fileList.addEventListener("click", function(e){
    // console.log(e.target);
    if(e.target.classList.contains("dels")) {
        let id = e.target.getAttribute("data-delete-id");
        console.log(id)
        document.getElementById(id).remove();
        count--;
    }
})

