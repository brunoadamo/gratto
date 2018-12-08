<%@page import="model.Instituicao"%>
<%@page import="model.InstituicaoDAO"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
    <jsp:include page="inc/head.jsp" />
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

        <jsp:include page="inc/menu.jsp" />

        <%

        String cod_usuario = session.getAttribute("usuarioID").toString();

        InstituicaoDAO iDAO = new InstituicaoDAO();

        List<Instituicao> listInstituicao = iDAO.listaCod(cod_usuario);

        request.setAttribute("listInstituicao",listInstituicao);

        %>


        <div class="content-wrapper">
            <div class="container-fluid">

                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Eventos</a>
                    </li>
                    <li class="breadcrumb-item active">Adicionar</li>
                </ol>

                <h2>Cadastro de Eventos</h2>
                <hr>

                <form action="../AddInstituicao" method="POST">

                    <input type="hiddden" class="form-control" name="id" id="id" value="<%=cod_usuario%>">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="razao">*Nome</label>
                            <input type="text" class="form-control" name="nome" id="razao">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nomefan">*Endereço</label>
                            <input type="text" class="form-control" name="descricao" id="nomefan">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cnpj">*Data</label>
                            <input type="text" class="form-control" name="data" id="cnpj">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="mail">*Horário</label>
                            <input type="text" class="form-control" name="horario" id="mail">
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="telefone">*Limite participante</label>
                            <input type="int" class="form-control" name="limit" id="telefone">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="telefone">*Instituição</label>
                            <select class="form-control" name="id_inst">
                                <c:forEach items="${listInstituicao}" var="i">
                                    <option value="${i.getIdInstituicao()}">${i.getNomeFantasia()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <button type="submit" class="btn btn-success">Cadastrar</button><br>
                        </div>
                    </div>

                </form>
            </div>

        </div>
        <br>

        <jsp:include page="inc/footer.jsp" />
    </body>
</html>