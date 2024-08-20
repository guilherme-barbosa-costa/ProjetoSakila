/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Filmes;
import model.dao.FilmesDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "SakilaController", urlPatterns = {"/SakilaController", "/sakila","/cadastrar", "/editar"})
public class SakilaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String paginaAtual = request.getServletPath();
            FilmesDAO fdao = new FilmesDAO();
                List<Filmes> filmes = fdao.ler();
            if(paginaAtual.equals("/sakila")){
     
                filmes = fdao.ler();
                request.setAttribute("filmes", filmes);
                request.getRequestDispatcher("/WEB-INF/jsp/sakila.jsp").forward(request, response);
    }else if(paginaAtual.equals("/cadastrar")){
                request.getRequestDispatcher("/WEB-INF/jsp/cadastrar.jsp").forward(request, response);
            }
    else if(paginaAtual.equals("/editar")){
        int id = Integer.parseInt(request.getParameter("filme"));
        Filmes filmeAtual = fdao.selecionarFilme(id);
        request.setAttribute("titulo", filmeAtual.getTitle());
        request.setAttribute("descricao", filmeAtual.getDescricao());
        request.setAttribute("ano", filmeAtual.getAnofilme());
        
        
        request.getRequestDispatcher("/WEB-INF/jsp/editar.jsp").forward(request, response);
    }
    } 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaAtual = request.getServletPath();
        
        if(paginaAtual.equals("/cadastrar")) {
            Filmes novoFilme = new Filmes();
            
            novoFilme.setTitle(request.getParameter("titulo"));
            novoFilme.setDescricao(request.getParameter("desc"));
            novoFilme.setAnofilme(Integer.parseInt(request.getParameter("ano")));
            
            FilmesDAO filmes = new FilmesDAO();
            filmes.cadastrar(novoFilme);
            
            response.sendRedirect("sakila");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
