
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ include file="../init.jsp"%>
<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<%-- 

<portlet:actionURL name="/login/login" var="loginURL">
	<portlet:param name="mvcRenderCommandName" value="/login/login" />
</portlet:actionURL>

 --%>
<style>
.container {
	height: 100%;
	align-content: center;
	margin-top: 50px;
}

.card {
	height: 370px;
	margin-top: auto;
	margin-bottom: auto;
	width: 400px;
	background-color: rgba(0, 0, 0, 0.5) !important;
}

.social_icon span {
	font-size: 60px;
	margin-left: 10px;
	color: #FFC312;
}

.social_icon span:hover {
	color: white;
	cursor: pointer;
}

.card-header h3 {
	color: white;
}

.social_icon {
	position: absolute;
	right: 20px;
	top: -45px;
}

.input-group-prepend span {
	width: 50px;
	background-color: #FFC312;
	color: black;
	border: 0 !important;
}

input:focus {
	outline: 0 0 0 0 !important;
	box-shadow: 0 0 0 0 !important;
}

.remember {
	color: white;
}

.remember input {
	width: 20px;
	height: 20px;
	margin-left: 15px;
	margin-right: 5px;
}

.login_btn {
	color: black;
	background-color: #FFC312;
	width: 100px;
}

.login_btn:hover {
	color: black;
	background-color: white;
}

.links {
	color: white;
}

.links a {
	margin-left: 4px;
}
</style>


<%-- 


<div class="container ">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Sign In</h3>
			</div>
			<div class="card-body">
				<form id="fm1" name="myForm" class="form-horizontal formlogin"
					action="<%=loginURL%>" onSubmit="onsubmit();" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-user"
								aria-hidden="true"></i></span>
						</div>
						<input id="<portlet:namespace/>user"
							name="<portlet:namespace/>login" class="form-control"
							required="required" tabindex="1" accesskey="n" type="text"
							size="55" autocomplete="false">

					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input id="<portlet:namespace/>password"
							name="<portlet:namespace/>password" class="form-control"
							required="required" tabindex="2" accesskey="p" type="password"
							size="25">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox" id="<portlet:namespace/>remember" name="">
						<label for="remember">Remember Me </label>

					</div>
					<div class="form-group">
						<button type="button" class="btn float-right login_btn"
							onclick="document.myForm.submit()" href="javascript:void(0)">Login
						</button>
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="#">Sign Up</a>
				</div>


			</div>
		</div>
	</div>
</div>




 --%>
<%-- 
   <div class="d-flex justify-content-center">
					<liferay-ui:error key="error_user"
						message="Tài khoản chưa được khởi tạo trên hệ thống dùng chung của tỉnh. <br/>Vui lòng liên hệ cán bộ CNTT để được hỗ trợ." />
					<liferay-ui:error key="error_pass"
						message="Tên đăng nhập hoặc mật khẩu không chính xác." />
				</div>
				
				<p>
    <b><liferay-ui:message key="myloginportlet_MyLogin.caption"/></b>
</p>
--%>


<c:choose>
	<c:when test="<%=themeDisplay.isSignedIn()%>">

		<%
			String signedInAs = HtmlUtil.escape(user.getFullName());

					if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
						String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

						signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">"
								+ signedInAs + "</a>";
					}
		%>

		<liferay-ui:message arguments="<%=signedInAs%>"
			key="you-are-signed-in-as-x" translateArguments="<%=false%>" />
	</c:when>
	<c:otherwise>

		<%
			String redirect = ParamUtil.getString(request, "redirect");
		%>

		<portlet:actionURL name="/login/login" var="loginURL">
			<portlet:param name="mvcRenderCommandName" value="/login/login" />
		</portlet:actionURL>

		<aui:form action="<%=loginURL%>" autocomplete='on'
			cssClass="sign-in-form" method="post" name="loginForm">

			<aui:input name="saveLastPath" type="hidden" value="<%=false%>" />
			<aui:input name="redirect" type="hidden" value="<%=redirect%>" />

			<aui:input autoFocus="true" cssClass="clearable"
				label="email-address" name="login" showRequiredLabel="<%=false%>"
				type="text" value="">
				<aui:validator name="required" />
			</aui:input>

			<aui:input name="password" showRequiredLabel="<%=false%>"
				type="password">
				<aui:validator name="required" />
			</aui:input>

			<aui:button-row>
				<aui:button cssClass="btn-lg" type="submit" value="sign-in" />
			</aui:button-row>

		</aui:form>
	</c:otherwise>
</c:choose>





