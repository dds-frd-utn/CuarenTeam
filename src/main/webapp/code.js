var num_cuenta;

function storeNumCuenta(){
    num_cuenta = document.getElementById("input_cuenta").value
};

$(function(){
    $("#consultas").click(function(){
        debugger;
        alert("hola");
        $.ajax({
            url: "http://localhost:8080/CuarenTeam/rest/cliente/" + num_cuenta,
            method: "GET",
            success: function(data){
                $("ul").append("<ol>"+"Su balance es de: "+"</ol>"+"<ol>"+data.balance+"</ol>");

            }
        });
    });
});



var montoDeposito;
function storeMontoDeposito(){
    montoDeposito = document.getElementById("montoDeposito").value
};

/*$(function(){
    $("#depositar").click(function(){
        $.ajax({
            url: 'http://localhost:8080/CuarenTeam/rest/cliente/' + num_cuenta,
            method: 'PUT',
            dataType: 'json',
            data: {balance:}
            },
            success: function(data){
                $(p).text("Despósito realizado con éxito")
            },
        });
    });
});*/
