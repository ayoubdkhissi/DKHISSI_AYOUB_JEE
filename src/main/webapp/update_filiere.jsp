<%-- 
    Document   : add_update_filiere.jsp
    Created on : Jan 15, 2023, 12:54:09 PM
    Author     : Ayoub DKhissi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="styles/add_update_filiere.css" rel="stylesheet" id="bootstrap-css">

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="scripts/filieres.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
        
        <title>Update Filiere</title>
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
            
            <h1 class="title-update">Update Filiere <s:property value='filiere.code_fil'/></h1>
            
            <div class="row">
                <div class="col-md-6 mx-auto form-container">
                    <s:form action="update_filiere">
                        <div class="form-group">
                            <label for="code_fil">Code Filiere</label>
                            <input readonly="readonly" type="text" class="form-control" id="code_fil" placeholder="Code Filiere" name="filiere.code_fil" value="<s:property value='filiere.code_fil'/>">
                        </div>
                        <div class="form-group">
                            <label for="nom_fil">Nom Filiere</label>
                            <input type="text" class="form-control" id="nom_fil" placeholder="Nom Filiere" name="filiere.nom_fil" value="<s:property value='filiere.nom_fil'/>">
                        </div>
                        <button type="submit" class="btn btn-primary">Update Filière</button>
                    </s:form>
                </div>
            </div>
        </div>

        <footer>
            <p>Projet JEE - DKHISSI AYOUB © 2022/2023</p>
        </footer>
    </body>
</html>
