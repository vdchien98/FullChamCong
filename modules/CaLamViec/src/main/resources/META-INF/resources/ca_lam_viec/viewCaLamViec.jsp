<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../init.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</link>



<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị ca làm việc</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách ca làm việc Giờ hành chính</h4>
		</div>
		<div class="card-body">
		   <portlet:actionURL name="saveCaLamViec" var="formCaLamViecActionURL" />
			<form id="form1" method="POST"	action="<%=formCaLamViecActionURL.toString()%>"
						name="<portlet:namespace />fm">
				<table class="table">
					<thead>
						<tr>
							<th>Tên ca làm việc</th>
							<th>Giờ vào</th>
							<th style="width: 15%;">Vào trước</th>
							<th>Giờ ra</th>
							<th style="width: 15%;">Ra sau</th>
						</tr>
					</thead>
					<div>
						<tr>
							<td>Ca làm sáng</td>
							<td><input id="gio_vao_sang" type="time"
								class="form-control" name="<portlet:namespace />gio_vao_sang" required
								value="${calamviec.gio_vao_sang}"></td>
							<td>
								<div class="input-group mb-3">
									<input id="vao_truoc_sang" type="number" name="<portlet:namespace />vao_truoc_sang"
										required class="form-control"
										value="${calamviec.vao_truoc_sang}">
									<div class="input-group-append">
										<span class="input-group-text" id="basic-addon2">Phút</span>
									</div>
								</div>
							</td>
							<td><input id="gio_ra_sang" type="time" class="form-control"
								name="<portlet:namespace />gio_ra_sang" required
								value="${calamviec.gio_ra_sang}"></td>
							<td>
								<div class="input-group mb-3">
									<input id="ra_sau_sang" type="number" name="<portlet:namespace />ra_sau_sang"
										required class="form-control"
										value="${calamviec.ra_sau_sang}">
									<div class="input-group-append">
										<span class="input-group-text" id="basic-addon2">Phút</span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>Ca làm chiều</td>
							<td><input id="gio_vao_chieu" type="time"
								class="form-control" name="<portlet:namespace />gio_vao_chieu" required
								value="${calamviec.gio_vao_chieu}"></td>
							<td>
								<div class="input-group mb-3">
									<input id="vao_truoc_chieu" type="number"
										name="<portlet:namespace />vao_truoc_chieu" required class="form-control"
										value="${calamviec.vao_truoc_chieu}">
									<div class="input-group-append">
										<span class="input-group-text" id="basic-addon2">Phút</span>
									</div>
								</div>
							</td>
							<td><input id="gio_ra_chieu" type="time"
								class="form-control" name="<portlet:namespace />gio_ra_chieu" required
								value="${calamviec.gio_ra_chieu}"></td>
							<td>
								<div class="input-group mb-3">
									<input id="ra_sau_chieu" type="number" name="<portlet:namespace />ra_sau_chieu"
										required class="form-control"
										value="${calamviec.ra_sau_chieu}">
									<div class="input-group-append">
										<span class="input-group-text" id="basic-addon2">Phút</span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>Ca làm tối</td>
							<td><input id="gio_vao_toi" type="time" class="form-control"
								name="<portlet:namespace />gio_vao_toi" required
								value="${calamviec.gio_vao_toi}"></td>
							<td>
								<div class="input-group mb-3">
									<input id="vao_truoc_toi" type="number" name="<portlet:namespace />vao_truoc_toi"
										required class="form-control"
										value="${calamviec.vao_truoc_toi}">
									<div class="input-group-append">
										<span class="input-group-text" id="basic-addon2">Phút</span>
									</div>
								</div>
							</td>
							<td><input id="gio_ra_toi" type="time" class="form-control"
								name="<portlet:namespace />gio_ra_toi" required value="${calamviec.gio_ra_toi}">
							</td>
							<td>
								<div class="input-group mb-3">
									<input id="ra_sau_toi" type="number" name="<portlet:namespace />ra_sau_toi" required
										class="form-control" value="${calamviec.ra_sau_toi}">
									<div class="input-group-append">
										<span class="input-group-text" id="basic-addon2">Phút</span>
									</div>
								</div>
							</td>
						</tr>
					</div>
				</table>
				
			   <input id="CalamviecId" type="hidden" class="form-control"
									name="<portlet:namespace />idCalamviec" required autofocus
									placeholder="ID" 
									value="${calamviec.id}"
									>
				<div class="text-center pb-3">
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
					</button>
				</div>
			</form>

		</div>
	</div>
</div>