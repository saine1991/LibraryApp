<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

<c:url value="/book/edit" var="editBookUrl"/>
<c:url value="/book/delete" var="deleteBookUrl"/>

<c:url value="/rent/book" var="rentUrl"/>

<div class="container">

    <h1>List of books</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center col-md-1">Id</th>
                    <th class="text-center">Title</th>
                    <th class="text-center">Author</th>
                    <th class="text-center col-md-1">Available</th>
                    <th class="text-center col-md-1">Edit</th>
                    <th class="text-center col-md-1">Delete</th>
                    <th class="text-center col-md-1">Rent</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.available}</td>
                        <td class="text-center"><a href="${editBookUrl}/${book.id}" class="btn btn-sm btn-primary">Edit</a></td>
                        <td class="text-center">
                            <a href="${deleteBookUrl}/${book.id}" class="btn btn-sm btn-danger delete-button">Delete</a>
                        </td>

                        <td class="text-center">
                        <c:choose>
                            <c:when test="${book.available > 0}">
                                <a href="${rentUrl}/${book.id}" class="btn btn-info btn-sm">Rent</a>
                            </c:when>
                            <c:otherwise>
                                brak
                            </c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<script>

    $(function() {
        $('.delete-button').on('click', function(event) {
            console.log(event);
            event.preventDefault();
            var url = event.target.href;
            $.post(url)
            .done(function() {
                location.reload();
            });
        });
    });




</script>

<%@ include file="/WEB-INF/include/footer.jsp" %>