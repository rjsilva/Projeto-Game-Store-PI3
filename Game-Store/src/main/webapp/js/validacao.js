function botaoVoltar() {

    href.window.location = "AcessorioServlet?acao=cadastro";
}
//=====BOTÃO CANCELAR DA PARTE DE CADASTRO DE PRODUTO========//
function BotaoCancelarProduto() {

    window.location = "AcessorioServlet?acao=listar";
}
//=====BOTÃO CANCELAR DA PARTE DE CADASTRO DE FILIAL========//
function BotaoCancelarFilial() {

    window.location = "FilialServlet?acao=listar";
}

//======DESABILITA OS BOTÕES SE O ID ESTIVER VÁZIO========//
function desabilitaBotao() {

    var id = document.getElementById("id").value;
    if (id != "" || id == "null") {

        document.getElementById("btncadastrar").style.display = 'none';
    } else {

        document.getElementById("btncancelar").style.display = 'none';
        document.getElementById("btnatualizar").style.display = 'none';
    }
}
//======DESABILITA A TELA DE CADASTRO FUNCIONÁRIO CASO O USUÁRIO NÃO TENHA PERMISSÃO ========///
function desabilitaTelaFuncionario() {

    var user = document.getElementById("user").value;
    if (user != "ADMIN") {

        document.getElementById("nomefuncionario").disabled = true;
        document.getElementById("cpf").disabled = true;
        document.getElementById("telefone").disabled = true;
        document.getElementById("dtnascimento").disabled = true;
        document.getElementById("cargo").disabled = true;
        document.getElementById("local_trabalho").disabled = true;
        document.getElementById("endereco").disabled = true;
        document.getElementById("bairro").disabled = true;
        document.getElementById("cidade").disabled = true;
        document.getElementById("uf").disabled = true;
        document.getElementById("cep").disabled = true;
        document.getElementById("btncadastrar").style.display = 'none';
    }
}
//DESABILTA A TELA CRIAR USUÁRIO CASO O USUÁRIO NÃO TEM PERMISSÃO DE CRIAR USUÁRIOS PARA O SISTEMA//
function desabilitaTelaUsuario() {

    var user = document.getElementById("user").value;
    if (user != "ADMIN") {

        document.getElementById("usuario").disabled = true;
        document.getElementById("senha").disabled = true;
        document.getElementById("perfil").disabled = true;
        document.getElementById("btncriarusuario").style.display = 'none';
    }
}

//=======VÁLIDA SO CAMPOS EM BRANCO NA TELA DE CADASTRO DE USUÁRIO, FORÇANDO O USUÁRIO A PREENCHER TODOS OS DADOS========//
function validarCampos(frm) {


    if (frm.acessorio.value == "") {

        alert("Informe o nome do produto");
        return false;
    }
    if (frm.marca.value == "") {

        alert("Informe a marca do produto");
        return false;
    }
    if (frm.preco.value == 0) {

        alert("Informe o preço");
        return false;
    }
    if (frm.tipo.value == "") {

        alert("Informe o tipo do produto");
        return false;
    }
    if (frm.quantidade.value == 0) {

        alert("Informe a quantidade do produto");
        return false;
    }
    if (frm.nf.value == "null" || frm.nf.value == 0) {

        alert("Informe o número da nota fiscal");
        return false;
    }
    if (frm.id.value != 0 && frm.id.value != "null") {
        alert("atualizado com sucesso");
    } else {
        alert("cadastrado com sucesso");
    }
    frm.submit();
}


