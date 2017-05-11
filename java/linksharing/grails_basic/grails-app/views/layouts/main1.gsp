<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:stylesheet src="font-awesome.min.css"/>
    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>
<nav class="navbar navbar-default custom-navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand modal-title" href="#">Link Sharing</a>
        </div>


        <div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user pull-right"></span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Username <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </li>
            </ul>

            <form class="navbar-form navbar-right">
                <div class="input-group ">
                    <span class="input-group-addon" id="sizing-addon-search">
                        <a href="#"><span class="glyphicon glyphicon-search"></span></a>
                    </span>
                    <input type="text" class="form-control" placeholder="Search" aria-describedby="sizing-addon-search sizing-addon-remove">

                    <span class="input-group-addon" id="sizing-addon-remove">
                        <a href="#"><span class="glyphicon glyphicon-remove"></span></a>
                    </span>

                </div>

                <a href="#"><span class="glyphicon glyphicon-paperclip glyphicon-custom-paperclip-edit"></span></a>
                <a href="#"><span class="glyphicon glyphicon-edit glyphicon-custom-paperclip-edit"></span></a>
            </form>
        </div>
    </div>
</nav>

<g:layoutBody/>

<div class="footer" role="contentinfo"></div>


<asset:javascript src="application.js"/>

</body>
</html>