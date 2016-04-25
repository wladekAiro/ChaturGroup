<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


    <h1 class="box-title">PROPERTY MANAGEMENT</h1>
    <div class="box-tools">
        <%--<div class="input-group">--%>
        <%--<input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>--%>
        <%--<div class="input-group-btn">--%>
        <%--<button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>--%>
        <%--</div>--%>
        <%--</div>--%>
        <div class="col-sm-3">
            <a class="btn btn-default" href="/admin/property/home">Companies</a>
        </div>
        <div class="col-sm-3">
            <a class="btn btn-default" href="/admin/building/home">Buildings</a>
        </div>
        <div class="col-sm-3">
            <a class="btn btn-default" href="/admin/floor/home">  Floors  </a>
        </div>
        <div class="col-sm-3">
            <a class="btn btn-default" href="/admin/shop/home">  Shops  </a>
        </div>
    </div>

