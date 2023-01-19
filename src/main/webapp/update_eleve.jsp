<%-- 
    Document   : add_update_filiere.jsp
    Created on : Jan 15, 2023, 12:54:09 PM
    Author     : Ayoub DKhissi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="styles/add_update_eleve.css" rel="stylesheet" id="bootstrap-css">

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="scripts/filieres.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>

        <title>Update Eleve</title>
    </head>


    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/DKHISSI_AYOUB_JEE">JEE</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="/DKHISSI_AYOUB_JEE">Home</a></li>
                    <li><a href="eleves">Eleves</a></li>
                    <li><a href="filieres">Filieres</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">

            <h1 class="title">Update Eleve</h1>

            <div class="row">
                <div class="col-md-6 mx-auto form-container">
                    <s:form action="update_eleve">
                        <div class="form-group">
                            <label for="cne">CNE</label>
                            <input readonly="readonly" type="text" class="form-control" id="cne" placeholder="CNE" name="eleve.cne" value="<s:property value='eleve.cne'/>"/>
                        </div>

                        <div class="form-group">
                            <label for="nom">Nom</label>
                            <input type="text" class="form-control" id="nom" placeholder="Nom" name="eleve.nom" value="<s:property value='eleve.nom'/>">
                        </div>

                        <div class="form-group">
                            <label for="prenom">Prenom</label>
                            <input type="text" class="form-control" id="prenom" placeholder="Prenom" name="eleve.prenom" value="<s:property value='eleve.prenom'/>">
                        </div>

                        <div class="form-group">
                            <label for="filiere">Filiere</label>
                            <select class="form-control" id="filiere" placeholder="Filiere" name="eleve.ref_fil.code_fil">
                                <option value="" >Non Determiné</option>
                                <s:iterator value="filieres">
                                    <c:if test="${code_fil.equalsIgnoreCase(eleve.ref_fil.code_fil)}">
                                        <option selected value="<s:property value="code_fil"/>"><s:property value="code_fil"/></option>
                                    </c:if>
                                    <c:if test="${!code_fil.equalsIgnoreCase(eleve.ref_fil.nom_fil)}">
                                        <option value="<s:property value="code_fil"/>"><s:property value="code_fil"/></option>
                                    </c:if>
                                </s:iterator>

                            </select>
                        </div>

                        <div class="form-group">
                            <label for="moyenne">Moyenne</label>
                            <input type="text" class="form-control" id="moyenne" placeholder="Moyenne" name="eleve.moyenne" value="<s:property value='eleve.moyenne'/>">
                        </div>
                        <button type="submit" class="btn btn-primary">Update Eleve</button>
                    </s:form>
                </div>
            </div>
        </div>

        <footer>
            <p>Projet JEE - DKHISSI AYOUB © 2022/2023</p>
        </footer>
    </body>



    <script>

    </script>
</html>
