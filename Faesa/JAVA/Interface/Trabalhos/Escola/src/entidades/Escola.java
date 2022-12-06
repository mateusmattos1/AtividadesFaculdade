/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.sub.Professor;
import java.util.List;
import javax.swing.JOptionPane;
import servicos.ValidaCampo;
/**
 *
 * @author mateus.ferreira && carlos.eugenio
 */

// Classe principal
public class Escola {
    
    // Area das variaveis
    private String nome;
    private String endereco;
    private String cnpj;

    // Area dos construtoress
    public Escola() {
    }
    
    public Escola(String nome, String endereco, String cnpj) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }

    // Area de getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    // Metodo para cadastrar a escola
    public Escola CadastrarEscola(){
        try {
            Escola escola = new Escola();
        
            // Todos os campos passam por um servico de validacao
            escola.nome = ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite o nome da escola: "), "nome", 'o');
            escola.cnpj = ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite o CNPJ da escola: "), "CNPJ", 'o');
            escola.endereco = ValidaCampo.VerificarCampo(JOptionPane.showInputDialog(null, "Digite o endereço da escola: "), "endereço", 'o');
       
            return escola;
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
}

