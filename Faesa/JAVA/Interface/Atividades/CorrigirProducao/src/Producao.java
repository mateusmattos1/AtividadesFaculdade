/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateus.ferreira
 */
public class Producao {
    
    // O erro é que os statics não estavam declarados
    static int previsaoDemanda = 200;
    static int producaoNormal = 250;
    static int estoqueInicial = 50;
    static int estoqueFinal;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        estoqueFinal = (estoqueInicial + producaoNormal)-previsaoDemanda;
        System.out.print("O estoque final previsto para o mês é de: " + estoqueFinal + " Unidades. ");
    }
    
}
