<%@page import="java.util.Date"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- jQuery UI library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<!-- jQuery UI CSS -->
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">


<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị ngày nghỉ lễ</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách ngày
				nghỉ lễ</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-7">
					<div class="form-group row">
						<form class="pl-5" id="search-year"
							action="">
							<div class="form-group row">
								<label class="col-form-label font-weight-bold text-info mr-3 datepicker">Năm</label>
								<input type="text" 
								       class="form-control datepicker col-md-6 ml-6"
									   name="<portlet:namespace />year" id="year" placeholder="Năm"
									   value="">
							</div>
						</form>
					</div>
					<table class="table table-bordered table-hover" id="dataTable"
						width="100%" cellspacing="0">
						<thead>
							<tr>
								<th style="width: 5%;">STT</th>
								<th>Tên</th>
								<th>Thời gian</th>
								<th style="width: 10%;">Trạng thái</th>
								<th>Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ngaynghile" items="${ngayNghiLeList}"
								varStatus="loop">


								<tr>
									<td>${loop.index +1}</td>
									<td>${ngaynghile.ten}</td>
									<td><fmt:formatDate value="${ngaynghile.ngay_nghi}" pattern="dd-MM-yyyy" /></td>
									<td><c:choose>
											<c:when test="${ngaynghile.trangthai == 1}">
												<span class="btn btn-success btn-sm">Hoạt động</span>
											</c:when>
											<c:otherwise>
												<span class="btn btn-light btn-sm">Không hoạt động</span></td>
									</th>
									</c:otherwise>
									</c:choose>
									<td>
										<button class="btn btn-success btn-circle mr-1 btn-sm"
											type="button" data-toggle="tooltip" title="Sửa"
											onclick="editNgayNghiLe('${ngaynghile.id}', '${ngaynghile.ten}', '${ngaynghile.ngay_nghi}', '${ngaynghile.trangthai}');">
											<i class="fas fa-edit"></i>
										</button> <portlet:actionURL var="deleteNgayNghileURL"
											name="deleteNgayNghiLe" />
										<form name="deleteNgayNghile" id="deleteNgayNghile"
											method="POST" action="<%=deleteNgayNghileURL%>">
											<input type="hidden"
												name="<portlet:namespace />deleteNgayNghiLeId"
												value="${ngaynghile.id}" />
											<button class="btn btn-danger btn-circle btn-sm"
												type="submit">
												<i class="fa fa-trash" aria-hidden="true"></i>
											</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="col-md-5">
					<div class="modal-header">
						<h5 class="modal-title text-uppercase font-weight-bold">Thêm
							mới ngày nghỉ lễ</h5>
					</div>
					<portlet:actionURL name="saveNgayNghiLe"
						var="formNgayNghiLeActionURL" />
					<form id="form" method="POST"
						action="<%=formNgayNghiLeActionURL.toString()%>">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="ten" class="col-form-label text-md-right">Tên
									ngày nghỉ <span class="text-danger">(*)</span>
								</label> <input id="idNgayNghiLe" type="hidden" class="form-control"
									name="<portlet:namespace />idNgayNghiLe" required autofocus
									placeholder="ID" value="${ngaynghileedit.id}"> <input
									id="ten" type="text" class="form-control"
									name="<portlet:namespace />ten" required autofocus
									value="${ngaynghileedit.ten}" placeholder="Nhập tên chức vụ">
							</div>
							<div class="form-group row mt-4">
								<label for="ngay_nghi" class="col-form-label text-md-right">Thời
									gian <span class="text-danger">(*)</span>
								</label>
								<div class="input-group">
									<input type="text" class="form-control"
										name="<portlet:namespace />ngay_nghi" id="ngay_nghi"
										placeholder="ngày nghỉ lễ"
										value="${ngaynghileedit.ngay_nghi }" required>
									<div class="input-group-append">
										<span class="input-group-text" id="basic-addon2"><i
											class="fas fa-calendar-alt"></i></span>
									</div>
								</div>
							</div>
							<div class="custom-control custom-checkbox">
								<input type="checkbox" name="<portlet:namespace />trangthai"
									value="1" class="custom-control-input" id="trangthai" checked>
								<label class="custom-control-label" for="trangthai">Hoạt
									động</label>
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary">
								<i class="far fa-save"></i> Lưu
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		$("#ngay_nghi").datepicker({
			// minDate: 0,
			// changeMonth: true,
			dateFormat : "dd/mm/yy",
			// firstDay: 1,
			// hideIfNoPrevNext: true,
			// showAnim: 'slideDown',
			// showOn: "both",  
			showOtherMonths : true,
		// showStatus: true,
		// maxDate: '-1d'
		});
	});

	$(document).ready(function() {
		// Khởi tạo datepicker với option chỉ hiển thị năm
		$("#year").datepicker({
			startView : 'decade',
			//  minViewMode: 'years',
			// format: 'yyyy'
			changeYear : true,
			// changeMonth: false,
			dateFormat : "yy", // chỉ lấy năm
			yearRange : "1000:3030" // giới hạn năm từ 1900 đến 2030
		});
	});

	function editNgayNghiLe(id, ten, ngay_nghi, trangthai) {
		var modalTitle = document.querySelector(".modal-title");
		if (id > 0) {
			modalTitle.textContent = 'Chỉnh sửa ngày nghỉ lễ';
		} else {
			modalTitle.textContent = 'Thêm mới ngày nghỉ lễ';
		}
		var ngayNghi = moment(ngay_nghi);
		var ngayNghiFormatted = ngayNghi.format("DD/MM/YYYY");
		document.getElementById("idNgayNghiLe").value = id;
		document.getElementById("ten").value = ten;
		document.getElementById("ngay_nghi").value = ngayNghiFormatted;
		document.getElementById("trangthai").checked = trangthai;
	}
	
	
	
</script>



