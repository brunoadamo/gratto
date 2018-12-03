<%@page import="model.Usuario"%>
<%@page import="model.UsuarioDAO"%>
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
                    <li class="breadcrumb-item active">Instituições</li>
                </ol>

                <%

                String cod_usuario = session.getAttribute("usuarioID").toString();

                UsuarioDAO iDAO = new UsuarioDAO();

                List<Usuario> listUsuario = iDAO.listaEvento(request.getParameter("id"));

                request.setAttribute("listUsuario",listUsuario);

                %>


                <!-- Example DataTables Card-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-table"></i> Participações evento!</div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>E-mail</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                                    <c:forEach items="${listUsuario}" var="i">

                                        <tr>
                                            <td>${i.getNomeUsuario()}</td>
                                            <td>${i.getEmailUsuario()}</td>


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