//====VÁLIDA OS CAMPOS EM BRANCO DA TELA CADASTRO DE FILIAL, FORÇANDO OS USUÁRIOS A PREENCHEREM TODOS OS DADOS=======//
function validarCamposFilial(frm) {


    if (frm.razaosocial.value == "") {

        alert("Informe a razão social da empresa");
        return false;
    }
    if (frm.cnpj.value == "") {

        alert("Informe o cnpj");

        return false;
    }
    if (frm.telefone.value == 0) {

        alert("Informe o telefone");
        return false;
    }
    if (frm.endereco.value == "") {

        alert("Informe o endereço da empresa");
        return false;
    }
    if (frm.cep.value == "") {

        alert("Informe o cep da empresa");
        return false;
    }

    var uf = combo.options[combo.selectedIndex].text;
    if (frm.uf.value == "" || frm.nf.value == "Selecione um Estado") {

        alert("Informe o estado da empresa");
        return false;
    }
    var cidade = combo.options[combo.selectedIndex].text;
    if (frm.cidade.value == "" && frm.cidade.value != "Selecione uma cidade") {
        alert("Informa a cidade da esmpresa");
    }
    if (frm.bairro.value == "") {

        alert("informe o bairro da empresa");
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
function validarTelaVenda(frm) {


    if (frm.nomeproduto.value == "") {

        alert("Escolha o nome do produto");
        return false;
    }
    if (frm.codigofuncionario.value == "") {

        alert("Digite o código do funcionário");
        return false;
    }
    if (frm.dtvenda.value == 0) {

        alert("Informe a data da venda");
        return false;
    }
    if (frm.filial.value == "") {

        alert("Escolha a filial");
        return false;
    }
    if (frm.quantvenda.value == 0) {

        alert("Informe a quantidade do produto");
        return false;
    }
    if (frm.quantvenda.value > frm.qtdestoque.value) {

        alert("quantidade de venda não pode ser maior do que a do estoque");
        return false;
    }
    frm.submit();
}

//=======FORMATA CAMPO TELEFONE===========///
function mascara(telefone) {
    if (telefone.value.length == 0)
        telefone.value = '(' + telefone.value; //quando começamos a digitar, o script irá inserir um parênteses no começo do campo.
    if (telefone.value.length == 3)
        telefone.value = telefone.value + ') '; //quando o campo já tiver 3 caracteres (um parênteses e 2 números) o script irá inserir mais um parênteses, fechando assim o código de área.

    if (telefone.value.length == 10)
        telefone.value = telefone.value + '-'; //quando o campo já tiver 8 caracteres, o script irá inserir um tracinho, para melhor visualização do telefone.

}
//=======FORMATA O CAMPO DATA==================
function mascaraData(campoData)
{

    var data = campoData.value;
    if (data.length == 2)
    {

        data = data + '/';
        document.form.data.value = data;
        return true;
    }
    if (data.length == 5)
    {

        data = data + '/';
        document.form.data.value = data;
        return true;
    }

}
//========FORMATA CAMPO DATA NO FORMATO DD/MM/YYY===========//
function mascaraData(campoData)
{

    var data = campoData.value;
    if (data.length == 2)
    {

        data = data + '/';
        document.form.data.value = data;
        return true;
    }
    if (data.length == 5)
    {

        data = data + '/';
        document.form.data.value = data;
        return true;
    }

}

//=======PESQUISA CEP===========

function limpa_formulário_cep() {
    //Limpa valores do formulário de cep.
    document.getElementById('rua').value = ("");
    document.getElementById('bairro').value = ("");
    document.getElementById('cidade').value = ("");
    document.getElementById('uf').value = ("");
}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        document.getElementById('rua').value = (conteudo.logradouro);
        document.getElementById('bairro').value = (conteudo.bairro);
        document.getElementById('cidade').value = (conteudo.localidade);
        document.getElementById('uf').value = (conteudo.uf);
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulário_cep();
        alert("CEP não encontrado.");
    }
}

function pesquisacep(valor) {

    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;

        //Valida o formato do CEP.
        if (validacep.test(cep)) {

            //Preenche os campos com "..." enquanto consulta webservice.
            document.getElementById('rua').value = "...";
            document.getElementById('bairro').value = "...";
            document.getElementById('cidade').value = "...";
            document.getElementById('uf').value = "...";

            //Cria um elemento javascript.
            var script = document.createElement('script');

            //Sincroniza com o callback.
            script.src = '//viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep();
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulário_cep();
    }
}

