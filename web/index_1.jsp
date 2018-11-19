<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" /> 

    <body>

        <jsp:include page="inc/nav.jsp" /> 

        <jsp:include page="inc/header.jsp" /> 
        
        <!-- Testimonials -->
        <section class="testimonials text-center bg-light">
            <div class="full-container">
                <h2 class="mb-5">Conheça algumas intituições:</h2>

                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                        <li data-target="#myCarousel" data-slide-to="3"></li>
                        <li data-target="#myCarousel" data-slide-to="4"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        
                        <div class="item">
                            <img src="img\banner\5.jpg" alt="BANNER" class="img-responsive">
                        </div>
                        <div class="item active">
                            <img src="img\banner\1.jpg" alt="BANNER" class="img-responsive">
                        </div>

                        <div class="item">
                            <img src="img\banner\2.jpg" alt="BANNER" class="img-responsive">
                        </div>

                        <div class="item">
                            <img src="img\banner\3.jpg" alt="BANNER" class="img-responsive">
                        </div>
                        
                        <div class="item">
                            <img src="img\banner\4.jpg" alt="BANNER" class="img-responsive">
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>

            </div>
        </section>

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

        <jsp:include page="inc/footer.jsp" /> 


    </body>

</html>
