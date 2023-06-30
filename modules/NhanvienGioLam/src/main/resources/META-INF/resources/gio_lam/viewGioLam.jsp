<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
i.icon-calendar {
	font-size: 35px;
	margin-left: 9px;
}

button.btn.btn-success.btn_chien {
	max-width: 200px;
}
</style>
<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Bảng giờ làm tháng
				6</h4>
		</div>
		<%
			String hienthichamcong = (String) request.getAttribute("hienthichamcong");
		%>
		<portlet:actionURL var="sendMaZaloURL" name="sendMaZalo" />
		<form id="check-in" class="float-right" action="<%=sendMaZaloURL%>"
			method="POST"></form>
		<form id="check-out" class="float-right" action="" method="POST">
		</form>
		<%-- 
		<div class="chamcongravao">
			<button type="button" class="btn btn-success"
				onclick="sendMaZaloAndConfirmCheckin(${userId});">
				<i class="fas fa-check-square"></i> Chấm công vào sáng
			</button>
			<button type="button" class="btn btn-success"
				onclick="sendMaZaloAndConfirmCheckin(${userId});">
				<i class="fas fa-check-square"></i> Chấm công ra sáng
			</button>

			<button type="button" class="btn btn-success"
				onclick="sendMaZaloAndConfirmCheckin(${userId});">
				<i class="fas fa-check-square"></i> Chấm công vào chiều
			</button>
			<button type="button" class="btn btn-success"
				onclick="sendMaZaloAndConfirmCheckin(${userId});">
				<i class="fas fa-check-square"></i> Chấm công ra chiều
			</button>
		</div>
			--%>




		<%
			if (hienthichamcong.equals("1")) {
		%>
		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien"
			onclick="handleAttendanceButton(1);">
			<i class="fas fa-check-square"></i> Chấm công vào sáng
		</button>
		<%
			} else if (hienthichamcong.equals("2")) {
		%>

		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien"
			onclick="handleAttendanceButton(2);">
			<i class="fas fa-check-square"></i> Chấm công ra sáng
		</button>
		<%
			} else if (hienthichamcong.equals("3")) {
		%>
		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien"
			onclick="handleAttendanceButton(3);">
			<i class="fas fa-check-square"></i> Chấm công vào chiều
		</button>
		<%
			} else if (hienthichamcong.equals("4")) {
		%>
		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien"
			onclick="handleAttendanceButton(4);">
			<i class="fas fa-check-square"></i> Chấm công ra chiều
		</button>
		<%
			}
		%>

		<%-- 
		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien" onclick="handleAttendanceButton();">
			<i class="fas fa-check-square"></i> Chấm công vào sáng
		</button>

	  --%>


		<portlet:actionURL var="xacthumazaloActionURL"
			name="xacthumazaloAction" />
		<form id="check_mazalo" class="float-right"
			action="<%=xacthumazaloActionURL%>" method="POST">
			<input type="hidden" name="<portlet:namespace />popupCapchaValue"
				id="popupCapchaValue" value=""> <input type="hidden"
				name="<portlet:namespace />statusHienThiNut" id="statusHienThiNut"
				value="">
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

	<style>
#timeTable td {
	text-align: center;
	vertical-align: middle;
}
</style>


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
				<tbody id="calendar-body">
					<form id="checkThangNamGiolam"   method="GET">
						<input type="hidden" id="selectedMonthInput" name="<portlet:namespace />selectedMonth"
							value="" />
					</form>


				</tbody>
			</table>

			,

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
	  }).on('changeDate', function(e) {
	    var selectedMonth = e.date.getMonth()+1; // Tháng được chọn (0-11)
	    var selectedYear = e.date.getFullYear(); // Năm được chọn
	    console.log("selectedMonth "+ selectedMonth)
	    $('#selectedMonthInput').val(selectedMonth);
	    $('#checkThangNamGiolam').submit();
	    
	  });
	});


</script>


<script>
  // Lấy thẻ input theo id
  var input = document.getElementById('year');

  // Gắn sự kiện click vào thẻ input
  input.addEventListener('click', function(event) {
    // Lấy giá trị của input khi người dùng click vào nó
    var value = event.target.value;

    // In giá trị của input ra console
    console.log(value);

    // Hoặc làm bất kỳ thao tác nào khác với giá trị của input ở đây
  });
