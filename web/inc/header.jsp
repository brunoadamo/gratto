<!-- Masthead -->
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <h1 class="mb-5">Encontre uma institui��o:</h1>
            </div>
            <div class="col-sm-12">
                
                <form action="searchresults.jsp" method="POST">
                    
                    <div class="col-sm-4">
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
                    <div class="col-sm-8">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-btn search-panel">


                                </div>
                                <input type="hidden" name="search_param" value="all" id="search_param">         
                                <input type="text" class="form-control" name="nome_fantasia" placeholder="Procure aqui uma instituil��o">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
                                </span>
                            </div>
                        </div>    
                    </div>
                    
                    <div class="col-sm-12">
                        <div class="form-group">
                            <a href="institutions.jsp" class="btn btn-success"> Veja todas as institui��es</a>
                        </div>    
                    </div>
                    
                    
                </form>    
            </div>
        </div>
    </div>
</header>