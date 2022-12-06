/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import javax.swing.JOptionPane;
import Modelo.*;
import java.util.ArrayList;
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
            
            JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de cadastro de clientes!");
          
            ArrayList<Cliente> clientes = CadastroCliente();       
            Leitura(clientes);
            
        }
        
        catch (Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        finally {
        
            JOptionPane.showMessageDialog(null, "Programa finalizado!");
        
        }
        
    } 
    
    private static ArrayList<Cliente> CadastroCliente(){
        
        boolean continuarCliente = true;
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        while (continuarCliente){
            
            Cliente cliente = new Cliente();
            cliente.setNome(JOptionPane.showInputDialog(null, "Digite o nome: "));
            cliente.setCPF(Long.parseLong(JOptionPane.showInputDialog(null, "Digite o CPF: ")));
            cliente.setEndereco(JOptionPane.showInputDialog(null, "Digite o endereco: "));
            cliente.setCelular(Long.parseLong(JOptionPane.showInputDialog(null, "Digite o celular: ")));
            cliente.setEmail(JOptionPane.showInputDialog(null, "Digite o Email: "));
            
            ArrayList<Veiculo> veics = CadastroVeiculo();
            
            cliente.setVeic(veics);
            clientes.add(cliente);
            continuarCliente = Validacao("clientes");         
        }
        
        return clientes;
    }
    
    private static ArrayList<Veiculo> CadastroVeiculo(){
        
        boolean continuarVeiculo = true;
        ArrayList<Veiculo> veics = new ArrayList<>();
        
        JOptionPane.showMessageDialog(null, "Agora vamos cadastrar os veículos desse cliente!");
        
        while (continuarVeiculo){
            Veiculo veic = new Veiculo();
                
            veic.setPlaca(JOptionPane.showInputDialog(null, "Digite a placa: "));
            veic.setModelo(JOptionPane.showInputDialog(null, "Digite o modelo: "));
            veic.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano: ")));
            veic.setFabricante(JOptionPane.showInputDialog(null, "Digite o fabricante: "));
            veic.cor = JOptionPane.showInputDialog(null, "Digite a cor: ");

            continuarVeiculo = Validacao("veículos");
                
            veics.add(veic);
        }
        
        return veics;
        
    }
    
    private static void Leitura(ArrayList<Cliente> clientes){
        JOptionPane.showMessageDialog(null, "Agora iremos mostrar os dados de cada cliente!"); 
        for(Cliente cliente : clientes){
            JOptionPane.showMessageDialog(null, "Cliente: " + cliente.getNome() + "\nCPF: " + cliente.getCPF() + "\n" +
                        "Celular: " + cliente.getCelular() + "\nEmail: " + cliente.getEmail() + "\nEndereço: " + cliente.getEndereco());
            
            int numeroVeic = 1;
            for(Veiculo veic : cliente.getVeic()){
                JOptionPane.showMessageDialog(null, "Veículo número " + numeroVeic + ":\n\nPlaca do veículo: " + veic.getPlaca() +
                        "\nModelo: " + veic.getModelo() + "\nAno: " + veic.getAno() + "\nFabricante: " + veic.getFabricante() + "\nCor: " + veic.cor);
                numeroVeic++;
            }
        }
    }
    
    private static boolean Validacao(String tipo){
        
        String escolha = JOptionPane.showInputDialog(null, "Cadastro finalizado! Digite CONTINUAR ou PARAR para cadastro de novos " + tipo + ": ");
                
        while (!escolha.equals("CONTINUAR") && !escolha.equals("PARAR")){
            escolha = JOptionPane.showInputDialog(null, "Opção inválida. Digite CONTINUAR ou PARAR para cadastro de novos " + tipo + ": ");
        }
                
        if (escolha.equals("PARAR")){
            return false;
        }
        
        return true;
    }
    
}
