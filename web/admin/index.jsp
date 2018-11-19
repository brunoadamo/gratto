<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" /> 

    <body class="fixed-nav sticky-footer bg-dark" id="page-top">

        <jsp:include page="inc/menu.jsp" /> 

        <div class="content-wrapper">
            <div class="container-fluid">
                <!-- Breadcrumbs-->
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active">Rela��o geral</li>
                </ol>
                <!-- Area Chart Example-->
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fa fa-area-chart"></i> Gr�fico de doa��es</div>
                    <div class="card-body">
                        <canvas id="myAreaChart" width="100%" height="30"></canvas>
                    </div>
                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                </div>
                <div class="row">
                    <div class="col-lg-8">
                        <!-- Example Bar Chart Card-->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-bar-chart"></i> Minhas doa��es</div>
                            <div class="card-body">
                                <canvas id="myBarChart" width="100" height="50"></canvas>
                            </div>
                            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <!-- Example Pie Chart Card-->
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-pie-chart"></i> Doa��es gerais</div>
                            <div class="card-body">
                                <canvas id="myPieChart" width="100%" height="100"></canvas>
                            </div>
                            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="inc/footer.jsp" /> 
    </body>

</html>
