<%@page import="model.Doacao"%>
<%@page import="model.DoacaoDAO"%>
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

                String cod_inst = request.getParameter("id");

                DoacaoDAO dDAO = new DoacaoDAO();

                InstituicaoDAO iDAO = new InstituicaoDAO();

                List<Doacao> listDoacao = dDAO.localizarInsDoacao(cod_inst);

                List<Instituicao> listDoacaoTotal = iDAO.relatorio(cod_inst);

                request.setAttribute("listDoacao",listDoacao);
                request.setAttribute("listDoacaoTotal",listDoacaoTotal);

                %>


                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Doa��es</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Data</th>
                                        <th>Valor</th>
                                        <th>Institui��o</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Data</th>
                                        <th>Valor</th>
                                        <th>Institui��o</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUI��ES %>
                                    <c:forEach items="${listDoacao}" var="i">
                                  
                                        <tr>
                                            <td>${i.getCodigo()}</td>
                                            <td>${i.getData()}</td>
                                            <td>R$ ${i.getValor()}</td>
                                            <td>${i.getCod_inst()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                                    
                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Total de Doa��es</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>M�s</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>M�s</th>
                                        <th>Total</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUI��ES %>
                                    <c:forEach items="${listDoacaoTotal}" var="i">
                                  
                                        <tr>
                                            <td>${i.getImg()}</td>
                                            <td>R$ ${i.getIdInstituicao()},00</td>
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

        <% //FIM DA LISTAGEM DE INSTITUI��ES %>

        <jsp:include page="inc/footer.jsp" /> 

</body>

</html>
