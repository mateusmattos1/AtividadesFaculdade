/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author mateus.ferreira
 */
public class Passeio extends Veiculo {

    public Passeio(int numeroPassageiro, int numeroPortas, String opcionais, String corExterna, String corInterna, String placa, String procedencia, String marca, String modelo, int anoModelo, int anoFabricacao, String chassi, String renavam, String combustivel, String motor, String quilometragem, int consumoMedio) {
        super(placa, procedencia, marca, modelo, anoModelo, anoFabricacao, chassi, renavam, combustivel, motor, quilometragem, consumoMedio);
        this.numeroPassageiro = numeroPassageiro;
        this.numeroPortas = numeroPortas;
        this.opcionais = opcionais;
        this.corExterna = corExterna;
        this.corInterna = corInterna;
    }

    public Passeio() {
    }
    
    private int numeroPassageiro;
    private int numeroPortas;
    private String opcionais;
    private String corExterna;
    private String corInterna;

    public int getNumeroPassageiro() {
        return numeroPassageiro;
    }

    public void setNumeroPassageiro(int numeroPassageiro) {
        this.numeroPassageiro = numeroPassageiro;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    public String getCorExterna() {
        return corExterna;
    }

    public void setCorExterna(String corExterna) {
        this.corExterna = corExterna;
    }

    public String getCorInterna() {
        return corInterna;
    }

    public void setCorInterna(String corInterna) {
        this.corInterna = corInterna;
    }
}
