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
public class Carga extends Veiculo {

    public Carga(int capacidadeMaxima, int altura, int largura, int profundidade, String placa, String procedencia, String marca, String modelo, int anoModelo, int anoFabricacao, String chassi, String renavam, String combustivel, String motor, String quilometragem, int consumoMedio) {
        super(placa, procedencia, marca, modelo, anoModelo, anoFabricacao, chassi, renavam, combustivel, motor, quilometragem, consumoMedio);
        this.capacidadeMaxima = capacidadeMaxima;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public Carga() {
    }
    
    private int capacidadeMaxima;
    private int altura;
    private int largura;
    private int profundidade;

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }
}
