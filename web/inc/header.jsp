<!-- Masthead -->

<!-- Header -->

<header class="masthead search-header" >
  <div class="container">
      
    <div class="intro-text">
      <div class="intro-lead-in">Bem-vindo ao Gratto!</div>
      <h4 class="font-weight-light">Busque uma institui��o e comece a ajudar!</h4><br>
      <form action="searchresults.jsp" method="POST">
        <div class="row">
          <div class="col-md-4">
              <div class="form-group">
                <select name="estado" class="form-control">
                    <option value="" selected disabled>Estado</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amap�</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Cear�</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Esp�rito Santo</option>
                    <option value="GO">Goi�s</option>
                    <option value="MA">Maranh�o</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Par�</option>
                    <option value="PB">Para�ba</option>
                    <option value="PR">Paran�</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piau�</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rond�nia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">S�o Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select>

            </div>
            
          </div>
          <div class="col-md-8">
              <div class="form-group">
                <input type="hidden" name="search_param" value="all" id="search_param">         
                <input type="text" class="form-control" name="nome_fantasia" placeholder="Procure aqui uma institui��o">
              </div>  
          </div>
          <div class="clearfix"></div>
          <div class="col-lg-12 text-center">
            <div id="success"></div>
            <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">Pesquisar</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</header>