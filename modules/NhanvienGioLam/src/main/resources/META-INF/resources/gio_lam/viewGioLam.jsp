<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp"%>
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
			class="btn btn-success btn_chien" onclick="handleAttendanceButton();">
			<i class="fas fa-check-square"></i> Chấm công vào sáng
		</button>
		<%
			} else if (hienthichamcong.equals("2")) {
		%>

		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien" onclick="handleAttendanceButton();">
			<i class="fas fa-check-square"></i> Chấm công ra sáng
		</button>
		<%
			} else if (hienthichamcong.equals("3")) {
		%>
		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien" onclick="handleAttendanceButton();">
			<i class="fas fa-check-square"></i> Chấm công vào chiều
		</button>
		<%
			} else if (hienthichamcong.equals("4")) {
		%>
		<button id="attendanceButton" type="button"
			class="btn btn-success btn_chien" onclick="handleAttendanceButton();">
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
				id="popupCapchaValue" value="">
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

	<div class="form-group row chien94">
		<form class="pl-5" id="search-year" action="">
			<div class="form-group row">
				<div class="form-group row ">
					<input type="text" class="form-control datepicker col-md-6 ml-6"
						name="year" id="year" placeholder="Năm" value="2023"> <i
						class="icon-calendar"></i>
				</div>
			</div>
		</form>
	</div>
	<div class="tab-content" id="myTabContent">
		<table id="timeTable">
			<thead>

				<tr>
					<th>Thứ 2</th>
					<th>Thứ 3</th>
					<th>Thứ 4</th>
					<th>Thứ 5</th>
					<th>Thứ 6</th>
					<th>Thứ 7</th>
					<th>Chủ nhật</th>
				</tr>
			</thead>
			<tbody id="timeTableBody">
			</tbody>
		</table>
	</div>
	<script>
	// Lấy ngày đầu tiên của tháng hiện tại
	var currentDate = new Date();
	var firstDay = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);

	// Lấy số ngày trong tháng
	var lastDay = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);
	var numDays = lastDay.getDate();

	// Tính toán vị trí ngày đầu tiên trong tuần
	var firstDayIndex = firstDay.getDay()-1; // (0: Chủ nhật, 1: Thứ 2, ..., 6: Thứ 7)
	console.log("firstDayIndex " + firstDayIndex);

	// Tạo bảng thời gian
	var timeTableBody = document.getElementById("timeTableBody");
	var row = document.createElement("tr");

	// Thêm các ô trống cho các ngày trước ngày đầu tiên trong tuần
	for (var i = 0; i < firstDayIndex; i++) {
		var emptyCell = document.createElement("td");
		row.appendChild(emptyCell);
	}

	// Thêm các ô với ngày trong tháng
	for (var day = 1; day <= numDays; day++) {
		var cell = document.createElement("td");
		cell.textContent = day;
		row.appendChild(cell);

		// Kiểm tra xem đã đến ngày cuối tuần (Chủ nhật) chưa
		if ((firstDayIndex + day) % 7 === 0) {
			timeTableBody.appendChild(row);
			row = document.createElement("tr");
		}
	}

	// Thêm các ô trống cho các ngày sau ngày cuối cùng trong tuần
	var remainingDays = 7 - ((firstDayIndex + numDays) % 7);
	for (var i = 0; i < remainingDays; i++) {
		var emptyCell = document.createElement("td");
		row.appendChild(emptyCell);
	}

	timeTableBody.appendChild(row);
</script>




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
  
 
  function handleAttendanceButton() {
	  var button = document.getElementById("attendanceButton");
	  var buttonText = button.textContent.trim();

	  switch (buttonText) {
	    case "Chấm công vào sáng":
	      attendanceStatus = "vào sáng";
	      break;
	    case "Chấm công ra sáng":
	      attendanceStatus = "ra sáng";
	      break;
	    case "Chấm công vào chiều":
	      attendanceStatus = "vào chiều";
	      break;
	    case "Chấm công ra chiều":
	      attendanceStatus = "ra chiều";
	      break;
	    default:
	      attendanceStatus = "";
	      break;
	  }
    sendMaZaloAndConfirmCheckin(${userId});
    toggleAttendanceButton();
  }

  function toggleAttendanceButton() {
    var button = document.getElementById("attendanceButton");
    console.log("button "+ button);

    if (attendanceStatus === "vào sáng") {
      button.innerHTML = '<i class="fas fa-check-square"></i> Chấm công ra sáng';
      attendanceStatus = "ra sáng";
      button.style.backgroundColor = "orange";
    } else if (attendanceStatus === "ra sáng") {
     // button.innerHTML = '<i class="fas fa-check-square"></i> Chấm công vào chiều';
     // attendanceStatus = "vào chiều";
        button.style.display = "none"; // Ẩn nút chấm công ra sáng
    } else if (attendanceStatus === "vào chiều") {
      button.innerHTML = '<i class="fas fa-check-square"></i> Chấm công ra chiều';
      attendanceStatus = "ra chiều";
      button.style.backgroundColor = "orange";
    } else if (attendanceStatus === "ra chiều") {
    	 button.style.display = "none"; // Ẩn nút chấm công ra sáng
    }
  }
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
		
		
		// Khi thực hiện bước ấn Oki trong ô thông báo 
		function sosanhmazalo(popupCapchaValueOne) {
			console.log("xin chao dang chien ***** "+ popupCapchaValueOne);
			 $('#popupCapchaValue').val(popupCapchaValueOne); 
			 $('#check_mazalo').submit(); // Submit form có id là "check_mazalo"
			 
			
		}
	 
	
</script>