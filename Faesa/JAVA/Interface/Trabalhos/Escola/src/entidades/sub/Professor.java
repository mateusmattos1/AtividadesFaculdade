/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.sub;

import entidades.sup.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import servicos.ValidaCampo;
/**
 *
 * @author mateus.ferreira && carlos.eugenio
 */

// -> Aplicacao do conceito de subclasse
public class Professor extends Pessoa {
    
    // Area de declaracao de variaveis
    private String materia;
    
    /* 
    Cada professor tem varios alunos.
    Lista previamente inicializada para evitarmos
    nullpointerexcpetion
    */
    public List<Aluno> alunos = new ArrayList();
    
    // Area de construtores - encapsulamento
    public Professor(){
    }
    
    public Professor(String nome, String cpf, String materia) {
        super(nome, cpf);
        this.materia = materia;
    }
    
    // Area de getters e setters (variaveis privadas)
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }   
    
     // Cadastro de professores da escola com sobrescrita de metodo
    @Override
    public Professor Cadastrar(){
        Professor professor = new Professor();
        // Utilizamos o metodo da superclasse (polimorfismo) para não precisar repetir codigo
        Pessoa pessoa = super.Cadastrar();
        professor.nome = pessoa.nome;
        professor.cpf = pessoa.cpf;
        try {
            // Validacoes nos campos
            professor.setMateria(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite a matéria lecionada: "), "matéria", 'a'));
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado!");
            return professor;
        }
        
        // Caso o sistema seja fechado, nao apresentara erro na saida
        catch (NullPointerException e){
            System.exit(0);
            return null;
        }
        
        // Erros nao tratados
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    // Metodo utilizado para associar o aluno a um ou mais professores
    public List<Professor> CadastrarAlunoAoProfessor(List<Professor> professores, Aluno aluno){      
        try {
            String escolha = "S";
            // Enquanto o usuario quiser cadastrar um professor, manteremos um loop
            while (escolha.equals("S")){
                
                List<Pessoa> pessoas = new ArrayList<>();
                
                // Loop utilizado para construir um layout em que o usuario consiga escolher um aluno pelo indice
                for (Professor prof : professores) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.cpf = prof.cpf;
                    pessoa.nome = prof.nome;
                    pessoas.add(pessoa);
                }
                
                // Chamada do layout
                String opcao = JOptionPane.showInputDialog(null, "Escolha a opção de um professor:\n" + ConstruirLayout(pessoas) + "\n");
                
                // Verificamos se o usuario escolheu uma opcao valida. Se nao, persiste na pergunta
                Professor professor = ValidaOpcaoProfessor(opcao, professores);
                while (professor == null){
                    opcao = JOptionPane.showInputDialog(null, "Escolha a opção de um professor:\n" + ConstruirLayout(pessoas) + "\n");
                    professor = ValidaOpcaoProfessor(opcao, professores);
                }
                
                // Com o professor selecionado, percorremos a lista de professores até o encontrarmos
                for (int i = 0; i < professores.size(); i++){
                    if (professores.get(i).equals(professor)){
                        // Se o professor ainda nao tiver o aluno eles sao relacionados
                        if (!professores.get(i).alunos.contains(aluno)){
                            professores.get(i).alunos.add(aluno);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Esse aluno já está cadastrado a esse professor.");
                        }
                    }  
                }
                
                // Pergunta ao usuario se ele quer cadastrar mais algum professor, até obter uma resposta valida
                escolha = JOptionPane.showInputDialog(null, "Esse aluno tem aula com mais algum professor? (S/N)\n");
                while (!escolha.toUpperCase().equals("S") && !escolha.toUpperCase().equals("N")){
                    escolha = JOptionPane.showInputDialog(null, "Opção inválida. Esse aluno tem aula com mais algum professor? (S/N)\n").toUpperCase();
                }   
            }
            return professores;
        }
        
        // Caso o sistema seja fechado, nao apresentara erro na saida
        catch (NullPointerException e){
            System.exit(0);
            return null;
        }
        
        // Excecoes nao tratadas
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    // Metodo utilizado para validarmos a opcao escolhida pelo usuario
    public static Professor ValidaOpcaoProfessor(String opcao, List<Professor> professores){
        try {
            /* 
            Só vai retornar se o usuario digitar qualquer coisa que possa 
            ser inteiro e esteja nas opções apresentadas no menu   
            */
            return professores.get(Integer.parseInt(opcao.trim().substring(0, 1)) - 1);
        }
        // Exemplos de ma utilizacao: não digitar nada, digitar caractere invalido, digitar numero que nao tenha...
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Escolha inválida. Tente novamente");
            return null;
        }
    }
}
