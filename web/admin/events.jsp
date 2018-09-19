<%@page import="model.Doacao"%>
<%@page import="model.DoacaoDAO"%>
<%@page import="model.InstituicaoDAO"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" /> 

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

        <jsp:include page="inc/menu.jsp" /> 
        
        <div class="content-wrapper">
            <div class="container-fluid">
                
            <!-- Breadcrumbs-->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="#">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Charts</li>
            </ol>

        <%
            
        String cod_usuario = session.getAttribute("usuarioID").toString();
        
        DoacaoDAO dDAO = new DoacaoDAO();
        
        InstituicaoDAO iDAO = new InstituicaoDAO();

        List<Doacao> listDoacao = dDAO.localizar(cod_usuario);

        request.setAttribute("listDoacao",listDoacao);

        %>


                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Eventos</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Data</th>
                                        <th>Nome</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                                    <c:forEach items="${listDoacao}" var="i">
                                  
                                        <tr>
                                            <td>${i.getCodigo()}</td>
                                            <td>${i.getData()}</td>
                                            <td>${i.getValor()}</td>
                                            <td class="actions">
                                                <!-- <a class="btn btn-success btn-xs" href="view.html">Visualizar</a> !-->
                                                <a class="btn btn-success btn-xs" href="donationsInstitutions.jsp?id=">Participantes</a>
                                                <a class="btn btn-warning btn-xs" href="editInstitution.jsp?id=">Editar</a>
                                                <a class="btn btn-danger btn-xs"  href="../DeleteInstituicao?id=">Excluir</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
         </div>    
                                    
        <!-- /.container-fluid-->

        <% //FIM DA LISTAGEM DE INSTITUIÇÕES %>

        <jsp:include page="inc/footer.jsp" /> 

</body>

</html>
