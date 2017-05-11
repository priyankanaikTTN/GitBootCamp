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
    <asset:stylesheet src="style_edit.css"/>

    <g:layoutHead/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <a class="navbar-brand modal-title" href="#">Link Sharing</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->

        <div >
        <ul class="nav navbar-nav navbar-right">
            <li>
                <form class="navbar-form navbar-right">
                    <div class="input-group " id="sizing-addon-search">
                        <span class="input-group-addon" >
                            <a href="#"><span class="glyphicon glyphicon-search"></span></a>
                        </span>
                        <input type="text" class="form-control" placeholder="Search" aria-describedby="sizing-addon-search sizing-addon-remove">

                        <span class="input-group-addon" id="sizing-addon-remove">
                            <a href="#"><span class="glyphicon glyphicon-remove"></span></a>
                        </span>

                    </div>
                </form>
            </li>
            <g:if test="${session.user}">
                <li style="margin-top: 5px">
                    <span >
                        <a class="btn" role="button" data-toggle="modal" title="Create Topic"
                           data-placement="bottom"
                           data-target="#createtopicModal">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                        <a class="btn" id="inviteModalBtn" role="button" data-toggle="modal"
                           data-target="#sendinviteModal" title="Send Invitation"
                           >
                            <span class="glyphicon glyphicon-envelope"></span>
                        </a>
                        <a class="btn" id="linkResourceModalBtn" role="button" data-toggle="modal"
                           data-target="#sharelinkModal" title="Link Resource"
                        >
                            <span class="glyphicon glyphicon-paperclip"></span>
                        </a>
                        <a class="btn" id="documentResourceModalBtn" role="button" data-toggle="modal"
                           data-target="#sharedocModal" title="Document Resource"
                           >
                            <span class="glyphicon glyphicon-edit"></span>
                        </a>
                    </span>
                </li>
                <li>
                    <div class="dropdown">
                        <a class="btn dropdown-toggle" type="button" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user glyphicon-user-topics"
                                  style="font-size: large"></span>${session.user.username}
                            <span class="caret"></span>
                        </a>
                         <ul class="dropdown-menu">
                            <li><g:link >Profile</g:link></li>
                            <li><g:link>Edit Profile</g:link></li>

                            <li><g:link controller="login" action="logout">Logout</g:link></li>
                        </ul>
                    </div>
                </li>
            </g:if>
        </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="container">
    <g:if test="${session.user}">
        <g:render template="/topic/create"/>
        <g:render template="/topic/email"/>
    <g:render template="/resource/linkResourceCreate"/>
    <g:render template="/resource/documentResourceCreate"/>
    </g:if>

    <g:if test="${flash.message}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            ${flash.message}
        </div>
    </g:if>


    <g:if test="${flash.error}">
        <div class="alert alert-danger alert-warning alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            ${flash.error}
        </div>
    </g:if>

    <div class="jsonObjectResponse" style="display: none">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
    </div>


    <g:layoutBody/>
</div>

    <div class="footer" role="contentinfo"></div>


    <asset:javascript src="application.js"/>

</body>
</html>
