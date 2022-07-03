/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

import java.text.DecimalFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author shayane teixeira & mateus mattos
 */
public class Media_Aluno {

    public static void main(String[] args) {

        try {
            
            // Setando local para usar ponto ao invés de vírgula
            Locale.setDefault(Locale.US);
            // Formatação das notas
            DecimalFormat df = new DecimalFormat("0.00");
            
            //Definimos as variaveis nome como string,
            //nota1, nota2, nota3 e 
            //media como double iniciada em 0.
            //faltas como inteiro;
            String nome;
            double n1, n2, n3, media = 0;
            int faltas;

            // Imprimir perguntas na tela em forma de um painel
            nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno: ");
            while (nome.isBlank()) {
                nome = JOptionPane.showInputDialog(null, "Nome vázio. Digite novamente: ");
            }

            // Todas as notas passam por um teste de validação
            n1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a primeira nota: "));
            n1 = retornaNotaValida(n1, 1);

            n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a segunda nota: "));
            n2 = retornaNotaValida(n2, 2);

            n3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a terceira nota: "));
            n3 = retornaNotaValida(n3, 3);

            faltas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de faltas do aluno: "));

            // quantidade de faltas 
            if (faltas > 5) {
                JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi REPROVADO por faltas mesmo que atinja aprovação nas três notas!!");
                // O programa é finalizado se a quantidade de faltas for maior do que 5
                System.exit(0);
            }

            //cálculo da média
            media = (n1 + n2 + n3);

            // Imprimir resultado final 
            JOptionPane.showMessageDialog(null, "A média do aluno \n" + nome + "\nNota 1: " + df.format(n1) + "\n" + "Nota 2: " + df.format(n2) + "\n" + "Nota 3: " + df.format(n3) + "\n" + "Nota final: " + df.format(media));

            //if media recuperacao final, media aprovado e media reprovado
            if (media >= 15 && media <= 18) {
                JOptionPane.showMessageDialog(null, "O aluno " + nome + " vai precisar de RECUPERAÇÃO FINAL!!");
            } else if (media > 18) {
                JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi APROVADO!!");
            } else {
                JOptionPane.showMessageDialog(null, "O aluno " + nome + " foi REPROVADO!!");
            }
            
        // Tratamento de exceções gerais
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        } finally {
            JOptionPane.showMessageDialog(null, "Programa finalizado!!");
        }
    }

    // Método que irá retornar uma nota válida para continuação do programa
    static private double retornaNotaValida(double nota, int numeroDaNota) {
        boolean notaValida = verificaNota(nota);

        // Só salvará a nota quando ela for válida
        while (!notaValida) {
            nota = Double.parseDouble(JOptionPane.showInputDialog(null, "A nota " + numeroDaNota + " está inválida. Digite novamente: "));
            notaValida = verificaNota(nota);
        }
        return nota;
    }

    // Método para verificar se a nota é válida
    static private boolean verificaNota(double nota) {
        return !(nota < 0 || nota > 10);
    }

}
