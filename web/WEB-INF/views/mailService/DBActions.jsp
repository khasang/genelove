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
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>DB Loader</legend>
        <h1>Clear tables</h1>
        <form method="post" action="clearTables">
            <input class="submitMail" type="submit" value="Send Mail" />
        </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>DB Loader</legend>
        <h1>Load/Reload tables</h1>
        <form method="post" action="loadTables">
            <input class="submitMail" type="submit" value="Send Mail" />
        </form>
    </fieldset>
</div>
<div class="sendMail">
    <fieldset class="fieldset">
        <legend>DB Loader</legend>
        <h1>View tables</h1>
        <form method="post" action="viewTables">
            <input class="submitMail" type="submit" value="Send Mail" />
        </form>
    </fieldset>
</div>
<jsp:include page="include/footer.jsp"/>