function Abrir_ventana (pagina) 
{
var opciones="toolbar=no, location=no, maximize:no, minimize:no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=508, height=365, top=85, left=140";
window.open(pagina,"",opciones);
}

 function borrarHistorial()
    {
		if (history.forward(1)) {
			location.replace(history.forward(1));
		}
}

function validar(form){
		    var form = document.getElementById('formperfil');
		    var id = form.id;
		    var nombre = form.nombre;
		    
		    if(id.value != '' && nombre.value != ''){
		     form.submit(); 
		     return true;             
		    }
		    
		    alert('Por favor ingrese id o nombre de perfil');
		    return false;
		   }