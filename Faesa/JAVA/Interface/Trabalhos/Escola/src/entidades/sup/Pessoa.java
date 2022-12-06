/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.sup;

import java.util.List;
import javax.swing.JOptionPane;
import servicos.ValidaCampo;

/**
 *
 * @author mateus.ferreira && carlos.eugenio
 */

// -> Aplicacao do conceito de superclasse, onde aqui 
// temos os parametros basicos de cadastro de alguem na escola
public class Pessoa {

    // Atributos da classe
    public String nome;
    public String cpf;
    
    // Construtores da classe
    public Pessoa(){
    }
    
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    // Area de getters e setters (variaveis privadas)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    // Metodo para cadastrar uma pessoa
    public Pessoa Cadastrar(){
        try {      
            Pessoa pessoa = new Pessoa();
            
            // Todos os campos passam por validacao
            pessoa.setNome(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite o nome: "), "nome", 'o'));
      
            pessoa.setCpf(ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite o CPF: "), "CPF", 'o'));
                
            return pessoa;
        }
        
        // Caso o sistema seja fechado, nao apresentara erro na saida
        catch (NullPointerException e){
            System.exit(0);
            return null;
        }
        
        // Se acontecer algum tipo de erro nao tratado
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    // Constroi o layout por indice de uma lista de pessoas
    public static String ConstruirLayout(List<Pessoa> pessoa){
        String construirLayout = "";
        int posicao = 1;
        for (Pessoa pess : pessoa){
            construirLayout += posicao + " - " + pess.getNome() + ", CPF: " + pess.getCpf() + "\n";
            posicao++;
        }
        return construirLayout;
    }
}
