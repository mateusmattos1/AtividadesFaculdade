/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author mateus.ferreira
 */
public class Cliente {

    public Cliente() {
    }

    public Cliente(String nome, long CPF, String endereco, String email, long celular) {
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.email = email;
        this.celular = celular;
        ArrayList<Veiculo> veic = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public ArrayList<Veiculo> getVeic() {
        return veic;
    }

    public void setVeic(ArrayList<Veiculo> veic) {
        this.veic = veic;
    }
    
    private String nome;
    private long CPF;
    private String endereco;
    private String email;
    private long celular;
    private ArrayList<Veiculo> veic;
}
