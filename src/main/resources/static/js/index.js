$(document).ready(function(){
    console.log("hello");
    $("#loginReset").click(function(){
        $("#loginId").val("");
        $("#loginPass").val("");
        $("#remark2").html("");
        $("#login").prop( "disabled",true);
    });

    $("#loginId").keyup(function(){
        if($("#loginId").val().length > 0 && $("#loginPass").val().length > 0){
            $("#login").prop("disabled",false);
        } else{
            $("#login").prop( "disabled",true);
        }
    });

    $("#loginPass").keyup(function(){
        if($("#loginId").val().length > 0 && $("#loginPass").val().length > 0){
            $("#login").prop("disabled",false);
        } else{
            $("#login").prop("disabled",true);
        }
    });

    $("#registerReset").click(function(){
        $("#registerId").val("");
        $("#registerAge").val("");
        $("#registerPass").val("");
        $("#remark").html("");
        $("#register").prop( "disabled",true);
    });

    $("#registerId").keyup(function(){
        if($("#registerId").val().length > 0 && $("#registerPass").val().length > 0 && $("#registerAge").val().length > 0){
            $("#register").prop("disabled",false);
        } else{
            $("#register").prop("disabled",true);
        }
    });

    $("#registerAge").keyup(function(){
        if($("#registerId").val().length > 0 && $("#registerPass").val().length > 0 && $("#registerAge").val().length > 0){
            $("#register").prop("disabled",false);
        } else{
            $("#register").prop("disabled",true);
        }
    });

    $("#registerPass").keyup(function(){
        if($("#registerId").val().length > 0 && $("#registerPass").val().length > 0 && $("#registerAge").val().length > 0){
            $("#register").prop("disabled",false);
        } else{
            $("#register").prop("disabled",true);
        }
    });

    $("#reset").click(function(){
        $("#fetch").prop("disabled",false);
        console.log("you clicked!!");
        $("tbody").html("");
    });

    $(".openRegister").click(function(){
        $(".win").slideDown();
        $(".win2").slideUp();
        $(".win3").slideUp();
    });

    $(".openLogin").click(function(){
        $(".win2").slideDown();
        $(".win").slideUp();
        $(".win3").slideUp();
    });

    $(".openList").click(function(){
        $(".win3").slideDown();
        $(".win2").slideUp();
        $(".win").slideUp();
    });

    $(".fas").click(function(){
        $(".win").slideUp();
        $(".win2").slideUp();
        $(".win3").slideUp();
    });

    $("#register").click(function(){
        const z = {
            "id": $(".lid").val(),
            "age": $(".lage").val(),
            "pass": $(".lpass").val()
        };
        console.log(z);
        console.log($(".lid").val());
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/saveInfo",
            data: JSON.stringify(z),
            dataType: 'json',

            success: function (data){
                $("#remark").html(data.msg);
            }
        });
    });

    $("#login").click(function(){
        const z1 = {
            "id" : $(".loginId").val(),
            "pass" : $(".loginPass").val()
        }
        console.log(z1);
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/login",
            data: JSON.stringify(z1),
            dataType: 'json',

            success: function (data){
                console.log(data.msg);
                $("#remark2").html(data.msg);
            }
        });
    });

    $("#fetch").click(function(){
        $("#fetch").prop("disabled",true);
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/fetchAllRecords",

            success: function (data){
                $.each(data, function(key,value){
                    $("tbody").append("<tr><th>"+ value.id +"</th><td>"+ value.age +"</td></tr>");
                });
            }
        });
    });
});