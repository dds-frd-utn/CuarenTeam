var num_cuenta;

function storeNumCuenta(){
    num_cuenta = document.getElementById("input_cuenta").value
};

$(function(){
    $("#consultas").click(function(){
        $.ajax({
            url: "http://localhost:8080/CuarenTeam/rest/cliente/" + num_cuenta,
            method: "GET",
            success: function(data){
                $("ul").append("<ol>"+"Su saldo es de: "+"</ol>"+"<ol>"+data.balance+"</ol>");

            },
        });
    });
});

