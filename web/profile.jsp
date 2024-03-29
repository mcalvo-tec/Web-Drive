<%-- 
    Document   : profile
    Created on : 15/06/2019, 04:47:17 PM
    Author     : Ace
--%>

<%@ page import="Models.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Drive Web</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Tree View style -->
        <link href="style/treeView/treeView.css" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <nav class="navbar navbar-inverse">  
          <div class="container-fluid">  
            <div class="navbar-header">  
              <a class="navbar-brand" href="#">Web Drive</a>  
            </div>  
            <ul class="nav navbar-nav">  
              <li class="active"><a href="#">Home</a></li>  
              <li><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>  
              </li>  
              <li><a href="#">Page 2</a></li>  
              <li><a href="#">Page 3</a></li>  
            </ul>  
            <ul class="nav navbar-nav navbar-right">  
              <li><a id="usernav" href="#">
                      <span class="glyphicon glyphicon-user"></span> 
                      <%out.println("Bienvenido, " + request.getSession(false).getAttribute("name"));%>
                  </a></li>  
              <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>  
            </ul>  
          </div>  
        </nav>  
        
        <div class="container-fluid" style="margin-top:30px;">
            <div class="row">
                <h3>Mi Unidad</h3>
                <div class="col-md-4">
                    <ul id="tree1">
           
                        <li><a href="#">TECH</a>

                            <ul>
                                <li>Company Maintenance</li>
                                <li>Employees
                                    <ul>
                                        <li>Reports
                                            <ul>
                                                <li>Report1</li>
                                                <li>Report2</li>
                                                <li>Report3</li>
                                            </ul>
                                        </li>
                                        <li>Employee Maint.</li>
                                    </ul>
                                </li>
                                <li>Human Resources</li>
                            </ul>
                        </li>
                        <li>XRP
                            <ul>
                                <li>Company Maintenance</li>
                                <li>Employees
                                    <ul>
                                        <li>Reports
                                            <ul>
                                                <li>Report1</li>
                                                <li>Report2</li>
                                                <li>Report3</li>
                                            </ul>
                                        </li>
                                        <li>Employee Maint.</li>
                                    </ul>
                                </li>
                                <li>Human Resources</li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        
        <!-- SCRIPTS -->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="mdb/js/popper.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- Tree View -->
        <script type="text/javascript" src="style/treeView/treeView.js" ></script>
    </body>
</html>
