<%@page import="com.liferay.docs.chamcong.model.Users"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<portlet:renderURL var="addEntryURL">
	<portlet:param name="mvcPath" value="/home/viewForm.jsp"></portlet:param>
</portlet:renderURL>

<style>
.card-header.py-3.headerDSNhanVien {
	display: flex;
	justify-content: space-between;
}
</style>


<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị nhân viên</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3 headerDSNhanVien">
			<h4 class="m-0 font-weight-bold text-primary ">Danh sách nhân
				viên</h4>
			<aui:button-row>
				<aui:button iconCssClass="icon-plus"
					onClick="<%=addEntryURL.toString()%>" value="Thêm mới"></aui:button>
			</aui:button-row>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th style="width: 5%;">STT</th>
								<th>Thông tin nhân viên</th>
								<th style="width: 10%;">Trạng thái</th>
								<th style="width: 15%;">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${usersList}">
							     <portlet:renderURL var="editURL">
												<portlet:param name="id" value="${user.id }" />
												<portlet:param name="mvcPath" value="/home/viewForm.jsp" />
								 </portlet:renderURL>

								<tr>
									<th>${user.id}</th>
									<th>
										<div class="row">
											<i class="fa fa-user-circle-o" aria-hidden="true"></i> <span
												class="text-info mr-3"> Viên chức </span> <span>${user.hovaten}</span>
										</div>
										<div class="row">
										
											<span class="text-warning mr-3">Phòng/ban: </span> Nghiên cứu
											và phát triển phần mềm
										</div>
										<div class="row">
											<span class="mr-3">Tên đăng nhập: </span>${user.email} <span
												class="ml-5 text-info">Có làm ca tối</span> <span
												class="ml-5 text-primary">Có chấm công ngoài</span>
										</div>
										<div class="row">
											<span class="mr-3">Số ngày nghỉ phép trong năm: </span><span
												class="text-danger">94</span>
										</div>

									</th>
									<th><span class="btn btn-success btn-sm">Hoạt động</span>
										<span class="btn btn-light btn-sm">Không hoạt động</span></th>
									<th>
									<a class="btn btn-success btn-circle mr-1 btn-sm" href="${editURL }"> 
										<i class="fa fa-pencil" aria-hidden="true"> 
										</i>
									</a>
									 <portlet:actionURL var="deleteNhanVienURL" name="deleteNhanVien"/>
										<form name="deleteNhanVienForm" id="deleteNhanVienForm" method="POST" action="<%=deleteNhanVienURL%>">
											 <input type="hidden" name="<portlet:namespace />deleteUserId" value="${user.id}" />
											<button 
											    class="btn btn-danger btn-circle btn-sm"
												type="submit" 
												>
												<i class="fa fa-trash" aria-hidden="true"></i>
											</button>
											

										</form></th>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</div>

