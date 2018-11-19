<%-- 
    Document   : nav
    Created on : 27/10/2018, 11:44:38
    Author     : bruno
--%>
<%
    String uri = request.getRequestURI();
   
    String pageName = uri.substring(uri.lastIndexOf("/")+1);
    String navClass = "";
   
    if(!pageName.equals("") && !pageName.equals("index.jsp")) navClass = "nav_content";

%>
 <!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top <%= navClass%>" id="mainNav">
  <div class="container">
    <a class="navbar-brand js-scroll-trigger" href="/gratto">Gratto</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      Menu
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav text-uppercase ml-auto">
         
        <li class="nav-item">
            <a class="nav-link" href="#portfolio" >Instituições</a>
        </li>
         <li class="nav-item">
            <a class="nav-link" href="#about" >Sobre</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#contact" >Contato</a>
        </li>
        <li class="nav-item">    
            
          <% 
                
                String usuarioNome = "";
                try {
                    usuarioNome = session.getAttribute("usuarioNome").toString();
                } catch (Exception e) {
                }             
                
                if(usuarioNome.isEmpty() || usuarioNome.equals("false")){            
            
            %>
                <a class="nav-link" href="#" data-toggle="modal" data-target="#myModal">Login</a>
            <% }else{%>

            
            <a class="btn user-name pull-right" href="admin"><%= usuarioNome%></a>
            </li>
            <li class="nav-item">
            <a class="btn btn-danger nav-link btn-sm" href="Logout">Logout</a>
            <% } %>
        </li>
      </ul>
    </div>
  </div>
</nav>
 
 <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">

            <div class="modal-body">
                <div class="col-md-12">
                    <h1>Login</h1>
                    <hr>
                    <div class="form-group">
                        <form name="form1" action="Login" method="POST">
                            E-mail:
                            <input type="text" name="email_user" value="" size="25" class="form-control" /><br><br>
                            Senha:
                            <input type="password" name="pass_user" value="" size="25" class="form-control" /><br><br>
                            <input type="submit" value="Entrar" name="btLogar" class="btn btn-primary"/> 
                            <a href="user.jsp" class="btn btn-primary pull-right" name="btLogar" style="color: #fff"> Cadastre-se </a> 
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