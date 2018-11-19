<%@page import="model.Instituicao"%>
<%@page import="model.InstituicaoDAO"%>
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
                        <a href="#">Instituições</a>
                    </li>
                    <li class="breadcrumb-item active">Editar</li>
                </ol>


                <%
    
                InstituicaoDAO iDAO = new InstituicaoDAO();
            
                int codigo = Integer.parseInt(request.getParameter("id"));

                Instituicao i = iDAO.localizar(codigo);
            
                %>

                <form action="../AttInstituicao" method="POST">

                    
                    <input type="hidden" name="id" value="<%=i.getIdInstituicao()%>"/>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="razao">*Razão Social:</label>
                            <input type="text" class="form-control" name="razao" id="razao" value="<%=i.getRazaoSocial()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="nomefan">*Nome Fantasia:</label>
                            <input type="text" class="form-control" name="nomeFantasia" id="nomefan" value="<%=i.getNomeFantasia()%>">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cnpj">*CNPJ:</label>
                            <input type="text" class="form-control" name="cnpj" id="cnpj" value="<%=i.getCnpj()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="mail">*E-mail:</label>
                            <input type="text" class="form-control" name="mail" id="mail" value="<%=i.getEmailInstituicao()%>">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="telefone">*Telefone:</label>
                            <input type="text" class="form-control" name="tel" id="telefone" value="<%=i.getTelefoneInstituicao()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="website">Website:</label>
                            <input type="text" class="form-control" name="website" id="website" value="<%=i.getSiteInstituicao()%>">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="facebook">Facebook:</label>
                            <input type="text" class="form-control" name="facebook" id="facebook" value="<%=i.getFacebookInstituicao()%>">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cep">*CEP:</label>
                            <input type="text" class="form-control" name="cep" id="cep" value="<%=i.getCepInstituicao()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="rua">*Rua:</label>
                            <input type="text" class="form-control" name="rua" id="rua" value="<%=i.getEnderecoInstituicao()%>">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="num">*Número:</label>
                            <input type="text" class="form-control" name="numero" id="num" value="<%=i.getNumero()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="bairro">*Bairro:</label>
                            <input type="text" class="form-control" name="bairro" id="bairro" value="<%=i.getBairro()%>">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="cidade">*Cidade:</label>
                            <input type="text" class="form-control" name="cidade" id="cidade" value="<%=i.getCidadeInstituicao()%>">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="estado">*Estado:</label>
                            <input type="text" class="form-control" name="estado" id="estado" value="<%=i.getEstadoInstituicao()%>">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="pais">*País:</label>
                            <input type="text" class="form-control" name="pais" id="pais" value="<%=i.getPaisInstituicao()%>">
                        </div>
                    </div>
                        
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="pais">*Descrição</label>
                            <textarea rows="10" type="text" class="form-control" name="descricao" id="descricao"><%=i.getDescricao()%></textarea>
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