function validaStatus(status){
    var id = document.getElementById("id").value;
    if(id == "" || id == "null"){
        
       document.getElementById("status").style.display = 'none';
    }
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
//=======VÁLIDA SO CAMPOS EM BRANCO NA TELA DE CADASTRO DE ACESSÓRIO, FORÇANDO O USUÁRIO A PREENCHER TODOS OS DADOS========//
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
    if (frm.cep.value == "") {

        alert("Informe o cep válido");
        return false;
    }
    if (frm.rua.value == "") {

        alert("Informe a rua");
        return false;
    }
    if (frm.bairro.value == "") {

        alert("Informe o bairro");
        return false;
    }
    if (frm.uf.value == "") {
        alert("Informa o estado");
    }
    if (frm.cidade.value == "") {

        alert("informe a cidade");
    }
    if (frm.id.value != 0 && frm.id.value != "null") {
        alert("atualizado com sucesso");
    } else {
        alert("cadastrado com sucesso");
    }
    frm.submit();
}

//====VÁLIDA OS CAMPOS EM BRANCO DA TELA CADASTRO DE FUNCIONÁRIO, FORÇANDO OS USUÁRIOS A PREENCHEREM TODOS OS DADOS=======//
function validarCamposFuncionario(frm) {

    if (frm.nomefuncionario.value == "") {

        alert("Informe o nome funcionário");
        return false;
    }
    if (frm.cpf.value == "") {

        alert("Informe o cpf");
        return false;
    }
    if (frm.telefone.value == "" || frm.telefone.value == 0) {

        alert("Informe o telefone");
        return false;
    }
    if (frm.data.value == "") {

        alert("Informe a data nascimento");
        return false;
    }
    if (frm.cargo.value == "") {

        alert("Informe um cargo");
        return false;
    }
    if (frm.filial.value == 0 || frm.filial.value == null) {

        alert("Informe uma filial");
        return false;
    }
    if (frm.cep.value == "") {

        alert("Informe um cep");
        return false;
    }
    if (frm.rua.value == "") {

        alert("Informe uma rua");
        return false;
    }
    if (frm.bairro.value == "") {

        alert("Informe uma bairro");
        return false;
    }
    if (frm.uf.value == "") {
        alert("Informa o estado");
    }
    if (frm.cidade.value == "") {

        alert("informe a cidade");
    }
    if (frm.id.value != 0 && frm.id.value != "null") {
        alert("atualizado com sucesso");
    } else {
        alert("cadastrado com sucesso");
    }
    frm.submit();
}

