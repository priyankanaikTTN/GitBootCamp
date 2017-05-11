<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>


<body>
<div class="row" style="padding:2% 5%">
    <div class="col-md-6">
        <div class="row">
            <div class="panel panel-default panel-primary">
                <div class="panel-heading">
                    Recent Shares
                </div>

                <div style="height: 400px;overflow-y: auto">
                    <g:each in="${recentPosts}" var="recentPost">
                        <g:render template="/templates/recentShares" model="[post: recentPost]"/>
                    </g:each>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default panel-primary">
                <div class="panel-heading">
                    Top Posts
                </div>

                <div style="height: 400px;overflow-y: auto">
                    <g:each in="${topPosts}" var="topPost">
                        <g:render template="/templates/topPosts" model="[post: topPost]"/>
                    </g:each>
                </div>

            </div>
        </div>
    </div>


</div>

<g:javascript>


</g:javascript>

</body>

</html>