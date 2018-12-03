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

                List<Evento> listEvento = iDAO.listaParticipacao(cod_usuario);

                request.setAttribute("listEvento",listEvento);

                %>


                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Meus eventos</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Data e Hor�rio</th>
                                        <th>A��es</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUI��ES %>
                                    <c:forEach items="${listEvento}" var="i">

                                        <tr>
                                            <td>${i.getNome()}</td>
                                            <td>${i.getDesc()}</td>
                                            <td>${i.getDataIni()} �s ${i.getHoraIni()}h</td>
                                            <td class="actions">
                                                <!-- <a class="btn btn-success btn-xs" href="view.html">Visualizar</a> !-->
                                                <a class="btn btn-danger btn-xs"  href="../myEvents?id=${i.getIdEvento()}">Cancelar Participacao</a>
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

        <% //FIM DA LISTAGEM DE INSTITUI��ES %>

        <jsp:include page="inc/footer.jsp" />

    </body>

</html>
