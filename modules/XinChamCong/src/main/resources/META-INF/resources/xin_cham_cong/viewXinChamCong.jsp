<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ include file="../init.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Thư viện Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.nav-link.active {
	color: red !important;
}
div#btn-color-targets {
    display: contents;
}
button.btn.btn-default.tuchoi {
    margin-left: 25px;
}
</style>

<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h4 class="m-0 font-weight-bold text-primary">Danh sách xin chấm
			công</h4>
	</div>
	<div class="card-body">
		<ul class="nav nav-tabs mb-2" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link text-dark active"
				id="profile-tab">Xin chấm công nửa ngày/cả ngày</a></li>
			<li class="nav-item">
			   <a class="nav-link text-dark" id="home-tab">Xin chấm công vào/ra</a></li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="profile">
               <%-- 
				<div class="mt-2 mb-2">
					<a class="btn btn-primary text-white" data-toggle="modal"> <i
						class="fa fa-check-square-o" aria-hidden="true"></i> Nửa ngày
					</a> 
					<a class="btn btn-success text-white" data-toggle="modal"> <i
						class="fa fa-check-square-o" aria-hidden="true"></i> Cả ngày
					</a>
				</div>

                --%>
                <div class="mt-2 mb-2">
				    <a class="btn btn-primary text-white" data-toggle="modal" data-target="#exampleModalCenter1">
				       <i class="fa fa-check-square-o" aria-hidden="true"></i> Nửa ngày
				    </a>
				    <a class="btn btn-success text-white" data-toggle="modal" data-target="#exampleModalCenter2">
				       <i class="fa fa-check-square-o" aria-hidden="true"></i> Cả ngày
				     </a>
				</div>
                
                
                
                

				<div id="dataTable1_wrapper"
					class="dataTables_wrapper dt-bootstrap4 no-footer">
					<div class="row">
						<div class="col-sm-12 col-md-6">
							<div class="dataTables_length" id="dataTable1_length">
								<label>Hiển thị <select name="dataTable1_length"
									aria-controls="dataTable1"
									class="custom-select custom-select-sm form-control form-control-sm"><option
											value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option></select> kết quả
								</label>
							</div>
						</div>
						<div class="col-sm-12 col-md-6">
							<div id="dataTable1_filter" class="dataTables_filter">
								<label>Tìm kiếm:<input type="search"
									class="form-control form-control-sm" placeholder=""
									aria-controls="dataTable1"></label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table class="table table-hover dataTable no-footer"
								id="dataTable1" role="grid" aria-describedby="dataTable1_info">
								<thead>
									<tr role="row">
										<th style="width: 5px;" class="sorting_asc" tabindex="0"
											aria-controls="dataTable1" rowspan="1" colspan="1"
											aria-sort="ascending"
											aria-label="STT: activate to sort column descending">STT</th>
										<th style="width: 15px;" class="sorting" tabindex="0"
											aria-controls="dataTable1" rowspan="1" colspan="1"
											aria-label="Họ và tên: activate to sort column ascending">Họ
											và tên</th>
										<th style="width: 20px;" class="sorting" tabindex="0"
											aria-controls="dataTable1" rowspan="1" colspan="1"
											aria-label="Thời gian: activate to sort column ascending">Thời
											gian</th>
										<th class="sorting" tabindex="0" aria-controls="dataTable1"
											rowspan="1" colspan="1"
											aria-label="Lý do: activate to sort column ascending"
											style="width: 0px;">Lý do</th>
										<th style="width: 10px;" class="sorting" tabindex="0"
											aria-controls="dataTable1" rowspan="1" colspan="1"
											aria-label="Trạng thái: activate to sort column ascending">Trạng
											thái</th>
										<th style="width: 12px;" class="sorting" tabindex="0"
											aria-controls="dataTable1" rowspan="1" colspan="1"
											aria-label="Hành động: activate to sort column ascending">Hành   động</th>
									</tr>
								</thead>
								
								
								<tbody>
								    <c:forEach items="${xinChamCongList}" var="item" varStatus="loop">
								        <tr role="row" class="${loop.index % 2 == 0 ? 'even' : 'odd'}">
								            <td class="sorting_1">${loop.index + 1}</td>
								            <td>
									            <c:forEach var="itemUser" items="${usersList}">
													<c:if test="${itemUser.userId == item.user_id}">
														<span class="text-info font-weight-bold ">
															${itemUser.hovaten}</span>
													</c:if>
												</c:forEach>
								            </td>
								            <td>
								                 <span class="text-info font-weight-bold">Từ Ngày: </span> <fmt:formatDate value="${item.tu_ngay}" pattern="dd-MM-yyyy"/> <br>
								                 <c:choose>
									                <c:when test="${item.trangthai == 0 || item.trangthai == 1 || item.trangthai == 2}">
									                    <span class="text-warning font-weight-bold">Buổi:</span> ${item.nua_ngay == 1 ? 'Chiều' : 'Sáng'}
									                </c:when>
									                <c:when test="${item.trangthai == 3 || item.trangthai == 4 || item.trangthai == 5}">
									                    <span class="text-warning font-weight-bold">Đến Ngày: </span>
									                    <fmt:formatDate value="${item.tu_ngay}" pattern="dd-MM-yyyy"/>
									                </c:when>
									            </c:choose>
								            <td>
								            
								           
								            
								            
								            <span class="font-weight-bold">${item.chon_ly_do}: </span> ${item.ly_do}<br></td>
								            <td>
								                <c:choose>
								                    <c:when test="${item.trangthai == 0}">
								                        <span class="btn btn-info">Chờ xác nhận của lãnh đạo phòng</span>
								                    </c:when>
								                    <c:when test="${item.trangthai == 1}">
								                        <span class="btn btn-danger">Bị từ chối </span>
								                    </c:when>
								                    <c:when test="${item.trangthai == 2}">
								                        <span class="btn btn-success">Đã xác nhận của trưởng phòng</span>
								                    </c:when>
								                    <c:when test="${item.trangthai == 3}">
								                        <span class="btn btn-info">Chờ xác nhận của lãnh đạo đơn vị</span>
								                    </c:when>
								                     <c:when test="${item.trangthai == 4}">
								                        <span class="btn btn-danger">Từ chối</span>
								                    </c:when>
								                     <c:when test="${item.trangthai == 5}">
								                        <span class="btn btn-success">Đã xác nhận của lãnh đạo đơn vị </span>
								                    </c:when>
								                </c:choose>
								            </td>
								            <td> 
								            <c:choose>
								                    <%-- xac nhan cua trưởng phòng  --%>  
								                    <c:when test="${item.trangthai == 0 || item.trangthai == 3}">
													      <div class="container bootstrap snippets bootdey">
														    <div class="btn-demo btn-success" id="btn-color-targets">
														        <a href="#modalColor" data-target-color="blue" data-toggle="modal" class="btn btn-default" 
														           onclick="openModal('confirm', ${item.id});">
														            <i class="fa fa-check" aria-hidden="true"></i>Xác nhận
														        </a>
														        <button type="button" class="btn btn-default tuchoi" data-toggle="modal" 
														                onclick="openModal('reject', ${item.id});">
														            <i class="fa fa-times-circle" aria-hidden="true"></i>Từ chối
														        </button>
														    </div>
														</div>

								                    </c:when>
								                    
								                  
								                   
								                </c:choose>
								            </td>
								        </tr>
								    </c:forEach>
							</tbody>
								
								
								
								
								
								
								
								
								
								
								
								<%-- 
								     
								      	<tbody>
									<tr role="row" class="odd">
										<td class="sorting_1">1</td>
										<td>Vũ Đăng Chiến</td>
										<td><span class="text-info font-weight-bold">Ngày:
										</span> 16-09-2023 <br> <span
											class="text-warning font-weight-bold">Buổi: </span> Chiều</td>
										<td><span class="font-weight-bold">Đi học tập: </span> em
											đi thực tập<br></td>
										<td><span class="btn btn-info">Chờ xác nhận của
												lãnh đạo phòng</span></td>
										<td>
											<button type="button" class="btn btn-success"
												onclick="confirmActive(695);">
												<i class="fa fa-check" aria-hidden="true"></i>Xác nhận
											</button> <a class="btn btn-light mt-1" type="button"
											data-toggle="tooltip" title="Từ chối"
											onclick="confirmTuChoiXinChamCong(695);"> <i class="fa fa-times-circle" aria-hidden="true"></i> Từ chối
										</a>
											<form id="tu-choi-xin-cham-cong-695"
												action=""
												method="POST">
												<input type="hidden" name="_token"
													value="">
											</form>
											<form id="active-695"
												action=""
												method="POST">
												<input type="hidden" name="_token"
													value="4bC32VySEur1scSQtkMMEzhKPAWL3jeOwkwWZaLc"> <input
													type="hidden" name="trangthai" value="1"> <input
													type="hidden" name="id" value="695">
											</form>
										</td>
									</tr>
								</tbody>
						
						
								
								 --%>
							
							</table>
						</div>
					</div>
					
					
					
					<%-- phân trang vs hiển thị trang --%>
					<div class="row">
						<div class="col-sm-12 col-md-5">
							<div class="dataTables_info" id="dataTable1_info" role="status"
								aria-live="polite">Hiển thị 1 đến 10 của 18 kết quả</div>
						</div>
						<div class="col-sm-12 col-md-7">
							<div class="dataTables_paginate paging_simple_numbers"
								id="dataTable1_paginate">
								<ul class="pagination">
									<li class="paginate_button page-item previous disabled"
										id="dataTable1_previous"><a href="#"
										aria-controls="dataTable1" data-dt-idx="0" tabindex="0"
										class="page-link">Quay lại</a></li>
									<li class="paginate_button page-item active"><a href="#"
										aria-controls="dataTable1" data-dt-idx="1" tabindex="0"
										class="page-link">1</a></li>
									<li class="paginate_button page-item "><a href="#"
										aria-controls="dataTable1" data-dt-idx="2" tabindex="0"
										class="page-link">2</a></li>
									<li class="paginate_button page-item next" id="dataTable1_next"><a
										href="#" aria-controls="dataTable1" data-dt-idx="3"
										tabindex="0" class="page-link">Tiếp</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>













			</div>

			<div class="tab-pane fade" id="home" role="tabpanel"
				aria-labelledby="home-tab">
				<div class="mt-2 mb-2">
					<a class="btn btn-info text-white" data-toggle="modal"> <i
						class="fa fa-check-square-o" aria-hidden="true"></i> Xin chấm công
						vào/ra
					</a>
				</div>
			</div>
		</div>
	</div>
