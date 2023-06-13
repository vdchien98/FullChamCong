<%@ include file="../init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.row.mb-3.chien {
	margin-left: 0;
}

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

			<h4 class="m-0 font-weight-bold text-primary">Bảng giờ làm tháng
				5</h4>
		</div>
		<%
			String hienthichamcong = (String) request.getAttribute("hienthichamcong");
		%>
		<portlet:actionURL var="sendMaZaloURL" name="sendMaZalo" />
		<form id="check-in" class="float-right" action="<%=sendMaZaloURL%>"
			method="POST"></form>
		<form id="check-out" class="float-right" action="" method="POST">
		</form>

		<button type="button" class="btn btn-success"
			onclick="sendMaZaloAndConfirmCheckin(${userId});">
			<i class="fas fa-check-square"></i> Chấm công vào sáng
		</button>
		<button type="button" class="btn btn-success"
			onclick="confirmCheckout();">
			<i class="fas fa-check-square"></i> Chấm công ra sáng
		</button>

		<button type="button" class="btn btn-success"
			onclick="sendMaZaloAndConfirmCheckin(${userId});">
			<i class="fas fa-check-square"></i> Chấm công vào chiều
		</button>
		<button type="button" class="btn btn-success"
			onclick="confirmCheckout();">
			<i class="fas fa-check-square"></i> Chấm công ra chiều
		</button>
		<%--  

				<%
					if (hienthichamcong.equals("1")) {
				%>
				<button type="button" class="btn btn-success"
					onclick="sendMaZaloAndConfirmCheckin(${userId});">
					<i class="fas fa-check-square"></i> Chấm công vào sáng
				</button>
				<%
					} else if (hienthichamcong.equals("2")) {
				%>
				</button>
				<button type="button" class="btn btn-success"
					onclick="confirmCheckout();">
					<i class="fas fa-check-square"></i> Chấm công ra sáng
				</button>
				<%
					} else if (hienthichamcong.equals("3")) {
				%>
				<button type="button" class="btn btn-success"
					onclick="sendMaZaloAndConfirmCheckin(${userId});">
					<i class="fas fa-check-square"></i> Chấm công vào chiều
				</button>
				<%
					} else if (hienthichamcong.equals("4")) {
				%>
				<button type="button" class="btn btn-success"
					onclick="sendMaZaloAndConfirmCheckin(${userId});">
					<i class="fas fa-check-square"></i> Chấm công ra chiều
				</button>
				<%
					}
				%>
				--%>

		<portlet:actionURL var="xacthumazaloActionURL"
			name="xacthumazaloAction" />
		<form id="check_mazalo" class="float-right"
			action="<%=xacthumazaloActionURL%>" method="POST">
			<input type="hidden" name="<portlet:namespace />popupCapchaValue"
				id="popupCapchaValue" value="">
		</form>


	</div>

	<div class="row mb-3 chien">
		<span class="btn btn-success">Đúng giờ</span> 
		<span class="btn btn-warning">Đi muộn/Về sớm</span> 
		<span class="btn btn-secondary">Không chấm công vào/ra</span> 
		<span class="btn btn-primary">Nghỉ phép/Nghỉ lễ</span> 
		<span class="btn btn-info">Xin chấm công</span> 
		<span class="btn btn-danger">Nghỉ không phép</span> 
		<span class="btn btn-light">M: số lần đi muộn, S: số lần về sớm</span>
	</div>


    <ul class="nav nav-tabs mb-2" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link text-dark active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Chấm công của tôi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-dark" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Chấm công của phòng/đơn vị</a>
                </li>
    </ul>



	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="home" role="tabpanel"
			aria-labelledby="home-tab">
			<table class="table table-bordered">
				<thead>
					<tr class="text-center text-white">
						<th style="padding: 0;" class="bg-info">T2</th>
						<th style="padding: 0;" class="bg-info">T3</th>
						<th style="padding: 0;" class="bg-info">T4</th>
						<th style="padding: 0;" class="bg-info">T5</th>
						<th style="padding: 0;" class="bg-info">T6</th>
						<th style="padding: 0;" class="bg-warning">T7</th>
						<th style="padding: 0;" class="bg-warning">CN</th>
					</tr>
				</thead>
				<tr>
					<td class="text-center" style="padding: 0;"></td>
					<td class="text-center"
						style="margin: 1px; padding-left: 4px; padding-right: 4px;"
						data-toggle="tooltip" title="Nghỉ lễ">Day<br>
						<div class="bg-primary border" style="height: 10px">&nbsp;</div>
						<div class="bg-primary border" style="height: 10px">&nbsp;</div>
					</td>
					<td class="text-center"
						style="margin: 1px; padding-left: 4px; padding-right: 4px;">Day
						1<br>
						<div class="bg-primary border" style="height: 10px">&nbsp;</div>
						<div class="bg-primary border" style="height: 10px">&nbsp;</div>
					</td>
					<td class="text-center"
						style="margin: 1px; padding-left: 4px; padding-right: 4px;"
						data-toggle="tooltip" title="{{ $nghi_phep->chon_ly_do }}">
						Day 2 <br>
						<div class="bg-primary border" style="height: 10px">&nbsp;</div>
						<div class="bg-primary border" style="height: 10px">&nbsp;</div>
					</td>
					<td class="text-center"
						style="margin: 1px; padding-left: 4px; padding-right: 4px;"
						data-toggle="tooltip" title="{{ $xin_cham_cong->chon_ly_do }}">
						Day 3 <br>
						<div class="bg-info border" style="height: 10px">&nbsp;</div>
						<div class="bg-info border" style="height: 10px">&nbsp;</div>
					</td>
					<td class="text-center"
						style="margin: 1px; padding-left: 4px; padding-right: 4px;">
						Day 4<br>
						<div class="bg-info border" style="height: 10px">&nbsp;</div>
						<div class="bg-info border" style="height: 10px">&nbsp;</div>
						<div class="border bg-warning" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca tối <br> Giờ vào: {{ $check_in_toi }} | Giờ ra: {{ $check_out_toi }}">&nbsp;</div>

						<div class="border bg-success" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca tối <br> Giờ vào: {{ $check_in_toi }} | Giờ ra: {{ $check_out_toi }}">&nbsp;</div>

					</td>
					<td class="text-center"
						style="margin: 1px; padding-left: 4px; padding-right: 4px;">
						Day 5 <br>
						<div class="bg-warning border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca sáng <br> Giờ vào: {{ $check_in_sang }} | Giờ ra: {{ $check_out_sang }}">&nbsp;</div>
						<div class="bg-success border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca sáng <br> Giờ vào: {{ $check_in_sang }} | Giờ ra: {{ $check_out_sang }}">&nbsp;</div>

						<div class="bg-secondary border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca sáng <br> Giờ vào: {{ $check_in_sang }} | Giờ ra: {{ $check_out_sang }}">&nbsp;</div>

						<div class="bg-success border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca sáng <br> Giờ vào: {{ $check_in_sang }} | Giờ ra: {{ $check_out_sang }}">&nbsp;</div>

						<div class="bg-primary border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="{{ $nghi_phep_nua_ngay->chon_ly_do }}">&nbsp;</div>
						<div class="bg-info border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="{{ $xin_cham_cong_nua_ngay->chon_ly_do }}">&nbsp;</div>
						<div class="bg-secondary border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca sáng <br> Giờ vào: {{ $check_in_sang }} | Giờ ra: {{ $check_out_sang }}">&nbsp;</div>
						<div class="bg-danger border" style="height: 10px"
							data-toggle="tooltip" data-html="true" title="Nghỉ không phép">&nbsp;</div>
						<div class="bg-warning border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca chiều <br> Giờ vào: {{ $check_in_chieu }} | Giờ ra: {{ $check_out_chieu }}">&nbsp;</div>
						<div class="bg-success border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca chiều <br> Giờ vào: {{ $check_in_chieu }} | Giờ ra: {{ $check_out_chieu }}">&nbsp;</div>

						<div class="bg-secondary border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca chiều <br> Giờ vào: {{ $check_in_chieu }} | Giờ ra: {{ $check_out_chieu }}">&nbsp;</div>

						<div class="bg-success border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca chiều <br> Giờ vào: {{ $check_in_chieu }} | Giờ ra: {{ $check_out_chieu }}">&nbsp;</div>

						<div class="bg-primary border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="{{ $nghi_phep_nua_ngay->chon_ly_do }}">&nbsp;</div>

						<div class="bg-info border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="{{ $xin_cham_cong_nua_ngay->chon_ly_do }}">&nbsp;</div>

						<div class="bg-secondary border" style="height: 10px"
							data-toggle="tooltip" data-html="true"
							title="Ca chiều <br> Giờ vào: {{ $check_in_chieu }} | Giờ ra: {{ $check_out_chieu }}">&nbsp;</div>

						<div class="bg-danger border" style="height: 10px"
							data-toggle="tooltip" data-html="true" title="Nghỉ không phép">&nbsp;</div>

					</td>
				</tr>
				</tbody>
			</table>
		</div>


	</div>




