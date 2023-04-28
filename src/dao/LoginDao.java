/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import classe.Funcionario;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 62127512022.2
 */
public class LoginDao {
    
      private Connection con;
      
    private ResultSet rs;
    
    
    public LoginDao(){
        
        this.con = new Conexao().getConnection();
        
    }
    
    public void buscarLogin(Funcionario funcionario){
        
        try{
            
            PreparedStatement stmt = con.prepareStatement
        ("select nome, usuario, senha from funcionario where usuario='"+funcionario.getUsuario()+"'"+"and senha ='"+funcionario.getSenha()+"'");
            rs = stmt.executeQuery();
            if(rs.next()){
            
            funcionario.setNome(rs.getString("nome"));
            funcionario.setUsuario(rs.getString("usuario"));
            funcionario.setSenha(rs.getString("senha"));
            
            }
           // stmt.execute();
            else{
            JOptionPane.showMessageDialog(null,"ERRO!"); 
            //con.close();
            }
        }
        catch(SQLException erro){
            
            throw new RuntimeException(erro); 
        }
        
    }
}
