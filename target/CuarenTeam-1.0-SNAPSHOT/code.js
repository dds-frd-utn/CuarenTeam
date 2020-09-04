var num_cuenta;
var monto_extraccion;
var monto_restar;
var datos;

var balance = sessionStorage.getItem('balance');
var edad = sessionStorage.getItem('edad');
var direccion = sessionStorage.getItem('direccion');
var nombre = sessionStorage.getItem('nombre');
var num_cuenta = sessionStorage.getItem('cuentanum');

function storeNumCuenta(){
    num_cuenta = document.getElementById("input_cuenta").value;
    sessionStorage.setItem('cuentanum', num_cuenta);
}
function storeMontoRestar(){
    monto_restar = document.getElementById("input_monto").value;
}
function storeMontoSumar(){
    monto_sumar = document.getElementById("input_monto").value;
}
function resetNumCuenta(){
    sessionStorage.removeItem('cuentanum');
}
function resetBalance(){
    sessionStorage.removeItem('balance');
}
function num() {
  var number = sessionStorage.getItem('cuentanum');
  document.getElementById("myText").innerHTML = number;
}
function bal() {
  var balance = sessionStorage.getItem('balance');
  document.getElementById("myBal").innerHTML = balance;
}
function restarBalance(){
    storeMontoRestar();
    balance = balance - monto_restar;
    return doJSON();
}

function doJSON(){
    return JSON.stringify({"balance":balance,"direccion":direccion,"edad":edad,"nombre":nombre});
}

$(function(){
$("#volver,#login").click(function(){
            sessionStorage.removeItem('direccion');
            sessionStorage.removeItem('edad');
            sessionStorage.removeItem('nombre');
            sessionStorage.removeItem('balance');
});
});

$(function(){
$("#consultas,#extraccion,#transferencia,#depositar,#bonos").click(function(){  /*TODO agrupar*/
    $.ajax({
        url: "rest/cliente/" + num_cuenta,
        method: "GET", 
        success: function(data){
            datos=data;
            sessionStorage.setItem('direccion', datos.direccion);
            sessionStorage.setItem('edad', datos.edad);
            sessionStorage.setItem('nombre', datos.nombre);
            sessionStorage.setItem('balance', datos.balance);
            alert("success");
        }
    });
});
});

$(function(){
$("#extraer").click(function(){
    $.ajax({
        url: "rest/cliente/" + num_cuenta,
        method: "PUT",
        contentType: 'application/json',
        dataType: 'json',
        data: restarBalance(),
        success: function(){
            alert(balance);
        }
    });
});
});


/*var montoDeposito;
function storeMontoDeposito(){
    montoDeposito = document.getElementById("montoDeposito").value
};*/

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
 