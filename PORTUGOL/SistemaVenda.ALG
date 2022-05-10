 Algoritmo "Trabalho Portugol"

// Disciplina   : Projeto Integrador I-A
// Professor   : Lorena Piza Arndt
// Descri��o   : L� os dados de 3 produtos e de uma venda. Mostra os dados
//               da venda e do produto atualizado.
// Autor(a)    : Mateus de Mattos Ferreira e Shayane Teixeira da Cruz
// Data atual  : 09/04/2022

Var
// Se��o de Declara��es das vari�veis - DADOS DO ESTOQUE
// Definimos que o valor unit�rio de venda e o valor total s�o do tipo real,
// pois vamos trabalhar com n�meros decimais. Al�m disso, por serem 3 produtos,
// utilizamos vetores.

codProduto, quantEstoque:vetor [1..3] de inteiro
nomeProduto:vetor [1..3] de caractere
valorProduto, valorVenda, valorTotal:vetor [1..3] de real
//vari�vel auxiliar para o la�o
indice, indicex: inteiro

// Se��o de Declara��es das vari�veis - DADOS DA VENDA. O valor total da venda
// tamb�m ser� um n�mero decimal, assim como o valor de desconto.

nomeCliente, formaPagamento: caractere
codProdutoCliente, quantVendida: inteiro
desconto, valorTotalVenda: real

Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc...

// Aqui iremos ler todos os dados necess�rios para o funcionamento do programa,
// se tratando de DADOS DO ESTOQUE.

para indice de 1 ate 3 faca
     escreva ("Digite o c�digo do produto: ")
            leia (codProduto[indice])
     escreva ("Digite o nome do produto: ")
            leia (nomeProduto[indice])
     escreva ("Digite o valor unit�rio do produto em estoque: ")
            leia (valorProduto[indice])
     escreva ("Digite a quantidade do produto em estoque: ")
            leia (quantEstoque[indice])
     escreval()

     // Aqui realizamos os c�lculos para descobrirmos o valor unit�rio de venda
     // do produto e o valor total do produto em estoque.
     valorVenda[indice] <- valorProduto[indice] + (valorProduto[indice] * 70/100)
     valorTotal[indice] <- valorProduto[indice] * quantEstoque[indice]
fimpara


// Aqui iremos ler todos os dados necess�rios para o funcionamento do programa,
// se tratando de DADOS DA VENDA.
escreva ("Digite o nome do cliente: ")
   leia(nomeCliente)
escreva ("Digite o c�digo do produto a ser vendido: ")
	leia(codProdutoCliente)
escreva ("Digite a quantidade que ser� vendida: ")
	leia(quantVendida)
escreva ("A forma de pagamento vai ser � vista ou a prazo? (Digite V ou P) ")
	leia(formaPagamento)
escreval()

//Atribuindo o desconto.
se (formaPagamento = "V") entao
		desconto <- 5/100
senao
      desconto <- 3/100
fimse

//Iremos percorrer o vetor do c�digo dos produtos para ver qual foi vendido.
para indicex de 1 ate 3 faca
	se (codProdutoCliente = codProduto[indicex]) entao
      //Iremos atualizar o estoque do produto vendido.
      quantEstoque[indicex] <- quantEstoque[indicex] - quantVendida

      //Atribuindo o valor da venda e aplicando o desconto.
      valorTotalVenda <- valorVenda[indicex] * quantVendida
      valorTotalVenda <- valorTotalVenda - (valorTotalVenda * desconto)

      //Apresenta��o final dos objetivos do trabalho
      escreval("-----------------------")
      escreval("-----DADOS DA VENDA----")
      escreval("-----------------------")
      escreval("Dados atualizados do estoque: ",quantEstoque[indicex],"." )
      escreval("Dados da venda:")
      escreval("Nome do cliente: ", nomeCliente,".")
      escreval("O produto vendido �: ",nomeProduto[indicex],", e a quantidade vendida foi: ",quantVendida,".")
      se (desconto = 5/100) entao
	   // Aqui estamos arredondando em duas casas decimais por se tratar de dinheiro
         escreval("Houve desconto de 5% porque o pagamento foi � vista, ent�o o valor ficou: ",valorTotalVenda:2:0,".")
      senao
         escreval("Houve desconto de 3% porque o pagamento foi � prazo, ent�o o valor ficou: ",valorTotalVenda:2:0,".")
      fimse
	fimse
fimpara

Fimalgoritmo
