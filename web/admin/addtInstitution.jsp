<%@page import="model.Instituicao"%>
<%@page import="model.InstituicaoDAO"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="pt-br">
    <jsp:include page="inc/head.jsp" />
    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

        <jsp:include page="inc/menu.jsp" /> 
        
        <%
            
        String cod_usuario = session.getAttribute("usuarioID").toString();

        %>
        
        
        <div class="content-wrapper">
            <div class="container-fluid">
                
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="#">Instituições</a>
                    </li>
                    <li class="breadcrumb-item active">Adicionar</li>
                </ol>
                
                <h2>Cadastro de Instituição</h2>
                <hr>

                <form action="../AddInstituicao" method="POST">
                    
                    <input type="hiddden" class="form-control" name="id" id="id" value="<%=cod_usuario%>">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="razao">*Razão Social:</label>
                            <input type="text" class="form-control" name="razao" id="razao">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nomefan">*Nome Fantasia:</label>
                            <input type="text" class="form-control" name="nomeFantasia" id="nomefan">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cnpj">*CNPJ:</label>
                            <input type="text" class="form-control" name="cnpj" id="cnpj">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="mail">*E-mail:</label>
                            <input type="text" class="form-control" name="mail" id="mail">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="telefone">*Telefone:</label>
                            <input type="text" class="form-control" name="tel" id="telefone">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="website">Website:</label>
                            <input type="text" class="form-control" name="website" id="website">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="facebook">Facebook:</label>
                            <input type="text" class="form-control" name="facebook" id="facebook">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cep">*CEP:</label>
                            <input type="text" class="form-control" name="cep" id="cep">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="rua">*Rua:</label>
                            <input type="text" class="form-control" name="rua" id="rua">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="num">*Número:</label>
                            <input type="text" class="form-control" name="numero" id="num">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="bairro">*Bairro:</label>
                            <input type="text" class="form-control" name="bairro" id="bairro">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cidade">*Cidade:</label>
                            <input type="text" class="form-control" name="cidade" id="cidade">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="estado">*Estado:</label>
                            <input type="text" class="form-control" name="estado" id="estado">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="pais">*País:</label>
                            <input type="text" class="form-control" name="pais" id="pais">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="pais">*Descrição</label>
                            <textarea rows="10" type="text" class="form-control" name="descricao" id="descricao"></textarea>
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