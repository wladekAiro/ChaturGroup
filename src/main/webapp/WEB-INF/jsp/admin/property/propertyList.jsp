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
        <jsp:include page="/WEB-INF/jsp/admin/property/header/propertyHeader.jsp"/>
    </div>
    <div class="box-body no-padding">
        <div class="box">
            <div class="box-header with-border">
                <div class="row">
                    <div class="col-sm-3">
                        <a class="btn btn-default" href="/admin/property/propertyForm">  New  </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="box-body">
        <div class="row">
            <c:if test="${message}">
                <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <div class="alert alert-success">
                                ${content}
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <div class="row">
            <c:choose>
                <c:when test="${empty propertyList}">
                    <div class="row">
                        <div class="col-sm-5 col-sm-offset-3">
                            <div class="alert alert-success">
                                No Companies registered
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-sm-12">
                        <div class="col-sm-3">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Companies</h3>
                                </div>
                                <div class="box-body">
                                    <c:forEach items="${propertyList}" var="property">
                                        <ul>
                                            <li><a href="/admin/property/home?company=${property.id}">${property.name}</a></li>
                                        </ul>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <%--<div class="col-sm-1"></div>--%>
                        <div class="col-sm-9">
                            <div class="box">
                                    <c:choose>
                                        <c:when test="${selectedProperty == null}">
                                            <p>Select a company on left to view options</p>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="box-header with-border">
                                                <h3 class="box-title">${selectedProperty.name}</h3>
                                                <div class="box-tools">
                                                    <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                                                        NEW BUILDING
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="table-responsive">
                                                    <c:choose>
                                                        <c:when test="${empty selectedProperty.buildings}">
                                                            <div class="alert alert-war">
                                                                No buildings
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <table class="table table-striped table-bordered table-hover">
                                                                <thead>
                                                                <tr>
                                                                    <th>Building name</th>
                                                                    <th>Floors</th>
                                                                    <th></th>
                                                                    <th></th>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <c:forEach items="${selectedProperty.buildings}" var="building">
                                                                    <tr>
                                                                        <td>${building.name}</td>
                                                                        <td>floors</td>
                                                                        <td>
                                                                            <a href="/admin/building/home/${building.id}">Show</a>
                                                                        </td>
                                                                        <td></td>
                                                                    </tr>
                                                                </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
        </div>
    </div>
</div>
<%--end body--%>
<!-- start of footer section -->
<%--modal--%>
<!-- Modal -->
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Building Form</h4>
            </div>
            <div class="modal-body">
                <div class="box">
                    <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
                        <form:form acceptCharset="UTF-8" action="/admin/property/building/${action}" method="post" modelAttribute="building" cssClass="form-horizontal" role="form">
                            <div class="form-group">
                                <label for="name" class="col-sm-3 control-label">Building Name</label>
                                <div class="col-sm-9">
                                    <form:input path="name" id="name" type="text" cssClass="form-control" placeholder="Building Name" />
                                    <form:input path="id" id="id" type="hidden"/>
                                    <form:input path="propertyId" type="hidden" value="${selectedProperty.id}"></form:input>
                                    <form:errors path="name" cssClass="form-inline" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address" class="col-sm-3 control-label">Address</label>
                                <div class="col-sm-9">
                                    <form:textarea path="address" id="address" cssClass="form-control" placeholder="Address here"></form:textarea>
                                    <form:errors path="address" cssClass="form-inline" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="location" class="col-sm-3 control-label">Location</label>
                                <div class="col-sm-9">
                                    <form:textarea path="location" id="location" cssClass="form-control" placeholder="Describe location here"></form:textarea>
                                    <form:errors path="location" cssClass="form-inline" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-10">
                                    <input class="btn btn-success" type="submit" value="Submit">
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<%--end modal--%>
<jsp:include page="/WEB-INF/jsp/common/adminFooter.jsp"/>
</html>
