<%@ include file="../init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>


<%--
<aui:form name="loginForm"  method="post">
    <aui:input label="Email" name="email" type="email" required="true" />
    <aui:input label="Password" name="password" type="password" required="true" />
    <aui:button type="submit" value="Login" />
</aui:form>

 --%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/home/viewHome.jsp"></portlet:param>
</portlet:renderURL>



<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị nhân viên</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Thêm mới nhân viên
			</h4>
		</div>
		<div class="card-body">
		<portlet:actionURL name="saveNhanVien" var="formActionURL" />
			<form id="form" method="POST"
				action="<%=formActionURL.toString()%>" name="<portlet:namespace />fm">
				<div class="modal-body">
					<div class="form-group row mt-4">
						<label for="hovaten" class="col-form-label text-md-left col-md-2">Họ và tên 
						       <span class="text-danger">(*)</span>
						</label> 
						<input 
						id="hovaten" 
						type="text" 
						class="form-control col-md-9" 
						name="<portlet:namespace />hovaten" 
						required autofocus 
						placeholder="Nhập họ và tên"
						 value="${useredit.hovaten} "/>
					</div>
					<div class="form-group row mt-4">
						<label for="email" class="col-form-label text-md-left col-md-2">Email
							đăng nhập <span class="text-danger">(*)</span>
						</label> <input id="email" type="text" class="form-control col-md-9"
							name="<portlet:namespace />email" required autofocus
							placeholder="Nhập email đăng nhập"
							value="">
					</div>
					<div class="form-group row mt-4">
						<label for="zalo_id" class="col-form-label text-md-left col-md-2">Zalo
							id <span class="text-danger">(*)</span>
						</label> <input id="zalo_id" type="text" class="form-control col-md-9"
							name="<portlet:namespace />zalo_id" autofocus placeholder="Nhập zalo id"
							value="">
					</div>
					
					<%-- 
					<div class="form-group row mt-4">
						<label for="chucvu_id"
							class="col-form-label text-md-left col-md-2">Chúc vụ <span
							class="text-danger">(*)</span></label> <select
							class="custom-select col-md-6" id="chucvu_id" name="<portlet:namespace />chucvu_id"
							required>
							<option value="">[-- Chọn chức vụ --]</option>			
						</select>
					</div>
					<div class="form-group row mt-4">
						<label for="phongban_id"
							class="col-form-label text-md-left col-md-2">Phòng/ban <span
							class="text-danger">(*)</span></label> <select
							class="custom-select col-md-6" id="phongban_id"
							name="<portlet:namespace />phongban_id" required>
							<option value="">[-- Chọn phòng/ban --]</option> 
						</select>
					</div>
					<div class="form-group row mt-4">
						<label for="ca_lam_id"
							class="col-form-label text-md-left col-md-2">Ca làm việc
							<span class="text-danger">(*)</span>
						</label> <select class="custom-select col-md-6" id="ca_lam_id"
							name="<portlet:namespace />ca_lam_id" required>
							<option></option>
						</select>
					</div>
						--%>
					<div class="form-group row mt-4">
						<label for="so_ngay_nghi_phep"
							class="col-form-label text-md-left col-md-2">Số ngày nghỉ
							phép trong năm <span class="text-danger">(*)</span>
						</label> <input id="so_ngay_nghi_phep" type="number"
							class="form-control col-md-2" name="<portlet:namespace />so_ngay_nghi_phep"
							placeholder="Nhập số ngày nghỉ phép trong năm"
							value="">
					</div>
				
					<div class="form-group row mt-4 ml-5">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" name="<portlet:namespace />trangthai" value="1"
								class="custom-control-input" id="trangthai"> <label
								class="custom-control-label" for="trangthai">Hoạt động</label>
						</div>
						<div class="custom-control custom-checkbox ml-5">
							<input type="checkbox" name="<portlet:namespace />ca_lam_toi" value="1"
								class="custom-control-input" id="ca_lam_toi"  > <label
								class="custom-control-label" for="ca_lam_toi">Làm ca tối</label>
						</div>
						<div class="custom-control custom-checkbox ml-5">
							<input type="checkbox" name="<portlet:namespace />cham_cong_ngoai" value="1"
								class="custom-control-input" id="cham_cong_ngoai" > <label
								class="custom-control-label" for="cham_cong_ngoai">Chấm
								công ngoài</label>
						</div>
						<div class="custom-control custom-checkbox ml-5">
							<input type="checkbox" name="<portlet:namespace />phu_trach_phong" value="1"
								class="custom-control-input" id="phu_trach_phong"> 
							<label class="custom-control-label" for="phu_trach_phong">Phụ trách phòng</label>
						</div>
					</div>
				</div>
				<input type="hidden" value="${useredit.id}" class="custom-control-input" name="<portlet:namespace />id"/>
				<div class="modal-footer justify-content-center">
					<aui:button-row>
						<aui:button type="submit" name="submit" value="Lưu">
						</aui:button>
						<aui:button type="cancel" value='Quay Lại' onClick="<%=viewURL.toString()%>"></aui:button>
					</aui:button-row>
					
					<%--
					
					--%>
				</div>
			</form>
		</div>
	</div>
</div>