</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>



<script>
	function Confirm(title, msg, okButton, cancelButton, userId) { /*change*/
		var $content = "<div class='dialog-ovelay'>"
				+ "<div class='dialog'><header class='text-center'>"
				+ " <h3 class='text-white font-weight-bold'> "
				+ title
				+ " </h3> "
				+ "<i class='fa fa-close'></i>"
				+ "</header>"
				+ "<div class='dialog-msg'>"
				+ " <h4> "
				+ msg
				+ " </h4> "
				+ "<strong>Thời gian nhập mã xác nhận <span id='lblCount' class='text-danger'></span>&nbsp;giây.</strong> <br>"
				+ "<strong class='text-danger' id='ms-capcha'></strong>"
				+ "<label class='col-form-label font-weight-bold'>Nhập mã xác nhận <span class='text-danger'>(*)</span></label>"
				+ "<input type='number' name='popup-capcha' id='popup-capcha' class='form-control'  placeholder='Nhập mã xác nhận'>"
				+ "</div>"
				+
				"<footer>"
				+ "<div class='controls text-center'>"
				+ " <button class='button button-danger doAction'>"
				+ okButton
				+ "</button> "
				+ " <button class='button button-default cancelAction'>"
				+ cancelButton
				+ "</button> "
				+ "</div>"
				+ "</footer>"
				+ "</div>" + "</div>";
		$('body').prepend($content);
		$('.doAction').click(
				function(event) {
					 var popupCapchaValueOne = $('#popup-capcha').val();
					 console.log("xin chao dang chien *****111222222"+ popupCapchaValueOne);
					 sosanhmazalo(popupCapchaValueOne);
					$(this).parents('.dialog-ovelay').fadeOut(500, function() {
						$(this).remove();
					});
				});
		$('.cancelAction, .fa-close').click(function() {
			$(this).parents('.dialog-ovelay').fadeOut(500, function() {
				$(this).remove();
			});
		});
	}

	
	function sendMaZaloAndConfirmCheckin(userId) {
	    sendMaZalo()
	      .then(function(response) {
	        // Xử lý phản hồi    từ hàm sendMaZalo nếu cần
	        
	        // Gọi hàm confirmCheckin
	      //  confirmCheckin(userId);
	        
	        
	        setTimeout(function() {
	            confirmCheckin(userId);
	          }, 100); // 30000 milliseconds = 30 seconds
	      })
	      .catch(function(error) {
	        console.log(error);
	      });
	  }

	  function sendMaZalo() {
	    return fetch('<%=sendMaZaloURL%>', {
	      method: 'POST',
	      body: JSON.stringify({}),
	      headers: {
	        'Content-Type': 'application/json'
	      }
	    })
	      .then(function(response) {
	        if (response.ok) {
	          return response.text();
	        }
	        throw new Error('Lỗi khi gửi yêu cầu đến hàm sendMaZalo');
	      });
	  }
	  
		function confirmCheckin(userId) { 
			if (userId != 0) {
				var title = 'THÔNG BÁO';
				var msg = 'Bạn có chắc chắn muốn chấm công ?';
				var okButton = 'OK';
				var cancelButton = 'Hủy';
				console.log("userId là " + userId)
				Confirm(title, msg, okButton, cancelButton, userId);
			}
		}
		
		function sosanhmazalo(popupCapchaValueOne) {
			console.log("xin chao dang chien ***** "+ popupCapchaValueOne);
			 $('#popupCapchaValue').val(popupCapchaValueOne); 
			 $('#check_mazalo').submit(); // Submit form có id là "check_mazalo"
			
		}
		
	
	
</script>