</div>








<%-- modal thực hiện chấm công nửa ngày --%>

<!-- Modal for Nửa ngày -->
<div class="modal fade custom-modal" id="exampleModalCenter1" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle1">Xin chấm công</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <portlet:actionURL name="saveChamCongNuaNgay" var="saveXinNghiCaNgayURL" />
                <form id="chamCongForm" method="POST" action="<%=saveXinNghiCaNgayURL.toString()%>" name="<portlet:namespace />fm">
                    <!-- <div class="row"> -->
                        <div class="form-group">
                            <label for="tu_ngay" class="col-form-label text-md-right">Chọn ngày xin chấm công <span class="text-danger">(*)</span></label>
                            <div class="input-group">
                                <input type="date" class="form-control" name="<portlet:namespace />tu_ngay" id="tu_ngay" value="" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nua_ngay" class="col-form-label text-md-right">Chọn buổi <span class="text-danger">(*)</span></label>
                            <select class="form-control" name="<portlet:namespace />nua_ngay" id="nua_ngay" required>
                                <option value="">[-- Chọn buổi --]</option>
                                <option value="1">Buổi sáng</option>
                                <option value="2">Buổi chiều</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="chon_ly_do" class="col-form-label text-md-right">Chọn lý do <span class="text-danger">(*)</span></label>
                            <select class="form-control" name="<portlet:namespace />chon_ly_do" id="chon_ly_do" required>
                                <option value="">[-- Chọn lý do --]</option>
                                <option value="Đi công tác">Đi công tác</option>
                                <option value="Đi học tập">Đi học tập</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="ly_do" class="col-form-label text-md-right">Nội dung <span class="text-danger">(*)</span></label>
                            <div class="input-group">
                                <textarea class="form-control" name="<portlet:namespace />ly_do" id="ly_do" rows="4" required></textarea>
                            </div>
                        </div>
                    <!-- </div> -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-window-close-o" aria-hidden="true"></i> Đóng</button>
                        <button type="submit" class="btn btn-primary" id="save-form"><i class="fa fa-floppy-o" aria-hidden="true" data-dismiss="modal" ></i> Xác nhận</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal for Cả ngày -->
