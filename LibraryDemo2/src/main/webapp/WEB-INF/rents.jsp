<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<div class="container">

    <h1>List of rents</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center col-md-1">Id</th>
                    <th class="text-center">Date rent</th>
                    <th class="text-center">Status</th>
                    <th class="text-center">User</th>
                    <th class="text-center">Book</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${rentsList}" var="rent">
                    <tr>
                        <td>${rent.id}</td>
                        <td>${rent.createdDate}</td>
                        <td>${rent.status}</td>
                        <td>${rent.user.firstName} ${rent.user.lastName}</td>
                        <td>${rent.book.author} - ${rent.book.title}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>