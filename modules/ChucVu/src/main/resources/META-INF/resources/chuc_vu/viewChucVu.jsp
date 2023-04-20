<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../init.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</link>



<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản trị chức vụ</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách chức vụ</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-7">
					<table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên chức vụ</th>
								<th>Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="chucvu" items="${chucVuList}" varStatus="loop"> 
								<tr>
									<td>${loop.index +1}</td>
									<td>
									     <span>${chucvu.name}</span> 
									     <br> 
									     <span class="font-weight-bold text-primary">Số nhân viên: 9</span> 
									     <br>
									     
									     <%--  
									     
									     <span class="font-weight-bold text-warning">Người phụ trách: ${user.hovaten}</span>
									     
										<c:forEach var="user" items="${usersLanhDao}">
											<c:if test="${user.id == phongban.nguoi_phu_trach}">
												
											</c:if>
										</c:forEach>
										--%>
									</td>
									<td>
										<button 
										     class="btn btn-success btn-circle mr-1 btn-sm"
											 type="button" data-toggle="tooltip" title="Sửa"
	                                         onclick= "editChucVu('${chucvu.id}', '${chucvu.name}', '${chucvu.role}');">
					
											<i class="fa fa-pencil" aria-hidden="true"></i>
										</button>
										 <portlet:actionURL var="deleteChucVuURL" name="deleteChucVu"/>
										 <form name="deleteChucVuForm" id="deleteChucVuForm" method="POST" action="<%=deleteChucVuURL%>">
											 <input type="hidden" name="<portlet:namespace />deleteChucVuId" value="${chucvu.id}" />
											 <button 
											    class="btn btn-danger btn-circle btn-sm" type="submit">
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
						<h5 class="modal-title text-uppercase font-weight-bold">Thêm mới chức vụ</h5>
					</div>
					<portlet:actionURL name="saveChucVu" var="formChucVuActionURL" />
					<form id="form1" method="POST"
						action="<%=formChucVuActionURL.toString()%>"
						name="<portlet:namespace />fm">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="tenchucvu" class="col-form-label text-md-right">
								      Tên chức vụ <span class="text-danger">(*)</span>
								</label>
							
								<input id="chucvuId" type="hidden" class="form-control"
									name="<portlet:namespace />idChucVu" required autofocus
									placeholder="ID" 
									value="${chucvuedit.id}"
									>
								 <input id="name" type="text" class="form-control inpputreset"
									name="<portlet:namespace />name" required autofocus
									placeholder="Nhập tên chức vụ " 
									${chucvuedit.name}
									>
							</div>
							<div class="form-group row mt-4">
								<label for="nguoi_phu_trach"
									class="col-form-label text-md-right">Nhóm quyền 
								</label> 
								<select class="form-control selectpicker inpputreset" 
								        id="roleChucVu"
									    name="<portlet:namespace />roleChucVu"
									    data-live-search="true" required>
									<option >[-- Chọn nhóm quyền --]</option>
									<option value="1">Nhân viên</option>
                                    <option value= "3">Lãnh đạo phòng</option>
                                    <option value= "6">Lãnh đạo đơn vị</option>
								</select>
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary"  onclick="clearForm(event)">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
							</button>
						</div>
					</form>

					<div>
						<strong class="text-danger">Chú ý:</strong> 
						<br> 
						<span>
							- Chỉ những chức vụ không có nhân viên có chức năng xóa. Chức vụ có nhân viên không có chức năng xóa.
							<br>
                            - Do vậy để xóa được chức vụ phải chuyển các nhân viên trong chức vụ đó sang chức vụ khác hoặc xóa những nhân viên đó..
                        </span>
					</div>
				</div>


			</div>
		</div>


	</div>
</div>

<script>	
	function editChucVu(id, name, role) {

  console.log("*****"+id)
  document.getElementById("chucvuId").value=id;
  document.getElementById("name").value=name;
  document.getElementById("roleChucVu").value=role;
 // document.getElementById("roleChucVu").value=roleChucVu;
}
</script>

