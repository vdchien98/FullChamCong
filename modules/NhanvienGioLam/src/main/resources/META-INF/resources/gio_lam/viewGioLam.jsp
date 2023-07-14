<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.docs.chamcong.model.GioLam"%>
<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
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
		<form class="pl-5" id="search-year" method="get">
			<input type="hidden" name="p_p_id"
				value="<%=themeDisplay.getPortletDisplay().getId()%>" /> <input
				type="hidden" name="p_p_auth"
				value="<%=AuthTokenUtil.getToken(request, themeDisplay.getPlid(), themeDisplay.getPpid())%>" />
			<div class="form-group row">
				<div class="form-group row">
					<label class="col-form-label font-weight-bold text-info mr-3">Năm</label>
					<input type="text" class="form-control datepicker col-md-6 ml-6"
						name="<portlet:namespace />year" id="year" placeholder="Năm"
						value="${thangNam}"> <input type="hidden"
						class="form-control datepicker col-md-6 ml-6"
						name="<portlet:namespace />thang" id="thang" placeholder="Năm"
						value=""> <input type="hidden"
						class="form-control datepicker col-md-6 ml-6"
						name="<portlet:namespace />nam" id="nam" placeholder="Năm"
						value="">
				</div>
			</div>
		</form>
	</div>

	<div class="tab-content" id="myTabContent">
	    <div>Chấm công của tôi</div>
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
					<%
						String selectedMonthStr = request.getParameter("thang");
						String selectedYearStr = request.getParameter("nam");

						if (selectedMonthStr != null && selectedYearStr != null) {
							int selectedMonth = Integer.parseInt(selectedMonthStr);
							int selectedYear = Integer.parseInt(selectedYearStr);

							// Lấy ngày cuối cùng của tháng
							java.util.Calendar cal = java.util.Calendar.getInstance();
							cal.set(selectedYear, selectedMonth - 1, 1);
							int numDays = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

							// Lấy ngày đầu tiên của tháng
							cal.set(selectedYear, selectedMonth - 1, 1);
							int startDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1; // Ngày đầu tiên của tuần
							int previousDay = startDayOfWeek - 1 >= 0 ? startDayOfWeek - 1 : 6; // Thứ trước 1 ngày

							// In ra danh sách các ngày trong từng cột
							int numWeeks = (int) Math.ceil((previousDay + numDays) / 7.0); // Số tuần cần để hiển thị hết các ngày
							for (int i = 0; i < numWeeks; i++) {
					%>
					<tr>
						<%
							List<GioLam> Listgiolamcanlay = (List<GioLam>) request.getAttribute("Listgiolamcanlay");
									for (int j = 0; j < 7; j++) {
										int dayIndex = i * 7 + j - previousDay + 1; // Chỉ số của ngày trong danh sách daysInMonth
										String day = "";
										if (dayIndex >= 1 && dayIndex <= numDays) {
											day = String.valueOf(dayIndex);
										}
										boolean hasData = false;
										String checkInSang = "";
										String checkOutSang = "";
										String checkInChieu = "";
										String checkOutChieu = "";
										java.util.Date currentDate = new java.util.Date();
										java.util.Calendar calendar = java.util.Calendar.getInstance();
										calendar.setTime(currentDate);
										int dayToday = calendar.get(java.util.Calendar.DAY_OF_MONTH);
										int Thismonth = calendar.get(java.util.Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, cần +1 để hiển thị đúng
										int Thisyear = calendar.get(java.util.Calendar.YEAR);

										for (GioLam gioLam : Listgiolamcanlay) {
											java.util.Calendar gioLamCal = java.util.Calendar.getInstance();
											gioLamCal.setTime(gioLam.getNgay_lam());
											int gioLamDay = gioLamCal.get(java.util.Calendar.DAY_OF_MONTH);
											int gioLamMonth = gioLamCal.get(java.util.Calendar.MONTH) + 1;
											if (gioLamDay == dayIndex && gioLamMonth == selectedMonth) {
												hasData = true;
												checkInSang = gioLam.getCheck_in_sang();
												checkOutSang = gioLam.getCheck_out_sang();
												checkInChieu = gioLam.getCheck_in_chieu();
												checkOutChieu = gioLam.getCheck_out_chieu();
												break;
											}
										}

										boolean isBeforeCurrentDate = (selectedYear < Thisyear)
												|| (selectedYear == Thisyear && selectedMonth < Thismonth)
												|| (selectedYear == Thisyear && selectedMonth == Thismonth && dayIndex < dayToday);
										boolean isNullInSang = checkInSang.isEmpty();
										boolean isNullOutSang = checkOutSang.isEmpty();
										String backgroundColorSang = (isBeforeCurrentDate && isNullInSang && isNullOutSang)
												? "#e74a3b"
												: ((isNullInSang || isNullOutSang) ? "#858796" : "#1cc88a");
										boolean isNullInChieu = checkInChieu.isEmpty();
										boolean isNullOutChieu = checkOutChieu.isEmpty();
										String backgroundColorChieu = (isBeforeCurrentDate && isNullInChieu && isNullOutChieu)
												? "#e74a3b"
												: ((isNullInChieu || isNullOutChieu) ? "#858796" : "#1cc88a");
						%>
						    <td>
						        <%
						            if (!day.isEmpty()) {
						        %>
						        <div><%=day%></div> 
						        <%
						                if (hasData || isBeforeCurrentDate) {
						                    if (j != 5 && j != 6) { // Bỏ qua thứ 7 và Chủ nhật
						        %>
						                    <div class="border"
						                        style="height: 10px; background-color: <%=backgroundColorSang%>"
						                        title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
						                        &nbsp;</div>
						                    <div class="border"
						                        style="height: 10px; background-color: <%=backgroundColorChieu%>"
						                        title="Vào sáng: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Sáng: <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
						                        &nbsp;</div>
						        <%
						                    }
						                }
						        %> 
						        <%
						            }
						        %>
						    </td>
						<%
							}
						%>
					</tr>
				  <%
				        }
				    %>
				    <%
				        } else {
				        	java.util.Date currentDate = new java.util.Date();
							java.util.Calendar calendar = java.util.Calendar.getInstance();
							calendar.setTime(currentDate);
							int dayToday = calendar.get(java.util.Calendar.DAY_OF_MONTH);
							int Thismonth = calendar.get(java.util.Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, cần +1 để hiển thị đúng
							int Thisyear = calendar.get(java.util.Calendar.YEAR);

							int selectedMonth = Thismonth;
							int selectedYear = Thisyear;

							// Lấy ngày cuối cùng của tháng
							java.util.Calendar cal = java.util.Calendar.getInstance();
							cal.set(selectedYear, selectedMonth - 1, 1);
							int numDays = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

							// Lấy ngày đầu tiên của tháng
							cal.set(selectedYear, selectedMonth - 1, 1);
							int startDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1; // Ngày đầu tiên của tuần
							int previousDay = startDayOfWeek - 1 >= 0 ? startDayOfWeek - 1 : 6; // Thứ trước 1 ngày

							// In ra danh sách các ngày trong từng cột
							int numWeeks = (int) Math.ceil((previousDay + numDays) / 7.0); // Số tuần cần để hiển thị hết các ngày
							for (int i = 0; i < numWeeks; i++) {
					%>
					<tr>
						<%
							List<GioLam> Listgiolamcanlay = (List<GioLam>) request.getAttribute("Listgiolamcanlay");

									for (int j = 0; j < 7; j++) {
										int dayIndex = i * 7 + j - previousDay + 1; // Chỉ số của ngày trong danh sách daysInMonth
										String day = "";
										if (dayIndex >= 1 && dayIndex <= numDays) {
											day = String.valueOf(dayIndex);
										}
										boolean hasData = false;
										String checkInSang = "";
										String checkOutSang = "";
										String checkInChieu = "";
										String checkOutChieu = "";
										
										for (GioLam gioLam : Listgiolamcanlay) {
											java.util.Calendar gioLamCal = java.util.Calendar.getInstance();
											gioLamCal.setTime(gioLam.getNgay_lam());
											int gioLamDay = gioLamCal.get(java.util.Calendar.DAY_OF_MONTH);
											int gioLamMonth = gioLamCal.get(java.util.Calendar.MONTH) + 1;
											if (gioLamDay == dayIndex && gioLamMonth == selectedMonth) {
												hasData = true;
												checkInSang = gioLam.getCheck_in_sang();
												checkOutSang = gioLam.getCheck_out_sang();
												checkInChieu = gioLam.getCheck_in_chieu();
												checkOutChieu = gioLam.getCheck_out_chieu();
												break;
											}
										}

										boolean isBeforeCurrentDate = (selectedYear < Thisyear)
												|| (selectedYear == Thisyear && selectedMonth < Thismonth)
												|| (selectedYear == Thisyear && selectedMonth == Thismonth && dayIndex < dayToday);
										boolean isNullInSang = checkInSang.isEmpty();
										boolean isNullOutSang = checkOutSang.isEmpty();
										String backgroundColorSang = (isBeforeCurrentDate && isNullInSang && isNullOutSang)
												? "#e74a3b"
												: ((isNullInSang || isNullOutSang) ? "#858796" : "#1cc88a");
										boolean isNullInChieu = checkInChieu.isEmpty();
										boolean isNullOutChieu = checkOutChieu.isEmpty();
										String backgroundColorChieu = (isBeforeCurrentDate && isNullInChieu && isNullOutChieu)
												? "#e74a3b"
												: ((isNullInChieu || isNullOutChieu) ? "#858796" : "#1cc88a");
						%>
						    <td>
						        <%
						            if (!day.isEmpty()) {
						        %>
						        <div><%=day%></div> 
						        <%
						                if (hasData || isBeforeCurrentDate) {
						                    if (j != 5 && j != 6) { // Bỏ qua thứ 7 và Chủ nhật
						        %>
						                    <div class="border"
						                        style="height: 10px; background-color: <%=backgroundColorSang%>"
						                        title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
						                        &nbsp;</div>
						                    <div class="border"
						                        style="height: 10px; background-color: <%=backgroundColorChieu%>"
						                        title="Vào sáng: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Sáng: <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
						                        &nbsp;</div>
						        <%
						                    }
						                }
						        %> 
						        <%
						            }
						        %>
						    </td>
						<%
							}
						%>
					</tr>
				  <%
				        }
				    %>
				    <%
				    				        	
				    %>
   
				    <%
				        }
				    %>
				</tbody>
			</table>
		</div>
		
		
		
		
	    <%-- Bắt đầu bảng 2 chấm công của phòng  --%>
	    <div>Chấm công của phòng/đơn vị</div>
	  
	    <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labelledby="home-tab">
		<table class="table table-bordered">
			<thead>
					    <tr>
					        <th style="padding: 0;" class="text-center">STT</th>
					        <th style="padding: 0;" class="text-center">Họ và tên</th>
					        <%
					        if(selectedMonthStr != null && selectedYearStr != null) {
					            int selectedMonth = Integer.parseInt(selectedMonthStr);
					            int selectedYear = Integer.parseInt(selectedYearStr);
					            int daysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
					            System.out.println("daysInMonth !!!!!!!1111111111111 " + daysInMonth);
					            for (int i = 1; i <= daysInMonth; i++) {
					                // Kiểm tra nếu ngày là thứ 7 hoặc chủ nhật
					                boolean isWeekend = false;
					                java.util.Calendar calendar = java.util.Calendar.getInstance();
					                calendar.set(selectedYear, selectedMonth - 1, i);
					                int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
					                if (dayOfWeek == java.util.Calendar.SATURDAY || dayOfWeek == java.util.Calendar.SUNDAY) {
					                    isWeekend = true;
					                }
					                %>
					                <th style="padding: 0px; width: 0px;" class="text-center sorting_disabled <%= isWeekend ? "bg-warning" : "" %>" rowspan="1" colspan="1" aria-label="<%= i %>">
					                    <%= i %>
					                </th>
					                <%
					            }
					        } else {
					            java.util.Date currentDate = new java.util.Date();
					            java.util.Calendar calendar = java.util.Calendar.getInstance();
					            calendar.setTime(currentDate);
					            int dayToday = calendar.get(java.util.Calendar.DAY_OF_MONTH);
					            int Thismonth = calendar.get(java.util.Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, cần +1 để hiển thị đúng
					            int Thisyear = calendar.get(java.util.Calendar.YEAR);
					            int selectedMonth = Thismonth;
					            int selectedYear = Thisyear;
					            int daysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
					            for (int i = 1; i <= daysInMonth; i++) {
					                // Kiểm tra nếu ngày là thứ 7 hoặc chủ nhật
					                boolean isWeekend = false;
					              
					                calendar.set(selectedYear, selectedMonth - 1, i);
					                int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
					                if (dayOfWeek == java.util.Calendar.SATURDAY || dayOfWeek == java.util.Calendar.SUNDAY) {
					                    isWeekend = true;
					                }
					                %>
					                <th style="padding: 0px; width: 0px;" class="text-center sorting_disabled <%= isWeekend ? "bg-warning" : "" %>" rowspan="1" colspan="1" aria-label="<%= i %>">
					                    <%= i %>
					                </th>
					                <%
					            }
					        }
					        %>
					        <th style="padding: 0;" class="text-center">Đ</th>
					        <th style="padding: 0;" class="text-center">M</th>
					        <th style="padding: 0;" class="text-center">S</th>
					    </tr>
					</thead>
		    <tbody>
		        <% List<List<GioLam>> AllGioLamNhanVienPhong = (List<List<GioLam>>) renderRequest.getAttribute("AllGioLamNhanVienPhong");
		        if (AllGioLamNhanVienPhong != null) {
		            int stt = 1;
		            for (List<GioLam> gioLamNhanVien : AllGioLamNhanVienPhong) {
		                %>
		                <tr>
                <td><%= stt++ %></td>
                <td><!-- Họ và tên --></td>
               <%
					int dayIndex = 0; // Biến đếm ngày trong tháng
					for (GioLam gioLam : gioLamNhanVien) {
					    // Lấy ngày từ gioLam và hiển thị vào thẻ <td>
					    %>
					    <td>
					        <%
					            Date ngaylam = gioLam.getNgay_lam();
					            String checkInSang = gioLam.getCheck_in_sang();
					            String checkOutSang = gioLam.getCheck_out_sang();
					            String checkInChieu = gioLam.getCheck_in_chieu();
					            String checkOutChieu = gioLam.getCheck_out_chieu();
					            boolean isNullInSang = checkInSang.isEmpty();
					            boolean isNullOutSang = checkOutSang.isEmpty();
					            String backgroundColorSang = (isNullInSang || isNullOutSang) ? "#858796" : "#1cc88a";
					            boolean isNullInChieu = checkInChieu.isEmpty();
					            boolean isNullOutChieu = checkOutChieu.isEmpty();
					            String backgroundColorChieu = (isNullInChieu || isNullOutChieu) ? "#858796" : "#1cc88a";
					        %>
					        <div class="border" style="height: 10px; background-color: <%=backgroundColorSang%>"
					            title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
					            &nbsp;</div>
					        <div class="border" style="height: 10px; background-color: <%=backgroundColorChieu%>"
					            title="Vào chiều: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra chiều: <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
					            &nbsp;</div>
					    </td>
					    <% 
					        dayIndex++;
					    } %>
            </tr>
		                <% } } %>
		    </tbody>
		</table>
	  </div>	
	   
    	<%-- Kết thúc bảng 2 của nhân viên  --%>
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
		    var monthString = String(selectedMonth).padStart(2, '0'); // Đảm bảo tháng có 2 chữ số (01-12)
		    var formattedDate =   selectedMonth+ '-' +selectedYear ; // Chuỗi tháng và năm theo định dạng "mm/yyyy"
		    $('#year').val(formattedDate);
		    $('#thang').val(selectedMonth);
		    $('#nam').val(selectedYear);
		    $('#search-year').submit();
		    
		  
		    
	  });
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