/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.sub;

import entidades.Escola;
import entidades.sup.Pessoa;
import entidades.sub.Professor;
import static entidades.sub.Professor.ValidaOpcaoProfessor;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import servicos.ValidaCampo;

/**
 *
 * @author mateus.ferreira && carlos.eugenio
 */

// -> Aplicacao do conceito de subclasse
public class Aluno extends Pessoa {
    
    // Declaracao de variaveis
    private String matricula;
    private double nota1;
    private double nota2;
    private double nota3;
    private int falta;
    
    // Area de construtores - encapsulamento
    public Aluno(){       
    }
    
    public Aluno(String matricula, String nome, String cpf, double nota1, double nota2, double nota3, int falta) {
        super(nome, cpf);
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    
    // Area de get e setters (variaveis privadas)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public int getFalta() {
        return falta;
    }

    public void setFalta(int falta) {
        this.falta = falta;
    }
          
    // Cadastro de alunos da escola com sobrescrita de metodo
    @Override
    public Aluno Cadastrar(){
        Aluno aluno = new Aluno();
        // Utilizamos o metodo da superclasse (polimorfismo) para não precisar repetir codigo
        Pessoa pessoa = super.Cadastrar();
        aluno.nome = pessoa.nome;
        aluno.cpf = pessoa.cpf;
        try {                                     
            // Validacoes nos campos
            aluno.setMatricula(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite a matricula do aluno: "), "matricula", 'a'));                      
            return aluno;
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
    
    public static void ListarAluno(List<Aluno> alunos, List<Professor> professores, Escola escola){
        try {
            
            List<Pessoa> pessoas = new ArrayList<>();
            
            // Loop utilizado para construir um layout em que o usuario consiga escolher um aluno pelo indice
            for (Aluno aluno : alunos) {
                Pessoa pessoa = new Pessoa();
                pessoa.cpf = aluno.cpf;
                pessoa.nome = aluno.nome;
                pessoas.add(pessoa);
            }
            
            // Chamada do layout
            String opcao = JOptionPane.showInputDialog(null, "Escolha a opção de um aluno:\n" + ConstruirLayout(pessoas) + "\n");
            
            // Verificamos se o usuario escolheu uma opcao valida. Se nao, persiste na pergunta
            Aluno aluno = ValidaOpcaoAluno(opcao, alunos);
            while (aluno == null){
                opcao = JOptionPane.showInputDialog(null, "Escolha a opção de um aluno:\n" + ConstruirLayout(pessoas) + "\n");
                aluno = ValidaOpcaoAluno(opcao, alunos);
            }
            
            // Chamada do metodo de aprovacao
            MostrarAprovacao(aluno, professores, escola);
        
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
    
    // Metodo utilizado para verificamos se um aluno esta aprovado
    public static void MostrarAprovacao(Aluno aluno, List<Professor> professores, Escola escola){
        String construtor = "";
        List<Professor> professoresDoAluno = new ArrayList<>();
        int auxiliar = 1;
        
        // Loop utilizado para verificarmos quais professores dão aula pra esse aluno
        for (Professor prof : professores){
            // Se o professor TIVER alunos, entra na segunda verificacao
            if (prof.alunos != null){
                /*
                Verifica se o professor tem esse aluno. Se tiver,
                chamamos uma variavel auxiliar pra construir um layout
                */
                if (prof.alunos.contains(aluno)){
                    construtor = construtor + auxiliar + " - " + prof.nome + ": "  + prof.getMateria() + "\n";
                    auxiliar++;
                    // Serve para dizer que o professor da aula praquele aluno
                    professoresDoAluno.add(prof);
                }
            }
        }
        try { 
            // Chamada do construtor de menu
            String opcao = JOptionPane.showInputDialog(null, "Escolha a materia digitando a opção do professor:\n" + construtor);
            // Funciona da mesma forma que o metodo ListarAluno. Persiste na questao ate ter resposta valida
            Professor professor = ValidaOpcaoProfessor(opcao, professoresDoAluno);
            while (professor == null){
                opcao = JOptionPane.showInputDialog(null, "Escolha a opção de um professor:\n" + construtor + "\n");
                professor = ValidaOpcaoProfessor(opcao, professores);
            }
            
            // Atribue as notas para o aluno, utilizado para validarmos aprovacao, até ter uma nota valida;
            double notaFinal = -1;
            while (notaFinal < 0 || notaFinal > 100){
                // Os campos double tem validacao em classe externa
                aluno.setNota1(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite a nota 1: "), "nota 1", true, 'a'));
                aluno.setNota2(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite a nota 2: "), "nota 2", true, 'a'));
                aluno.setNota3(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite a nota 3: "), "nota 3", true, 'a'));
                notaFinal = aluno.getNota1() + aluno.getNota2() + aluno.getNota3();
                // Verifica se a nota é possível
                if (notaFinal < 0 || notaFinal > 100) {
                    JOptionPane.showMessageDialog(null, "Nota inválida. Mínimo 0, máximo 100!");
                }
            }
            
            // Utilizacao do servico de verificacao externo novamente.
            aluno.setFalta(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite a nota a quantidade de faltas (máximo 100): "), "quantidade de faltas", 'a', true));
            
            // Utilizado para colocarmos uma data no relatorio final
            Date data = new Date(System.currentTimeMillis()); 
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy"); 
            
            // Verificacao se o aluno foi aprovado ou nao
            if (aluno.falta <= 40 && notaFinal >= 60){
                JOptionPane.showMessageDialog(null, "A escola " + escola.getNome() + ", de CNPJ " + escola.getCnpj() + ", localizada na "
                + escola.getEndereco() + ",\natesta reconhecimento de aprovação do aluno " + aluno.matricula + ",\nde CPF " + aluno.cpf +
                " na matéria de " + professor.getMateria() + ", do professor " + professor.nome + ".\n\n Gerado em " + formatarDate.format(data));
            }
            else {
                JOptionPane.showMessageDialog(null, "A escola " + escola.getNome() + ", de CNPJ " + escola.getCnpj() + ", localizada na "
                + escola.getEndereco() + ",\natesta reconhecimento de reprovação do aluno " + aluno.matricula + ",\nde CPF " + aluno.cpf +
                " na matéria de " + professor.getMateria() + ", do professor " + professor.nome + ", visto que não alcançou os requisitos mínimos"
                + ".\n\n Gerado em " + formatarDate.format(data));
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
    
    // Metodo utilizado para validarmos a opcao escolhida pelo usuario
    public static Aluno ValidaOpcaoAluno(String opcao, List<Aluno> alunos){
        try {
            /* 
            Só vai retornar se o usuario digitar qualquer coisa que possa 
            ser inteiro e esteja nas opções apresentadas no menu   
            */
            return alunos.get(Integer.parseInt(opcao.trim().substring(0, 1)) - 1);
        }
        // Exemplos de ma utilizacao: não digitar nada, digitar caractere invalido, digitar numero que nao tenha...
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Escolha inválida. Tente novamente");
            return null;
        }
    }
}
