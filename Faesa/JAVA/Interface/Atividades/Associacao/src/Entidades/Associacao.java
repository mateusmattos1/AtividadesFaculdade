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
public class Associacao {

    public Associacao(int id, String nome, String logradouro, int num, long CEP, String bairro, String cidade, String UF, String telefone, String CPF) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.num = num;
        this.CEP = CEP;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
        this.telefone = telefone;
        this.CPF = CPF;
    }
    
    public Associacao() {
    }
    
    private int id;
    private String nome;
    private String logradouro;
    private int num;
    private long CEP;
    private String bairro;
    private String cidade;
    private String UF;
    private String telefone;
    private String CPF;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public long getCEP() {
        return CEP;
    }

    public void setCEP(long CEP) {
        this.CEP = CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
