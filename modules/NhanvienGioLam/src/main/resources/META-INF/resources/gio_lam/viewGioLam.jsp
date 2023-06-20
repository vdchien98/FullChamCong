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
		<div class="chamcongravao">
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
		</div>


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

	<div class="form-group row">
		<form class="pl-5" id="search-year" action="">
			<div class="form-group row">
				<div class="form-group row">
					<label class="col-form-label font-weight-bold text-info mr-3">Năm</label>
					<input type="text" class="form-control datepicker col-md-6 ml-6"
						name="year" id="year" placeholder="Năm" value="2023">
				</div>
			</div>
		</form>
	</div>






	<div class="row mb-3 chien">
		<span class="btn btn-success">Đúng giờ</span> <span
			class="btn btn-warning">Đi muộn/Về sớm</span> <span
			class="btn btn-secondary">Không chấm công vào/ra</span> <span
			class="btn btn-primary">Nghỉ phép/Nghỉ lễ</span> <span
			class="btn btn-info">Xin chấm công</span> <span
			class="btn btn-danger">Nghỉ không phép</span> <span
			class="btn btn-light">M: số lần đi muộn, S: số lần về sớm</span>
	</div>


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
				<tbody>
					<tr>
						<%
							java.util.Calendar calendar = java.util.Calendar.getInstance();
							calendar.set(java.util.Calendar.YEAR, 2023); // Năm 2023
							calendar.set(java.util.Calendar.MONTH, 5); // Tháng 6 (0-11)
							calendar.set(java.util.Calendar.DAY_OF_MONTH, 1);

							int lastDayOfMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

							while (calendar.get(java.util.Calendar.DAY_OF_MONTH) <= lastDayOfMonth) {
								int dayOfMonth = calendar.get(java.util.Calendar.DAY_OF_MONTH);
								int month = calendar.get(java.util.Calendar.MONTH) + 1; // Tháng (0-11)
								int year = calendar.get(java.util.Calendar.YEAR);

								String formattedDate = String.format("%02d/%02d/%04d", dayOfMonth, month, year);
						%>
						<td class="text-center" style="padding: 0;"><%=formattedDate%><br>
							<div class="bg-primary border" style="height: 10px">&nbsp;</div>
							<div class="bg-primary border" style="height: 10px">&nbsp;</div>
						</td>
						<%
							calendar.add(java.util.Calendar.DAY_OF_MONTH, 1); // Tăng ngày lên 1
								int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
								if (dayOfWeek == java.util.Calendar.SUNDAY
										&& calendar.get(java.util.Calendar.DAY_OF_MONTH) <= lastDayOfMonth) {
						%>
					</tr>
					<tr>
						<!-- Kết thúc hàng trước ngày Chủ nhật -->
						<%
							}
						%>
						<%
							}
						%>
					</tr>
				</tbody>
			</table>


		</div>
	</div>
</div>
<script>
!(function($){

	$.fn.datepicker.dates['vi'] = {

		days: ["Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy", "Chủ nhật"],

		daysShort: ["CN", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "CN"],

		daysMin: ["CN", "T2", "T3", "T4", "T5", "T6", "T7", "CN"],

		months: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"],

		monthsShort: ["Th1", "Th2", "Th3", "Th4", "Th5", "Th6", "Th7", "Th8", "Th9", "Th10", "Th11", "Th12"],

		today: "Hôm nay",

		clear: "Xóa",

		format: "dd/mm/yyyy"

	};

}(jQuery));
$(document).ready(function() {
    $('.datepicker').datepicker({
        language: 'vi',
        format: "mm/yyyy",
        startView: "months", 
        minViewMode: "months"
    });
}); 


// Lấy các ngày trong tháng theo máy 
//Lấy ngày đầu tiên của tháng hiện tại
var currentDate = new Date();
var firstDayOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);

// Lấy ngày cuối cùng của tháng hiện tại
var lastDayOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);

// Tạo danh sách các ngày trong tháng bao gồm cả thứ
var daysInMonth = [];
for (var date = firstDayOfMonth; date <= lastDayOfMonth; date.setDate(date.getDate() + 1)) {
  var day = ("0" + date.getDate()).slice(-2); // Định dạng số ngày thành "dd"
  var month = ("0" + (date.getMonth() + 1)).slice(-2); // Định dạng số tháng thành "mm"
  var year = date.getFullYear(); // Lấy năm hiện tại
  var weekday = date.toLocaleDateString("vi-VN", { weekday: "long" }); // Lấy tên thứ tiếng Việt
  var formattedDate = day + "/" + month + "/" + year + " (" + weekday + ")"; // Kết hợp thành "dd/mm/yyyy (Thứ)"
  daysInMonth.push(formattedDate);
}

// In ra danh sách các ngày trong tháng bao gồm cả thứ
console.log(daysInMonth);






</script>

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





