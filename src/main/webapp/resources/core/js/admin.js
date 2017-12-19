
function addAdmin(){	
	var url = "admin/saveAdmin";
	
	$.ajax({
		url: url,
		type: 'POST',
		data: $('#form_regUsuario').serialize(),      
		success: function(result){
			if(result){  

				alert('sucess add Admin!' + result);                        
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


function deleteAdmin(){
	var url = 'removeAdmin';
	
	$.ajax({
		url: url,
		type: 'POST',
		data: $('#form_regUsuario').serialize(),      
		success: function(result){
			if(result){  
				//$('#data_table_serv').load('../request/service/getAllService.php'); 
				alert('sucess add Provider!' + result); 
				//clearService();              
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


function changeStateAdmin(id,state){  
	var url = "admin/changeStateAdmin";

	$.ajax({
		url: url,
		type: 'POST',
		data: {"key": id, "state":state},      
		success: function(result){
			if(result){  
				alert('sucess change State Admin!' + result);
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



function changeCheckBox(id, check){

	var state = "0";
	if(check.checked){
		   state="1";
    }
	changeStateAdmin(id, state);		
}