<div class="modal fade custom-modal" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenter2Label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle2">Xin chấm công</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                 <portlet:actionURL name="saveChamCongCaNgay" var="saveXinNghiCaNgayURL" />
                <form id="chamCongForm1" method="POST" action="<%=saveXinNghiCaNgayURL.toString()%>" name="<portlet:namespace />fm">
                        <div class="form-group">
                            <label for="tu_ngay" class="col-form-label text-md-right">Xin chấm công từ ngày <span class="text-danger">(*)</span></label>
                            <div class="input-group">
                                <input type="date" class="form-control" name="<portlet:namespace />tu_ngay" id="tu_ngay" value="" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="den_ngay" class="col-form-label text-md-right">Đến ngày <span class="text-danger">(*)</span></label>
                            <div class="input-group">
                                <input type="date" class="form-control" name="<portlet:namespace />den_ngay" id="den_ngay" value="" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="chon_ly_do" class="col-form-label text-md-right">Chọn lý do <span class="text-danger">(*)</span></label>
                            <select class="form-control" name="<portlet:namespace />chon_ly_do" id="chon_ly_do" required>
                                <option value="">[-- Chọn lý do --]</option>
                                <option value="Đi công tác">Đi công tác</option>
                                <option value="Đi học tập">Đi học tập</option>
                                <option value="Lý do khác">Lý do khác</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="ly_do" class="col-form-label text-md-right">Nội dung <span class="text-danger">(*)</span></label>
                            <div class="input-group">
                                <textarea class="form-control" name="<portlet:namespace />ly_do" id="ly_do" rows="4" required></textarea>
                            </div>
                        </div>
                    <!-- </div> -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-window-close-o" aria-hidden="true"></i> Đóng</button>
                        <button type="submit" class="btn btn-primary" id="save-form"><i class="fa fa-floppy-o" aria-hidden="true" data-dismiss="modal" ></i>  Xác nhận</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>



