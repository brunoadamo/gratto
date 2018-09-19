/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author Bruno
 */
public class AddUser extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nome = request.getParameter("nome");;
            String sexo = request.getParameter("sexo");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String tel = request.getParameter("tel");
            String mail = request.getParameter("mail"); 
            String senha = request.getParameter("senha"); 
              
            		
            Usuario usuario = new Usuario();            
                       
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if(!usuarioDAO.bd.getConnection()) {
                System.out.println("Falha na conexão com o Banco de Dados.");
                System.exit(0);
            }
            
            usuario.setNomeUsuario(nome);
            usuario.setSexo(sexo);
            usuario.setCidadeUsuario(cidade);
            usuario.setEstadoUsuario(estado);
            usuario.setTelefoneUsuario(tel);
            usuario.setEmailUsuario(mail);
            usuario.setSenha(senha);
                           
            if(usuarioDAO.gravar(usuario)) {                
                response.sendRedirect("user.jsp");
            } else{
                response.sendRedirect("user.jsp");
            }
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
