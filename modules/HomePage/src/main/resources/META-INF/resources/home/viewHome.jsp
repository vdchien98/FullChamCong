<%@page import="com.liferay.docs.chamcong.model.Users"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>



<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>



<portlet:renderURL var="addEntryURL">
	<portlet:param name="mvcPath" value="/home/viewForm.jsp"></portlet:param>
</portlet:renderURL>

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
span.font-weight-bold.text-warning.styleChucVuHome {
    margin: 0px 10px;
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
							<c:forEach var="user" items="${usersList}" varStatus="loop">
								<portlet:renderURL var="editURL">
									<portlet:param name="id" value="${user.id }" />
									<portlet:param name="mvcPath" value="/home/viewForm.jsp" />
								</portlet:renderURL>

								<tr>
									<th>${loop.index +1}</th>
									<th>
										<div class="row">
											<i class="fa fa-user-circle-o iconUserChucVu"
												aria-hidden="true"></i>
											<c:forEach var="itemChucVu" items="${selectChucVu}">
												<c:if test="${itemChucVu.id == user.chucvu_id}">
													<span class="font-weight-bold text-warning styleChucVuHome">
														${itemChucVu.name}</span>
												</c:if>
											</c:forEach>
											<span>${user.hovaten}</span>
										</div>
										<div class="row">
											<c:forEach var="itemPhongBan" items="${selectPhongBan}">
												<c:if test="${itemPhongBan.id == user.phongban_id}">
													<span class="text-warning mr-3"> Phòng/ban:
														${itemPhongBan.tenphong}</span>
												</c:if>
											</c:forEach>
										</div>
										<div class="row">
											<span class="mr-3">Tên đăng nhập: </span>${user.email}
											<c:choose>
												<c:when test="${user.ca_lam_toi == 1}">
													<span class="ml-5 text-info">Có làm ca tối</span>
												</c:when>
												<c:otherwise>
													<!-- không làm gì cả -->
												</c:otherwise>
											</c:choose>
											<span class="ml-5 text-primary">Có chấm công ngoài</span>
										</div>
										<div class="row">
											<span class="mr-3">Số ngày nghỉ phép trong năm: </span><span
												class="text-danger">${user.so_ngay_nghi_phep}</span>
										</div>

									</th>
									<th><c:choose>
											<c:when test="${user.trangthai == 1}">
												<span class="btn btn-success btn-sm">Hoạt động</span>
											</c:when>
											<c:otherwise>
												<span class="btn btn-light btn-sm">Không hoạt động</span></th>
									</c:otherwise>
									</c:choose>

									<th><a class="btn btn-success btn-circle mr-1 btn-sm"
										href="${editURL }"> <i class="fa fa-pencil"
											aria-hidden="true"> </i>
									</a>

										   <portlet:actionURL var="deleteNhanVienURL" name="deleteNhanVien" />
											<form name="deleteNhanVienForm" id="deleteNhanVienForm"
												method="POST" action="<%=deleteNhanVienURL%>">
												<input type="hidden" name="<portlet:namespace />deleteUserId" />
											
										           <button class="btn btn-danger btn-circle btn-sm" type="button"
														onclick="deleteNhanVien('${user.id}');">
														<i class="fa fa-trash" aria-hidden="true"></i>
												</button>
											</form>
									</th>
								</tr>
							</c:forEach>

						</tbody>
					</table>
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
        var deleteForm = $('#deleteNhanVienForm');
        deleteForm.find('[name="<portlet:namespace />deleteUserId"]').val(id);
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
function deleteNhanVien(id) {
	if(id != 0) {
		var title = 'THÔNG BÁO';
		var msg = 'Bạn có chắc chắn muốn xóa nhân viên này?';
		var okButton = 'OK';
		var cancelButton = 'Hủy';
		console.log("id là "+ id)
		Confirm(title, msg, okButton, cancelButton, id);
	}
}
</script>