<%-- Modal chấm công ra/vào 

<div class="modal fade custom-modal" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCenterTitle">Xin chấm công</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="form" method="POST" action="">
                        <div class="form-group">
                            <label for="ngay_lam" class="col-form-label text-md-right">Chọn ngày xin chấm công <span class="text-danger">(*)</span></label>
                            <div class="input-group">
                                <input type="date" class="form-control" name="ngay_lam" id="ngay_lam" value="" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ca_lam" class="col-form-label text-md-right">Chọn ca chấm công <span class="text-danger">(*)</span></label>
                            <select class="form-control" name="ca_lam" id="ca_lam" required>
                                <option value="">[-- Chọn ca chấm công --]</option>
                                <option value="sang">Ca làm sáng</option>
                                <option value="chieu">Ca làm chiều</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="loai_cham_cong" class="col-form-label text-md-right">Chọn loại chấm công <span class="text-danger">(*)</span></label>
                            <select class="form-control" name="loai_cham_cong" id="loai_cham_cong" required>
                                <option value="">[-- Chọn loại chấm công --]</option>
                                <option value="check_in">Chấm công vào</option>
                                <option value="check_out">Chấm công ra</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="ly_do" class="col-form-label text-md-right">Lý do <span class="text-danger">(*)</span></label>
                            <div class="input-group">
                                <textarea class="form-control" name="ly_do" id="ly_do" rows="4" required></textarea>
                            </div>
                        </div>
                    <!-- </div> -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fas fa-window-close"></i> Đóng</button>
                        <button type="submit" class="btn btn-primary" id="save-form"><i class="fas fa-save"></i> Xác nhận</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


--%>





<!-- Modal -->
<div class="modal fade custom-modal" id="modalColor" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Thông Báo</h4>
            </div>
            <div class="modal-body">
                <p id="modal-message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="modal-confirm-button">Đồng Ý</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

 <portlet:actionURL name="updateChamCongCaNgay" var="updateChamCongCaNgayURL" />
 <form id="chamCongForm11" method="POST" action="<%=updateChamCongCaNgayURL.toString()%>" name="<portlet:namespace />fm">
           <input type=hidden class="form-control" name="<portlet:namespace />idxinchamcong" id="idxinchamcong" value="" required>  
            <input type=hidden class="form-control" name="<portlet:namespace />xac_nhan_truongphong" id="xac_nhan_truongphong" value="" required>     
 </form>

<script>
    function openModal(action, itemId) {
        const modal = $('#modalColor');
        const message = $('#modal-message');
        const confirmButton = $('#modal-confirm-button');

        if (action === 'confirm') {
        	
            message.text('Bạn có chắc chắn xác nhận lý do và thời gian này?');
            confirmButton.text('Đồng Ý').addClass('btn-primary').removeClass('btn-danger');
            confirmButton.off('click').on('click', function () {
                // Xử lý xác nhận ở đây (sử dụng itemId nếu cần)
                console.log("itemId la xác nhận  "+ itemId);
                const idxinchamcongInput = $('#idxinchamcong');
                idxinchamcongInput.val(itemId);
                const xac_nhan_truongphong = $('#xac_nhan_truongphong');
                xac_nhan_truongphong.val("xac_nhan");
                // Gửi form
                $('#chamCongForm11').submit();
                
                modal.modal('hide');
            });
        } else if (action === 'reject') {
        	
            message.text('Bạn có chắc chắn từ chối không?');
            confirmButton.text('Từ chối').addClass('btn-danger').removeClass('btn-primary');
            confirmButton.off('click').on('click', function () {
                // Xử lý từ chối ở đây (sử dụng itemId nếu cần)
                const idxinchamcongInput = $('#idxinchamcong');
                idxinchamcongInput.val(itemId); 
                const xac_nhan_truongphong = $('#xac_nhan_truongphong');
                xac_nhan_truongphong.val("tu_choi");
                // Gửi form
                $('#chamCongForm11').submit();
                
                modal.modal('hide');
            });
        }

        modal.modal('show');
    }
