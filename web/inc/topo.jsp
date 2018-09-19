<!-- Navigation -->
<nav class="navbar navbar-fixed-top navbar-default">
    <div class="container">
        <div class="col-sm-12">
            <a class="navbar-brand" href="index.jsp">Gratto</a>
            
            <% 
                
                String usuarioNome = "";
                try {
                    usuarioNome = session.getAttribute("usuarioNome").toString();
                } catch (Exception e) {
                }             
                
                if(usuarioNome.isEmpty()){            
            
            %>
                <a class="btn btn-primary pull-right btn-login" href="#" data-toggle="modal" data-target="#myModal">Login</a>   
            <% }else{%>

            
            <a class="btn user-name pull-right" href="admin"><%= usuarioNome%></a>
            <a class="btn btn-danger btn-login" href="Logout">Logout</a>
            <% } %>
        </div>
        
    </div>
</nav>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <h1>Login</h1>
                    <div class="form-group">
                        <form name="form1" action="Login" method="POST">
                            E-mail:
                            <input type="text" name="email_user" value="" size="25" class="form-control" /><br><br>
                            Senha:
                            <input type="password" name="pass_user" value="" size="25" class="form-control" /><br><br>
                            <input type="submit" value="Logar" name="btLogar" class="btn btn-primary"/> 
                            <a href="user.jsp" class="btn btn-primary pull-right" name="btLogar" style="color: #fff"> Cadastre-se </a> 
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