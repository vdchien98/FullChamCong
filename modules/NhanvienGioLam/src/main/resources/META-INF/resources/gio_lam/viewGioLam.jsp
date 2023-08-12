<%@page import="com.liferay.docs.chamcong.model.Ngaynghile"%>
<%@page import="java.util.Map"%>
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

th.text-center.stt {
	width: 5px;
}

td.text-center.hovaten {
	/* max-width: 57px
px
; */
	width: 28px;
}

th.text-center.dms {
	width: 5px;
}

#timeTable td {
	text-align: center;
	vertical-align: middle;
}

.col-auto.chien {
	font-size: 50px;
	color: #f6c23e !important;
}

.col-md-6.thongbao {
	flex: 0 0 50%;
	max-width: 33%;
}

.form-group.row.namvathang {
	display: flex;
	align-items: center;
	flex-direction: row;
	justify-content: center;
	padding: 0px 0px;
	margin: 6px 0px;
}

form#search-year {
	margin-bottom: -25px;
	margin-top: 15px;
}
input#year {
    margin-left: 1px !important;
}
.chamcongcuatoi {
    display: flex;
    justify-content: center;
    font-size: 30px;
    color: #84d16b;
    font-family: 'FontAwesome';
}
</style>

<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Bảng giờ làm tháng
				6</h4>
		</div>

		<%-- xử lý cham cong --%>


		<portlet:actionURL var="sendMaZaloURL" name="sendMaZalo" />
		<form id="check-in" class="float-right" action="<%=sendMaZaloURL%>"
			method="POST"></form>
		<form id="check-out" class="float-right" action="" method="POST">
		</form>

		<%
			int hienthichamcong = (int) request.getAttribute("hienthichamcong");
			long usreid = (long) request.getAttribute("userId");
			GioLam giolam = (GioLam) request.getAttribute("userGioLamNutChamCong");
		%>
		<%
			if (giolam == null) {
		%>
		<%
			if (hienthichamcong == 1) {
		%>
		<button id="attendanceButton1" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance1(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			sáng
		</button>
		<button id="attendanceButton2" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance2(${userId})"
			style="display: none; background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			sáng
		</button>
		<%
			} else if (hienthichamcong == 3) {
		%>
		<button id="attendanceButton3" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance3(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			chiều
		</button>
		<button id="attendanceButton4" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance4(${userId})"
			style="display: none; background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			chiều
		</button>
		<%
			}
		%>
		<%
			} else {
		%>
		<%
			int trangthai = giolam.getTrangthai();
				if (hienthichamcong == 1 || (hienthichamcong == 3 && trangthai == 2)
						|| (hienthichamcong == 3 && trangthai == 3)) {
		%>

		<%
			if (trangthai == 1) {
		%>
		<button id="attendanceButton2" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance2(${userId})"
			style="background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			sáng
		</button>
		<button id="attendanceButton1" type="button"
			class="btn btn-success btn_chien" style="display: none;"
			onclick="changeAttendance1(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			sáng
		</button>
		<%
			} else if (hienthichamcong == 1 && trangthai == 2) {
		%>
		<button id="attendanceButton2" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance2(${userId})"
			style="display: none; background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			sáng
		</button>
		<button id="attendanceButton1" type="button"
			class="btn btn-success btn_chien" style="display: none;"
			onclick="changeAttendance1(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			sáng
		</button>
		<%
			} else if (hienthichamcong == 3 && trangthai == 2) {
		%>
		<button id="attendanceButton3" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance3(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			chiều
		</button>
		<button id="attendanceButton4" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance4(${userId})"
			style="display: none; background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			chiều
		</button>

		<%
			} else if (trangthai == 3) {
		%>
		<button id="attendanceButton4" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance4(${userId})"
			style="background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			chiều
		</button>
		<button id="attendanceButton3" type="button"
			class="btn btn-success btn_chien" style="display: none;"
			onclick="changeAttendance3(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			chiều
		</button>
		<%
			} else if (trangthai == 4) {
		%>
		<button id="attendanceButton2" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance(${userId})"
			style="display: none; background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			sáng
		</button>
		<button id="attendanceButton1" type="button"
			class="btn btn-success btn_chien" style="display: none;"
			onclick="changeAttendance1(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			sáng
		</button>
		<%
			}
		%>
		<%
			} else if (hienthichamcong == 3 && trangthai == 1) {
		%>
		<button id="attendanceButton4" type="button"
			class="btn btn-success btn_chien"
			onclick="changeAttendance4(${userId})"
			style="background-color: #e74a3b;">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công ra
			chiều
		</button>
		<button id="attendanceButton3" type="button"
			class="btn btn-success btn_chien" style="display: none;"
			onclick="changeAttendance3(${userId})">
			<i class="fa fa-check-square" aria-hidden="true"></i> Chấm công vào
			chiều
		</button>
		<%
			}
		%>
		<%
			}
		%>

		<%-- kêt thúc xử lý nút chấm công --%>
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
	<%-- Mục chọn năm và tháng  --%>

	<div class="form-group row namvathang">
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
						value="${thangNam}"> <input type="hidden" class=""
						name="<portlet:namespace />thang" id="thang" value=""> <input
						type="hidden" class="" name="<portlet:namespace />nam" id="nam"
						value="">
				</div>
			</div>
		</form>
	</div>
	<%-- Bảng điểm cá nhân  --%>
	<div class="tab-content" id="myTabContent">
		<div class="chamcongcuatoi">Chấm công của tôi</div>
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
						  List<Ngaynghile> listngaynghiletheothang = (List<Ngaynghile>) request.getAttribute("listngaynghiletheothang");
									for (int j = 0; j < 7; j++) {
										int dayIndex = i * 7 + j - previousDay + 1; // Chỉ số của ngày trong danh sách daysInMonth
		
										String day = "";
										if (dayIndex >= 1 && dayIndex <= numDays) {
											day = String.valueOf(dayIndex);
										}
										boolean hasData = false;
										String checkInSang = "";
										String checkOutSang = "";
										int dimuonsang = 0;
										int vesomsang =0 ;
										
										
										String checkInChieu = "";
										String checkOutChieu = "";
										int dimuonchieu = 0;
										int vesomchieu =0 ;
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
											if (gioLamDay == dayIndex && gioLamMonth == selectedMonth) {  // nếu ngày trong data trung vs ngày trong tháng đang xét 
												hasData = true;
												checkInSang = gioLam.getCheck_in_sang();
												checkOutSang = gioLam.getCheck_out_sang();
												dimuonsang = gioLam.getDi_muon_sang();
												vesomsang = gioLam.getVe_som_sang();
												
												
												checkInChieu = gioLam.getCheck_in_chieu();
												checkOutChieu = gioLam.getCheck_out_chieu();
												dimuonchieu = gioLam.getDi_muon_chieu();
												vesomchieu = gioLam.getVe_som_chieu();
												
												break;
											}
											
											
										}

										 boolean isSpecialEvent = false;
										for (Ngaynghile ngaynghi : listngaynghiletheothang) {
								            java.util.Calendar ngayNghiCal = java.util.Calendar.getInstance();
								            ngayNghiCal.setTime(ngaynghi.getNgay_nghi());

								            int ngayNghiDay = ngayNghiCal.get(java.util.Calendar.DAY_OF_MONTH);
								      //      System.out.println("ngayNghiDay &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& ----------" + ngayNghiDay);
								            int ngayNghiMonth = ngayNghiCal.get(java.util.Calendar.MONTH) + 1;
								   //         System.out.println("ngayNghiMonth &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& ----------" + ngayNghiMonth);
								            if (ngayNghiDay == dayIndex && ngayNghiMonth == selectedMonth) {
								                isSpecialEvent = true;
								                break;
								            }
								        }
										
									
										
								        
								        
										boolean isBeforeCurrentDate = (selectedYear < Thisyear)
												|| (selectedYear == Thisyear && selectedMonth < Thismonth)
												|| (selectedYear == Thisyear && selectedMonth == Thismonth && dayIndex < dayToday);
										boolean isNullInSang = checkInSang.isEmpty();
										boolean isNullOutSang = checkOutSang.isEmpty();
										boolean dimuonvesomsang = (dimuonsang > 0 || vesomsang >0);
										
										String backgroundColorSang = "";

										if( isSpecialEvent &&isBeforeCurrentDate){
											 backgroundColorSang = "#4e73df";
										}else if (isBeforeCurrentDate && isNullInSang && isNullOutSang) {
										    backgroundColorSang = "#e74a3b";
										} else if ((isNullInSang || isNullOutSang) && !dimuonvesomsang) {
										    backgroundColorSang = "#858796";
										} else if (dimuonvesomsang && !isNullInSang && !isNullOutSang) {
										    backgroundColorSang = "#f6c23e";
										} else if (!dimuonvesomsang && !isNullInSang && !isNullOutSang) {
										    backgroundColorSang = "#1cc88a";
										}else if (dimuonvesomsang && (isNullInSang || isNullOutSang)  ){
											   backgroundColorSang = "#f6c23e";
										}

										
	
										boolean isNullInChieu = checkInChieu.isEmpty();
										boolean isNullOutChieu = checkOutChieu.isEmpty();
										boolean dimuonvesomchieu = (dimuonchieu > 0 || vesomchieu >0);
										
										String backgroundColorChieu = "";
										if(isSpecialEvent && isBeforeCurrentDate) {
											backgroundColorChieu = "#4e73df";
										}else if (isBeforeCurrentDate && isNullInChieu && isNullOutChieu) {
											backgroundColorChieu = "#e74a3b";
										} else if ((isNullInChieu || isNullOutChieu) && !dimuonvesomchieu ) {
											backgroundColorChieu = "#858796";
										} else if (dimuonvesomchieu && !isNullOutChieu && !isNullInChieu) {
											backgroundColorChieu = "#f6c23e";
										} else if (!dimuonvesomchieu && !isNullInChieu && !isNullOutChieu) {
											backgroundColorChieu = "#1cc88a";
										}else if (dimuonvesomchieu && (isNullInChieu || isNullOutChieu)  ){
											   backgroundColorSang = "#f6c23e";
										}
										// xử lý ngày nghỉ trùng vs ngày dayIndex   
			
						%>
						<td>
							<%
								if (!day.isEmpty()) {
							%>
							<div><%=day%></div> <%
							 	if (hasData || isBeforeCurrentDate) {
									if (j != 5 && j != 6) { // Bỏ qua thứ 7 và Chủ nhật
						%>
						<%
						if (isBeforeCurrentDate && !isNullInSang && isNullOutSang && 
						isNullInChieu && !isNullOutChieu && !dimuonvesomsang && !dimuonvesomchieu) {
						%>
						<div class="border"
						    style="height: 10px; background-color: #1cc88a"
						    title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
						    &nbsp;
						</div>
						<div class="border"
						    style="height: 10px; background-color: #1cc88a"
						    title="Vào chiều: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Chiều : <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
						    &nbsp;
						</div>
						<%
						} else if(isBeforeCurrentDate && !isNullInSang && isNullOutSang && 
								isNullInChieu && !isNullOutChieu && dimuonvesomchieu) { %>
									<div class="border"
						    style="height: 10px; background-color: #1cc88a"
						    title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
						    &nbsp;
						</div>
						<div class="border"
						    style="height: 10px; background-color: #f6c23e"
						    title="Vào chiều: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Chiều : <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
						    &nbsp;
						</div>
						
						
						<% } else { %>		
						
							<div class="border"
							        style="height: 10px; background-color: <%=backgroundColorSang %>"
							        title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
							        &nbsp;
							    </div>
							    <div class="border"
							        style="height: 10px; background-color: <%=backgroundColorChieu %>"
							        title="Vào chiều: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Chiều : <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
							        &nbsp;
							    </div>
						
						<% } %>
						
						
												
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
						List<Ngaynghile> listngaynghiletheothang = (List<Ngaynghile>) request.getAttribute("listngaynghiletheothang");
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
										int dimuonchieu = 0;
										int vesomchieu =0 ;
										int dimuonsang = 0;
										int vesomsang =0 ;

										for (GioLam gioLam : Listgiolamcanlay) {
											java.util.Calendar gioLamCal = java.util.Calendar.getInstance();
											gioLamCal.setTime(gioLam.getNgay_lam());
											int gioLamDay = gioLamCal.get(java.util.Calendar.DAY_OF_MONTH);
											int gioLamMonth = gioLamCal.get(java.util.Calendar.MONTH) + 1;
											if (gioLamDay == dayIndex && gioLamMonth == selectedMonth) {
												hasData = true;
												checkInSang = gioLam.getCheck_in_sang();
												checkOutSang = gioLam.getCheck_out_sang();
												dimuonsang = gioLam.getDi_muon_sang();
												vesomsang = gioLam.getVe_som_sang();
												
												
												checkInChieu = gioLam.getCheck_in_chieu();
												checkOutChieu = gioLam.getCheck_out_chieu();
												dimuonchieu = gioLam.getDi_muon_chieu();
												vesomchieu = gioLam.getVe_som_chieu();
												break;
											}
										}

										

										 boolean isSpecialEvent = false;
										for (Ngaynghile ngaynghi : listngaynghiletheothang) {
								            java.util.Calendar ngayNghiCal = java.util.Calendar.getInstance();
								            ngayNghiCal.setTime(ngaynghi.getNgay_nghi());

								            int ngayNghiDay = ngayNghiCal.get(java.util.Calendar.DAY_OF_MONTH);
								            int ngayNghiMonth = ngayNghiCal.get(java.util.Calendar.MONTH) + 1;
								            if (ngayNghiDay == dayIndex && ngayNghiMonth == selectedMonth) {
								                isSpecialEvent = true;
								                break;
								            }
								        }
										
										
										
										boolean isBeforeCurrentDate = (selectedYear < Thisyear)
												|| (selectedYear == Thisyear && selectedMonth < Thismonth)
												|| (selectedYear == Thisyear && selectedMonth == Thismonth && dayIndex < dayToday);
										boolean isNullInSang = checkInSang.isEmpty();
										boolean isNullOutSang = checkOutSang.isEmpty();
										boolean dimuonvesomsang = (dimuonsang > 0 || vesomsang >0);
										
										String backgroundColorSang = "";
										if( isSpecialEvent &&isBeforeCurrentDate){
											 backgroundColorSang = "#4e73df";
										}else if (isBeforeCurrentDate && isNullInSang && isNullOutSang) {
										    backgroundColorSang = "#e74a3b";
										} else if (isNullInSang || isNullOutSang) {
										    backgroundColorSang = "#858796";
										} else if (dimuonvesomsang && !isNullInSang && !isNullOutSang) {
										    backgroundColorSang = "#f6c23e";
										} else if (!dimuonvesomsang && !isNullInSang && !isNullOutSang) {
										    backgroundColorSang = "#1cc88a";
										}

										
	
										boolean isNullInChieu = checkInChieu.isEmpty();
										boolean isNullOutChieu = checkOutChieu.isEmpty();
										boolean dimuonvesomchieu = (dimuonchieu > 0 || vesomchieu >0 || (dimuonchieu > 0 && vesomchieu>0));
										
										String backgroundColorChieu = "";
										if(isSpecialEvent && isBeforeCurrentDate) {
											backgroundColorChieu = "#4e73df";
										}else if (isBeforeCurrentDate && isNullInChieu && isNullOutChieu) {
											backgroundColorChieu = "#e74a3b";
										} else if (isNullInChieu || isNullOutChieu) {
											backgroundColorChieu = "#858796";
										} else if (dimuonvesomchieu && !isNullOutChieu && !isNullInChieu) {
											backgroundColorChieu = "#f6c23e";
										} else if (!dimuonvesomchieu && !isNullInChieu && !isNullOutChieu) {
											backgroundColorChieu = "#1cc88a";
										}
						%>
						<td>
							<%
								if (!day.isEmpty()) {
							%>
							<div><%=day%></div> <%
									 	if (hasData || isBeforeCurrentDate) {
												if (j != 5 && j != 6) { // Bỏ qua thứ 7 và Chủ nhật
									%>
									<%
									if (isBeforeCurrentDate && !isNullInSang && isNullOutSang && 
									isNullInChieu && !isNullOutChieu && !dimuonvesomsang && !dimuonvesomchieu) {
									%>
									<div class="border"
									    style="height: 10px; background-color: #1cc88a"
									    title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
									    &nbsp;
									</div>
									<div class="border"
									    style="height: 10px; background-color: #1cc88a"
									    title="Vào chiều: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Chiều : <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
									    &nbsp;
									</div>
									<%
									} else if(isBeforeCurrentDate && !isNullInSang && isNullOutSang && 
											isNullInChieu && !isNullOutChieu && dimuonvesomchieu) { %>
												<div class="border"
									    style="height: 10px; background-color: #1cc88a"
									    title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
									    &nbsp;
									</div>
									<div class="border"
									    style="height: 10px; background-color: #f6c23e"
									    title="Vào chiều: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Chiều : <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
									    &nbsp;
									</div>
									
									
									<% } else { %>		
									
										<div class="border"
										        style="height: 10px; background-color: <%=backgroundColorSang %>"
										        title="Vào sáng: <%=checkInSang.isEmpty() ? "Null" : checkInSang%> --- Ra Sáng: <%=checkOutSang.isEmpty() ? "Null" : checkOutSang%>">
										        &nbsp;
										    </div>
										    <div class="border"
										        style="height: 10px; background-color: <%=backgroundColorChieu %>"
										        title="Vào chiều: <%=checkInChieu.isEmpty() ? "Null" : checkInChieu%> --- Ra Chiều : <%=checkOutChieu.isEmpty() ? "Null" : checkOutChieu%>">
										        &nbsp;
										    </div>
									
									<% } %>
									
									
															
									<%
										      }
										      }
									 %> <%
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

		<%-- Kết thúc bảng điểm cá nhân  --%>

	







		<%-- Bắt đầu bảng 2 chấm công của phòng dành cho phụ trách phòng --%>

		<%
			int phutrachphong = (int) renderRequest.getAttribute("phutrachphong");
			if (phutrachphong == 1) {
		%>
		<div class="chamcongcuatoi">Chấm công của phòng/đơn vị</div>

		<div class="tab-pane fade show active" id="profile" role="tabpanel"
			aria-labelledby="home-tab">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="padding: 0;" class="text-center stt">STT</th>
						<th style="padding: 0;" class="text-center">Họ và tên</th>
						<%
							if (selectedMonthStr != null && selectedYearStr != null) {
									int selectedMonth = Integer.parseInt(selectedMonthStr);
									int selectedYear = Integer.parseInt(selectedYearStr);
									int daysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
									for (int i = 1; i <= daysInMonth; i++) {
										boolean isWeekend = false;
										java.util.Calendar calendar = java.util.Calendar.getInstance();
										calendar.set(selectedYear, selectedMonth - 1, i);
										int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
										if (dayOfWeek == java.util.Calendar.SATURDAY || dayOfWeek == java.util.Calendar.SUNDAY) {
											isWeekend = true;
										}
						%>
						<th style="padding: 0px; width: 20px;"
							class="text-center sorting_disabled <%=isWeekend ? "bg-warning" : ""%>"
							rowspan="1" colspan="1" aria-label="<%=i%>"><%=i%></th>
						<%
							}
								} else {
									java.util.Date currentDate = new java.util.Date();
									java.util.Calendar calendar = java.util.Calendar.getInstance();
									calendar.setTime(currentDate);
									int dayToday = calendar.get(java.util.Calendar.DAY_OF_MONTH);
									int Thismonth = calendar.get(java.util.Calendar.MONTH) + 1;
									int Thisyear = calendar.get(java.util.Calendar.YEAR);
									int selectedMonth = Thismonth;
									int selectedYear = Thisyear;
									int daysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
									for (int i = 1; i <= daysInMonth; i++) {
										boolean isWeekend = false;
										calendar.set(selectedYear, selectedMonth - 1, i);
										int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
										if (dayOfWeek == java.util.Calendar.SATURDAY || dayOfWeek == java.util.Calendar.SUNDAY) {
											isWeekend = true;
										}
						%>
						<th style="padding: 0px; width: 0px;"
							class="text-center sorting_disabled <%=isWeekend ? "bg-warning" : ""%>"
							rowspan="1" colspan="1" aria-label="<%=i%>"><%=i%></th>
						<%
							}
								}
						%>
						<th style="padding: 0;" class="text-center dms">Đ</th>
						<th style="padding: 0;" class="text-center dms">M</th>
						<th style="padding: 0;" class="text-center dms">S</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<List<Map<String, Object>>> AllGioLamNhanVienPhong = (List<List<Map<String, Object>>>) renderRequest.getAttribute("allGioLamNhanVienPhong");
							if (AllGioLamNhanVienPhong != null) {
								int stt = 1;
								for (List<Map<String, Object>> gioLamNhanVien : AllGioLamNhanVienPhong) {
									 System.out.println("gioLamNhanVien ------- " + gioLamNhanVien);
									boolean hasData = !gioLamNhanVien.isEmpty();
									boolean isAllRed = !hasData;
				 	%>
					<tr class="">
						<td style="padding: 0;" class="text-center"><%=stt%></td>
						<td style="padding: 0;" class="text-center hovaten"><%=gioLamNhanVien.get(0).get("nameNhanVien")%></td>

						<%
							if (selectedMonthStr != null && selectedYearStr != null) {
								int selectedMonth = Integer.parseInt(selectedMonthStr);
								System.out.println("selectedMonth --------------- " + selectedMonth);
								int selectedYear = Integer.parseInt(selectedYearStr);
								System.out.println("selectedYear --------------- " + selectedYear);
								int daysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
								System.out.println("daysInMonth --------------- " + daysInMonth);
								java.util.Calendar todayCalendar = java.util.Calendar.getInstance();
								System.out.println("todayCalendar --------------- " + todayCalendar);
								java.util.Date todayDate = todayCalendar.getTime();
								System.out.println("todayDate --------------- " + todayDate);
								
								
								System.out.println(" ************************************************************************************************ ");
								
								for (int i = 1; i <= daysInMonth; i++) {
									boolean isWeekend = false;
									java.util.Calendar calendar = java.util.Calendar.getInstance();
									//System.out.println("calendar 11111 --------------- " + calendar);
									calendar.set(selectedYear, selectedMonth - 1, i);
									//System.out.println("calendar 22222 --------------- " + calendar);
									int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
									//System.out.println("dayOfWeek  --------------- " + dayOfWeek);
									if (dayOfWeek == java.util.Calendar.SATURDAY || dayOfWeek == java.util.Calendar.SUNDAY) {
										isWeekend = true;
									}
						%>
						<td style="padding: 0px; width: 20px;"
							class="text-center sorting_disabled <%=isWeekend ? "" : ""%>"
							rowspan="1" colspan="1" aria-label="<%=i%>">
							<%
								if (!isWeekend) {
							%> 
							       <%
									 if (isAllRed) {
								   %>
										<div class="bg-danger border" style="height: 10px" data-toggle="tooltip" data-html="true" title="No data">&nbsp;</div>
										<div class="bg-danger border" style="height: 10px" data-toggle="tooltip" data-html="true" title="No data">&nbsp;</div>
								  <% }else { %>
								     <%
									 	boolean hasDataForCurrentDate = false;
									 %> 
										 <%
										 	if (hasData) {
										 %> 
										 <%
										 	for (Map<String, Object> gioLam : gioLamNhanVien) {
										 		java.util.Date ngayLam = (java.util.Date) gioLam.get("ngay_lam");
										 		if (ngayLam == null) {
										 %> 
								    	 <%
									 	 } else {
										 	java.util.Calendar gioLamCalendar = java.util.Calendar.getInstance();
										 	gioLamCalendar.setTime(ngayLam);
										 	int gioLamDay = gioLamCalendar.get(java.util.Calendar.DAY_OF_MONTH);
										 	int gioLamMonth = gioLamCalendar.get(java.util.Calendar.MONTH) + 1;
										 	if (gioLamDay == i && gioLamMonth == selectedMonth) {
										 			String checkInSang = (String) gioLam.get("check_in_sang");
										 			String checkOutSang = (String) gioLam.get("check_out_sang");
										 			String checkInChieu = (String) gioLam.get("check_in_chieu");
										 			String checkOuChieu = (String) gioLam.get("check_out_chieu");
										 	     if (checkInSang != "" && checkOutSang != "") {
									    %>
												<div class="border" style="height: 10px; 
												     background-color: #1cc88a;" 
												     data-toggle="tooltip" 
												     data-html="true" 
												     title="Ca sáng-- Giờ vào: <%=checkInSang%> | Giờ ra: <%=checkOutSang%>">&nbsp;
												 </div>							
												<% } else if (checkInSang != "" || checkOutSang != "") { %>
														<div class="border"
															style="height: 10px; background-color: #858796;"
															data-toggle="tooltip" data-html="true"
															title="Ca sáng -- Giờ vào: <%=checkInSang%> | Giờ ra: <%=checkOutSang%>">&nbsp;
														</div>
									             <%} else { %>
														<div class="border"
															style="height: 10px; background-color: #e74a3b;"
															data-toggle="tooltip" data-html="true"
															title="Ca sáng -- Giờ vào: Null | Giờ ra :Null "">&nbsp;</div> 
												<% }
                                                  if (checkInChieu != "" && checkOuChieu != "") {
								             	%>
									 				<div class="border"
														 style="height: 10px; background-color: #1cc88a;"
														 data-toggle="tooltip" data-html="true"
														 title="Ca chiều -- Giờ vào: <%=checkInChieu%> | Giờ ra: <%=checkOuChieu%>">&nbsp;
													</div>
									
												<% } else if (checkInChieu != "" || checkOuChieu != "") { %>
													<div class="border"
														 style="height: 10px; background-color: #858796;"
														 data-toggle="tooltip" data-html="true"
														 title="Ca chiều -- Giờ vào: <%=checkInChieu%> | Giờ ra: <%=checkOuChieu%>">&nbsp;
													</div>
									
												<% } else {%>
													<div class="border"
														 style="height: 10px; background-color: #e74a3b;"
														 data-toggle="tooltip" data-html="true"
														 title="Ca chiều -- Giờ vào: Null | Giờ ra :Null ">&nbsp;</div> 
												<% }
									 				hasDataForCurrentDate = true;
									 				}
									 				}
									                }
									            %> 
									            <% } if (!hasDataForCurrentDate) {
									 					// java.util.Calendar todayCalendar = java.util.Calendar.getInstance();
									 						todayCalendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
									 						todayCalendar.set(java.util.Calendar.MINUTE, 0);
									 						todayCalendar.set(java.util.Calendar.SECOND, 0);
									 						todayCalendar.set(java.util.Calendar.MILLISECOND, 0);
									 						java.util.Date today = todayCalendar.getTime();
									 					//   java.util.Calendar calendar = java.util.Calendar.getInstance();
									 						calendar.set(selectedYear, selectedMonth - 1, i);
									 						java.util.Date date = calendar.getTime();
									 					if (date.before(today)) {
									             %>
														<div class="border"
															 style="height: 10px; background-color: #e74a3b;"
															 data-toggle="tooltip" data-html="true"
															 title="Ca sáng -- Giờ vào: Null | Giờ ra :Null "">&nbsp;</div>
														<div class="border"
															 style="height: 10px; background-color: #e74a3b;"
															 data-toggle="tooltip" data-html="true"
															 title="Ca chiều -- Giờ vào: Null | Giờ ra :Null ">&nbsp;
														</div> 
												 <%
												 	}
												 %> <%
												 	}
												 %> <%
												 	}
												 %> <%
												 	}
												 %>
						         </td>
						<%
							}
										}

										else {
											java.util.Date currentDate = new java.util.Date();
											java.util.Calendar calendar = java.util.Calendar.getInstance();
											calendar.setTime(currentDate);
											int dayToday = calendar.get(java.util.Calendar.DAY_OF_MONTH);
											int Thismonth = calendar.get(java.util.Calendar.MONTH) + 1; // Tháng bắt đầu từ 0, cần +1 để hiển thị đúng
											int Thisyear = calendar.get(java.util.Calendar.YEAR);

											int selectedMonth = Thismonth;
											int selectedYear = Thisyear;

											int daysInMonth = new Date(selectedYear, selectedMonth, 0).getDate();
											java.util.Calendar todayCalendar = java.util.Calendar.getInstance();
											java.util.Date todayDate = todayCalendar.getTime();
											for (int i = 1; i <= daysInMonth; i++) {
												boolean isWeekend = false;
												//java.util.Calendar calendar = java.util.Calendar.getInstance();
												calendar.set(selectedYear, selectedMonth - 1, i);
												int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
												if (dayOfWeek == java.util.Calendar.SATURDAY
														|| dayOfWeek == java.util.Calendar.SUNDAY) {
													isWeekend = true;
												}
						%>
						<td style="padding: 0px; width: 0px;"
							class="text-center sorting_disabled <%=isWeekend ? "" : ""%>"
							rowspan="1" colspan="1" aria-label="<%=i%>">
							<%
								if (!isWeekend) {
							%> <%
							 	if (isAllRed) {
							 %>
							<div class="bg-danger border" style="height: 10px"
								data-toggle="tooltip" data-html="true" title="No data">&nbsp;</div>
							<div class="bg-danger border" style="height: 10px"
								data-toggle="tooltip" data-html="true" title="No data">&nbsp;</div>
							<%
								} else {
							%> <%
							 	boolean hasDataForCurrentDate = false;
							 %> <%
							 	if (hasData) {
							 %> <%
							 	for (Map<String, Object> gioLam : gioLamNhanVien) {
							 										java.util.Date ngayLam = (java.util.Date) gioLam.get("ngay_lam");
							 										if (ngayLam == null) {
							 %> 
								  <%
 	                                } else {
 											java.util.Calendar gioLamCalendar = java.util.Calendar
 													.getInstance();
 											gioLamCalendar.setTime(ngayLam);
 											int gioLamDay = gioLamCalendar.get(java.util.Calendar.DAY_OF_MONTH);
 											int gioLamMonth = gioLamCalendar.get(java.util.Calendar.MONTH) + 1;
 											if (gioLamDay == i && gioLamMonth == selectedMonth) {
 												String checkInSang = (String) gioLam.get("check_in_sang");
 												String checkOutSang = (String) gioLam.get("check_out_sang");
 												String checkInChieu = (String) gioLam.get("check_in_chieu");
 												String checkOuChieu = (String) gioLam.get("check_out_chieu");
 												if (checkInSang != "" && checkOutSang != "") {
                                  %>
							<div class="border"
								style="height: 10px; background-color: #1cc88a;"
								data-toggle="tooltip" data-html="true"
								title="Ca sáng-- Giờ vào: <%=checkInSang%> | Giờ ra: <%=checkOutSang%>">&nbsp;</div>

							<%
								} else if (checkInSang != "" || checkOutSang != "") {
							%>
							<div class="border"
								style="height: 10px; background-color: #858796;"
								data-toggle="tooltip" data-html="true"
								title="Ca sáng -- Giờ vào: <%=checkInSang%> | Giờ ra: <%=checkOutSang%>">&nbsp;</div>

							<%
								} else {
							%>
							<div class="border"
								style="height: 10px; background-color: #e74a3b;"
								data-toggle="tooltip" data-html="true"
								title="Ca sáng -- Giờ vào: Null | Giờ ra :Null "">&nbsp;</div> <%
 	}
 												if (checkInChieu != "" && checkOuChieu != "") {
                        %>
							<div class="border"
								style="height: 10px; background-color: #1cc88a;"
								data-toggle="tooltip" data-html="true"
								title="Ca chiều -- Giờ vào: <%=checkInChieu%> | Giờ ra: <%=checkOuChieu%>">&nbsp;</div>

							<%
								} else if (checkInChieu != "" || checkOuChieu != "") {
							%>
							<div class="border"
								style="height: 10px; background-color: #858796;"
								data-toggle="tooltip" data-html="true"
								title="Ca chiều -- Giờ vào: <%=checkInChieu%> | Giờ ra: <%=checkOuChieu%>">&nbsp;</div>

							<%
								} else {
							%>
							<div class="border"
								style="height: 10px; background-color: #e74a3b;"
								data-toggle="tooltip" data-html="true"
								title="Ca chiều -- Giờ vào: Null | Giờ ra :Null ">&nbsp;</div> <%
 	}
 												hasDataForCurrentDate = true;
 											}
 										}

 									}
								 %> <%
								 	}
		 								if (!hasDataForCurrentDate) {
		 									// java.util.Calendar todayCalendar = java.util.Calendar.getInstance();
		 									todayCalendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
		 									todayCalendar.set(java.util.Calendar.MINUTE, 0);
		 									todayCalendar.set(java.util.Calendar.SECOND, 0);
		 									todayCalendar.set(java.util.Calendar.MILLISECOND, 0);
		 									java.util.Date today = todayCalendar.getTime();
		 									//   java.util.Calendar calendar = java.util.Calendar.getInstance();
		 									calendar.set(selectedYear, selectedMonth - 1, i);
		 									java.util.Date date = calendar.getTime();
		 									if (date.before(today)) {
											 %>
																		<div class="border"
																			style="height: 10px; background-color: #e74a3b;"
																			data-toggle="tooltip" data-html="true"
																			title="Ca sáng -- Giờ vào: Null | Giờ ra :Null "">&nbsp;</div>
																		<div class="border"
																			style="height: 10px; background-color: #e74a3b;"
																			data-toggle="tooltip" data-html="true"
																			title="Ca chiều -- Giờ vào: Null | Giờ ra :Null ">&nbsp;</div> <%
											 	}
											 %> <%
											 	}
											 %> <%
											 	}
											 %> <%
											 	}
											 %>
																	</td>
																	<%
																		}
											
																					}
																	%>
																</tr>
																<%
																	stt++;
																			}
																		}
																%>

				</tbody>
			</table>
		</div>

		<%
			}
		%>

		<%-- Kết thúc bảng 2 của nhân viên  --%>




	<%-- Thông báo xếp loại --%>

		<div class="row justify-content-center">
			<div class="col-md-6 thongbao">
				<div class="card border-left-info shadow h-100 py-2">
					<div class="card-body">
						<div class="row ml-2">
							<%
								// Truy cập giá trị trong request
								int diemtoidaRequest = (int) request.getAttribute("diemtoida");
								float diemhientaiofBan = (float) request.getAttribute("diemhientaiofBan");

								int tylephantram = (int) ((diemhientaiofBan / diemtoidaRequest) * 100);
							%>
							<%
								if (diemtoidaRequest == 100) {
							%>
							<strong>Điểm tối đa của tháng chưa được xác định</strong>
							<%
								} else {
							%>
							<strong>Điểm tối đa của tháng : <span
								class="text-danger"> <%=diemtoidaRequest%></span></strong>
							<%
								}
							%>
						</div>
						<div class="row ml-2">
							<strong>Điểm hiện tại của bạn : <span
								class="text-danger"><%=diemhientaiofBan%></span></strong>
						</div>
						<div class="row ml-2">
							<%
								if (tylephantram >= 85) {
							%>
							<strong>Xếp loại hiện tại của bạn: <span
								class="text-danger">A </span></strong>
							<%
								} else if (tylephantram >= 70 && tylephantram < 85) {
							%>
							<strong>Xếp loại hiện tại của bạn: <span
								class="text-danger">B</span></strong>
							<%
								} else if (tylephantram >= 50 && tylephantram < 70) {
							%>
							<strong>Xếp loại hiện tại của bạn: <span
								class="text-danger">C</span></strong>
							<%
								} else if (tylephantram < 50) {
							%>
							<strong>Xếp loại hiện tại của bạn: <span
								class="text-danger">D</span></strong>
							<%
								}
							%>
						</div>

						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<div class="text-info text-uppercase">
									<i class="fas fa-running fa-2x"></i> <span
										class="font-weight-bold">Cố lên nào !!! </span>

								</div>
								<strong>Hiện tại bạn đang đạt : <span
									class="text-danger"><%=tylephantram%> %</span></strong>
							</div>
							<div class="col-auto chien">
								<i class="fa fa-trophy" aria-hidden="true"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
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

	
	function sendMaZaloAndConfirmCheckin(userId, trangthai) {
	//	console.log("userId ########33333333333 "+ userId);
	//	console.log("trangthai ########33333333333 "+ trangthai);
	    sendMaZalo()
	      .then(function(response) {
	        // Xử lý phản hồi    từ hàm sendMaZalo nếu cần
	        
	        // Gọi hàm confirmCheckin
	      //  confirmCheckin(userId);
	        setTimeout(function() {
	            confirmCheckin(userId,trangthai);
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


<script>
		function changeAttendance1() {
			var button1 = document.getElementById("attendanceButton1");
			var button2 = document.getElementById("attendanceButton2");
			button1.style.display = "none"; // Ẩn nút "Chấm công vào sáng"
			button2.style.display = "block"; // Hiển thị nút "Chấm công ra sáng" với màu nền #e74a3b
			sendMaZaloAndConfirmCheckin(${userId},1);
		}
	
		function changeAttendance2() {
			var button1 = document.getElementById("attendanceButton1");
			var button2 = document.getElementById("attendanceButton2");
			button1.style.display = "none"; // Hiển thị lại nút "Chấm công vào sáng"
			button2.style.display = "none"; // Ẩn nút "Chấm công ra sáng"
			sendMaZaloAndConfirmCheckin(${userId},2);
		}
		
		
		
		
		function changeAttendance3() {
			var button1 = document.getElementById("attendanceButton3");
			var button2 = document.getElementById("attendanceButton4");
			button1.style.display = "none"; // Ẩn nút "Chấm công vào sáng"
			button2.style.display = "block"; // Hiển thị nút "Chấm công ra sáng" với màu nền #e74a3b
			sendMaZaloAndConfirmCheckin(${userId},3);
		}
	
		function changeAttendance4() {
			var button1 = document.getElementById("attendanceButton3");
			var button2 = document.getElementById("attendanceButton4");
	
			button1.style.display = "none"; // Hiển thị lại nút "Chấm công vào sáng"
			button2.style.display = "none"; // Ẩn nút "Chấm công ra sáng"
			
			sendMaZaloAndConfirmCheckin(${userId},4);
			
			
		}
		
		
   </script>