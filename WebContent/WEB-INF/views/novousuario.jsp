<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
	<title>Vote no Restaurante - Novo Usuário</title>

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
        <link rel="stylesheet" href="${resources}/assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="${resources}/assets/css/style.css" />
</head>
<body>

     <div class="col-lg-5">
         <div class="feedback-form">

             <div id="contact-response"></div>
 
             <form action="criarusuario" method="post" id="contact-form">
                 <fieldset>
                     <div class="form-group form-group-fullname">
                         <label class="control-label" for="nome">Nome: </label>
                         <input type="text" class="form-control" name="nome" id="nome" placeholder="Informe seu nome">
                     </div>
                     <div class="form-group form-group-email">
                         <label class="control-label" for="email">E-mail: </label>
                         <input type="text" class="form-control" name="email" id="email" placeholder="Informe seu e-mail">
                     </div>          
                     <button type="submit" class="btn btn-primary">Salvar</button>
                 </fieldset>
             </form>
         </div> 
     </div>
                



<!-- 	<form action="criarusuario" method="post"> -->
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<td><label for="nome">Nome: </label></td> -->
<!-- 				<td><input name="nome" id="nome" /></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><label for="nome">E-mail: </label></td> -->
<!-- 				<td><input name="email" id="email" /></td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
<!-- 		<input type="submit" value="Salvar" /> -->
<!-- 	</form> -->


    <script type="text/javascript" src="${resources}/js/jquery-1.10.2.min.js" ></script>
    <script src="${resources}/assets/bootstrap/js/bootstrap.min.js" ></script>
</body>
</html>