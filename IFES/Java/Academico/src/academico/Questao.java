/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academico;

import java.util.ArrayList;

/**
 *
 * @author 20181tiimi0197
 */
public class Questao {
    private String enunciado;
    private ArrayList<String> alternativas;
    private int gabarito;

    public Questao(String enunciado, ArrayList<String> alternativas, int gabarito) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.gabarito = gabarito;
    }
    
    public boolean correta(int resposta){
        if (resposta == this.getGabarito()){
            return true;
        }
        return false;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }

    public int getGabarito() {
        return gabarito;
    }

    public void setGabarito(int gabarito) {
        this.gabarito = gabarito;
    }
    
}
