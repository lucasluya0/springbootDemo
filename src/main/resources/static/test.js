$(function () {
    $("#test2").click(function () {
        $.post("testException",{},function (result) {
            console.log({"result:":result});
        })
    })
})