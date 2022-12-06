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
public class Colaborador extends Associacao{
    
    public Colaborador(){
    }
    
    private String cargoOuFuncao;

    public Colaborador(String cargoOuFuncao, int id, String nome, String logradouro, int num, long CEP, String bairro, String cidade, String UF, String telefone, String CPF) {
        super(id, nome, logradouro, num, CEP, bairro, cidade, UF, telefone, CPF);
        this.cargoOuFuncao = cargoOuFuncao;
    }

    public String getCargoOuFuncao() {
        return cargoOuFuncao;
    }

    public void setCargoOuFuncao(String cargoOuFuncao) {
        this.cargoOuFuncao = cargoOuFuncao;
    }
}
