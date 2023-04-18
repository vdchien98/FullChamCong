<%@page import="com.liferay.docs.chamcong.model.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../init.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị phòng ban</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách phòng
				ban</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-7">
					<table class="table table-bordered table-hover" id="dataTable"
						width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên phòng ban</th>
								<th>Trạng thái</th>
								<th>Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="phongban" items="${phongBanList}"
								varStatus="loop">
								<tr>
									<td>${loop.index +1}</td>
									<td><span>${phongban.tenphong}</span> <br> <span
										class="font-weight-bold text-primary">Số nhân viên: 9</span> <br>
										<c:forEach var="user" items="${usersLanhDao}">
											<c:if test="${user.id == phongban.nguoi_phu_trach}">
												<span class="font-weight-bold text-warning">Người phụ
												trách: ${user.hovaten}</span>
											</c:if>
										</c:forEach></td>
									<td><c:if test="${condition}">
											<span class="btn btn-success btn-sm">Hoạt động</span>
										</c:if> <c:if test="${!condition}">
											<span class="btn btn-light btn-sm">Không hoạt động</span>
										</c:if></td>
									<td>
										<button class="btn btn-success btn-circle mr-1 btn-sm"
											type="button" data-toggle="tooltip" title="Sửa">
											<i class="fa fa-pencil" aria-hidden="true"></i>
										</button>
										<button class="btn btn-danger btn-circle btn-sm" type="button"
											data-toggle="tooltip" title="Xóa">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>


				<div class="col-md-5">
					<div class="modal-header">
						<h5 class="modal-title text-uppercase font-weight-bold">Thêm
							mới phòng ban</h5>
					</div>
					<portlet:actionURL name="savePhongBan" var="formPhongBanActionURL" />
					<form id="form1" method="POST"
						action="<%=formPhongBanActionURL.toString()%>"
						name="<portlet:namespace />fm">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="tenphong" class="col-form-label text-md-right">Tên
									phòng ban <span class="text-danger">(*)</span>
								</label> <input id="tenphong" type="text" class="form-control"
									name="<portlet:namespace />tenphong" required autofocus
									placeholder="Nhập tên phòng">
							</div>
							<div class="form-group row mt-4">
								<label for="nguoi_phu_trach"
									class="col-form-label text-md-right">Người phụ trách</label> <select
									class="form-control selectpicker" id="nguoi_phu_trach"
									name="<portlet:namespace />nguoi_phu_trach"
									data-live-search="true" required>
									<option value="">[-- Chọn người phụ trách --]</option>
									<c:forEach items="${usersLanhDao}" var="item">
										<option value="${item.id}">${item.hovaten}</option>
									</c:forEach>


								</select>
							</div>
							<div class="form-group row mt-4">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" name="<portlet:namespace />trangthai"
										value="1" class="custom-control-input" id="trangthai" checked>
									<label class="custom-control-label" for="trangthai">Hoạt
										động</label>
								</div>
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
							</button>
						</div>
					</form>

					<div>
						<strong class="text-danger">Chú ý:</strong> <br> <span>
							- Chỉ những phòng ban không có nhân viên có chức năng xóa. Phòng
							ban có nhân viên không có chức năng xóa.</span> <br> <span>
							- Do vậy để xóa được phòng ban phải chuyển các nhân viên trong
							phòng ban đó sang phòng ban khác hoặc xóa những nhân viên đó.</span>
					</div>
				</div>


			</div>
		</div>


	</div>
</div>
