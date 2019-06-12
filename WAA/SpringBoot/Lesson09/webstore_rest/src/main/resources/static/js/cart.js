$(document).ready(function() {
	
	$('.order-btn').click(function(event){

		event.preventDefault();
		var productId = $(this).attr("data");

		$.ajax({
			url: 'http://localhost:8888/rest/cart/add/' + productId,
			type: 'PUT',
			dataType: "json",
			success: function(response){
				alert("Product Successfully added to the Cart!");
			},
			error: function(){						
				alert('Error while request..');
			}
		});
		
	});
	
	$('.product-remove-btn').click(function(event){
		event.preventDefault();
		var productId = $(this).attr("data");
		
		$.ajax({
			url: '/rest/cart/remove/'+ productId,
			type: 'PUT',
			dataType: "json",
			success: function (response) {
				location.reload(true);
			},
			error: function(){						
				alert('Error while request..');
			} 
		});
		
	});

});

 