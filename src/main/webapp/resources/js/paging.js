const pl = document.getElementsByClassName("page-link");
const searchForm = document.getElementById("searchForm");
const page = document.getElementById("page");

for (let p of pl) {
    p.addEventListener("click", function(e){
        e.preventDefault();
        let attr =this.getAttribute("data-board-page");
        console.log(attr);
        page.value = attr;
        searchForm.submit();
    })
}
