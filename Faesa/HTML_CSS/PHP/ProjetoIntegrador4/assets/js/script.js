// Valida se o formato foi respeitado
function validarTelefone() {
    // Obtém o valor do campo de telefone
    var telefone = document.getElementById('telefone').value;

    // Expressão regular para validar o telefone no formato especificado
    var regex = /^\(\d{2}\) \d{4,5} \d{4}$/;

    if (regex.test(telefone)) {
        // Telefone válido
        return true;
    } else {
        // Telefone inválido, exibe uma mensagem de erro
        alert("Por favor, insira um telefone válido no formato (99) 9999 9999 ou (99) 99999 9999.");
        return false;
    }
}
