/* function for calcule date */
function parseDate(str) {
    var mdy = str.split('-');
    return new Date(mdy[0], mdy[1]-1, mdy[2]);
}

function daydiff(first, second) {
    return Math.round((second-first)/(1000*60*60*24)).toString();
}

function addPaquete(){	
	
var url = "paquete/savePaquete";

var d = new Date(); // date today
var today = d.getFullYear()+ "-" + (d.getMonth()+1)+ "-"+d.getDate();
var duracion = $('#duracionPaquete').val();
var duracionOf = $('#duracionOfertaPaquete').val();
var oferta =  $('#ofertaPaquete').val();

var destinos = $('#multiselectDestino').val();
var image1 = $("#imagen1")[0].files[0];
var image2 = $("#imagen2")[0].files[0];

var datas = new FormData();
var other_data = $('#form_regPaquete').serializeArray();

$.each(other_data,function(key,input){
	datas.append(input.name,input.value);
});

if(destinos !="") datas.append("destinosPaquete",destinos);
if(image1 !="" ) datas.append("image1",image1);
if(image2 !="") datas.append("image2",image2);
if(duracion !="") datas.append("duracion",daydiff(parseDate(today), parseDate(duracion)));
if(duracionOf !="") datas.append("duracionOf",daydiff(parseDate(today), parseDate(duracionOf)));
if(oferta !="") datas.append("ofertaPaquete",oferta);

	$.ajax({
		url: url,		
		type: 'POST',
		data: datas,  
		enctype: 'multipart/form-data',
		processData: false,
		contentType: false,
		data: datas,      
		success: function(result){
			if(result){  

				alert('sucess add Admin!' + result);
				window.location.replace("paquetes");
			}
			else{
				alert('ocurrio algun ERROR, vuelva a intentarlo ');
			}   

		},
		error: function(){
			alert('Ocurrio un erro en el Proceso');
		}
	});
	
}


function changeStatePaquete(id,state){  
	var url = "paquete/changeStatePaquete";
   alert("vals: "+id + " "+state);
	$.ajax({
		url: url,
		type: 'POST',
		data: {"key": id, "state":state},      
		success: function(result){
			if(result){  
				alert('sucess change State paquete!' + result);
			}
			else{
				alert('ocurrio algun ERROR, vuelva a intentarlo ');

			}   
		},
		error: function(){
			alert('Ocurrio un error en el Proceso');
		}
	});
}

function changeCheckBox2(id, check){

	var state = "0";
	if(check.checked){
		   state="1";
    }
	changeStatePaquete(id, state);		
}

