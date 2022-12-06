/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Subentities;
import Entities.Retangulo;

/**
 *
 * @author mateus.ferreira
 */
public class TrianguloRetangulo extends Retangulo{
    
    @Override
    public double CalculoArea(){
        return (getBase() * getAltura())/2; 
    }
   
}
