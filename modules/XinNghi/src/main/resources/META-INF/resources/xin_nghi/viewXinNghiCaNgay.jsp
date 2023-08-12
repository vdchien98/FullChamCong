<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Thêm mới xin nghỉ
			</h4>
		</div>
		<div class="card-body">
		     <portlet:actionURL name="saveXinNghiCaNgay" var="saveXinNghiCaNgayURL" />
			<form id="form" method="POST" action="<%=saveXinNghiCaNgayURL.toString()%>" name="<portlet:namespace />fm">
					<input type="hidden" name="_token" value="Pvy5o2oZs3Ge5350sE2qrbpoi3aVBuxT7HXq5DKK">
					<div class="form-group row">
						<label for="tu_ngay" class="col-form-label text-md-left col-md-2 font-weight-bold">Từ ngày <span class="text-danger">(*)</span>
						</label> 
						    <input id="tu_ngay" type="date" class="form-control col-md-3"
						           name="<portlet:namespace />tu_ngay" required="" value="">
						 <label for="den_ngay" class="col-form-label text-md-center col-md-2 font-weight-bold">Đếnngày <span class="text-danger">(*)</span>
						</label> 
						     <input id="den_ngay" type="date" class="form-control col-md-3" name="<portlet:namespace />den_ngay" required="" value="">
					</div>
					<div class="form-group row">
						<label for="chon_ly_do" class="col-form-label text-md-left col-md-2 font-weight-bold">Chọn lý do <span class="text-danger">(*)</span>
						</label> 
						   <select name="<portlet:namespace />chon_ly_do" id="chon_ly_do"
								   class="form-control col-md-4" required="">
							<option value="Nghỉ phép">Nghỉ phép</option>
							<!-- <option value="Đi công tác" >Đi công tác</option> -->
							<!-- <option value="Đi đào tạo" >Đi đào tạo</option> -->
						   </select>
					</div>
					<div class="form-group row">
						<label for="ly_do"
							class="col-form-label text-md-left col-md-2 font-weight-bold">Nội
							dung <span class="text-danger">(*)</span>
						</label>
						<textarea name="<portlet:namespace />ly_do" id="ly_do" class="form-control col-md-9"
							required="" placeholder="Nhập lý do xin nghỉ" rows="5"></textarea>
					</div>
					<div class="modal-footer justify-content-center">
						<a href="" class="btn btn-light" onclick="window.location.href='/nhanvien/xin-nghi'"><i class="fa fa-undo" aria-hidden="true"></i> Quay lại </a>
						<button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu</button>
					</div>
			</form>
		</div>
	</div>
</div>