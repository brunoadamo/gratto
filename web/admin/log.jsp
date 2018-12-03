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
                String acao     = "";
                String param    = "";
                String data     = "";


                try{
                    acao = request.getParameter("acao");
                    param = request.getParameter("param");
                    data = request.getParameter("data");
                }catch (Exception e){

                }

                System.out.println(acao);
                System.out.println(acao);
                System.out.println(acao);

                if(acao != null || param != null || data != null){
                    listLog = iDAO.localizar(acao,param,data);
                }

                request.setAttribute("listLog",listLog);

                %>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-search"></i> Pesquisa
                        <br>
                    </div>
                    <div class="card-body">
                        <form action="log.jsp" method="POST">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <select name="acao" class="form-control">
                                            <option value="" selected disabled>Ação</option>
                                            <option value="insert">Insert</option>
                                            <option value="update">Update</option>
                                            <option value="delete">Delete</option>

                                        </select>

                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="hidden" name="param" value="" id="search_param">
                                        <input type="text" class="form-control" name="nome_fantasia" placeholder="Busca...">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <input type="hidden" name="data" value="" id="search_param">
                                        <input type="text" class="form-control" name="nome_fantasia" placeholder="Data">
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-lg-12 text-center">
                                    <div id="success"></div>
                                    <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">Pesquisar</button>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
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
                                        <th>ID Usuário</th>
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

