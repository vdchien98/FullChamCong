<%@page import="javax.portlet.PortletSession"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
<%@ include file="../init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<style type="text/css">
a.btn.btn-link.mr-2.fileUrl {
	margin-top: -30px;
}

button.nutkyso {
	margin-top: -30px;
}
</style>
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
											<th>${loop.index + 1}${user.id}${user.user_id}</th>
											<th>
												<div class="row">
													<c:forEach var="hovatennhanvien"
														items="${hovatennhanviens}">
														<c:if test="${user.user_id == hovatennhanvien.userId }">
															<span class="text-warning mr-3 fileUrl">
																${hovatennhanvien.hovaten}</span>
														</c:if>
													</c:forEach>
												</div>
											</th>
											<th>
												<div class="row">
													<span class="text-info font-weight-bold">Từ Ngày: <fmt:formatDate
															value="${user.tu_ngay}" pattern="dd/MM/yyyy" /></span> <span
														class="text-warning font-weight-bold">Đến Ngày: <fmt:formatDate
															value="${user.den_ngay}" pattern="dd/MM/yyyy" />
													</span>
												</div>
											</th>
											<th>
												<div class="row">
													<span>Lý do : ${user.ly_do}</span> <br> <br />
													<%-- <portlet:actionURL var="OpenFilePDFURL" name="OpenFilePDF" /> action="<%=OpenFilePDFURL%>"--%>

													<form id="check_pdf" class="float-right" method="get">
														<input type="hidden" name="p_p_id"
															value="<%=themeDisplay.getPortletDisplay().getId()%>" />
														<input type="hidden" name="p_p_auth"
															value="<%=AuthTokenUtil.getToken(request, themeDisplay.getPlid(), themeDisplay.getPpid())%>" />
														<input type="hidden"
															name="<portlet:namespace />popupCapchaValue"
															id="popupCapchaValueURL" value="">
													</form>
													<%-- 	<a
														href="<portlet:renderURL><portlet:param name='file_url' value='${user.file_url}' /></portlet:renderURL>"
														class="btn btn-link mr-2 fileUrl" target="_blank"> <span>Xem
															file xin nghỉ : ${user.file_url}</span>
													</a>
													
													<a href="#" class="btn btn-link mr-2 fileUrl"
														target="_blank" onclick="loadPdf('${user.file_url}')">
														<span>Xem file xin nghỉ : ${user.file_url}</span>
													</a> --%>
													<a href="javascript:void(0);"
														class="btn btn-link mr-2 fileUrl"
														onclick="loadPdf('${user.file_url}')"> <span>Xem
															file xin nghỉ : ${user.file_url}</span>
													</a>
													<button class="nutkyso">Ký Số</button>
												</div>
											</th>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>

						</tbody>
					</table>
					<!-- End tab content -->



				</div>
			</div>
		</div>
	</div>
</div>


<script>
    function loadPdf(fileUrl) {
        var pdfUrl = '/nhanvien/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_sbwb&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_sbwb_file_url=' + fileUrl;
        window.open(pdfUrl);
    }
</script>

<%-- 
<script>
    function loadPdf(fileUrl) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/nhanvien/xin-nghi?p_p_id=com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_sbwb&p_p_lifecycle=2&p_p_resource_id=serveResource&p_p_cacheability=cacheLevelPage&_com_liferay_docs_xinnghi_portlet_XinNghiPortlet_INSTANCE_sbwb_file_url=' + fileUrl, true);
        xhr.responseType = 'blob';

        xhr.onload = function() {
            if (xhr.status === 200) {
                var blob = xhr.response;
                var url = window.URL.createObjectURL(blob);

                var a = document.createElement('a');
                a.style.display = 'none';
                a.href = url;
                a.download = fileUrl;

                document.body.appendChild(a);
                a.click();
                window.URL.revokeObjectURL(url);
            } else {
                // Xử lý lỗi khi tệp PDF không tồn tại
                alert("Tệp PDF không tồn tại");
            }
        };

        xhr.send();
    }
</script>

 --%>