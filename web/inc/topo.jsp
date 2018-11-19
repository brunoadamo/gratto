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

