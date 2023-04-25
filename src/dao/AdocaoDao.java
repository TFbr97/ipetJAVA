/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Adocao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class AdocaoDao {
    
    private Connection con;
    private ResultSet rs;
    
    
    public AdocaoDao(){
        
        this.con = new Conexao().getConnection();
        
    }
    
    public void insertAdocao(Adocao adocao){
        
        try{
            
            PreparedStatement stmt = con.prepareStatement
        ("insert into adocao(idanimal,idcliente,idfuncionario,data)values(?,?,?,?)");
            
            stmt.setInt(1, adocao.getIdanimal());
            stmt.setInt(2, adocao.getIdcliente());
            stmt.setInt(3, adocao.getIdfuncionario());
            stmt.setString(4, adocao.getData());
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Adoção Realizada com Sucesso!"); 
            //con.close();
            
        }
        catch(SQLException erro){
            
            throw new RuntimeException(erro); 
        }
        
    }
    
    public List <Adocao> ListaAdocao(){
        
        try{
        
        List<Adocao> adocoes = new ArrayList<Adocao>();
        
        PreparedStatement stmt = con.prepareStatement("select * from adocao");
        
        rs = stmt.executeQuery();
        
        while(rs.next()) {
            Adocao adocao = new Adocao();
            
            adocao.setIdadocao(rs.getInt("idadocao"));
            adocao.setIdanimal(rs.getInt("idanimal"));
            adocao.setIdcliente(rs.getInt("idcliente"));
            adocao.setIdfuncionario(rs.getInt("idfuncionario"));
            adocao.setData(rs.getString("data"));
            adocoes.add(adocao);
        }
        
        return adocoes;
        
        }
        
        catch(SQLException erro){
            
            throw new RuntimeException(erro);
            
        }
        
        
    }
    
}
