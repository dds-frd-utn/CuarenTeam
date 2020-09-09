/* VARIABLES */

var num_cuenta;
var monto_extraccion;
var monto_restar;
var numberStr;
var number;
var datos;
var balance = sessionStorage.getItem('balance');
var edad = sessionStorage.getItem('edad');
var direccion = sessionStorage.getItem('direccion');
var nombre = sessionStorage.getItem('nombre');
var num_cuenta = sessionStorage.getItem('cuentanum');
var datos2;
var num_cuenta_destino;
var balance2;
var edad2;
var direccion2;
var nombre2;
var movimientosCuenta;


/* NUMERO DE CUENTA PARA LA SESION */

function storeNumCuenta(){
    num_cuenta = document.getElementById("input_cuenta").value;
    sessionStorage.setItem('cuentanum', num_cuenta);
}
function resetNumCuenta(){
    sessionStorage.removeItem('cuentanum');
}


/* FUNCIONES PARA MOSTRAR VARIABLES EN HTML */

function num() {
  var number = sessionStorage.getItem('cuentanum');
  document.getElementById("myText").innerHTML = number;
}
function bal() {
  var balance = sessionStorage.getItem('balance');
  document.getElementById("myBal").innerHTML = balance;
}


/* FUNCION PARA MODIFICAR EL BALANCE */

function modificarBalance(pnum,suma){
    if(pnum==num_cuenta){
        balance = parseFloat(balance) + parseFloat(suma);
    }
    else{
        balance2 = parseFloat(balance2) + parseFloat(suma);
    };
    $.ajax({
        url: "rest/cliente/" + pnum,
        method: "PUT",
        contentType: 'application/json',
        dataType: 'json',
        data: doJsonBal(pnum),
        success: function(){
            alert("retire su dinero");
        }
    });
}


/* FUNCION PARA CONVERTIR JSONs EN STRINGS */

function doJsonBal(pnum){
    var payload;
    if(pnum===num_cuenta){
        payload= JSON.stringify({"balance":balance,"direccion":direccion,"edad":edad,"nombre":nombre});
    }
    else{
        payload= JSON.stringify({
            "balance":balance2,
            "direccion":direccion2,
            "edad":edad2,
            "nombre":nombre2
        });
    }
    return payload;
}

function doJsonTransf(){
    var payload;
    var input_monto= document.getElementById("input_monto").value;
    payload= JSON.stringify({
        "cuenta_destino": num_cuenta_destino,
        "cuenta_origen": num_cuenta,
        "fecha": getFechaYHora(),
        "monto": input_monto
    });
    return payload;
}

function doJsonMovim(tipo,valor,cuenta){
    var payload;
    payload= JSON.stringify({
        "fecha": getFechaYHora(),
        "tipo": tipo,
        "monto": valor,
        "cuenta":cuenta
    });
    return payload;
}


/* FUNCION PARA OBTENER FECHA Y HORA EN FORMATO YYYY-MM-DD HH:MM:SS*/

function normalizar(number){
    numberStr= number.toString();
    if (numberStr.length < 2){
        numberStr='0' + numberStr;
    }
    return numberStr;
}

function getFechaYHora(){
    var currentDate = new Date(); 
    var year = currentDate.getFullYear();
    var month = normalizar(currentDate.getMonth()+1);
    var day = normalizar(currentDate.getDate());
    var hours = normalizar(currentDate.getHours());
    var minutes = normalizar(currentDate.getMinutes());
    var seconds = normalizar(currentDate.getSeconds());

    var dateTime =  year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    return dateTime;
}


/* ACTUALIZACION DE DATOS */

function actualizarDatos(pnum){  /*TODO agrupar*/
    $.ajax({
        url: "rest/cliente/" + pnum,
        method: "GET", 
        success: function(data){
            if(pnum==num_cuenta){
                datos=data;
                almacenarDatosCliente();
            }
            else{
                datos2=data;
                almacenarDatosClienteDestino();
            };
            
            alert('success');
        }
    });
}
function almacenarDatosCliente(){
    sessionStorage.setItem('direccion', datos.direccion);
    sessionStorage.setItem('edad', datos.edad);
    sessionStorage.setItem('nombre', datos.nombre);
    sessionStorage.setItem('balance', datos.balance);
}
function almacenarDatosClienteDestino(){
    direccion2= datos2.direccion;
    edad2= datos2.edad;
    nombre2= datos2.nombre;
    balance2= datos2.balance;
    alert('success destino');
};


