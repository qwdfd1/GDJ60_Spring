const btn1 = document.getElementById('btn1');

btn1.addEventListener('click', function(){
    // window.open("./new.html", 'test', 'width=400px; height=200px; top=100px; left=200px;');
    clearInterval(st);
    
})

//setTimeout
setTimeout(function(){
    alert('timeout');
}, 1000)

let st = setInterval(function(){
    console.log('Interval')
}, 1000);