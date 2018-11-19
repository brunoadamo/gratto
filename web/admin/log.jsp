<%@page import="model.Log"%>
<%@page import="model.LogDAO"%>
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
                    <li class="breadcrumb-item active">Logs</li>
                </ol>

                <%

                String cod_usuario = session.getAttribute("usuarioID").toString();

                LogDAO iDAO = new LogDAO();

                List<Log> listLog = iDAO.listaTodos();

                request.setAttribute("listLog",listLog);

                %>


                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Logs</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Usuário</th>
                                        <th>Horário</th>
                                        <th>Módulo</th>
                                        <th>Ações</th>
                                        <th>Parâmetros</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                                    <c:forEach items="${listLog}" var="i">

                                        <tr>
                                            <td>${i.getIdLog()}</td>
                                            <td>${i.getCodUsuario()}</td>
                                            <td>${i.getDataHora()}</td>
                                            <td>${i.getModulo()}</td>
                                            <td>${i.getAcao()}</td>
                                            <td>${i.getParametros()}</td>

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

        <% //FIM DA LISTAGEM DE LOGS %>

        <jsp:include page="inc/footer.jsp" />

    </body>

</html>

