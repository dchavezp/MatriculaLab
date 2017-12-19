function addAgencia(){	
	
var url = "agencia/saveAgencia";
	
	$.ajax({
		url: url,
		type: 'POST',
		data: $('#form_regAgencia').serialize(),      
		success: function(result){
			if(result){  

				alert('Se ha aregado nueva agencia');    
				window.location.replace("agencias");
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







function changeStateAgencia(id,state){  
	var url = "agencia/changeStateAgencia";
   
	$.ajax({
		url: url,
		type: 'POST',
		data: {"key": id, "state":state},      
		success: function(result){
			if(result){  
				alert('Se ha cambiado estado');
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

function changeCheckBoxAgencia(id, check){

	var state = "0";
	if(check.checked){
		   state="1";
    }
	changeStateAgencia(id, state);		
}