</script>

<script>
    $(document).ready(function() {
    	 const modal = $('#exampleModalCenter1');
        // Toggle modal display when clicking the buttons
        $('.btn[data-toggle="modal"]').click(function() {
            var targetModal = $(this).data('target');
            $('.custom-modal').not(targetModal).hide(); // Hide other modals
            $(targetModal).modal('toggle'); // Toggle the target modal
        });

        // Event listener for modal close buttons
        $('.modal').on('hidden.bs.modal', function (event) {
            // This event is triggered when the modal is fully closed
            // You can add any post-modal-close logic here
        });
        
        
        $('#chamCongForm, #chamCongForm1').submit(function(event) {
            event.preventDefault(); // Prevent the default form submission
            var form = $(this);
            $.ajax({
                type: form.attr('method'),
                url: form.attr('action'),
                data: form.serialize(),
                success: function(response) {
                    location.reload(); // Reload the page on successful submission
                }
            });
        });
    });

</script>







<%-- 
<script>
document.addEventListener("DOMContentLoaded", function() {
    const nuaNgayButton = document.querySelector(".btn-primary[data-toggle='modal']");
    const modal = document.getElementById("exampleModalCenter1");
    const chamCongForm = document.getElementById("chamCongForm");

    nuaNgayButton.addEventListener("click", function() {
        $(modal).modal("show");
    });

    chamCongForm.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent the default form submission
        const formData = new FormData(chamCongForm);

        $.ajax({
            type: "POST",
            url: chamCongForm.getAttribute("action"),
            data: formData,
            success: function(response) {
                // Handle the success response here
                console.log("Form submitted successfully!", response);
                chamCongForm.reset(); // Reset the form fields
            },
            error: function(error) {
                // Handle the error response here
                console.error("Form submission failed!", error);
            },
            processData: false, // Prevent jQuery from automatically processing data
            contentType: false, // Prevent jQuery from automatically setting content type
        });
    });
});
</script>


<script>
document.addEventListener("DOMContentLoaded", function() {
  const caNgayButton = document.querySelector(".btn-success[data-toggle='modal']");
  const modal = document.getElementById("exampleModalCenter2");
  const chamCongForm1 = document.getElementById("chamCongForm1");
  caNgayButton.addEventListener("click", function() {
    $(modal).modal("show"); // Sử dụng Bootstrap's modal('show') để hiển thị modal
  });
  chamCongForm1.addEventListener("submit", function(event) {
      event.preventDefault(); // Prevent the default form submission
      const formData = new FormData(chamCongForm1);

      $.ajax({
          type: "POST",
          url: chamCongForm1.getAttribute("action"),
          data: formData,
          success: function(response) {
              // Handle the success response here
              console.log("Form submitted successfully!", response);
              chamCongForm1.reset(); // Reset the form fields
          },
          error: function(error) {
              // Handle the error response here
              console.error("Form submission failed!", error);
          },
          processData: false, // Prevent jQuery from automatically processing data
          contentType: false, // Prevent jQuery from automatically setting content type
      });
  });
  
  
  
});
</script>

 --%>








<%--  
  ko dùng nữa 
<script>
document.addEventListener("DOMContentLoaded", function() {
  const nuaNgayButton = document.querySelector(".btn-primary[data-toggle='modal']");
  const modal = document.getElementById("exampleModalCenter1");

  nuaNgayButton.addEventListener("click", function() {
    $(modal).modal("show"); // Sử dụng Bootstrap's modal('show') để hiển thị modal
  });
 
});
</script>

--%>









<script>
	document.addEventListener("DOMContentLoaded", function() {
		const profileTab = document.getElementById("profile-tab");
		const homeTab = document.getElementById("home-tab");
		const profileContent = document.getElementById("profile");
		const homeContent = document.getElementById("home");

		profileTab.addEventListener("click", function() {
			profileContent.classList.add("show", "active");
			homeContent.classList.remove("show", "active");

			profileTab.classList.add("active");
			homeTab.classList.remove("active");
		});

		homeTab.addEventListener("click", function() {
			homeContent.classList.add("show", "active");
			profileContent.classList.remove("show", "active");

			homeTab.classList.add("active");
			profileTab.classList.remove("active");
		});
	});
</script>