//==============VALIDAR CAMPO ABRIR CHAMADO ======================//
function validarCampoAbrirChamado(frm) {

    if (frm.email.value == "") {

        alert("Informe seu email");
        return false;
    }
    if (frm.telefone.value == "") {

        alert("Informe seu telefone");
        return false;
    }
    if (frm.assunto.value == "") {

        alert("Informe o assunto");
        return false;
    }
    if (frm.comentario.value == "" || frm.comentario.value == null) {

        alert("Detalhe o problema");
        return false;
    }

    frm.submit();
}
//==========VÁLIDA OS CAMPOS EM BRANCO NA TELA CRIAR USUÁRIO FORÇANDO O USUÁRIO A PREENCHER OS CAMPOS==========
function validarTelaCriarUsuario(frm) {


    if (frm.funcionario.value == 0 || frm.funcionario.value == null) {

        alert("Selecione um Funcionário");

        return false;
    }
    if (frm.filial.value == 0 || frm.filial.value == null) {

        alert("Selecione uma Filial");

        return false;
    }
    if (frm.cpf.value == "" || frm.cpf.value == null) {

        alert("digite o cpf do usuário");

        return false;

    }
    if (frm.perfil.value == 0 || frm.perfil.value == null) {

        alert("Selecione um Perfil");

        return false;

    }
    if (frm.email.value == "" || frm.email.value == null) {

        alert("Digite um Email");

        return false;

    }

    else {

        frm.submit();
    }
}
//====FORMATA O VALOR NO CAMPO INPUT========//
function moeda(z) {
    v = z.value;
    v = v.replace(/\D/g, "") // permite digitar apenas numero
    v = v.replace(/(\d{1})(\d{14})$/, "$1.$2") // coloca ponto antes dos ultimos digitos
    v = v.replace(/(\d{1})(\d{11})$/, "$1.$2") // coloca ponto antes dos ultimos 11 digitos
    v = v.replace(/(\d{1})(\d{8})$/, "$1.$2") // coloca ponto antes dos ultimos 8 digitos
    v = v.replace(/(\d{1})(\d{5})$/, "$1.$2") // coloca ponto antes dos ultimos 5 digitos
    v = v.replace(/(\d{1})(\d{1,2})$/, "$1,$2") // coloca virgula antes dos ultimos 2 digitos
    z.value = v;
}
//=====FORÇA O USUÁRIO A PREENCHER OS DADOS NA TELA DE VENDA==========//
function validarTelaVenda(frm) {


    if (frm.nomeproduto.value == 0) {

        alert("Escolha o nome do produto");
        return false;
    }
    if (frm.quantvenda.value == 0) {

        alert("Informe a quantidade do produto");

        return false;
    }
    var quantvenda = document.getElementById("quantvenda").value;
    var quantestoque = document.getElementById("qtdestoque").value;
    var venda = parseInt(quantvenda);
    var estoque = parseInt(quantestoque);
    if (venda > estoque) {

        alert("quantidade de venda não pode ser maior do que a do estoque");

        return false;
    } else {

        frm.submit();
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

//=======MASCARA CPF( mascara(o,f) e execmascara() =========

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
//================VALIDA CNPJ, DATA, TELEFONE=====================

//===========VALIDA O CNPJ DIGITE NO FORMATO DO GERADOR CNPJ===================
function ValidarCNPJ(ObjCnpj) {
    var cnpj = ObjCnpj.value;
    var valida = new Array(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2);
    var dig1 = new Number;
    var dig2 = new Number;

    exp = /\.|\-|\//g
    cnpj = cnpj.toString().replace(exp, "");
    var digito = new Number(eval(cnpj.charAt(12) + cnpj.charAt(13)));

    for (i = 0; i < valida.length; i++) {
        dig1 += (i > 0 ? (cnpj.charAt(i - 1) * valida[i]) : 0);
        dig2 += cnpj.charAt(i) * valida[i];
    }
    dig1 = (((dig1 % 11) < 2) ? 0 : (11 - (dig1 % 11)));
    dig2 = (((dig2 % 11) < 2) ? 0 : (11 - (dig2 % 11)));

    if (((dig1 * 10) + dig2) != digito) {
        alert('CNPJ Invalido!');
        document.getElementById('cnpj').value = "";
    } else {

        return true;
    }

}

//========MASCARA TELEFONE============================
function mascara(o, f) {
    v_obj = o
    v_fun = f
    setTimeout("execmascara()", 1)
}
function execmascara() {
    v_obj.value = v_fun(v_obj.value)
}
function mtel(v) {
    v = v.replace(/\D/g, "");             //Remove tudo o que não é dígito
    v = v.replace(/^(\d{2})(\d)/g, "($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v = v.replace(/(\d)(\d{4})$/, "$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}

//=======MASCARA CNPJ============
function FormataCnpj(campo, teclapres)
{
    var tecla = teclapres.keyCode;
    var vr = new String(campo.value);
    vr = vr.replace(".", "");
    vr = vr.replace("/", "");
    vr = vr.replace("-", "");
    tam = vr.length + 1;
    if (tecla != 14)
    {
        if (tam == 3)
            campo.value = vr.substr(0, 2) + '.';
        if (tam == 6)
            campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 5) + '.';
        if (tam == 10)
            campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3) + '.' + vr.substr(6, 3) + '/';
        if (tam == 15)
            campo.value = vr.substr(0, 2) + '.' + vr.substr(2, 3) + '.' + vr.substr(6, 3) + '/' + vr.substr(9, 4) + '-' + vr.substr(13, 2);
    }
}
//======VALIDA DATA=======
function mascara_data(data) {
    var mydata = '';
    mydata = mydata + data;
    if (mydata.length == 2) {
        mydata = mydata + '/';
        document.forms[0].data.value = mydata;
    }
    if (mydata.length == 5) {
        mydata = mydata + '/';
        document.forms[0].data.value = mydata;
    }
    if (mydata.length == 10) {
        verifica_data();
    }
}

function verifica_data() {

    dia = (document.forms[0].data.value.substring(0, 2));
    mes = (document.forms[0].data.value.substring(3, 5));
    ano = (document.forms[0].data.value.substring(6, 10));

    situacao = "";
    // verifica o dia valido para cada mes 
    if ((dia < 01) || (dia < 01 || dia > 30) && (mes == 04 || mes == 06 || mes == 09 || mes == 11) || dia > 31) {
        situacao = "falsa";
    }

    // verifica se o mes e valido 
    if (mes < 01 || mes > 12) {
        situacao = "falsa";
    }

    // verifica se e ano bissexto 
    if (mes == 2 && (dia < 01 || dia > 29 || (dia > 28 && (parseInt(ano / 4) != ano / 4)))) {
        situacao = "falsa";
    }

    if (document.forms[0].data.value == "") {
        situacao = "falsa";
    }

    if (situacao == "falsa") {
        alert("Data inválida!");
        document.getElementById("data").value = "";
        document.forms[0].data.focus();
    }
}
//========VÁLIDA EMAIL DIGITADO NO CAMPO INPUT DA CRIAÇÃO DE USUÁRIO

function validarEmail(field) {
    usuario = field.value.substring(0, field.value.indexOf("@"));
    dominio = field.value.substring(field.value.indexOf("@") + 1, field.value.length);

    if ((usuario.length >= 1) &&
            (dominio.length >= 3) &&
            (usuario.search("@") == -1) &&
            (dominio.search("@") == -1) &&
            (usuario.search(" ") == -1) &&
            (dominio.search(" ") == -1) &&
            (dominio.search(".") != -1) &&
            (dominio.indexOf(".") >= 1) &&
            (dominio.lastIndexOf(".") < dominio.length - 1)) {
    }
    else {
        alert("E-mail invalido");
        document.getElementById('email').value = "";
    }
}