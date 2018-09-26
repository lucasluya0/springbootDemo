$(function () {
    // $("#test2").click(function () {
    //     $.post("testException",{},function (result) {
    //         console.log({"result:":result});
    //     })
    // })
    $("#signin").click(function () {
        $.post("login",{username:"张三",password:'123'},function (result) {
            alert(result.Msg);
        },"json");
    })
    $("#signup").click(function () {
        $.post("addUser",{username:"张三",pwd:'123'},function (result) {
            alert(result.Msg);
        },"json");
    })

})