<%@page import="model.Instituicao"%>
<%@page import="model.InstituicaoDAO"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" /> 

    <body>

      
    <jsp:include page="inc/nav.jsp" /> 



    <div class="container">

        <hgroup class="mb20">
            <h1>Resultados de busca</h1>
            <h2 class="lead">Resultados encontrados para busca!</h2>               
        </hgroup>

        <%

        String estado = request.getParameter("estado");
        String nomeFantasia = request.getParameter("nome_fantasia");

        InstituicaoDAO iDAO = new InstituicaoDAO();

        List<Instituicao> listInstituicao = iDAO.localizar(nomeFantasia,estado);

        request.setAttribute("listInstituicao",listInstituicao);

        %>


        <section class="col-sm-12">

            <% if(listInstituicao != null){%>


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

                <% }else{ %>
                <p>Nenhum resultado encontrado!</p>
                <% } %>

        </section>
    </div>




        

<jsp:include page="inc/footer.jsp" /> 

</body>

</html>
