<?php

    $hostname = "localhost";
    $bancodedados = "form";
    $usuario = "root";
    $senha = "";
    $mysqli = new mysqli($hostname, $usuario, $senha, $bancodedados);

    // retorna o numero do erro
    if ($mysqli -> connect_errno){
        echo "Falha ao conectar: (" .$mysqli -> connect_errno .") ".$mysqli -> connect_errno;
    }else{
        echo "Mensagem foi enviada com sucesso!";
    }

?>
