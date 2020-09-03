var num_cuenta;
var datos;
var bal;

var num_cuenta = sessionStorage.getItem('cuentanum');
function storeNumCuenta(){
    num_cuenta = document.getElementById("input_cuenta").value;
    sessionStorage.setItem('cuentanum', num_cuenta);
};
function resetNumCuenta(){
    sessionStorage.removeItem('cuentanum');
};

function resetBalance(){
    sessionStorage.removeItem('balance');
};
function num() {
  var number = sessionStorage.getItem('cuentanum');
  document.getElementById("myText").innerHTML = number;
}
function bal() {
  var bal = sessionStorage.getItem('balance');
  document.getElementById("myBal").innerHTML = bal;
}

$(function(){
$("#consultas").click(function(){
    $.ajax({
        url: "rest/cliente/" + num_cuenta,
        method: "GET", 
        success: function(data){
            datos=data.balance;
            alert(datos);
            <!--$("ul").append("<ol>"+"Su balance es de: "+"</ol>"+"<ol>"+data.balance+"</ol>");-->
            sessionStorage.setItem('balance', datos);
        }
    });
});
});
/*$(function(){
    $("#consultas").click(function(){
        alert("hola");
    });
});*/


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
