/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Funcionario;
import java.sql.Connection;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 62127512022.2
 */
public class FuncionarioDao {
    private Connection con;
    private ResultSet rs;
    
    
    
    
    public FuncionarioDao(){
        this.con =  (Connection) new Conexao().getConnection();
    }
    
    public void insetFuncionario(Funcionario funcionario) throws SQLException{
        
        try{
            PreparedStatement stmt = con.prepareStatement("insert into funcionario(nome,cargo,cpf,endereco,usuario,senha,status)values(?,?,?,?,?,?,?)");
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getUsuario());
            stmt.setString(6, funcionario.getSenha());
            stmt.setString(7,funcionario.getStatus());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Funcionario Cadastrado No Sistema");
        }catch(SQLException erro) {
            
            throw new RuntimeException(erro);
            
        }
        
        
    }
    
    public void inativar(Funcionario funcionario){
        
        try{
            PreparedStatement stmt = con.prepareStatement("update funcionario set status = ? where idfuncionario='"+funcionario.getIdfuncionario()+"'");
            
            stmt.setString(1, funcionario.getStatus());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Funcionario Desativado"); 
            //con.close();
            
        }
        catch(SQLException erro){
            
            throw new RuntimeException(erro); 
        } 
        
    }
    
    public void buscarFuncionario(Funcionario funcionario){ //Referente ao idfuncionario
            
            try{
                PreparedStatement stmt = con.prepareStatement
                ("select * from funcionario where nome = '"+funcionario.getNome()+"' and status ='A'");
                 rs = stmt.executeQuery();
                 
                 if(rs.next()){
                     funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
                     funcionario.setNome(rs.getString("nome"));
                     funcionario.setCargo(rs.getString("cargo"));
                     funcionario.setCpf(rs.getString("cpf"));
                     funcionario.setEndereco(rs.getString("endereco"));
                     funcionario.setUsuario(rs.getString("usuario"));
                     funcionario.setSenha(rs.getString("senha"));
                 }else{
                      JOptionPane.showMessageDialog(null,"Funcionario Não Existe!");
                 }
            } catch(SQLException erro){
              throw new RuntimeException(erro);
          } 
        }
    
    
    public List<Funcionario> BuscaFuncionarios(){
        
        try{
            
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = con.prepareStatement("select * from funcionario where status = 'A'");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               
              Funcionario funcionario = new Funcionario();
              
              funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
              funcionario.setNome(rs.getString("nome"));
              funcionario.setCargo(rs.getString("cargo"));
              funcionario.setCpf(rs.getString("cpf"));
              funcionario.setEndereco(rs.getString("endereco"));
              funcionario.setUsuario(rs.getString("usuario"));
              funcionario.setSenha(rs.getString("senha"));
              funcionarios.add(funcionario);
                
            }
            
            return funcionarios;
                        
        }
        
        catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
        
        
        
    }
    
    
        public List<Funcionario> BuscaVet(Funcionario f){
        
        try{
            
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = con.prepareStatement("select * from funcionario where status = 'A' and cargo = 'Veterinário'");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
               
              Funcionario funcionario = new Funcionario();
              
              funcionario.setIdfuncionario(rs.getInt("idfuncionario"));
              funcionario.setNome(rs.getString("nome"));
              funcionario.setCargo(rs.getString("cargo"));
              funcionario.setCpf(rs.getString("cpf"));
              funcionario.setEndereco(rs.getString("endereco"));
              funcionario.setUsuario(rs.getString("usuario"));
              funcionario.setSenha(rs.getString("senha"));
              funcionarios.add(funcionario);
                
            }
            
            return funcionarios;
                        
        }
        
        catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
        
        
        
    }
    
}
