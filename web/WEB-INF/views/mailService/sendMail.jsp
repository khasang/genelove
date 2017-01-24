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
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send simple e-mail by form (Denis Guzikov)</h1>
    <form class="mailForm" method="post" action="sendMail">
        <table border="0" align="center">
            <tr>
                <td><label>To:</label></td>
                <td><input type="text" name="recipient" class="inputTextarea"/></td>
            </tr>
            <tr>
                <td><label>Subject:</label></td>
                <td><input type="text" name="subject" class="inputTextarea"/></td>
            </tr>
            <tr>
                <td><label>Message:</label></td>
                <td><textarea rows="4" name="message" class="inputTextarea"></textarea></td>
            </tr>
        </table>
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send simple e-mail (Alexander Pyankov)</h1>
    <form method="post" action="sendMailToUser">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send multiple e-mail (Alexander Pyankov)</h1>
    <form method="post" action="sendMailToSomeUsers">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Send multiple e-mail for all users</h1>
    <form method="get" action="sendMailToAllUsers">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>E-Mail Service</legend>
    <h1>Empty<br>(For future usage)</h1>
    <form method="post" action="noAction">
        <input class="submitMail" type="submit" value="Send Mail" />
    </form>
    </fieldset>
</div>
<jsp:include page="include/footer.jsp"/>