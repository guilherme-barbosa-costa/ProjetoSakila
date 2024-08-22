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
    
    public Filmes selecionarFilme(int id){
        Filmes filmeSelecionado = new Filmes();
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT * FROM film WHERE film_id = ?");
            stmt.setInt(1, id);
            
            
            rs = stmt.executeQuery();
            if(rs.next()){
                filmeSelecionado.setTitle(rs.getString("title"));
                filmeSelecionado.setDescricao(rs.getString("description"));
                filmeSelecionado.setAnofilme(rs.getInt("release_year"));
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
            
        }catch(SQLException e){
           e.printStackTrace();
           }     
        return filmeSelecionado;
    }
    
    public void excluirFilme(int id){
            
try{
   Connection conexao = Conexao.conectar();
   PreparedStatement stmt = null;
   
   stmt = conexao.prepareStatement(
   "DELETE FROM film WHERE film_id = ?"
   );
   
   
   stmt.setInt(1, id);
   
   

   stmt.executeUpdate();
   stmt.close();
   conexao.close();

}catch(SQLException e){
e.printStackTrace();
}
    }
    
    public void editarFilme(Filmes filme, int id){
            
try{
   Connection conexao = Conexao.conectar();
   PreparedStatement stmt = null;
   
   
   stmt = conexao.prepareStatement(
           "UPDATE film SET title = ?, description = ?, release_year = ?  WHERE film_id = ?"
   );
  
   
   
   stmt.setString(1, filme.getTitle());
   stmt.setString(2,filme.getDescricao());
   stmt.setInt(3, filme.getAnofilme());
   stmt.setInt(4, id);
   
   

   stmt.executeUpdate();
   stmt.close();
   conexao.close();

}catch(SQLException e){
e.printStackTrace();
}
    }
}
