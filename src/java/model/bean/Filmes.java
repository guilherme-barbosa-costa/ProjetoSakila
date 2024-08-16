/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Senai
 */
public class Filmes {
   private int filme_id;
   private String title;
   private String descricao;
   private int anofilme;

    public Filmes() {
    }

    public Filmes(int filme_id, String title, String descricao, int anofilme) {
        this.filme_id = filme_id;
        this.title = title;
        this.descricao = descricao;
        this.anofilme = anofilme;
    }

    public int getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(int filme_id) {
        this.filme_id = filme_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnofilme() {
        return anofilme;
    }

    public void setAnofilme(int anofilme) {
        this.anofilme = anofilme;
    }

}
