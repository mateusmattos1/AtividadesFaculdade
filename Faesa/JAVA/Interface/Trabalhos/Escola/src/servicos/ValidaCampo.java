/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import javax.swing.JOptionPane;

/**
 *
 * @author mateus.ferreira && carlos.eugenio
 */

// Classe utilizada para validacao dos campos
public class ValidaCampo {
    // Metodo para verificar se o campo esta vazio
    static public String VerificarCampo(String resposta, String campo, char pronome){
        while (resposta.trim().equals("")){
            resposta = JOptionPane.showInputDialog(null, "Campo inválido. Digite novamente " + pronome + " " + campo + ":");
        }
        return resposta;
    }
    
    // Aplicacao de sobrecarga, verifica se é um inteiro e se é a quantidade de faltas possivel
    static public int VerificarCampo(String resposta, String campo, char pronome, boolean inteiro){
        if (resposta.trim().isEmpty()){
            resposta = "-1";
        }
        while (!isInteger(resposta) || Integer.parseInt(resposta) < 0 || Integer.parseInt(resposta) > 100){
            resposta = JOptionPane.showInputDialog(null, "Campo imcompatível. Digite novamente " + pronome + " " + campo + ":");
            if (resposta.trim().isEmpty()){
                resposta = "-1";
            }
        }
        return Integer.parseInt(resposta);
    }
    
    // Aplicacao de sobrecarga, verifica se o valor passado é um double
    static public double VerificarCampo(String resposta, String campo, boolean isdouble, char pronome){
        if (resposta.trim().isEmpty()){
            resposta = "f";
        }
        while (!isDouble(resposta)){
            resposta = JOptionPane.showInputDialog(null, "Campo imcompatível. Digite novamente " + pronome + " " + campo + ": ");
            if (resposta.trim().isEmpty()){
                resposta = "f";
            }
        }
        return Double.parseDouble(resposta);
    }
    
    // Metodo utilizado para ver se uma string é inteira
    public static boolean isInteger(String str){
        return str.matches("[0-9]*");
    }
    
    // Metodo utilizado para ver se uma string é double
    public static boolean isDouble(String str){
	try{
            Double.parseDouble(str);
	}catch(Exception e){
            return false;
	}
	return true;
}
}
