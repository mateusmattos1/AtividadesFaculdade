/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import javax.swing.JOptionPane;
/**
 *
 * @author mateus.ferreira
 */
public class Viga {

    public Viga() {
    }

    public Viga(double altura, double base, double comprimento) {
        this.altura = altura;
        this.base = base;
        this.comprimento = comprimento;
    }
    
    private double altura;
    private double base;
    private double comprimento;

    public double getAltura() {
        return altura;
    }

    public double getBase() {
        return base;
    }

    public double getComprimento() {
        return comprimento;
    }
    
    public void LerDados(){
        this.altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Altura: "));
        this.base = Double.parseDouble(JOptionPane.showInputDialog(null, "Base: "));
        this.comprimento = Double.parseDouble(JOptionPane.showInputDialog(null, "Base: "));
    }
    
    public void Calculo(){
        JOptionPane.showMessageDialog(null, "Altura total: " + getAltura() * getBase() * getComprimento());
    }
}
