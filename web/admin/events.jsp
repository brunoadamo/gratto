<%@page import="model.Evento"%>
<%@page import="model.EventoDAO"%>
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
                    <li class="breadcrumb-item active">Eventos</li>
                </ol>

                <%

                String cod_usuario = session.getAttribute("usuarioID").toString();

                EventoDAO iDAO = new EventoDAO();

                List<Evento> listEvento = iDAO.listaCod(cod_usuario);

                request.setAttribute("listEvento",listEvento);

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
                                        <th>Nome</th>
                                        <th>Data e Horário</th>
                                        <th>ID Instituição</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                                    <c:forEach items="${listEvento}" var="i">

                                        <tr>
                                            <td>${i.getIdEvento()}</td>
                                            <td>${i.getNome()}</td>
                                            <td>${i.getDataIni()} às ${i.getHoraIni()}h</td>
                                            <td>${i.getCod_inst()}</td>
                                            <td class="actions">
                                                <!-- <a class="btn btn-success btn-xs" href="view.html">Visualizar</a> !-->
                                                <a class="btn btn-success btn-xs" href="participacao.jsp?id=${i.getIdEvento()}">Participantes</a>
                                                <a class="btn btn-warning btn-xs" href="editEvent.jsp?id=${i.getIdEvento()}">Editar</a>
                                                <a class="btn btn-danger btn-xs"  href="../DeleteEvent?id=${i.getIdEvento()}">Cancelar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <a class="btn btn-primary btn-xs" href="addtEvent.jsp?usuario="<%=cod_usuario%>> Novo</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- /.container-fluid-->

        <% //FIM DA LISTAGEM DE INSTITUIÇÕES %>

        <jsp:include page="inc/footer.jsp" />

    </body>

</html>
