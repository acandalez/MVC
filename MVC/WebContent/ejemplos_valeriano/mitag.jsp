<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="mitag" uri="../WEB-INF/etiqueta.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ETIQUETA SIMPLE! <br>
<mitag:holaMundo nombre="Raul"/>
<!-- mitag:nveces el atributo num equivale al numero de veces que queremos que se repita aparte 
de lo que estamos mostrando del invoke de la clase EtiquetaSimpleBucle -->
<mitag:nveces  num="3">Es esto!</mitag:nveces>
<mitag:atrDinamico  num="5">${count}</mitag:atrDinamico>
<!-- el cuerpo no es un valor constante es una variable que tiene que evauluar, RECUERDA QUE CON EL $ USAMOS UNA EXPRESION LENGUAGE "EL"
EL CUAL NECESITA SE EVALUADO POR EL SERVIDOR. -->
<br>ETIQUETA CLASSIC! <br>
<!-- aqui estamos usando  -->
<mitag:classic  num="5" idcountry="${count}">${count}</mitag:classic>
<!--  -->
</body>
</html>