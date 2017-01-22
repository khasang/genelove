<jsp:include page="header.jsp"/>
<body>
<jsp:include page="navigation.jsp"/>
<div class="systemErrorMessage">
    <p>Your request has <strong>NOT</strong> been completed by reason:
    <span class="errorMessage">${errorMessage}</span></p>
</div>
<jsp:include page="footer.jsp"/>
