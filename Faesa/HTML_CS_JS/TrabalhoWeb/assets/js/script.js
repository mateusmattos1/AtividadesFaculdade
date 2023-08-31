window.addEventListener('load', function() {
    showAlert("Bem-vindo ao Sesc Glória!");
});

function showAlert(message) {
    var alertBox = document.createElement("div");
    alertBox.className = "custom-alert"; // Aplicar classe de estilo do CSS
    alertBox.textContent = message;

    document.body.appendChild(alertBox);

    setTimeout(function() {
        document.body.removeChild(alertBox);
    }, 3000);
}