

$('#btn').click(()=> {

    let productId = $('#productId').val();

    $.get("https://dummyjson.com/products/"+productId, (response)=>{
        console.log(response);
        console.log(response.title);
    });
})

$.get('https://dummyjson.com/products/', (response) => {
    console.log(response.products.length);


    // for(let item of response.products) {
    //     console.log(item);
    //     let result = '<div class="card" style="width: 18rem;">';
    //     result = result + '<img src="'+item.thumbnail+'" class="card-img-top" alt="...">';
    //     result = result + '<div class="card-body">';
    //     result = result + '<h5 class="card-title">'+item.title+'</h5>';
    //     result = result + '<p class="card-text">'+item.description+'</p>';
    //     result * result + '<a href="#" class="btn btn-primary detail">'+item.price+'</a>';
    //     result * result + '</div></div>';
    //     $('#productList').append(result);
    // }

    response.products.forEach((item, index)=> {
        console.log(index, item);
        let result = '<div class="card" style="width: 18rem;">';
        result = result + '<img src="'+item.thumbnail+'" class="card-img-top" alt="...">';
        result = result + '<div class="card-body">';
        result = result + '<h5 class="card-title">'+item.title+'</h5>';
        result = result + '<p class="card-text">'+item.description+'</p>';
        result = result + '<a href="#" class="btn btn-primary detail" data-productId="'+item.id+'">'+item.price+'$</a>';
        result = result + '</div></div>';
        $('#productList').append(result);
    })

    $('#productList').on('click', '.detail', function(){
        let id = $(this).attr('data-productId');
        console.log(id);
    })

    //$('#productList').html(result);
    
    

})


              
