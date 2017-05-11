<%@ page import="enums.Visibility" %>
<div class="modal fade" id="createtopicModal" tabindex="-1" role="dialog" aria-labelledby="createtopicModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="createtopicModalLabel">Create Topic</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="topic" action="save" name="topicCreate">
                    <div class="form-group row">
                        <label for="topicname" class="col-sm-4 form-control-label">Name *</label>

                        <div class="col-sm-8">
                            <g:textField name="topicname" placeholder="Topic Name"
                                         class="form-control col-sm-8" value="${topicCO?.topicname}"/>
                            <g:hiddenField name="createdBy" value="${session.user}"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="visibility" class="col-sm-4 form-control-label">Visibility *</label>

                        <div class="col-sm-8">
                            <div class="dropdown">
                                <g:render name="visibility" class="btn dropdown-toggle"
                                          template="/templates/visibility" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-4 form-control-label">
                            <button type="button" class="btn btn-default btn-block" data-dismiss="modal">Close</button>
                        </div>

                        <div class="col-sm-8">
                            <button  name="createTopicBtn" id="createTopicBtn" value=""
                                     class="btn btn-block btn-primary">Create Topic</button>
                        </div>
                    </div>
                </g:form>
            </div>
        </div>
    </div>
</div>