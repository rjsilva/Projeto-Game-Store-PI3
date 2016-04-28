function BotaoCancelar(){
    
    window.location = "AcessorioServlet?acao=cadastro";
}

/*desabilta botões conforme a solicitação*/
function desabilitaBotao() {

    var id = document.getElementById("id").value;

    if (id != "null") {

        document.getElementById("btnsalvar").style.display = 'none';

    } else {

        document.getElementById("btncancelar").style.display = 'none';
        document.getElementById("btnatualizar").style.display = 'none';
    }
}
/*desabilta tela de cadastro funcionário caso o usuario não seja o admin*/
function desabilitaTelaFuncionario() {

    var user = document.getElementById("user").value;

    if (user != "ADMIN") {

        document.getElementById("filial").disabled = true;
        document.getElementById("cpf").disabled = true;
        document.getElementById("telefone").disabled = true;
        document.getElementById("dtnascimento").disabled = true;
        document.getElementById("endereco").disabled = true;
        document.getElementById("cidade").disabled = true;
        document.getElementById("uf").disabled = true;
        document.getElementById("cep").disabled = true;
        document.getElementById("btncadastrar").style.display = 'none';
    }
}
/*desabilta tela de criar usuario caso o usuario não seja o admin*/
function desabilitaTelaUsuario() {

    var user = document.getElementById("user").value;

    if (user != "ADMIN") {

        document.getElementById("usuario").disabled = true;
        document.getElementById("senha").disabled = true;
        document.getElementById("perfil").disabled = true;
        document.getElementById("btnsalvar").style.display = 'none';
    }
}

/*valida os campo em branco na tela de cadastro de acessório, força o usuário a digitar os produtos*/
function validarCampos(frm) {


    if (frm.acessorio.value == "null") {

        alert("Informe o nome do produto");

        return false;
    }
    if (frm.marca.value == "null") {

        alert("Informe a marca do produto");

        return false;

    }
    if (frm.preco.value == 0) {

        alert("Informe o preço");

        return false;

    }
    if (frm.tipo.value == "null") {

        alert("Informe o tipo do produto");

        return false;

    }
    if (frm.quantidade.value == 0) {

        alert("Informe a quantidade do produto");

        return false;

    }
    if (frm.nf.value == "null" || frm.acessorio.value == 0) {

        alert("Informe o número da nota fiscal");

        return false;

    }

    frm.submit();
}

function validaAcessorio() {
    varItens = document.getElementById('selecaoacessorio');
    if (varItens.value === "jogo") {

        document.getElementById('tipo').disabled = false;
    } else {
        document.getElementById('tipo').disabled = true;
    }
}

/*formata o valor moeda no campo preço*/
function formatar_moeda(campo, separador_milhar, separador_decimal, tecla) {

    var sep = 0;
    var key = '';
    var i = j = 0;
    var len = len2 = 0;
    var strCheck = '0123456789';
    var aux = aux2 = '';
    var whichCode = (window.Event) ? tecla.which : tecla.keyCode;

    if (whichCode == 13)
        return true; // Tecla Enter
    if (whichCode == 8)
        return true; // Tecla Delete
    key = String.fromCharCode(whichCode); // Pegando o valor digitado
    if (strCheck.indexOf(key) == -1)
        return false; // Valor inválido (não inteiro)
    len = campo.value.length;
    for (i = 0; i < len; i++)
        if ((campo.value.charAt(i) != '0') && (campo.value.charAt(i) != separador_decimal))
            break;
    aux = '';
    for (; i < len; i++)
        if (strCheck.indexOf(campo.value.charAt(i)) != -1)
            aux += campo.value.charAt(i);
    aux += key;
    len = aux.length;
    if (len == 0)
        campo.value = '';
    if (len == 1)
        campo.value = '0' + separador_decimal + '0' + aux;
    if (len == 2)
        campo.value = '0' + separador_decimal + aux;

    if (len > 2) {
        aux2 = '';

        for (j = 0, i = len - 3; i >= 0; i--) {
            if (j == 3) {
                aux2 += separador_milhar;
                j = 0;
            }
            aux2 += aux.charAt(i);
            j++;
        }

        campo.value = '';
        len2 = aux2.length;
        for (i = len2 - 1; i >= 0; i--)
            campo.value += aux2.charAt(i);
        campo.value += separador_decimal + aux.substr(len - 2, len);
    }

    return false;
}

/*função para campo do tipo números*/
function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58))
        return true;
    else {
        if (tecla == 8 || tecla == 0)
            return true;
        else
            return false;
    }
}