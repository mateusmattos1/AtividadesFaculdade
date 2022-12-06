/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;
import Interface.ContratoNota;
import javax.swing.JOptionPane;
/**
 *
 * @author mateus.ferreira
 */
public class Aluno implements ContratoNota {

    public Aluno(){
    }
    
    public Aluno(double nota) {
        this.nota = nota;
    }

    private double nota;

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    @Override
    public void CadastrarNota(){
        setNota(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota do aluno: ")));
    }
    
    @Override
    public void VerificarAprovacao() {
        if (getNota() < 11 && getNota() > 6){
            JOptionPane.showMessageDialog(null, "Parabéns, você atingiu todos os indicadores de avaliação com excelência");
        }
        else if (getNota() == 6){
            JOptionPane.showMessageDialog(null, "Parabéns, você obteve aproveitamento satisfatório nos indicadores de avaliação");
        }
        else if (getNota() >= 0){
            JOptionPane.showMessageDialog(null, "Você não atingiu o mínimo esperado para aprovação");
        }
        else {
            JOptionPane.showMessageDialog(null, "Nota inválida");
        }
    }
    
}
