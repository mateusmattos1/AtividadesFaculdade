/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academico;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author 20181tiimi0197
 */
public class Sistema {
    ArrayList<Aluno> alunos;
    ArrayList<Questao> questoes;

    public Sistema() {
        this.alunos = new ArrayList<>();
        this.questoes = new ArrayList<>();
    }
    
    
    public void inserirAluno(Aluno a){
        this.alunos.add(a);
    }
    
    public void inserirQuestao(Questao q){
        this.questoes.add(q);
    }
    
    public void salvarAlunos() throws IOException {
        FileWriter f = new FileWriter("alunos.txt");
        BufferedWriter b = new BufferedWriter(f);
        
        b.write( this.alunos.size() + "\n" );
        
        for (Aluno a : this.alunos) {
            b.write(a.getCodigo()+ "\n");
            b.write(a.getNome() + "\n");
            b.write(a.getNota()+ "\n");
        }
        
        b.close();
    }
    public void lerAlunos() throws FileNotFoundException, IOException {
        FileReader f = new FileReader("alunos.txt"); 
        BufferedReader b = new BufferedReader(f);
        
        int n = Integer.parseInt( b.readLine() );
        
        for (int i = 0; i < n; i++) {
            String codigo = b.readLine();
            String nome = b.readLine();
            Double nota = Double.parseDouble(b.readLine());
            
            Aluno a = new Aluno(codigo, nome, nota);
            try {
                this.inserirAluno(a);
            } catch (RepeticaoException ex) {
                System.out.println("Então... deu ruim. Já tinha um aluno com esse login.");
            }
        }
        
        b.close();
        
    }
    public void salvarQuestoes() throws IOException {
        FileWriter f = new FileWriter("questoes.txt");
        BufferedWriter b = new BufferedWriter(f);
        
        b.write( this.questoes.size() + "\n" );
        
        for (Questao q : this.questoes) {
            b.write(q.getEnunciado()+ "\n");
            b.write(q.getGabarito()+ "\n");
            b.write(q.getAlternativas().size() + "\n");
            for (String a : q.getAlternativas()){
                b.write(a + "\n");
            }
        }
        
        b.close();
    }
    public void lerQuestoes() throws FileNotFoundException, IOException {
        FileReader f = new FileReader("questoes.txt"); 
        BufferedReader b = new BufferedReader(f);
        
        int n = Integer.parseInt( b.readLine() );
        
        for (int i = 0; i < n; i++) {
            String enunciado = b.readLine();
            int gabarito = Integer.parseInt(b.readLine());
            int k = Integer.parseInt(b.readLine());
            ArrayList<String> alternativas = new ArrayList();
            for (int j = 0; j < k; j++){
                alternativas.add(b.readLine());
            }
            
            Questao q = new Questao(enunciado, alternativas, gabarito);
            try {
                this.inserirQuestao(q);
            } catch (RepeticaoException ex) {
                System.out.println("Então... deu ruim. Já tinha uma questao com esse login.");
            }
        }
        
        b.close();
        
    }
}
