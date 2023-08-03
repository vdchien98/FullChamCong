<%@page import="com.liferay.docs.chamcong.model.Ngaylamviec"%>
<%@page import="java.util.Date"%>
<%@ include file="../init.jsp"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>

<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị ngày làm việc</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách số ngày
				làm việc trong tháng</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-7">
					<%
						String thangNam = request.getParameter("thangNam");
					%>
					<div class="form-group row">
						<form class="pl-5" id="search-year" method="get">
							<input type="hidden" name="p_p_id"
								value="<%=themeDisplay.getPortletDisplay().getId()%>" /> <input
								type="hidden" name="p_p_auth" value="" />
							<div class="form-group row">
								<div class="form-group row">
									<label class="col-form-label font-weight-bold text-info mr-3">Năm</label>
									<input type="text"
										class="form-control datepicker col-md-6 ml-6"
										name="<portlet:namespace />year" id="year" placeholder="Năm"
										value="${thangNam}" />
								</div>
							</div>
						</form>
					</div>


					<%
						List<Ngaylamviec> ListNgayLamViecOfNam = (List<Ngaylamviec>) request.getAttribute("ListNgayLamViecOfNam");
						System.out.println("ListNgayLamViecOfNam --------jsp --- " + ListNgayLamViecOfNam);
					%>
					<table class="table table-bordered table-hover" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Tháng</th>
								<th>Số ngày làm việc</th>
								<th>Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ListNgayLamViecOfNam}" var="ngaylamviec">
								<tr>
									<td class="text-center">${ngaylamviec.thang}</td>
									<td class="text-center">${ngaylamviec.so_ngay_lam_viec}</td>
									<td class="text-center">
										<button class="btn btn-success btn-circle mr-1 btn-sm"
											type="button" data-toggle="tooltip" title="Sửa"
											onclick="editNgayLamViec('${ngaylamviec.id}', '${ngaylamviec.thang}', '${ngaylamviec.so_ngay_lam_viec}');">
											<i class="fa fa-pencil" aria-hidden="true"></i>
										</button>

									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>





				</div>
				<%-- cập nhật ngày làm việc  --%>
			<div class="col-md-5">
					<div class="modal-header">
						<h5 class="modal-title text-uppercase font-weight-bold">CẬP NHẬT NGÀY LÀM VIỆC</h5>
					</div>
					<portlet:actionURL name="saveNgayLamViec" var="formNgayLamViecActionURL" />
					<form id="form1" method="POST"
						action="<%=formNgayLamViecActionURL.toString()%>"
						name="<portlet:namespace />fm">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="tenphong" class="col-form-label text-md-right">Tháng <span class="text-danger">(*)</span></label> 
								<input id="idngaylamviec" type="hidden" class="form-control"
									name="<portlet:namespace />idngaylamviec" required autofocus
									placeholder="ID" value=""> 
									<input
									id="thangId" type="text" class="form-control inpputreset"
									name="<portlet:namespace />thangId" required autofocus
									placeholder="Nhập tên phòng" value="">
							</div>
							<div class="form-group row mt-4">
								<label for="nguoi_phu_trach" class="col-form-label text-md-right">Số ngày làm việc </label> 
								<input id="so_ngay_lam_viecId" type="text" class="form-control inpputreset"
									name="<portlet:namespace />so_ngay_lam_viecId" required autofocus
									placeholder="Nhập số ngày " value="">
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary"
								onclick="clearForm(event)">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
							</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('.datepicker').datepicker({
			language : 'vi',
			format : "yyyy",
			startView : "years",
			minViewMode : "years"
		}).on('changeDate', function(e) {
			var selectedYear = e.date.getFullYear(); // Năm được chọn
			console.log("selectedYear là " + selectedYear)
			$('#year').val(selectedYear);
			$('#search-year').submit();

		});
	});
</script>

<script>
	function editNgayLamViec(id, thang, so_ngay_lam_viec) {
		var modalTitle = document.querySelector(".modal-title");
		document.getElementById("idngaylamviec").value = id;
		document.getElementById("thangId").value = thang;
		document.getElementById("so_ngay_lam_viecId").value = so_ngay_lam_viec;
		
	}
</script>