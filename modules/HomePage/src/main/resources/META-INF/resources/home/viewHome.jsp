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

<script type="text/javascript">
function redirecttoViewForm() {
    window.location.href = "/home/viewForm.jsp";
}
</script>



<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản trị nhân viên</h1>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">
				Danh sách nhân viên	
				<%-- 
				<aui:button-row >				
					<aui:button iconCssClass="icon-plus" onClick="<%=addEntryURL.toString()%>" value="Thêm mới"></aui:button>
				</aui:button-row>
				<button href="/home/viewForm" class="btn btn-success float-right">
					<i class="fa fa-plus" aria-hidden="true"></i> Thêm mới
				</button>
				
				 --%>
				
				 <button onclick="redirecttoViewForm()" class="btn btn-success float-right" ><i class="fa fa-plus" aria-hidden="true"></i>Thêm mới</button>
				  <% 
               // Xử lý sự kiện của button
               if (request.getParameter("redirectButton") != null) {
                          response.sendRedirect("/home/viewForm.jsp");
                                 }
                  %>
			</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-12">
					<table class="table table-hover" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th style="width: 5%;">STT</th>
								<th>Thông tin nhân viên</th>
								<th style="width: 10%;">Trạng thái</th>
								<th style="width: 15%;">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>1</th>
								<th>
									<div class="row">
										<i class="fa fa-user-circle-o" aria-hidden="true"></i> <span
											class="text-info mr-3"> Viên chức </span> <span>Vũ
											Đăng Chiến</span>
									</div>
									<div class="row">
										<span class="text-warning mr-3">Phòng/ban: </span> Nghiên cứu
										và phát triển phần mềm
									</div>
									<div class="row">
										<span class="mr-3">Tên đăng nhập: </span>vudangchien98@gmail.com
										<span class="ml-5 text-info">Có làm ca tối</span> <span
											class="ml-5 text-primary">Có chấm công ngoài</span>
									</div>
									<div class="row">
										<span class="mr-3">Số ngày nghỉ phép trong năm: </span><span
											class="text-danger">94</span>
									</div>

								</th>
								<th><span class="btn btn-success btn-sm">Hoạt động</span> <span
									class="btn btn-light btn-sm">Không hoạt động</span></th>
								<th><a class="btn btn-success btn-circle mr-1 btn-sm"
									href="{{ route('admin.nhan-vien.edit', $data->id) }}"> <i
										class="fa fa-pencil" aria-hidden="true"></i>
								</a>
									<button class="btn btn-danger btn-circle btn-sm" type="button"
										onclick="confirmDelete({{ $data->id }});">
										<i class="fa fa-trash" aria-hidden="true"></i>
									</button>

									<form id="delete-{{ $data->id }}" class="float-right"
										action="{{ route('admin.nhan-vien.destroy', $data->id) }}"
										method="POST">
										<%-- 
                                            @csrf
                                            @method('DELETE')  
                                          --%>
									</form></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</div>

