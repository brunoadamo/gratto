<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" />

    <body>

        <jsp:include page="inc/nav.jsp" />

        <section class="bg-light" id="portfolio">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Usuário</h2>
                        <h3 class="section-subheading text-muted">Cadastro</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <form name="form1" action="AddUser" method="POST">
                            <div class="row">
                                <div class="col-md-6">

                                    <div class="form-group">
                                        <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome Completo:">
                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <select type="text" class="form-control" name="sexo">
                                            <option value="" selected disabled>Selecione o genêro</option>
                                            <option value="M">Masculino</option>
                                            <option value="F">Feminino</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="clearfix"></div>
                                <div class="col-md-12">
                                    <h3>Endereço</h3><hr>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-md-6">

                                    <div class="form-group">
                                        <input type="text" class="form-control" name="cidade" id="cidade" placeholder="Cidade:">
                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="estado" id="estado" placeholder="Estado">
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-md-12">
                                    <h3>Contato</h3><hr>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-md-6">

                                    <div class="form-group">
                                        <input type="text" class="form-control" id="mail" name="mail" placeholder="E-mail:">
                                    </div>

                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="tel" id="telefone" placeholder="Telefone:">
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-md-12">
                                    <h3>Conta</h3><hr>
                                </div>

                                <div class="clearfix"></div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha:">
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-md-12 mx-auto">
                                    <div class="form-group">
                                        <input type="submit" value="Cadastrar" class="btn btn-success"/>

                                    </div>
                                </div>
                            </div>




                        </form>

                    </div>
                </div>
            </div>
        </section>



        <jsp:include page="inc/footer.jsp" />

        <% //FIM DA LISTAGEM DE INSTITUIÇÕES %>
    </body>

</html>
