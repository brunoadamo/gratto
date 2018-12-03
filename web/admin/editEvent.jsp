<%@page import="model.Evento"%>
<%@page import="model.EventoDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="pt-br">
    <jsp:include page="inc/head.jsp" />
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

        <jsp:include page="inc/menu.jsp" />
        <div class="content-wrapper">
            <div class="container-fluid">

                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Eventos</a>
                    </li>
                    <li class="breadcrumb-item active">Editar</li>
                </ol>


                <%

                EventoDAO iDAO = new EventoDAO();

                int codigo = Integer.parseInt(request.getParameter("id"));

                Evento i = iDAO.localizar(codigo);

                %>

                <form action="../AttInstituicao" method="POST">


                    <input type="hidden" name="id" value="<%=i.getIdEvento()%>"/>


                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="razao">*Nome</label>
                            <input type="text" class="form-control" name="nome" id="razao" value="<%=i.getNome()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nomefan">*Endereço</label>
                            <input type="text" class="form-control" name="descricao" id="nomefan" value="<%=i.getDesc()%>">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cnpj">*Data</label>
                            <input type="text" class="form-control" name="data" id="cnpj" value="<%=i.getDataIni()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="mail">*Horário</label>
                            <input type="text" class="form-control" name="horario" id="mail" value="<%=i.getHoraIni()%>">
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="telefone">*Limite participante</label>
                            <input type="int" class="form-control" name="limit" id="telefone" value="<%=i.getLimit()%>">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <button type="submit" class="btn btn-success">Atualizar</button><br>
                        </div>
                    </div>

                </form>
            </div>

        </div>
        <br>

        <jsp:include page="inc/footer.jsp" />
    </body>
</html>