/**
 * Created by gabor on 2017.04.27..
 */

$( document ).ready(function() {

    function addToCart(id) {
        $.ajax({
            method: 'POST',
            url: '/addtocart',
            data: {'id': id},
            success: function () {
                $("#").text(parseInt($("#").html()) + 1);
            }
        });
    }
}