<%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<style>

.collapsed-content {
	display: none;
}

.bg-white.py-2.collapse-inner.rounded {
	display: flex;
	flex-direction: column;
	margin-left: 30px;
}

a.collapse-item.item-small {
	padding: 3px 14px;
}

.nav-link:hover {
	background-color: #237ed9;
	color: white;
	border-radius: 10px;
}

.collapse-item.item-small:hover {
	background-color: #237ed9;
	color: white;
	border-radius: 9px;
}

.collapse-item.item-small {
	text-decoration: none;
}

a.collapse-item.item-small {
	border-radius: 9px;
}

li.chien_logout {
	margin-left: 15px;
}
p.thongtinnhanvien.chucnangsiderbar {
    margin-left: 15px;
    margin-bottom: -4px;
}


.chucnanghethongsiderbar {
    margin-left: 15px;
}
div#collapseUtilities {
    margin-top: -10px;
}

</style>
<style>
.infonhanvien {
    display: flex;
    flex-direction: column;
    align-items: baseline;
}
p.thongtinnhanvien {
    font-size: 22px;
    font-family: sans-serif;
    color: #0d7874;
    font-weight: bold;
}

span.styleChucVu {
    font-size: 17px;
    color: #227285;
   
    border-radius: 20px;
    padding: 5px 20px;
    margin-top: -20px;
    width: 215px;
}

span.styletenPhong {
    font-size: 17px;
    color: #227285;
    
    border-radius: 20px;
    padding: 5px 20px;
    margin-top: 0px;
    width: 215px;
}

span.styleHoVaTen {
    font-size: 17px;
    color: #227285;
    
    border-radius: 20px;
    padding: 5px 20px;
    margin-top: 0px;
    width: 215px;
}


i.iconsiderbar {
    margin-right: 10px;
}

li.chien_logout {
    margin-left: 15px;
    margin-top: 10px;
    font-size: 20px;
    font-family: sans-serif;
    font-weight: bold;
    text-decoration: none;
    
}
span.textchienlogoy {
    color: #227285;
}
i.fa.fa-sign-out.iconchiendangxuat  {
    color: #227285;
}
</style>


<div>
    <p class="thongtinnhanvien chucnangsiderbar">Chức Năng</p>
    <div class="chucnanghethongsiderbar">
    
       <% 
       
       
       long roleadmin = (long) request.getAttribute("roleadmin");
       
       
       %>
       <% if(roleadmin == 20103) { %>
		    <li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"
				onclick="toggleCollapse()"> <i class="fa fa-cogs"
					aria-hidden="true"></i> <span class="cauhinhhethong">Cấu hình hệ thống</span>
			</a>
				<div id="collapseUtilities" class="collapse collapsed-content"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item item-small" href="/home">Nhân viên</a> <a
							class="collapse-item item-small" href="/phong-ban">Phòng ban</a> <a
							class="collapse-item item-small" href="/chuc-vu">Chức vụ</a> <a
							class="collapse-item item-small" href="/ca-lam-viec">Ca làm việc</a>
						<a class="collapse-item item-small" href="/ngay-nghi-le">Ngày nghỉ lễ</a> 
						<a class="collapse-item item-small" href="/ngay-lam-viec">Ngày làm việc</a>
					</div>
				</div>
			</li>
		<% } %>
		
		
		
		<li class="nav-item "><a class="nav-link" href="/nhanvien/gio-lam"> <i class="fa fa-clock-o" aria-hidden="true"></i> <span>Bảng giờlàm</span></a></li>
		
		<li class="nav-item"><a class="nav-link" href="/nhanvien/xin-nghi"> <i class="fa fa-calendar-times-o" aria-hidden="true"></i> <span>Xin nghỉ</span></a></li>
		
		<li class="nav-item"><a class="nav-link" href="/nhanvien/xin-cham-cong"> <i class="fa fa-calendar-check-o" aria-hidden="true"></i> <span>Xin chấm công</span></a></li>

    
    
    </div>
	
</div>

<div class="infonhanvien">
	<p class="thongtinnhanvien">Thông Tin</p>
	<c:forEach var="itemChucVu" items="${selectChucVuSiderBar}">
		<c:if test="${itemChucVu.id == userInforSiderBar.chucvu_id}">
			<span class="styleChucVu"><i class="fa fa-star-o iconsiderbar" aria-hidden="true"></i>${itemChucVu.name}</span>
		</c:if>
	</c:forEach>
	<c:forEach var="itemPhongBan" items="${selectPhongBanSiderBar}">
		<c:if test="${itemPhongBan.id == userInforSiderBar.phongban_id}">
			<span class="styletenPhong"><i class="fa fa-building-o iconsiderbar" aria-hidden="true"></i>${itemPhongBan.tenphong}</span>
		</c:if>
	</c:forEach>
	<span class="styleHoVaTen"><i class="fa fa-user-o iconsiderbar" aria-hidden="true"></i>${userInforSiderBar.hovaten}</span>
</div>
<li class="chien_logout"><a href="/c/portal/logout" class="logout">
		<i class="fa fa-sign-out iconchiendangxuat" aria-hidden="true"></i> <span class="textchienlogoy">ĐăngXuất</span>
</a></li>





<script>
	// JavaScript
	function toggleCollapse() {
		var collapseContent = document.getElementById("collapseUtilities");
		if (collapseContent.classList.contains("collapsed-content")) {
			// Nếu chưa mở, thêm lớp "show" và xóa lớp "collapsed-content" để hiển thị nội dung
			collapseContent.classList.remove("collapsed-content");
			collapseContent.classList.add("show");
		} else {
			// Nếu đã mở, thêm lớp "collapsed-content" và xóa lớp "show" để ẩn nội dung
			collapseContent.classList.remove("show");
			collapseContent.classList.add("collapsed-content");
		}
	}
</script>