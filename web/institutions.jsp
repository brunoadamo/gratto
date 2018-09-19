<%@page import="model.Instituicao"%>
<%@page import="model.InstituicaoDAO"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" /> 

    <body>

        <section>
            <div id="login" class="modal fade" role="dialog">
                <div class="modal-dialog">   

                    <div  class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Login</h4>
                        </div> 
                        <div class="modal-body">
                            <form name="form1" action="LoginServlet" method="POST">
                                <div class="form-group">
                                    <label> Usuário </label>
                                    <input type="text" name="usuario" value="" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label> Senha </label>             
                                    <input type="password" name="senha" value="" class="form-control" />

                                </div>

                                <div class="modal-footer">
                                    <input type="submit" value="Logar" name="btLogar" class="btn btn-primary"/>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                </div>
                            </form>         
                        </div> 
                    </div>      

                    </section>

                    <jsp:include page="inc/topo.jsp" /> 
                    
                    <jsp:include page="inc/header.jsp" /> 

                    

                    <div class="container">

                        <hgroup class="mb20">
                            <br>
                        </hgroup>
                        
                        <%
    
                        InstituicaoDAO iDAO = new InstituicaoDAO();

                        List<Instituicao> listInstituicao = iDAO.listaTodos();
                        
                        request.setAttribute("listInstituicao",listInstituicao);
                        
                        %>


                        <section class="col-sm-12">
                            
                            <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                            <c:forEach items="${listInstituicao}" var="i">
                                <article class="search-result row item-institution">
                                    <div class="col-sm-12 col-md-3">
                                        <a href="institution.jsp?idInstituicao=${i.getIdInstituicao()}" class="thumbnail img-responsive"><img src="img/inst/${i.getImg()}.jpg" alt="Lorem ipsum" /></a>
                                    </div>
                                    <div class="col-sm-12 col-md-4">
                                        <ul class="meta-search">
                                            <li><i class="glyphicon glyphicon-home"></i> <span> ${i.getCidadeInstituicao()}/${i.getEstadoInstituicao()}</span></li>
                                            <li><i class="glyphicon glyphicon-phone"></i> <span>${i.getTelefoneInstituicao()}</span></li>
                                            <li><i class="glyphicon glyphicon-tags"></i> <span> ${i.getSiteInstituicao()}</span></li>
                                        </ul>
                                    </div>
                                    <div class="col-xs-12 col-sm-12 col-md-5 excerpet">
                                        <h3><a href="institution.jsp?idInstituicao=${i.getIdInstituicao()}" title="">${i.getNomeFantasia()}</a></h3>
                                        <p>${i.getDescricao().substring(0, 250)}...</p>            
                                        <span class="plus"><a href="institution.jsp?idInstituicao=${i.getIdInstituicao()}" title="Saiba mais">Saiba mais <i class="glyphicon glyphicon-plus"></i></a></span>
                                    </div>
                                    <span class="clearfix borda"></span>
                                </article>
                            </c:forEach>
                            
                            <% //FIM DA LISTAGEM DE INSTITUIÇÕES %>

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
                                                <button type="submit" class="btn btn-block btn-lg btn-primary">Doar!</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </section>

                    <jsp:include page="inc/footer.jsp" /> 

                    </body>

                    </html>
