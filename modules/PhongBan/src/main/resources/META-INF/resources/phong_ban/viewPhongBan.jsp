<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
							<c:forEach var="data" items="${listPhongban}" varStatus="status">
								<c:set var="usersCount" value="${data.users.size()}" />

								<tr>
									<td>${status.index + 1}</td>
									<td><span>${data.tenphong}</span> <br> <span
										class="font-weight-bold text-primary">Số nhân viên:
											${usersCount}</span> <br> <span
										class="font-weight-bold text-warning">Người phụ trách:
											${not empty data.nguoi_phu_trach ? data.nguoiPhuTrach.hovaten : ''}</span>
									</td>
									<td><c:if test="${data.trangthai}">
											<span class="btn btn-success btn-sm">Hoạt động</span>
										</c:if> <c:if test="${!data.trangthai}">
											<span class="btn btn-light btn-sm">Không hoạt động</span>
										</c:if></td>
									<td>
										<button class="btn btn-success btn-circle mr-1 btn-sm"
											type="button" data-toggle="tooltip" title="Sửa"
											onclick="editPhongban(${data});">
											<i class="fas fa-edit"></i>
										</button> <c:if test="${usersCount == 0}">
											<button class="btn btn-danger btn-circle btn-sm"
												type="button" data-toggle="tooltip" title="Xóa"
												onclick="confirmDelete(${data.id});">
												<i class="fas fa-trash"></i>
											</button>

											<form id="delete-${data.id}" class="float-right"
												method="POST">
												<input type="hidden" name="_csrf" value="${_csrf.token}" />
												<input type="hidden" name="_method" value="DELETE" />
											</form>
										</c:if>
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
					<form id="form" method="POST">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="tenphong" class="col-form-label text-md-right">Tên
									phòng ban <span class="text-danger">(*)</span>
								</label> <input id="tenphong" type="text" class="form-control"
									name="tenphong" required autofocus placeholder="Nhập tên phòng">
							</div>
							<div class="form-group row mt-4">
								<label for="nguoi_phu_trach"
									class="col-form-label text-md-right">Người phụ trách</label> <select
									class="form-control selectpicker" id="nguoi_phu_trach"
									name="nguoi_phu_trach" data-live-search="true" required>
									<option value="">[-- Chọn người phụ trách --]</option>
									<c:forEach items="${nguoiPhuTrach}" var="data">
										<option value="${data.id}">${data.hovaten}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group row mt-4">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" name="trangthai" value="1"
										class="custom-control-input" id="trangthai" checked> <label
										class="custom-control-label" for="trangthai">Hoạt động</label>
								</div>
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary">
								<i class="far fa-save"></i> Lưu
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