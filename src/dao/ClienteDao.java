/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Cliente;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lopes
 */
public class ClienteDao {
    
    private Connection con;
    private ResultSet rs;
   
    
    public ClienteDao(){
        this.con = new Conexao().getConnection();
        
    }
    
    public void insertCliente(Cliente cliente) throws SQLException{
        
        try{
            PreparedStatement stmt = con.prepareStatement
        ("insert into cliente(nome,cpf,endereco,telefone)values(?,?,?,?)");
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado No Sistema");
            
        }  catch(SQLException erro) {
            
            throw new RuntimeException(erro);
            
        }
    
    }
    public void buscaCliente(Cliente cliente){ // Referente ai idcliente
      try{
              PreparedStatement stmt = con.prepareStatement
        ("select * from cliente where idcliente = '"+cliente.getIdCliente()+"'");
             rs = stmt.executeQuery();
             
             if(rs.next()){
                 cliente.setIdCliente(rs.getInt("idcliente"));
                 cliente.setNome(rs.getString("nome"));
                 cliente.setCpf(rs.getString("cpf"));
                 cliente.setTelefone(rs.getString("telefone"));
                 cliente.setEndereco(rs.getString("endereco"));
                 
             }else{
                 JOptionPane.showMessageDialog(null,"Cliente Não Existe!");
             }
              
              
              
          }
          catch(SQLException erro){
              throw new RuntimeException(erro);
          }   
    }
    
    public void buscaClienteNome(Cliente cliente){ // Referente ai nome do cliente
      try{
              PreparedStatement stmt = con.prepareStatement
        ("select * from cliente where nome = '"+cliente.getNome()+"'");
             rs = stmt.executeQuery();
             
             if(rs.next()){
                 cliente.setIdCliente(rs.getInt("idcliente"));
                 cliente.setNome(rs.getString("nome"));
                 cliente.setCpf(rs.getString("cpf"));
                 cliente.setTelefone(rs.getString("telefone"));
                 cliente.setEndereco(rs.getString("endereco"));
                 
             }else{
                 JOptionPane.showMessageDialog(null,"Cliente Não Existe!");
             }
              
              
              
          }
          catch(SQLException erro){
              throw new RuntimeException(erro);
          }   
    }
    
    public List<Cliente> BuscaClientes(){
        
        try{
            
            List<Cliente> clientes = new ArrayList<Cliente>();
            PreparedStatement stmt = con.prepareStatement("select * from cliente");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
              
             Cliente cliente = new Cliente();
                
             cliente.setIdCliente(rs.getInt("idcliente"));
             cliente.setNome(rs.getString("nome"));
             cliente.setCpf(rs.getString("cpf"));
             cliente.setTelefone(rs.getString("telefone"));
             cliente.setEndereco(rs.getString("endereco"));
             
             clientes.add(cliente);
                
            }
            
            return clientes;
                        
        }
        
        catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
        
        
        
    }


}

      
      
    

