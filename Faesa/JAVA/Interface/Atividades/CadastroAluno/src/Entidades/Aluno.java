/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author mateus.ferreira
 */
public class Aluno {
    
    public String nome;
    public String endereco;
    public String numero;
    public String email;
    public String matricula;
    
    public Aluno() {
    }

    public Aluno(String nome, String endereco, String numero, String email, String matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.email = email;
        this.matricula = matricula;
    }
    
}
