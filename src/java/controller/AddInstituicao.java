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
import model.Instituicao;
import model.InstituicaoDAO;

/**
 *
 * @author Bruno
 */
public class AddInstituicao extends HttpServlet {

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
            
            String razao = request.getParameter("razao");;
            String nomeFantasia = request.getParameter("nomeFantasia");
            String cnpj = request.getParameter("cnpj");
            String mail = request.getParameter("mail");
            String tel= request.getParameter("tel");
            String website = request.getParameter("website");
            String facebook = request.getParameter("facebook");
            String cep = request.getParameter("cep");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String pais = request.getParameter("pais");
            String descricao = request.getParameter("descricao");
            
            int id_responsavel = Integer.parseInt(request.getParameter("id"));    
             
            		
            Instituicao i = new Instituicao();            
                       
            InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
            if(!instituicaoDAO.bd.getConnection()) {
                System.out.println("Falha na conexão com o Banco de Dados.");
                System.exit(0);
            }
            
            i.setRazaoSocial(razao);
            i.setDescricao(descricao);
            i.setNomeFantasia(nomeFantasia);
            i.setCnpj(cnpj);
            i.setEnderecoInstituicao(rua);
            i.setNumero(numero);
            i.setBairro(bairro);
            i.setCidadeInstituicao(cidade);
            i.setEstadoInstituicao(estado);
            i.setPaisInstituicao(pais);
            i.setCepInstituicao(cep);
            i.setTelefoneInstituicao(tel);
            i.setEmailInstituicao(mail);
            i.setSiteInstituicao(website);
            i.setFacebookInstituicao(facebook);
                        
            if(instituicaoDAO.gravar(i)) {                
                response.sendRedirect("admin/addtInstitution.jsp");
            } else{
                response.sendRedirect("admin/addtInstitution.jsp");   
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
