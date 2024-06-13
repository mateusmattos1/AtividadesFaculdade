function calcularMedia() {
    let nota1 = document.getElementById('nota1').value;
    let nota2 = document.getElementById('nota2').value;
    let resultado = document.getElementById('resultado');

    nota1 = parseInt(nota1, 10);
    nota2 = parseInt(nota2, 10);

    resultado.innerHTML = "A média é: " + ((nota1 + nota2) / 2).toFixed(2) + ".";
}

let btn = document.getElementById('calcular');
btn.addEventListener('click', calcularMedia);

