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
import model.ParticipacaoDAO;
import model.Participacao;

/**
*
* @author Bruno
*/
public class ParticipaEvento extends HttpServlet {

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
int id_evento = 0;
int id_instituicao = 0;
int id_usuario = 0;

id_evento = Integer.parseInt(request.getParameter("id_evento"));
id_instituicao = Integer.parseInt(request.getParameter("id_instituicao"));

try {

id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
} catch (NumberFormatException e) {

}
Date d = new Date();
String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
Participacao participa = new Participacao();
ParticipacaoDAO participacaoDAO = new ParticipacaoDAO();
if (!participacaoDAO.bd.getConnection()) {
System.out.println("Falha na conexão com o Banco de Dados.");
System.exit(0);
}

participa.setCod_usuario(id_usuario);
participa.setDataInsc(data);
participa.setCod_evento(id_instituicao);
participa.setCod_instituicao(id_evento);

if (participacaoDAO.gravar(participa)) {
response.sendRedirect("thanks.jsp");
} else {
response.sendRedirect("thanks.jsp");
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
