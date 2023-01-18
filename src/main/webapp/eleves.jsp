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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>

        <title>Eleves</title>
    </head>


    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/DKHISSI_AYOUB_JEE">JEE</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="nav-link"><a href="/DKHISSI_AYOUB_JEE">Home</a></li>
                    <li class="nav-link active"><a href="eleves">Eleves</a></li>
                    <li class="nav-link"><a href="filieres">Filieres</a></li>
                </ul>
            </div>
        </nav>

        <s:if test="success_message != null && !success_message.isEmpty()">
            <span class="alert-success success"><s:property value="success_message"/></span>
        </s:if>
        <div class="container">
            <div class="row ">

                <div class="col-md-10 col-md-offset-1">

                    <div class="panel panel-default panel-table">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col col-xs-6 ">
                                    <div class="panel-title font-weight-bold">Liste des eleves</div>
                                </div>
                                <div class="col col-xs-6 text-right">
                                    <a href="addEleveForm" class="btn btn-sm btn-primary btn-create">Ajouter Eleve</a>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-list">
                                <thead>
                                    <tr>
                                        <th style="width: 16.66%"><em class="fa fa-cog"></em></th>
                                        <th>CNE</th>
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>Filiere</th>
                                        <th>Moyenne</th>
                                    </tr> 
                                </thead>
                                <tbody>

                                    <s:iterator value="eleves">
                                        <tr>
                                            <td align="center">
                                                <a href="updateEleveForm?cne=<s:property value='cne'/>" class="btn btn-default"><em class="fa fa-pencil"></em></a>
                                                <a onclick="confirmDelete('<s:property value='cne'/>')" class="btn btn-danger" ><em class="fa fa-trash"></em></a>
                                            </td>
                                            <td><s:property value="cne" /></td>
                                            <td><s:property value="nom" /></td>
                                            <td><s:property value="prenom" /></td>
                                            <td>
                                                <s:if test="ref_fil != null">
                                                    <s:property value="ref_fil.code_fil" />
                                                </s:if>
                                                <s:else>
                                                    Non determiné
                                                </s:else>
                                            </td>
                                            <td><s:property value="moyenne" /></td>


                                        </tr>
                                    </s:iterator>

                                </tbody>
                            </table>

                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col col-xs-4">
                                    Nombre total d'eleves: ${nbrTotalEleves}
                                </div>
                                <div class="col col-xs-8">
                                    <ul class="pagination hidden-xs pull-right">
                                        <c:forEach var="i" begin="1" end="${nbrTotalEleves/4 + (nbrTotalEleves%4!=0?1:0) }" step="1">
                                            <c:if test="${i eq pageIndex}">
                                                <li class="active"><a href="?pageIndex=${i}">${i}</a></li>
                                            </c:if>
                                            <c:if test="${i ne pageIndex}">
                                                <li class=""><a href="?pageIndex=${i}">${i}</a></li>
                                            </c:if>
                                        </c:forEach>
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

    <script>
        function confirmDelete(cne) {
            if (confirm("Are you sure you want to delete this item?")) {
                // redirect the user to another page
                window.location.href = 'delete_eleve?cne=' + cne;
            }
        }
    </script>

</html>
