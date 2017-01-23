
<jsp:include page="head.jsp"/>

<body>
<jsp:include page="header.jsp"/>
<c:set var="pageListHolder" value="${usersList}" scope="session" />

<div align="center">
    <ul class="pagination">
        <li>
            <%--<a href="?page=previous">&lt;</a>--%>
            <span style="float:left;">
                    <c:choose>
                        <c:when test="${pageListHolder.firstPage}"> < </c:when>
                        <c:otherwise><a href="?page=previous"> < </a></c:otherwise>
                    </c:choose>
                    </span>
        </li>
        <li>
                    <span>
                    <c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
                        &nbsp;&nbsp;
                        <c:choose>
                            <c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
                            <c:otherwise><a href="?page=${loop.index}">${loop.index+1}</a></c:otherwise>
                        </c:choose>
                        &nbsp;&nbsp;
                    </c:forEach>
                    </span>
        </li>
        <li>
            <%--<a href="?page=next">&gt;</a>--%>
            <span>
                    <c:choose>
                        <c:when test="${pageListHolder.lastPage}"> > </c:when>
                        <c:otherwise><a href="?page=next"> > </a></c:otherwise>
                    </c:choose>
                    </span>
        </li>
    </ul>
</div>
</body>
</html>
