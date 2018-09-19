<%@page import="model.Instituicao"%>
<%@page import="model.InstituicaoDAO"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String aux = request.getParameter("idInstituicao");
    int idUsuario = 0;    
    int idInstituicao = 0;
    

    try {
        idInstituicao = Integer.parseInt(aux);
        
        if(session.getAttribute("usuarioID") != null){
            idUsuario = Integer.parseInt(session.getAttribute("usuarioID").toString());
        }       
        
    } catch (NumberFormatException e) {
        
        
    }

    InstituicaoDAO iDAO = new InstituicaoDAO();

    Instituicao instituicao = iDAO.localizar(idInstituicao);

%>

<!-- Profile -->

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" /> 
    <body>


        <jsp:include page="inc/topo.jsp" /> 

        <jsp:include page="inc/header.jsp" /> 

        <div class="container">


            <div class="clearfix"></div>


            <section class="col-sm-12">
                <br>
                <article class="search-result row item-institution">

                    <div class="col-xs-12 col-sm-12 col-md-5">
                        <img class="center-block img-responsive" src="img/inst/<%=instituicao.getImg()%>.jpg" alt="" />
                        <ul class="meta-search">
                            <li><i class="glyphicon glyphicon-home"></i> <span> <%=instituicao.getEnderecoInstituicao()%>, <%=instituicao.getNumero()%>, <%=instituicao.getBairro()%>. <%=instituicao.getCepInstituicao()%>. <%=instituicao.getCidadeInstituicao()%>-<%=instituicao.getEstadoInstituicao()%>.</span></li>
                            <li><i class="glyphicon glyphicon-phone"></i> <span> <%=instituicao.getTelefoneInstituicao()%></span></li>
                            <li><i class="glyphicon glyphicon-envelope"></i> <span> <%=instituicao.getSiteInstituicao()%></span></li>
                        </ul>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                        <h3><a href="#" title=""><%=instituicao.getNomeFantasia()%></a></h3>
                        <p><%=instituicao.getCidadeInstituicao()%> - <%=instituicao.getEstadoInstituicao()%></p><br>
                        <p><%=instituicao.getDescricao()%></p>
                        
                    </div>
                        
                    <div class="clearfix"></div>
            
                    <div class="col-sm-4 col-sm-offset-4">
                        <br>
                        <a class="btn btn-success center-block" data-toggle="modal" data-target="#modalDoar" style="color: #fff">DOAR</a>
                        <br>

                    </div>
                </article>

            </section>
                        
            <section class="text-center col-sm-12">
                <h2 class="mb-5">Eventos</h2>

                <table class="table table-bordered" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Evento</th>
                            <th>Data</th>
                            <th>Local</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        
                    <tr>
                        <td>Evento teste</td>
                        <td>21/12/2018 às 19:00</td>
                        <td>Salão teste</td>
                        <td><a class="btn btn-success btn-xs" href="donationsInstitutions.jsp?id=">Participar</a></td>
                    </tr>
                    </tbody>
                </table>
            </section>
                        
            <section class="text-center col-sm-12">
                <h2 class="mb-5">Trabalhos e contribuições da instituição:</h2>

                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="img\inst\1.jpg" alt="Los Angeles" class="img-responsive">
                        </div>

                        <div class="item">
                            <img src="img\inst\5.jpg" alt="Chicago" class="img-responsive">
                        </div>

                        <div class="item">
                            <img src="img\inst\2.jpg" alt="New york" class="img-responsive">
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Anterior</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Próximo</span>
                    </a>

                </div>
                <br>
            </section>

        </div>

        <!-- Call to Action -->
        <section class="call-to-action text-white text-center">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto">
                        <h2 class="mb-4">Pronto para começar? Registre-se agora!</h2>
                    </div>
                    <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                        <form>
                            <div class="form-row">
                                <div class="col-12 col-md-9 mb-2 mb-md-0">
                                    <input type="email" class="form-control form-control-lg" placeholder="Digite seu email...">
                                </div>
                                <div class="col-12 col-md-3">
                                    <a href="user.jsp" class="btn btn-block btn-lg btn-primary">Entrar!</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>        
        
        <!-- Modal Doar -->
        <div id="modalDoar" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <h1><%=instituicao.getNomeFantasia()%></h1>
                            <div class="form-group">
                                <form name="form1" action="DoacaoServlet" method="POST">
                                    Valor:
                                    <input type="number" name="valor_doacao" value="" size="25" class="form-control" /><br>
                                    
                                    <input type="hidden" name="id_instituicao" value="<%=instituicao.getIdInstituicao()%>"/>
                                    <input type="hidden" name="id_usuario" value="<%=idUsuario%>"/>
                                    
                                    <p>Agradecemos sua iniciativa!</p>
                                    
                                    <input type="submit" value="Doar" name="btLogar" class="btn btn-success"/>   
                                    
                                    
                                </form>
                            </div>
                        </div>  
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
        
        <jsp:include page="inc/footer.jsp" />               

        <!-- Bootstrap core JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </body>

</html>

