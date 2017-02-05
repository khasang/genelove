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
<div class="systemErrorMessage">
    <p>Your request has <strong>NOT</strong> been completed by reason:<br>
    <span class="errorMessage">${errorMessage}</span></p>
</div>
<jsp:include page="include/footer.jsp"/>
