/**
 * Created by gabor on 2017.04.27..
 */

$(document).ready(function() {
    var titleList = [];
    $(".btn-success").on("click", function() {
        var title = $(this).closest(".caption").find("h4").text();
        var element = $.inArray(title, titleList);
        if(element === -1) {
            titleList.push(title);
            $(".modal-body").prepend("<div>" + title + "</div>");
        }

        console.log(titleList);

        console.log(title);
    });
});