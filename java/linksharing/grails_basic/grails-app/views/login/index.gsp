<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>


<body>
<div class="row" style="padding: 2% 5%">
    <div class="col-md-6">
        <div class="row">
            <div class="panel panel-default panel-primary">
                <div class="panel-heading">
                    Recent Shares
                </div>

                <div style="height: 400px;overflow-y: auto">

                        <ls:recentShares/>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default panel-primary">
                <div class="panel-heading">
                    Top Posts
                    <div class="dropdown col-sm-4 pull-right col-sm-push-2">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            Today
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <li><a href="#">1 week</a></li>
                            <li><a href="#">1 month</a></li>
                            <li><a href="#">1 year</a></li>
                        </ul>
                    </div>
                </div>

                <div style="height: 400px;
                overflow-y: auto;
                width: 100%;">
                    <ls:topPosts/>
                </div>

            </div>
        </div>
    </div>

    <div class="col-md-5 col-md-offset-1">
        <div class="row">
            <g:render template="/login/login"/>
        </div>

        <div class="row">
            <g:render template="/login/register"/>
        </div>
    </div>
</div>

<g:javascript>


</g:javascript>

</body>

</html>