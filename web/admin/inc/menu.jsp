<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-black fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.jsp">GRATTO - PANEL</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Instituições">
                <a class="nav-link" href="institutions.jsp">
                    <i class="fa fa-fw fa-dashboard"></i>
                    <span class="nav-link-text">Instituições</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Doações">
                <a class="nav-link" href="donations.jsp">
                    <i class="fa fa-fw fa-area-chart"></i>
                    <span class="nav-link-text">Minhas Doações</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Meus Eventos">
                <a class="nav-link" href="myEvents.jsp">
                    <i class="fa fa-fw fa-address-book"></i>
                    <span class="nav-link-text">Minha Agenda</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Doações">
                <a class="nav-link" href="events.jsp">
                    <i class="fa fa-fw fa-calendar"></i>
                    <span class="nav-link-text">Eventos</span>
                </a>
            </li>
            <%

            String cod_usuario = session.getAttribute("usuarioID").toString();


            if(cod_usuario.equals("1")){

            %>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Log">
                <a class="nav-link" href="log.jsp">
                    <i class="fa fa-fw fa-hourglass-half"></i>
                    <span class="nav-link-text">Logs</span>
                </a>
            </li>
            <% } %>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
                <a class="nav-link" href="../">
                    <span class="nav-link-text">Voltar para o site</span>
                </a>
            </li>

        </ul>
        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>


        <ul class="navbar-nav ml-auto">

            <li class="nav-item">
                <a class="nav-link" href="../Logout">
                    <i class="fa fa-fw fa-sign-out"></i>Logout</a>
            </li>
        </ul>

    </div>
</nav>