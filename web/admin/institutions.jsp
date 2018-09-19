<%@page import="model.Instituicao"%>
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

        InstituicaoDAO iDAO = new InstituicaoDAO();

        List<Instituicao> listInstituicao = iDAO.listaCod(cod_usuario);

        request.setAttribute("listInstituicao",listInstituicao);

        %>


                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Instituições</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Telefone</th>
                                        <th>Site</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Telefone</th>
                                        <th>Site</th>
                                        <th>Ações</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                                    <c:forEach items="${listInstituicao}" var="i">
                                        
                                        <tr>
                                            <td>${i.getIdInstituicao()}</td>
                                            <td>${i.getNomeFantasia()}</td>
                                            <td>${i.getTelefoneInstituicao()}</td>
                                            <td>${i.getSiteInstituicao()}</td>
                                            <td class="actions">
                                                <!-- <a class="btn btn-success btn-xs" href="view.html">Visualizar</a> !-->
                                                <a class="btn btn-success btn-xs" href="donationsInstitutions.jsp?id=${i.getIdInstituicao()}">Doações</a>
                                                <a class="btn btn-warning btn-xs" href="editInstitution.jsp?id=${i.getIdInstituicao()}">Editar</a>
                                                <a class="btn btn-danger btn-xs"  href="../DeleteInstituicao?id=${i.getIdInstituicao()}">Excluir</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <a class="btn btn-primary btn-xs" href="addtInstitution.jsp?usuario="<%=cod_usuario %> >Nova</a>
                        <a class="btn btn-info btn-xs" href="allInstitutions.jsp">Veja a listagem completa</a>
                    </div>
                </div>
            </div>
         </div>    
                                    
        <!-- /.container-fluid-->

        <% //FIM DA LISTAGEM DE INSTITUIÇÕES %>

        <jsp:include page="inc/footer.jsp" /> 

</body>

</html>
