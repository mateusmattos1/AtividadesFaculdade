/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author mateus.ferreira
 */
public class Calculadora {

    public static double getN1() {
        return n1;
    }

    public static void setN1(double n1) {
        Calculadora.n1 = n1;
    }

    public static double getN2() {
        return n2;
    }

    public static void setN2(double n2) {
        Calculadora.n2 = n2;
    }
    
    public Calculadora() {
    }
    
    public Calculadora(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
    
    private static double n1;
    private static double n2;
    
    public class Soma {
        public double Soma(){
            return n1 + n2;
        }
    }
    public class Subtracao {
        public double Subtracao(){
            return n1 - n2;
        }
    }
    public class Multiplicacao {
        public double Multiplicacao(){
            return n1 * n2;
        }
    }
    public class Divisao {
        public double Divisao(){
            return n1 / n2;
        }
    }
}
