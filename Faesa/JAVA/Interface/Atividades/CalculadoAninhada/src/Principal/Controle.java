/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Entidades.Calculadora;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus.ferreira
 */
public class Controle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double n1 =  Double.parseDouble(JOptionPane.showInputDialog(null, "Cadastre o primeiro número: "));
        double n2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Cadastre o segundo número: "));
        char escolha = JOptionPane.showInputDialog(null, "Cadastre a operação (+, -, *, /): ").charAt(0);
        
        if (escolha == '+'){   
            JOptionPane.showMessageDialog(null, new Calculadora(n1, n2).new Soma().Soma());
        }
        else if (escolha == '-'){
            JOptionPane.showMessageDialog(null, new Calculadora(n1, n2).new Subtracao().Subtracao());
        }
        else if (escolha == '*'){
            JOptionPane.showMessageDialog(null, new Calculadora(n1, n2).new Multiplicacao().Multiplicacao());
        }
        else if (escolha == '/'){
            JOptionPane.showMessageDialog(null, new Calculadora(n1, n2).new Divisao().Divisao());
        }
    }
    
}
