<%@page import="model.Instituicao"%>
<%@page import="model.InstituicaoDAO"%>
<%@page import="model.Evento"%>
<%@page import="model.EventoDAO"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" />

    <body>

        <jsp:include page="inc/nav.jsp" />


        <%
            InstituicaoDAO iDAO = new InstituicaoDAO();

            List<Instituicao> listInstituicao = iDAO.listaTodos();

            request.setAttribute("listInstituicao", listInstituicao);

            int count = 0;
            int idUsuario = 0;

            try {

                if (session.getAttribute("usuarioID") != null) {
                    idUsuario = Integer.parseInt(session.getAttribute("usuarioID").toString());
                }

            } catch (NumberFormatException e) {

            }

        %>

        <section class="bg-light" id="portfolio">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase">Instituições</h2>
                        <h3 class="section-subheading text-muted">Conheça o trabalho das instituições que participam do nosso projeto!</h3>
                    </div>
                </div>
                <div class="row">

                    <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                    <c:forEach items="${listInstituicao}" var="i">

                        <div class="col-md-6 col-sm-6 portfolio-item">

                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModall${i.getIdInstituicao()}">
                                <div class="portfolio-hover">
                                    <div class="portfolio-hover-content">
                                        <i class="fas fa-plus fa-3x"></i>
                                    </div>
                                </div>
                                <img class="img-fluid" src="img/inst/${i.getImg()}.jpg" alt="">
                            </a>
                            <div class="portfolio-caption">
                                <h4 class="mb-3">${i.getNomeFantasia()}</h4>
                                <p>${i.getDescricao().substring(0, 250)}...</p>
                                <span class="plus "><a class="portfolio-link btn-warning btn mt-3" data-toggle="modal" href="#portfolioModall${i.getIdInstituicao()}">Saiba mais <i class="glyphicon glyphicon-plus"></i></a></span>
                            </div>
                        </div>


                    </c:forEach>

                    <% //FIM DA LISTAGEM DE INSTITUIÇÕES %>

                </div>
            </div>
        </section>






        <!-- Portfolio Modals -->

        <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
        <%
            count = 0;

        %>
        <c:forEach items="${listInstituicao}" var="instituicao">
            <% count++;%>
            <!-- Modal 1 -->
            <div class="portfolio-modal modal fade" id="portfolioModall${instituicao.getIdInstituicao()}" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="close-modal" data-dismiss="modal">
                            <div class="lr">
                                <div class="rl"></div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-8 mx-auto">
                                    <div class="modal-body">
                                        <!-- Project Details Go Here -->
                                        <h2 class="text-uppercase">${instituicao.getNomeFantasia()}</h2>
                                        <button class="btn btn-success" data-toggle="modal" data-target="#modalDoar${instituicao.getIdInstituicao()}" type="button">
                                            <i class="fas fa-times"></i>
                                            DOAR
                                        </button><br>
                                        <p class="item-intro text-muted">${instituicao.getCidadeInstituicao()} - ${instituicao.getEstadoInstituicao()}</p>
                                        <ul class="list-inline">

                                            <li><strong>Tel:</strong> ${instituicao.getTelefoneInstituicao()}</li>
                                            <li><strong>Site:</strong> ${instituicao.getSiteInstituicao()}</li>
                                            <li><strong>Endereço:</strong> ${instituicao.getEnderecoInstituicao()}, ${instituicao.getNumero()}, ${instituicao.getBairro()}. ${instituicao.getCepInstituicao()}. ${instituicao.getCidadeInstituicao()}-${instituicao.getEstadoInstituicao()}.</li>

                                        </ul>

                                        <img class="img-fluid d-block mx-auto" src="img/inst/${instituicao.getImg()}.jpg" alt="">
                                        <p style="text-align: justify;">${instituicao.getDescricao()}</p>

                                        <button class="btn btn-success" data-toggle="modal" data-target="#modalDoar${instituicao.getIdInstituicao()}" type="button">
                                            <i class="fas fa-times"></i>
                                            DOAR
                                        </button><br><br><br>

                                        <%
                                            EventoDAO eDAO = new EventoDAO();

                                            int idInst = listInstituicao.get(count - 1).getIdInstituicao();

                                            List<Evento> listEvento = eDAO.listaInst(idInst);
                                            request.setAttribute("listEvento", listEvento);
                                        %>

                                        <% if (listEvento.isEmpty()) { %>
                                        <h3 class="mb-5">Aguarde eventos futuros!</h3>
                                        <% } else { %>

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
                                                <% //INICIO DA LISTAGEM DE INSTITUIÇÕES %>
                                                <c:forEach items="${listEvento}" var="i">

                                                    <tr>
                                                        <td>${i.getNome()}</td>
                                                        <td>${i.getDataIni()}</td>
                                                        <td>${i.getDesc()}</td>
                                                        <td><a class="btn btn-success btn-xs" href="ParticipaEvento?id_evento=${i.getIdEvento()}&id_instituicao=<%= idInst%>&id_usuario=<%= idUsuario%>">Participar</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <% }%>
                                        <button class="btn btn-primary" data-dismiss="modal" type="button">
                                            <i class="fas fa-times"></i>
                                            Fechar instituição
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal Doar -->
            <div id="modalDoar${instituicao.getIdInstituicao()}" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">

                        <div class="modal-body">
                            <div class="col-md-12">
                                <h3>Agradecemos sua iniciativa!!</h3>
                                <div class="form-group">
                                    <form name="form1" action="DoacaoServlet" method="POST">
                                        Valor:
                                        <input type="number" name="valor_doacao" value="" size="25" class="form-control" /><br>

                                        <input type="hidden" name="id_instituicao" value="${instituicao.getIdInstituicao()}"/>
                                        <input type="hidden" name="id_usuario" value="<%= idUsuario%>"/>

                                        <input type="submit" value="Doar" name="btLogar" class="btn btn-success"/>


                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>

                </div>
            </div>
        </c:forEach>
        <jsp:include page="inc/footer.jsp" />

        <% //FIM DA LISTAGEM DE INSTITUIÇÕES %>
    </body>

</html>