//=====VALIDA CPF======
function validarCPF(cpf) {
    var filtro = /^\d{3}.\d{3}.\d{3}-\d{2}$/i;

    if (!filtro.test(cpf))
    {
        window.alert("CPF inválido. Tente novamente.");
        document.getElementById('cpf').value = "";
        return false;
    }

    cpf = remove(cpf, ".");
    cpf = remove(cpf, "-");

    if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" ||
            cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" ||
            cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" ||
            cpf == "88888888888" || cpf == "99999999999")
    {
        window.alert("CPF inválido. Tente novamente.");
        document.getElementById('cpf').value = "";
        return false;
    }

    soma = 0;
    for (i = 0; i < 9; i++)
    {
        soma += parseInt(cpf.charAt(i)) * (10 - i);
    }

    resto = 11 - (soma % 11);
    if (resto == 10 || resto == 11)
    {
        resto = 0;
    }
    if (resto != parseInt(cpf.charAt(9))) {
        window.alert("CPF inválido. Tente novamente.");
        document.getElementById('cpf').value = "";
        return false;
    }

    soma = 0;
    for (i = 0; i < 10; i++)
    {
        soma += parseInt(cpf.charAt(i)) * (11 - i);
    }
    resto = 11 - (soma % 11);
    if (resto == 10 || resto == 11)
    {
        resto = 0;
    }

    if (resto != parseInt(cpf.charAt(10))) {
        window.alert("CPF inválido. Tente novamente.");
        document.getElementById('cpf').value = "";
        return false;
    }

    return true;
}

function remove(str, sub) {
    i = str.indexOf(sub);
    r = "";
    if (i == -1)
        return str;
    {
        r += str.substring(0, i) + remove(str.substring(i + sub.length), sub);
    }

    return r;
}

/**
 * MASCARA ( mascara(o,f) e execmascara() ) CRIADAS POR ELCIO LUIZ
 * elcio.com.br
 */
function mascara(o, f) {
    v_obj = o
    v_fun = f
    setTimeout("execmascara()", 1)
}

function execmascara() {
    v_obj.value = v_fun(v_obj.value)
}

function cpf_mask(v) {
    v = v.replace(/\D/g, "")                 //Remove tudo o que não é dígito
    v = v.replace(/(\d{3})(\d)/, "$1.$2")    //Coloca ponto entre o terceiro e o quarto dígitos
    v = v.replace(/(\d{3})(\d)/, "$1.$2")    //Coloca ponto entre o setimo e o oitava dígitos
    v = v.replace(/(\d{3})(\d)/, "$1-$2")   //Coloca ponto entre o decimoprimeiro e o decimosegundo dígitos
    return v
}

//========VALIDA CNPJ======
function validarCNPJ(cnpj) {

    cnpj = cnpj.replace(/[^\d]+/g, '');

    if (cnpj == '')
        return false;

    if (cnpj.length != 14)
        return false;

    // Elimina CNPJs invalidos conhecidos
    if (cnpj == "00000000000000" ||
            cnpj == "11111111111111" ||
            cnpj == "22222222222222" ||
            cnpj == "33333333333333" ||
            cnpj == "44444444444444" ||
            cnpj == "55555555555555" ||
            cnpj == "66666666666666" ||
            cnpj == "77777777777777" ||
            cnpj == "88888888888888" ||
            cnpj == "99999999999999")
        return false;

    // Valida DVs
    tamanho = cnpj.length - 2
    numeros = cnpj.substring(0, tamanho);
    digitos = cnpj.substring(tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(0))
        return false;

    tamanho = tamanho + 1;
    numeros = cnpj.substring(0, tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(1))
        return false;

    return true;

}
