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
<#assign
	time_zone = user.getTimeZoneId()
	is_login_redirect_required = portalUtil.isLoginRedirectRequired(request)
	is_signed_in = theme_display.isSignedIn()
	group_id = theme_display.getScopeGroupId()
/>


	<#if is_signed_in>
				<style>
						@media screen and (max-width: 500px) {
							#sidebar {
								display: none;
							}
				}
			</style>
			<section id="sidebar">
				<@liferay_portlet["runtime"]
					defaultPreferences="<portlet-preferences></portlet-preferences>"
					portletProviderAction=portletProviderAction.VIEW
					portletName="com_liferay_docs_sidebar_portlet_SidebarPortlet"/>
			</section>
	</#if>
 
    



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