/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Filmes;

/**
 *
 * @author Senai
 */
public class FilmesDAO {
    public List<Filmes> ler() {
        List<Filmes> filmes = new ArrayList<>();
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM film");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Filmes filme = new Filmes();
                filme.setFilme_id(rs.getInt("film_id"));
                filme.setTitle(rs.getString("title"));
                filme.setDescricao(rs.getString("description"));
                filme.setAnofilme(rs.getInt("release_year"));
                
                filmes.add(filme);
                System.out.println("filmes: " + filme.getTitle());
            }
            
            rs.close();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return filmes;
    } 
    
    public void cadastrar(Filmes filme){
try{
   Connection conexao = Conexao.conectar();
   PreparedStatement stmt = null;
   
   stmt = conexao.prepareStatement(
   "INSERT INTO film (title, description, release_year) VALUES (?, ?, ?)"
   );
   
   
   stmt.setString(1, filme.getTitle());
   stmt.setString(2, filme.getDescricao());
   stmt.setInt(3, filme.getAnofilme());
   
   

   stmt.executeUpdate();
   stmt.close();
   conexao.close();

}catch(SQLException e){
e.printStackTrace();
}
    }
}
