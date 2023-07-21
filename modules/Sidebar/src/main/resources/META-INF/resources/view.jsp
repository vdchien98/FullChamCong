<%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
</style>


<li class="nav-item">
  <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities" onclick="toggleCollapse()"> 
    <i class="fas fa-cogs"></i> <span>Cấu hình hệ thống</span>
  </a>
  <div id="collapseUtilities" class="collapse collapsed-content" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
    <div class="bg-white py-2 collapse-inner rounded">
      <a class="collapse-item item-small" href="">Nhân viên</a> 
      <a class="collapse-item item-small" href="">Phòng ban</a> 
      <a class="collapse-item item-small" href="">Chức vụ</a> 
      <a class="collapse-item item-small" href="">Ca làm việc</a> 
      <a class="collapse-item item-small" href="">Ngày nghỉ lễ</a> 
      <a class="collapse-item item-small" href="">Ngày làm việc</a>
    </div>
  </div>
</li>
<li
	class="nav-item ">
	<a class="nav-link" href=""> 
	<i class="far fa-clock"></i> 
	<span>Bảng giờ làm</span>
</a>
</li>

<li
	class="nav-item">
	<a class="nav-link" href=""> 
	<i class="far fa-calendar-times"></i> 
	<span>Xin nghỉ</span>
</a>
</li>

<li class="nav-item">
	<a class="nav-link" href="">
		<i class="fas fa-calendar-check"></i> 
		<span>Xin chấm công</span> 
    </a>
</li>

<li>
	<a href="/c/portal/logout" class="logout"> 
		<i class='bx bxs-log-out-circle'></i> 
		<span class="text">ĐăngXuất</span>
	</a>
</li>





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