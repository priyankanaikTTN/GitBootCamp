
<g:each in="${topPostList}" var="topPost">

    <div style="padding-top:30px" class="panel-body">

        <div class="row">
            <div class="col-sm-2">
                <a href="#"><span class="glyphicon glyphicon-user glyphicon-user-topics"></span></a>
            </div>

            <div class="col-sm-6">
                <div class="col-sm-4 ">
                    <h3 class="header">${topPost.userFirstName}</h3>
                </div>
                <div class="col-sm-4" style="margin-top:25px">
                    <span class="text-muted">@${topPost.userName  }</span>
                </div>
                <div class="col-sm-4 pull-right col-sm-push-10 linkUnderlineAll">
                    <a href="#">${topPost.topicName}</a>
                </div>

            </div>

            <div class="col-sm-8">

                <p style="margin-left:100px; margin-right:40px ;text-align:center">
                    ${topPost.description}
                </p>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <div class="col-sm-8 linkUnderlineAll col-sm-push-10 pull right">
                    <a href="#">View Post</a>
                </div>
            </div>
        </div>

    </div>


</g:each>