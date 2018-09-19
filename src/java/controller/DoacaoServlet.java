/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.Clock;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DoacaoDAO;
import model.Doacao;

/**
 *
 * @author Bruno
 */
public class DoacaoServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            
            
            
            double valor = Double.parseDouble(request.getParameter("valor_doacao"));
            int id_instituicao = Integer.parseInt(request.getParameter("id_instituicao"));
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
            Date d = new Date();
            String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            
            System.out.println(request.getParameter("id_instituicao") + " AQUIIIIIIIIII");
            System.out.println(id_instituicao);
            System.out.println(id_usuario);
            System.out.println(valor);
            System.out.println(data);
            		
            Doacao doacao = new Doacao();            
                       
            DoacaoDAO doacaoDAO = new DoacaoDAO();
            if(!doacaoDAO.bd.getConnection()) {
                System.out.println("Falha na conexão com o Banco de Dados.");
                System.exit(0);
            }
            
            doacao.setCod_usuario(id_usuario);
            doacao.setValor(valor);
            doacao.setCod_inst(id_usuario);
            doacao.setData(data);
                        
            if(doacaoDAO.gravar(doacao)) {                
                response.sendRedirect("institution.jsp?idInstituicao=" + id_instituicao);
            } else{
                response.sendRedirect("institution.jsp?idInstituicao=" + id_instituicao);
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
