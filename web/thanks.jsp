<!DOCTYPE html>
<html lang="en">

    <jsp:include page="inc/head.jsp" />

    <body>

        <%
            String msg = "";
            try {
                msg = request.getParameter("msg");
            } catch (Exception e) {

            }

            if (msg == null) {
                msg = "Obrigado por ajudar!";
            }


        %>

        <jsp:include page="inc/nav.jsp" />
        <section id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading text-uppercase"><%=msg%></h2>
                    </div>
                </div>


            </div>
        </section>



        <jsp:include page="inc/footer.jsp" />

    </body>

</html>