/* REGISTRO DE MOVIMIENTOS */

function registrarMovimiento(tipo,valor,cuenta){
    $.ajax({
        url: "rest/movimientos",
        method: "POST", 
        contentType: 'application/json',
        dataType: 'json',
        data: doJsonMovim(tipo,valor,cuenta),        
        success: function(){
            alert('movimiento registrado');
        }
    });
}


/* PANTALLA PRINCIPAL */ /* LISTO */

$(function(){
$("#consultas,#extraccion,#transferencia,#deposito,#bonos").click(function(){  /*TODO agrupar*/
            actualizarDatos(num_cuenta);
});
});

/* EXTRACCION */ /* LISTO */

$(function(){
    $("#extraer").click(function(){
        var input_monto= document.getElementById("input_monto").value;  
        input_monto *= -1;
        modificarBalance(num_cuenta,input_monto);
        registrarMovimiento("Extraccion",input_monto,num_cuenta);
    });
});

/* TRANSFERENCIAS */ /* LISTO */

function displayTransferencia() {
    var input_monto= document.getElementById("input_monto").value;
    num_cuenta_destino= document.getElementById("num_cuenta_destino").value;
    actualizarDatos(num_cuenta_destino);
    document.getElementById("demo").innerHTML = "Usted va a transferir $"+input_monto+" a "+nombre2+", cuyo numero de cuenta es: "+num_cuenta_destino;
    document.getElementById("transferir").innerHTML = "Modificar";
    document.getElementById("confirmar").innerHTML = '<button onclick="realizarTransferencia()" type="submit" class="btn btn-secondary mt-4">Confirmar</button>';
}

function realizarTransferencia(){  /*TODO agrupar*/
    $.ajax({
        url: "rest/transaccion",
        method: "POST", 
        contentType: 'application/json',
        dataType: 'json',
        data: doJsonTransf(),        
        success: function(){
        var input_monto= document.getElementById("input_monto").value;  
        modificarBalance(num_cuenta_destino,input_monto);
        modificarBalance(num_cuenta,input_monto *= -1); 
        alert('transferencia completada');
        registrarMovimiento("Transferencia",input_monto,num_cuenta);
        registrarMovimiento("Transferencia",input_monto *= -1,num_cuenta_destino)
        },
    });
};


/* DEPOSITOS */ /* LISTO */

$(function(){
    $("#depositar").click(function(){
        var input_monto= document.getElementById("input_monto").value;  
        modificarBalance(num_cuenta,input_monto);
        registrarMovimiento("Deposito",input_monto,num_cuenta);
    });
});


/* BONOS */

/* CONSULTAS */

$(function(){
    $("#consultas").click(function(){
        $.ajax({
            url: "rest/movimientos",
            method: "GET", 
            success: function(data){
                var movimientos = data;
                movimientosCuenta = movimientos.filter( element => element.cuenta == num_cuenta);
                movimientosCuenta.sort(function(a, b){
                    return b.id - a.id;
                });
                movimientosCuenta=JSON.stringify(movimientosCuenta);
                alert(movimientosCuenta);
                sessionStorage.setItem('movimientos', movimientosCuenta);
            },
        });
    });
});

function showTable(){
    document.getElementById('tabla').style.visibility="visible";
}
function hideTable(){
    document.getElementById("tabla").style.visibility="hidden";
}   

function signo(num){
    if(Math.sign(num)>0){sig=""}else{sig="-"};
    return sig;
}
function actualizarUltimosMovimientos(){
    showTable();
    movimientosCuenta = sessionStorage.getItem('movimientos');
    var i;
    movimientosCuenta= JSON.parse(movimientosCuenta);
    for (i = 0; i < 5; i++) {
        obj=movimientosCuenta[i];
        var fec = (obj.fecha).toString().slice(0,19);
        var mov = obj.tipo;
        var mon = signo(obj.monto)+" $"+Math.abs(obj.monto).toString();
        var sfec="fec"+(i+1).toString();
        var smov= "mov"+(i+1).toString();
        var smon="mon"+(i+1).toString();
        document.getElementById(sfec).innerHTML = fec;
        document.getElementById(smov).innerHTML = mov;
        document.getElementById(smon).innerHTML = mon;   
        };
};
