/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Escola;
import entidades.sub.Aluno;
import entidades.sub.Professor;
import entidades.sup.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
    Alguns dos metodos utilizados:
        1 - .trim(): tira espaços vazios no inicio ou fim da string
        2 - .equals(): utilizado para comparações
        3 - .substring(): corta a string em "pedaços"
        4 - .toUpperCase(): colocar os caracteres em maiusculo
        5 - .contains(): serve para ver se um objeto esta numa lista
        6 - .size(): tamanho da lista

    Observações:

        1 - Alguns whiles do sistema tem um if "embutido", nao precisando 
        ser usado um if separado para fazer a verificacao.

        2 - Os nullpointers exception são previstos no programa e tratados,
        mas eles estouram quando o sistema é fechado (botão X ou Cancelar),
        por isso eles são utilizados no Catch.
*/

/**
 *
 * @author mateus.ferreira && carlos.eugenio
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    // Entidades estaticas que metodos diferentes vao acessar
    static List<Professor> professores = new ArrayList<>();
    static List<Aluno> alunos = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        // Inicializando o programa cadastrando a escola
        Escola escola = new Escola().CadastrarEscola();
        
        // Depois da escola ter sido cadastrada, cadastramos alunos e professores
        ConstruirTelaPrincipal(escola);    
    }
    
    // Metodo utilizado para controlarmos o menu
    private static void ConstruirTelaPrincipal(Escola escola){
        try {
            // O usuario escolhe a opcao
            String opcao = OpcaoCadastro(escola);
        
            boolean opcaoValida = false;
            
            /* 
            Depois de cada processo, o usuario retorna ao menu inicial
            refazendo a variavel 'opcao',
            a não ser que ele escolha a opcao de sair 
            */ 
            while (!opcaoValida){
                // Opcao de cadastro de professor
                switch (opcao){
                    case "1":                    
                        /* 
                        Adicionando um novo cadastro de professor
                        na nossa lista estatica de professores 
                        */ 
                        professores.add(new Professor().Cadastrar());
                        opcao = OpcaoCadastro(escola);
                        break;
            
                    case "2":
                        // Só pode ser cadastrado aluno se tiver professor
                        if (professores.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Favor, cadastrar pelo menos UM professor antes. Voltando ao menu inicial...");
                            opcao = OpcaoCadastro(escola);
                            break;
                        }
                        // Cadastro de aluno
                        Aluno aluno = new Aluno().Cadastrar();
                        alunos.add(aluno);
                        
                        /*
                        Vamos acessar um professor escolhido pelo usuario 
                        e relacionar com o aluno cadastrado
                        */
                        professores = new Professor().CadastrarAlunoAoProfessor(professores, aluno);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado!");
                   
                        opcao = OpcaoCadastro(escola);
                        break;
                
                    case "3":
                        // Verifica se ja tem algum aluno cadastrado
                        if (alunos.isEmpty()){
                            JOptionPane.showMessageDialog(null, "Favor, cadastrar pelo menos UM aluno antes. Voltando ao menu inicial...");
                            opcao = OpcaoCadastro(escola);
                            break;
                        }
                        
                        /* 
                        Metodo para que o usuario escolha o aluno.
                        Dentro desse metodo tambem verificamos aprovacao
                        */
                        Aluno.ListarAluno(alunos, professores, escola);
                        opcao = OpcaoCadastro(escola);
                        break;
                        
                    // Opcao de sair
                    case "0":
                        opcaoValida = true;
                
                // Caso nenhuma opcao apresentada seja escolhida, reinicia o cadastro
                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida. Voltando ao menu inicial...");
                    opcao = OpcaoCadastro(escola);
                }
            }        
        }
        
        // Caso o sistema seja fechado, nao apresentara erro na saida
        catch (NullPointerException e){
            System.exit(0);
        }
        
        // Erros nao tratados
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
    
    // Metodo para escolher opcao do menu
    private static String OpcaoCadastro(Escola escola){
        String opcao =  JOptionPane.showInputDialog(null, "Bem vindo à escola " + escola.getNome() + "!\n"
            + " Escolha uma opção de cadastro: \n\n"
            + "1 - Cadastrar Professor\n"
            + "2 - Cadastrar Aluno\n"
            + "3 - Verificar aprovação\n"
            + "0 - Sair\n");
        return opcao.trim();
    }
}
