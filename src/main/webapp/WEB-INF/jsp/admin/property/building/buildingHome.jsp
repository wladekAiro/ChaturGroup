<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/jsp/common/adminHeader.jsp">
        <jsp:param name="title" value="PENSION"/>
    </jsp:include>
</head>
<jsp:include page="/WEB-INF/jsp/common/adminHead.jsp"/>

<!-- Carousel
================================================== -->
<%--body--%>
<div class="box">
    <div class="box-header with-border">
        <jsp:include page="/WEB-INF/jsp/admin/property/header/buildingHeader.jsp"/>
    </div>
    <div class="box-body no-padding">
        <div class="box">
            <div class="box-header with-border">
                <div class="row">
                    <div class="col-sm-3">
                        <h4>MANAGE ${building.name.toUpperCase()} BUILDING</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="box-body">
        <div class="row">
            <c:if test="${message}">
                <div class="row">
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <div class="alert alert-success">
                                    ${content}
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="box">
                    <div class="box-title">
                        <div class="box-header with-border">
                            <h3>Floors</h3>
                        </div>
                    </div>
                </div>
                <div class="box-body">
                    <div class="col-sm-12">
                        <c:choose>
                            <c:when test="${empty floorPage.content}">
                                No floors available
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${floorPage.content}" var="floor">
                                    <ul>
                                        <li>
                                            <a href="/admin/building/home/${building.id}?floor=${floor.id}">${floor.number}</a>
                                        </li>
                                    </ul>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="box-footer">
                    <jsp:include page="/WEB-INF/jsp/common/pagination.jsp">
                        <jsp:param name="paginatedRecord" value="floorPage"/>
                        <jsp:param name="url" value="${pagenatedUrl}"/>
                    </jsp:include>
                </div>
            </div>
            <div class="col-sm-9">
                <div class="box">
                    <div class="box-header">
                        <div class="box-tools">
                            <c:choose>
                                <c:when test="${floorFom}">
                                    <a type="button" class="btn btn-primary btn-sm" href="/admin/building/home/${building.id}">
                                        CANCEL
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a type="button" class="btn btn-primary btn-sm" href="/admin/building/home/${building.id}?form=true">
                                        ADD FLOOR
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="box-body">
                        <%--floor form area--%>
                        <c:choose>
                            <c:when test="${floorFom}">
                                <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
                                    <h1 class="page-header">Register floor</h1>
                                    <form:form acceptCharset="UTF-8" action="/admin/building/home/${building.id}" method="post" modelAttribute="floor" cssClass="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="number" class="col-sm-2 control-label">Number</label>
                                            <div class="col-sm-6">
                                                <form:input path="number" id="number" type="text" cssClass="form-control" placeholder="Floor number" />
                                                <form:input path="id" id="id" type="hidden"/>
                                                <form:input path="buildingId" id="buildingId" value="${building.id}" type="hidden"/>
                                                <form:errors path="number" cssClass="form-inline" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description" class="col-sm-2 control-label">Description</label>
                                            <div class="col-sm-6">
                                                <form:textarea path="description" id="description" cssClass="form-control" placeholder="Brief description"></form:textarea>
                                                <form:errors path="description" cssClass="form-inline" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input class="btn btn-success" type="submit" value="Submit">
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-sm-9">
                                    <div class="box">
                                        <c:choose>
                                            <c:when test="${selectedFloor == null}">
                                                <p>Select a Floor on left to view options</p>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="box">
                                                    <div class="box-header">
                                                        <div class="box-tools">
                                                            <div>
                                                                <c:choose>
                                                                    <c:when test="${roomForm}">
                                                                        <a type="button" class="btn btn-sm" href="/admin/building/home/${building.id}?floor=${selectedFloor.id}">
                                                                            Cancel
                                                                        </a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a type="button" class="btn btn-sm" href="/admin/building/home/${building.id}?floor=${selectedFloor.id}&room=true">
                                                                            ADD ROOM
                                                                        </a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="box-body">
                                                    <c:choose>
                                                        <c:when test="${roomForm}">
                                                            <div class="col-sm-12 col-sm-offset-0 col-md-12 col-md-offset-0 main">
                                                                <h1 class="page-header">Add room to ${selectedFloor.number} floor</h1>
                                                                <form:form acceptCharset="UTF-8" action="/admin/building/home/room/${building.id}?floor=${selectedFloor.id}&room=true" method="post" modelAttribute="shop" cssClass="form-horizontal" role="form">
                                                                    <div class="form-group">
                                                                        <label for="number" class="col-sm-3 control-label">Room Number</label>
                                                                        <div class="col-sm-6">
                                                                            <form:input path="number" id="number" type="text" cssClass="form-control" placeholder="Floor number" />
                                                                            <form:input path="id" id="id" type="hidden"/>
                                                                            <form:input path="floorId" id="floorId" value="${selectedFloor.id}" type="hidden"/>
                                                                            <form:errors path="number" cssClass="form-inline" />
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="description" class="col-sm-3 control-label">Description</label>
                                                                        <div class="col-sm-6">
                                                                            <form:textarea path="description" id="description" cssClass="form-control" placeholder="Brief description"></form:textarea>
                                                                            <form:errors path="description" cssClass="form-inline" />
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="col-sm-offset-3 col-sm-10">
                                                                            <input class="btn btn-success" type="submit" value="Submit">
                                                                        </div>
                                                                    </div>
                                                                </form:form>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:choose>
                                                                <c:when test="${empty selectedFloor.shops}">
                                                                    No rooms created yet
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="table-responsive">
                                                                        <table class="table table-striped table-bordered table-hover">
                                                                            <thead>
                                                                            <tr>
                                                                                <th>Room number/name</th>
                                                                                <th>Status</th>
                                                                                <th></th>
                                                                                <th></th>
                                                                            </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                            <c:forEach items="${selectedFloor.shops}" var="room">
                                                                                <tr>
                                                                                    <td>${room.number}</td>
                                                                                    <td>Vacant</td>
                                                                                    <td>
                                                                                        <a href="#">Show</a>
                                                                                    </td>
                                                                                    <td></td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                        <%--end floor form area--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--end body--%>
<!-- start of footer section -->
<%--end modal--%>
<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>
