const pl = document.getElementsByClassName("page-link");
const searchForm = document.getElementById("searchForm");
const page = document.getElementById("page");

for (let p of pl) {
    p.addEventListener("click", function(e){
        let attr = this.getAttribute("data-board-page");
        page.value = attr;
        console.log(page.value);
        searchForm.submit();
    })
}
