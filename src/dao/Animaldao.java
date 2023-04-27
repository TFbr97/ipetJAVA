/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import classe.Animal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class AnimalDao {
    
    private Connection con;
    private ResultSet rs;
    
    
    public AnimalDao(){//Conecção com o banco de dados
       
        this.con = new Conexao().getConnection();
        
    }
    
    public void insertAnimal(Animal animal){ // teste
        
        try{
            PreparedStatement stmt = con.prepareStatement
        ("insert into animal(nome,idade,sexo,raca,status,descricao,idfuncionario)values(?,?,?,?,?,?,?)");
            
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getIdade());
            stmt.setString(3, animal.getSexo());
            stmt.setString(4, animal.getRaca());
            stmt.setString(5, animal.getStatus());
            stmt.setString(6, animal.getDescricao());
            stmt.setInt(7,animal.getIdfuncionario());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Animal cadastrado no sistema");
            
        }
        
        catch(SQLException erro) {
            
            throw new RuntimeException(erro);
            
        }
        
    }
    
    public void inativoAnimal(Animal animal){
        
        try{
            PreparedStatement stmt = con.prepareStatement("update animal set status = ? where idanimal='"+animal.getIdanimal()+"'");
            
            stmt.setString(1, animal.getStatus());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Animal Adotado"); 
            //con.close();
            
        }
        catch(SQLException erro){
            
            throw new RuntimeException(erro); 
        } 
        
    }
    
    
    public void Buscaid(Animal animal){
        
        try{
            
            PreparedStatement stmt = con.prepareStatement
        ("select * from animal where status = 'P' and idanimal='"+animal.getIdanimal()+"'; ");
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
                animal.setIdanimal(rs.getInt("idanimal"));
                animal.setNome(rs.getString("nome"));
                animal.setIdade(rs.getString("idade"));
                animal.setSexo(rs.getString("sexo"));
                animal.setRaca(rs.getString("raca"));
                animal.setDescricao(rs.getString("descricao"));
                animal.setIdfuncionario(rs.getInt("idfuncionario"));
                
                
                
            }
            
            else{
                
                JOptionPane.showMessageDialog(null, "Animal nâo encontrado");
                
            }
            
        }
        catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
        
    }
    
    public void Buscanome(Animal animal){
        
        try{
            
            PreparedStatement stmt = con.prepareStatement
        ("select * from animal where status = 'P' and nome = '"+animal.getNome()+"';");
            
            rs = stmt.executeQuery(); 
            
            if(rs.next()){ 
                
                animal.setIdanimal(rs.getInt("idanimal")); 
                animal.setNome(rs.getString("nome"));
                animal.setIdade(rs.getString("idade"));
                animal.setSexo(rs.getString("sexo"));
                animal.setRaca(rs.getString("raca"));
                animal.setStatus(rs.getString("status"));
                animal.setDescricao(rs.getString("descricao"));
                animal.setIdfuncionario(rs.getInt("idfuncionario"));
                
            }
            
            else{
                
                JOptionPane.showMessageDialog(null, "Animal não encontrado");
                
            }
            
        }
        catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
        
    }
    
    public List<Animal> BuscaAnimais(){
        
        try{
            
            List<Animal> animais = new ArrayList<Animal>();
            PreparedStatement stmt = con.prepareStatement("select * from animal where status = 'P'");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                             
              Animal animal = new Animal();
                
              animal.setIdanimal(rs.getInt("idanimal"));
              animal.setNome(rs.getString("nome"));
              animal.setIdade(rs.getString("idade"));
              animal.setSexo(rs.getString("sexo"));
              animal.setRaca(rs.getString("raca"));
              animal.setDescricao(rs.getString("descricao"));
              animal.setIdfuncionario(rs.getInt("idfuncionario"));
              animais.add(animal);
                
            }
            
            return animais;
                        
        }
        
        catch(SQLException erro){
            
            throw new RuntimeException(erro);
        }
        
        
        
    }
    
    
}
