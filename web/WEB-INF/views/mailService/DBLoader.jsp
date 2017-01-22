<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navigation.jsp"/>
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
<jsp:include page="footer.jsp"/>
