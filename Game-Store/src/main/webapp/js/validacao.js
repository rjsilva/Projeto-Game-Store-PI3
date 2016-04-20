function validarCampo()
{
    var login = document.getElementById("login");
    var senha = document.getElementById("senha");
    
    if(login.value == "" || login.value == null){
        
        alert("Favor preencher os campos em branco");
        
        return false;
        
    }
    
}

