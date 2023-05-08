<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../init.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</link>
<style>
i.fa.fa-user-circle-o {
	margin-top: 3px;
}

.styleChucVu {
	margin: 0px 10px;
}

.card-header.py-3.headerDSNhanVien {
	display: flex;
	justify-content: space-between;
}



/* thông báo xóa nhân viên*/

.dialog-ovelay {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.50);
    z-index: 999999
}
.dialog-ovelay .dialog {
    position: fixed;
    top: 20%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 400px;
    margin: 300px auto 0;
    background-color: #fff;
    box-shadow: 0 0 20px rgba(0,0,0,.2);
    border-radius: 3px;
    overflow: hidden
}
.dialog-ovelay .dialog header {
    padding: 10px 8px;
    background-color: #4e73df;
    border-bottom: 1px solid #e5e5e5
}
.dialog-ovelay .dialog header h3 {
    font-size: 14px;
    margin: 0;
    color: #555;
    display: inline-block
}
.dialog-ovelay .dialog header .fa-close {
    float: right;
    color: #c4c5c7;
    cursor: pointer;
    transition: all .5s ease;
    padding: 0 2px;
    border-radius: 1px    
}
.dialog-ovelay .dialog header .fa-close:hover {
    color: #b9b9b9
}
.dialog-ovelay .dialog header .fa-close:active {
    box-shadow: 0 0 5px #673AB7;
    color: #a2a2a2
}
.dialog-ovelay .dialog .dialog-msg {
    padding: 12px 10px
}
.dialog-ovelay .dialog .dialog-msg p{
    margin: 0;
    font-size: 15px;
    color: #333
}
.dialog-ovelay .dialog footer {
    border-top: 1px solid #e5e5e5;
    padding: 8px 10px
}
.dialog-ovelay .dialog footer .controls {
    direction: rtl
}
.dialog-ovelay .dialog footer .controls .button {
    padding: 5px 15px;
    border-radius: 3px
}


</style>


<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800 font-weight-bold text-uppercase">Quản
		trị chức vụ</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách chức vụ</h4>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-md-7">
					<table class="table table-bordered table-hover" id="dataTable"
						width="100%" cellspacing="0">
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
									<td><span>${chucvu.name}</span> <br> <span
										class="font-weight-bold text-primary">Số nhân viên: 9</span> <br>

										<%--  
									     
									     <span class="font-weight-bold text-warning">Người phụ trách: ${user.hovaten}</span>
									     
										<c:forEach var="user" items="${usersLanhDao}">
											<c:if test="${user.id == phongban.nguoi_phu_trach}">
												
											</c:if>
										</c:forEach>
										--%></td>
									<td>
										<button class="btn btn-success btn-circle mr-1 btn-sm"
											type="button" data-toggle="tooltip" title="Sửa"
											onclick="editChucVu('${chucvu.id}', '${chucvu.name}', '${chucvu.role}');">

											<i class="fa fa-pencil" aria-hidden="true"></i>
										</button> <portlet:actionURL var="deleteChucVuURL" name="deleteChucVu" />
										<form name="deleteChucVuForm" id="deleteChucVuForm"
											method="POST" action="<%=deleteChucVuURL%>">
											<input type="hidden"
												name="<portlet:namespace />deleteChucVuId"
												value="${chucvu.id}" />
												
												
												  <button class="btn btn-danger btn-circle btn-sm" type="button"
														onclick="deleteChucVu('${chucvu.id}');">
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
							mới chức vụ</h5>
					</div>
					<portlet:actionURL name="saveChucVu" var="formChucVuActionURL" />
					<form id="form1" method="POST"
						action="<%=formChucVuActionURL.toString()%>"
						name="<portlet:namespace />fm">
						<div class="modal-body">
							<div class="form-group row mt-4">
								<label for="tenchucvu" class="col-form-label text-md-right">
									Tên chức vụ <span class="text-danger">(*)</span>
								</label> <input id="chucvuId" type="hidden" class="form-control"
									name="<portlet:namespace />idChucVu" required autofocus
									placeholder="ID" value="${chucvuedit.id}"> <input
									id="name" type="text" class="form-control inpputreset"
									name="<portlet:namespace />name" required autofocus
									placeholder="Nhập tên chức vụ " ${chucvuedit.name}>
							</div>
							<div class="form-group row mt-4">
								<label for="nguoi_phu_trach"
									class="col-form-label text-md-right">Nhóm quyền </label> <select
									class="form-control selectpicker inpputreset" id="roleChucVu"
									name="<portlet:namespace />roleChucVu" data-live-search="true"
									required >
									<option>[-- Chọn nhóm quyền --]</option>
									<option value="1" >Nhân viên</option>
									<option value="3" >Lãnh đạo phòng</option>
									<option value="6" >Lãnh đạo đơn vị</option>
								</select>
							</div>
						</div>
						<div class="modal-footer justify-content-center">
							<button type="submit" class="btn btn-primary"
								onclick="clearForm(event)">
								<i class="fa fa-floppy-o" aria-hidden="true"></i> Lưu
							</button>
						</div>
					</form>

					<div>
						<strong class="text-danger">Chú ý:</strong> <br> <span>
							- Chỉ những chức vụ không có nhân viên có chức năng xóa. Chức vụ
							có nhân viên không có chức năng xóa. <br> - Do vậy để xóa
							được chức vụ phải chuyển các nhân viên trong chức vụ đó sang chức
							vụ khác hoặc xóa những nhân viên đó..
						</span>
					</div>
				</div>


			</div>
		</div>


	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function Confirm(title, msg, okButton, cancelButton, id) { /*change*/
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> " + title + " </h3> " +
                     "<i class='fa fa-close'></i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                     " <h4> " + msg + " </h4> " +
                 "</div>" +
                 "<footer>" +
                     "<div class='controls text-center'>" +
                         " <button class='button button-danger doAction'>" + okButton + "</button> " +
                         " <button class='button button-default cancelAction'>" + cancelButton + "</button> " +
                     "</div>" +
                 "</footer>" +
              "</div>" +
            "</div>";
    $('body').prepend($content);
    $('.doAction').click(function (event){ 
        var deleteForm = $('#deleteChucVuForm');
        deleteForm.find('[name="<portlet:namespace />deleteChucVuId"]').val(id);
        deleteForm.submit();     
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
        });
    });
    $('.cancelAction, .fa-close').click(function () {
        $(this).parents('.dialog-ovelay').fadeOut(500, function () {
            $(this).remove();
      });
    });
}
function deleteChucVu(id) {
	if(id != 0) {
		var title = 'THÔNG BÁO';
		var msg = 'Bạn có chắc chắn muốn xóa Chức vụ này?';
		var okButton = 'OK';
		var cancelButton = 'Hủy';
		console.log("id là "+ id)
		Confirm(title, msg, okButton, cancelButton, id);
	}
}
</script>
<script>
	function editChucVu(id, name, role) {
		var modalTitle = document.querySelector(".modal-title");
		if (id > 0) {
			modalTitle.textContent = 'Chỉnh sửa chức vụ';
		} else {
			modalTitle.textContent = 'Thêm mới chức vụ';
		}
		console.log("*****" + id)
		document.getElementById("chucvuId").value = id;
		document.getElementById("name").value = name;
		document.getElementById("roleChucVu").value = role;
	}
</script>



