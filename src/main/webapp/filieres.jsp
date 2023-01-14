<%-- 
    Document   : filieres
    Created on : Jan 14, 2023, 8:22:36 PM
    Author     : Ayoub Dkhissi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="styles/filieres.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="scripts/filieres.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>

        <title>Filieres</title>
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
            <div class="row ">

                <div class="col-md-10 col-md-offset-1">

                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6 ">
                                    <div class="panel-title font-weight-bold">Liste des filieres</div>
                                </div>
                                <div class="col col-xs-6 text-right">
                                    <button class="btn btn-sm btn-primary btn-create" data-toggle="modal">Ajouter Filière</button>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-list">
                                <thead>
                                    <tr>
                                        <th><em class="fa fa-cog"></em></th>
                                        <th>Code Filiere</th>
                                        <th>Designation</th>
                                        <th class="hidden-xs">Nombre d'eleves</th>
                                    </tr> 
                                </thead>
                                <tbody>

                                    <s:iterator value="filieres">
                                        <tr>
                                            <td align="center">
                                                <a class="btn btn-default"><em class="fa fa-pencil"></em></a>
                                                <a class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                            </td>
                                            <td><s:property value="code_fil" /></td>
                                            <td><s:property value="nom_fil" /></td>
                                            <td class="hidden-xs">1</td>
                                        </tr>
                                    </s:iterator>

                                </tbody>
                            </table>

                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col col-xs-4">Page 1 of 5
                                </div>
                                <div class="col col-xs-8">
                                    <ul class="pagination hidden-xs pull-right">
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                    </ul>
                                    <ul class="pagination visible-xs pull-right">
                                        <li><a href="#">«</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                </div></div></div>


        <footer>
            <p>Projet JEE - DKHISSI AYOUB © 2022/2023</p>
        </footer>
    </body>

</html>
