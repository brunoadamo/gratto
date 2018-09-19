<!DOCTYPE html>


<html lang="en">
    <jsp:include page="inc/head.jsp" /> 
    <body>
        <jsp:include page="inc/topo.jsp" /> 
        <jsp:include page="inc/header.jsp" /> 
        <div class="container-fluid">
            <div class="row row-offcanvas row-offcanvas-left">
                <div class="row-offcanvas row-offcanvas-right">
                    <div class="col-xs-6 col-sm-2 sidebar-offcanvas" id="sidebarLeft" role="navigation">

                    </div>
                </div>
                <!--/.well -->
            </div>
            <!--/span-->

            <div class="container">

                <div class="col-sm-12">

                    <h3>Cadastro</h3><hr>
                     
                    <form name="form1" action="AddUser" method="POST">

                        <div class="form-group col-sm-6">
                            <label for="nome">Nome Completo:</label>
                            <input type="text" class="form-control" name="nome" id="nome">
                        </div>
                        <div class="form-group col-sm-6">
                            <label for="sexo">Genêro</label>
                            <select type="text" class="form-control" name="sexo">
                                <option value="M">Masculino</option>
                                <option value="F">Feminino</option>
                            </select>
                        </div>

                        <div class="clearfix"></div>

                        <h3>Endereço</h3><hr> 

                        <div class="form-group col-sm-6">
                            <label for="cidade">Cidade:</label>
                            <input type="text" class="form-control" name="cidade" id="cidade">
                        </div>
                        <div class="form-group col-sm-6">
                            <label for="estado">Estado:</label>
                            <input type="text" class="form-control" name="estado" id="estado">
                        </div>

                        <div class="clearfix"></div>

                        <h3>Contato</h3><hr> 

                        <div class="form-group col-sm-6">
                            <label for="telefone">Telefone::</label>
                            <input type="text" class="form-control" name="tel" id="telefone">
                        </div>

                        <div class="clearfix"></div>

                        <h3>Conta</h3><hr> 

                        <div class="form-group col-sm-6">
                            <label for="mail">Email:</label>
                            <input type="text" class="form-control" id="mail" name="mail">
                        </div>
                        <div class="form-group col-sm-6">
                            <label for="mail">Senha</label>
                            <input type="password" class="form-control" id="senha" name="senha">
                        </div>
                        <div class="form-group col-sm-12">
                            <div class="row">                                
                                <input type="submit" value="Cadastrar" class="btn btn-success"/>
                            </div>    
                        </div>
                        
                        
                    </form>           
                </div>


            </div> 

            <jsp:include page="inc/footer.jsp" /> 

    </body>
</html>
