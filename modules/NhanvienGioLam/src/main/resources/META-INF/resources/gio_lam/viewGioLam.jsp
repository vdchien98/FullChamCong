<%@ include file="../init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	box-shadow: 0 0 20px rgba(0, 0, 0, .2);
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

.dialog-ovelay .dialog .dialog-msg p {
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
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">
				Bảng giờ làm tháng 5
				<portlet:actionURL var="deleteNhanVienURL" name="deleteNhanVien" />
				<button type="button" class="btn btn-success"
					onclick="confirmCheckin(${userId});">
					<i class="fas fa-check-square"></i> Chấm công vào
				</button>
				<form id="check-in" class="float-right" action="" method="POST">

				</form>
				<button type="button" class="btn btn-success"
					onclick="confirmCheckout();">
					<i class="fas fa-check-square"></i> Chấm công ra
				</button>
				<form id="check-out" class="float-right" action="" method="POST">
				</form>

			</h4>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function Confirm(title, msg, okButton, cancelButton, userId) { /*change*/
    var $content =  "<div class='dialog-ovelay'>" +
                    "<div class='dialog'><header class='text-center'>" +
                     " <h3 class='text-white font-weight-bold'> " + title + " </h3> " +
                     "<i class='fa fa-close'></i>" +
                 "</header>" +
                 "<div class='dialog-msg'>" +
                 " <h4> " + msg + " </h4> " +
                 "<strong>Thời gian nhập mã xác nhận <span id='lblCount' class='text-danger'></span>&nbsp;giây.</strong> <br>" +
                 "<strong class='text-danger' id='ms-capcha'></strong>" +
                 "<label class='col-form-label font-weight-bold'>Nhập mã xác nhận <span class='text-danger'>(*)</span></label>" +
                 "<input type='number' name='popup-capcha' id='popup-capcha' class='form-control'  placeholder='Nhập mã xác nhận'>" +
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
        deleteForm.find('[name="<portlet:namespace />deleteUserId"]').val(userId);
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
function confirmCheckin(userId) {
	
	if(userId != 0) {
		var title = 'THÔNG BÁO';
		var msg = 'Bạn có chắc chắn muốn chấm công ?';
		var okButton = 'OK';
		var cancelButton = 'Hủy';
		console.log("userId là "+ userId)
		Confirm(title, msg, okButton, cancelButton, userId);
	}
}
</script>
