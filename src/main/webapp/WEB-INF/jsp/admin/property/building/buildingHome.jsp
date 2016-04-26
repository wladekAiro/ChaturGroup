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
                        <h4>Building Management Section</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="box-body">
        <div class="row">
            <c:if test="${message}">
                <div class="row">
                    <div class="alert alert-success">
                        Deleted ....
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
                    No floors registered yet
                </div>
            </div>
            <div class="col-sm-9">
                <div class="box">
                    <div class="box-header">
                        <div class="box-tools">
                            <a type="button" class="btn btn-primary btn-sm" href="/admin/building/home/${building.id}?form=true">
                                ADD FLOOR
                            </a>
                        </div>
                    </div>
                    <div class="box-body">
                        <c:if test="${floorFom}">
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
                        </c:if>
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
