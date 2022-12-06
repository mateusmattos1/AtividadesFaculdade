/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.Subentidades;
import Entidades.Associacao;

/**
 *
 * @author mateus.ferreira
 */
public class Associado extends Associacao {

    public Associado(){
    }
    
    public Associado(String situacao, int numeroAssociado, int id, String nome, String logradouro, int num, long CEP, String bairro, String cidade, String UF, String telefone, String CPF) {
        super(id, nome, logradouro, num, CEP, bairro, cidade, UF, telefone, CPF);
        this.situacao = situacao;
        this.numeroAssociado = numeroAssociado;
    }
    
    private String situacao;
    private int numeroAssociado;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getNumeroAssociado() {
        return numeroAssociado;
    }

    public void setNumeroAssociado(int numeroAssociado) {
        this.numeroAssociado = numeroAssociado;
    }
}