</script>



<script>
  
 
  function handleAttendanceButton(status) {
	  var button = document.getElementById("attendanceButton");
	  console.log("status @@@@@@@@@@@@@@@@@ " + status);
	 // var button = document.getElementById("attendanceButton");
	 // var buttonText = button.textContent.trim();

	  switch (status) {
	    case 1:
	      toggleAttendanceButton(2); // Chuyển đổi trạng thái sang 2
	      break;
	    case 2:
	      toggleAttendanceButton(1); // Chuyển đổi trạng thái sang 1
	      break;
	    case 3:
	      toggleAttendanceButton(4); // Chuyển đổi trạng thái sang 4
	      break;
	    case 4:
	      toggleAttendanceButton(3); // Chuyển đổi trạng thái sang 3
	      break;
	    default:
	      break;
	  }
    sendMaZaloAndConfirmCheckin(${userId}, status);
    toggleAttendanceButton(status);
    localStorage.setItem("attendanceButtonStatus", status);
  }

  function toggleAttendanceButton(status) {
	  var button = document.getElementById("attendanceButton");
	  console.log("button " + button);

	  if (status === 1) {
	    button.innerHTML = '<i class="fas fa-check-square"></i> Chấm công ra sáng';
	    button.setAttribute("onclick", "handleAttendanceButton(2);");
	  } else if (status === 2) {
	    button.innerHTML = '<i class="fas fa-check-square"></i> Chấm công vào chiều';
	    button.setAttribute("onclick", "handleAttendanceButton(3);");
	  } else if (status === 3) {
	    button.innerHTML = '<i class="fas fa-check-square"></i> Chấm công ra chiều';
	    button.setAttribute("onclick", "handleAttendanceButton(4);");
	  } else if (status === 4) {
	    // Không có hành động nào
	  }
	}
  
  
  
  window.addEventListener("load", function () {
	  // Lấy trạng thái từ localStorage nếu có
	  var storedStatus = localStorage.getItem("attendanceButtonStatus");
	  if (storedStatus !== null) {
	    toggleAttendanceButton(parseInt(storedStatus));
	  }
	});
  
</script>
<script>
	function Confirm(title, msg, okButton, cancelButton, userId, statusHienThiNut) { /*change*/
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
					 console.log("statusHienThiNut ########33333333333444444444 "+ statusHienThiNut);
					 sosanhmazalo(popupCapchaValueOne,statusHienThiNut);
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

	
	function sendMaZaloAndConfirmCheckin(userId,statusHienThiNut) {
		console.log("statusHienThiNut ########33333333333 "+ statusHienThiNut);
	    sendMaZalo()
	      .then(function(response) {
	        // Xử lý phản hồi    từ hàm sendMaZalo nếu cần
	        
	        // Gọi hàm confirmCheckin
	      //  confirmCheckin(userId);
	        setTimeout(function() {
	            confirmCheckin(userId,statusHienThiNut);
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
	  
		function confirmCheckin(userId,statusHienThiNut) { 
			if (userId != 0) {
				var title = 'THÔNG BÁO';
				var msg = 'Bạn có chắc chắn muốn chấm công ?';
				var okButton = 'OK';
				var cancelButton = 'Hủy';
				console.log("userId là " + userId)
				Confirm(title, msg, okButton, cancelButton, userId,statusHienThiNut);
			}
		}
		
		
		// Khi thực hiện bước ấn Oki trong ô thông báo 
		function sosanhmazalo(popupCapchaValueOne,statusHienThiNutOne) {
			console.log("xin chao dang chien ***** "+ popupCapchaValueOne);
			 $('#popupCapchaValue').val(popupCapchaValueOne); 
			 console.log("xin chao dang chien statusHienThiNutOne ***** "+ statusHienThiNutOne);
			 $('#statusHienThiNut').val(statusHienThiNutOne); 
			 $('#check_mazalo').submit(); // Submit form có id là "check_mazalo"
			 
			
		}
	 
	
</script>