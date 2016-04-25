<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/jsp/common/adminHeader.jsp">
    <jsp:param name="title" value="PENSION"/>
  </jsp:include>
</head>
<jsp:include page="/WEB-INF/jsp/common/adminHead.jsp"/>
<body>

<div class="box">
  <div class="box-header with-border">
    <jsp:include page="/WEB-INF/jsp/admin/property/header/propertyHeader.jsp"/>
  </div><!-- /.box-header -->
  <div class="box-body no-padding">
    <div class="box">
      <div class="box-header with-border">
        <div class="row">
          <div class="col-sm-3">
            <a class="btn btn-default" href="/admin/property/home">  Back  </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="box-body">
    <div class="col-sm-9 col-sm-offset-1 col-md-10 col-md-offset-1 main">
      <h1 class="page-header">Building Form</h1>
      <form:form acceptCharset="UTF-8" action="/admin/property/building/${action}" method="post" modelAttribute="property" cssClass="form-horizontal" role="form">
        <div class="form-group">
          <label for="name" class="col-sm-2 control-label">Company Name</label>
          <div class="col-sm-6">
            <form:input path="name" id="name" type="text" cssClass="form-control" placeholder="Company Name" />
            <form:input path="id" id="id" type="hidden"/>
            <form:errors path="name" cssClass="form-inline" />
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
  </div>
  </div>
</body>
</html>
