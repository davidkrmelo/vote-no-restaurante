<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<spring:url value="resources" var="resources" />

        <!-- meta data & title -->
        <meta charset="utf-8">
        <title>Vote no restaurante</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css' />
        <link href="http://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="${resources}/assets/bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" href="${resources}/assets/css/style.css" />
    </head>
  <body>
	
    <!-- Begin #services-section -->
    <section id="services" class="services-section section-global-wrapper">
        <div class="container">

			<a href="votar?id=${restaurante1.id}">
	            <!-- Restaurante 1 -->
	            <div class="row services-row services-row-head services-row-1">
	                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
	                    <div class="services-group wow animated">
	                        <img src="${resources}/assets/img/logo-outback.jpg" height="100" alt="">
	                        <h4 class="services-title">Outback</h4>
	                        <p class="services-body">O Outback Steakhouse é um restaurante informal, construído e decorado em estilo que remete ao interior da Austrália. São mais de 800 restaurantes nos Estados Unidos, onde foi inaugurado em 1988, e cerca de 120 unidades em outros 22 países.</p>
	                        <p class="services-more"><a href="https://www.outback.com.br/" target="_blank">Site oficial</a></p>
	                    </div>
	                </div>
                </a>

                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">VS</div>

				<a href="votar?id=${restaurante1.id}">
	                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
	                    <div class="services-group wow animated">
	                        <img src="${resources}/assets/img/logo-da-Temakeria-e-Cia.jpg" height="100" alt="">
	                        <h4 class="services-title">Temakeria e Cia.</h4>
	                        <p class="services-body">A primeira Temakeria e Cia foi inaugurada em 2006. Hoje conta com mais de 20 franquias em diversas cidades brasileiras. Conquistou uma clientela fiel ao propor temakis fartamente recheados a preços moderados.</p>
	                        <p class="services-more"><a href="http://www.temakeria-ecia.com/" target="_blank">Site oficial</a></p>
	                    </div>
	                </div>
        		</a>
            </div>
            <!-- End Serivces Row 2 -->
    
        </div>      
    </section>
    <!-- End #services-section -->

    <script type="text/javascript" src="${resources}/js/jquery-1.10.2.min.js" ></script>
    <script src="${resources}/assets/bootstrap/js/bootstrap.min.js" ></script>
  </body>
</html>