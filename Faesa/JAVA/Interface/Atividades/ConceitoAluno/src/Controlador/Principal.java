/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Entidade.Aluno;
import javax.swing.JOptionPane;
/**
 *
 * @author mateus.ferreira
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Aluno aluno = new Aluno();
            aluno.CadastrarNota();
            aluno.VerificarAprovacao();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            JOptionPane.showMessageDialog(null, "Programa finalizado");
        }
    }
    
}
