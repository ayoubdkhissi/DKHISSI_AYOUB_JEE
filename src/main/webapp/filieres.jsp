<%-- 
    Document   : filieres
    Created on : Jan 14, 2023, 8:22:36 PM
    Author     : Ayoub Dkhissi
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des filieres</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-offset-1 col-md-10">
                    <div class="panel">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-sm-12 col-xs-12">
                                    <a href="#" class="btn btn-sm btn-primary pull-left"><i class="fa fa-plus-circle"></i> Add New</a>
                                    <form class="form-horizontal pull-right">
                                        <div class="form-group">
                                            <label>Show : </label>
                                            <select class="form-control">
                                                <option>5</option>
                                                <option>10</option>
                                                <option>15</option>
                                                <option>20</option>
                                            </select>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Action</th>
                                        <th>#</th>
                                        <th>Name</th>
                                        <th>Age</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <ul class="action-list">
                                                <li><a href="#" class="btn btn-primary"><i class="fa fa-pencil-alt"></i></a></li>
                                                <li><a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a></li>
                                            </ul>
                                        </td>
                                        <td>1</td>
                                        <td>Vincent Williamson</td>
                                        <td>31</td>
                                        <td><a href="#" class="btn btn-sm btn-success"><i class="fa fa-search"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <ul class="action-list">
                                                <li><a href="#" class="btn btn-primary"><i class="fa fa-pencil-alt"></i></a></li>
                                                <li><a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a></li>
                                            </ul>
                                        </td>
                                        <td>2</td>
                                        <td>Taylor Reyes</td>
                                        <td>22</td>
                                        <td><a href="#" class="btn btn-sm btn-success"><i class="fa fa-search"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <ul class="action-list">
                                                <li><a href="#" class="btn btn-primary"><i class="fa fa-pencil-alt"></i></a></li>
                                                <li><a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a></li>
                                            </ul>
                                        </td>
                                        <td>3</td>
                                        <td>Justin Block</td>
                                        <td>26</td>
                                        <td><a href="#" class="btn btn-sm btn-success"><i class="fa fa-search"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <ul class="action-list">
                                                <li><a href="#" class="btn btn-primary"><i class="fa fa-pencil-alt"></i></a></li>
                                                <li><a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a></li>
                                            </ul>
                                        </td>
                                        <td>4</td>
                                        <td>Sean Guzman</td>
                                        <td>26</td>
                                        <td><a href="#" class="btn btn-sm btn-success"><i class="fa fa-search"></i></a></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <ul class="action-list">
                                                <li><a href="#" class="btn btn-primary"><i class="fa fa-pencil-alt"></i></a></li>
                                                <li><a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a></li>
                                            </ul>
                                        </td>
                                        <td>5</td>
                                        <td>Keith Carter</td>
                                        <td>24</td>
                                        <td><a href="#" class="btn btn-sm btn-success"><i class="fa fa-search"></i></a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">showing <b>5</b> out of <b>25</b> entries</div>
                                <div class="col-sm-6 col-xs-6">
                                    <ul class="pagination hidden-xs pull-right">
                                        <li><a href="#">«</a></li>
                                        <li class="active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                    <ul class="pagination visible-xs pull-right">
                                        <li><a href="#">«</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
