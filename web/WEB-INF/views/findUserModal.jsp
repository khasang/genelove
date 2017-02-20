
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="modal fade" id="myModalFindLove" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Find Love Parameter</h4>
            </div>
            <div class="modal-body">
                <div class="panel-body">
<form:form action="${pageContext.request.contextPath}findProfile" method="get" commandName="findProfile"
           cssClass="form-inline form-group-sm">
                    <p>
                        AGE :  <input id="from" type="number" min="16" max="90" name="from"/> - <input id="to" type="number" min="16" max="90" name="to"/>
                    </p>
                    <p><label for="gender">Gender:</label>
                        <select name="gender" id="gender" class="form-control">
                            <option value="FEMALE">female</option>
                            <option value="MALE">male</option>
                        </select></p>

                    <p><label for="marital">Marital Status:</label>
                        <select name="marital" id="marital" class="form-control">
                            <option value="SINGLE">Single</option>
                            <option value="MARRIED">Married</option>
                            <option value="SEPARATED">Separated</option>
                            <option value="DIVORCED">Divorced</option>
                            <option value="WIDOWED">Widowed</option>
                        </select></p>


                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" class="btn btn-success" value="Find">
</form:form>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
