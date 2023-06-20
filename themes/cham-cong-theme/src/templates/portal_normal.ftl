<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	<@liferay.css file_name="${css_folder}/styles.css" />
	<@liferay.css file_name="${css_folder}/app.css" />
	<@liferay.css file_name="${css_folder}/base.css" />
	<@liferay.css file_name="${css_folder}/sb-admin-2.min.css" />
	<@liferay.css file_name="${css_folder}/style.css" />
	<@liferay.css file_name="${css_folder}/bootstrap-datepicker.css" />
	<@liferay.css file_name="${css_folder}/bootstrap-datetimepicker.css" />
	<@liferay.css file_name="${css_folder}/bootstrap-datetimepicker.min.css" />
	
	
	
	<@liferay.js file_name="${javascript_folder}/jquery.js" />
	<@liferay.js file_name="${javascript_folder}/style.js" />
	<@liferay.js file_name="${javascript_folder}/bootstrap-datepicker.js" />
	<@liferay.js file_name="${javascript_folder}/bootstrap-datetimepicker.js" />
	<@liferay.js file_name="${javascript_folder}/bootstrap-datetimepicker.min.js" />

	
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid position-relative" id="wrapper">
<#-- Đây là một comment trong FTL 
	<header id="banner" role="banner">
		<div id="heading">
			<div aria-level="1" class="site-title" role="heading">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</div>
		</div>

		<#if !is_signed_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>

		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>
	
-->
<section id="sidebar">
		<a href="#" class="brand">
			<span class="text">Chấm Công</span>
		</a>
		<ul class="side-menu top">
			<li class="active">
				<a href="/home">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Home</span>
				</a>
			</li>
			<li class="active">
				<a href="/login">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Login</span>
				</a>
			</li>
				<li class="active">
				<a href="/phong-ban">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Phòng Ban</span>
				</a>
			</li>
				<li class="active">
				<a href="/chuc-vu">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Chức Vụ</span>
				</a>
			</li>
			</li>
				<li class="active">
				<a href="/ca-lam-viec">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Ca Làm Việc</span>
				</a>
			</li>
			</li>
				<li class="active">
				<a href="/ngay-nghi-le">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Ngày Nghỉ Lễ</span>
				</a>
			</li>
			</li>
				<li class="active">
				<a href="/nhanvien/gio-lam">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Giờ Làm Nhân Viên</span>
				</a>
			</li>
			
			
			
			
			<li>
				<a href="#">
					<i class='bx bxs-shopping-bag-alt' ></i>
					<span class="text"></span>
				</a>
			</li>
		</ul>
		<ul class="side-menu">
			<li>
				<a href="#">
					<i class='bx bxs-cog' ></i>
					<span class="text">Settings</span>
				</a>
			</li>
			<li>
				<a href="#" class="logout">
					<i class='bx bxs-log-out-circle' ></i>
					<span class="text">Logout</span>
				</a>
			</li>
		</ul>
	</section>
	<#-- 
	
		<section id="content">
		<main>
			<div class="head-title">
				<div class="left">
					<h1>Dashboard</h1>
					<ul class="breadcrumb">
						<li><i class='bx bx-chevron-right' ></i></li>
						<li>
							<a class="active" href="#">Home</a>
						</li>
						<li>
							<a class="active" href="#"></a>
						</li>
					</ul>
				</div>
			</div>
		</main>
		
	</section>
	 -->
	<section id="content">
		<h2 class="hide-accessible sr-only" role="heading" aria-level="1">${htmlUtil.escape(the_title)}</h2>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language_format
				arguments='<a href="http://www.liferay.com" rel="external">Liferay</a>'
				key="powered-by-x"
			/>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>