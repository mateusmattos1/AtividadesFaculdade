<?php

    require_once("conexao.php");

    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $telefone = $_POST['telefone'];
    $mensagem = $_POST['mensagem'];

    // insercao no banco de dados e guarda o resultado
    $sql = "INSERT INTO cadastro (nome, email, telefone, mensagem) VALUES ('$nome', '$email', '$telefone', '$mensagem')";
    $result = $mysqli -> query($sql);

?>