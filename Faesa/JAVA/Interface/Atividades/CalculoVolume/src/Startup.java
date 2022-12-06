/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateus.ferreira
 */
import Entities.Viga;
import javax.swing.JOptionPane;

public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            
            Viga viga = new Viga();
            viga.LerDados();
            viga.Calculo();
        
        }
        
        catch (Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        finally {
            
            JOptionPane.showMessageDialog(null, "Programa finalizado!");
            
        }
    }
    
}
