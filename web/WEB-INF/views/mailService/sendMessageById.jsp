<jsp:include page="include/header.jsp"/>
<div class="Messenger">
    <fieldset class="fieldsetMessenger">
        <legend id="numberOfMessages">0</legend>
        <a href="/messenger">Dear <strong>${currentUser}</strong>.<br>You have not new message yet</a>
    </fieldset>
</div>
<jsp:include page="include/title.jsp"/>
<body>
<jsp:include page="include/navigation.jsp"/>
<div class="systemMessage">
    <p>Your request has been successfully completed<br>
    <span class="systemResponce">${message}</span></p>
</div>
<hr class="hr">
<div class="sendMailById">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send Private Message to User by Id</h1>
    <form class="mailForm" method="post" action="send">
        <input type="hidden" name="recipient" value="${id}"/>
        <table border="0" align="center">
            <tr>
                <td><label>Private Message:</label></td>
                <td><textarea rows="4" name="privateMessage"></textarea></td>
            </tr>
        </table>
        <input class="submitMail" type="submit" value="Send your PM" />
    </form>
    </fieldset>
</div>
<jsp:include page="include/footer.jsp"/>
