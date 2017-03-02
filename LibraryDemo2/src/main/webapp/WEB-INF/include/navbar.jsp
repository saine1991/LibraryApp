<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/users" var="usersURL"/>
<c:url value="/create-user" var="createUserURL"/>
<c:url value="/logout" var="logoutURL"/>

<c:url var="booksUrl" value="/books"/>
<c:url var="createBookUrl" value="/book/create"/>

<c:url var="rentsUrl" value="/rents"/>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <sec:authorize access="hasRole('ADMIN')">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Users <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${createUserURL}">New...</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${usersURL}">Show all</a></li>
                    </ul>
                </li>
                </sec:authorize>

                 <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Books <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${createBookUrl}">New...</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${booksUrl}">Show all</a></li>
                    </ul>
                </li>
                <li><a href="${rentsUrl}">My rents</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <sec:authentication property="principal.username"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">My account</a></li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="${logoutURL}">Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>