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
public class Fornecedor extends Associacao{
    public Fornecedor(){
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
    private String nomeFantasia;
    private String website;

    public Fornecedor(String nomeFantasia, String website, int id, String nome, String logradouro, int num, long CEP, String bairro, String cidade, String UF, String telefone, String CPF) {
        super(id, nome, logradouro, num, CEP, bairro, cidade, UF, telefone, CPF);
        this.nomeFantasia = nomeFantasia;
        this.website = website;
    }
}
