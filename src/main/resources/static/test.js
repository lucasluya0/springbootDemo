$(function () {
    // $("#test2").click(function () {
    //     $.post("testException",{},function (result) {
    //         console.log({"result:":result});
    //     })
    // })
    alert("test");
    $("#signin").click(function () {
        $.post("login",{username:"lucas",password:'123'},function (result) {
            alert(result.state);
        },"json");
    })
})