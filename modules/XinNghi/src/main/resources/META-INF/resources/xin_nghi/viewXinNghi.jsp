<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<portlet:renderURL var="xinnghiURL">
	<portlet:param name="mvcPath" value="/xin_nghi/viewXinNghiCaNgay.jsp"></portlet:param>
</portlet:renderURL>
<div class="container-fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">Danh sách xin nghỉ</h4>
		</div>
		<div class="card-body">
			<table>
				<thead>
					<tr>
						<th>Tổng số ngày nghỉ phép trong năm</th>
						<th class="text-danger">12</th>
					</tr>
					<tr>
						<th>Số ngày đã nghỉ phép trong năm</th>
						<th class="text-danger">2</th>
					</tr>
				</thead>
			</table>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<div class="mb-3 row">
						<aui:button-row>
							<aui:button iconCssClass="icon-plus"
								onClick="<%=xinnghiURL.toString()%>" value="Xin Nghỉ "></aui:button>
						</aui:button-row>
						<a href="" class="btn btn-info ml-3"><i
							class="far fa-calendar-times"></i> Xin nghỉ nửa ngày</a>
					</div>
					<table class="table table-hover" id="dataTable">
						<thead>
							<tr>
								<th style="width: 5%">STT</th>
								<th style="width: 15%">Họ và tên</th>
								<th style="width: 20%">Thời gian</th>
								<th>Lý do</th>
								<th style="width: 10%">Trạng thái</th>
								<th style="width: 12%">Hành động</th>
							</tr>
						</thead>

						<tbody>
							<%-- 
								<portlet:renderURL var="editURL">
									<portlet:param name="id" value="${user.id }" />
									<portlet:param name="mvcPath" value="/home/viewForm.jsp" />
								</portlet:renderURL>
                                --%>
							<c:forEach var="user" items="${danhsachXinNghi}" varStatus="loop">

								<c:choose>
									<c:when
										test="${user.trangthai == 0 || user.trangthai == 1 || user.trangthai == 2 || user.trangthai == 3 || user.trangthai == 4 || user.trangthai == 5}">
										<tr>
											<th>${loop.index + 1}</th>
											<th>
												<div class="row">
													<span>${user.user_id}</span>
												</div>
											</th>
											<th>
												<div class="row">
													<span>${user.tu_ngay}</span>
													<span>${user.den_ngay}</span>
												</div>
											</th>
										</tr>
									</c:when>
								</c:choose>

							</c:forEach>
							<%-- 
		                        
		                                <tr>
		                                    <td>1</td>
		                                    <td>Vũ Đăng Chiến</td>
		                                    <td>
		                                            <span class="text-info font-weight-bold">Ngày: </span> 09-04-1998 <br>
		                                            <span class="text-warning font-weight-bold">Nghỉ buổi: </span> Buổi chiều <br>
		                                            <span class="text-info font-weight-bold">Từ ngày: </span> 6-8-2023 <br>
		                                            <span class="text-warning font-weight-bold">Đến ngày: </span> 8-8-2023 <br>
		                                    </td>
		                                    <td>
		                                        <span class="font-weight-bold">Nghỉ phép: </span>  Em xin phép nghỉ buổi sáng ngày 14/06/2023. lý do làm việc cá nhân ạ<br>
		                                            <a href="" class="btn btn-link mr-2" target="_blank">
		                                                <span>Xem file xin nghỉ</span>
		                                            </a>
		                                            <a href="#" onclick="" class="btn btn-success">
		                                                <span>Ký số</span>
		                                            </a><br>
		                                                <span class="font-weight-bold"> đã ký: </span>
		                                                <a href="" class="btn btn-link mr-2" target="_blank">
		                                                    <span>Xem file xin nghỉ</span>
		                                                </a>
		                                                <a href="#" onclick="" class="btn btn-success pt-1">
		                                                    <span>Ký số</span>
		                                                </a>
		                                                <br>
		                                    </td>
		                                    <td>
		                                            <span class="btn btn-info">Chờ xác nhận của lãnh đạo phòng</span>
		                                    </td>
		                                    <td>
		                                            <a class="btn btn-success btn-circle mr-1 btn-sm" href="">
		                                               <i class="fa fa-pencil" aria-hidden="true"></i>
		                                            </a>
		
		                                    </td>
		                                </tr>
                                 --%>
						</tbody>
					</table>
					<!-- End tab content -->



				</div>
			</div>
		</div>
	</div>
</div>



